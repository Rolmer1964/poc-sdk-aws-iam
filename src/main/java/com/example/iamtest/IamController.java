package com.example.iamtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.iam.model.CreateUserRequest;
import software.amazon.awssdk.services.iam.model.ListUserPoliciesResponse;
import software.amazon.awssdk.services.iam.model.User;

import java.util.List;

@RestController

public class IamController {

    @Autowired
    IamService iamService;

    @GetMapping("/iam/users")
    public ResponseEntity<List<MyUser>> getIamUsers() {
        List<MyUser> users = iamService.listIamUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/iam/users")
    public ResponseEntity<MyUser> createIamUser(@RequestBody CreateIamUserRequest createIamUserRequest) {
        MyUser user = iamService.createUser(createIamUserRequest);
        return ResponseEntity.ok(user);
    }

}