package com.example.grpcj.server;

import com.example.grpcj.common.example.UserInfoServiceImpl;
import com.example.grpcj.common.configuration.GrpcServerConfig;
import com.example.grpcj.common.utils.ZkClient;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GrpcServer {
    private static final Logger logger = LoggerFactory.getLogger(GrpcServer.class);

    private Server server;
    @Resource
    private ZkClient zkClient;
    @Resource
    private GrpcServerConfig grpcServerConfig;

    public void start() {
        logger.info("GrpcServer is starting");
        try {
            server = ServerBuilder.forPort(grpcServerConfig.getPort())
                    .addService(new UserInfoServiceImpl())
                    .build()
                    .start();
            logger.info("GrpcServer is started");
        } catch (Exception e) {
            logger.error("GrpcServer start exception: " + e.getMessage());
        }
        // grpc server启动成功之后，将服务注册到zk
        boolean register = zkClient.register(grpcServerConfig.getHost(), grpcServerConfig.getPort());
        if (register) {
            logger.info("GrpcServer service register success, host:{},port:{}", grpcServerConfig.getHost(), grpcServerConfig.getPort());
        } else {
            logger.error("GrpcServer service register fail, host:{},port:{}", grpcServerConfig.getHost(), grpcServerConfig.getPort());
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            gracefulShutdown();
            logger.info("GrpcServer is shutdown");
        }));
    }

    public void gracefulShutdown() {
        if (server != null && !server.isShutdown()) {
            try {
                server.shutdown();
            } catch (Exception e) {
                logger.error("gracefulShutdown exception: " + e.getMessage());
            }
        }
    }

    public void waitAndStop() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
