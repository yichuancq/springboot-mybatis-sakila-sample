package com.example.es.service;

import com.example.es.domain.FilmList;
import com.example.es.repository.FilmListRepository;
import com.example.es.repository.FilmRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FilmServiceImpl implements FilmService {

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

}
