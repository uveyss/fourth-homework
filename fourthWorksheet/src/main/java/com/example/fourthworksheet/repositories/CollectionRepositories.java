package com.example.fourthworksheet.repositories;

import com.example.fourthworksheet.entity.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface CollectionRepositories extends JpaRepository<CollectionEntity,Long> {

    public List<CollectionEntity> findAllByCollectionDateBetween(Date startDate,Date endDate);

    @Query("select c from CollectionEntity c where c.debitEntity.user.userId=?1 and c.debitEntity.isCollected=true")
    public List<CollectionEntity> findAllCollectionByUserId(Long userId);
    @Query("select SUM (c.collectedAmount-c.debitEntity.totalDebitAmount )from CollectionEntity c where c.debitEntity.user.userId=?1 and c.debitEntity.isCollected=true")
    public BigDecimal userCollectedDelayAmount(Long userId);
}
