package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzctc implements zzdbq, zzcxm {
    private final Clock zza;
    private final zzcte zzb;
    private final zzfcw zzc;
    private final String zzd;

    public zzctc(Clock clock, zzcte zzcteVar, zzfcw zzfcwVar, String str) {
        this.zza = clock;
        this.zzb = zzcteVar;
        this.zzc = zzfcwVar;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdbq
    public final void zza() {
        Clock clock = this.zza;
        zzcte zzcteVar = this.zzb;
        String str = this.zzd;
        ((DefaultClock) clock).getClass();
        zzcteVar.zze(str, SystemClock.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        Clock clock = this.zza;
        String str = this.zzd;
        ((DefaultClock) clock).getClass();
        this.zzb.zzd(this.zzc.zzf, str, SystemClock.elapsedRealtime());
    }
}
