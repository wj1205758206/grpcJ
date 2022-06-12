package com.example.grpcj.common.serializer;

import com.example.grpcj.common.gen.UserInfo;
import com.example.grpcj.server.GrpcServer;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

public class UserInfoSerializer implements Serializer<UserInfo>{
    private static final Logger logger = LoggerFactory.getLogger(UserInfoSerializer.class);

    @Override
    public byte[] serialize(String topic, UserInfo userInfo) {
        return ProtostuffUtil.serializer(userInfo, UserInfo.class);
    }
}
