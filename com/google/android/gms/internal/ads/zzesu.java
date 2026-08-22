package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzesu implements zzhgr {
    private final zzhha zza;

    private zzesu(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzesu zza(zzhha zzhhaVar) {
        return new zzesu(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzess(((zzcvk) this.zza).zza());
    }
}
