package com.google.android.gms.ads.interstitial;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbmz;
import com.yoyogames.runner.RunnerJNILib;

/* JADX INFO: loaded from: classes.dex */
public abstract class InterstitialAd {
    @Deprecated
    public static boolean isAdAvailable(Context context, String str) {
        try {
            return zzb.zza(context).zzt(str);
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public static void load(Context context, String str, AdRequest adRequest, InterstitialAdLoadCallback interstitialAdLoadCallback) {
        zzah.checkNotNull(context, "Context cannot be null.");
        zzah.checkNotNull(str, "AdUnitId cannot be null.");
        zzah.checkNotNull(adRequest, "AdRequest cannot be null.");
        zzah.checkNotNull(interstitialAdLoadCallback, "LoadCallback cannot be null.");
        zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzbde.zza(context);
        if (((Boolean) zzbfc.zzi.zze()).booleanValue()) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new RunnerJNILib.AnonymousClass2(4, str, context, adRequest, interstitialAdLoadCallback));
                return;
            }
        }
        new zzbmz(context, str).zza(adRequest.zza, interstitialAdLoadCallback);
    }

    @Deprecated
    public static InterstitialAd pollAd(Context context, String str) {
        try {
            zzbx zzbxVarZzj = zzb.zza(context).zzj(str);
            if (zzbxVarZzj != null) {
                return new zzbmz(context, str, zzbxVarZzj);
            }
            zzo.zzl("Failed to obtain an Interstitial Ad from the preloader.", null);
            return null;
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }

    public abstract String getAdUnitId();

    public abstract ResponseInfo getResponseInfo();

    public abstract void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback);

    public abstract void setImmersiveMode(boolean z);

    public abstract void setOnPaidEventListener(OnPaidEventListener onPaidEventListener);

    public abstract void show(Activity activity);
}
