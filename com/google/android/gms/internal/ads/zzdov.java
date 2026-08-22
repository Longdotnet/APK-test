package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdov implements zzhgr {
    private final zzhha zza;

    private zzdov(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdov zza(zzhha zzhhaVar) {
        return new zzdov(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbcj.zza.EnumC0001zza enumC0001zza = ((zzcvp) this.zza).zzc().zzo.zza == 3 ? zzbcj.zza.EnumC0001zza.REWARDED_INTERSTITIAL : zzbcj.zza.EnumC0001zza.REWARD_BASED_VIDEO_AD;
        zzhgz.zzb(enumC0001zza);
        return enumC0001zza;
    }
}
