package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzaqg {
    private final AtomicInteger zza;
    private final Set zzb;
    private final PriorityBlockingQueue zzc;
    private final PriorityBlockingQueue zzd;
    private final zzapn zze;
    private final zzapw zzf;
    private final zzapx[] zzg;
    private zzapp zzh;
    private final List zzi;
    private final List zzj;
    private final zzapu zzk;

    public zzaqg(zzapn zzapnVar, zzapw zzapwVar, int i) {
        zzapu zzapuVar = new zzapu(new Handler(Looper.getMainLooper()));
        this.zza = new AtomicInteger();
        this.zzb = new HashSet();
        this.zzc = new PriorityBlockingQueue();
        this.zzd = new PriorityBlockingQueue();
        this.zzi = new ArrayList();
        this.zzj = new ArrayList();
        this.zze = zzapnVar;
        this.zzf = zzapwVar;
        this.zzg = new zzapx[4];
        this.zzk = zzapuVar;
    }

    public final zzaqd zza(zzaqd zzaqdVar) {
        zzaqdVar.zzf(this);
        Set set = this.zzb;
        synchronized (set) {
            set.add(zzaqdVar);
        }
        zzaqdVar.zzg(this.zza.incrementAndGet());
        zzaqdVar.zzm("add-to-queue");
        zzc(zzaqdVar, 0);
        this.zzc.add(zzaqdVar);
        return zzaqdVar;
    }

    public final void zzb(zzaqd zzaqdVar) {
        Set set = this.zzb;
        synchronized (set) {
            set.remove(zzaqdVar);
        }
        List list = this.zzi;
        synchronized (list) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((zzaqf) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzc(zzaqdVar, 5);
    }

    public final void zzc(zzaqd zzaqdVar, int i) {
        List list = this.zzj;
        synchronized (list) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((zzaqe) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd() {
        zzapp zzappVar = this.zzh;
        if (zzappVar != null) {
            zzappVar.zzb();
        }
        zzapx[] zzapxVarArr = this.zzg;
        for (int i = 0; i < 4; i++) {
            zzapx zzapxVar = zzapxVarArr[i];
            if (zzapxVar != null) {
                zzapxVar.zza();
            }
        }
        PriorityBlockingQueue priorityBlockingQueue = this.zzc;
        PriorityBlockingQueue priorityBlockingQueue2 = this.zzd;
        zzapn zzapnVar = this.zze;
        zzapu zzapuVar = this.zzk;
        zzapp zzappVar2 = new zzapp(priorityBlockingQueue, priorityBlockingQueue2, zzapnVar, zzapuVar);
        this.zzh = zzappVar2;
        zzappVar2.start();
        for (int i2 = 0; i2 < 4; i2++) {
            zzapx zzapxVar2 = new zzapx(priorityBlockingQueue2, this.zzf, zzapnVar, zzapuVar);
            zzapxVarArr[i2] = zzapxVar2;
            zzapxVar2.start();
        }
    }
}
