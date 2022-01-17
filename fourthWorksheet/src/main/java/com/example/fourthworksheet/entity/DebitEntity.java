package com.example.fourthworksheet.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Debit",schema = "public")

public class DebitEntity {


    public DebitEntity(long debitId, UserEntity user, Date maturityDate, boolean isCollected, BigDecimal totalDebitAmount, Date debitDate, Date collectedDate) {
        this.debitId = debitId;
        this.user = user;
        this.maturityDate = maturityDate;
        this.isCollected = isCollected;
        this.totalDebitAmount = totalDebitAmount;
        this.debitDate = debitDate;
        this.collectedDate = collectedDate;
    }

    public DebitEntity() {
    }



    @SequenceGenerator(schema = "public",name = "generator", sequenceName = "debit_id_seq")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "debitId", nullable = false)
    private long debitId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "FK_DEBIT_USER_ID"))
    private  UserEntity user;

    @Column(name = "maturityDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date maturityDate;


    @Column(length = 1, name = "isCollected")
    private boolean isCollected;

    @Column(name = "totalDebitAmount" , precision = 19, scale = 2)
    private BigDecimal totalDebitAmount;

    @Column(name = "debitDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date debitDate;

    @Column(name = "collectedDate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectedDate;

    public long getDebitId() {
        return debitId;
    }

    public void setDebitId(long debitId) {
        this.debitId = debitId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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

    public BigDecimal getTotalDebitAmount() {
        return totalDebitAmount;
    }

    public void setTotalDebitAmount(BigDecimal totalDebitAmount) {
        this.totalDebitAmount = totalDebitAmount;
    }

    public Date getDebitDate() {
        return debitDate;
    }

    public void setDebitDate(Date debitDate) {
        this.debitDate = debitDate;
    }

    public Date getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(Date collectedDate) {
        this.collectedDate = collectedDate;
    }
}
