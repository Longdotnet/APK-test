package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdoy implements com.google.android.gms.ads.internal.zzn {
    final /* synthetic */ zzdpj zza;

    public zzdoy(zzdpj zzdpjVar) {
        Objects.requireNonNull(zzdpjVar);
        this.zza = zzdpjVar;
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdg() {
        this.zza.zzg.zzb();
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdh() {
        this.zza.zzg.zzc();
    }
}
