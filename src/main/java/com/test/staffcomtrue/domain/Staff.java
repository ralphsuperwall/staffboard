package com.test.staffcomtrue.domain;

public class Staff {

    private int staffCode;
    private String staffName;
    private String staffGrade;
    private String staffEmail;
    private String staffPhone;

    public int getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(int staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffGrade() {
        return staffGrade;
    }

    public void setStaffGrade(String staffGrade) {
        this.staffGrade = staffGrade;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffCode=" + staffCode +
                ", staffName='" + staffName + '\'' +
                ", staffGrade='" + staffGrade + '\'' +
                ", staffEmail='" + staffEmail + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                '}';
    }
}
