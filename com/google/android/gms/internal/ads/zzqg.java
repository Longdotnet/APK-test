package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class zzqg {
    private final Handler zza;
    private final zzqh zzb;

    public zzqg(Handler handler, zzqh zzqhVar) {
        this.zza = zzqhVar == null ? null : handler;
        this.zzb = zzqhVar;
    }

    public static /* synthetic */ void zza(zzqg zzqgVar, zzid zzidVar) {
        String str = zzex.zza;
        zzqgVar.zzb.zze(zzidVar);
    }

    public static /* synthetic */ void zzb(zzqg zzqgVar, String str) {
        String str2 = zzex.zza;
        zzqgVar.zzb.zzc(str);
    }

    public static /* synthetic */ void zzc(zzqg zzqgVar, long j) {
        String str = zzex.zza;
        zzqgVar.zzb.zzg(j);
    }

    public static /* synthetic */ void zzd(zzqg zzqgVar, zzqi zzqiVar) {
        String str = zzex.zza;
        zzqgVar.zzb.zzk(zzqiVar);
    }

    public static /* synthetic */ void zze(zzqg zzqgVar, int i, long j, long j2) {
        String str = zzex.zza;
        zzqgVar.zzb.zzl(i, j, j2);
    }

    public static /* synthetic */ void zzf(zzqg zzqgVar, Exception exc) {
        String str = zzex.zza;
        zzqgVar.zzb.zzi(exc);
    }

    public static /* synthetic */ void zzg(zzqg zzqgVar, int i) {
        String str = zzex.zza;
        zzqgVar.zzb.zzh(i);
    }

    public static /* synthetic */ void zzh(zzqg zzqgVar, Exception exc) {
        String str = zzex.zza;
        zzqgVar.zzb.zza(exc);
    }

    public static /* synthetic */ void zzi(zzqg zzqgVar, zzz zzzVar, zzie zzieVar) {
        String str = zzex.zza;
        zzqgVar.zzb.zzf(zzzVar, zzieVar);
    }

    public static /* synthetic */ void zzj(zzqg zzqgVar, boolean z) {
        String str = zzex.zza;
        zzqgVar.zzb.zzo(z);
    }

    public static /* synthetic */ void zzk(zzqg zzqgVar, zzqi zzqiVar) {
        String str = zzex.zza;
        zzqgVar.zzb.zzj(zzqiVar);
    }

    public static /* synthetic */ void zzl(zzqg zzqgVar, String str, long j, long j2) {
        String str2 = zzex.zza;
        zzqgVar.zzb.zzb(str, j, j2);
    }

    public static /* synthetic */ void zzm(zzqg zzqgVar, zzid zzidVar) {
        zzidVar.zza();
        String str = zzex.zza;
        zzqgVar.zzb.zzd(zzidVar);
    }

    public final void zzn(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqa
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzh(this.zza, exc);
                }
            });
        }
    }

    public final void zzo(final int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpu
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzg(this.zza, i);
                }
            });
        }
    }

    public final void zzp(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqb
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzf(this.zza, exc);
                }
            });
        }
    }

    public final void zzq(final zzqi zzqiVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpy
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzk(this.zza, zzqiVar);
                }
            });
        }
    }

    public final void zzr(final zzqi zzqiVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpz
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzd(this.zza, zzqiVar);
                }
            });
        }
    }

    public final void zzs(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqe
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzl(this.zza, str, j, j2);
                }
            });
        }
    }

    public final void zzt(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqf
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzb(this.zza, str);
                }
            });
        }
    }

    public final void zzu(final zzid zzidVar) {
        zzidVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpv
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzm(this.zza, zzidVar);
                }
            });
        }
    }

    public final void zzv(final zzid zzidVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpt
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zza(this.zza, zzidVar);
                }
            });
        }
    }

    public final void zzw(final zzz zzzVar, final zzie zzieVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqc
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzi(this.zza, zzzVar, zzieVar);
                }
            });
        }
    }

    public final void zzx(final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpw
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzc(this.zza, j);
                }
            });
        }
    }

    public final void zzy(final boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqd
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zzj(this.zza, z);
                }
            });
        }
    }

    public final void zzz(final int i, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpx
                @Override // java.lang.Runnable
                public final void run() {
                    zzqg.zze(this.zza, i, j, j2);
                }
            });
        }
    }
}
