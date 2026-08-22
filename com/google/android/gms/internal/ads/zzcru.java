package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcru implements zzhgr {
    private final zzcrq zza;

    private zzcru(zzcrq zzcrqVar) {
        this.zza = zzcrqVar;
    }

    public static zzcru zza(zzcrq zzcrqVar) {
        return new zzcru(zzcrqVar);
    }

    public static zzfcn zzd(zzcrq zzcrqVar) {
        zzfcn zzfcnVarZzc = zzcrqVar.zzc();
        zzhgz.zzb(zzfcnVarZzc);
        return zzfcnVarZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final zzfcn zzc() {
        return zzd(this.zza);
    }
}
