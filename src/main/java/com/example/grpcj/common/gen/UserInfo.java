// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserInfo.proto

package com.example.grpcj.common.gen;

/**
 * Protobuf type {@code UserInfo}
 */
public final class UserInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:UserInfo)
    UserInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UserInfo.newBuilder() to construct.
  private UserInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserInfo() {
    name_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new UserInfo();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UserInfo(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 24: {

            age_ = input.readInt32();
            break;
          }
          case 34: {
            School.Builder subBuilder = null;
            if (school_ != null) {
              subBuilder = school_.toBuilder();
            }
            school_ = input.readMessage(School.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(school_);
              school_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return UserInfoProto.internal_static_UserInfo_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return UserInfoProto.internal_static_UserInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            UserInfo.class, Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  @Override
  public int getId() {
    return id_;
  }

  public static final int NAME_FIELD_NUMBER = 2;
  private volatile Object name_;
  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  @Override
  public String getName() {
    Object ref = name_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  @Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    Object ref = name_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AGE_FIELD_NUMBER = 3;
  private int age_;
  /**
   * <code>int32 age = 3;</code>
   * @return The age.
   */
  @Override
  public int getAge() {
    return age_;
  }

  public static final int SCHOOL_FIELD_NUMBER = 4;
  private School school_;
  /**
   * <code>.School school = 4;</code>
   * @return Whether the school field is set.
   */
  @Override
  public boolean hasSchool() {
    return school_ != null;
  }
  /**
   * <code>.School school = 4;</code>
   * @return The school.
   */
  @Override
  public School getSchool() {
    return school_ == null ? School.getDefaultInstance() : school_;
  }
  /**
   * <code>.School school = 4;</code>
   */
  @Override
  public SchoolOrBuilder getSchoolOrBuilder() {
    return getSchool();
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
    }
    if (age_ != 0) {
      output.writeInt32(3, age_);
    }
    if (school_ != null) {
      output.writeMessage(4, getSchool());
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
    }
    if (age_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, age_);
    }
    if (school_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getSchool());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof UserInfo)) {
      return super.equals(obj);
    }
    UserInfo other = (UserInfo) obj;

    if (getId()
        != other.getId()) return false;
    if (!getName()
        .equals(other.getName())) return false;
    if (getAge()
        != other.getAge()) return false;
    if (hasSchool() != other.hasSchool()) return false;
    if (hasSchool()) {
      if (!getSchool()
          .equals(other.getSchool())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + AGE_FIELD_NUMBER;
    hash = (53 * hash) + getAge();
    if (hasSchool()) {
      hash = (37 * hash) + SCHOOL_FIELD_NUMBER;
      hash = (53 * hash) + getSchool().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static UserInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UserInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UserInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UserInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UserInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UserInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UserInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static UserInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static UserInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static UserInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static UserInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static UserInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(UserInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code UserInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:UserInfo)
      UserInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return UserInfoProto.internal_static_UserInfo_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return UserInfoProto.internal_static_UserInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              UserInfo.class, Builder.class);
    }

    // Construct using com.example.grpcj.common.gen.UserInfo.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      id_ = 0;

      name_ = "";

      age_ = 0;

      if (schoolBuilder_ == null) {
        school_ = null;
      } else {
        school_ = null;
        schoolBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return UserInfoProto.internal_static_UserInfo_descriptor;
    }

    @Override
    public UserInfo getDefaultInstanceForType() {
      return UserInfo.getDefaultInstance();
    }

    @Override
    public UserInfo build() {
      UserInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public UserInfo buildPartial() {
      UserInfo result = new UserInfo(this);
      result.id_ = id_;
      result.name_ = name_;
      result.age_ = age_;
      if (schoolBuilder_ == null) {
        result.school_ = school_;
      } else {
        result.school_ = schoolBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof UserInfo) {
        return mergeFrom((UserInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(UserInfo other) {
      if (other == UserInfo.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.getAge() != 0) {
        setAge(other.getAge());
      }
      if (other.hasSchool()) {
        mergeSchool(other.getSchool());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      UserInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (UserInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int id_ ;
    /**
     * <code>int32 id = 1;</code>
     * @return The id.
     */
    @Override
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private Object name_ = "";
    /**
     * <code>string name = 2;</code>
     * @return The name.
     */
    public String getName() {
      Object ref = name_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private int age_ ;
    /**
     * <code>int32 age = 3;</code>
     * @return The age.
     */
    @Override
    public int getAge() {
      return age_;
    }
    /**
     * <code>int32 age = 3;</code>
     * @param value The age to set.
     * @return This builder for chaining.
     */
    public Builder setAge(int value) {
      
      age_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 age = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAge() {
      
      age_ = 0;
      onChanged();
      return this;
    }

    private School school_;
    private com.google.protobuf.SingleFieldBuilderV3<
        School, School.Builder, SchoolOrBuilder> schoolBuilder_;
    /**
     * <code>.School school = 4;</code>
     * @return Whether the school field is set.
     */
    public boolean hasSchool() {
      return schoolBuilder_ != null || school_ != null;
    }
    /**
     * <code>.School school = 4;</code>
     * @return The school.
     */
    public School getSchool() {
      if (schoolBuilder_ == null) {
        return school_ == null ? School.getDefaultInstance() : school_;
      } else {
        return schoolBuilder_.getMessage();
      }
    }
    /**
     * <code>.School school = 4;</code>
     */
    public Builder setSchool(School value) {
      if (schoolBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        school_ = value;
        onChanged();
      } else {
        schoolBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.School school = 4;</code>
     */
    public Builder setSchool(
        School.Builder builderForValue) {
      if (schoolBuilder_ == null) {
        school_ = builderForValue.build();
        onChanged();
      } else {
        schoolBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.School school = 4;</code>
     */
    public Builder mergeSchool(School value) {
      if (schoolBuilder_ == null) {
        if (school_ != null) {
          school_ =
            School.newBuilder(school_).mergeFrom(value).buildPartial();
        } else {
          school_ = value;
        }
        onChanged();
      } else {
        schoolBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.School school = 4;</code>
     */
    public Builder clearSchool() {
      if (schoolBuilder_ == null) {
        school_ = null;
        onChanged();
      } else {
        school_ = null;
        schoolBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.School school = 4;</code>
     */
    public School.Builder getSchoolBuilder() {
      
      onChanged();
      return getSchoolFieldBuilder().getBuilder();
    }
    /**
     * <code>.School school = 4;</code>
     */
    public SchoolOrBuilder getSchoolOrBuilder() {
      if (schoolBuilder_ != null) {
        return schoolBuilder_.getMessageOrBuilder();
      } else {
        return school_ == null ?
            School.getDefaultInstance() : school_;
      }
    }
    /**
     * <code>.School school = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        School, School.Builder, SchoolOrBuilder>
        getSchoolFieldBuilder() {
      if (schoolBuilder_ == null) {
        schoolBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            School, School.Builder, SchoolOrBuilder>(
                getSchool(),
                getParentForChildren(),
                isClean());
        school_ = null;
      }
      return schoolBuilder_;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:UserInfo)
  }

  // @@protoc_insertion_point(class_scope:UserInfo)
  private static final UserInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new UserInfo();
  }

  public static UserInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserInfo>
      PARSER = new com.google.protobuf.AbstractParser<UserInfo>() {
    @Override
    public UserInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UserInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserInfo> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<UserInfo> getParserForType() {
    return PARSER;
  }

  @Override
  public UserInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
