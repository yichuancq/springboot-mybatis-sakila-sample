package com.example.es.service;

import com.example.es.domain.FilmList;
import com.example.es.repository.FilmListRepository;
import com.example.es.repository.FilmRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FilmServiceImpl implements FilmService {

    @Autowired
    private ReactiveElasticsearchOperations elasticsearchOperations;
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmListRepository filmListRepository;

    /**
     * @param keyword
     * @return
     */

    @Override
    public Flux<FilmList> findAllByDescriptionLike(String keyword) {
        return filmRepository.findAllByDescriptionLike(keyword);
    }

    @Override
    public Page<FilmList> search(QueryBuilder searchQuery, Pageable pageable) {
        return filmListRepository.search(searchQuery, pageable);
    }

    @Override
    public Page<FilmList> searchSimilar(FilmList filmList, String[] fields, Pageable pageable) {
        return filmListRepository.searchSimilar(filmList, fields, pageable);
    }

    @Override
    public List<FilmList> searchMulWithHighLight(String queryWord, int page, int pageSize) {
        List<FilmList> filmListList = new ArrayList<>();
        final String stringIndex = "nicer_but_slower_film_list";
        // 查询的关键字
        //String queryWord = "Girl";
        // 查询的字段
        String field = "description";

        // 高亮设置
        String preTags = "<span style=\"color:#F56C6C\">";
        String postTags = "</span>";
        IndexCoordinates index = IndexCoordinates.of(stringIndex);
        //创建builder
        NativeSearchQuery searchQuery =
                new NativeSearchQueryBuilder()
                        .withQuery(QueryBuilders.matchQuery(field, queryWord))
                        .withHighlightBuilder(new HighlightBuilder().field(field).preTags(preTags).postTags(postTags))
                        .withPageable(PageRequest.of(page, pageSize))
                        .build();
        Flux<SearchHit<FilmList>> searchHitFlux = elasticsearchOperations.search(searchQuery, FilmList.class, index);

        Iterator<SearchHit<FilmList>> filmListIterator = searchHitFlux.toIterable().iterator();
        while (filmListIterator.hasNext()) {
            SearchHit<FilmList> searchHit = filmListIterator.next();
            FilmList filmList = searchHit.getContent();

            Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
            highlightFields.keySet().forEach(key -> filmList.setDescription(String.valueOf(highlightFields.get(key).get(0))));
            filmListList.add(filmList);
            log.info("filmList:{}", filmList);
        }
        return filmListList;
    }

}
