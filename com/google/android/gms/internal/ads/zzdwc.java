package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdwc extends AdListener {
    final /* synthetic */ zzdwf zza;

    public zzdwc(zzdwf zzdwfVar) {
        Objects.requireNonNull(zzdwfVar);
        this.zza = zzdwfVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zza.zzl(zzdwf.zzk(loadAdError));
    }
}
