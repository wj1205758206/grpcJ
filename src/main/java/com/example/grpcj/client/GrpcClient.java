package com.example.grpcj.client;

import com.example.grpcj.client.discovery.ZkNameResolverProvider;
import com.example.grpcj.common.configuration.GrpcClientConfig;
import com.example.grpcj.common.gen.*;
import com.example.grpcj.common.utils.ZkClient;
import com.example.grpcj.common.configuration.GrpcServerConfig;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * gRPC客户端,每个客户端都封装了channel和stub,实现复用
 */
@Component
public class GrpcClient {
    private static final Logger logger = LoggerFactory.getLogger(GrpcClient.class);

    @Resource
    private GrpcClientConfig grpcClientConfig;

    // 在gRPC官网中《最佳性能实践》章节建议复用channel和stub
    private ManagedChannel channel; // 定义一个channel
    private UserInfoServicesGrpc.UserInfoServicesBlockingStub blockingStub; // 定义一个阻塞式同步存根

    @PostConstruct
    public void initGrpcClient() {
        logger.info("load GrpcClientConfig: " + grpcClientConfig.toString());
        this.channel = ManagedChannelBuilder
                .forTarget(grpcClientConfig.getZkAddress()) // zk服务器地址
                .keepAliveTime(grpcClientConfig.getKeepAliveTime(), TimeUnit.SECONDS) // 设置channel保活 发送PING帧最小时间间隔，用来确定空闲连接是否仍然有效
                .keepAliveTimeout(grpcClientConfig.getKeepAliveTimeout(), TimeUnit.SECONDS) // 超过KeepAliveTimeout，关闭连接
                .keepAliveWithoutCalls(grpcClientConfig.isKeepAliveWithoutCalls()) // 即使没有请求进行，也可以发送keepalive ping
                .nameResolverFactory(new ZkNameResolverProvider()) // 服务发现配置
                .defaultLoadBalancingPolicy(grpcClientConfig.getLoadBalancingPolicy()) // 负载均衡，轮询策略
                .idleTimeout(grpcClientConfig.getIdleTimeout(), TimeUnit.MINUTES) // 空闲超时，将断开所有连接和nameResolver、LB
                .enableRetry() // 开启重试
                .maxRetryAttempts(grpcClientConfig.getMaxRetryAttempts()) // 最大重试次数
                .usePlaintext()
                .build();
        this.blockingStub = UserInfoServicesGrpc.newBlockingStub(channel).withCompression("gzip");
    }

    /**
     * 定义客户端addUserInfo方法
     *
     * @param userInfo
     */
    public boolean addUserInfo(UserInfo userInfo) {
        UserInfoRequest request = UserInfoRequest.newBuilder().setUserInfo(userInfo).build();
        UserInfoResponse response;
        try {
            response = blockingStub.addUserInfo(request);
        } catch (Exception e) {
            logger.error("GrpcClient call addUserInfo fail: " + e);
            return false;
        }
        if (response.getStatusCode() == 200) {
            logger.info("GrpcClient call addUserInfo success, response: " + response);
            return true;
        }
        return false;
    }

    /**
     * 定义客户端deleteUserInfo方法
     *
     * @param id
     * @return
     */
    public boolean deleteUserInfo(int id) {
        UserInfo userInfo = UserInfo.newBuilder()
                .setId(id)
                .build();
        UserInfoRequest request = UserInfoRequest.newBuilder().setUserInfo(userInfo).build();
        UserInfoResponse response;
        try {
            response = blockingStub.deleteUserInfo(request);
        } catch (Exception e) {
            logger.error("GrpcClient call deleteUserInfo fail: " + e.getMessage());
            return false;
        }
        if (response.getStatusCode() == 200) {
            logger.info("GrpcClient call deleteUserInfo success, response: " + response);
            return true;
        }
        return false;
    }

    /**
     * 定义客户端updateUserInfo方法
     *
     * @param id
     * @return
     */
    public boolean updateUserInfo(int id) {
        UserInfo userInfo = UserInfo.newBuilder()
                .setId(id)
                .build();
        UserInfoRequest request = UserInfoRequest.newBuilder().setUserInfo(userInfo).build();
        UserInfoResponse response;
        try {
            response = blockingStub.updateUserInfo(request);
        } catch (Exception e) {
            logger.error("GrpcClient call updateUserInfo fail: " + e.getMessage());
            return false;
        }
        if (response.getStatusCode() == 200) {
            logger.info("GrpcClient call updateUserInfo success, response: " + response);
            return true;
        }
        return false;
    }

    /**
     * 定义客户端getUserInfo方法
     *
     * @param id
     * @return
     */
    public String getUserInfo(int id) {
        UserInfo userInfo = UserInfo.newBuilder()
                .setId(id)
                .build();
        UserInfoRequest request = UserInfoRequest.newBuilder().setUserInfo(userInfo).build();
        UserInfoResponse response;
        try {
            response = blockingStub.getUserInfo(request);
        } catch (Exception e) {
            logger.error("GrpcClient call getUserInfo fail: " + e.getMessage());
            return null;
        }
        if (response.getStatusCode() == 200) {
            logger.info("GrpcClient call getUserInfo success, response: " + response);
            return response.getResult();
        }
        return null;
    }

    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            if (channel.isShutdown() || channel.isTerminated()) {
                logger.info("the channel has shutdown or terminated: " + channel.toString());
            }
        } catch (InterruptedException e) {
            logger.error("channel shutdown exception: " + e.getMessage());
        }
    }

    public ManagedChannel getChannel() {
        return channel;
    }

    public void setChannel(ManagedChannel channel) {
        this.channel = channel;
    }

    public UserInfoServicesGrpc.UserInfoServicesBlockingStub getBlockingStub() {
        return blockingStub;
    }

    public void setBlockingStub(UserInfoServicesGrpc.UserInfoServicesBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    @Override
    public String toString() {
        return "GrpcClient{" +
                "channel=" + channel +
                ", blockingStub=" + blockingStub +
                '}';
    }


}
