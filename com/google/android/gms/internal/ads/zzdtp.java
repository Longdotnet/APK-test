package com.google.android.gms.internal.ads;

import com.google.gson.yWTz.kBfGXgdfpo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtp {
    private final zzble zza;

    public zzdtp(zzble zzbleVar) {
        this.zza = zzbleVar;
    }

    private final void zzs(zzdtn zzdtnVar) {
        String strZza = zzdtn.zza(zzdtnVar);
        String strConcat = "Dispatching AFMA event on publisher webview: ".concat(strZza);
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
        this.zza.zzb(strZza);
    }

    public final void zza() {
        zzs(new zzdtn("initialize", null));
    }

    public final void zzb(long j) {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onAdClicked";
        this.zza.zzb(zzdtn.zza(zzdtnVar));
    }

    public final void zzc(long j) {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onAdClosed";
        zzs(zzdtnVar);
    }

    public final void zzd(long j, int i) {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onAdFailedToLoad";
        zzdtnVar.zzd = Integer.valueOf(i);
        zzs(zzdtnVar);
    }

    public final void zze(long j) {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onAdLoaded";
        zzs(zzdtnVar);
    }

    public final void zzf(long j) {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdtnVar);
    }

    public final void zzh(long j) {
        zzdtn zzdtnVar = new zzdtn("creation", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "nativeObjectCreated";
        zzs(zzdtnVar);
    }

    public final void zzi(long j) {
        zzdtn zzdtnVar = new zzdtn("creation", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "nativeObjectNotCreated";
        zzs(zzdtnVar);
    }

    public final void zzj(long j) {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onAdClicked";
        zzs(zzdtnVar);
    }

    public final void zzk(long j) {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onRewardedAdClosed";
        zzs(zzdtnVar);
    }

    public final void zzl(long j, zzbws zzbwsVar) {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onUserEarnedReward";
        zzdtnVar.zze = zzbwsVar.zzf();
        zzdtnVar.zzf = Integer.valueOf(zzbwsVar.zze());
        zzs(zzdtnVar);
    }

    public final void zzm(long j, int i) {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onRewardedAdFailedToLoad";
        zzdtnVar.zzd = Integer.valueOf(i);
        zzs(zzdtnVar);
    }

    public final void zzn(long j, int i) {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onRewardedAdFailedToShow";
        zzdtnVar.zzd = Integer.valueOf(i);
        zzs(zzdtnVar);
    }

    public final void zzo(long j) {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onAdImpression";
        zzs(zzdtnVar);
    }

    public final void zzp(long j) {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onRewardedAdLoaded";
        zzs(zzdtnVar);
    }

    public final void zzq(long j) {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdtnVar);
    }

    public final void zzr(long j) {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onRewardedAdOpened";
        zzs(zzdtnVar);
    }

    public final void zzg(long j) {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = kBfGXgdfpo.RGUyr;
        zzs(zzdtnVar);
    }
}
