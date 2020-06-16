package com.example.application;

import com.example.domain.FilmList;
import com.example.service.film.FilmService;
import com.example.vo.PageRequest;
import com.example.vo.ResultDTO;
import com.github.pagehelper.PageHelper;
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

    public List<FilmList> queryAllFilmList(FilmList filmList) {
        return filmService.selectAll();
    }

    /**
     * @param filmList
     * @param pageRequest
     * @return
     */
    public ResultDTO<FilmList> queryByPageFilmList(FilmList filmList, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNumber(), pageRequest.getPageSize());
        List<FilmList> filmLists = filmService.selectByPage(filmList);
        Integer totalPage = filmService.totalPage(filmList);
        return new ResultDTO(200, "ok", totalPage, filmLists);

    }
}
