package com.google.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public interface Message extends MessageLite, MessageOrBuilder {

    /* JADX INFO: renamed from: com.google.protobuf.Message$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
    }

    public interface Builder extends MessageLite.Builder, MessageOrBuilder {

        /* JADX INFO: renamed from: com.google.protobuf.Message$Builder$-CC, reason: invalid class name */
        public abstract /* synthetic */ class CC {
        }

        Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        Message build();

        Message buildPartial();

        Builder clear();

        Builder clearField(Descriptors.FieldDescriptor fieldDescriptor);

        Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor);

        /* JADX INFO: renamed from: clone */
        Builder m108clone();

        @Override // com.google.protobuf.MessageOrBuilder
        Descriptors.Descriptor getDescriptorForType();

        Builder getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor);

        Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i);

        @Override // com.google.protobuf.MessageLite.Builder
        boolean mergeDelimitedFrom(InputStream inputStream);

        @Override // com.google.protobuf.MessageLite.Builder
        boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(ByteString byteString);

        Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(CodedInputStream codedInputStream);

        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(Message message);

        Builder mergeFrom(InputStream inputStream);

        Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(byte[] bArr);

        Builder mergeFrom(byte[] bArr, int i, int i2);

        Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet);

        Builder newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor);

        Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj);

        Builder setUnknownFields(UnknownFieldSet unknownFieldSet);
    }

    boolean equals(Object obj);

    Parser<? extends Message> getParserForType();

    int hashCode();

    Builder newBuilderForType();

    Builder toBuilder();

    String toString();
}
