package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdbx implements zzhgr {
    private final zzdbw zza;
    private final zzhha zzb;

    private zzdbx(zzdbw zzdbwVar, zzhha zzhhaVar) {
        this.zza = zzdbwVar;
        this.zzb = zzhhaVar;
    }

    public static zzdbx zza(zzdbw zzdbwVar, zzhha zzhhaVar) {
        return new zzdbx(zzdbwVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcwa zzcwaVarZza = this.zza.zza(((zzhhd) this.zzb).zzb());
        zzhgz.zzb(zzcwaVarZza);
        return zzcwaVarZza;
    }
}
