package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdiz implements zzhgr {
    private final zzhha zza;

    private zzdiz(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdiz zza(zzhha zzhhaVar) {
        return new zzdiz(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdiy(((zzcrr) this.zza).zzc());
    }
}
