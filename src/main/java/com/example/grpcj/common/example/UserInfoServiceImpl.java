package com.example.grpcj.common.example;

import com.example.grpcj.common.gen.UserInfo;
import com.example.grpcj.common.gen.UserInfoRequest;
import com.example.grpcj.common.gen.UserInfoResponse;
import com.example.grpcj.common.gen.UserInfoServicesGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Server端实现Client定义的方法
 */
public class UserInfoServiceImpl extends UserInfoServicesGrpc.UserInfoServicesImplBase {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private Map<Integer, UserInfo> userInfoMap = new HashMap<>(); // Server端用来存储所有user info

    public UserInfoServiceImpl() {
    }

    /**
     * 实现添加user info方法
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void addUserInfo(UserInfoRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        UserInfo userInfo = request.getUserInfo();
        logger.info("GrpcServer receive add user info request: "
                        + "id:{}, name,{}, age:{}, school:[address:{}, schoolName:{}]",
                userInfo.getId(), userInfo.getName(), userInfo.getAge(), userInfo.getSchool().getAddress(), userInfo.getSchool().getSchoolName());
        UserInfoResponse response = null;
        try {
            // 如果user已存在，则不进行添加
            if (userInfoMap.containsKey(userInfo.getId())) {
                logger.info("user info is existed, id: {}", userInfo.getId());
                response = UserInfoResponse.newBuilder()
                        .setStatusCode(500)
                        .setErrorMsg("this user is existed")
                        .setResult("")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            userInfoMap.put(userInfo.getId(), userInfo);
            logger.info("user info add success, id:{}", userInfo.getId());
            response = UserInfoResponse.newBuilder()
                    .setStatusCode(200)
                    .setErrorMsg("")
                    .setResult("this user add success")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            logger.error("add user info exception: " + e.getMessage());
        }
    }

    /**
     * 实现删除user info方法
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void deleteUserInfo(UserInfoRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        UserInfo userInfo = request.getUserInfo();
        logger.info("GrpcServer receive delete user info request: " + "id:{}", userInfo.getId());
        UserInfoResponse response = null;
        try {
            if (userInfoMap.containsKey(userInfo.getId())) {
                userInfoMap.remove(userInfo.getId());
                logger.info("delete user info, id:{}", userInfo.getId());
                response = UserInfoResponse.newBuilder()
                        .setStatusCode(200)
                        .setResult("delete success")
                        .setErrorMsg("")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            logger.warn("delete user info fail, user not exist");
            response = UserInfoResponse.newBuilder()
                    .setStatusCode(500)
                    .setResult("")
                    .setErrorMsg("user info not exist")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            logger.error("delete user info exception: " + e.getMessage());
        }
    }

    /**
     * 实现修改user info方法
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void updateUserInfo(UserInfoRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        UserInfo userInfo = request.getUserInfo();
        logger.info("GrpcServer receive update user info request: "
                        + "id:{}, name,{}, age:{}, school:[address:{}, schoolName:{}]",
                userInfo.getId(), userInfo.getName(), userInfo.getAge(), userInfo.getSchool().getAddress(), userInfo.getSchool().getSchoolName());
        UserInfoResponse response = null;
        try {
            if (userInfoMap.containsKey(userInfo.getId())) {
                userInfoMap.remove(userInfo.getId());
                userInfoMap.put(userInfo.getId(), userInfo);
                logger.info(" update user info success: "
                                + "id:{}, name,{}, age:{}, school:[address:{}, schoolName:{}]",
                        userInfo.getId(), userInfo.getName(), userInfo.getAge(), userInfo.getSchool().getAddress(), userInfo.getSchool().getSchoolName());
                response = UserInfoResponse.newBuilder()
                        .setStatusCode(200)
                        .setResult("update success")
                        .setErrorMsg("")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            logger.warn("update user info fail, user not exist, id:{}", userInfo.getId());
            response = UserInfoResponse.newBuilder()
                    .setStatusCode(500)
                    .setResult("")
                    .setErrorMsg("update user info fail, user not exist")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            logger.error("update user info exception: " + e.getMessage());
        }
    }

    /**
     * 实现获取user info方法
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void getUserInfo(UserInfoRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        UserInfo userInfo = request.getUserInfo();
        logger.info("GrpcServer receive get user info request: " + "id:{}", userInfo.getId());
        UserInfoResponse response = null;
        try {
            if (userInfoMap.containsKey(userInfo.getId())) {
                UserInfo user = userInfoMap.get(userInfo.getId());
                logger.info("get user info: ", user.toString());
                response = UserInfoResponse.newBuilder()
                        .setStatusCode(200)
                        .setResult(String.valueOf(user))
                        .setErrorMsg("")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            logger.warn("get user info fail, user not exist");
            response = UserInfoResponse.newBuilder()
                    .setStatusCode(500)
                    .setResult("")
                    .setErrorMsg("user info not exist")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            logger.error("delete user info exception: " + e.getMessage());
        }
    }
}
