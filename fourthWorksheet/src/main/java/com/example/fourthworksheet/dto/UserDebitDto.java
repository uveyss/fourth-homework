package com.example.fourthworksheet.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UserDebitDto {

    private Date maturityDate;

    private boolean isCollected;

    private String userName;

    private String lastName;

    private Long contractNumber;

    private BigDecimal totalDebitAmount;

    private Date debitDate;
    private Long userId;
    private BigDecimal totalLatedDebitamount;

    public UserDebitDto() {
    }

    public UserDebitDto(Date maturityDate, boolean isCollected, String userName, String lastName, Long contractNumber, BigDecimal totalDebitAmount,Date debitDate,Long userId,BigDecimal totalLatedDebitamount) {
        this.maturityDate = maturityDate;
        this.isCollected = isCollected;
        this.userName = userName;
        this.lastName = lastName;
        this.contractNumber = contractNumber;
        this.totalDebitAmount = totalDebitAmount;
        this.debitDate=debitDate;
        this.userId=userId;
        this.totalLatedDebitamount=totalLatedDebitamount;
    }

    public BigDecimal getTotalLatedDebitamount() {
        return totalLatedDebitamount;
    }

    public void setTotalLatedDebitamount(BigDecimal totalLatedDebitamount) {
        this.totalLatedDebitamount = totalLatedDebitamount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDebitDate() {
        return debitDate;
    }

    public void setDebitDate(Date debitDate) {
        this.debitDate = debitDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public BigDecimal getTotalDebitAmount() {
        return totalDebitAmount;
    }

    public void setTotalDebitAmount(BigDecimal totalDebitAmount) {
        this.totalDebitAmount = totalDebitAmount;
    }
}
