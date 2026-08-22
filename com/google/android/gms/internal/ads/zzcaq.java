package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcaq implements zzgdj {
    final /* synthetic */ zzcao zza;
    final /* synthetic */ zzcam zzb;

    public zzcaq(zzcar zzcarVar, zzcao zzcaoVar, zzcam zzcamVar) {
        this.zza = zzcaoVar;
        this.zzb = zzcamVar;
        Objects.requireNonNull(zzcarVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        this.zza.zza(obj);
    }
}
