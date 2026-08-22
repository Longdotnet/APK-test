package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.measurement.zzby;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzap {
    public static volatile zzby zza;
    public final zzgm zzb;
    public final com.google.android.gms.ads.zza zzc;
    public volatile long zzd;

    public zzap(zzgm zzgmVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzgmVar);
        this.zzb = zzgmVar;
        this.zzc = new com.google.android.gms.ads.zza((Object) this, (Object) zzgmVar, 27, false);
    }

    public final void zzb() {
        this.zzd = 0L;
        zzf().removeCallbacks(this.zzc);
    }

    public abstract void zzc();

    public final void zzd(long j) {
        zzb();
        if (j >= 0) {
            ((DefaultClock) this.zzb.zzav()).getClass();
            this.zzd = System.currentTimeMillis();
            if (zzf().postDelayed(this.zzc, j)) {
                return;
            }
            this.zzb.zzay().zzd.zzb(Long.valueOf(j), "Failed to schedule delayed post. time");
        }
    }

    public final Handler zzf() {
        zzby zzbyVar;
        if (zza != null) {
            return zza;
        }
        synchronized (zzap.class) {
            try {
                if (zza == null) {
                    zza = new zzby(this.zzb.zzau().getMainLooper());
                }
                zzbyVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbyVar;
    }
}
