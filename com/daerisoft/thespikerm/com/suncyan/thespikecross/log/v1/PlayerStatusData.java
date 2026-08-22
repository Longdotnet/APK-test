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
public final class PlayerStatusData extends GeneratedMessage implements PlayerStatusDataOrBuilder {
    private static final PlayerStatusData DEFAULT_INSTANCE;
    public static final int JUMP_FIELD_NUMBER = 4;
    private static final Parser<PlayerStatusData> PARSER;
    public static final int POWER_FIELD_NUMBER = 1;
    public static final int RECEIVE_FIELD_NUMBER = 3;
    public static final int SPEED_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private float jump_;
    private byte memoizedIsInitialized;
    private float power_;
    private float receive_;
    private float speed_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", PlayerStatusData.class.getName());
        DEFAULT_INSTANCE = new PlayerStatusData();
        PARSER = new AbstractParser<PlayerStatusData>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerStatusData.1
            @Override // com.google.protobuf.Parser
            public PlayerStatusData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = PlayerStatusData.newBuilder();
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

    public static PlayerStatusData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerStatusData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PlayerStatusData parseDelimitedFrom(InputStream inputStream) {
        return (PlayerStatusData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlayerStatusData parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<PlayerStatusData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlayerStatusData)) {
            return super.equals(obj);
        }
        PlayerStatusData playerStatusData = (PlayerStatusData) obj;
        return Float.floatToIntBits(getPower()) == Float.floatToIntBits(playerStatusData.getPower()) && Float.floatToIntBits(getSpeed()) == Float.floatToIntBits(playerStatusData.getSpeed()) && Float.floatToIntBits(getReceive()) == Float.floatToIntBits(playerStatusData.getReceive()) && Float.floatToIntBits(getJump()) == Float.floatToIntBits(playerStatusData.getJump()) && getUnknownFields().equals(playerStatusData.getUnknownFields());
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerStatusDataOrBuilder
    public float getJump() {
        return this.jump_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlayerStatusData> getParserForType() {
        return PARSER;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerStatusDataOrBuilder
    public float getPower() {
        return this.power_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerStatusDataOrBuilder
    public float getReceive() {
        return this.receive_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeFloatSize = Float.floatToRawIntBits(this.power_) != 0 ? CodedOutputStream.computeFloatSize(1, this.power_) : 0;
        if (Float.floatToRawIntBits(this.speed_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(2, this.speed_);
        }
        if (Float.floatToRawIntBits(this.receive_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(3, this.receive_);
        }
        if (Float.floatToRawIntBits(this.jump_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(4, this.jump_);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeFloatSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerStatusDataOrBuilder
    public float getSpeed() {
        return this.speed_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getUnknownFields().hashCode() + ((Float.floatToIntBits(getJump()) + ((((Float.floatToIntBits(getReceive()) + ((((Float.floatToIntBits(getSpeed()) + ((((Float.floatToIntBits(getPower()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerStatusData_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerStatusData.class, Builder.class);
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
        if (Float.floatToRawIntBits(this.power_) != 0) {
            codedOutputStream.writeFloat(1, this.power_);
        }
        if (Float.floatToRawIntBits(this.speed_) != 0) {
            codedOutputStream.writeFloat(2, this.speed_);
        }
        if (Float.floatToRawIntBits(this.receive_) != 0) {
            codedOutputStream.writeFloat(3, this.receive_);
        }
        if (Float.floatToRawIntBits(this.jump_) != 0) {
            codedOutputStream.writeFloat(4, this.jump_);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerStatusDataOrBuilder {
        private int bitField0_;
        private float jump_;
        private float power_;
        private float receive_;
        private float speed_;

        private void buildPartial0(PlayerStatusData playerStatusData) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                playerStatusData.power_ = this.power_;
            }
            if ((i & 2) != 0) {
                playerStatusData.speed_ = this.speed_;
            }
            if ((i & 4) != 0) {
                playerStatusData.receive_ = this.receive_;
            }
            if ((i & 8) != 0) {
                playerStatusData.jump_ = this.jump_;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerStatusData_descriptor;
        }

        public Builder clearJump() {
            this.bitField0_ &= -9;
            this.jump_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearPower() {
            this.bitField0_ &= -2;
            this.power_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearReceive() {
            this.bitField0_ &= -5;
            this.receive_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearSpeed() {
            this.bitField0_ &= -3;
            this.speed_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerStatusData_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerStatusDataOrBuilder
        public float getJump() {
            return this.jump_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerStatusDataOrBuilder
        public float getPower() {
            return this.power_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerStatusDataOrBuilder
        public float getReceive() {
            return this.receive_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerStatusDataOrBuilder
        public float getSpeed() {
            return this.speed_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerStatusData_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerStatusData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setJump(float f) {
            this.jump_ = f;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setPower(float f) {
            this.power_ = f;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setReceive(float f) {
            this.receive_ = f;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setSpeed(float f) {
            this.speed_ = f;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        private Builder() {
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlayerStatusData build() {
            PlayerStatusData playerStatusDataBuildPartial = buildPartial();
            if (playerStatusDataBuildPartial.isInitialized()) {
                return playerStatusDataBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) playerStatusDataBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlayerStatusData buildPartial() {
            PlayerStatusData playerStatusData = new PlayerStatusData(this);
            if (this.bitField0_ != 0) {
                buildPartial0(playerStatusData);
            }
            onBuilt();
            return playerStatusData;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerStatusData getDefaultInstanceForType() {
            return PlayerStatusData.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.power_ = 0.0f;
            this.speed_ = 0.0f;
            this.receive_ = 0.0f;
            this.jump_ = 0.0f;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PlayerStatusData) {
                return mergeFrom((PlayerStatusData) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(PlayerStatusData playerStatusData) {
            if (playerStatusData == PlayerStatusData.getDefaultInstance()) {
                return this;
            }
            if (playerStatusData.getPower() != 0.0f) {
                setPower(playerStatusData.getPower());
            }
            if (playerStatusData.getSpeed() != 0.0f) {
                setSpeed(playerStatusData.getSpeed());
            }
            if (playerStatusData.getReceive() != 0.0f) {
                setReceive(playerStatusData.getReceive());
            }
            if (playerStatusData.getJump() != 0.0f) {
                setJump(playerStatusData.getJump());
            }
            mergeUnknownFields(playerStatusData.getUnknownFields());
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
                                this.power_ = codedInputStream.readFloat();
                                this.bitField0_ |= 1;
                            } else if (tag == 21) {
                                this.speed_ = codedInputStream.readFloat();
                                this.bitField0_ |= 2;
                            } else if (tag == 29) {
                                this.receive_ = codedInputStream.readFloat();
                                this.bitField0_ |= 4;
                            } else if (tag != 37) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.jump_ = codedInputStream.readFloat();
                                this.bitField0_ |= 8;
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

    private PlayerStatusData(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.power_ = 0.0f;
        this.speed_ = 0.0f;
        this.receive_ = 0.0f;
        this.jump_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(PlayerStatusData playerStatusData) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(playerStatusData);
    }

    public static PlayerStatusData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlayerStatusData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PlayerStatusData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayerStatusData parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlayerStatusData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static PlayerStatusData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static PlayerStatusData parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static PlayerStatusData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlayerStatusData parseFrom(InputStream inputStream) {
        return (PlayerStatusData) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    private PlayerStatusData() {
        this.power_ = 0.0f;
        this.speed_ = 0.0f;
        this.receive_ = 0.0f;
        this.jump_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PlayerStatusData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PlayerStatusData) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayerStatusData parseFrom(CodedInputStream codedInputStream) {
        return (PlayerStatusData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlayerStatusData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PlayerStatusData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
