package com.example.es.application;

import com.example.es.domain.FilmList;
import com.example.es.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yichuan
 */
@Service
@Slf4j
public class FilmApplication {

    @Autowired
    private FilmService filmService;


    /**
     * @param keyword
     * @param page
     * @param pageSize
     * @return
     */
    public List<FilmList> searchMulWithHighLight(String keyword, int page, int pageSize) {
        return filmService.searchMulWithHighLight(keyword, page, pageSize);
    }
}
