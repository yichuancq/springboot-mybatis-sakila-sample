package com.example.es.service;

import com.example.es.domain.FilmList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{
    @Override
    public List<FilmList> selectByPage(FilmList filmList) {
        return null;
    }
}
