package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzky extends zzla {
    public /* synthetic */ zzky(zzkx zzkxVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zza(Object obj, long j) {
        ((zzkm) zzmy.zzf(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zzb(Object obj, Object obj2, long j) {
        zzkm zzkmVarZzd = (zzkm) zzmy.zzf(obj, j);
        zzkm zzkmVar = (zzkm) zzmy.zzf(obj2, j);
        int size = zzkmVarZzd.size();
        int size2 = zzkmVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzkmVarZzd.zzc()) {
                zzkmVarZzd = zzkmVarZzd.zzd(size2 + size);
            }
            zzkmVarZzd.addAll(zzkmVar);
        }
        if (size > 0) {
            zzkmVar = zzkmVarZzd;
        }
        zzmy.zzs(obj, j, zzkmVar);
    }

    private zzky() {
        super(null);
    }
}
