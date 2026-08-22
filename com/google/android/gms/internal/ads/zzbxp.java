package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import androidx.loader.app.gv.DYYbQc;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxp extends RewardedInterstitialAd {
    private final String zza;
    private final zzbwv zzb;
    private final Context zzc;
    private final zzbxn zzd;
    private FullScreenContentCallback zze;
    private OnAdMetadataChangedListener zzf;
    private OnPaidEventListener zzg;
    private final long zzh = System.currentTimeMillis();
    private final AtomicLong zzi = new AtomicLong();

    public zzbxp(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        TooltipPopup tooltipPopup = com.google.android.gms.ads.internal.client.zzbb.zzb.zzd;
        zzbpm zzbpmVar = new zzbpm();
        tooltipPopup.getClass();
        this.zzb = (zzbwv) new com.google.android.gms.ads.internal.client.zzaa(tooltipPopup, context, str, zzbpmVar).zzd(context, false);
        this.zzd = new zzbxn();
    }

    public final Bundle getAdMetadata() {
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                return zzbwvVar.zzc();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final String getAdUnitId() {
        return this.zza;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zze;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    public final long getPlacementId() {
        AtomicLong atomicLong = this.zzi;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        synchronized (this) {
            try {
                try {
                    zzbwv zzbwvVar = this.zzb;
                    if (zzbwvVar != null) {
                        long jZzb = zzbwvVar.zzb();
                        AtomicLong atomicLong2 = this.zzi;
                        atomicLong2.set(jZzb);
                        return atomicLong2.get();
                    }
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                }
                return 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final ResponseInfo getResponseInfo() {
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzd = null;
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzeaVarZzd = zzbwvVar.zzd();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl(DYYbQc.XHCbiTMR, e);
        }
        return new ResponseInfo(zzeaVarZzd);
    }

    public final RewardItem getRewardItem() {
        try {
            zzbwv zzbwvVar = this.zzb;
            zzbws zzbwsVarZze = zzbwvVar != null ? zzbwvVar.zze() : null;
            if (zzbwsVarZze != null) {
                return new zzbxf(zzbwsVarZze);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zze = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzbwvVar.zzj(z);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzf = onAdMetadataChangedListener;
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzbwvVar.zzk(new com.google.android.gms.ads.internal.client.zzft(onAdMetadataChangedListener));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzg = onPaidEventListener;
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzbwvVar.zzl(new com.google.android.gms.ads.internal.client.zzfu(onPaidEventListener));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setPlacementId(long j) {
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzbwvVar.zzm(j);
                this.zzi.set(j);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzbwvVar.zzo(new zzbxj(serverSideVerificationOptions));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        zzbxn zzbxnVar = this.zzd;
        zzbxnVar.zzc(onUserEarnedRewardListener);
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzbwvVar.zzn(zzbxnVar);
                zzbwvVar.zzp(new ObjectWrapper(activity));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.client.zzek zzekVar, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzekVar.zzn = this.zzh;
                zzbwvVar.zzi(com.google.android.gms.ads.internal.client.zzq.zza(this.zzc, zzekVar), new zzbxo(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
