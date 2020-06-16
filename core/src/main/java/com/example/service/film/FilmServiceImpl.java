package com.example.service.film;

import com.example.dao.FilmListMapper;
import com.example.domain.FilmList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yichuan
 */
@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmListMapper filmListMapper;

    @Override
    public List<FilmList> selectAll() {
        return filmListMapper.selectAll();
    }
    /**
     * 条件查询
     *
     * @param filmList
     * @return
     */
    @Override
    public List<FilmList> selectByPage(FilmList filmList) {
        return filmListMapper.selectByCondition(filmList);
    }

    /**
     * 总页码
     *
     * @param filmList
     * @return
     */
    @Override
    public Integer totalPage(FilmList filmList) {
        return filmListMapper.totalPage(filmList);
    }
}
