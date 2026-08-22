package com.google.android.gms.ads.appopen;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.ads.zzbas;
import com.google.android.gms.internal.ads.zzbaw;
import com.google.android.gms.internal.ads.zzbbe;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.yoyogames.runner.RunnerJNILib;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppOpenAd {

    public abstract class AppOpenAdLoadCallback extends AdLoadCallback {
    }

    @Deprecated
    public static boolean isAdAvailable(Context context, String str) {
        try {
            return zzb.zza(context).zzs(str);
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public static void load(Context context, String str, AdRequest adRequest, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        zzah.checkNotNull(context, "Context cannot be null.");
        zzah.checkNotNull(str, "adUnitId cannot be null.");
        zzah.checkNotNull(adRequest, "AdRequest cannot be null.");
        zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzbde.zza(context);
        if (((Boolean) zzbfc.zzd.zze()).booleanValue()) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new RunnerJNILib.AnonymousClass2(3, str, context, adRequest, appOpenAdLoadCallback));
                return;
            }
        }
        new zzbbe(context, str, adRequest.zza, appOpenAdLoadCallback).zza();
    }

    @Deprecated
    public static AppOpenAd pollAd(Context context, String str) {
        try {
            zzbaw zzbawVarZzh = zzb.zza(context).zzh(str);
            if (zzbawVarZzh != null) {
                return new zzbas(zzbawVarZzh, str);
            }
            zzo.zzl("Failed to obtain an App Open ad from the preloader.", null);
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

    public abstract void show(Activity activity);
}
