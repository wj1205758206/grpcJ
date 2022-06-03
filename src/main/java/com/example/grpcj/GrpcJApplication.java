package com.example.grpcj;

import com.example.grpcj.server.GrpcServer;
import com.example.grpcj.server.GrpcServerBootStrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GrpcJApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(GrpcJApplication.class, args);
        ApplicationContext context = GrpcServerBootStrap.getApplicationContext();
        final GrpcServer grpcServer = context.getBean(GrpcServer.class);
        grpcServer.start();
        grpcServer.waitAndStop();
    }
}
