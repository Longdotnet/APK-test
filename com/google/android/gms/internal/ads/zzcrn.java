package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcrn implements zzgdj {
    final /* synthetic */ zzgdj zza;
    final /* synthetic */ zzcrp zzb;

    public zzcrn(zzcrp zzcrpVar, zzgdj zzgdjVar) {
        this.zza = zzgdjVar;
        Objects.requireNonNull(zzcrpVar);
        this.zzb = zzcrpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        this.zza.zza(th);
        zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcrj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd = false;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcrp.zzc(this.zzb, ((zzcri) obj).zza, this.zza);
    }
}
