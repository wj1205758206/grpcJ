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
    public NewTopic userInfoTopic(){
        return new NewTopic(constantConfig.getUserInfoTopic(), constantConfig.getPartitionNum(), (short) 1);
    }
}
