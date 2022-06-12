package com.example.grpcj.kafka;


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
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @Resource
    GrpcClient grpcClient;

    @KafkaListener(topics = "userInfoTopic", groupId = "userInfoGroup")
    public boolean consume(List<ConsumerRecord<?, ?>> records) {
        logger.info("[kafkaConsumer] consumer records count: " + records.size());
        int successCount = 0;
        int failCount = 0;
        for (ConsumerRecord record : records) {
            logger.info("[kafkaConsumer] topic={}, partition={}, value={}",
                    record.topic(), record.partition(), record.value());
            UserInfo userInfo = (UserInfo) record.value();
            boolean isSuccess = false;
            try {
                isSuccess = grpcClient.addUserInfo(userInfo);
            } catch (Exception e) {
                logger.error("[kafkaConsumer] addUserInfo exception: " + e.getMessage());
            }
            if (isSuccess) {
                successCount++;
                logger.info("[kafkaConsumer] addUserInfo success, userInfo={}", userInfo.toString());
            } else {
                failCount++;
                logger.info("[kafkaConsumer] addUserInfo fail, userInfo={}", userInfo.toString());
            }
        }
        logger.info("[kafkaConsumer] total={},successCount={},failCount={}", records.size(), successCount, failCount);
        return true;
    }
}
