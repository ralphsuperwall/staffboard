package com.test.staffcomtrue.controller;


import com.test.staffcomtrue.domain.Staff;
import com.test.staffcomtrue.service.StaffService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
    public class MainController {

        private final StaffService staffService;
        public MainController(StaffService staffService) {
            this.staffService = staffService;
        }

        @GetMapping("/")
        public String main(Model model){
            List<Staff> staffList = staffService.staffList();
            model.addAttribute("staffList", staffList);
            return "main";
        }

        @GetMapping("/staffSearch")
        public String getStaffInfo(@RequestParam(name = "searchValue", required = false) String searchValue,
                                    @RequestParam(name = "searchKey", required = false) String searchKey,
                                    Model model) {

            Map<String, Object> search = new HashMap<String, Object>();
            search.put("searchKey", searchKey);
            search.put("searchValue", searchValue);
            List<Staff> staffList = staffService.getStaffInfo(search);
            model.addAttribute("staffList", staffList);
            return "main";
        }

        @GetMapping("/excel/download")
        public void excelDownload(HttpServletResponse response) throws IOException {
            Workbook wb = new XSSFWorkbook();
            List<Staff> staffList = staffService.staffList();
            Sheet sheet = wb.createSheet("첫번째 시트");
            Row row = null;
            Cell cell = null;
            int rowNum = 0;

            row = sheet.createRow(rowNum++);
            cell = row.createCell(0);
            cell.setCellValue("사원코드");
            cell = row.createCell(1);
            cell.setCellValue("이름");
            cell = row.createCell(2);
            cell.setCellValue("직급");
            cell = row.createCell(3);
            cell.setCellValue("이메일");
            cell = row.createCell(4);
            cell.setCellValue("전화번호");

            for (int i=0; i< staffList.size(); i++) {
                Staff staff = staffList.get(i);
                row = sheet.createRow(rowNum++);
                cell = row.createCell(0);
                cell.setCellValue(staff.getStaffCode());
                cell = row.createCell(1);
                cell.setCellValue(staff.getStaffName());
                cell = row.createCell(2);
                cell.setCellValue(staff.getStaffGrade());
                cell = row.createCell(3);
                cell.setCellValue(staff.getStaffEmail());
                cell = row.createCell(4);
                cell.setCellValue(staff.getStaffPhone());
            }

            response.setContentType("ms-vnd/excel");
            response.setHeader("Content-Disposition", "attachment;filename=stafflist.xlsx");

            wb.write(response.getOutputStream());
            wb.close();
        }
    }

