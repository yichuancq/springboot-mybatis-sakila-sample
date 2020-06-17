package com.example.es.controller;

import com.example.es.domain.FilmList;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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

}
