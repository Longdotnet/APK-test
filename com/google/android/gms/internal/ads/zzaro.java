package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class zzaro extends zzhgc implements Closeable {
    static {
        zzhgj.zzb(zzaro.class);
    }

    public zzaro(zzhgd zzhgdVar, zzarn zzarnVar) {
        zze(zzhgdVar, zzhgdVar.zzc(), zzarnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhgc, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.google.android.gms.internal.ads.zzhgc
    public final String toString() {
        String string = this.zzc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
