package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdya implements zzgdj {
    final /* synthetic */ zzdyb zza;

    public zzdya(zzdyb zzdybVar) {
        Objects.requireNonNull(zzdybVar);
        this.zza = zzdybVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        zzfcn zzfcnVar = (zzfcn) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcv)).booleanValue()) {
            this.zza.zzl.zzdo(zzfcnVar);
        }
    }
}
