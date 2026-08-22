package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;

/* JADX INFO: loaded from: classes.dex */
public final class ProtobufValueEncoderContext implements ValueEncoderContext {
    public FieldDescriptor field;
    public final ProtobufDataEncoderContext objEncoderCtx;
    public boolean encoded = false;
    public boolean skipDefault = false;

    public ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.objEncoderCtx = protobufDataEncoderContext;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String str) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, str, this.skipDefault);
        return this;
    }

    public final void checkNotUsed() {
        if (this.encoded) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.encoded = true;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(float f) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, f, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(double d) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, d, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(int i) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, i, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(long j) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, j, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, z ? 1 : 0, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(byte[] bArr) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, bArr, this.skipDefault);
        return this;
    }
}
