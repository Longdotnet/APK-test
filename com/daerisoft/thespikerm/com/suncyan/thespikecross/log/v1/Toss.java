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
public final class Toss extends GeneratedMessage implements TossOrBuilder {
    private static final Toss DEFAULT_INSTANCE;
    public static final int IS_TOSS_SUCCESS_FIELD_NUMBER = 2;
    private static final Parser<Toss> PARSER;
    public static final int TOSS_TYPE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private boolean isTossSuccess_;
    private byte memoizedIsInitialized;
    private int tossType_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", Toss.class.getName());
        DEFAULT_INSTANCE = new Toss();
        PARSER = new AbstractParser<Toss>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.Toss.1
            @Override // com.google.protobuf.Parser
            public Toss parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = Toss.newBuilder();
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

    public static Toss getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Toss_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Toss parseDelimitedFrom(InputStream inputStream) {
        return (Toss) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Toss parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Toss> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Toss)) {
            return super.equals(obj);
        }
        Toss toss = (Toss) obj;
        return this.tossType_ == toss.tossType_ && getIsTossSuccess() == toss.getIsTossSuccess() && getUnknownFields().equals(toss.getUnknownFields());
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossOrBuilder
    public boolean getIsTossSuccess() {
        return this.isTossSuccess_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Toss> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeEnumSize = this.tossType_ != TossType.TOSS_TYPE_UNSPECIFIED.getNumber() ? CodedOutputStream.computeEnumSize(1, this.tossType_) : 0;
        boolean z = this.isTossSuccess_;
        if (z) {
            iComputeEnumSize += CodedOutputStream.computeBoolSize(2, z);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeEnumSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossOrBuilder
    public TossType getTossType() {
        TossType tossTypeForNumber = TossType.forNumber(this.tossType_);
        return tossTypeForNumber == null ? TossType.UNRECOGNIZED : tossTypeForNumber;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossOrBuilder
    public int getTossTypeValue() {
        return this.tossType_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getUnknownFields().hashCode() + ((Internal.hashBoolean(getIsTossSuccess()) + ((((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + this.tossType_) * 37) + 2) * 53)) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Toss_fieldAccessorTable.ensureFieldAccessorsInitialized(Toss.class, Builder.class);
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
        if (this.tossType_ != TossType.TOSS_TYPE_UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(1, this.tossType_);
        }
        boolean z = this.isTossSuccess_;
        if (z) {
            codedOutputStream.writeBool(2, z);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements TossOrBuilder {
        private int bitField0_;
        private boolean isTossSuccess_;
        private int tossType_;

        private void buildPartial0(Toss toss) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                toss.tossType_ = this.tossType_;
            }
            if ((i & 2) != 0) {
                toss.isTossSuccess_ = this.isTossSuccess_;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Toss_descriptor;
        }

        public Builder clearIsTossSuccess() {
            this.bitField0_ &= -3;
            this.isTossSuccess_ = false;
            onChanged();
            return this;
        }

        public Builder clearTossType() {
            this.bitField0_ &= -2;
            this.tossType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Toss_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossOrBuilder
        public boolean getIsTossSuccess() {
            return this.isTossSuccess_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossOrBuilder
        public TossType getTossType() {
            TossType tossTypeForNumber = TossType.forNumber(this.tossType_);
            return tossTypeForNumber == null ? TossType.UNRECOGNIZED : tossTypeForNumber;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossOrBuilder
        public int getTossTypeValue() {
            return this.tossType_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Toss_fieldAccessorTable.ensureFieldAccessorsInitialized(Toss.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setIsTossSuccess(boolean z) {
            this.isTossSuccess_ = z;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setTossType(TossType tossType) {
            tossType.getClass();
            this.bitField0_ |= 1;
            this.tossType_ = tossType.getNumber();
            onChanged();
            return this;
        }

        public Builder setTossTypeValue(int i) {
            this.tossType_ = i;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        private Builder() {
            this.tossType_ = 0;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Toss build() {
            Toss tossBuildPartial = buildPartial();
            if (tossBuildPartial.isInitialized()) {
                return tossBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) tossBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Toss buildPartial() {
            Toss toss = new Toss(this);
            if (this.bitField0_ != 0) {
                buildPartial0(toss);
            }
            onBuilt();
            return toss;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Toss getDefaultInstanceForType() {
            return Toss.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.tossType_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.tossType_ = 0;
            this.isTossSuccess_ = false;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Toss) {
                return mergeFrom((Toss) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Toss toss) {
            if (toss == Toss.getDefaultInstance()) {
                return this;
            }
            if (toss.tossType_ != 0) {
                setTossTypeValue(toss.getTossTypeValue());
            }
            if (toss.getIsTossSuccess()) {
                setIsTossSuccess(toss.getIsTossSuccess());
            }
            mergeUnknownFields(toss.getUnknownFields());
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
                                this.tossType_ = codedInputStream.readEnum();
                                this.bitField0_ |= 1;
                            } else if (tag != 16) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.isTossSuccess_ = codedInputStream.readBool();
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

    private Toss(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.tossType_ = 0;
        this.isTossSuccess_ = false;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(Toss toss) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(toss);
    }

    public static Toss parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Toss parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Toss) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Toss parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Toss getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static Toss parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Toss parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    private Toss() {
        this.isTossSuccess_ = false;
        this.memoizedIsInitialized = (byte) -1;
        this.tossType_ = 0;
    }

    public static Toss parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Toss parseFrom(InputStream inputStream) {
        return (Toss) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Toss parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Toss) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Toss parseFrom(CodedInputStream codedInputStream) {
        return (Toss) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Toss parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Toss) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
