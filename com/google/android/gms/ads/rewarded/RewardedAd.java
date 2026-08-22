package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzbxe;
import com.yoyogames.runner.RunnerJNILib;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RewardedAd {
    @Deprecated
    public static boolean isAdAvailable(Context context, String str) {
        zzah.checkNotNull(context, "Context cannot be null.");
        zzah.checkNotNull(str, "AdUnitId cannot be null.");
        try {
            return zzb.zza(context).zzu(str);
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public static void load(Context context, String str, AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        zzah.checkNotNull(context, "Context cannot be null.");
        zzah.checkNotNull(str, "AdUnitId cannot be null.");
        zzah.checkNotNull(adRequest, "AdRequest cannot be null.");
        zzah.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzbde.zza(context);
        if (((Boolean) zzbfc.zzk.zze()).booleanValue()) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new RunnerJNILib.AnonymousClass2(8, str, context, adRequest, rewardedAdLoadCallback));
                return;
            }
        }
        zzo.zze("Loading on UI thread");
        new zzbxe(context, str).zza(adRequest.zza, rewardedAdLoadCallback);
    }

    @Deprecated
    public static RewardedAd pollAd(Context context, String str) {
        zzah.checkNotNull(context, "Context cannot be null.");
        zzah.checkNotNull(str, "AdUnitId cannot be null.");
        try {
            zzbwv zzbwvVarZzm = zzb.zza(context).zzm(str);
            if (zzbwvVarZzm != null) {
                return new zzbxe(context, str, zzbwvVarZzm);
            }
            zzo.zzl("Failed to obtain a Rewarded Ad from the preloader.", null);
            return null;
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }

    public abstract String getAdUnitId();

    public abstract ResponseInfo getResponseInfo();

    public abstract void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback);

    public abstract void setOnPaidEventListener(OnPaidEventListener onPaidEventListener);

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener);

    public static void load(Context context, String str, AdManagerAdRequest adManagerAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        zzah.checkNotNull(context, "Context cannot be null.");
        zzah.checkNotNull(str, "AdUnitId cannot be null.");
        zzah.checkNotNull(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        zzah.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzbde.zza(context);
        if (((Boolean) zzbfc.zzk.zze()).booleanValue()) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                zzo.zze(gZrKCJ.GhsoetByWdnWD);
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new RunnerJNILib.AnonymousClass2(7, str, context, adManagerAdRequest, rewardedAdLoadCallback));
                return;
            }
        }
        zzo.zze("Loading on UI thread");
        new zzbxe(context, str).zza(adManagerAdRequest.zza, rewardedAdLoadCallback);
    }
}
