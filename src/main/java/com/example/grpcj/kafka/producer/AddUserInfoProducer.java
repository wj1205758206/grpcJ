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
public class AddUserInfoProducer {
    private static final Logger logger = LoggerFactory.getLogger(AddUserInfoProducer.class);

    KafkaTemplate kafkaTemplate;

    @Resource
    ConstantConfig constantConfig;

    public AddUserInfoProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean produce(UserInfo userInfo) {
        boolean isSuccess = false;
        if (userInfo == null) {
            logger.error("[AddUserInfoProducer] invalid user info, produce fail");
            return isSuccess;
        }
        String addUserInfoTopic = constantConfig.getTopics().get("addUserInfoTopic");
        int partition = getPartition(userInfo, constantConfig.getPartitions().get("addUserInfoTopic"));
        if (partition < 0 || partition >= constantConfig.getPartitions().get("addUserInfoTopic")) {
            logger.error("[AddUserInfoProducer] invalid partition, partition={}, produce fail", partition);
            return isSuccess;
        }
        try {
            ListenableFuture sendFuture = kafkaTemplate.send(addUserInfoTopic, partition, userInfo);
            sendFuture.addCallback(new KafkaSendCallback() {
                @Override
                public void onFailure(KafkaProducerException e) {
                    logger.info("[AddUserInfoProducer] produce fail, send userInfo={}, topic={}, partition={}, exception={}",
                            TextFormat.printToUnicodeString(userInfo), addUserInfoTopic, partition, e.getMessage());
                }

                @Override
                public void onSuccess(Object result) {
                    logger.info("[AddUserInfoProducer] produce success, send userInfo={}, topic={}, partition={}",
                            TextFormat.printToUnicodeString(userInfo), addUserInfoTopic, partition);
                }
            });
            isSuccess = true;
        } catch (Exception e) {
            logger.error("[AddUserInfoProducer] produce exception: " + e);
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
