package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzagn extends zzaei {
    final /* synthetic */ zzaeu zza;
    final /* synthetic */ zzago zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagn(zzago zzagoVar, zzaeu zzaeuVar, zzaeu zzaeuVar2) {
        super(zzaeuVar);
        this.zza = zzaeuVar2;
        Objects.requireNonNull(zzagoVar);
        this.zzb = zzagoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaei, com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        zzaes zzaesVarZzg = this.zza.zzg(j);
        zzaev zzaevVar = zzaesVarZzg.zza;
        long j2 = zzaevVar.zzc;
        zzago zzagoVar = this.zzb;
        zzaev zzaevVar2 = new zzaev(zzaevVar.zzb, zzagoVar.zzb + j2);
        zzaev zzaevVar3 = zzaesVarZzg.zzb;
        return new zzaes(zzaevVar2, new zzaev(zzaevVar3.zzb, zzagoVar.zzb + zzaevVar3.zzc));
    }
}
