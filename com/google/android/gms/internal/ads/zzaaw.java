package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzaaw implements zzacm {
    final /* synthetic */ zztf zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzaba zzd;

    public zzaaw(zzaba zzabaVar, zztf zztfVar, int i, long j) {
        this.zza = zztfVar;
        this.zzb = i;
        this.zzc = j;
        Objects.requireNonNull(zzabaVar);
        this.zzd = zzabaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zza(long j) {
        this.zzd.zzam(this.zza, this.zzb, this.zzc, j);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zzb() {
        this.zzd.zzas(this.zza, this.zzb, this.zzc);
    }
}
