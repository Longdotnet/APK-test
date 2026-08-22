package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzaru extends zzhfy {
    public zzaru(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzhfy
    public final void zze(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.remaining() + byteBuffer.position());
    }
}
