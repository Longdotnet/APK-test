package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgmt {
    private final zzgxe zza;
    private final Class zzb;

    public /* synthetic */ zzgmt(zzgxe zzgxeVar, Class cls, zzgms zzgmsVar) {
        this.zza = zzgxeVar;
        this.zzb = cls;
    }

    public static zzgmt zzb(zzgmr zzgmrVar, zzgxe zzgxeVar, Class cls) {
        return new zzgmq(zzgxeVar, cls, zzgmrVar);
    }

    public abstract zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar);

    public final zzgxe zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
