package com.google.protobuf;

import androidx.loader.app.gv.DYYbQc;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class Int64Value extends GeneratedMessage implements Int64ValueOrBuilder {
    private static final Int64Value DEFAULT_INSTANCE;
    private static final Parser<Int64Value> PARSER;
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private long value_;

    public static Int64Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Int64Value of(long j) {
        return newBuilder().setValue(j).build();
    }

    public static Int64Value parseDelimitedFrom(InputStream inputStream) {
        return (Int64Value) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Int64Value parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Int64Value> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Int64Value)) {
            return super.equals(obj);
        }
        Int64Value int64Value = (Int64Value) obj;
        return getValue() == int64Value.getValue() && getUnknownFields().equals(int64Value.getUnknownFields());
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Int64Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        long j = this.value_;
        int serializedSize = getUnknownFields().getSerializedSize() + (j != 0 ? CodedOutputStream.computeInt64Size(1, j) : 0);
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.Int64ValueOrBuilder
    public long getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getUnknownFields().hashCode() + ((Internal.hashLong(getValue()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int64Value.class, Builder.class);
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
        long j = this.value_;
        if (j != 0) {
            codedOutputStream.writeInt64(1, j);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements Int64ValueOrBuilder {
        private int bitField0_;
        private long value_;

        private void buildPartial0(Int64Value int64Value) {
            if ((this.bitField0_ & 1) != 0) {
                int64Value.value_ = this.value_;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
        }

        public Builder clearValue() {
            this.bitField0_ &= -2;
            this.value_ = 0L;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
        }

        @Override // com.google.protobuf.Int64ValueOrBuilder
        public long getValue() {
            return this.value_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int64Value.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setValue(long j) {
            this.value_ = j;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        private Builder() {
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Int64Value build() {
            Int64Value int64ValueBuildPartial = buildPartial();
            if (int64ValueBuildPartial.isInitialized()) {
                return int64ValueBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) int64ValueBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Int64Value buildPartial() {
            Int64Value int64Value = new Int64Value(this);
            if (this.bitField0_ != 0) {
                buildPartial0(int64Value);
            }
            onBuilt();
            return int64Value;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Int64Value getDefaultInstanceForType() {
            return Int64Value.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.value_ = 0L;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Int64Value) {
                return mergeFrom((Int64Value) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Int64Value int64Value) {
            if (int64Value == Int64Value.getDefaultInstance()) {
                return this;
            }
            if (int64Value.getValue() != 0) {
                setValue(int64Value.getValue());
            }
            mergeUnknownFields(int64Value.getUnknownFields());
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
                                this.value_ = codedInputStream.readInt64();
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

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, DYYbQc.TyF, Int64Value.class.getName());
        DEFAULT_INSTANCE = new Int64Value();
        PARSER = new AbstractParser<Int64Value>() { // from class: com.google.protobuf.Int64Value.1
            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream inputStream) {
                return super.parseDelimitedFrom(inputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteString byteString) {
                return super.parseFrom(byteString);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream inputStream) {
                return super.parsePartialDelimitedFrom(inputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString byteString) {
                return super.parsePartialFrom(byteString);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseDelimitedFrom(inputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(byteString, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.parsePartialDelimitedFrom(inputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return super.parsePartialFrom(byteString, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream codedInputStream) {
                return super.parseFrom(codedInputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream) {
                return super.parsePartialFrom(codedInputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(InputStream inputStream) {
                return super.parseFrom(inputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream inputStream) {
                return super.parsePartialFrom(inputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(inputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.parsePartialFrom(inputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer byteBuffer) {
                return super.parseFrom(byteBuffer);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr) {
                return super.parsePartialFrom(bArr);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(byteBuffer, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr, int i, int i2) {
                return super.parsePartialFrom(bArr, i, i2);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr) {
                return super.parseFrom(bArr);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
                return super.parsePartialFrom(bArr, i, i2, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, int i, int i2) {
                return super.parseFrom(bArr, i, i2);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return super.parsePartialFrom(bArr, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(bArr, i, i2, extensionRegistryLite);
            }

            @Override // com.google.protobuf.Parser
            public Int64Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = Int64Value.newBuilder();
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

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(bArr, extensionRegistryLite);
            }
        };
    }

    private Int64Value(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.value_ = 0L;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(Int64Value int64Value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(int64Value);
    }

    public static Int64Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Int64Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Int64Value parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Int64Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static Int64Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Int64Value() {
        this.value_ = 0L;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Int64Value parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static Int64Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Int64Value parseFrom(InputStream inputStream) {
        return (Int64Value) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Int64Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Int64Value parseFrom(CodedInputStream codedInputStream) {
        return (Int64Value) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Int64Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
