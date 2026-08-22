package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfdh implements zzgdj {
    final /* synthetic */ zzfdi zza;
    final /* synthetic */ int zzb;

    public zzfdh(zzfdi zzfdiVar, int i) {
        this.zzb = i;
        Objects.requireNonNull(zzfdiVar);
        this.zza = zzfdiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "BufferingUrlPinger.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzb((String) obj, this.zzb, null);
    }
}
