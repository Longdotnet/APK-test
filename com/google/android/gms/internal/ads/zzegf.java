package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzegf extends zzbri {
    final /* synthetic */ zzegh zza;
    private final zzedp zzb;

    public /* synthetic */ zzegf(zzegh zzeghVar, zzedp zzedpVar, zzegg zzeggVar) {
        Objects.requireNonNull(zzeghVar);
        this.zza = zzeghVar;
        this.zzb = zzedpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final void zze(String str) {
        ((zzefd) this.zzb.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        ((zzefd) this.zzb.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final void zzg(zzbqf zzbqfVar) {
        this.zza.zzc = zzbqfVar;
        ((zzefd) this.zzb.zzc).zzo();
    }
}
