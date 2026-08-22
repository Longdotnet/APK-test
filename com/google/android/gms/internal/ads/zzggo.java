package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.common.Ko.TSDAbK;

/* JADX INFO: loaded from: classes2.dex */
public final class zzggo {
    public static final zzggo zza = new zzggo("SHA1");
    public static final zzggo zzb = new zzggo("SHA224");
    public static final zzggo zzc = new zzggo(TSDAbK.NpthpSEJS);
    public static final zzggo zzd = new zzggo("SHA384");
    public static final zzggo zze = new zzggo("SHA512");
    private final String zzf;

    private zzggo(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
