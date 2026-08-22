package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzfku {
    private final Object zza;
    private final long zzb;
    private final Clock zzc;
    private final long zzd;

    public zzfku(Object obj, Clock clock) {
        this.zza = obj;
        this.zzc = clock;
        ((DefaultClock) clock).getClass();
        this.zzb = System.currentTimeMillis();
        this.zzd = ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzF)).longValue() * 1000;
    }

    public final long zza() {
        long jMin = this.zzd + Math.min(Math.max(((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzA)).longValue(), -900000L), 10000L);
        ((DefaultClock) this.zzc).getClass();
        return jMin - (System.currentTimeMillis() - this.zzb);
    }

    public final long zzb() {
        return this.zzb;
    }

    public final Object zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        long j = this.zzb;
        long j2 = this.zzd;
        ((DefaultClock) this.zzc).getClass();
        return System.currentTimeMillis() >= j + j2;
    }
}
