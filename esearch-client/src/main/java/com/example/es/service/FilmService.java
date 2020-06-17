package com.example.es.service;

import com.example.es.domain.FilmList;
import org.springframework.data.elasticsearch.core.SearchHits;
import reactor.core.publisher.Flux;

/**
 * @author yichuan
 */
public interface FilmService {

    SearchHits  queryPageFilmList();

    Flux<FilmList> findAllByDescriptionLike(String keyword);



}
