package com.example.fourthworksheet.converter;

import com.example.fourthworksheet.dto.UserCollectionDto;
import com.example.fourthworksheet.dto.UserDto;
import com.example.fourthworksheet.entity.CollectionEntity;
import com.example.fourthworksheet.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserCollectionConverter {

    UserCollectionConverter INSTANCE = Mappers.getMapper(UserCollectionConverter.class);
    @Mapping(source = "debitEntity.user.name",target = "userName")
    @Mapping(source = "debitEntity.user.lastName",target = "lastName")
    @Mapping(source = "debitEntity.user.userId",target = "userId")
    @Mapping(source = "debitEntity.user.contractNumber",target = "contractId")
    @Mapping(source = "debitEntity.totalDebitAmount",target ="debitAmount" )
    @Mapping(source = "collectionDate",target = "collectedDate")
    UserCollectionDto collectionEntityConvertToUserCollectionDto(CollectionEntity entity);

    @Mapping(target = "debitEntity.user.name",source = "userName")
    @Mapping(target = "debitEntity.user.lastName",source = "lastName")
    @Mapping(target = "debitEntity.user.userId",source = "userId")
    @Mapping(target = "debitEntity.user.contractNumber",source = "contractId")
    @Mapping(target = "debitEntity.totalDebitAmount",source ="debitAmount" )
    @Mapping(target = "collectionDate",source = "collectedDate")
    CollectionEntity userCollectionDtoConvertToCollectionEntity(UserCollectionDto userDto);

    List<UserCollectionDto> collectionEntityListConvertToUserCollectionDtoList(List<CollectionEntity> userEntities);


    List<CollectionEntity> userCollectionDtoConvertToCollectionEntityList(List<UserCollectionDto> userDtoList);
}
