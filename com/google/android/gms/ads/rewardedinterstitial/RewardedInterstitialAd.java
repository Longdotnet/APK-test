package com.google.android.gms.ads.rewardedinterstitial;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbxp;
import com.yoyogames.runner.RunnerJNILib;

/* JADX INFO: loaded from: classes.dex */
public abstract class RewardedInterstitialAd {
    public static void load(Context context, String str, AdRequest adRequest, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        zzah.checkNotNull(context, "Context cannot be null.");
        zzah.checkNotNull(str, "AdUnitId cannot be null.");
        zzah.checkNotNull(adRequest, "AdRequest cannot be null.");
        zzah.checkNotNull(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzbde.zza(context);
        if (((Boolean) zzbfc.zzk.zze()).booleanValue()) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                zzb.zzb.execute(new RunnerJNILib.AnonymousClass2(10, str, context, adRequest, rewardedInterstitialAdLoadCallback));
                return;
            }
        }
        new zzbxp(context, str).zza(adRequest.zza, rewardedInterstitialAdLoadCallback);
    }

    public abstract String getAdUnitId();

    public abstract ResponseInfo getResponseInfo();

    public abstract void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback);

    public abstract void setOnPaidEventListener(OnPaidEventListener onPaidEventListener);

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener);

    public static void load(Context context, String str, AdManagerAdRequest adManagerAdRequest, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        zzah.checkNotNull(context, "Context cannot be null.");
        zzah.checkNotNull(str, "AdUnitId cannot be null.");
        zzah.checkNotNull(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        zzah.checkNotNull(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzbde.zza(context);
        if (((Boolean) zzbfc.zzk.zze()).booleanValue()) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                zzb.zzb.execute(new RunnerJNILib.AnonymousClass2(9, str, context, adManagerAdRequest, rewardedInterstitialAdLoadCallback));
                return;
            }
        }
        new zzbxp(context, str).zza(adManagerAdRequest.zza, rewardedInterstitialAdLoadCallback);
    }
}
