package com.test.staffcomtrue.service;

import com.test.staffcomtrue.domain.Staff;
import com.test.staffcomtrue.mapper.StaffMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StaffService {

    private final StaffMapper staffMapper;

    public StaffService(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    public int enrollStaff(Staff staff) {
        return staffMapper.enrollStaff(staff);
    }

    public int deleteStaff(int staffCode){
        return staffMapper.deleteStaff(staffCode);
    }

    public List<Staff> targetStaff(int staffCode){
        List<Staff> targetStaff = staffMapper.targetStaff(staffCode);
        return targetStaff;
    }

    public List<Staff> staffList(){
        List<Staff> staffList = staffMapper.staffList();
        return staffList;
    }

    public List<Staff> getStaffInfo(Map<String, Object> search){
        String searchKey = (String) search.get("searchKey");
        if(searchKey != null) {
            if("staffCode".equals(searchKey)) {
                searchKey = "staff_code";
            }else if("staffName".equals(searchKey)) {
                searchKey = "staff_name";
            }else if("staffGrade".equals(searchKey)) {
                searchKey = "staff_grade";
            }else if("staffEmail".equals(searchKey)) {
                searchKey = "staff_email";
            }else {
                searchKey = "staff_phone";
            }
            search.put("searchKey", searchKey);
        }
        List<Staff> staffList = staffMapper.getStaffInfo(search);
        return staffList;
    }
}
