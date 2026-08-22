package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdhu implements zzhgr {
    private final zzdhp zza;

    private zzdhu(zzdhp zzdhpVar) {
        this.zza = zzdhpVar;
    }

    public static zzdhu zza(zzdhp zzdhpVar) {
        return new zzdhu(zzdhpVar);
    }

    public static zzdny zzd(zzdhp zzdhpVar) {
        zzdny zzdnyVarZzc = zzdhpVar.zzc();
        zzhgz.zzb(zzdnyVarZzc);
        return zzdnyVarZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final zzdny zzc() {
        return zzd(this.zza);
    }
}
