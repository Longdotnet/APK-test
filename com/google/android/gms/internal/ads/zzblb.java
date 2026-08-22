package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.h5.OnH5AdsEventListener;

/* JADX INFO: loaded from: classes.dex */
public final class zzblb extends zzbld {
    private final OnH5AdsEventListener zza;

    public zzblb(OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = onH5AdsEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzble
    public final void zzb(String str) {
        this.zza.onH5AdsEvent(str);
    }
}
