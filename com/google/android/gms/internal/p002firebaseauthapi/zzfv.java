package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfv {
    private final zzqv zza;
    private final Class zzb;

    public /* synthetic */ zzfv(zzqv zzqvVar, Class cls, zzfu zzfuVar) {
        this.zza = zzqvVar;
        this.zzb = cls;
    }

    public static zzfv zzb(zzft zzftVar, zzqv zzqvVar, Class cls) {
        return new zzfs(zzqvVar, cls, zzftVar);
    }

    public abstract zzaw zza(zzha zzhaVar, zzca zzcaVar);

    public final zzqv zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
