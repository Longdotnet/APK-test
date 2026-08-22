package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbbv extends PushbackInputStream {
    final /* synthetic */ zzbbw zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbbv(zzbbw zzbbwVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        Objects.requireNonNull(zzbbwVar);
        this.zza = zzbbwVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        zzbby.zze(this.zza.zzc);
        super.close();
    }
}
