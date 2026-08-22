package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

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
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class BallPhysData extends GeneratedMessage implements BallPhysDataOrBuilder {
    private static final BallPhysData DEFAULT_INSTANCE;
    public static final int DIRECTION_FIELD_NUMBER = 3;
    public static final int L_P_POWER_FIELD_NUMBER = 5;
    private static final Parser<BallPhysData> PARSER;
    public static final int SPEED_FIELD_NUMBER = 4;
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private float direction_;
    private float lPPower_;
    private byte memoizedIsInitialized;
    private float speed_;
    private float x_;
    private float y_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", BallPhysData.class.getName());
        DEFAULT_INSTANCE = new BallPhysData();
        PARSER = new AbstractParser<BallPhysData>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysData.1
            @Override // com.google.protobuf.Parser
            public BallPhysData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = BallPhysData.newBuilder();
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

    public static BallPhysData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_BallPhysData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BallPhysData parseDelimitedFrom(InputStream inputStream) {
        return (BallPhysData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static BallPhysData parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<BallPhysData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BallPhysData)) {
            return super.equals(obj);
        }
        BallPhysData ballPhysData = (BallPhysData) obj;
        return Float.floatToIntBits(getX()) == Float.floatToIntBits(ballPhysData.getX()) && Float.floatToIntBits(getY()) == Float.floatToIntBits(ballPhysData.getY()) && Float.floatToIntBits(getDirection()) == Float.floatToIntBits(ballPhysData.getDirection()) && Float.floatToIntBits(getSpeed()) == Float.floatToIntBits(ballPhysData.getSpeed()) && Float.floatToIntBits(getLPPower()) == Float.floatToIntBits(ballPhysData.getLPPower()) && getUnknownFields().equals(ballPhysData.getUnknownFields());
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysDataOrBuilder
    public float getDirection() {
        return this.direction_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysDataOrBuilder
    public float getLPPower() {
        return this.lPPower_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<BallPhysData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeFloatSize = Float.floatToRawIntBits(this.x_) != 0 ? CodedOutputStream.computeFloatSize(1, this.x_) : 0;
        if (Float.floatToRawIntBits(this.y_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(2, this.y_);
        }
        if (Float.floatToRawIntBits(this.direction_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(3, this.direction_);
        }
        if (Float.floatToRawIntBits(this.speed_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(4, this.speed_);
        }
        if (Float.floatToRawIntBits(this.lPPower_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(5, this.lPPower_);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeFloatSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysDataOrBuilder
    public float getSpeed() {
        return this.speed_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysDataOrBuilder
    public float getX() {
        return this.x_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysDataOrBuilder
    public float getY() {
        return this.y_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getUnknownFields().hashCode() + ((Float.floatToIntBits(getLPPower()) + ((((Float.floatToIntBits(getSpeed()) + ((((Float.floatToIntBits(getDirection()) + ((((Float.floatToIntBits(getY()) + ((((Float.floatToIntBits(getX()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53)) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_BallPhysData_fieldAccessorTable.ensureFieldAccessorsInitialized(BallPhysData.class, Builder.class);
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
        if (Float.floatToRawIntBits(this.x_) != 0) {
            codedOutputStream.writeFloat(1, this.x_);
        }
        if (Float.floatToRawIntBits(this.y_) != 0) {
            codedOutputStream.writeFloat(2, this.y_);
        }
        if (Float.floatToRawIntBits(this.direction_) != 0) {
            codedOutputStream.writeFloat(3, this.direction_);
        }
        if (Float.floatToRawIntBits(this.speed_) != 0) {
            codedOutputStream.writeFloat(4, this.speed_);
        }
        if (Float.floatToRawIntBits(this.lPPower_) != 0) {
            codedOutputStream.writeFloat(5, this.lPPower_);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements BallPhysDataOrBuilder {
        private int bitField0_;
        private float direction_;
        private float lPPower_;
        private float speed_;
        private float x_;
        private float y_;

        private void buildPartial0(BallPhysData ballPhysData) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                ballPhysData.x_ = this.x_;
            }
            if ((i & 2) != 0) {
                ballPhysData.y_ = this.y_;
            }
            if ((i & 4) != 0) {
                ballPhysData.direction_ = this.direction_;
            }
            if ((i & 8) != 0) {
                ballPhysData.speed_ = this.speed_;
            }
            if ((i & 16) != 0) {
                ballPhysData.lPPower_ = this.lPPower_;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_BallPhysData_descriptor;
        }

        public Builder clearDirection() {
            this.bitField0_ &= -5;
            this.direction_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearLPPower() {
            this.bitField0_ &= -17;
            this.lPPower_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearSpeed() {
            this.bitField0_ &= -9;
            this.speed_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearX() {
            this.bitField0_ &= -2;
            this.x_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearY() {
            this.bitField0_ &= -3;
            this.y_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_BallPhysData_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysDataOrBuilder
        public float getDirection() {
            return this.direction_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysDataOrBuilder
        public float getLPPower() {
            return this.lPPower_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysDataOrBuilder
        public float getSpeed() {
            return this.speed_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysDataOrBuilder
        public float getX() {
            return this.x_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.BallPhysDataOrBuilder
        public float getY() {
            return this.y_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_BallPhysData_fieldAccessorTable.ensureFieldAccessorsInitialized(BallPhysData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setDirection(float f) {
            this.direction_ = f;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setLPPower(float f) {
            this.lPPower_ = f;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setSpeed(float f) {
            this.speed_ = f;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setX(float f) {
            this.x_ = f;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setY(float f) {
            this.y_ = f;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        private Builder() {
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BallPhysData build() {
            BallPhysData ballPhysDataBuildPartial = buildPartial();
            if (ballPhysDataBuildPartial.isInitialized()) {
                return ballPhysDataBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) ballPhysDataBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BallPhysData buildPartial() {
            BallPhysData ballPhysData = new BallPhysData(this);
            if (this.bitField0_ != 0) {
                buildPartial0(ballPhysData);
            }
            onBuilt();
            return ballPhysData;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BallPhysData getDefaultInstanceForType() {
            return BallPhysData.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.x_ = 0.0f;
            this.y_ = 0.0f;
            this.direction_ = 0.0f;
            this.speed_ = 0.0f;
            this.lPPower_ = 0.0f;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof BallPhysData) {
                return mergeFrom((BallPhysData) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(BallPhysData ballPhysData) {
            if (ballPhysData == BallPhysData.getDefaultInstance()) {
                return this;
            }
            if (ballPhysData.getX() != 0.0f) {
                setX(ballPhysData.getX());
            }
            if (ballPhysData.getY() != 0.0f) {
                setY(ballPhysData.getY());
            }
            if (ballPhysData.getDirection() != 0.0f) {
                setDirection(ballPhysData.getDirection());
            }
            if (ballPhysData.getSpeed() != 0.0f) {
                setSpeed(ballPhysData.getSpeed());
            }
            if (ballPhysData.getLPPower() != 0.0f) {
                setLPPower(ballPhysData.getLPPower());
            }
            mergeUnknownFields(ballPhysData.getUnknownFields());
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
                            if (tag == 13) {
                                this.x_ = codedInputStream.readFloat();
                                this.bitField0_ |= 1;
                            } else if (tag == 21) {
                                this.y_ = codedInputStream.readFloat();
                                this.bitField0_ |= 2;
                            } else if (tag == 29) {
                                this.direction_ = codedInputStream.readFloat();
                                this.bitField0_ |= 4;
                            } else if (tag == 37) {
                                this.speed_ = codedInputStream.readFloat();
                                this.bitField0_ |= 8;
                            } else if (tag != 45) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.lPPower_ = codedInputStream.readFloat();
                                this.bitField0_ |= 16;
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

    private BallPhysData(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.x_ = 0.0f;
        this.y_ = 0.0f;
        this.direction_ = 0.0f;
        this.speed_ = 0.0f;
        this.lPPower_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(BallPhysData ballPhysData) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(ballPhysData);
    }

    public static BallPhysData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static BallPhysData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BallPhysData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BallPhysData parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public BallPhysData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static BallPhysData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static BallPhysData parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static BallPhysData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static BallPhysData parseFrom(InputStream inputStream) {
        return (BallPhysData) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    private BallPhysData() {
        this.x_ = 0.0f;
        this.y_ = 0.0f;
        this.direction_ = 0.0f;
        this.speed_ = 0.0f;
        this.lPPower_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static BallPhysData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BallPhysData) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BallPhysData parseFrom(CodedInputStream codedInputStream) {
        return (BallPhysData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static BallPhysData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BallPhysData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
