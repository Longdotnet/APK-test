package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcph implements zzhgr {
    private final zzhha zza;

    private zzcph(zzcoz zzcozVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcph zza(zzcoz zzcozVar, zzhha zzhhaVar) {
        return new zzcph(zzcozVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        zzfyv zzfyvVarZzo = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmY)).booleanValue() ? zzfyv.zzo(new zzddv(((zzcql) this.zza).zzb(), zzcaf.zza)) : zzfyv.zzn();
        zzhgz.zzb(zzfyvVarZzo);
        return zzfyvVarZzo;
    }
}
