package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxe extends RewardedAd {
    private final AtomicReference zza;
    private final zzbwv zzb;
    private final Context zzc;
    private final zzbxn zzd;
    private OnAdMetadataChangedListener zze;
    private OnPaidEventListener zzf;
    private FullScreenContentCallback zzg;
    private final long zzh;
    private final AtomicLong zzi;

    public zzbxe(Context context, zzbwv zzbwvVar) {
        this.zzh = System.currentTimeMillis();
        this.zzi = new AtomicLong();
        this.zzc = context.getApplicationContext();
        this.zza = new AtomicReference();
        this.zzb = zzbwvVar;
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

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final String getAdUnitId() {
        String strZzf;
        String str;
        AtomicReference atomicReference = this.zza;
        if (atomicReference.get() != null) {
            return (String) atomicReference.get();
        }
        synchronized (this) {
            try {
                strZzf = this.zzb.zzf();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                strZzf = null;
            }
            if (strZzf == null) {
                this.zza.set("");
            } else {
                this.zza.set(strZzf);
            }
            str = (String) this.zza.get();
        }
        return str;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zze;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzf;
    }

    public final long getPlacementId() {
        long j;
        AtomicLong atomicLong = this.zzi;
        long jZzb = 0;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        synchronized (this) {
            try {
                zzbwv zzbwvVar = this.zzb;
                if (zzbwvVar != null) {
                    jZzb = zzbwvVar.zzb();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
            AtomicLong atomicLong2 = this.zzi;
            atomicLong2.set(jZzb);
            j = atomicLong2.get();
        }
        return j;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final ResponseInfo getResponseInfo() {
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzd = null;
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzeaVarZzd = zzbwvVar.zzd();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
        return new ResponseInfo(zzeaVarZzd);
    }

    public final RewardItem getRewardItem() {
        GraphRequest.Companion companion = RewardItem.DEFAULT_REWARD;
        try {
            zzbwv zzbwvVar = this.zzb;
            zzbws zzbwsVarZze = zzbwvVar != null ? zzbwvVar.zze() : null;
            return zzbwsVarZze == null ? companion : new zzbxf(zzbwsVarZze);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return companion;
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzg = fullScreenContentCallback;
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
        try {
            this.zze = onAdMetadataChangedListener;
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzbwvVar.zzk(new com.google.android.gms.ads.internal.client.zzft(onAdMetadataChangedListener));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzf = onPaidEventListener;
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

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        if (serverSideVerificationOptions != null) {
            try {
                zzbwv zzbwvVar = this.zzb;
                if (zzbwvVar != null) {
                    zzbwvVar.zzo(new zzbxj(serverSideVerificationOptions));
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        zzbxn zzbxnVar = this.zzd;
        zzbxnVar.zzc(onUserEarnedRewardListener);
        if (activity == null) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
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

    public final void zza(com.google.android.gms.ads.internal.client.zzek zzekVar, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            zzbwv zzbwvVar = this.zzb;
            if (zzbwvVar != null) {
                zzekVar.zzn = this.zzh;
                zzbwvVar.zzh(com.google.android.gms.ads.internal.client.zzq.zza(this.zzc, zzekVar), new zzbxi(rewardedAdLoadCallback, this));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public zzbxe(Context context, String str, zzbwv zzbwvVar) {
        this.zzh = System.currentTimeMillis();
        this.zzi = new AtomicLong();
        this.zzc = context.getApplicationContext();
        this.zza = new AtomicReference(str);
        this.zzb = zzbwvVar;
        this.zzd = new zzbxn();
    }

    public zzbxe(Context context, String str) {
        TooltipPopup tooltipPopup = com.google.android.gms.ads.internal.client.zzbb.zzb.zzd;
        zzbpm zzbpmVar = new zzbpm();
        tooltipPopup.getClass();
        this(context, str, (zzbwv) new com.google.android.gms.ads.internal.client.zzaa(tooltipPopup, context, str, zzbpmVar).zzd(context, false));
    }
}
