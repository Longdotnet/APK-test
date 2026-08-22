package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbko implements com.google.android.gms.ads.internal.overlay.zzaa {
    final /* synthetic */ zzbkr zza;

    public zzbko(zzbkr zzbkrVar) {
        Objects.requireNonNull(zzbkrVar);
        this.zza = zzbkrVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaa
    public final void zza(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaa
    public final void zzb(int i) {
        this.zza.zzm(i);
    }
}
