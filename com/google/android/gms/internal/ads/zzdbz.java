package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdbz implements zzhgr {
    private final zzdbw zza;

    private zzdbz(zzdbw zzdbwVar) {
        this.zza = zzdbwVar;
    }

    public static zzdbz zza(zzdbw zzdbwVar) {
        return new zzdbz(zzdbwVar);
    }

    public static Set zzc(zzdbw zzdbwVar) {
        Set setEmptySet = Collections.emptySet();
        zzhgz.zzb(setEmptySet);
        return setEmptySet;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
