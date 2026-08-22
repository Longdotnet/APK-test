package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class zzfmi {
    private static final zzfmi zza = new zzfmi();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfmi() {
    }

    public static zzfmi zza() {
        return zza;
    }

    public final Collection zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zzflp zzflpVar) {
        this.zzb.add(zzflpVar);
    }

    public final void zze(zzflp zzflpVar) {
        ArrayList arrayList = this.zzb;
        boolean zZzg = zzg();
        arrayList.remove(zzflpVar);
        this.zzc.remove(zzflpVar);
        if (!zZzg || zzg()) {
            return;
        }
        zzfmq.zzb().zzg();
    }

    public final void zzf(zzflp zzflpVar) {
        ArrayList arrayList = this.zzc;
        boolean zZzg = zzg();
        arrayList.add(zzflpVar);
        if (zZzg) {
            return;
        }
        zzfmq.zzb().zzf();
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
