package com.google.protobuf;

import androidx.core.internal.view.Oteb.nYVxXTZQ;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class MapEntry<K, V> extends AbstractMessage {
    private volatile int cachedSerializedSize;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    public static class Builder<K, V> extends AbstractMessage.Builder<Builder<K, V>> {
        private boolean hasKey;
        private boolean hasValue;
        private K key;
        private final Metadata<K, V> metadata;
        private V value;

        public /* synthetic */ Builder(Metadata metadata) {
            this(metadata);
        }

        private void checkFieldDescriptor(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() == this.metadata.descriptor) {
                return;
            }
            throw new RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
        }

        public Builder<K, V> clearKey() {
            this.key = this.metadata.defaultKey;
            this.hasKey = false;
            return this;
        }

        public Builder<K, V> clearValue() {
            this.value = this.metadata.defaultValue;
            this.hasValue = false;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            TreeMap treeMap = new TreeMap();
            for (Descriptors.FieldDescriptor fieldDescriptor : this.metadata.descriptor.getFields()) {
                if (hasField(fieldDescriptor)) {
                    treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                }
            }
            return Collections.unmodifiableMap(treeMap);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return this.metadata.descriptor;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            Object key = fieldDescriptor.getNumber() == 1 ? getKey() : getValue();
            return fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM ? fieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) key).intValue()) : key;
        }

        public K getKey() {
            return this.key;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getUnknownFields() {
            return UnknownFieldSet.getDefaultInstance();
        }

        public V getValue() {
            return this.value;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            return fieldDescriptor.getNumber() == 1 ? this.hasKey : this.hasValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return MapEntry.isInitialized(this.metadata, this.value);
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 2 && fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return ((Message) this.value).newBuilderForType();
            }
            throw new RuntimeException("\"" + fieldDescriptor.getFullName() + "\" is not a message value field.");
        }

        public Builder<K, V> setKey(K k) {
            this.key = k;
            this.hasKey = true;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return this;
        }

        public Builder<K, V> setValue(V v) {
            this.value = v;
            this.hasValue = true;
            return this;
        }

        public /* synthetic */ Builder(Metadata metadata, Object obj, Object obj2, boolean z, boolean z2) {
            this(metadata, obj, obj2, z, z2);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            throw new RuntimeException(nYVxXTZQ.ynLkTDyTjZF);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 1) {
                clearKey();
            } else {
                clearValue();
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            checkFieldDescriptor(fieldDescriptor);
            if (obj == null) {
                throw new NullPointerException(fieldDescriptor.getFullName() + " is null");
            }
            if (fieldDescriptor.getNumber() == 1) {
                setKey(obj);
            } else {
                if (fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM) {
                    obj = Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber());
                } else if (fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !this.metadata.defaultValue.getClass().isInstance(obj)) {
                    obj = ((Message) this.metadata.defaultValue).toBuilder().mergeFrom((Message) obj).build();
                }
                setValue(obj);
            }
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        private Builder(Metadata<K, V> metadata) {
            this(metadata, metadata.defaultKey, metadata.defaultValue, false, false);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MapEntry<K, V> build() {
            MapEntry<K, V> mapEntryBuildPartial = buildPartial();
            if (mapEntryBuildPartial.isInitialized()) {
                return mapEntryBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) mapEntryBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MapEntry<K, V> buildPartial() {
            return new MapEntry<>(this.metadata, this.key, this.value);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MapEntry<K, V> getDefaultInstanceForType() {
            Metadata<K, V> metadata = this.metadata;
            return new MapEntry<>(metadata, metadata.defaultKey, metadata.defaultValue);
        }

        private Builder(Metadata<K, V> metadata, K k, V v, boolean z, boolean z2) {
            this.metadata = metadata;
            this.key = k;
            this.value = v;
            this.hasKey = z;
            this.hasValue = z2;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public Builder<K, V> mo106clone() {
            return new Builder<>(this.metadata, this.key, this.value, this.hasKey, this.hasValue);
        }
    }

    public static final class Metadata<K, V> extends MapEntryLite.Metadata<K, V> {
        public final Descriptors.Descriptor descriptor;
        public final Parser<MapEntry<K, V>> parser;

        /* JADX INFO: renamed from: com.google.protobuf.MapEntry$Metadata$1 */
        public class AnonymousClass1 extends AbstractParser<MapEntry<K, V>> {
            public AnonymousClass1() {
            }

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
            public MapEntry<K, V> parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new MapEntry<>(Metadata.this, codedInputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(bArr, extensionRegistryLite);
            }
        }

        public Metadata(Descriptors.Descriptor descriptor, MapEntry<K, V> mapEntry, WireFormat.FieldType fieldType, WireFormat.FieldType fieldType2) {
            super(fieldType, ((MapEntry) mapEntry).key, fieldType2, ((MapEntry) mapEntry).value);
            this.descriptor = descriptor;
            this.parser = new AbstractParser<MapEntry<K, V>>() { // from class: com.google.protobuf.MapEntry.Metadata.1
                public AnonymousClass1() {
                }

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
                public MapEntry<K, V> parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return new MapEntry<>(Metadata.this, codedInputStream, extensionRegistryLite);
                }

                @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
                public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                    return super.parseFrom(bArr, extensionRegistryLite);
                }
            };
        }
    }

    public /* synthetic */ MapEntry(Metadata metadata, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this(metadata, codedInputStream, extensionRegistryLite);
    }

    private void checkFieldDescriptor(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.getContainingType() == this.metadata.descriptor) {
            return;
        }
        throw new RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
    }

    public static <K, V> MapEntry<K, V> newDefaultInstance(Descriptors.Descriptor descriptor, WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        return new MapEntry<>(descriptor, fieldType, k, fieldType2, v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        TreeMap treeMap = new TreeMap();
        for (Descriptors.FieldDescriptor fieldDescriptor : this.metadata.descriptor.getFields()) {
            if (hasField(fieldDescriptor)) {
                treeMap.put(fieldDescriptor, getField(fieldDescriptor));
            }
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        checkFieldDescriptor(fieldDescriptor);
        Object key = fieldDescriptor.getNumber() == 1 ? getKey() : getValue();
        return fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM ? fieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) key).intValue()) : key;
    }

    public K getKey() {
        return this.key;
    }

    public final Metadata<K, V> getMetadata() {
        return this.metadata;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MapEntry<K, V>> getParserForType() {
        return this.metadata.parser;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        if (this.cachedSerializedSize != -1) {
            return this.cachedSerializedSize;
        }
        int iComputeSerializedSize = MapEntryLite.computeSerializedSize(this.metadata, this.key, this.value);
        this.cachedSerializedSize = iComputeSerializedSize;
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    public V getValue() {
        return this.value;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        checkFieldDescriptor(fieldDescriptor);
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return isInitialized(this.metadata, this.value);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        MapEntryLite.writeTo(codedOutputStream, this.metadata, this.key, this.value);
    }

    public /* synthetic */ MapEntry(Metadata metadata, Object obj, Object obj2) {
        this(metadata, obj, obj2);
    }

    public static <V> boolean isInitialized(Metadata metadata, V v) {
        if (metadata.valueType.getJavaType() == WireFormat.JavaType.MESSAGE) {
            return ((MessageLite) v).isInitialized();
        }
        return true;
    }

    private MapEntry(Descriptors.Descriptor descriptor, WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        this.cachedSerializedSize = -1;
        this.key = k;
        this.value = v;
        this.metadata = new Metadata<>(descriptor, this, fieldType, fieldType2);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MapEntry<K, V> getDefaultInstanceForType() {
        Metadata<K, V> metadata = this.metadata;
        return new MapEntry<>(metadata, metadata.defaultKey, metadata.defaultValue);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder<K, V> newBuilderForType() {
        return new Builder<>(this.metadata);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder<K, V> toBuilder() {
        return new Builder<>(this.metadata, this.key, this.value, true, true);
    }

    private MapEntry(Metadata metadata, K k, V v) {
        this.cachedSerializedSize = -1;
        this.key = k;
        this.value = v;
        this.metadata = metadata;
    }

    private MapEntry(Metadata<K, V> metadata, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.cachedSerializedSize = -1;
        try {
            this.metadata = metadata;
            Map.Entry entry = MapEntryLite.parseEntry(codedInputStream, metadata, extensionRegistryLite);
            this.key = (K) entry.getKey();
            this.value = (V) entry.getValue();
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
        }
    }
}
