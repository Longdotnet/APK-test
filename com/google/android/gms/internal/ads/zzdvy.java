package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.LoadAdError;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdvy extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ BaseAdView zzb;
    final /* synthetic */ zzdwf zzc;

    public zzdvy(zzdwf zzdwfVar, String str, BaseAdView baseAdView) {
        this.zza = str;
        this.zzb = baseAdView;
        Objects.requireNonNull(zzdwfVar);
        this.zzc = zzdwfVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzc.zzl(zzdwf.zzk(loadAdError));
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        this.zzc.zzg(this.zza, this.zzb);
    }
}
