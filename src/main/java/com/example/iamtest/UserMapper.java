package com.example.iamtest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import software.amazon.awssdk.services.iam.model.User;

import java.time.Instant;
import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "path", expression = "java(user.path())")
    @Mapping(target = "userName", expression = "java(user.userName())")
    @Mapping(target = "userId", expression = "java(user.userId())")
    @Mapping(target = "arn", expression = "java(user.arn())")
    @Mapping(target = "createDate", expression = "java(user.createDate())")
    @Mapping(target = "passwordLastUsed", expression = "java(user.passwordLastUsed())")
    MyUser toMyUser(User user);

}