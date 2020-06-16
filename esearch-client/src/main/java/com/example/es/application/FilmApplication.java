package com.example.es.application;

import com.example.es.domain.FilmList;
import com.example.es.service.FilmService;
import com.example.es.vo.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yichuan
 */
@Service
public class FilmApplication {

    @Autowired
    private FilmService filmService;
    /**
     * @return
     */
    public ResultDTO<FilmList> queryByPageFilmList(FilmList filmList) {
        List<FilmList> filmLists = filmService.selectByPage(filmList);
        return new ResultDTO(200, "ok", filmLists);

    }
}
