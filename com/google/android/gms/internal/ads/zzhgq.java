package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhgq implements zzhha, zzhgl {
    private static final Object zza = new Object();
    private volatile zzhha zzb;
    private volatile Object zzc = zza;

    private zzhgq(zzhha zzhhaVar) {
        this.zzb = zzhhaVar;
    }

    public static zzhgl zza(zzhha zzhhaVar) {
        return zzhhaVar instanceof zzhgl ? (zzhgl) zzhhaVar : new zzhgq(zzhhaVar);
    }

    public static zzhha zzc(zzhha zzhhaVar) {
        return zzhhaVar instanceof zzhgq ? zzhhaVar : new zzhgq(zzhhaVar);
    }

    private final synchronized Object zzd() {
        try {
            Object obj = this.zzc;
            Object obj2 = zza;
            if (obj != obj2) {
                return obj;
            }
            Object objZzb = this.zzb.zzb();
            Object obj3 = this.zzc;
            if (obj3 != obj2 && obj3 != objZzb) {
                throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objZzb + ". This is likely due to a circular dependency.");
            }
            this.zzc = objZzb;
            this.zzb = null;
            return objZzb;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        Object obj = this.zzc;
        return obj == zza ? zzd() : obj;
    }
}
