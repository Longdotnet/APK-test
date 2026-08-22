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
public final class PlayerPhysData extends GeneratedMessage implements PlayerPhysDataOrBuilder {
    private static final PlayerPhysData DEFAULT_INSTANCE;
    private static final Parser<PlayerPhysData> PARSER;
    public static final int VSPEED_FIELD_NUMBER = 1;
    public static final int XFRICTION_FIELD_NUMBER = 5;
    public static final int XSPEED_FIELD_NUMBER = 4;
    public static final int X_FIELD_NUMBER = 2;
    public static final int Y_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private float vspeed_;
    private float x_;
    private float xfriction_;
    private float xspeed_;
    private float y_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", PlayerPhysData.class.getName());
        DEFAULT_INSTANCE = new PlayerPhysData();
        PARSER = new AbstractParser<PlayerPhysData>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysData.1
            @Override // com.google.protobuf.Parser
            public PlayerPhysData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = PlayerPhysData.newBuilder();
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

    public static PlayerPhysData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerPhysData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PlayerPhysData parseDelimitedFrom(InputStream inputStream) {
        return (PlayerPhysData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlayerPhysData parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<PlayerPhysData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlayerPhysData)) {
            return super.equals(obj);
        }
        PlayerPhysData playerPhysData = (PlayerPhysData) obj;
        return Float.floatToIntBits(getVspeed()) == Float.floatToIntBits(playerPhysData.getVspeed()) && Float.floatToIntBits(getX()) == Float.floatToIntBits(playerPhysData.getX()) && Float.floatToIntBits(getY()) == Float.floatToIntBits(playerPhysData.getY()) && Float.floatToIntBits(getXspeed()) == Float.floatToIntBits(playerPhysData.getXspeed()) && Float.floatToIntBits(getXfriction()) == Float.floatToIntBits(playerPhysData.getXfriction()) && getUnknownFields().equals(playerPhysData.getUnknownFields());
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlayerPhysData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeFloatSize = Float.floatToRawIntBits(this.vspeed_) != 0 ? CodedOutputStream.computeFloatSize(1, this.vspeed_) : 0;
        if (Float.floatToRawIntBits(this.x_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(2, this.x_);
        }
        if (Float.floatToRawIntBits(this.y_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(3, this.y_);
        }
        if (Float.floatToRawIntBits(this.xspeed_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(4, this.xspeed_);
        }
        if (Float.floatToRawIntBits(this.xfriction_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(5, this.xfriction_);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeFloatSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysDataOrBuilder
    public float getVspeed() {
        return this.vspeed_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysDataOrBuilder
    public float getX() {
        return this.x_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysDataOrBuilder
    public float getXfriction() {
        return this.xfriction_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysDataOrBuilder
    public float getXspeed() {
        return this.xspeed_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysDataOrBuilder
    public float getY() {
        return this.y_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getUnknownFields().hashCode() + ((Float.floatToIntBits(getXfriction()) + ((((Float.floatToIntBits(getXspeed()) + ((((Float.floatToIntBits(getY()) + ((((Float.floatToIntBits(getX()) + ((((Float.floatToIntBits(getVspeed()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53)) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerPhysData_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerPhysData.class, Builder.class);
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
        if (Float.floatToRawIntBits(this.vspeed_) != 0) {
            codedOutputStream.writeFloat(1, this.vspeed_);
        }
        if (Float.floatToRawIntBits(this.x_) != 0) {
            codedOutputStream.writeFloat(2, this.x_);
        }
        if (Float.floatToRawIntBits(this.y_) != 0) {
            codedOutputStream.writeFloat(3, this.y_);
        }
        if (Float.floatToRawIntBits(this.xspeed_) != 0) {
            codedOutputStream.writeFloat(4, this.xspeed_);
        }
        if (Float.floatToRawIntBits(this.xfriction_) != 0) {
            codedOutputStream.writeFloat(5, this.xfriction_);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerPhysDataOrBuilder {
        private int bitField0_;
        private float vspeed_;
        private float x_;
        private float xfriction_;
        private float xspeed_;
        private float y_;

        private void buildPartial0(PlayerPhysData playerPhysData) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                playerPhysData.vspeed_ = this.vspeed_;
            }
            if ((i & 2) != 0) {
                playerPhysData.x_ = this.x_;
            }
            if ((i & 4) != 0) {
                playerPhysData.y_ = this.y_;
            }
            if ((i & 8) != 0) {
                playerPhysData.xspeed_ = this.xspeed_;
            }
            if ((i & 16) != 0) {
                playerPhysData.xfriction_ = this.xfriction_;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerPhysData_descriptor;
        }

        public Builder clearVspeed() {
            this.bitField0_ &= -2;
            this.vspeed_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearX() {
            this.bitField0_ &= -3;
            this.x_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearXfriction() {
            this.bitField0_ &= -17;
            this.xfriction_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearXspeed() {
            this.bitField0_ &= -9;
            this.xspeed_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearY() {
            this.bitField0_ &= -5;
            this.y_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerPhysData_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysDataOrBuilder
        public float getVspeed() {
            return this.vspeed_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysDataOrBuilder
        public float getX() {
            return this.x_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysDataOrBuilder
        public float getXfriction() {
            return this.xfriction_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysDataOrBuilder
        public float getXspeed() {
            return this.xspeed_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerPhysDataOrBuilder
        public float getY() {
            return this.y_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerPhysData_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerPhysData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setVspeed(float f) {
            this.vspeed_ = f;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setX(float f) {
            this.x_ = f;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setXfriction(float f) {
            this.xfriction_ = f;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setXspeed(float f) {
            this.xspeed_ = f;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setY(float f) {
            this.y_ = f;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        private Builder() {
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlayerPhysData build() {
            PlayerPhysData playerPhysDataBuildPartial = buildPartial();
            if (playerPhysDataBuildPartial.isInitialized()) {
                return playerPhysDataBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) playerPhysDataBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlayerPhysData buildPartial() {
            PlayerPhysData playerPhysData = new PlayerPhysData(this);
            if (this.bitField0_ != 0) {
                buildPartial0(playerPhysData);
            }
            onBuilt();
            return playerPhysData;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerPhysData getDefaultInstanceForType() {
            return PlayerPhysData.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.vspeed_ = 0.0f;
            this.x_ = 0.0f;
            this.y_ = 0.0f;
            this.xspeed_ = 0.0f;
            this.xfriction_ = 0.0f;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PlayerPhysData) {
                return mergeFrom((PlayerPhysData) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(PlayerPhysData playerPhysData) {
            if (playerPhysData == PlayerPhysData.getDefaultInstance()) {
                return this;
            }
            if (playerPhysData.getVspeed() != 0.0f) {
                setVspeed(playerPhysData.getVspeed());
            }
            if (playerPhysData.getX() != 0.0f) {
                setX(playerPhysData.getX());
            }
            if (playerPhysData.getY() != 0.0f) {
                setY(playerPhysData.getY());
            }
            if (playerPhysData.getXspeed() != 0.0f) {
                setXspeed(playerPhysData.getXspeed());
            }
            if (playerPhysData.getXfriction() != 0.0f) {
                setXfriction(playerPhysData.getXfriction());
            }
            mergeUnknownFields(playerPhysData.getUnknownFields());
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
                                this.vspeed_ = codedInputStream.readFloat();
                                this.bitField0_ |= 1;
                            } else if (tag == 21) {
                                this.x_ = codedInputStream.readFloat();
                                this.bitField0_ |= 2;
                            } else if (tag == 29) {
                                this.y_ = codedInputStream.readFloat();
                                this.bitField0_ |= 4;
                            } else if (tag == 37) {
                                this.xspeed_ = codedInputStream.readFloat();
                                this.bitField0_ |= 8;
                            } else if (tag != 45) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.xfriction_ = codedInputStream.readFloat();
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

    private PlayerPhysData(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.vspeed_ = 0.0f;
        this.x_ = 0.0f;
        this.y_ = 0.0f;
        this.xspeed_ = 0.0f;
        this.xfriction_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(PlayerPhysData playerPhysData) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(playerPhysData);
    }

    public static PlayerPhysData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlayerPhysData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PlayerPhysData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayerPhysData parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlayerPhysData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static PlayerPhysData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static PlayerPhysData parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static PlayerPhysData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlayerPhysData parseFrom(InputStream inputStream) {
        return (PlayerPhysData) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    private PlayerPhysData() {
        this.vspeed_ = 0.0f;
        this.x_ = 0.0f;
        this.y_ = 0.0f;
        this.xspeed_ = 0.0f;
        this.xfriction_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PlayerPhysData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PlayerPhysData) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayerPhysData parseFrom(CodedInputStream codedInputStream) {
        return (PlayerPhysData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlayerPhysData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PlayerPhysData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
