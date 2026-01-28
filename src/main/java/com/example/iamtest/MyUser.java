package com.example.iamtest;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Setter
@Getter
public class MyUser {

    private  String path;
    private  String userName;
    private  String userId;
    private  String arn;
    private  Instant createDate;
    private  Instant passwordLastUsed;

}
