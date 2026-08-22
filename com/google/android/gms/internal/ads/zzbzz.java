package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzbzz {
    private zzgdy zza;
    private zzdsj zzb;
    private final AtomicBoolean zzc = new AtomicBoolean(false);
    private final AtomicBoolean zzd = new AtomicBoolean(false);
    private long zze = -1;
    private long zzf = -1;

    public static void zza(zzbzz zzbzzVar) {
        zzdsj zzdsjVar;
        while (zzbzzVar.zzd.get()) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbzx
                @Override // java.lang.Runnable
                public final void run() {
                    atomicBoolean.getAndSet(true);
                }
            });
            try {
                Thread.sleep(zzbzzVar.zze);
                if (!atomicBoolean.get()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznV)).booleanValue() && (zzdsjVar = zzbzzVar.zzb) != null) {
                        zzdsi zzdsiVarZza = zzdsjVar.zza();
                        zzdsiVarZza.zzb("action", "paa");
                        zzdsiVarZza.zzi();
                    }
                }
                do {
                    try {
                        Thread.sleep(zzbzzVar.zzf);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                } while (!atomicBoolean.get());
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public final void zzb(zzgdy zzgdyVar, zzdsj zzdsjVar) {
        if (this.zzc.getAndSet(true)) {
            return;
        }
        this.zza = zzgdyVar;
        this.zzb = zzdsjVar;
        zzbcv zzbcvVar = zzbde.zznT;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        this.zze = ((Long) zzbdVar.zzd.zzb(zzbcvVar)).longValue();
        this.zzf = ((Long) zzbdVar.zzd.zzb(zzbde.zznU)).longValue();
    }

    public final void zzc() {
        zzgdy zzgdyVar;
        if (!this.zzc.get() || this.zze < 0 || this.zzf < 0 || !this.zzd.compareAndSet(false, true) || (zzgdyVar = this.zza) == null) {
            return;
        }
        zzgdyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbzy
            @Override // java.lang.Runnable
            public final void run() {
                zzbzz.zza(this.zza);
            }
        });
    }
}
