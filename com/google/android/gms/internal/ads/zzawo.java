package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzawo extends zzauk {
    public Long zza;
    public Boolean zzb;
    public Boolean zzc;

    public zzawo() {
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, this.zza);
        map.put(1, this.zzb);
        map.put(2, this.zzc);
        return map;
    }

    public zzawo(String str) {
        HashMap mapZza = zzauk.zza(str);
        if (mapZza != null) {
            this.zza = (Long) mapZza.get(0);
            this.zzb = (Boolean) mapZza.get(1);
            this.zzc = (Boolean) mapZza.get(2);
        }
    }
}
