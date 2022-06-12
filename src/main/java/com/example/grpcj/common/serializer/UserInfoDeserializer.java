package com.example.grpcj.common.serializer;

import com.example.grpcj.common.gen.UserInfo;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfoDeserializer implements Deserializer<UserInfo> {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoDeserializer.class);

    @Override
    public UserInfo deserialize(String topic, byte[] bytes) {
        return ProtostuffUtil.deserializer(bytes, UserInfo.class);
    }
}
