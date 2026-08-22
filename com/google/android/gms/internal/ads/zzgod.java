package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgod {
    private final zzgxe zza;
    private final Class zzb;

    public /* synthetic */ zzgod(zzgxe zzgxeVar, Class cls, zzgoc zzgocVar) {
        this.zza = zzgxeVar;
        this.zzb = cls;
    }

    public static zzgod zzb(zzgob zzgobVar, zzgxe zzgxeVar, Class cls) {
        return new zzgoa(zzgxeVar, cls, zzgobVar);
    }

    public abstract zzgfm zza(zzgpb zzgpbVar);

    public final zzgxe zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
