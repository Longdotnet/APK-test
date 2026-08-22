package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgmx {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzgmx(Class cls, Class cls2, zzgmw zzgmwVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgmx zzb(zzgmv zzgmvVar, Class cls, Class cls2) {
        return new zzgmu(cls, cls2, zzgmvVar);
    }

    public abstract zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar);

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
