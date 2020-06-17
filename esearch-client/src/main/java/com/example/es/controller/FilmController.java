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

//
//    @Autowired
//    private FilmApplication filmApplication;

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

    /**
     * 搜索文章
     *
     * @return
     */
//    @GetMapping("/film/search")
//    public ResponseEntity searchFilms(
//            @RequestParam(value = "curPage", defaultValue = "1") int curPage,
//            @RequestParam(value = "size", defaultValue = "7") int size,
//            @RequestParam(value = "keyword") String keyword) {
//        List<FilmList> articles = filmApplication.searchMulWithHighLight(keyword, curPage, size);
//        return ResponseEntity.ok(articles);
//    }
}
