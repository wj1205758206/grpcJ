package com.example.grpcj.common.serializer;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProtostuffUtil {
    private static final Logger logger = LoggerFactory.getLogger(ProtostuffUtil.class);

    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<>();

    private static final LinkedBuffer BUFFER = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE * 5);

    /**
     * 序列化
     *
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> byte[] serializer(T data, Class<T> clazz) {
        byte[] bytes = null;
        try {
            Schema<T> schema = getSchema(clazz);
            bytes = ProtostuffIOUtil.toByteArray(data, schema, BUFFER);
        } catch (Exception e) {
            logger.error("[ProtostuffUtil] serialize data exception: " + e.getMessage());
        } finally {
            BUFFER.clear();
        }
        return bytes;
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T deserializer(byte[] bytes, Class<T> clazz) {
        Schema<T> schema = getSchema(clazz);
        T object = schema.newMessage();
        try {
            ProtostuffIOUtil.mergeFrom(bytes, object, schema);
        } catch (Exception e) {
            logger.error("[ProtostuffUtil] deserializer data exception: " + e.getMessage());
        }
        return object;
    }

    /**
     * 缓存schema
     *
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> Schema<T> getSchema(Class<T> clazz) {
        Schema<T> schema = (Schema<T>) cachedSchema.get(clazz);
        if (schema == null) {
            schema = RuntimeSchema.createFrom(clazz);
            cachedSchema.put(clazz, schema);
        }
        return schema;
    }
}
