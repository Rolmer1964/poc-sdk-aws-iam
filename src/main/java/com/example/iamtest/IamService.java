package com.example.iamtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.MarkedYAMLException;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.*;

import java.util.List;

@Service
public class IamService {

    @Autowired
    IamClient iamClient;

    public List<MyUser> listIamUsers() {
        ListUsersRequest request = ListUsersRequest.builder().build();
        ListUsersResponse response = iamClient.listUsers(request);
        return ListUserMapper.INSTANCE.toMyUserList(response.users());

    }

    public MyUser createUser(CreateIamUserRequest createIamUserRequest) {
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .userName(createIamUserRequest.userName)
                .build();

        CreateUserResponse createUserResponse = iamClient.createUser(createUserRequest);

        CreateLoginProfileRequest loginProfileRequest = CreateLoginProfileRequest.builder()
                .userName(createIamUserRequest.userName)
                .password(createIamUserRequest.password)
                .passwordResetRequired(true)
                .build();
        iamClient.createLoginProfile(loginProfileRequest);

        return UserMapper.INSTANCE.toMyUser(createUserResponse.user());

    }


}
