package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzaqo {
    public static final boolean zza = zzaqp.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    public final void finalize() {
        if (this.zzc) {
            return;
        }
        zzb("Request on the loose");
        zzaqp.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }

    public final synchronized void zza(String str, long j) {
        if (this.zzc) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.zzb.add(new zzaqn(str, j, SystemClock.elapsedRealtime()));
    }

    public final synchronized void zzb(String str) {
        this.zzc = true;
        List<zzaqn> list = this.zzb;
        long j = list.size() == 0 ? 0L : ((zzaqn) list.get(list.size() - 1)).zzc - ((zzaqn) list.get(0)).zzc;
        if (j > 0) {
            long j2 = ((zzaqn) list.get(0)).zzc;
            zzaqp.zza("(%-4d ms) %s", Long.valueOf(j), str);
            for (zzaqn zzaqnVar : list) {
                long j3 = zzaqnVar.zzc;
                zzaqp.zza("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(zzaqnVar.zzb), zzaqnVar.zza);
                j2 = j3;
            }
        }
    }
}
