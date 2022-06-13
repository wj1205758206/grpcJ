package com.example.grpcj.kafka;

import com.example.grpcj.common.configuration.ConstantConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class KafkaTopics {
    @Resource
    ConstantConfig constantConfig;

    @Bean
    public NewTopic userInfoTopic() {
        return new NewTopic(constantConfig.getUserInfoTopic(), constantConfig.getPartitionNum(), (short) 1);
    }

    @Bean
    public NewTopic addUserInfoTopic() {
        return new NewTopic(
                constantConfig.getTopics().get("addUserInfoTopic"),
                constantConfig.getPartitions().get("addUserInfoTopic"),
                (short) 1);
    }

    @Bean
    public NewTopic deleteUserInfoTopic() {
        return new NewTopic(
                constantConfig.getTopics().get("deleteUserInfoTopic"),
                constantConfig.getPartitions().get("deleteUserInfoTopic"),
                (short) 1);
    }

    @Bean
    public NewTopic updateUserInfoTopic() {
        return new NewTopic(
                constantConfig.getTopics().get("updateUserInfoTopic"),
                constantConfig.getPartitions().get("updateUserInfoTopic"),
                (short) 1);
    }

    @Bean
    public NewTopic getUserInfoTopic() {
        return new NewTopic(
                constantConfig.getTopics().get("getUserInfoTopic"),
                constantConfig.getPartitions().get("getUserInfoTopic"),
                (short) 1);
    }
}
