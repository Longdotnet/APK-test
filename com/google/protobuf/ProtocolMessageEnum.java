package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public interface ProtocolMessageEnum extends Internal.EnumLite {
    Descriptors.EnumDescriptor getDescriptorForType();

    @Override // com.google.protobuf.Internal.EnumLite, com.google.protobuf.AbstractMessageLite.InternalOneOfEnum
    int getNumber();

    Descriptors.EnumValueDescriptor getValueDescriptor();
}
