package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
final class zzeot {
    public final ListenableFuture zza;
    private final long zzb;
    private final Clock zzc;

    public zzeot(ListenableFuture listenableFuture, long j, Clock clock) {
        this.zza = listenableFuture;
        this.zzc = clock;
        ((DefaultClock) clock).getClass();
        this.zzb = SystemClock.elapsedRealtime() + j;
    }

    public final boolean zza() {
        Clock clock = this.zzc;
        long j = this.zzb;
        ((DefaultClock) clock).getClass();
        return j < SystemClock.elapsedRealtime();
    }
}
