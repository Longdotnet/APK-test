package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzalx implements zzako {
    private final zzalq zza;
    private final long[] zzb;
    private final Map zzc;
    private final Map zzd;
    private final Map zze;

    public zzalx(zzalq zzalqVar, Map map, Map map2, Map map3) {
        this.zza = zzalqVar;
        this.zzd = map2;
        this.zze = map3;
        this.zzc = Collections.unmodifiableMap(map);
        this.zzb = zzalqVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final long zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.ads.zzako
    public final List zzc(long j) {
        return this.zza.zze(j, this.zzc, this.zzd, this.zze);
    }
}
