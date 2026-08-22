package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzawd extends zzauk {
    public long zza;
    public long zzb;

    public zzawd() {
        this.zza = -1L;
        this.zzb = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, Long.valueOf(this.zza));
        map.put(1, Long.valueOf(this.zzb));
        return map;
    }

    public zzawd(String str) {
        this.zza = -1L;
        this.zzb = -1L;
        HashMap mapZza = zzauk.zza(str);
        if (mapZza != null) {
            this.zza = ((Long) mapZza.get(0)).longValue();
            this.zzb = ((Long) mapZza.get(1)).longValue();
        }
    }
}
