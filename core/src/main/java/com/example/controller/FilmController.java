package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.application.FilmApplication;
import com.example.domain.FilmList;
import com.example.vo.PageRequest;
import com.example.vo.ResultDTO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 查询所有影片列表
     *
     * @param filmList
     * @return
     */
    @ApiOperation(value = "/film/queryAllFilmList", notes = "查询所有影片列表")
    @RequestMapping(value = "/film/queryAllFilmList", method = RequestMethod.POST)
    public String queryAllFimList(@RequestBody FilmList filmList) {
        log.info("params:{}", filmList.toString());
        return JSON.toJSONString(filmApplication.queryAllFilmList(filmList));

    }

    /**
     * @param filmList
     * @return
     */
    @ApiOperation(value = "/film/queryByPageFilmList", notes = "查询所有影片列表")
    @RequestMapping(value = "/film/queryByPageFilmList", method = RequestMethod.POST)
    public String queryByPageFilmList(@RequestBody FilmList filmList, PageRequest pageRequest) {
        try {
            log.info("filmList:{}", filmList.toString());
            log.info("pageRequest:{}", pageRequest.toString());
            return JSON.toJSONString(filmApplication.queryByPageFilmList(filmList, pageRequest));
        } catch (Exception ex) {
            ex.printStackTrace();
            return JSON.toJSONString(new ResultDTO(200, ex.getMessage(), 0, null));
        }
    }
}
