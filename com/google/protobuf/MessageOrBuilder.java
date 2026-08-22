package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public interface MessageOrBuilder extends MessageLiteOrBuilder {

    /* JADX INFO: renamed from: com.google.protobuf.MessageOrBuilder$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
    }

    List<String> findInitializationErrors();

    Map<Descriptors.FieldDescriptor, Object> getAllFields();

    Message getDefaultInstanceForType();

    Descriptors.Descriptor getDescriptorForType();

    Object getField(Descriptors.FieldDescriptor fieldDescriptor);

    String getInitializationErrorString();

    Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor);

    Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i);

    int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

    UnknownFieldSet getUnknownFields();

    boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

    boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor);
}
