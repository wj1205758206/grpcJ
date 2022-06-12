package com.example.grpcj;

import com.example.grpcj.client.GrpcClient;
import com.example.grpcj.common.gen.School;
import com.example.grpcj.common.gen.UserInfo;
import com.example.grpcj.server.GrpcServer;
import com.example.grpcj.common.configuration.GrpcServerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class GrpcJApplicationTests {
    @Resource
    GrpcServer grpcServer;
    @Resource
    GrpcServerConfig grpcServerConfig;
    @Resource
    GrpcClient grpcClient;

    @Test
    public void test(){
        UserInfo user = UserInfo.newBuilder()
                .setId(1)
                .setName("张三")
                .setAge(12)
                .setSchool(School.newBuilder()
                        .setAddress("beijing")
                        .setSchoolName("北京大学")
                        .build())
                .build();

        System.out.println(user);
        boolean b = grpcClient.addUserInfo(user);
        System.out.println("-----" + b);
        String userInfo = grpcClient.getUserInfo(1);
        System.out.println(userInfo);
    }

}
