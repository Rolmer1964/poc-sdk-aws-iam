package com.example.iamtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.regions.Region;

@Configuration
public class ConfigAws {

    @Bean
    public IamClient iamClient() {
        return IamClient.builder()
                .region(Region.AWS_GLOBAL) // IAM é global
                .build();
    }
}