package com.test.staffcomtrue.controller;

import com.test.staffcomtrue.domain.Staff;
import com.test.staffcomtrue.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/modify/{staffCode}")
    public String modify(@PathVariable int staffCode, Model model) {
        List<Staff> targetStaff = staffService.targetStaff(staffCode);
        model.addAttribute("targetStaff", targetStaff);
        return "modify";
    }

    @PostMapping("/enroll/staff")
    public String enrollStaff(Staff staff){
        System.out.println(staff);
        staffService.enrollStaff(staff);
        return "redirect:/enroll";
    }

    @GetMapping("/staff/{staffCode}")
    public String deleteStaff(@PathVariable int staffCode) {
        staffService.deleteStaff(staffCode);
        return "main";
    }

}
