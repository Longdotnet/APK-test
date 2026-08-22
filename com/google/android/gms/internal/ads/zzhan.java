package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzhan {
    public static final boolean zza(Object obj) {
        return !((zzham) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzham zzhamVarZzb = (zzham) obj;
        zzham zzhamVar = (zzham) obj2;
        if (!zzhamVar.isEmpty()) {
            if (!zzhamVarZzb.zze()) {
                zzhamVarZzb = zzhamVarZzb.zzb();
            }
            zzhamVarZzb.zzd(zzhamVar);
        }
        return zzhamVarZzb;
    }
}
