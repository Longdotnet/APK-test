package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzboy implements zzcam {
    final /* synthetic */ zzcak zza;
    final /* synthetic */ zzboc zzb;

    public zzboy(zzbpa zzbpaVar, zzcak zzcakVar, zzboc zzbocVar) {
        this.zza = zzcakVar;
        this.zzb = zzbocVar;
        Objects.requireNonNull(zzbpaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbol("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
