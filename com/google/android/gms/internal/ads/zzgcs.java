package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgcs extends zzgcb.zzf {
    private static final zzgco zzbg;
    private static final zzgdw zzbh = new zzgdw(zzgcs.class);
    volatile int remainingField;
    volatile Set<Throwable> seenExceptionsField = null;

    static {
        Throwable th;
        zzgco zzgcqVar;
        try {
            zzgcqVar = new zzgcp(null);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzgcqVar = new zzgcq(null);
        }
        zzbg = zzgcqVar;
        if (th != null) {
            zzbh.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    public zzgcs(int i) {
        this.remainingField = i;
    }

    public final int zzB() {
        return zzbg.zza(this);
    }

    public final Set zzC() {
        Set<Throwable> set = this.seenExceptionsField;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzw(setNewSetFromMap);
        zzbg.zzb(this, null, setNewSetFromMap);
        Set<Throwable> set2 = this.seenExceptionsField;
        Objects.requireNonNull(set2);
        return set2;
    }

    public abstract void zzw(Set set);
}
