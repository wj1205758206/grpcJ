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
public class UpdateUserInfoConsumer {
    private static final Logger logger = LoggerFactory.getLogger(UpdateUserInfoConsumer.class);
    @Resource
    GrpcClient grpcClient;

    @KafkaListener(topics = "updateUserInfoTopic", groupId = "userInfoGroup")
    public boolean consume(List<ConsumerRecord<?, ?>> records) {
        logger.info("[UpdateUserInfoConsumer] consumer records count: " + records.size());
        int successCount = 0;
        int failCount = 0;
        for (ConsumerRecord record : records) {
            logger.info("[UpdateUserInfoConsumer] topic={}, partition={}, value={}",
                    record.topic(), record.partition(), record.value());
            UserInfo userInfo = (UserInfo) record.value();
            boolean isSuccess = false;
            try {
                isSuccess = grpcClient.updateUserInfo(userInfo.getId());
            } catch (Exception e) {
                logger.error("[UpdateUserInfoConsumer] update exception: " + e.getMessage());
            }
            if (isSuccess) {
                successCount++;
                logger.info("[UpdateUserInfoConsumer] update success, userInfo={}", userInfo.toString());
            } else {
                failCount++;
                logger.info("[UpdateUserInfoConsumer] update fail, userInfo={}", userInfo.toString());
            }
        }
        logger.info("[UpdateUserInfoConsumer] total={},successCount={},failCount={}", records.size(), successCount, failCount);
        return true;
    }
}
