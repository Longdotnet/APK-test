package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhgs implements zzhgr, zzhgl {
    private static final zzhgs zza = new zzhgs(null);
    private final Object zzb;

    private zzhgs(Object obj) {
        this.zzb = obj;
    }

    public static zzhgr zza(Object obj) {
        zzhgz.zza(obj, "instance cannot be null");
        return new zzhgs(obj);
    }

    public static zzhgr zzc(Object obj) {
        return obj == null ? zza : new zzhgs(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        return this.zzb;
    }
}
