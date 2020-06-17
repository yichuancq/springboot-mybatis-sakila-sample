package com.example.es.repository;

import com.example.es.domain.FilmList;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yichuan
 */
@Repository
public interface FilmListRepository extends ElasticsearchRepository<FilmList, String> {

    /**
     * @param actory
     * @return
     */
    List<FilmList> findFilmListsByActors(String actory);

    /**
     * @param desc
     * @return
     */
    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"description\" : \"?0\"}}}}")
    List<FilmList> findByDescriptionLike(String desc);

}
