package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxl {
    private final zzbpw zza;

    public zzbxl(zzbpw zzbpwVar) {
        this.zza = zzbpwVar;
    }

    public final void onAdClosed() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(AdError adError) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdFailedToShow.");
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(adError.zza, "Mediation ad failed to show: Error Code = ", ". Error Message = ");
        sbM.append(adError.zzb);
        sbM.append(" Error Domain = ");
        sbM.append(adError.zzc);
        com.google.android.gms.ads.internal.util.client.zzo.zzj(sbM.toString());
        try {
            this.zza.zzk(adError.zza());
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onUserEarnedReward() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onUserEarnedReward.");
        try {
            this.zza.zzu();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoComplete() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onVideoComplete.");
        try {
            this.zza.zzv();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoStart() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onVideoStart.");
        try {
            this.zza.zzz();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdClicked() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called reportAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdImpression() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called reportAdImpression.");
        try {
            this.zza.zzm();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onUserEarnedReward.");
        try {
            this.zza.zzt(new zzbxm(rewardItem));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(String str) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdFailedToShow.");
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Mediation ad failed to show: ".concat(String.valueOf(str)));
        try {
            this.zza.zzl(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
