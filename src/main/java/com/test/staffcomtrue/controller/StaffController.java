package com.test.staffcomtrue.controller;

import com.test.staffcomtrue.domain.Staff;
import com.test.staffcomtrue.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class StaffController {

    private final StaffService staffService;
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/enroll")
    public String enroll() {
        return "enroll";
    }

    @PostMapping("/enroll/staff")
    public String enrollStaff(Staff staff){
        staffService.enrollStaff(staff);
        return "redirect:/enroll";
    }

    @GetMapping("/modify/{staffCode}")
    public String modify(@PathVariable String staffCode, Model model) {
        List<Staff> targetStaff = staffService.targetStaff(staffCode);
        List<String> allStaffCode = staffService.getAllStaffCode();
        String targetPrimaryCode = staffCode;
        model.addAttribute("targetStaff", targetStaff);
        model.addAttribute("allStaffCode", allStaffCode);
        model.addAttribute("targetPrimaryCode", targetPrimaryCode);
        staffService.deleteStaff(staffCode);
        return "/modify";
    }

    @PostMapping("/modify/target/staff")
    public String modifyStaff(Staff staff){
        List<String> allStaffCode = staffService.getAllStaffCode();
        String staffModifyCode = staff.getStaffCode();
        if(allStaffCode.contains(staffModifyCode)){
            staffService.modifyStaff(staff);
        }else{
            staffService.modifyStaffCode(staff);
        }
        return "redirect:/";
    }

    @GetMapping("/staff/{staffCode}")
    public String deleteStaff(@PathVariable String staffCode) {
        staffService.deleteStaff(staffCode);
        return "redirect:/";
    }

}
