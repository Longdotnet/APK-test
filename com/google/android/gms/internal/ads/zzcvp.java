package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvp implements zzhgr {
    private final zzcvh zza;

    private zzcvp(zzcvh zzcvhVar) {
        this.zza = zzcvhVar;
    }

    public static zzcvp zza(zzcvh zzcvhVar) {
        return new zzcvp(zzcvhVar);
    }

    public static zzfcw zzd(zzcvh zzcvhVar) {
        zzfcw zzfcwVarZzh = zzcvhVar.zzh();
        zzhgz.zzb(zzfcwVarZzh);
        return zzfcwVarZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final zzfcw zzc() {
        return zzd(this.zza);
    }
}
