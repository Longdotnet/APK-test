package com.google.protobuf;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaFeaturesProto {
    public static final int JAVA_FIELD_NUMBER = 1001;
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_pb_JavaFeatures_descriptor;
    private static final GeneratedMessage.FieldAccessorTable internal_static_pb_JavaFeatures_fieldAccessorTable;
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> java_;

    public static final class JavaFeatures extends GeneratedMessage implements JavaFeaturesOrBuilder {
        private static final JavaFeatures DEFAULT_INSTANCE;
        public static final int LEGACY_CLOSED_ENUM_FIELD_NUMBER = 1;
        private static final Parser<JavaFeatures> PARSER;
        public static final int UTF8_VALIDATION_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean legacyClosedEnum_;
        private byte memoizedIsInitialized;
        private int utf8Validation_;

        public enum Utf8Validation implements ProtocolMessageEnum {
            UTF8_VALIDATION_UNKNOWN(0),
            DEFAULT(1),
            VERIFY(2);

            public static final int DEFAULT_VALUE = 1;
            public static final int UTF8_VALIDATION_UNKNOWN_VALUE = 0;
            private static final Utf8Validation[] VALUES;
            public static final int VERIFY_VALUE = 2;
            private static final Internal.EnumLiteMap<Utf8Validation> internalValueMap;
            private final int value;

            static {
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", Utf8Validation.class.getName());
                internalValueMap = new Internal.EnumLiteMap<Utf8Validation>() { // from class: com.google.protobuf.JavaFeaturesProto.JavaFeatures.Utf8Validation.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public Utf8Validation findValueByNumber(int i) {
                        return Utf8Validation.forNumber(i);
                    }
                };
                VALUES = values();
            }

            Utf8Validation(int i) {
                this.value = i;
            }

            public static Utf8Validation forNumber(int i) {
                if (i == 0) {
                    return UTF8_VALIDATION_UNKNOWN;
                }
                if (i == 1) {
                    return DEFAULT;
                }
                if (i != 2) {
                    return null;
                }
                return VERIFY;
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return JavaFeatures.getDescriptor().getEnumTypes().get(0);
            }

            public static Internal.EnumLiteMap<Utf8Validation> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite, com.google.protobuf.AbstractMessageLite.InternalOneOfEnum
            public final int getNumber() {
                return this.value;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            @Deprecated
            public static Utf8Validation valueOf(int i) {
                return forNumber(i);
            }

            public static Utf8Validation valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() == getDescriptor()) {
                    return VALUES[enumValueDescriptor.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        public static /* synthetic */ int access$776(JavaFeatures javaFeatures, int i) {
            int i2 = i | javaFeatures.bitField0_;
            javaFeatures.bitField0_ = i2;
            return i2;
        }

        public static JavaFeatures getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return JavaFeaturesProto.internal_static_pb_JavaFeatures_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static JavaFeatures parseDelimitedFrom(InputStream inputStream) {
            return (JavaFeatures) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static JavaFeatures parseFrom(ByteBuffer byteBuffer) {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<JavaFeatures> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof JavaFeatures)) {
                return super.equals(obj);
            }
            JavaFeatures javaFeatures = (JavaFeatures) obj;
            if (hasLegacyClosedEnum() != javaFeatures.hasLegacyClosedEnum()) {
                return false;
            }
            if ((!hasLegacyClosedEnum() || getLegacyClosedEnum() == javaFeatures.getLegacyClosedEnum()) && hasUtf8Validation() == javaFeatures.hasUtf8Validation()) {
                return (!hasUtf8Validation() || this.utf8Validation_ == javaFeatures.utf8Validation_) && getUnknownFields().equals(javaFeatures.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean getLegacyClosedEnum() {
            return this.legacyClosedEnum_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<JavaFeatures> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeBoolSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeBoolSize(1, this.legacyClosedEnum_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                iComputeBoolSize += CodedOutputStream.computeEnumSize(2, this.utf8Validation_);
            }
            int serializedSize = getUnknownFields().getSerializedSize() + iComputeBoolSize;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public Utf8Validation getUtf8Validation() {
            Utf8Validation utf8ValidationForNumber = Utf8Validation.forNumber(this.utf8Validation_);
            return utf8ValidationForNumber == null ? Utf8Validation.UTF8_VALIDATION_UNKNOWN : utf8ValidationForNumber;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasLegacyClosedEnum() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasUtf8Validation() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int iHashCode = getDescriptor().hashCode() + 779;
            if (hasLegacyClosedEnum()) {
                iHashCode = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 1, 53) + Internal.hashBoolean(getLegacyClosedEnum());
            }
            if (hasUtf8Validation()) {
                iHashCode = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 2, 53) + this.utf8Validation_;
            }
            int iHashCode2 = getUnknownFields().hashCode() + (iHashCode * 29);
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessage
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return JavaFeaturesProto.internal_static_pb_JavaFeatures_fieldAccessorTable.ensureFieldAccessorsInitialized(JavaFeatures.class, Builder.class);
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
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.writeBool(1, this.legacyClosedEnum_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeEnum(2, this.utf8Validation_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements JavaFeaturesOrBuilder {
            private int bitField0_;
            private boolean legacyClosedEnum_;
            private int utf8Validation_;

            private void buildPartial0(JavaFeatures javaFeatures) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    javaFeatures.legacyClosedEnum_ = this.legacyClosedEnum_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    javaFeatures.utf8Validation_ = this.utf8Validation_;
                    i |= 2;
                }
                JavaFeatures.access$776(javaFeatures, i);
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return JavaFeaturesProto.internal_static_pb_JavaFeatures_descriptor;
            }

            public Builder clearLegacyClosedEnum() {
                this.bitField0_ &= -2;
                this.legacyClosedEnum_ = false;
                onChanged();
                return this;
            }

            public Builder clearUtf8Validation() {
                this.bitField0_ &= -3;
                this.utf8Validation_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return JavaFeaturesProto.internal_static_pb_JavaFeatures_descriptor;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean getLegacyClosedEnum() {
                return this.legacyClosedEnum_;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public Utf8Validation getUtf8Validation() {
                Utf8Validation utf8ValidationForNumber = Utf8Validation.forNumber(this.utf8Validation_);
                return utf8ValidationForNumber == null ? Utf8Validation.UTF8_VALIDATION_UNKNOWN : utf8ValidationForNumber;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasLegacyClosedEnum() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasUtf8Validation() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return JavaFeaturesProto.internal_static_pb_JavaFeatures_fieldAccessorTable.ensureFieldAccessorsInitialized(JavaFeatures.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setLegacyClosedEnum(boolean z) {
                this.legacyClosedEnum_ = z;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setUtf8Validation(Utf8Validation utf8Validation) {
                utf8Validation.getClass();
                this.bitField0_ |= 2;
                this.utf8Validation_ = utf8Validation.getNumber();
                onChanged();
                return this;
            }

            private Builder() {
                this.utf8Validation_ = 0;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public JavaFeatures build() {
                JavaFeatures javaFeaturesBuildPartial = buildPartial();
                if (javaFeaturesBuildPartial.isInitialized()) {
                    return javaFeaturesBuildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) javaFeaturesBuildPartial);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public JavaFeatures buildPartial() {
                JavaFeatures javaFeatures = new JavaFeatures(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(javaFeatures);
                }
                onBuilt();
                return javaFeatures;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public JavaFeatures getDefaultInstanceForType() {
                return JavaFeatures.getDefaultInstance();
            }

            private Builder(AbstractMessage.BuilderParent builderParent) {
                super(builderParent);
                this.utf8Validation_ = 0;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.legacyClosedEnum_ = false;
                this.utf8Validation_ = 0;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof JavaFeatures) {
                    return mergeFrom((JavaFeatures) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(JavaFeatures javaFeatures) {
                if (javaFeatures == JavaFeatures.getDefaultInstance()) {
                    return this;
                }
                if (javaFeatures.hasLegacyClosedEnum()) {
                    setLegacyClosedEnum(javaFeatures.getLegacyClosedEnum());
                }
                if (javaFeatures.hasUtf8Validation()) {
                    setUtf8Validation(javaFeatures.getUtf8Validation());
                }
                mergeUnknownFields(javaFeatures.getUnknownFields());
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
                                    this.legacyClosedEnum_ = codedInputStream.readBool();
                                    this.bitField0_ |= 1;
                                } else if (tag != 16) {
                                    if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                    }
                                } else {
                                    int i = codedInputStream.readEnum();
                                    if (Utf8Validation.forNumber(i) == null) {
                                        mergeUnknownVarintField(2, i);
                                    } else {
                                        this.utf8Validation_ = i;
                                        this.bitField0_ |= 2;
                                    }
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
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, xPQrbOSWiEdU.FFyQeFryUo, JavaFeatures.class.getName());
            DEFAULT_INSTANCE = new JavaFeatures();
            PARSER = new AbstractParser<JavaFeatures>() { // from class: com.google.protobuf.JavaFeaturesProto.JavaFeatures.1
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
                public JavaFeatures parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    Builder builderNewBuilder = JavaFeatures.newBuilder();
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

        private JavaFeatures(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.legacyClosedEnum_ = false;
            this.utf8Validation_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(JavaFeatures javaFeatures) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(javaFeatures);
        }

        public static JavaFeatures parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static JavaFeatures parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JavaFeatures) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public JavaFeatures getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static JavaFeatures parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static JavaFeatures parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.AbstractMessage
        public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        private JavaFeatures() {
            this.legacyClosedEnum_ = false;
            this.memoizedIsInitialized = (byte) -1;
            this.utf8Validation_ = 0;
        }

        public static JavaFeatures parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(InputStream inputStream) {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, inputStream);
        }

        public static JavaFeatures parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(CodedInputStream codedInputStream) {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
        }

        public static JavaFeatures parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface JavaFeaturesOrBuilder extends MessageOrBuilder {
        boolean getLegacyClosedEnum();

        JavaFeatures.Utf8Validation getUtf8Validation();

        boolean hasLegacyClosedEnum();

        boolean hasUtf8Validation();
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", JavaFeaturesProto.class.getName());
        GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> generatedExtensionNewFileScopedGeneratedExtension = GeneratedMessage.newFileScopedGeneratedExtension(JavaFeatures.class, JavaFeatures.getDefaultInstance());
        java_ = generatedExtensionNewFileScopedGeneratedExtension;
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#google/protobuf/java_features.proto\u0012\u0002pb\u001a google/protobuf/descriptor.proto\"\u009b\u0005\n\fJavaFeatures\u0012\u0090\u0002\n\u0012legacy_closed_enum\u0018\u0001 \u0001(\bBá\u0001\u0088\u0001\u0001\u0098\u0001\u0004\u0098\u0001\u0001¢\u0001\t\u0012\u0004true\u0018\u0084\u0007¢\u0001\n\u0012\u0005false\u0018ç\u0007²\u0001»\u0001\bè\u0007\u0010è\u0007\u001a²\u0001The legacy closed enum behavior in Java is deprecated and is scheduled to be removed in edition 2025.  See http://protobuf.dev/programming-guides/enum/#java for more information.R\u0010legacyClosedEnum\u0012¯\u0002\n\u000futf8_validation\u0018\u0002 \u0001(\u000e2\u001f.pb.JavaFeatures.Utf8ValidationBä\u0001\u0088\u0001\u0001\u0098\u0001\u0004\u0098\u0001\u0001¢\u0001\f\u0012\u0007DEFAULT\u0018\u0084\u0007²\u0001È\u0001\bè\u0007\u0010é\u0007\u001a¿\u0001The Java-specific utf8 validation feature is deprecated and is scheduled to be removed in edition 2025.  Utf8 validation behavior should use the global cross-language utf8_validation feature.R\u000eutf8Validation\"F\n\u000eUtf8Validation\u0012\u001b\n\u0017UTF8_VALIDATION_UNKNOWN\u0010\u0000\u0012\u000b\n\u0007DEFAULT\u0010\u0001\u0012\n\n\u0006VERIFY\u0010\u0002:B\n\u0004java\u0012\u001b.google.protobuf.FeatureSet\u0018é\u0007 \u0001(\u000b2\u0010.pb.JavaFeaturesR\u0004javaB(\n\u0013com.google.protobufB\u0011JavaFeaturesProto"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_pb_JavaFeatures_descriptor = descriptor2;
        internal_static_pb_JavaFeatures_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(descriptor2, new String[]{"LegacyClosedEnum", "Utf8Validation"});
        generatedExtensionNewFileScopedGeneratedExtension.internalInit(descriptor.getExtensions().get(0));
        descriptor.resolveAllFeaturesImmutable();
        DescriptorProtos.getDescriptor();
    }

    private JavaFeaturesProto() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(java_);
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }
}
