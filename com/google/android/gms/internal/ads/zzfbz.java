package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzfbz {
    private final Clock zza;
    private final zzdsj zzb;
    private final Object zzc = new Object();
    private volatile int zze = 1;
    private volatile long zzd = 0;

    public zzfbz(Clock clock, zzdsj zzdsjVar) {
        this.zza = clock;
        this.zzb = zzdsjVar;
    }

    private final void zze() {
        ((DefaultClock) this.zza).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.zzc) {
            try {
                if (this.zze == 3) {
                    if (this.zzd + ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgj)).longValue() <= jCurrentTimeMillis) {
                        this.zze = 1;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzf(int i, int i2) {
        zze();
        Object obj = this.zzc;
        ((DefaultClock) this.zza).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (obj) {
            try {
                if (this.zze != i) {
                    return;
                }
                this.zze = i2;
                if (this.zze == 3) {
                    this.zzd = jCurrentTimeMillis;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza() {
        zzf(2, 3);
    }

    public final void zzb(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznv)).booleanValue()) {
            zzdsi zzdsiVarZza = this.zzb.zza();
            zzdsiVarZza.zzb("action", "mbs_state");
            zzdsiVarZza.zzb("mbs_state", true != z ? "0" : "1");
            zzdsiVarZza.zzj();
        }
        if (z) {
            zzf(1, 2);
        } else {
            zzf(2, 1);
        }
    }

    public final boolean zzc() {
        boolean z;
        synchronized (this.zzc) {
            zze();
            z = this.zze == 3;
        }
        return z;
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzc) {
            zze();
            z = this.zze == 2;
        }
        return z;
    }
}
