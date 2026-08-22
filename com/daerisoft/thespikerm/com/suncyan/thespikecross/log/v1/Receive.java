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
public final class Receive extends GeneratedMessage implements ReceiveOrBuilder {
    private static final Receive DEFAULT_INSTANCE;
    public static final int FAIL_FIELD_NUMBER = 1;
    public static final int IS_ROLLING_RECEIVE_FIELD_NUMBER = 2;
    private static final Parser<Receive> PARSER;
    public static final int RECEIVE_ACCURACY_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private boolean fail_;
    private boolean isRollingReceive_;
    private byte memoizedIsInitialized;
    private float receiveAccuracy_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", Receive.class.getName());
        DEFAULT_INSTANCE = new Receive();
        PARSER = new AbstractParser<Receive>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.Receive.1
            @Override // com.google.protobuf.Parser
            public Receive parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = Receive.newBuilder();
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

    public static Receive getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Receive_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Receive parseDelimitedFrom(InputStream inputStream) {
        return (Receive) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Receive parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Receive> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Receive)) {
            return super.equals(obj);
        }
        Receive receive = (Receive) obj;
        return getFail() == receive.getFail() && getIsRollingReceive() == receive.getIsRollingReceive() && Float.floatToIntBits(getReceiveAccuracy()) == Float.floatToIntBits(receive.getReceiveAccuracy()) && getUnknownFields().equals(receive.getUnknownFields());
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ReceiveOrBuilder
    public boolean getFail() {
        return this.fail_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ReceiveOrBuilder
    public boolean getIsRollingReceive() {
        return this.isRollingReceive_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Receive> getParserForType() {
        return PARSER;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ReceiveOrBuilder
    public float getReceiveAccuracy() {
        return this.receiveAccuracy_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        boolean z = this.fail_;
        int iComputeBoolSize = z ? CodedOutputStream.computeBoolSize(1, z) : 0;
        boolean z2 = this.isRollingReceive_;
        if (z2) {
            iComputeBoolSize += CodedOutputStream.computeBoolSize(2, z2);
        }
        if (Float.floatToRawIntBits(this.receiveAccuracy_) != 0) {
            iComputeBoolSize += CodedOutputStream.computeFloatSize(3, this.receiveAccuracy_);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeBoolSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getUnknownFields().hashCode() + ((Float.floatToIntBits(getReceiveAccuracy()) + ((((Internal.hashBoolean(getIsRollingReceive()) + ((((Internal.hashBoolean(getFail()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(Receive.class, Builder.class);
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
        boolean z = this.fail_;
        if (z) {
            codedOutputStream.writeBool(1, z);
        }
        boolean z2 = this.isRollingReceive_;
        if (z2) {
            codedOutputStream.writeBool(2, z2);
        }
        if (Float.floatToRawIntBits(this.receiveAccuracy_) != 0) {
            codedOutputStream.writeFloat(3, this.receiveAccuracy_);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ReceiveOrBuilder {
        private int bitField0_;
        private boolean fail_;
        private boolean isRollingReceive_;
        private float receiveAccuracy_;

        private void buildPartial0(Receive receive) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                receive.fail_ = this.fail_;
            }
            if ((i & 2) != 0) {
                receive.isRollingReceive_ = this.isRollingReceive_;
            }
            if ((i & 4) != 0) {
                receive.receiveAccuracy_ = this.receiveAccuracy_;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Receive_descriptor;
        }

        public Builder clearFail() {
            this.bitField0_ &= -2;
            this.fail_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsRollingReceive() {
            this.bitField0_ &= -3;
            this.isRollingReceive_ = false;
            onChanged();
            return this;
        }

        public Builder clearReceiveAccuracy() {
            this.bitField0_ &= -5;
            this.receiveAccuracy_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Receive_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ReceiveOrBuilder
        public boolean getFail() {
            return this.fail_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ReceiveOrBuilder
        public boolean getIsRollingReceive() {
            return this.isRollingReceive_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ReceiveOrBuilder
        public float getReceiveAccuracy() {
            return this.receiveAccuracy_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(Receive.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setFail(boolean z) {
            this.fail_ = z;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setIsRollingReceive(boolean z) {
            this.isRollingReceive_ = z;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setReceiveAccuracy(float f) {
            this.receiveAccuracy_ = f;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        private Builder() {
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Receive build() {
            Receive receiveBuildPartial = buildPartial();
            if (receiveBuildPartial.isInitialized()) {
                return receiveBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) receiveBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Receive buildPartial() {
            Receive receive = new Receive(this);
            if (this.bitField0_ != 0) {
                buildPartial0(receive);
            }
            onBuilt();
            return receive;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Receive getDefaultInstanceForType() {
            return Receive.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.fail_ = false;
            this.isRollingReceive_ = false;
            this.receiveAccuracy_ = 0.0f;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Receive) {
                return mergeFrom((Receive) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Receive receive) {
            if (receive == Receive.getDefaultInstance()) {
                return this;
            }
            if (receive.getFail()) {
                setFail(receive.getFail());
            }
            if (receive.getIsRollingReceive()) {
                setIsRollingReceive(receive.getIsRollingReceive());
            }
            if (receive.getReceiveAccuracy() != 0.0f) {
                setReceiveAccuracy(receive.getReceiveAccuracy());
            }
            mergeUnknownFields(receive.getUnknownFields());
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
                                this.fail_ = codedInputStream.readBool();
                                this.bitField0_ |= 1;
                            } else if (tag == 16) {
                                this.isRollingReceive_ = codedInputStream.readBool();
                                this.bitField0_ |= 2;
                            } else if (tag != 29) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.receiveAccuracy_ = codedInputStream.readFloat();
                                this.bitField0_ |= 4;
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

    private Receive(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.fail_ = false;
        this.isRollingReceive_ = false;
        this.receiveAccuracy_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(Receive receive) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(receive);
    }

    public static Receive parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Receive parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Receive) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Receive parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Receive getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static Receive parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Receive parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static Receive parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    private Receive() {
        this.fail_ = false;
        this.isRollingReceive_ = false;
        this.receiveAccuracy_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Receive parseFrom(InputStream inputStream) {
        return (Receive) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Receive parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Receive) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Receive parseFrom(CodedInputStream codedInputStream) {
        return (Receive) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Receive parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Receive) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
