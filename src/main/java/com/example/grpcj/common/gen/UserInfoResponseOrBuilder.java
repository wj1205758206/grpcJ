// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserInfo.proto

package com.example.grpcj.common.gen;

public interface UserInfoResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:UserInfoResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 statusCode = 1;</code>
   * @return The statusCode.
   */
  int getStatusCode();

  /**
   * <code>string errorMsg = 2;</code>
   * @return The errorMsg.
   */
  String getErrorMsg();
  /**
   * <code>string errorMsg = 2;</code>
   * @return The bytes for errorMsg.
   */
  com.google.protobuf.ByteString
      getErrorMsgBytes();

  /**
   * <code>string result = 3;</code>
   * @return The result.
   */
  String getResult();
  /**
   * <code>string result = 3;</code>
   * @return The bytes for result.
   */
  com.google.protobuf.ByteString
      getResultBytes();
}
