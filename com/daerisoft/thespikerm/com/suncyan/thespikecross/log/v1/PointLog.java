package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class PointLog extends GeneratedMessage implements PointLogOrBuilder {
    private static final PointLog DEFAULT_INSTANCE;
    private static final Parser<PointLog> PARSER;
    public static final int POINT_COMMON_DATA_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private PointCommonData pointCommonData_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", PointLog.class.getName());
        DEFAULT_INSTANCE = new PointLog();
        PARSER = new AbstractParser<PointLog>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointLog.1
            @Override // com.google.protobuf.Parser
            public PointLog parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = PointLog.newBuilder();
                try {
                    builderNewBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return builderNewBuilder.buildPartial();
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(builderNewBuilder.buildPartial());
                } catch (UninitializedMessageException e2) {
                    throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(builderNewBuilder.buildPartial());
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(builderNewBuilder.buildPartial());
                }
            }
        };
    }

    public static /* synthetic */ int access$576(PointLog pointLog, int i) {
        int i2 = i | pointLog.bitField0_;
        pointLog.bitField0_ = i2;
        return i2;
    }

    public static PointLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PointLog_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PointLog parseDelimitedFrom(InputStream inputStream) {
        return (PointLog) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PointLog parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<PointLog> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PointLog)) {
            return super.equals(obj);
        }
        PointLog pointLog = (PointLog) obj;
        if (hasPointCommonData() != pointLog.hasPointCommonData()) {
            return false;
        }
        return (!hasPointCommonData() || getPointCommonData().equals(pointLog.getPointCommonData())) && getUnknownFields().equals(pointLog.getUnknownFields());
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PointLog> getParserForType() {
        return PARSER;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointLogOrBuilder
    public PointCommonData getPointCommonData() {
        PointCommonData pointCommonData = this.pointCommonData_;
        return pointCommonData == null ? PointCommonData.getDefaultInstance() : pointCommonData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointLogOrBuilder
    public PointCommonDataOrBuilder getPointCommonDataOrBuilder() {
        PointCommonData pointCommonData = this.pointCommonData_;
        return pointCommonData == null ? PointCommonData.getDefaultInstance() : pointCommonData;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int serializedSize = getUnknownFields().getSerializedSize() + ((this.bitField0_ & 1) != 0 ? CodedOutputStream.computeMessageSize(1, getPointCommonData()) : 0);
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointLogOrBuilder
    public boolean hasPointCommonData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getDescriptor().hashCode() + 779;
        if (hasPointCommonData()) {
            iHashCode = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 1, 53) + getPointCommonData().hashCode();
        }
        int iHashCode2 = getUnknownFields().hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PointLog_fieldAccessorTable.ensureFieldAccessorsInitialized(PointLog.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(1, getPointCommonData());
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PointLogOrBuilder {
        private int bitField0_;
        private SingleFieldBuilder<PointCommonData, PointCommonData.Builder, PointCommonDataOrBuilder> pointCommonDataBuilder_;
        private PointCommonData pointCommonData_;

        private void buildPartial0(PointLog pointLog) {
            int i = 1;
            if ((this.bitField0_ & 1) != 0) {
                SingleFieldBuilder<PointCommonData, PointCommonData.Builder, PointCommonDataOrBuilder> singleFieldBuilder = this.pointCommonDataBuilder_;
                pointLog.pointCommonData_ = singleFieldBuilder == null ? this.pointCommonData_ : (PointCommonData) singleFieldBuilder.build();
            } else {
                i = 0;
            }
            PointLog.access$576(pointLog, i);
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PointLog_descriptor;
        }

        private SingleFieldBuilder<PointCommonData, PointCommonData.Builder, PointCommonDataOrBuilder> getPointCommonDataFieldBuilder() {
            if (this.pointCommonDataBuilder_ == null) {
                this.pointCommonDataBuilder_ = new SingleFieldBuilder<>(getPointCommonData(), getParentForChildren(), isClean());
                this.pointCommonData_ = null;
            }
            return this.pointCommonDataBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getPointCommonDataFieldBuilder();
            }
        }

        public Builder clearPointCommonData() {
            this.bitField0_ &= -2;
            this.pointCommonData_ = null;
            SingleFieldBuilder<PointCommonData, PointCommonData.Builder, PointCommonDataOrBuilder> singleFieldBuilder = this.pointCommonDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.pointCommonDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PointLog_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointLogOrBuilder
        public PointCommonData getPointCommonData() {
            SingleFieldBuilder<PointCommonData, PointCommonData.Builder, PointCommonDataOrBuilder> singleFieldBuilder = this.pointCommonDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PointCommonData) singleFieldBuilder.getMessage();
            }
            PointCommonData pointCommonData = this.pointCommonData_;
            return pointCommonData == null ? PointCommonData.getDefaultInstance() : pointCommonData;
        }

        public PointCommonData.Builder getPointCommonDataBuilder() {
            this.bitField0_ |= 1;
            onChanged();
            return (PointCommonData.Builder) getPointCommonDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointLogOrBuilder
        public PointCommonDataOrBuilder getPointCommonDataOrBuilder() {
            SingleFieldBuilder<PointCommonData, PointCommonData.Builder, PointCommonDataOrBuilder> singleFieldBuilder = this.pointCommonDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PointCommonDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PointCommonData pointCommonData = this.pointCommonData_;
            return pointCommonData == null ? PointCommonData.getDefaultInstance() : pointCommonData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PointLogOrBuilder
        public boolean hasPointCommonData() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PointLog_fieldAccessorTable.ensureFieldAccessorsInitialized(PointLog.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergePointCommonData(PointCommonData pointCommonData) {
            PointCommonData pointCommonData2;
            SingleFieldBuilder<PointCommonData, PointCommonData.Builder, PointCommonDataOrBuilder> singleFieldBuilder = this.pointCommonDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(pointCommonData);
            } else if ((this.bitField0_ & 1) == 0 || (pointCommonData2 = this.pointCommonData_) == null || pointCommonData2 == PointCommonData.getDefaultInstance()) {
                this.pointCommonData_ = pointCommonData;
            } else {
                getPointCommonDataBuilder().mergeFrom(pointCommonData);
            }
            if (this.pointCommonData_ != null) {
                this.bitField0_ |= 1;
                onChanged();
            }
            return this;
        }

        public Builder setPointCommonData(PointCommonData pointCommonData) {
            SingleFieldBuilder<PointCommonData, PointCommonData.Builder, PointCommonDataOrBuilder> singleFieldBuilder = this.pointCommonDataBuilder_;
            if (singleFieldBuilder == null) {
                pointCommonData.getClass();
                this.pointCommonData_ = pointCommonData;
            } else {
                singleFieldBuilder.setMessage(pointCommonData);
            }
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PointLog build() {
            PointLog pointLogBuildPartial = buildPartial();
            if (pointLogBuildPartial.isInitialized()) {
                return pointLogBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) pointLogBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PointLog buildPartial() {
            PointLog pointLog = new PointLog(this);
            if (this.bitField0_ != 0) {
                buildPartial0(pointLog);
            }
            onBuilt();
            return pointLog;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PointLog getDefaultInstanceForType() {
            return PointLog.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.pointCommonData_ = null;
            SingleFieldBuilder<PointCommonData, PointCommonData.Builder, PointCommonDataOrBuilder> singleFieldBuilder = this.pointCommonDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.pointCommonDataBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PointLog) {
                return mergeFrom((PointLog) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setPointCommonData(PointCommonData.Builder builder) {
            SingleFieldBuilder<PointCommonData, PointCommonData.Builder, PointCommonDataOrBuilder> singleFieldBuilder = this.pointCommonDataBuilder_;
            if (singleFieldBuilder == null) {
                this.pointCommonData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder mergeFrom(PointLog pointLog) {
            if (pointLog == PointLog.getDefaultInstance()) {
                return this;
            }
            if (pointLog.hasPointCommonData()) {
                mergePointCommonData(pointLog.getPointCommonData());
            }
            mergeUnknownFields(pointLog.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag != 10) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                codedInputStream.readMessage(getPointCommonDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 1;
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    onChanged();
                    throw th;
                }
            }
            onChanged();
            return this;
        }
    }

    private PointLog(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(PointLog pointLog) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(pointLog);
    }

    public static PointLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PointLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PointLog) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PointLog parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PointLog getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    private PointLog() {
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PointLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static PointLog parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static PointLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PointLog parseFrom(InputStream inputStream) {
        return (PointLog) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PointLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PointLog) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PointLog parseFrom(CodedInputStream codedInputStream) {
        return (PointLog) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PointLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PointLog) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
