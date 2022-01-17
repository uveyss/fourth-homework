package com.example.fourthworksheet.services;

import com.example.fourthworksheet.dao.CollectionDao;
import com.example.fourthworksheet.entity.CollectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CollectionService {
    @Autowired
    CollectionDao collectionDao;

    public List<CollectionEntity> findDebitsByStartDateAndEndDate(Date startDate, Date endDate)
    {
        return collectionDao.findDebitsByStartDateAndEndDate(startDate,endDate);
    }

    public List<CollectionEntity> findAllCollectionByUserId(Long userId)
    {
        return collectionDao.findAllCollectionByUserId(userId);
    }

    public BigDecimal userCollectedDelayAmount(Long userId)
    {
        return collectionDao.userCollectedDelayAmount(userId);
    }
}
