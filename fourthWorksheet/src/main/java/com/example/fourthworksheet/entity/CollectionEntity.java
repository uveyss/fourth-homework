package com.example.fourthworksheet.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "collection")
@SequenceGenerator(schema = "public",name = "generator", sequenceName = "collection_id_seq")
public class CollectionEntity {


    @SequenceGenerator(schema = "public",name = "generator", sequenceName = "collection_id_seq")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "collectionId", nullable = false)
    private long collectionId;

    @Column(name = "collectionDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionDate;

    @Column(name = "collectedAmount", nullable = false)
    private BigDecimal collectedAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debit_id",
            foreignKey = @ForeignKey(name = "FK_DEBIT_DEBIT_ID"))
    private DebitEntity debitEntity;

    public CollectionEntity(long collectionId, Date collectionDate, BigDecimal collectedAmount, DebitEntity debitEntity) {
        this.collectionId = collectionId;
        this.collectionDate = collectionDate;
        this.collectedAmount = collectedAmount;
        this.debitEntity = debitEntity;
    }

    public CollectionEntity() {
    }

    public long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(long collectionId) {
        this.collectionId = collectionId;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public BigDecimal getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(BigDecimal collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public DebitEntity getDebitEntity() {
        return debitEntity;
    }

    public void setDebitEntity(DebitEntity debitEntity) {
        this.debitEntity = debitEntity;
    }
}

