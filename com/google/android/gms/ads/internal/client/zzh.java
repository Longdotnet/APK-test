package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.internal.ads.zzbmz;

/* JADX INFO: loaded from: classes.dex */
public final class zzh extends zzbm {
    public final AdLoadCallback zza;
    public final zzbmz zzb;

    public zzh(AdLoadCallback adLoadCallback, zzbmz zzbmzVar) {
        this.zza = adLoadCallback;
        this.zzb = zzbmzVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb(zze zzeVar) {
        AdLoadCallback adLoadCallback = this.zza;
        if (adLoadCallback != null) {
            adLoadCallback.onAdFailedToLoad(zzeVar.zzb());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzc() {
        zzbmz zzbmzVar;
        AdLoadCallback adLoadCallback = this.zza;
        if (adLoadCallback == null || (zzbmzVar = this.zzb) == null) {
            return;
        }
        adLoadCallback.onAdLoaded(zzbmzVar);
    }
}
