package com.google.protobuf;

import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Struct extends GeneratedMessage implements StructOrBuilder {
    private static final Struct DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static final Parser<Struct> PARSER;
    private static final long serialVersionUID = 0;
    private MapField<String, Value> fields_;
    private byte memoizedIsInitialized;

    public static final class FieldsDefaultEntryHolder {
        static final MapEntry<String, Value> defaultEntry = MapEntry.newDefaultInstance(StructProto.internal_static_google_protobuf_Struct_FieldsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

        private FieldsDefaultEntryHolder() {
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", Struct.class.getName());
        DEFAULT_INSTANCE = new Struct();
        PARSER = new AbstractParser<Struct>() { // from class: com.google.protobuf.Struct.1
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
            public Struct parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = Struct.newBuilder();
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

    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapField<String, Value> internalGetFields() {
        MapField<String, Value> mapField = this.fields_;
        return mapField == null ? MapField.emptyMapField(FieldsDefaultEntryHolder.defaultEntry) : mapField;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Struct parseDelimitedFrom(InputStream inputStream) {
        return (Struct) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Struct parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Struct> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Struct)) {
            return super.equals(obj);
        }
        Struct struct = (Struct) obj;
        return internalGetFields().equals(struct.internalGetFields()) && getUnknownFields().equals(struct.getUnknownFields());
    }

    @Override // com.google.protobuf.StructOrBuilder
    @Deprecated
    public Map<String, Value> getFields() {
        return getFieldsMap();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public int getFieldsCount() {
        return internalGetFields().getMap().size();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Map<String, Value> getFieldsMap() {
        return internalGetFields().getMap();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Value getFieldsOrDefault(String str, Value value) {
        if (str == null) {
            throw new NullPointerException("map key");
        }
        Map<String, Value> map = internalGetFields().getMap();
        return map.containsKey(str) ? map.get(str) : value;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Value getFieldsOrThrow(String str) {
        if (str == null) {
            throw new NullPointerException("map key");
        }
        Map<String, Value> map = internalGetFields().getMap();
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Struct> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (Map.Entry<String, Value> entry : internalGetFields().getMap().entrySet()) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(1, FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeMessageSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getDescriptor().hashCode() + 779;
        if (!internalGetFields().getMap().isEmpty()) {
            iHashCode = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 1, 53) + internalGetFields().hashCode();
        }
        int iHashCode2 = getUnknownFields().hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage
    public MapFieldReflectionAccessor internalGetMapFieldReflection(int i) {
        if (i == 1) {
            return internalGetFields();
        }
        throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Invalid map field number: "));
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
        GeneratedMessage.serializeStringMapTo(codedOutputStream, internalGetFields(), FieldsDefaultEntryHolder.defaultEntry, 1);
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements StructOrBuilder {
        private static final FieldsConverter fieldsConverter = new FieldsConverter();
        private int bitField0_;
        private MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> fields_;

        public static final class FieldsConverter implements MapFieldBuilder.Converter<String, ValueOrBuilder, Value> {
            private FieldsConverter() {
            }

            @Override // com.google.protobuf.MapFieldBuilder.Converter
            public MapEntry<String, Value> defaultEntry() {
                return FieldsDefaultEntryHolder.defaultEntry;
            }

            @Override // com.google.protobuf.MapFieldBuilder.Converter
            public Value build(ValueOrBuilder valueOrBuilder) {
                return valueOrBuilder instanceof Value ? (Value) valueOrBuilder : ((Value.Builder) valueOrBuilder).build();
            }
        }

        private void buildPartial0(Struct struct) {
            if ((this.bitField0_ & 1) != 0) {
                struct.fields_ = internalGetFields().build(FieldsDefaultEntryHolder.defaultEntry);
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        private MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> internalGetFields() {
            MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> mapFieldBuilder = this.fields_;
            return mapFieldBuilder == null ? new MapFieldBuilder<>(fieldsConverter) : mapFieldBuilder;
        }

        private MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> internalGetMutableFields() {
            if (this.fields_ == null) {
                this.fields_ = new MapFieldBuilder<>(fieldsConverter);
            }
            this.bitField0_ |= 1;
            onChanged();
            return this.fields_;
        }

        public Builder clearFields() {
            this.bitField0_ &= -2;
            internalGetMutableFields().clear();
            return this;
        }

        @Override // com.google.protobuf.StructOrBuilder
        public boolean containsFields(String str) {
            if (str != null) {
                return internalGetFields().ensureBuilderMap().containsKey(str);
            }
            throw new NullPointerException("map key");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        @Override // com.google.protobuf.StructOrBuilder
        @Deprecated
        public Map<String, Value> getFields() {
            return getFieldsMap();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public int getFieldsCount() {
            return internalGetFields().ensureBuilderMap().size();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Map<String, Value> getFieldsMap() {
            return internalGetFields().getImmutableMap();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Value getFieldsOrDefault(String str, Value value) {
            if (str == null) {
                throw new NullPointerException("map key");
            }
            Map<String, MessageOrBuilderT> mapEnsureBuilderMap = internalGetMutableFields().ensureBuilderMap();
            return mapEnsureBuilderMap.containsKey(str) ? fieldsConverter.build((ValueOrBuilder) mapEnsureBuilderMap.get(str)) : value;
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Value getFieldsOrThrow(String str) {
            if (str == null) {
                throw new NullPointerException("map key");
            }
            Map<String, MessageOrBuilderT> mapEnsureBuilderMap = internalGetMutableFields().ensureBuilderMap();
            if (mapEnsureBuilderMap.containsKey(str)) {
                return fieldsConverter.build((ValueOrBuilder) mapEnsureBuilderMap.get(str));
            }
            throw new IllegalArgumentException();
        }

        @Deprecated
        public Map<String, Value> getMutableFields() {
            this.bitField0_ |= 1;
            return internalGetMutableFields().ensureMessageMap();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public MapFieldReflectionAccessor internalGetMapFieldReflection(int i) {
            if (i == 1) {
                return internalGetFields();
            }
            throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Invalid map field number: "));
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public MapFieldReflectionAccessor internalGetMutableMapFieldReflection(int i) {
            if (i == 1) {
                return internalGetMutableFields();
            }
            throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Invalid map field number: "));
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder putAllFields(Map<String, Value> map) {
            for (Map.Entry<String, Value> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw null;
                }
            }
            internalGetMutableFields().ensureBuilderMap().putAll(map);
            this.bitField0_ |= 1;
            return this;
        }

        public Builder putFields(String str, Value value) {
            if (str == null) {
                throw new NullPointerException("map key");
            }
            if (value == null) {
                throw new NullPointerException("map value");
            }
            internalGetMutableFields().ensureBuilderMap().put(str, value);
            this.bitField0_ |= 1;
            return this;
        }

        public Value.Builder putFieldsBuilderIfAbsent(String str) {
            Map<String, MessageOrBuilderT> mapEnsureBuilderMap = internalGetMutableFields().ensureBuilderMap();
            Object builder = (ValueOrBuilder) mapEnsureBuilderMap.get(str);
            if (builder == null) {
                builder = Value.newBuilder();
                mapEnsureBuilderMap.put(str, builder);
            }
            if (builder instanceof Value) {
                builder = ((Value) builder).toBuilder();
                mapEnsureBuilderMap.put(str, builder);
            }
            return (Value.Builder) builder;
        }

        public Builder removeFields(String str) {
            if (str == null) {
                throw new NullPointerException("map key");
            }
            internalGetMutableFields().ensureBuilderMap().remove(str);
            return this;
        }

        private Builder() {
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Struct build() {
            Struct structBuildPartial = buildPartial();
            if (structBuildPartial.isInitialized()) {
                return structBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) structBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Struct buildPartial() {
            Struct struct = new Struct(this);
            if (this.bitField0_ != 0) {
                buildPartial0(struct);
            }
            onBuilt();
            return struct;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Struct getDefaultInstanceForType() {
            return Struct.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            internalGetMutableFields().clear();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Struct) {
                return mergeFrom((Struct) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Struct struct) {
            if (struct == Struct.getDefaultInstance()) {
                return this;
            }
            internalGetMutableFields().mergeFrom(struct.internalGetFields());
            this.bitField0_ |= 1;
            mergeUnknownFields(struct.getUnknownFields());
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
                            if (tag != 10) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(FieldsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                internalGetMutableFields().ensureBuilderMap().put((String) mapEntry.getKey(), (ValueOrBuilder) mapEntry.getValue());
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

    private Struct(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(Struct struct) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(struct);
    }

    public static Struct parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    @Override // com.google.protobuf.StructOrBuilder
    public boolean containsFields(String str) {
        if (str != null) {
            return internalGetFields().getMap().containsKey(str);
        }
        throw new NullPointerException(bUqMCsuPSX.eUZt);
    }

    public static Struct parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Struct parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Struct getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    private Struct() {
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Struct parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Struct parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static Struct parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Struct parseFrom(InputStream inputStream) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Struct parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Struct parseFrom(CodedInputStream codedInputStream) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Struct parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
