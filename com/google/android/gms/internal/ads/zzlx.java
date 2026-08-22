package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzlx extends zzuv {
    private final zzbk zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzlx(zzly zzlyVar, zzbl zzblVar) {
        super(zzblVar);
        Objects.requireNonNull(zzlyVar);
        this.zzc = new zzbk();
    }

    @Override // com.google.android.gms.internal.ads.zzuv, com.google.android.gms.internal.ads.zzbl
    public final zzbj zzd(int i, zzbj zzbjVar, boolean z) {
        zzbl zzblVar = this.zzb;
        zzbj zzbjVarZzd = zzblVar.zzd(i, zzbjVar, z);
        if (zzblVar.zze(zzbjVarZzd.zzc, this.zzc, 0L).zzb()) {
            zzbjVarZzd.zzi(zzbjVar.zza, zzbjVar.zzb, zzbjVar.zzc, zzbjVar.zzd, 0L, zzb.zza, true);
        } else {
            zzbjVarZzd.zzf = true;
        }
        return zzbjVarZzd;
    }
}
