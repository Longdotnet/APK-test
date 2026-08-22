package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzafk implements zzaeu {
    final /* synthetic */ zzafn zza;
    private final long zzb;

    public zzafk(zzafn zzafnVar, long j) {
        Objects.requireNonNull(zzafnVar);
        this.zza = zzafnVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        zzafn zzafnVar = this.zza;
        zzaes zzaesVarZza = zzafnVar.zzi[0].zza(j);
        for (int i = 1; i < zzafnVar.zzi.length; i++) {
            zzaes zzaesVarZza2 = zzafnVar.zzi[i].zza(j);
            if (zzaesVarZza2.zza.zzc < zzaesVarZza.zza.zzc) {
                zzaesVarZza = zzaesVarZza2;
            }
        }
        return zzaesVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
