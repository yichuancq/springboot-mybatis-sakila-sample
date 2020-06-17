package com.example.es.service;

import org.springframework.data.elasticsearch.core.SearchHits;

/**
 * @author yichuan
 */
public interface FilmService {

    SearchHits  queryPageFilmList();

}
