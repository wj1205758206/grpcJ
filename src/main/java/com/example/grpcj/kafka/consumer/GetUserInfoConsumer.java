package com.example.grpcj.kafka.consumer;


import com.example.grpcj.client.GrpcClient;
import com.example.grpcj.common.gen.UserInfo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class GetUserInfoConsumer {
    private static final Logger logger = LoggerFactory.getLogger(GetUserInfoConsumer.class);
    @Resource
    GrpcClient grpcClient;

    @KafkaListener(topics = "getUserInfoTopic", groupId = "userInfoGroup")
    public boolean consume(List<ConsumerRecord<?, ?>> records) {
        logger.info("[GetUserInfoConsumer] consumer records count: " + records.size());
        int successCount = 0;
        int failCount = 0;
        for (ConsumerRecord record : records) {
            logger.info("[GetUserInfoConsumer] topic={}, partition={}, value={}",
                    record.topic(), record.partition(), record.value());
            UserInfo userInfo = (UserInfo) record.value();
            boolean isSuccess = false;
            try {
                String user = grpcClient.getUserInfo(userInfo.getId());
                if (user != null) {
                    isSuccess = true;
                }
            } catch (Exception e) {
                logger.error("[GetUserInfoConsumer] getUserInfo exception: " + e.getMessage());
            }
            if (isSuccess) {
                successCount++;
                logger.info("[GetUserInfoConsumer] getUserInfo success, userInfo={}", userInfo.toString());
            } else {
                failCount++;
                logger.info("[GetUserInfoConsumer] getUserInfo fail, userInfo={}", userInfo.toString());
            }
        }
        logger.info("[GetUserInfoConsumer] total={},successCount={},failCount={}", records.size(), successCount, failCount);
        return true;
    }
}
