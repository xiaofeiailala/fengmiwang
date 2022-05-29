package com.fei.bean;

public class User {
    private int id;
    private String username;
    private String password;
    private String phone;
    private Integer roleId;
    private String sex;
    private String mail;
    private String mailStatus;
    private String validateCode;

    public User() {
    }

    public User(String username, String password, String phone, Integer roleId, String sex, String mail, String mailStatus, String validateCode) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.roleId = roleId;
        this.sex = sex;
        this.mail = mail;
        this.mailStatus = mailStatus;
        this.validateCode = validateCode;
    }

    public User(int id, String username, String password, String phone, Integer roleId, String sex, String mail, String mailStatus, String validateCode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.roleId = roleId;
        this.sex = sex;
        this.mail = mail;
        this.mailStatus = mailStatus;
        this.validateCode = validateCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(String mailStatus) {
        this.mailStatus = mailStatus;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", roleId=" + roleId +
                ", sex='" + sex + '\'' +
                ", mail='" + mail + '\'' +
                ", mailStatus='" + mailStatus + '\'' +
                ", validateCode='" + validateCode + '\'' +
                '}';
    }
}
