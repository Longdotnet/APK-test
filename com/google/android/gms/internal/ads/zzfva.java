package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfva implements zzfvq {
    public static zzfva zzc(char c) {
        return new zzfux(c);
    }

    @Override // com.google.android.gms.internal.ads.zzfvq
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c);
}
