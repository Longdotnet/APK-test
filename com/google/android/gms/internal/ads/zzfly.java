package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfly {
    private final String zza;
    private final String zzb;

    private zzfly(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static zzfly zza(String str, String str2) {
        zzfni.zzb(str, "Name is null or empty");
        zzfni.zzb(str2, "Version is null or empty");
        return new zzfly(str, str2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
