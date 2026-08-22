package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;

/* JADX INFO: loaded from: classes.dex */
public final class zzbat extends zzbbc {
    private FullScreenContentCallback zza;

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzc() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzd(com.google.android.gms.ads.internal.client.zze zzeVar) {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzeVar.zza());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzf() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void zzg(FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
    }
}
