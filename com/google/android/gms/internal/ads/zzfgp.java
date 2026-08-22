package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfgp implements zzgdj {
    final /* synthetic */ zzfgg zza;
    final /* synthetic */ zzfgq zzb;

    public zzfgp(zzfgq zzfgqVar, zzfgg zzfggVar) {
        this.zza = zzfggVar;
        Objects.requireNonNull(zzfgqVar);
        this.zzb = zzfgqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        this.zzb.zza.zzd.zzb(this.zza, th);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        this.zzb.zza.zzd.zzd(this.zza);
    }
}
