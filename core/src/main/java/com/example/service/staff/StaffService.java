package com.example.service.staff;

import com.example.domain.Staff;
import com.example.domain.StaffList;
import com.example.vo.staff.StaffVO;

import java.util.List;

/**
 *
 */
public interface StaffService {

    Integer saveOne(Staff staff);

    /**
     * @param staffList
     * @return
     */
    List<StaffList> selectByPage(StaffList staffList);

    /**
     * @param staffList
     * @return
     */
    Integer totalPage(StaffList staffList);

    /**
     * @return
     * @paramstaffVO
     */
    List<StaffVO> selectStaffByPage(StaffVO staffVO);

    /**
     * @param staffVO
     * @return
     */
    Integer totalPageStaff(StaffVO staffVO);

}
