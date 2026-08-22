package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdiq {
    private zzbgm zza;

    public zzdiq(zzdib zzdibVar) {
        this.zza = zzdibVar;
    }

    public final synchronized zzbgm zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbgm zzbgmVar) {
        this.zza = zzbgmVar;
    }
}
