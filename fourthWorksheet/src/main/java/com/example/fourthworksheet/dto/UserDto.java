package com.example.fourthworksheet.dto;

import java.util.Date;

public class UserDto {

    private String userName;

    private String mail;

    private String lastName;

    private Long contractNumber;

    private Date recordDate;

    private String phone;

    private String address;

    public UserDto() {
    }

    public UserDto(String userName, String mail, String lastName, Long contractNumber, Date recordDate, String phone,String address) {
        this.userName = userName;
        this.mail = mail;
        this.lastName = lastName;
        this.contractNumber = contractNumber;
        this.recordDate = recordDate;
        this.phone = phone;
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Long contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
