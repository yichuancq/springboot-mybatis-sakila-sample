package com.example.service.staff;

import com.example.dao.StaffListMapper;
import com.example.dao.StaffMapper;
import com.example.domain.Staff;
import com.example.domain.StaffList;
import com.example.vo.staff.StaffVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffListMapper staffListMapper;

    @Autowired
    private StaffMapper staffMapper;

    /**
     * @param staff
     * @return
     */
    @Override
    public Integer saveOne(Staff staff) {
        return staffMapper.insert(staff);
    }

    /***
     *
     * @param staffList
     * @return
     */
    @Override
    public List<StaffList> selectByPage(StaffList staffList) {
        return staffListMapper.selectByConditions(staffList);
    }

    /**
     * @param staffList
     * @return
     */
    @Override
    public Integer totalPage(StaffList staffList) {
        return staffListMapper.selectTotalPage(staffList);
    }

    @Override
    public List<StaffVO> selectStaffByPage(StaffVO staffVO) {
        return staffListMapper.selectStaffByPage(staffVO);
    }

    /**
     * @param staffVO
     * @return
     */
    @Override
    public Integer totalPageStaff(StaffVO staffVO) {

        return staffListMapper.selectTotalPageStaffVO(staffVO);
    }


}
