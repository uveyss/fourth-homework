package com.example.fourthworksheet.controller;

import com.example.fourthworksheet.constants.ReturnMessagges;
import com.example.fourthworksheet.converter.UserCollectionConverter;
import com.example.fourthworksheet.converter.UserDebitConverter;
import com.example.fourthworksheet.dto.UserCollectionDto;
import com.example.fourthworksheet.dto.UserDebitDto;
import com.example.fourthworksheet.entity.CollectionEntity;
import com.example.fourthworksheet.entity.DebitEntity;
import com.example.fourthworksheet.exception.UserNotFoundException;
import com.example.fourthworksheet.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/collections/")
public class CollectionController {


    @Autowired
    CollectionService collectionService;

    @GetMapping("/debits/{startDate}/{endDate}")
    public List<UserCollectionDto> findUserDebitsByDates(@PathVariable Date startDate, @PathVariable Date endDate)
    {
        List<CollectionEntity> collectionEntities = collectionService.findDebitsByStartDateAndEndDate(startDate,endDate);
        if(collectionEntities.size()<=0)
        {
            throw new UserNotFoundException(ReturnMessagges.haveNotDebitsWithThisDates);
        }
        List<UserCollectionDto> userCollectionDtos= UserCollectionConverter.INSTANCE.collectionEntityListConvertToUserCollectionDtoList(collectionEntities);
        return userCollectionDtos;
    }

    @GetMapping("/userCollection/{id}")
    public List<UserCollectionDto> findUserLatedDebit(@PathVariable Long id)
    {
        List<CollectionEntity> collectionEntities=collectionService.findAllCollectionByUserId(id);
        if(collectionEntities.size()<=0)
        {
            throw new UserNotFoundException(ReturnMessagges.userHasNosLatedDebit);
        }
        List<UserCollectionDto> userCollectionDtos= UserCollectionConverter.INSTANCE.collectionEntityListConvertToUserCollectionDtoList(collectionEntities);
        return userCollectionDtos;
    }

    @GetMapping("/userCollectedDelayAmount/{id}")
    public BigDecimal getUserPayedDelayamount(@PathVariable Long userId)
    {
        BigDecimal delayAmount = BigDecimal.ZERO;
        delayAmount=collectionService.userCollectedDelayAmount(userId);

        return delayAmount;
    }
}
