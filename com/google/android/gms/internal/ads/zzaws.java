package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzaws extends zzauk {
    public Long zza;
    public Long zzb;

    public zzaws() {
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, this.zza);
        map.put(1, this.zzb);
        return map;
    }

    public zzaws(String str) {
        HashMap mapZza = zzauk.zza(str);
        if (mapZza != null) {
            this.zza = (Long) mapZza.get(0);
            this.zzb = (Long) mapZza.get(1);
        }
    }
}
