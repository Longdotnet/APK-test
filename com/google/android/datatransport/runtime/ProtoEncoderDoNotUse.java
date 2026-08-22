package com.google.android.datatransport.runtime;

import com.google.firebase.encoders.proto.ProtobufEncoder;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProtoEncoderDoNotUse {
    public static final ProtobufEncoder ENCODER = ProtobufEncoder.builder().configureWith(AutoProtoEncoderDoNotUseEncoder.CONFIG).build();
}
