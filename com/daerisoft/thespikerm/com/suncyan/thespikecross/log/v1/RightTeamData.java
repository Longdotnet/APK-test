package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class RightTeamData extends GeneratedMessage implements RightTeamDataOrBuilder {
    private static final RightTeamData DEFAULT_INSTANCE;
    public static final int IS_EPD_FIELD_NUMBER = 1;
    public static final int MB_PLAYER_ID_FIELD_NUMBER = 6;
    public static final int MB_USER_PLAYER_ID_FIELD_NUMBER = 3;
    private static final Parser<RightTeamData> PARSER;
    public static final int SE_PLAYER_ID_FIELD_NUMBER = 5;
    public static final int SE_USER_PLAYER_ID_FIELD_NUMBER = 2;
    public static final int WS_PLAYER_ID_FIELD_NUMBER = 7;
    public static final int WS_USER_PLAYER_ID_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private boolean isEpd_;
    private int mbPlayerId_;
    private int mbUserPlayerId_;
    private byte memoizedIsInitialized;
    private int sePlayerId_;
    private int seUserPlayerId_;
    private int wsPlayerId_;
    private int wsUserPlayerId_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", RightTeamData.class.getName());
        DEFAULT_INSTANCE = new RightTeamData();
        PARSER = new AbstractParser<RightTeamData>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamData.1
            @Override // com.google.protobuf.Parser
            public RightTeamData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = RightTeamData.newBuilder();
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

    public static RightTeamData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_RightTeamData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static RightTeamData parseDelimitedFrom(InputStream inputStream) {
        return (RightTeamData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static RightTeamData parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<RightTeamData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RightTeamData)) {
            return super.equals(obj);
        }
        RightTeamData rightTeamData = (RightTeamData) obj;
        return getIsEpd() == rightTeamData.getIsEpd() && getSeUserPlayerId() == rightTeamData.getSeUserPlayerId() && getMbUserPlayerId() == rightTeamData.getMbUserPlayerId() && getWsUserPlayerId() == rightTeamData.getWsUserPlayerId() && getSePlayerId() == rightTeamData.getSePlayerId() && getMbPlayerId() == rightTeamData.getMbPlayerId() && getWsPlayerId() == rightTeamData.getWsPlayerId() && getUnknownFields().equals(rightTeamData.getUnknownFields());
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
    public boolean getIsEpd() {
        return this.isEpd_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
    public int getMbPlayerId() {
        return this.mbPlayerId_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
    public int getMbUserPlayerId() {
        return this.mbUserPlayerId_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<RightTeamData> getParserForType() {
        return PARSER;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
    public int getSePlayerId() {
        return this.sePlayerId_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
    public int getSeUserPlayerId() {
        return this.seUserPlayerId_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        boolean z = this.isEpd_;
        int iComputeBoolSize = z ? CodedOutputStream.computeBoolSize(1, z) : 0;
        int i2 = this.seUserPlayerId_;
        if (i2 != 0) {
            iComputeBoolSize += CodedOutputStream.computeInt32Size(2, i2);
        }
        int i3 = this.mbUserPlayerId_;
        if (i3 != 0) {
            iComputeBoolSize += CodedOutputStream.computeInt32Size(3, i3);
        }
        int i4 = this.wsUserPlayerId_;
        if (i4 != 0) {
            iComputeBoolSize += CodedOutputStream.computeInt32Size(4, i4);
        }
        int i5 = this.sePlayerId_;
        if (i5 != 0) {
            iComputeBoolSize += CodedOutputStream.computeInt32Size(5, i5);
        }
        int i6 = this.mbPlayerId_;
        if (i6 != 0) {
            iComputeBoolSize += CodedOutputStream.computeInt32Size(6, i6);
        }
        int i7 = this.wsPlayerId_;
        if (i7 != 0) {
            iComputeBoolSize += CodedOutputStream.computeInt32Size(7, i7);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeBoolSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
    public int getWsPlayerId() {
        return this.wsPlayerId_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
    public int getWsUserPlayerId() {
        return this.wsUserPlayerId_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getUnknownFields().hashCode() + ((getWsPlayerId() + ((((getMbPlayerId() + ((((getSePlayerId() + ((((getWsUserPlayerId() + ((((getMbUserPlayerId() + ((((getSeUserPlayerId() + ((((Internal.hashBoolean(getIsEpd()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53)) * 37) + 6) * 53)) * 37) + 7) * 53)) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_RightTeamData_fieldAccessorTable.ensureFieldAccessorsInitialized(RightTeamData.class, Builder.class);
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
        boolean z = this.isEpd_;
        if (z) {
            codedOutputStream.writeBool(1, z);
        }
        int i = this.seUserPlayerId_;
        if (i != 0) {
            codedOutputStream.writeInt32(2, i);
        }
        int i2 = this.mbUserPlayerId_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(3, i2);
        }
        int i3 = this.wsUserPlayerId_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(4, i3);
        }
        int i4 = this.sePlayerId_;
        if (i4 != 0) {
            codedOutputStream.writeInt32(5, i4);
        }
        int i5 = this.mbPlayerId_;
        if (i5 != 0) {
            codedOutputStream.writeInt32(6, i5);
        }
        int i6 = this.wsPlayerId_;
        if (i6 != 0) {
            codedOutputStream.writeInt32(7, i6);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements RightTeamDataOrBuilder {
        private int bitField0_;
        private boolean isEpd_;
        private int mbPlayerId_;
        private int mbUserPlayerId_;
        private int sePlayerId_;
        private int seUserPlayerId_;
        private int wsPlayerId_;
        private int wsUserPlayerId_;

        private void buildPartial0(RightTeamData rightTeamData) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                rightTeamData.isEpd_ = this.isEpd_;
            }
            if ((i & 2) != 0) {
                rightTeamData.seUserPlayerId_ = this.seUserPlayerId_;
            }
            if ((i & 4) != 0) {
                rightTeamData.mbUserPlayerId_ = this.mbUserPlayerId_;
            }
            if ((i & 8) != 0) {
                rightTeamData.wsUserPlayerId_ = this.wsUserPlayerId_;
            }
            if ((i & 16) != 0) {
                rightTeamData.sePlayerId_ = this.sePlayerId_;
            }
            if ((i & 32) != 0) {
                rightTeamData.mbPlayerId_ = this.mbPlayerId_;
            }
            if ((i & 64) != 0) {
                rightTeamData.wsPlayerId_ = this.wsPlayerId_;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_RightTeamData_descriptor;
        }

        public Builder clearIsEpd() {
            this.bitField0_ &= -2;
            this.isEpd_ = false;
            onChanged();
            return this;
        }

        public Builder clearMbPlayerId() {
            this.bitField0_ &= -33;
            this.mbPlayerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMbUserPlayerId() {
            this.bitField0_ &= -5;
            this.mbUserPlayerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSePlayerId() {
            this.bitField0_ &= -17;
            this.sePlayerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSeUserPlayerId() {
            this.bitField0_ &= -3;
            this.seUserPlayerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWsPlayerId() {
            this.bitField0_ &= -65;
            this.wsPlayerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWsUserPlayerId() {
            this.bitField0_ &= -9;
            this.wsUserPlayerId_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_RightTeamData_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
        public boolean getIsEpd() {
            return this.isEpd_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
        public int getMbPlayerId() {
            return this.mbPlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
        public int getMbUserPlayerId() {
            return this.mbUserPlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
        public int getSePlayerId() {
            return this.sePlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
        public int getSeUserPlayerId() {
            return this.seUserPlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
        public int getWsPlayerId() {
            return this.wsPlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.RightTeamDataOrBuilder
        public int getWsUserPlayerId() {
            return this.wsUserPlayerId_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_RightTeamData_fieldAccessorTable.ensureFieldAccessorsInitialized(RightTeamData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setIsEpd(boolean z) {
            this.isEpd_ = z;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setMbPlayerId(int i) {
            this.mbPlayerId_ = i;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setMbUserPlayerId(int i) {
            this.mbUserPlayerId_ = i;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setSePlayerId(int i) {
            this.sePlayerId_ = i;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setSeUserPlayerId(int i) {
            this.seUserPlayerId_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setWsPlayerId(int i) {
            this.wsPlayerId_ = i;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setWsUserPlayerId(int i) {
            this.wsUserPlayerId_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        private Builder() {
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RightTeamData build() {
            RightTeamData rightTeamDataBuildPartial = buildPartial();
            if (rightTeamDataBuildPartial.isInitialized()) {
                return rightTeamDataBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) rightTeamDataBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RightTeamData buildPartial() {
            RightTeamData rightTeamData = new RightTeamData(this);
            if (this.bitField0_ != 0) {
                buildPartial0(rightTeamData);
            }
            onBuilt();
            return rightTeamData;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RightTeamData getDefaultInstanceForType() {
            return RightTeamData.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.isEpd_ = false;
            this.seUserPlayerId_ = 0;
            this.mbUserPlayerId_ = 0;
            this.wsUserPlayerId_ = 0;
            this.sePlayerId_ = 0;
            this.mbPlayerId_ = 0;
            this.wsPlayerId_ = 0;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof RightTeamData) {
                return mergeFrom((RightTeamData) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(RightTeamData rightTeamData) {
            if (rightTeamData == RightTeamData.getDefaultInstance()) {
                return this;
            }
            if (rightTeamData.getIsEpd()) {
                setIsEpd(rightTeamData.getIsEpd());
            }
            if (rightTeamData.getSeUserPlayerId() != 0) {
                setSeUserPlayerId(rightTeamData.getSeUserPlayerId());
            }
            if (rightTeamData.getMbUserPlayerId() != 0) {
                setMbUserPlayerId(rightTeamData.getMbUserPlayerId());
            }
            if (rightTeamData.getWsUserPlayerId() != 0) {
                setWsUserPlayerId(rightTeamData.getWsUserPlayerId());
            }
            if (rightTeamData.getSePlayerId() != 0) {
                setSePlayerId(rightTeamData.getSePlayerId());
            }
            if (rightTeamData.getMbPlayerId() != 0) {
                setMbPlayerId(rightTeamData.getMbPlayerId());
            }
            if (rightTeamData.getWsPlayerId() != 0) {
                setWsPlayerId(rightTeamData.getWsPlayerId());
            }
            mergeUnknownFields(rightTeamData.getUnknownFields());
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
                                this.isEpd_ = codedInputStream.readBool();
                                this.bitField0_ |= 1;
                            } else if (tag == 16) {
                                this.seUserPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 2;
                            } else if (tag == 24) {
                                this.mbUserPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 4;
                            } else if (tag == 32) {
                                this.wsUserPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 8;
                            } else if (tag == 40) {
                                this.sePlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 16;
                            } else if (tag == 48) {
                                this.mbPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 32;
                            } else if (tag != 56) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.wsPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 64;
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

    private RightTeamData(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.isEpd_ = false;
        this.seUserPlayerId_ = 0;
        this.mbUserPlayerId_ = 0;
        this.wsUserPlayerId_ = 0;
        this.sePlayerId_ = 0;
        this.mbPlayerId_ = 0;
        this.wsPlayerId_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(RightTeamData rightTeamData) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(rightTeamData);
    }

    public static RightTeamData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static RightTeamData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RightTeamData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RightTeamData parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public RightTeamData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static RightTeamData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static RightTeamData parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static RightTeamData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RightTeamData parseFrom(InputStream inputStream) {
        return (RightTeamData) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static RightTeamData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RightTeamData) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    private RightTeamData() {
        this.isEpd_ = false;
        this.seUserPlayerId_ = 0;
        this.mbUserPlayerId_ = 0;
        this.wsUserPlayerId_ = 0;
        this.sePlayerId_ = 0;
        this.mbPlayerId_ = 0;
        this.wsPlayerId_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static RightTeamData parseFrom(CodedInputStream codedInputStream) {
        return (RightTeamData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static RightTeamData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RightTeamData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
