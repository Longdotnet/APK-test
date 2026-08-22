package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhhe implements zzhha {
    private static final Object zza = new Object();
    private volatile zzhha zzb;
    private volatile Object zzc = zza;

    private zzhhe(zzhha zzhhaVar) {
        this.zzb = zzhhaVar;
    }

    public static zzhha zza(zzhha zzhhaVar) {
        return ((zzhhaVar instanceof zzhhe) || (zzhhaVar instanceof zzhgq)) ? zzhhaVar : new zzhhe(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzhha zzhhaVar = this.zzb;
        if (zzhhaVar == null) {
            return this.zzc;
        }
        Object objZzb = zzhhaVar.zzb();
        this.zzc = objZzb;
        this.zzb = null;
        return objZzb;
    }
}
