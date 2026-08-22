package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzemd implements zzeuc {
    private final Clock zza;
    private final zzfcw zzb;

    public zzemd(Clock clock, zzfcw zzfcwVar) {
        this.zza = clock;
        this.zzb = zzfcwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        Clock clock = this.zza;
        zzfcw zzfcwVar = this.zzb;
        ((DefaultClock) clock).getClass();
        return zzgdn.zzh(new zzeme(zzfcwVar, System.currentTimeMillis()));
    }
}
