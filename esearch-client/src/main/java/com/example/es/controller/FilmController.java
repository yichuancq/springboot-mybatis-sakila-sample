package com.example.es.controller;

import com.example.es.application.FilmApplication;
import com.example.es.domain.FilmList;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yichuan
 */
@Slf4j
@RestController
public class FilmController {


    @Autowired
    private FilmApplication filmApplication;

    /**
     * 查询影片
     *
     * @param filmList
     * @return
     */
    @ApiOperation(value = "/film/queryFilmList", notes = "es查询影片列表")
    @RequestMapping(value = "/film/queryFilmList", method = RequestMethod.POST)
    public ResponseEntity queryAllFimList(@RequestBody FilmList filmList) {
        log.info("params:{}", filmList.toString());
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "/film/searchMulWithHighLight", notes = "es HighLight查询影片列表")
    @RequestMapping(value = "/film/searchMulWithHighLight", method = RequestMethod.POST)
    public ResponseEntity searchMulWithHighLight(String keyWords) {
        log.info("keyWords:{}", keyWords);
        return ResponseEntity.ok(filmApplication.searchMulWithHighLight(keyWords, 1, 10));
    }

}
