package com.example.iamtest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import software.amazon.awssdk.services.iam.model.User;

import java.util.List;

@Mapper(uses = {UserMapper.class})
public interface ListUserMapper {
    ListUserMapper INSTANCE = Mappers.getMapper(ListUserMapper.class);
    List<MyUser> toMyUserList(List<User> users);
}