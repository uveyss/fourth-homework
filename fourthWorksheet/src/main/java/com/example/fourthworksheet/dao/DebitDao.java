package com.example.fourthworksheet.dao;

import com.example.fourthworksheet.entity.DebitEntity;
import com.example.fourthworksheet.entity.UserEntity;
import com.example.fourthworksheet.repositories.DebitRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DebitDao {
    @Autowired
    private DebitRepositories repositories;

    public List<DebitEntity> findAll()
    {
        return  repositories.findAll();
    }

    public DebitEntity findById(Long id)
    {
        Optional<DebitEntity> debitEntity=repositories.findById(id);
        return debitEntity.orElse(null);
    }
    public DebitEntity save(DebitEntity debitEntity)
    {
       return repositories.save(debitEntity);
    }

    public List<DebitEntity> findUserDebitsById(Long userId)
    {
        return repositories.findUserDebits(userId);
    }

    public List<DebitEntity> findUserDebits(UserEntity userEntity,boolean isCollected)
    {
        return  new ArrayList<>();//epositories.findAllByUserAndCollected(userEntity,isCollected);
    }

    public List<DebitEntity>findDebitsByStartDateAndEndDate(Date startDate,Date endDate)
    {
        return repositories.findAllByDebitDateBetween(startDate,endDate);
    }

    public List<DebitEntity>findUserLatedDebits(Long userId)
    {
        return repositories.findUserLatedDebits(userId);
    }

    public List<DebitEntity> findUserTotalDebits(Long userId)
    {
        return repositories.findUserTotalDebits(userId);
    }
}
