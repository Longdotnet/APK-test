package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzsc {
    public final int zza;
    public final zzvh zzb;
    private final CopyOnWriteArrayList zzc;

    private zzsc(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzvh zzvhVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzvhVar;
    }

    public final zzsc zza(int i, zzvh zzvhVar) {
        return new zzsc(this.zzc, 0, zzvhVar);
    }

    public final void zzb(Handler handler, zzsd zzsdVar) {
        this.zzc.add(new zzsb(handler, zzsdVar));
    }

    public final void zzc(zzsd zzsdVar) {
        CopyOnWriteArrayList<zzsb> copyOnWriteArrayList = this.zzc;
        for (zzsb zzsbVar : copyOnWriteArrayList) {
            if (zzsbVar.zza == zzsdVar) {
                copyOnWriteArrayList.remove(zzsbVar);
            }
        }
    }

    public zzsc() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}
