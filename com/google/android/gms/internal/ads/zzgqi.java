package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgqi {
    public static final zzgqi zza = new zzgqi("SHA1");
    public static final zzgqi zzb = new zzgqi("SHA224");
    public static final zzgqi zzc = new zzgqi("SHA256");
    public static final zzgqi zzd = new zzgqi("SHA384");
    public static final zzgqi zze = new zzgqi("SHA512");
    private final String zzf;

    private zzgqi(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
