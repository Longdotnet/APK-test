package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class zzfml {
    private final zzfnz zza;
    private final String zzb;
    private final zzfls zzc;
    private final String zzd = "Ad overlay";

    public zzfml(View view, zzfls zzflsVar, String str) {
        this.zza = new zzfnz(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = zzflsVar;
    }

    public final zzfls zza() {
        return this.zzc;
    }

    public final zzfnz zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zzb;
    }
}
