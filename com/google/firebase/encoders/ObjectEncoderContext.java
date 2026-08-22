package com.google.firebase.encoders;

/* JADX INFO: loaded from: classes.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z);

    @Deprecated
    ObjectEncoderContext add(String str, double d);

    @Deprecated
    ObjectEncoderContext add(String str, int i);

    @Deprecated
    ObjectEncoderContext add(String str, long j);

    @Deprecated
    ObjectEncoderContext add(String str, Object obj);

    @Deprecated
    ObjectEncoderContext add(String str, boolean z);

    ObjectEncoderContext inline(Object obj);

    ObjectEncoderContext nested(FieldDescriptor fieldDescriptor);

    ObjectEncoderContext nested(String str);
}
