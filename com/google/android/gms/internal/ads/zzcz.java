package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzcz {
    private static final String zzc;
    private static final String zzd;
    public final String zza;
    public final int zzb;

    static {
        String str = zzex.zza;
        zzc = Integer.toString(0, 36);
        zzd = Integer.toString(1, 36);
    }

    public zzcz(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putString(zzc, this.zza);
        bundle.putInt(zzd, this.zzb);
        return bundle;
    }
}
