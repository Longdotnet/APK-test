package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzfnv {
    private final BlockingQueue zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private zzfnu zzd = null;

    public zzfnv() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzfnu zzfnuVar = (zzfnu) this.zzc.poll();
        this.zzd = zzfnuVar;
        if (zzfnuVar != null) {
            zzfnuVar.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzfnu zzfnuVar) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzfnu zzfnuVar) {
        zzfnuVar.zzb(this);
        this.zzc.add(zzfnuVar);
        if (this.zzd == null) {
            zzc();
        }
    }
}
