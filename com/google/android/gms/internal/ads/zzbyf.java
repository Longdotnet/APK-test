package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyf {
    private final Clock zza;
    private final zzbyd zzb;

    public zzbyf(Clock clock, zzbyd zzbydVar) {
        this.zza = clock;
        this.zzb = zzbydVar;
    }

    public static zzbyf zza(Context context) {
        return zzbyp.zzb(context).zza();
    }

    public final void zzb(int i, long j) {
        this.zzb.zza(i, j);
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzfx zzfxVar) {
        ((DefaultClock) this.zza).getClass();
        this.zzb.zza(-1, System.currentTimeMillis());
    }

    public final void zzd() {
        ((DefaultClock) this.zza).getClass();
        this.zzb.zza(-1, System.currentTimeMillis());
    }
}
