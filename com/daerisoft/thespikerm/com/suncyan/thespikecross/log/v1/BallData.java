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
public final class BallData extends GeneratedMessage implements BallDataOrBuilder {
    public static final int BALL_PHYS_DATA_FIELD_NUMBER = 2;
    public static final int BALL_STATE_FIELD_NUMBER = 1;
    private static final BallData DEFAULT_INSTANCE;
    private static final Parser<BallData> PARSER;
    private static final long serialVersionUID = 0;
    private BallPhysData ballPhysData_;
    private int ballState_;
    private int bitField0_;
    private byte memoizedIsInitialized;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", BallData.class.getName());
        DEFAULT_INSTANCE = new BallData();
        PARSER = new AbstractParser<BallData>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallData.1
            @Override // com.google.protobuf.Parser
            public BallData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = BallData.newBuilder();
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

    public static /* synthetic */ int access$676(BallData ballData, int i) {
        int i2 = i | ballData.bitField0_;
        ballData.bitField0_ = i2;
        return i2;
    }

    public static BallData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_BallData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BallData parseDelimitedFrom(InputStream inputStream) {
        return (BallData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static BallData parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<BallData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BallData)) {
            return super.equals(obj);
        }
        BallData ballData = (BallData) obj;
        if (this.ballState_ == ballData.ballState_ && hasBallPhysData() == ballData.hasBallPhysData()) {
            return (!hasBallPhysData() || getBallPhysData().equals(ballData.getBallPhysData())) && getUnknownFields().equals(ballData.getUnknownFields());
        }
        return false;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallDataOrBuilder
    public BallPhysData getBallPhysData() {
        BallPhysData ballPhysData = this.ballPhysData_;
        return ballPhysData == null ? BallPhysData.getDefaultInstance() : ballPhysData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallDataOrBuilder
    public BallPhysDataOrBuilder getBallPhysDataOrBuilder() {
        BallPhysData ballPhysData = this.ballPhysData_;
        return ballPhysData == null ? BallPhysData.getDefaultInstance() : ballPhysData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallDataOrBuilder
    public BallState getBallState() {
        BallState ballStateForNumber = BallState.forNumber(this.ballState_);
        return ballStateForNumber == null ? BallState.UNRECOGNIZED : ballStateForNumber;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallDataOrBuilder
    public int getBallStateValue() {
        return this.ballState_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<BallData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeEnumSize = this.ballState_ != BallState.STAT_NORMAL.getNumber() ? CodedOutputStream.computeEnumSize(1, this.ballState_) : 0;
        if ((this.bitField0_ & 1) != 0) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(2, getBallPhysData());
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeEnumSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallDataOrBuilder
    public boolean hasBallPhysData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + this.ballState_;
        if (hasBallPhysData()) {
            iHashCode = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 2, 53) + getBallPhysData().hashCode();
        }
        int iHashCode2 = getUnknownFields().hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_BallData_fieldAccessorTable.ensureFieldAccessorsInitialized(BallData.class, Builder.class);
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
        if (this.ballState_ != BallState.STAT_NORMAL.getNumber()) {
            codedOutputStream.writeEnum(1, this.ballState_);
        }
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(2, getBallPhysData());
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements BallDataOrBuilder {
        private SingleFieldBuilder<BallPhysData, BallPhysData.Builder, BallPhysDataOrBuilder> ballPhysDataBuilder_;
        private BallPhysData ballPhysData_;
        private int ballState_;
        private int bitField0_;

        private void buildPartial0(BallData ballData) {
            int i;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                ballData.ballState_ = this.ballState_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<BallPhysData, BallPhysData.Builder, BallPhysDataOrBuilder> singleFieldBuilder = this.ballPhysDataBuilder_;
                ballData.ballPhysData_ = singleFieldBuilder == null ? this.ballPhysData_ : (BallPhysData) singleFieldBuilder.build();
                i = 1;
            } else {
                i = 0;
            }
            BallData.access$676(ballData, i);
        }

        private SingleFieldBuilder<BallPhysData, BallPhysData.Builder, BallPhysDataOrBuilder> getBallPhysDataFieldBuilder() {
            if (this.ballPhysDataBuilder_ == null) {
                this.ballPhysDataBuilder_ = new SingleFieldBuilder<>(getBallPhysData(), getParentForChildren(), isClean());
                this.ballPhysData_ = null;
            }
            return this.ballPhysDataBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_BallData_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getBallPhysDataFieldBuilder();
            }
        }

        public Builder clearBallPhysData() {
            this.bitField0_ &= -3;
            this.ballPhysData_ = null;
            SingleFieldBuilder<BallPhysData, BallPhysData.Builder, BallPhysDataOrBuilder> singleFieldBuilder = this.ballPhysDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.ballPhysDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearBallState() {
            this.bitField0_ &= -2;
            this.ballState_ = 0;
            onChanged();
            return this;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallDataOrBuilder
        public BallPhysData getBallPhysData() {
            SingleFieldBuilder<BallPhysData, BallPhysData.Builder, BallPhysDataOrBuilder> singleFieldBuilder = this.ballPhysDataBuilder_;
            if (singleFieldBuilder != null) {
                return (BallPhysData) singleFieldBuilder.getMessage();
            }
            BallPhysData ballPhysData = this.ballPhysData_;
            return ballPhysData == null ? BallPhysData.getDefaultInstance() : ballPhysData;
        }

        public BallPhysData.Builder getBallPhysDataBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (BallPhysData.Builder) getBallPhysDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallDataOrBuilder
        public BallPhysDataOrBuilder getBallPhysDataOrBuilder() {
            SingleFieldBuilder<BallPhysData, BallPhysData.Builder, BallPhysDataOrBuilder> singleFieldBuilder = this.ballPhysDataBuilder_;
            if (singleFieldBuilder != null) {
                return (BallPhysDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            BallPhysData ballPhysData = this.ballPhysData_;
            return ballPhysData == null ? BallPhysData.getDefaultInstance() : ballPhysData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallDataOrBuilder
        public BallState getBallState() {
            BallState ballStateForNumber = BallState.forNumber(this.ballState_);
            return ballStateForNumber == null ? BallState.UNRECOGNIZED : ballStateForNumber;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallDataOrBuilder
        public int getBallStateValue() {
            return this.ballState_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_BallData_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallDataOrBuilder
        public boolean hasBallPhysData() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_BallData_fieldAccessorTable.ensureFieldAccessorsInitialized(BallData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeBallPhysData(BallPhysData ballPhysData) {
            BallPhysData ballPhysData2;
            SingleFieldBuilder<BallPhysData, BallPhysData.Builder, BallPhysDataOrBuilder> singleFieldBuilder = this.ballPhysDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(ballPhysData);
            } else if ((this.bitField0_ & 2) == 0 || (ballPhysData2 = this.ballPhysData_) == null || ballPhysData2 == BallPhysData.getDefaultInstance()) {
                this.ballPhysData_ = ballPhysData;
            } else {
                getBallPhysDataBuilder().mergeFrom(ballPhysData);
            }
            if (this.ballPhysData_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder setBallPhysData(BallPhysData ballPhysData) {
            SingleFieldBuilder<BallPhysData, BallPhysData.Builder, BallPhysDataOrBuilder> singleFieldBuilder = this.ballPhysDataBuilder_;
            if (singleFieldBuilder == null) {
                ballPhysData.getClass();
                this.ballPhysData_ = ballPhysData;
            } else {
                singleFieldBuilder.setMessage(ballPhysData);
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setBallState(BallState ballState) {
            ballState.getClass();
            this.bitField0_ |= 1;
            this.ballState_ = ballState.getNumber();
            onChanged();
            return this;
        }

        public Builder setBallStateValue(int i) {
            this.ballState_ = i;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        private Builder() {
            this.ballState_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BallData build() {
            BallData ballDataBuildPartial = buildPartial();
            if (ballDataBuildPartial.isInitialized()) {
                return ballDataBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) ballDataBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BallData buildPartial() {
            BallData ballData = new BallData(this);
            if (this.bitField0_ != 0) {
                buildPartial0(ballData);
            }
            onBuilt();
            return ballData;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BallData getDefaultInstanceForType() {
            return BallData.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.ballState_ = 0;
            this.ballPhysData_ = null;
            SingleFieldBuilder<BallPhysData, BallPhysData.Builder, BallPhysDataOrBuilder> singleFieldBuilder = this.ballPhysDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.ballPhysDataBuilder_ = null;
            }
            return this;
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.ballState_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof BallData) {
                return mergeFrom((BallData) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setBallPhysData(BallPhysData.Builder builder) {
            SingleFieldBuilder<BallPhysData, BallPhysData.Builder, BallPhysDataOrBuilder> singleFieldBuilder = this.ballPhysDataBuilder_;
            if (singleFieldBuilder == null) {
                this.ballPhysData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeFrom(BallData ballData) {
            if (ballData == BallData.getDefaultInstance()) {
                return this;
            }
            if (ballData.ballState_ != 0) {
                setBallStateValue(ballData.getBallStateValue());
            }
            if (ballData.hasBallPhysData()) {
                mergeBallPhysData(ballData.getBallPhysData());
            }
            mergeUnknownFields(ballData.getUnknownFields());
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
                            if (tag == 8) {
                                this.ballState_ = codedInputStream.readEnum();
                                this.bitField0_ |= 1;
                            } else if (tag != 18) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                codedInputStream.readMessage(getBallPhysDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 2;
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

    private BallData(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.ballState_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(BallData ballData) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(ballData);
    }

    public static BallData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static BallData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BallData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BallData parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public BallData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static BallData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private BallData() {
        this.memoizedIsInitialized = (byte) -1;
        this.ballState_ = 0;
    }

    public static BallData parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static BallData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static BallData parseFrom(InputStream inputStream) {
        return (BallData) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static BallData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BallData) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BallData parseFrom(CodedInputStream codedInputStream) {
        return (BallData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static BallData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BallData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
