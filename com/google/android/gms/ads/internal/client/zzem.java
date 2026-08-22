package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.util.client.zzo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzem extends AdListener {
    public final /* synthetic */ zzen zza;
    public final Object zza$1;
    public AdListener zzb;

    public zzem(zzen zzenVar) {
        Objects.requireNonNull(zzenVar);
        this.zza = zzenVar;
        this.zza$1 = new Object();
    }

    @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        synchronized (this.zza$1) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdClicked();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClosed() {
        synchronized (this.zza$1) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdClosed();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        zzen zzenVar = this.zza;
        VideoController videoController = zzenVar.zze;
        zzbx zzbxVar = zzenVar.zzj;
        zzed zzedVarZzm = null;
        if (zzbxVar != null) {
            try {
                zzedVarZzm = zzbxVar.zzm();
            } catch (RemoteException e) {
                zzo.zzl("#007 Could not call remote method.", e);
            }
        }
        videoController.zzb(zzedVarZzm);
        synchronized (this.zza$1) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdFailedToLoad(loadAdError);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdImpression() {
        synchronized (this.zza$1) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdImpression();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        zzen zzenVar = this.zza;
        VideoController videoController = zzenVar.zze;
        zzbx zzbxVar = zzenVar.zzj;
        zzed zzedVarZzm = null;
        if (zzbxVar != null) {
            try {
                zzedVarZzm = zzbxVar.zzm();
            } catch (RemoteException e) {
                zzo.zzl("#007 Could not call remote method.", e);
            }
        }
        videoController.zzb(zzedVarZzm);
        synchronized (this.zza$1) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdLoaded();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        synchronized (this.zza$1) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdOpened();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
