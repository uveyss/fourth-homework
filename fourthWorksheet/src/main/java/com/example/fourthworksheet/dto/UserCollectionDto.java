package com.example.fourthworksheet.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UserCollectionDto {

    private Long userId;

    private Long contractId;

    private String userName;

    private String lastName;

    private BigDecimal debitAmount;

    private BigDecimal collectedAmount;

    private Date collectedDate;

    private BigDecimal delayAmount;

    public UserCollectionDto(Long userId, Long contractId, String userName, String userLastName, BigDecimal debitamount, BigDecimal collectedAmount, Date collectedDate, BigDecimal delayAmount) {
        this.userId = userId;
        this.contractId = contractId;
        this.userName = userName;
        this.lastName = userLastName;
        this.debitAmount = debitamount;
        this.collectedAmount = collectedAmount;
        this.collectedDate = collectedDate;
        this.delayAmount = delayAmount;
    }

    public UserCollectionDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(BigDecimal collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public Date getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(Date collectedDate) {
        this.collectedDate = collectedDate;
    }

    public BigDecimal getDelayAmount() {
        return delayAmount;
    }

    public void setDelayAmount(BigDecimal delayAmount) {
        this.delayAmount = delayAmount;
    }
}
