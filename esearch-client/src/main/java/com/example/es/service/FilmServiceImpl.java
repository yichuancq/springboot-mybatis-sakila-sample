package com.example.es.service;

import com.example.es.domain.FilmList;
import com.example.es.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FilmServiceImpl implements FilmService {


    @Autowired
    private FilmRepository filmRepository;


    @Override
    public SearchHits queryPageFilmList() {
//        //创建builder
//        BoolQueryBuilder builder = QueryBuilders.boolQuery();
//        //builder下有must、should以及mustNot 相当于sql中的and、or以及not
//        //设置模糊搜索,真实姓名中包含金的用户
//        builder.must(QueryBuilders.fuzzyQuery("description", "Tom"));
//        //设置用户名为king
//        //builder.must(new QueryStringQueryBuilder("king").field("username"));
//        //排序
//        //FieldSortBuilder sort = SortBuilders.fieldSort("age").order(SortOrder.DESC);
//
//        //设置分页
//        //====注意!es的分页和Hibernate一样api是从第0页开始的=========
//        PageRequest page =  PageRequest.of(0, 2);
//
//        //构建查询
//        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
//        //将搜索条件设置到构建中
//        nativeSearchQueryBuilder.withQuery(builder);
//        //将分页设置到构建中
//        nativeSearchQueryBuilder.withPageable(page);
//        //将排序设置到构建中
//        //nativeSearchQueryBuilder.withSort(sort);
//        //生产NativeSearchQuery
//        NativeSearchQuery query = nativeSearchQueryBuilder.build();
//
//        //执行,返回包装结果的分页
//        SearchHits searchHits = elasticsearchRestTemplate.search(query,FilmList.class);
//
//        return searchHits;
        return null;
    }

    @Override
    public Flux<FilmList> findAllByDescriptionLike(String keyword) {
        return filmRepository.findAllByDescriptionLike(keyword);
    }
}
