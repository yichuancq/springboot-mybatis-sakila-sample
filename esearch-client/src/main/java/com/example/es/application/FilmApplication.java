//package com.example.es.application;
//
//import com.example.es.domain.FilmList;
//import com.example.es.service.FilmService;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//import org.springframework.data.elasticsearch.core.SearchHit;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.data.elasticsearch.core.query.Query;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @author yichuan
// */
//@Service
//public class FilmApplication {
//
//    @Autowired
//    private FilmService filmService;
//
//    @Autowired
//    private ElasticsearchRestTemplate elasticsearchRestTemplate;
//
//
//    /**
//     * @param keyword
//     * @param curPage
//     * @param pageSize
//     * @return
//     */
//    public List<FilmList> searchMulWithHighLight(String keyword, int curPage, int pageSize) {
//
//        // 高亮设置
//        String preTags = "<span style=\"color:#F56C6C\">";
//        String postTags = "</span>";
//        // 查询条件
//        Query query = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.boolQuery()
//                        // must就相当于我们mysql的and
//                        .must(QueryBuilders.multiMatchQuery(keyword, "description")))
//                // 在title和description里面查找关键词
//                .withHighlightBuilder(new HighlightBuilder().field("description")
//                        .preTags(preTags).postTags(postTags))
//                .withPageable(PageRequest.of(curPage - 1, pageSize))
//                // 设置分页参数，默认从0开始
//                .build();
//
//        // 执行搜索，获取结果
//        SearchHits<FilmList> contents = elasticsearchRestTemplate.search(query, FilmList.class);
//        List<SearchHit<FilmList>> articles = contents.getSearchHits();
//        // 如果list的长度为0，直接return
//        if (articles.size() == 0) {
//            return new ArrayList<>();
//        }
//        List<FilmList> result = articles.stream().map(filmListSearchHit -> {
//            // 获取高亮数据
//            Map<String, List<String>> highlightFields = filmListSearchHit.getHighlightFields();
//            //如果集合不为空说明包含高亮字段，则添加。
//            if (!CollectionUtils.isEmpty(highlightFields.get("description"))) {
//                filmListSearchHit.getContent().setDescription(highlightFields.get("description").get(0));
//                System.out.println("description:" + highlightFields.get("description").size());
//            }
//            FilmList resultVale = new FilmList();
//            return resultVale;
//        }).collect(Collectors.toList());
//        return result;
//    }
//}
