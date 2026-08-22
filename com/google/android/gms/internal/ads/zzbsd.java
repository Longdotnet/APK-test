package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: loaded from: classes.dex */
final class zzbsd {
    final zzbpw zza;

    public zzbsd(zzbpw zzbpwVar) {
        this.zza = zzbpwVar;
    }

    public final void onAdClosed() {
        try {
            this.zza.zzf();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(AdError adError) {
        try {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Mediated ad failed to show: Error Code = " + adError.zza + ". Error Message = " + adError.zzb + " Error Domain = " + adError.zzc);
            this.zza.zzk(adError.zza());
        } catch (RemoteException unused) {
        }
    }

    public final void onAdLeftApplication() {
        try {
            this.zza.zzn();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdOpened() {
        try {
            this.zza.zzp();
        } catch (RemoteException unused) {
        }
    }

    public final void onUserEarnedReward() {
        try {
            this.zza.zzu();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoComplete() {
        try {
            this.zza.zzw();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
        try {
            this.zza.zzx();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoPlay() {
        try {
            this.zza.zzy();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoStart() {
        try {
            this.zza.zzz();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdClicked() {
        try {
            this.zza.zze();
        } catch (RemoteException unused) {
        }
    }

    public final void reportAdImpression() {
        try {
            this.zza.zzm();
        } catch (RemoteException unused) {
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.zza.zzt(new zzbxm(rewardItem));
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(String str) {
        try {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Mediated ad failed to show: " + str);
            this.zza.zzl(str);
        } catch (RemoteException unused) {
        }
    }
}
