package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbar extends zzbay {
    private final AppOpenAd.AppOpenAdLoadCallback zza;
    private final String zzb;

    public zzbar(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.zza = appOpenAdLoadCallback;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzb(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zza;
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAdFailedToLoad(zzeVar.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzd(zzbaw zzbawVar) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zza;
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAdLoaded(new zzbas(zzbawVar, this.zzb));
        }
    }
}
