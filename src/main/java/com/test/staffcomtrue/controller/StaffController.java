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
        model.addAttribute("targetStaff", targetStaff);
        staffService.deleteStaff(staffCode);
        return "/modify";
    }

    @PostMapping("/modify/target/staff")
    public String modifyStaff(Staff staff){
        staffService.modifyStaff(staff);
        return "redirect:/enroll";
    }

    @GetMapping(value = "/modify/staff/code", produces = "application/json")
    @ResponseBody
    public boolean staffCodeCheck(@RequestParam("staffCode") String staffCode) {
        List<String> allStaffCode = staffService.getAllStaffCode();
        if(allStaffCode.contains(staffCode)){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/staff/{staffCode}")
    public String deleteStaff(@PathVariable String staffCode) {
        staffService.deleteStaff(staffCode);
        return "redirect:/";
    }

}
