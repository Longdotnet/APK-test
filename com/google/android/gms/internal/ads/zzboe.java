package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzboe implements zzcam {
    final /* synthetic */ zzboc zza;

    public zzboe(zzboh zzbohVar, zzboc zzbocVar) {
        this.zza = zzbocVar;
        Objects.requireNonNull(zzbohVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("Rejecting reference for JS Engine.");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhZ)).booleanValue()) {
            this.zza.zzh(new IllegalStateException("Unable to create JS engine reference."), "SdkJavascriptFactory.createNewReference.FailureCallback");
        } else {
            this.zza.zzg();
        }
    }
}
