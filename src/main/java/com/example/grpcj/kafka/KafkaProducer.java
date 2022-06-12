package com.example.grpcj.kafka;

import com.example.grpcj.common.configuration.ConstantConfig;
import com.example.grpcj.common.gen.UserInfo;
import com.google.protobuf.TextFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

@Service
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    KafkaTemplate kafkaTemplate;

    @Resource
    ConstantConfig constantConfig;

    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean produce(UserInfo userInfo) {
        boolean isSuccess = false;
        if (userInfo == null) {
            logger.error("[kafkaProducer] invalid user info, produce fail");
            return isSuccess;
        }
        int partition = getPartition(userInfo);
        if (partition < 0 || partition >= constantConfig.getPartitionNum()) {
            logger.error("[kafkaProducer] invalid partition, partition={}, produce fail", partition);
            return isSuccess;
        }
        try {
            ListenableFuture sendFuture = kafkaTemplate.send(constantConfig.getUserInfoTopic(), partition, userInfo);
            sendFuture.addCallback(new KafkaSendCallback() {
                @Override
                public void onFailure(KafkaProducerException e) {
                    logger.info("[kafkaProducer] produce fail, send userInfo={}, topic={}, partition={}, exception={}",
                            TextFormat.printToUnicodeString(userInfo), constantConfig.getUserInfoTopic(), partition, e.getMessage());
                }

                @Override
                public void onSuccess(Object result) {
                    logger.info("[kafkaProducer] produce success, send userInfo={}, topic={}, partition={}",
                            TextFormat.printToUnicodeString(userInfo), constantConfig.getUserInfoTopic(), partition);
                }
            });
        } catch (Exception e) {
            logger.error("[kafkaProducer] produce exception: " + e);
        }
        return isSuccess;
    }

    private int getPartition(UserInfo userInfo) {
        int id = userInfo.getId();
        String name = userInfo.getName();
        int partition = (id + name).hashCode() % constantConfig.getPartitionNum();
        return partition;
    }
}
