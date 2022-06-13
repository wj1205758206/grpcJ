package com.example.grpcj.kafka.producer;

import com.example.grpcj.common.configuration.ConstantConfig;
import com.example.grpcj.common.gen.UserInfo;
import com.google.protobuf.TextFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

@Service
public class GetUserInfoProducer {
    private static final Logger logger = LoggerFactory.getLogger(GetUserInfoProducer.class);

    KafkaTemplate kafkaTemplate;

    @Resource
    ConstantConfig constantConfig;

    public GetUserInfoProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean produce(UserInfo userInfo) {
        boolean isSuccess = false;
        if (userInfo == null) {
            logger.error("[GetUserInfoProducer] invalid user info, produce fail");
            return isSuccess;
        }
        String getUserInfoTopic = constantConfig.getTopics().get("getUserInfoTopic");
        int partition = getPartition(userInfo, constantConfig.getPartitions().get("getUserInfoTopic"));
        if (partition < 0 || partition >= constantConfig.getPartitions().get("getUserInfoTopic")) {
            logger.error("[GetUserInfoProducer] invalid partition, partition={}, produce fail", partition);
            return isSuccess;
        }
        try {
            ListenableFuture sendFuture = kafkaTemplate.send(getUserInfoTopic, partition, userInfo);
            sendFuture.addCallback(new KafkaSendCallback() {
                @Override
                public void onFailure(KafkaProducerException e) {
                    logger.info("[GetUserInfoProducer] produce fail, send userInfo={}, topic={}, partition={}, exception={}",
                            TextFormat.printToUnicodeString(userInfo), getUserInfoTopic, partition, e.getMessage());
                }

                @Override
                public void onSuccess(Object result) {
                    logger.info("[GetUserInfoProducer] produce success, send userInfo={}, topic={}, partition={}",
                            TextFormat.printToUnicodeString(userInfo), getUserInfoTopic, partition);
                }
            });
            isSuccess = true;
        } catch (Exception e) {
            logger.error("[GetUserInfoProducer] produce exception: " + e);
        }
        return isSuccess;
    }

    public int getPartition(UserInfo userInfo, int topicPartitionNum) {
        int id = userInfo.getId();
        String name = userInfo.getName();
        int partition = (id + name).hashCode() % topicPartitionNum;
        return partition;
    }
}
