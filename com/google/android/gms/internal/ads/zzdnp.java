package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdnp implements zzgdj {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbkf zzb;

    public zzdnp(zzdny zzdnyVar, String str, zzbkf zzbkfVar) {
        this.zza = str;
        this.zzb = zzbkfVar;
        Objects.requireNonNull(zzdnyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcfg) obj).zzag(this.zza, this.zzb);
    }
}
