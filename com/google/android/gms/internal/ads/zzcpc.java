package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpc implements zzhgr {
    private final zzcoz zza;

    private zzcpc(zzcoz zzcozVar) {
        this.zza = zzcozVar;
    }

    public static zzcpc zza(zzcoz zzcozVar) {
        return new zzcpc(zzcozVar);
    }

    public static zzfcb zzd(zzcoz zzcozVar) {
        zzfcb zzfcbVarZze = zzcozVar.zze();
        zzhgz.zzb(zzfcbVarZze);
        return zzfcbVarZze;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final zzfcb zzc() {
        return zzd(this.zza);
    }
}
