package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxb extends zzauk {
    public Long zza;
    public Long zzb;
    public Long zzc;
    public Long zzd;
    public Long zze;

    public zzaxb() {
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, this.zza);
        map.put(1, this.zzb);
        map.put(2, this.zzc);
        map.put(3, this.zzd);
        map.put(4, this.zze);
        return map;
    }

    public zzaxb(String str) {
        HashMap mapZza = zzauk.zza(str);
        if (mapZza != null) {
            this.zza = (Long) mapZza.get(0);
            this.zzb = (Long) mapZza.get(1);
            this.zzc = (Long) mapZza.get(2);
            this.zzd = (Long) mapZza.get(3);
            this.zze = (Long) mapZza.get(4);
        }
    }
}
