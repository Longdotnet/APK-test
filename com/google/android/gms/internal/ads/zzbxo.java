package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxo extends zzbxb {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzbxp zzb;

    public zzbxo(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzbxp zzbxpVar) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzbxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zze(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzeVar.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zzg() {
        zzbxp zzbxpVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback == null || (zzbxpVar = this.zzb) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.onAdLoaded(zzbxpVar);
    }
}
