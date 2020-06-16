package com.example.dao;

import com.example.domain.StaffList;
import com.example.vo.staff.StaffVO;

import java.util.List;

public interface StaffListMapper {
    int insert(StaffList record);

    List<StaffList> selectAll();

    /**
     * @param staffList
     * @return
     */
    List<StaffList> selectByConditions(StaffList staffList);

    /**
     * @param staffList
     * @return
     */
    Integer selectTotalPage(StaffList staffList);

    /**
     * @param staffVO
     * @return
     */
    Integer selectTotalPageStaffVO(StaffVO staffVO);

    /**
     * @param staffVO
     * @return
     */
    List<StaffVO> selectStaffByPage(StaffVO staffVO);

}