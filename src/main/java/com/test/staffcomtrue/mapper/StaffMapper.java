package com.test.staffcomtrue.mapper;

import com.test.staffcomtrue.domain.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StaffMapper {

    int enrollStaff(Staff staff);
    int modifyStaff(Staff staff);
    List<Staff> staffList();
    List<Staff> targetStaff(String staffCode);
    List<Staff> getStaffInfo(Map<String, Object> search);
    int deleteStaff(String staffCode);
}
