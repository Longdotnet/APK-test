package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzfh implements zzfo {
    private final zzfo[] zza;

    public zzfh(zzfo... zzfoVarArr) {
        this.zza = zzfoVarArr;
    }

    @Override // com.google.android.gms.internal.auth.zzfo
    public final zzfn zzb(Class<?> cls) {
        zzfo[] zzfoVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzfo zzfoVar = zzfoVarArr[i];
            if (zzfoVar.zzc(cls)) {
                return zzfoVar.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }

    @Override // com.google.android.gms.internal.auth.zzfo
    public final boolean zzc(Class<?> cls) {
        zzfo[] zzfoVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzfoVarArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
