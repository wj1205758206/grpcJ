package com.example.grpcj.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "constant")
public class ConstantConfig {
    private  int partitionNum;
    private String userInfoTopic;
    private Map<String, String> topics;
    private Map<String, Integer> partitions;

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

    public Map<String, String> getTopics() {
        return topics;
    }

    public void setTopics(Map<String, String> topics) {
        this.topics = topics;
    }

    public Map<String, Integer> getPartitions() {
        return partitions;
    }

    public void setPartitions(Map<String, Integer> partition) {
        this.partitions = partition;
    }
}
