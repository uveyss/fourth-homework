package com.example.fourthworksheet.controller;


import com.example.fourthworksheet.constants.ReturnMessagges;
import com.example.fourthworksheet.converter.UserDebitConverter;
import com.example.fourthworksheet.dto.UserDebitDto;
import com.example.fourthworksheet.entity.DebitEntity;
import com.example.fourthworksheet.entity.UserEntity;
import com.example.fourthworksheet.exception.DefaultExceptionMessagges;
import com.example.fourthworksheet.exception.UserNotFoundException;
import com.example.fourthworksheet.services.DebitService;
import com.example.fourthworksheet.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/debits/")
public class DebitController {

    @Autowired
    private DebitService debitService;

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<UserDebitDto> findAll()
    {
        List<DebitEntity> debitEntities=debitService.findall();
        if(debitEntities.size()<=0)
        {
            throw new UserNotFoundException(DefaultExceptionMessagges.debitNotFound);
        }
        return UserDebitConverter.INSTANCE.debitEntityListConvertToDebitDto(debitEntities);

    }

    @GetMapping("/{id}")
    public UserDebitDto findById(@PathVariable Long id)
    {

        DebitEntity debitEntity= debitService.findById(id);
        if(debitEntity==null)
        {
            throw new UserNotFoundException(DefaultExceptionMessagges.debitNotFound);
        }
        return UserDebitConverter.INSTANCE.debitEntityConvertToDebitDto(debitEntity);
    }

    @PostMapping()
    public UserDebitDto save (@RequestBody UserDebitDto debitDto)
    {
        DebitEntity entity= UserDebitConverter.INSTANCE.debitDtoConvertToDebitEntity(debitDto);
        entity=debitService.save(entity);
        debitDto=UserDebitConverter.INSTANCE.debitEntityConvertToDebitDto(entity);
        return debitDto;



    }

    @GetMapping("/userDebit/{id}")
    public List<UserDebitDto> findUserDebit(@PathVariable Long id)
    {
        List<DebitEntity> debitEntity=debitService.findUserDebitsById(id);
        if(debitEntity.size()<=0)
        {
            throw new UserNotFoundException(ReturnMessagges.userHaveNotDebits);
        }
        List<UserDebitDto> userDebitDto=  UserDebitConverter.INSTANCE.debitEntityListConvertToDebitDto(debitEntity);
        return userDebitDto;
    }

    @GetMapping("/debits/{startDate}/{endDate}")
    public List<UserDebitDto> findUserDebitsByDates(@PathVariable Date startDate,@PathVariable Date endDate)
    {
        List<DebitEntity> debitEntities = debitService.findDebitsByStartDateAndEndDate(startDate,endDate);
        if(debitEntities.size()<=0)
        {
            throw new UserNotFoundException(ReturnMessagges.haveNotDebitsWithThisDates);
        }
        List<UserDebitDto> userDebitDtos=UserDebitConverter.INSTANCE.debitEntityListConvertToDebitDto(debitEntities);
        return userDebitDtos;
    }

    @GetMapping("/userLatedDebit/{id}")
    public List<UserDebitDto> findUserLatedDebit(@PathVariable Long id)
    {
        List<DebitEntity> debitEntity=debitService.findUserLatedDebits(id);
        if(debitEntity.size()<=0)
        {
            throw new UserNotFoundException(ReturnMessagges.userHasNosLatedDebit);
        }
        List<UserDebitDto> userDebitDto=  UserDebitConverter.INSTANCE.debitEntityListConvertToDebitDto(debitEntity);
        return userDebitDto;
    }

    @GetMapping("/userTotaldDebit/{id}")
    public  List<UserDebitDto> findUserTotalDebit(@PathVariable Long id)
    {
        List<DebitEntity> debitEntity=debitService.findUserTotalDebits(id);
        if(debitEntity==null)
        {
            throw new UserNotFoundException(ReturnMessagges.userHaveNotDebits);
        }
        List<UserDebitDto> userDebitDto=  UserDebitConverter.INSTANCE.debitEntityListConvertToDebitDto(debitEntity);
        userDebitDto=debitService.calculateDelayDebitAmount(userDebitDto);
        return userDebitDto;
    }

    @GetMapping("/userSumLateddDebit/{id}")
    public BigDecimal calculateUserLateDebit(@PathVariable Long id)
    {
        List<UserDebitDto> userDebitDtoList = findUserTotalDebit(id);
        return userDebitDtoList.stream().map(UserDebitDto::getTotalLatedDebitamount).reduce(BigDecimal::add).get();
    }
}
