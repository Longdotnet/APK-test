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
public final class Serve extends GeneratedMessage implements ServeOrBuilder {
    private static final Serve DEFAULT_INSTANCE;
    private static final Parser<Serve> PARSER;
    public static final int SERVE_TYPE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int serveType_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", Serve.class.getName());
        DEFAULT_INSTANCE = new Serve();
        PARSER = new AbstractParser<Serve>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.Serve.1
            @Override // com.google.protobuf.Parser
            public Serve parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = Serve.newBuilder();
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

    public static Serve getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Serve_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Serve parseDelimitedFrom(InputStream inputStream) {
        return (Serve) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Serve parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Serve> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Serve)) {
            return super.equals(obj);
        }
        Serve serve = (Serve) obj;
        return this.serveType_ == serve.serveType_ && getUnknownFields().equals(serve.getUnknownFields());
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Serve> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int serializedSize = getUnknownFields().getSerializedSize() + (this.serveType_ != ServeType.SERVE_TYPE_SPIKE.getNumber() ? CodedOutputStream.computeEnumSize(1, this.serveType_) : 0);
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ServeOrBuilder
    public ServeType getServeType() {
        ServeType serveTypeForNumber = ServeType.forNumber(this.serveType_);
        return serveTypeForNumber == null ? ServeType.UNRECOGNIZED : serveTypeForNumber;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ServeOrBuilder
    public int getServeTypeValue() {
        return this.serveType_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getUnknownFields().hashCode() + ((((((getDescriptor().hashCode() + 779) * 37) + 1) * 53) + this.serveType_) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Serve_fieldAccessorTable.ensureFieldAccessorsInitialized(Serve.class, Builder.class);
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
        if (this.serveType_ != ServeType.SERVE_TYPE_SPIKE.getNumber()) {
            codedOutputStream.writeEnum(1, this.serveType_);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ServeOrBuilder {
        private int bitField0_;
        private int serveType_;

        private void buildPartial0(Serve serve) {
            if ((this.bitField0_ & 1) != 0) {
                serve.serveType_ = this.serveType_;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Serve_descriptor;
        }

        public Builder clearServeType() {
            this.bitField0_ &= -2;
            this.serveType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Serve_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ServeOrBuilder
        public ServeType getServeType() {
            ServeType serveTypeForNumber = ServeType.forNumber(this.serveType_);
            return serveTypeForNumber == null ? ServeType.UNRECOGNIZED : serveTypeForNumber;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ServeOrBuilder
        public int getServeTypeValue() {
            return this.serveType_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Serve_fieldAccessorTable.ensureFieldAccessorsInitialized(Serve.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setServeType(ServeType serveType) {
            serveType.getClass();
            this.bitField0_ |= 1;
            this.serveType_ = serveType.getNumber();
            onChanged();
            return this;
        }

        public Builder setServeTypeValue(int i) {
            this.serveType_ = i;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        private Builder() {
            this.serveType_ = 0;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Serve build() {
            Serve serveBuildPartial = buildPartial();
            if (serveBuildPartial.isInitialized()) {
                return serveBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) serveBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Serve buildPartial() {
            Serve serve = new Serve(this);
            if (this.bitField0_ != 0) {
                buildPartial0(serve);
            }
            onBuilt();
            return serve;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Serve getDefaultInstanceForType() {
            return Serve.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.serveType_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.serveType_ = 0;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Serve) {
                return mergeFrom((Serve) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Serve serve) {
            if (serve == Serve.getDefaultInstance()) {
                return this;
            }
            if (serve.serveType_ != 0) {
                setServeTypeValue(serve.getServeTypeValue());
            }
            mergeUnknownFields(serve.getUnknownFields());
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
                            if (tag != 8) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.serveType_ = codedInputStream.readEnum();
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

    private Serve(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.serveType_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(Serve serve) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(serve);
    }

    public static Serve parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Serve parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Serve) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Serve parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Serve getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static Serve parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Serve() {
        this.memoizedIsInitialized = (byte) -1;
        this.serveType_ = 0;
    }

    public static Serve parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static Serve parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Serve parseFrom(InputStream inputStream) {
        return (Serve) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Serve parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Serve) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Serve parseFrom(CodedInputStream codedInputStream) {
        return (Serve) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Serve parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Serve) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
