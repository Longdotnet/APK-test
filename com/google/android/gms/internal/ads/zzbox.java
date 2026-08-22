package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbox implements zzcao {
    final /* synthetic */ zzboc zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzcak zzc;
    final /* synthetic */ zzbpa zzd;

    public zzbox(zzbpa zzbpaVar, zzboc zzbocVar, Object obj, zzcak zzcakVar) {
        this.zza = zzbocVar;
        this.zzb = obj;
        this.zzc = zzcakVar;
        Objects.requireNonNull(zzbpaVar);
        this.zzd = zzbpaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcao
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzcak zzcakVar = this.zzc;
        zzbpa.zzd(this.zzd, this.zza, (zzboj) obj, obj2, zzcakVar);
    }
}
