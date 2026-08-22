package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdgz implements zzhgr {
    private final zzdgw zza;

    private zzdgz(zzdgw zzdgwVar) {
        this.zza = zzdgwVar;
    }

    public static zzdgz zza(zzdgw zzdgwVar) {
        return new zzdgz(zzdgwVar);
    }

    public static zzdje zzd(zzdgw zzdgwVar) {
        zzdje zzdjeVarZzb = zzdgwVar.zzb();
        zzhgz.zzb(zzdjeVarZzb);
        return zzdjeVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final zzdje zzc() {
        return zzd(this.zza);
    }
}
