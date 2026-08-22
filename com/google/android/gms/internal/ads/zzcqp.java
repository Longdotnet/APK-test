package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzcqp implements zzcxm, zzazd, zzdax {
    private final zzfca zza;
    private final zzcwq zzb;
    private final zzcxv zzc;
    private final zzcym zzf;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();
    private final AtomicBoolean zzg = new AtomicBoolean();

    public zzcqp(zzfca zzfcaVar, zzcwq zzcwqVar, zzcxv zzcxvVar, zzcym zzcymVar) {
        this.zza = zzfcaVar;
        this.zzb = zzcwqVar;
        this.zzc = zzcxvVar;
        this.zzf = zzcymVar;
    }

    private final void zzd() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzdp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzdq() {
        if (this.zza.zze == 4) {
            zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzdr(zzazc zzazcVar) {
        int i = this.zza.zze;
        if (i == 1) {
            if (zzazcVar.zzj) {
                zzd();
            }
        } else if (i == 4 && zzazcVar.zzj && this.zzg.compareAndSet(false, true)) {
            this.zzf.zza();
        }
        if (zzazcVar.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final synchronized void zzu() {
        int i = this.zza.zze;
        if (i == 1 || i == 4) {
            return;
        }
        zzd();
    }
}
