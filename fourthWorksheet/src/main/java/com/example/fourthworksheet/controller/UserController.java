package com.example.fourthworksheet.controller;

import com.example.fourthworksheet.converter.UserConverter;
import com.example.fourthworksheet.converter.UserDebitConverter;
import com.example.fourthworksheet.dto.UserDebitDto;
import com.example.fourthworksheet.dto.UserDto;
import com.example.fourthworksheet.entity.UserEntity;
import com.example.fourthworksheet.exception.DefaultExceptionMessagges;
import com.example.fourthworksheet.exception.UserNotFoundException;
import com.example.fourthworksheet.services.DebitService;
import com.example.fourthworksheet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("")
    public List<UserDto> findAll()
    {
        List<UserEntity> userEntityList = userService.findAll();
        if(userEntityList.size()<=0)
        {
            throw new UserNotFoundException(DefaultExceptionMessagges.userNotFound);
        }
        return UserConverter.INSTANCE.userEntityListConvertToUserDto(userEntityList);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id)
    {
        UserEntity userEntity = userService.findById(id);
        if(userEntity==null)
        {
            throw new UserNotFoundException(DefaultExceptionMessagges.userNotFound);
        }
        return UserConverter.INSTANCE.userEntityConvertToUserDto(userEntity);
    }

    @PostMapping("")
    public UserDto save(@RequestBody UserDto userDto)
    {
        UserEntity userEntity =UserConverter.INSTANCE.userDtoConvertToUserEntity(userDto);
        UserEntity savedEntity = userService.save(userEntity);
        return UserConverter.INSTANCE.userEntityConvertToUserDto(savedEntity);

    }

    @PutMapping("")
    public UserDto update(@RequestBody UserDto userDto)
    {
        UserEntity userEntity =UserConverter.INSTANCE.userDtoConvertToUserEntity(userDto);
        UserEntity savedEntity = userService.save(userEntity);
        return UserConverter.INSTANCE.userEntityConvertToUserDto(savedEntity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id)
    {
        UserEntity userEntity=userService.findById(id);
        if(userEntity==null)
        {
            throw new UserNotFoundException(DefaultExceptionMessagges.userNotFound);
        }

        userService.delete(id);
    }



}
