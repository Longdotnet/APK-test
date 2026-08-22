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
public final class LeftTeamData extends GeneratedMessage implements LeftTeamDataOrBuilder {
    private static final LeftTeamData DEFAULT_INSTANCE;
    public static final int MB_PLAYER_ID_FIELD_NUMBER = 5;
    public static final int MB_USER_PLAYER_ID_FIELD_NUMBER = 2;
    private static final Parser<LeftTeamData> PARSER;
    public static final int SE_PLAYER_ID_FIELD_NUMBER = 4;
    public static final int SE_USER_PLAYER_ID_FIELD_NUMBER = 1;
    public static final int WS_PLAYER_ID_FIELD_NUMBER = 6;
    public static final int WS_USER_PLAYER_ID_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int mbPlayerId_;
    private int mbUserPlayerId_;
    private byte memoizedIsInitialized;
    private int sePlayerId_;
    private int seUserPlayerId_;
    private int wsPlayerId_;
    private int wsUserPlayerId_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", LeftTeamData.class.getName());
        DEFAULT_INSTANCE = new LeftTeamData();
        PARSER = new AbstractParser<LeftTeamData>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamData.1
            @Override // com.google.protobuf.Parser
            public LeftTeamData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = LeftTeamData.newBuilder();
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

    public static LeftTeamData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_LeftTeamData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static LeftTeamData parseDelimitedFrom(InputStream inputStream) {
        return (LeftTeamData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LeftTeamData parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<LeftTeamData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LeftTeamData)) {
            return super.equals(obj);
        }
        LeftTeamData leftTeamData = (LeftTeamData) obj;
        return getSeUserPlayerId() == leftTeamData.getSeUserPlayerId() && getMbUserPlayerId() == leftTeamData.getMbUserPlayerId() && getWsUserPlayerId() == leftTeamData.getWsUserPlayerId() && getSePlayerId() == leftTeamData.getSePlayerId() && getMbPlayerId() == leftTeamData.getMbPlayerId() && getWsPlayerId() == leftTeamData.getWsPlayerId() && getUnknownFields().equals(leftTeamData.getUnknownFields());
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
    public int getMbPlayerId() {
        return this.mbPlayerId_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
    public int getMbUserPlayerId() {
        return this.mbUserPlayerId_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LeftTeamData> getParserForType() {
        return PARSER;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
    public int getSePlayerId() {
        return this.sePlayerId_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
    public int getSeUserPlayerId() {
        return this.seUserPlayerId_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.seUserPlayerId_;
        int iComputeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) : 0;
        int i3 = this.mbUserPlayerId_;
        if (i3 != 0) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
        }
        int i4 = this.wsUserPlayerId_;
        if (i4 != 0) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
        }
        int i5 = this.sePlayerId_;
        if (i5 != 0) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(4, i5);
        }
        int i6 = this.mbPlayerId_;
        if (i6 != 0) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, i6);
        }
        int i7 = this.wsPlayerId_;
        if (i7 != 0) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(6, i7);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeInt32Size;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
    public int getWsPlayerId() {
        return this.wsPlayerId_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
    public int getWsUserPlayerId() {
        return this.wsUserPlayerId_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getUnknownFields().hashCode() + ((getWsPlayerId() + ((((getMbPlayerId() + ((((getSePlayerId() + ((((getWsUserPlayerId() + ((((getMbUserPlayerId() + ((((getSeUserPlayerId() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53)) * 37) + 6) * 53)) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_LeftTeamData_fieldAccessorTable.ensureFieldAccessorsInitialized(LeftTeamData.class, Builder.class);
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
        int i = this.seUserPlayerId_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        int i2 = this.mbUserPlayerId_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(2, i2);
        }
        int i3 = this.wsUserPlayerId_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(3, i3);
        }
        int i4 = this.sePlayerId_;
        if (i4 != 0) {
            codedOutputStream.writeInt32(4, i4);
        }
        int i5 = this.mbPlayerId_;
        if (i5 != 0) {
            codedOutputStream.writeInt32(5, i5);
        }
        int i6 = this.wsPlayerId_;
        if (i6 != 0) {
            codedOutputStream.writeInt32(6, i6);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements LeftTeamDataOrBuilder {
        private int bitField0_;
        private int mbPlayerId_;
        private int mbUserPlayerId_;
        private int sePlayerId_;
        private int seUserPlayerId_;
        private int wsPlayerId_;
        private int wsUserPlayerId_;

        private void buildPartial0(LeftTeamData leftTeamData) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                leftTeamData.seUserPlayerId_ = this.seUserPlayerId_;
            }
            if ((i & 2) != 0) {
                leftTeamData.mbUserPlayerId_ = this.mbUserPlayerId_;
            }
            if ((i & 4) != 0) {
                leftTeamData.wsUserPlayerId_ = this.wsUserPlayerId_;
            }
            if ((i & 8) != 0) {
                leftTeamData.sePlayerId_ = this.sePlayerId_;
            }
            if ((i & 16) != 0) {
                leftTeamData.mbPlayerId_ = this.mbPlayerId_;
            }
            if ((i & 32) != 0) {
                leftTeamData.wsPlayerId_ = this.wsPlayerId_;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_LeftTeamData_descriptor;
        }

        public Builder clearMbPlayerId() {
            this.bitField0_ &= -17;
            this.mbPlayerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMbUserPlayerId() {
            this.bitField0_ &= -3;
            this.mbUserPlayerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSePlayerId() {
            this.bitField0_ &= -9;
            this.sePlayerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSeUserPlayerId() {
            this.bitField0_ &= -2;
            this.seUserPlayerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWsPlayerId() {
            this.bitField0_ &= -33;
            this.wsPlayerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWsUserPlayerId() {
            this.bitField0_ &= -5;
            this.wsUserPlayerId_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_LeftTeamData_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
        public int getMbPlayerId() {
            return this.mbPlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
        public int getMbUserPlayerId() {
            return this.mbUserPlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
        public int getSePlayerId() {
            return this.sePlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
        public int getSeUserPlayerId() {
            return this.seUserPlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
        public int getWsPlayerId() {
            return this.wsPlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.LeftTeamDataOrBuilder
        public int getWsUserPlayerId() {
            return this.wsUserPlayerId_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_LeftTeamData_fieldAccessorTable.ensureFieldAccessorsInitialized(LeftTeamData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setMbPlayerId(int i) {
            this.mbPlayerId_ = i;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setMbUserPlayerId(int i) {
            this.mbUserPlayerId_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setSePlayerId(int i) {
            this.sePlayerId_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setSeUserPlayerId(int i) {
            this.seUserPlayerId_ = i;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setWsPlayerId(int i) {
            this.wsPlayerId_ = i;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setWsUserPlayerId(int i) {
            this.wsUserPlayerId_ = i;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        private Builder() {
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LeftTeamData build() {
            LeftTeamData leftTeamDataBuildPartial = buildPartial();
            if (leftTeamDataBuildPartial.isInitialized()) {
                return leftTeamDataBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) leftTeamDataBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LeftTeamData buildPartial() {
            LeftTeamData leftTeamData = new LeftTeamData(this);
            if (this.bitField0_ != 0) {
                buildPartial0(leftTeamData);
            }
            onBuilt();
            return leftTeamData;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LeftTeamData getDefaultInstanceForType() {
            return LeftTeamData.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
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
            if (message instanceof LeftTeamData) {
                return mergeFrom((LeftTeamData) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(LeftTeamData leftTeamData) {
            if (leftTeamData == LeftTeamData.getDefaultInstance()) {
                return this;
            }
            if (leftTeamData.getSeUserPlayerId() != 0) {
                setSeUserPlayerId(leftTeamData.getSeUserPlayerId());
            }
            if (leftTeamData.getMbUserPlayerId() != 0) {
                setMbUserPlayerId(leftTeamData.getMbUserPlayerId());
            }
            if (leftTeamData.getWsUserPlayerId() != 0) {
                setWsUserPlayerId(leftTeamData.getWsUserPlayerId());
            }
            if (leftTeamData.getSePlayerId() != 0) {
                setSePlayerId(leftTeamData.getSePlayerId());
            }
            if (leftTeamData.getMbPlayerId() != 0) {
                setMbPlayerId(leftTeamData.getMbPlayerId());
            }
            if (leftTeamData.getWsPlayerId() != 0) {
                setWsPlayerId(leftTeamData.getWsPlayerId());
            }
            mergeUnknownFields(leftTeamData.getUnknownFields());
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
                                this.seUserPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 1;
                            } else if (tag == 16) {
                                this.mbUserPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 2;
                            } else if (tag == 24) {
                                this.wsUserPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 4;
                            } else if (tag == 32) {
                                this.sePlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 8;
                            } else if (tag == 40) {
                                this.mbPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 16;
                            } else if (tag != 48) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.wsPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 32;
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

    private LeftTeamData(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.seUserPlayerId_ = 0;
        this.mbUserPlayerId_ = 0;
        this.wsUserPlayerId_ = 0;
        this.sePlayerId_ = 0;
        this.mbPlayerId_ = 0;
        this.wsPlayerId_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(LeftTeamData leftTeamData) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(leftTeamData);
    }

    public static LeftTeamData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LeftTeamData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LeftTeamData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LeftTeamData parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LeftTeamData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static LeftTeamData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static LeftTeamData parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static LeftTeamData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LeftTeamData parseFrom(InputStream inputStream) {
        return (LeftTeamData) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static LeftTeamData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LeftTeamData) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    private LeftTeamData() {
        this.seUserPlayerId_ = 0;
        this.mbUserPlayerId_ = 0;
        this.wsUserPlayerId_ = 0;
        this.sePlayerId_ = 0;
        this.mbPlayerId_ = 0;
        this.wsPlayerId_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LeftTeamData parseFrom(CodedInputStream codedInputStream) {
        return (LeftTeamData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static LeftTeamData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LeftTeamData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
