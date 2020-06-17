package com.example.es.service;

import com.example.es.domain.FilmList;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

/**
 * @author yichuan
 */
public interface FilmService {
    Flux<FilmList> findAllByDescriptionLike(String keyword);

    /**
     * @param searchQuery
     * @param pageable
     * @return
     */
    Page<FilmList> search(QueryBuilder searchQuery, Pageable pageable);

    /**
     * @param filmList
     * @param fields
     * @param pageable
     * @return
     */
    Page<FilmList> searchSimilar(FilmList filmList, String[] fields, Pageable pageable);
}
