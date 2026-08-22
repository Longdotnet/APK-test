package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgiv {
    public static final zzgiv zza = new zzgiv("ASSUME_AES_GCM");
    public static final zzgiv zzb = new zzgiv("ASSUME_XCHACHA20POLY1305");
    public static final zzgiv zzc = new zzgiv("ASSUME_CHACHA20POLY1305");
    public static final zzgiv zzd = new zzgiv("ASSUME_AES_CTR_HMAC");
    public static final zzgiv zze = new zzgiv("ASSUME_AES_EAX");
    public static final zzgiv zzf = new zzgiv("ASSUME_AES_GCM_SIV");
    private final String zzg;

    private zzgiv(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
