package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgoh {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzgoh(Class cls, Class cls2, zzgog zzgogVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgoh zzb(zzgof zzgofVar, Class cls, Class cls2) {
        return new zzgoe(cls, cls2, zzgofVar);
    }

    public abstract zzgpb zza(zzgfm zzgfmVar);

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
