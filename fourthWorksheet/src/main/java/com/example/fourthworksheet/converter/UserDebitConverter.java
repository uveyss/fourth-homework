package com.example.fourthworksheet.converter;
import com.example.fourthworksheet.dto.UserDebitDto;
import com.example.fourthworksheet.entity.DebitEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDebitConverter {

    UserDebitConverter INSTANCE = Mappers.getMapper(UserDebitConverter.class);

    @Mapping(source = "user.name",target = "userName")
    @Mapping(source = "user.contractNumber",target = "contractNumber")
    @Mapping(source = "user.lastName",target = "lastName")
    @Mapping(source = "user.userId",target = "userId")
    UserDebitDto debitEntityConvertToDebitDto(DebitEntity entity);

    @Mapping(target = "user.name",source = "userName")
    @Mapping(target = "user.contractNumber",source = "contractNumber")
    @Mapping(target = "user.lastName",source = "lastName")
    @Mapping(target = "user.userId",source = "userId")
    DebitEntity debitDtoConvertToDebitEntity(UserDebitDto userDebitDto);

    List<UserDebitDto> debitEntityListConvertToDebitDto(List<DebitEntity> userEntities);


    List<DebitEntity> debitDtoListConvertToDebitEntityList(List<UserDebitDto> userDtoList);
}
