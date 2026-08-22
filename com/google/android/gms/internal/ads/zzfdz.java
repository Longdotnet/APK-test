package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzfdz implements zzhgr {
    private zzfdz(zzfdy zzfdyVar) {
    }

    public static zzfdz zza(zzfdy zzfdyVar) {
        return new zzfdz(zzfdyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        DefaultClock defaultClock = DefaultClock.zza;
        zzhgz.zzb(defaultClock);
        return defaultClock;
    }
}
