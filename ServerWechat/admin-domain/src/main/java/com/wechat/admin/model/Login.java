package com.wechat.admin.model;

import java.util.Date;

public class Login {
    private Long userId;

    private String phoneNum;

    private String password;

    private String avatar;

    private String realName;

    private String idNum;

    private String debitCard;

    private String reservedPhoneNum;

    private Date inputDate;

    private String noAgree;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
    }

    public String getDebitCard() {
        return debitCard;
    }

    public void setDebitCard(String debitCard) {
        this.debitCard = debitCard == null ? null : debitCard.trim();
    }

    public String getReservedPhoneNum() {
        return reservedPhoneNum;
    }

    public void setReservedPhoneNum(String reservedPhoneNum) {
        this.reservedPhoneNum = reservedPhoneNum == null ? null : reservedPhoneNum.trim();
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getNoAgree() {
        return noAgree;
    }

    public void setNoAgree(String noAgree) {
        this.noAgree = noAgree == null ? null : noAgree.trim();
    }
}