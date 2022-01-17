package com.example.fourthworksheet.converter;

import com.example.fourthworksheet.dto.UserDto;
import com.example.fourthworksheet.entity.UserEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);
    @Mapping(source = "name",target = "userName")
    UserDto userEntityConvertToUserDto(UserEntity entity);
    @Mapping(source = "userName",target = "name")
    UserEntity userDtoConvertToUserEntity(UserDto userDto);

    List<UserDto> userEntityListConvertToUserDto(List<UserEntity> userEntities);


    List<UserEntity> userDtoListConvertToUserEntityList(List<UserDto> userDtoList);
}
