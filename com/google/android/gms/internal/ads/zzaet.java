package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzaet implements zzaeu {
    private final long zza;
    private final zzaes zzb;

    public zzaet(long j, long j2) {
        this.zza = j;
        zzaev zzaevVar = j2 == 0 ? zzaev.zza : new zzaev(0L, j2);
        this.zzb = new zzaes(zzaevVar, zzaevVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return false;
    }
}
