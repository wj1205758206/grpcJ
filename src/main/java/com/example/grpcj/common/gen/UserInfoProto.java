// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserInfo.proto

package com.example.grpcj.common.gen;

public final class UserInfoProto {
  private UserInfoProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_School_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_School_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserInfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserInfoResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\016UserInfo.proto\"J\n\010UserInfo\022\n\n\002id\030\001 \001(\005" +
      "\022\014\n\004name\030\002 \001(\t\022\013\n\003age\030\003 \001(\005\022\027\n\006school\030\004 " +
      "\001(\0132\007.School\"-\n\006School\022\017\n\007address\030\001 \001(\t\022" +
      "\022\n\nschoolName\030\002 \001(\t\".\n\017UserInfoRequest\022\033" +
      "\n\010userInfo\030\001 \001(\0132\t.UserInfo\"H\n\020UserInfoR" +
      "esponse\022\022\n\nstatusCode\030\001 \001(\005\022\020\n\010errorMsg\030" +
      "\002 \001(\t\022\016\n\006result\030\003 \001(\t2\360\001\n\020UserInfoServic" +
      "es\0224\n\013AddUserInfo\022\020.UserInfoRequest\032\021.Us" +
      "erInfoResponse\"\000\0227\n\016DeleteUserInfo\022\020.Use" +
      "rInfoRequest\032\021.UserInfoResponse\"\000\0227\n\016Upd" +
      "ateUserInfo\022\020.UserInfoRequest\032\021.UserInfo" +
      "Response\"\000\0224\n\013GetUserInfo\022\020.UserInfoRequ" +
      "est\032\021.UserInfoResponse\"\000B/\n\034com.example." +
      "grpcj.common.genB\rUserInfoProtoP\001b\006proto" +
      "3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_UserInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_UserInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserInfo_descriptor,
        new String[] { "Id", "Name", "Age", "School", });
    internal_static_School_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_School_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_School_descriptor,
        new String[] { "Address", "SchoolName", });
    internal_static_UserInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_UserInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserInfoRequest_descriptor,
        new String[] { "UserInfo", });
    internal_static_UserInfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_UserInfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserInfoResponse_descriptor,
        new String[] { "StatusCode", "ErrorMsg", "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
