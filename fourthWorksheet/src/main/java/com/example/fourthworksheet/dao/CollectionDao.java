package com.example.fourthworksheet.dao;

import com.example.fourthworksheet.entity.CollectionEntity;
import com.example.fourthworksheet.entity.DebitEntity;
import com.example.fourthworksheet.repositories.CollectionRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CollectionDao {

    @Autowired
    CollectionRepositories collectionRepositories;

    public List<CollectionEntity> findDebitsByStartDateAndEndDate(Date startDate, Date endDate)
    {
        return collectionRepositories.findAllByCollectionDateBetween(startDate,endDate);
    }

    public List<CollectionEntity> findAllCollectionByUserId(Long userId)
    {
        return collectionRepositories.findAllCollectionByUserId(userId);
    }
    public BigDecimal userCollectedDelayAmount(Long userId)
    {
        return collectionRepositories.userCollectedDelayAmount(userId);
    }
}
