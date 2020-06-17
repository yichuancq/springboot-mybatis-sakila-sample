package com.example.es.repository;

import com.example.es.domain.FilmList;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface FilmRepository extends ReactiveCrudRepository<FilmList, String> {

    Flux<FilmList> findAllByDescriptionLike(String keyword);

}
