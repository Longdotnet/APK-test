package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdvz extends InterstitialAdLoadCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdwf zzb;

    public zzdvz(zzdwf zzdwfVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzdwfVar);
        this.zzb = zzdwfVar;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.zzl(zzdwf.zzk(loadAdError));
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void onAdLoaded(Object obj) {
        this.zzb.zzg(this.zza, (InterstitialAd) obj);
    }
}
