package com.example.fourthworksheet.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "User",schema = "public")
@SequenceGenerator(schema = "public",name = "generator", sequenceName = "user_id_seq")
public class UserEntity implements Serializable {

    public UserEntity(long userId, String name, String lastName, String address, String phone, Date recordDate, Long contractNumber) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.recordDate = recordDate;
        this.contractNumber = contractNumber;
    }

    public UserEntity()
    {

    }


    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "userid", nullable = false)
    private long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;


    @Column(name = "recordDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;

    @Column(name = "contractNumber", nullable = false)
    private Long contractNumber;

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Long getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Long contractNumber) {
        this.contractNumber = contractNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
