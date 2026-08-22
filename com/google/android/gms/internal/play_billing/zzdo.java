package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzdo extends zzdq {
    private zzdo() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    public final void zza(Object obj, long j) {
        ((zzcz) zzfp.zzf(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    public final void zzb(Object obj, Object obj2, long j) {
        zzcz zzczVarZzd = (zzcz) zzfp.zzf(obj, j);
        zzcz zzczVar = (zzcz) zzfp.zzf(obj2, j);
        int size = zzczVarZzd.size();
        int size2 = zzczVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzczVarZzd.zzc()) {
                zzczVarZzd = zzczVarZzd.zzd(size2 + size);
            }
            zzczVarZzd.addAll(zzczVar);
        }
        if (size > 0) {
            zzczVar = zzczVarZzd;
        }
        zzfp.zzs(obj, j, zzczVar);
    }

    public /* synthetic */ zzdo(zzdn zzdnVar) {
        super(null);
    }
}
