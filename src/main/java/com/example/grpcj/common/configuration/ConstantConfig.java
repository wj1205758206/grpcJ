package com.example.grpcj.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "constant")
public class ConstantConfig {
    private  int partitionNum;
    private String userInfoTopic;

    public int getPartitionNum() {
        return partitionNum;
    }

    public void setPartitionNum(int partitionNum) {
        this.partitionNum = partitionNum;
    }

    public String getUserInfoTopic() {
        return userInfoTopic;
    }

    public void setUserInfoTopic(String userInfoTopic) {
        this.userInfoTopic = userInfoTopic;
    }
}
