package com.example.application;

import com.example.domain.StaffList;
import com.example.service.staff.StaffService;
import com.example.vo.PageRequest;
import com.example.vo.ResultDTO;
import com.example.vo.staff.StaffVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffApplication {


    @Autowired
    private StaffService staffService;

    /**
     * @param staffList
     * @param pageRequest
     * @return
     */
    public ResultDTO<StaffList> queryByPageStaffList(StaffList staffList, PageRequest pageRequest) {
        try {
            PageHelper.startPage(pageRequest.getPageNumber(), pageRequest.getPageSize());
            List<StaffList> filmLists = staffService.selectByPage(staffList);
            Integer totalPage = staffService.totalPage(staffList);
            return new ResultDTO(200, "ok", totalPage, filmLists);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResultDTO(200, ex.getMessage(), 0, null);
        }

    }

    /**
     * @param staffVO
     * @param pageRequest
     * @return
     */
    public ResultDTO<StaffVO> queryByPageStaffVoList(StaffVO staffVO, PageRequest pageRequest) {
        try {
            PageHelper.startPage(pageRequest.getPageNumber(), pageRequest.getPageSize());
            List<StaffVO> filmLists = staffService.selectStaffByPage(staffVO);
            Integer totalPage = staffService.totalPageStaff(staffVO);
            return new ResultDTO(200, "ok", totalPage, filmLists);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResultDTO(200, ex.getMessage(), 0, null);
        }

    }


}
