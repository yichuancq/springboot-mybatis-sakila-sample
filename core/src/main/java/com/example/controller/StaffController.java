package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.application.StaffApplication;
import com.example.domain.StaffList;
import com.example.vo.PageRequest;
import com.example.vo.ResultDTO;
import com.example.vo.staff.StaffVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class StaffController {

    @Autowired
    private StaffApplication staffApplication;

    /**
     * @param staffList
     * @param pageRequest
     * @return
     */
    @ApiOperation(value = "/staff/queryByPageStaffList", notes = "查询所有雇员列表")
    @RequestMapping(value = "/staff/queryByPageStaffList", method = RequestMethod.POST)
    public ResultDTO<StaffList> queryByPageStaffList(@RequestBody StaffList staffList, PageRequest pageRequest) {
        log.info("staffList:{}", staffList.toString());
        log.info("pageRequest:{}", pageRequest.toString());
        return staffApplication.queryByPageStaffList(staffList, pageRequest);
    }

    /**
     * @param staffVO
     * @param pageRequest
     * @return
     */
    @ApiOperation(value = "/staff/queryByPageStaffVOList", notes = "查询所有雇员VO列表")
    @RequestMapping(value = "/staff/queryByPageStaffVOList", method = RequestMethod.POST)
    public String queryByPageStaffVOList(@RequestBody StaffVO staffVO, PageRequest pageRequest) {
        log.info("staffVO:{}", staffVO.toString());
        log.info("pageRequest:{}", pageRequest.toString());
        return JSON.toJSONString(staffApplication.queryByPageStaffVoList(staffVO, pageRequest));
    }


}
