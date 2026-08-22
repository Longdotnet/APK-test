package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzboa implements zzcao {
    final /* synthetic */ zzboc zza;

    public zzboa(zzboc zzbocVar) {
        Objects.requireNonNull(zzbocVar);
        this.zza = zzbocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcao
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("Releasing engine reference.");
        this.zza.zzb.zzd();
    }
}
