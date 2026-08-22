package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpl implements zzhgr {
    private final zzcoz zza;
    private final zzhha zzb;

    private zzcpl(zzcoz zzcozVar, zzhha zzhhaVar) {
        this.zza = zzcozVar;
        this.zzb = zzhhaVar;
    }

    public static zzcpl zza(zzcoz zzcozVar, zzhha zzhhaVar) {
        return new zzcpl(zzcozVar, zzhhaVar);
    }

    public static zzddv zzc(zzcoz zzcozVar, zzcqn zzcqnVar) {
        return new zzddv(zzcqnVar, zzcaf.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc(this.zza, (zzcqn) this.zzb.zzb());
    }
}
