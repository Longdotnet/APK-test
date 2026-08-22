package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzawz extends zzauk {
    public Long zza;
    public Long zzb;
    public Long zzc;
    public Long zzd;
    public Long zze;
    public Long zzf;
    public Long zzg;
    public Long zzh;
    public Long zzi;
    public Long zzj;
    public Long zzk;

    public zzawz() {
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, this.zza);
        map.put(1, this.zzb);
        map.put(2, this.zzc);
        map.put(3, this.zzd);
        map.put(4, this.zze);
        map.put(5, this.zzf);
        map.put(6, this.zzg);
        map.put(7, this.zzh);
        map.put(8, this.zzi);
        map.put(9, this.zzj);
        map.put(10, this.zzk);
        return map;
    }

    public zzawz(String str) {
        HashMap mapZza = zzauk.zza(str);
        if (mapZza != null) {
            this.zza = (Long) mapZza.get(0);
            this.zzb = (Long) mapZza.get(1);
            this.zzc = (Long) mapZza.get(2);
            this.zzd = (Long) mapZza.get(3);
            this.zze = (Long) mapZza.get(4);
            this.zzf = (Long) mapZza.get(5);
            this.zzg = (Long) mapZza.get(6);
            this.zzh = (Long) mapZza.get(7);
            this.zzi = (Long) mapZza.get(8);
            this.zzj = (Long) mapZza.get(9);
            this.zzk = (Long) mapZza.get(10);
        }
    }
}
