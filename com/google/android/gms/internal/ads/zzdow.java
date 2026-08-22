package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdow implements zzhgr {
    private final zzhha zza;

    private zzdow(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdow zza(zzhha zzhhaVar) {
        return new zzdow(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((zzcvp) this.zza).zzc().zzo.zza == 3 ? "rewarded_interstitial" : "rewarded";
    }
}
