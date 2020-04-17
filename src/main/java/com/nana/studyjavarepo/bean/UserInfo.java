package com.nana.studyjavarepo.bean;

public class UserInfo {
    private String userId;

    private String userName;

    private String gender;

    private String jobTitle;

    private String departmentCode;

    private String phone;

    private String email;

    private String dingdingNumber;

    private String roleId;

    public UserInfo(String userId, String userName, String gender, String jobTitle, String departmentCode, String phone, String email, String dingdingNumber, String roleId) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.jobTitle = jobTitle;
        this.departmentCode = departmentCode;
        this.phone = phone;
        this.email = email;
        this.dingdingNumber = dingdingNumber;
        this.roleId = roleId;
    }

    public UserInfo() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode == null ? null : departmentCode.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDingdingNumber() {
        return dingdingNumber;
    }

    public void setDingdingNumber(String dingdingNumber) {
        this.dingdingNumber = dingdingNumber == null ? null : dingdingNumber.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}