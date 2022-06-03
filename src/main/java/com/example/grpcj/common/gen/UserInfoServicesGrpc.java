package com.example.grpcj.common.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * userInfo服务: 增删改查
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: UserInfo.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserInfoServicesGrpc {

  private UserInfoServicesGrpc() {}

  public static final String SERVICE_NAME = "UserInfoServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest,
      com.example.grpcj.common.gen.UserInfoResponse> getAddUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddUserInfo",
      requestType = com.example.grpcj.common.gen.UserInfoRequest.class,
      responseType = com.example.grpcj.common.gen.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest,
      com.example.grpcj.common.gen.UserInfoResponse> getAddUserInfoMethod() {
    io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest, com.example.grpcj.common.gen.UserInfoResponse> getAddUserInfoMethod;
    if ((getAddUserInfoMethod = UserInfoServicesGrpc.getAddUserInfoMethod) == null) {
      synchronized (UserInfoServicesGrpc.class) {
        if ((getAddUserInfoMethod = UserInfoServicesGrpc.getAddUserInfoMethod) == null) {
          UserInfoServicesGrpc.getAddUserInfoMethod = getAddUserInfoMethod =
              io.grpc.MethodDescriptor.<com.example.grpcj.common.gen.UserInfoRequest, com.example.grpcj.common.gen.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcj.common.gen.UserInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcj.common.gen.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserInfoServicesMethodDescriptorSupplier("AddUserInfo"))
              .build();
        }
      }
    }
    return getAddUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest,
      com.example.grpcj.common.gen.UserInfoResponse> getDeleteUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUserInfo",
      requestType = com.example.grpcj.common.gen.UserInfoRequest.class,
      responseType = com.example.grpcj.common.gen.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest,
      com.example.grpcj.common.gen.UserInfoResponse> getDeleteUserInfoMethod() {
    io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest, com.example.grpcj.common.gen.UserInfoResponse> getDeleteUserInfoMethod;
    if ((getDeleteUserInfoMethod = UserInfoServicesGrpc.getDeleteUserInfoMethod) == null) {
      synchronized (UserInfoServicesGrpc.class) {
        if ((getDeleteUserInfoMethod = UserInfoServicesGrpc.getDeleteUserInfoMethod) == null) {
          UserInfoServicesGrpc.getDeleteUserInfoMethod = getDeleteUserInfoMethod =
              io.grpc.MethodDescriptor.<com.example.grpcj.common.gen.UserInfoRequest, com.example.grpcj.common.gen.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcj.common.gen.UserInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcj.common.gen.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserInfoServicesMethodDescriptorSupplier("DeleteUserInfo"))
              .build();
        }
      }
    }
    return getDeleteUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest,
      com.example.grpcj.common.gen.UserInfoResponse> getUpdateUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserInfo",
      requestType = com.example.grpcj.common.gen.UserInfoRequest.class,
      responseType = com.example.grpcj.common.gen.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest,
      com.example.grpcj.common.gen.UserInfoResponse> getUpdateUserInfoMethod() {
    io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest, com.example.grpcj.common.gen.UserInfoResponse> getUpdateUserInfoMethod;
    if ((getUpdateUserInfoMethod = UserInfoServicesGrpc.getUpdateUserInfoMethod) == null) {
      synchronized (UserInfoServicesGrpc.class) {
        if ((getUpdateUserInfoMethod = UserInfoServicesGrpc.getUpdateUserInfoMethod) == null) {
          UserInfoServicesGrpc.getUpdateUserInfoMethod = getUpdateUserInfoMethod =
              io.grpc.MethodDescriptor.<com.example.grpcj.common.gen.UserInfoRequest, com.example.grpcj.common.gen.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcj.common.gen.UserInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcj.common.gen.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserInfoServicesMethodDescriptorSupplier("UpdateUserInfo"))
              .build();
        }
      }
    }
    return getUpdateUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest,
      com.example.grpcj.common.gen.UserInfoResponse> getGetUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserInfo",
      requestType = com.example.grpcj.common.gen.UserInfoRequest.class,
      responseType = com.example.grpcj.common.gen.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest,
      com.example.grpcj.common.gen.UserInfoResponse> getGetUserInfoMethod() {
    io.grpc.MethodDescriptor<com.example.grpcj.common.gen.UserInfoRequest, com.example.grpcj.common.gen.UserInfoResponse> getGetUserInfoMethod;
    if ((getGetUserInfoMethod = UserInfoServicesGrpc.getGetUserInfoMethod) == null) {
      synchronized (UserInfoServicesGrpc.class) {
        if ((getGetUserInfoMethod = UserInfoServicesGrpc.getGetUserInfoMethod) == null) {
          UserInfoServicesGrpc.getGetUserInfoMethod = getGetUserInfoMethod =
              io.grpc.MethodDescriptor.<com.example.grpcj.common.gen.UserInfoRequest, com.example.grpcj.common.gen.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcj.common.gen.UserInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcj.common.gen.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserInfoServicesMethodDescriptorSupplier("GetUserInfo"))
              .build();
        }
      }
    }
    return getGetUserInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserInfoServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserInfoServicesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserInfoServicesStub>() {
        @Override
        public UserInfoServicesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserInfoServicesStub(channel, callOptions);
        }
      };
    return UserInfoServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserInfoServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserInfoServicesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserInfoServicesBlockingStub>() {
        @Override
        public UserInfoServicesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserInfoServicesBlockingStub(channel, callOptions);
        }
      };
    return UserInfoServicesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserInfoServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserInfoServicesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserInfoServicesFutureStub>() {
        @Override
        public UserInfoServicesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserInfoServicesFutureStub(channel, callOptions);
        }
      };
    return UserInfoServicesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * userInfo服务: 增删改查
   * </pre>
   */
  public static abstract class UserInfoServicesImplBase implements io.grpc.BindableService {

    /**
     */
    public void addUserInfo(com.example.grpcj.common.gen.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddUserInfoMethod(), responseObserver);
    }

    /**
     */
    public void deleteUserInfo(com.example.grpcj.common.gen.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserInfoMethod(), responseObserver);
    }

    /**
     */
    public void updateUserInfo(com.example.grpcj.common.gen.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserInfoMethod(), responseObserver);
    }

    /**
     */
    public void getUserInfo(com.example.grpcj.common.gen.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserInfoMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddUserInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpcj.common.gen.UserInfoRequest,
                com.example.grpcj.common.gen.UserInfoResponse>(
                  this, METHODID_ADD_USER_INFO)))
          .addMethod(
            getDeleteUserInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpcj.common.gen.UserInfoRequest,
                com.example.grpcj.common.gen.UserInfoResponse>(
                  this, METHODID_DELETE_USER_INFO)))
          .addMethod(
            getUpdateUserInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpcj.common.gen.UserInfoRequest,
                com.example.grpcj.common.gen.UserInfoResponse>(
                  this, METHODID_UPDATE_USER_INFO)))
          .addMethod(
            getGetUserInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpcj.common.gen.UserInfoRequest,
                com.example.grpcj.common.gen.UserInfoResponse>(
                  this, METHODID_GET_USER_INFO)))
          .build();
    }
  }

  /**
   * <pre>
   * userInfo服务: 增删改查
   * </pre>
   */
  public static final class UserInfoServicesStub extends io.grpc.stub.AbstractAsyncStub<UserInfoServicesStub> {
    private UserInfoServicesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserInfoServicesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserInfoServicesStub(channel, callOptions);
    }

    /**
     */
    public void addUserInfo(com.example.grpcj.common.gen.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUserInfo(com.example.grpcj.common.gen.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUserInfo(com.example.grpcj.common.gen.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserInfo(com.example.grpcj.common.gen.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * userInfo服务: 增删改查
   * </pre>
   */
  public static final class UserInfoServicesBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserInfoServicesBlockingStub> {
    private UserInfoServicesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserInfoServicesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserInfoServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpcj.common.gen.UserInfoResponse addUserInfo(com.example.grpcj.common.gen.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddUserInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpcj.common.gen.UserInfoResponse deleteUserInfo(com.example.grpcj.common.gen.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpcj.common.gen.UserInfoResponse updateUserInfo(com.example.grpcj.common.gen.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpcj.common.gen.UserInfoResponse getUserInfo(com.example.grpcj.common.gen.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * userInfo服务: 增删改查
   * </pre>
   */
  public static final class UserInfoServicesFutureStub extends io.grpc.stub.AbstractFutureStub<UserInfoServicesFutureStub> {
    private UserInfoServicesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserInfoServicesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserInfoServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpcj.common.gen.UserInfoResponse> addUserInfo(
        com.example.grpcj.common.gen.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddUserInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpcj.common.gen.UserInfoResponse> deleteUserInfo(
        com.example.grpcj.common.gen.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpcj.common.gen.UserInfoResponse> updateUserInfo(
        com.example.grpcj.common.gen.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpcj.common.gen.UserInfoResponse> getUserInfo(
        com.example.grpcj.common.gen.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_USER_INFO = 0;
  private static final int METHODID_DELETE_USER_INFO = 1;
  private static final int METHODID_UPDATE_USER_INFO = 2;
  private static final int METHODID_GET_USER_INFO = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserInfoServicesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserInfoServicesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_USER_INFO:
          serviceImpl.addUserInfo((com.example.grpcj.common.gen.UserInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse>) responseObserver);
          break;
        case METHODID_DELETE_USER_INFO:
          serviceImpl.deleteUserInfo((com.example.grpcj.common.gen.UserInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER_INFO:
          serviceImpl.updateUserInfo((com.example.grpcj.common.gen.UserInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse>) responseObserver);
          break;
        case METHODID_GET_USER_INFO:
          serviceImpl.getUserInfo((com.example.grpcj.common.gen.UserInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpcj.common.gen.UserInfoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserInfoServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserInfoServicesBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpcj.common.gen.UserInfoProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserInfoServices");
    }
  }

  private static final class UserInfoServicesFileDescriptorSupplier
      extends UserInfoServicesBaseDescriptorSupplier {
    UserInfoServicesFileDescriptorSupplier() {}
  }

  private static final class UserInfoServicesMethodDescriptorSupplier
      extends UserInfoServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserInfoServicesMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserInfoServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserInfoServicesFileDescriptorSupplier())
              .addMethod(getAddUserInfoMethod())
              .addMethod(getDeleteUserInfoMethod())
              .addMethod(getUpdateUserInfoMethod())
              .addMethod(getGetUserInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
