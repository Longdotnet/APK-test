package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmz extends AdManagerInterstitialAd {
    private final Context zza;
    private final com.google.android.gms.ads.internal.client.zzq zzb;
    private final com.google.android.gms.ads.internal.client.zzbx zzc;
    private final AtomicReference zzd;
    private final zzbpm zze;
    private final long zzf;
    private AppEventListener zzg;
    private FullScreenContentCallback zzh;
    private OnPaidEventListener zzi;
    private final AtomicLong zzj;

    public zzbmz(Context context, com.google.android.gms.ads.internal.client.zzbx zzbxVar) {
        this.zze = new zzbpm();
        this.zzf = System.currentTimeMillis();
        this.zzj = new AtomicLong();
        this.zza = context;
        this.zzd = new AtomicReference();
        this.zzb = com.google.android.gms.ads.internal.client.zzq.zza;
        this.zzc = zzbxVar;
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final String getAdUnitId() {
        String strZzs;
        String str;
        AtomicReference atomicReference = this.zzd;
        if (atomicReference.get() != null) {
            return (String) atomicReference.get();
        }
        synchronized (this) {
            try {
                strZzs = this.zzc.zzs();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                strZzs = null;
            }
            if (strZzs == null) {
                this.zzd.set("");
            } else {
                this.zzd.set(strZzs);
            }
            str = (String) this.zzd.get();
        }
        return str;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzg;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzh;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzi;
    }

    public final long getPlacementId() {
        AtomicLong atomicLong = this.zzj;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        synchronized (this) {
            try {
                try {
                    com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.zzc;
                    if (zzbxVar != null) {
                        long jZzc = zzbxVar.zzc();
                        AtomicLong atomicLong2 = this.zzj;
                        atomicLong2.set(jZzc);
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

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final ResponseInfo getResponseInfo() {
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzl = null;
        try {
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.zzc;
            if (zzbxVar != null) {
                zzeaVarZzl = zzbxVar.zzl();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
        return new ResponseInfo(zzeaVarZzl);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzg = appEventListener;
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.zzc;
            if (zzbxVar != null) {
                zzbxVar.zzH(appEventListener != null ? new zzazr(appEventListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzh = fullScreenContentCallback;
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.zzc;
            if (zzbxVar != null) {
                zzbxVar.zzK(new com.google.android.gms.ads.internal.client.zzbe(fullScreenContentCallback));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzi = onPaidEventListener;
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.zzc;
            if (zzbxVar != null) {
                zzbxVar.zzQ(new com.google.android.gms.ads.internal.client.zzfu(onPaidEventListener));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void show(Activity activity) {
        if (activity == null) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.zzc;
            if (zzbxVar != null) {
                zzbxVar.zzY(new ObjectWrapper(activity));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.client.zzek zzekVar, AdLoadCallback adLoadCallback) {
        try {
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.zzc;
            if (zzbxVar != null) {
                zzekVar.zzn = this.zzf;
                com.google.android.gms.ads.internal.client.zzq zzqVar = this.zzb;
                Context context = this.zza;
                zzqVar.getClass();
                zzbxVar.zzz(com.google.android.gms.ads.internal.client.zzq.zza(context, zzekVar), new com.google.android.gms.ads.internal.client.zzh(adLoadCallback, this));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", "com.google.android.gms.ads", null, null));
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void setImmersiveMode(boolean z) {
        try {
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.zzc;
            if (zzbxVar != null) {
                zzbxVar.zzM(z);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl(nYVxXTZQ.WuDDuOvtZfX, e);
        }
    }

    public final void setPlacementId(long j) {
        try {
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.zzc;
            if (zzbxVar != null) {
                zzbxVar.zzR(j);
                this.zzj.set(j);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl(eoBKjVuj.IvqJT, e);
        }
    }

    public zzbmz(Context context, String str) {
        zzbpm zzbpmVar = new zzbpm();
        this.zze = zzbpmVar;
        this.zzf = System.currentTimeMillis();
        this.zzj = new AtomicLong();
        this.zza = context;
        this.zzd = new AtomicReference(str);
        this.zzb = com.google.android.gms.ads.internal.client.zzq.zza;
        TooltipPopup tooltipPopup = com.google.android.gms.ads.internal.client.zzbb.zzb.zzd;
        com.google.android.gms.ads.internal.client.zzr zzrVar = new com.google.android.gms.ads.internal.client.zzr();
        tooltipPopup.getClass();
        this.zzc = (com.google.android.gms.ads.internal.client.zzbx) new com.google.android.gms.ads.internal.client.zzao(tooltipPopup, context, zzrVar, str, zzbpmVar).zzd(context, false);
    }

    public zzbmz(Context context, String str, com.google.android.gms.ads.internal.client.zzbx zzbxVar) {
        com.google.android.gms.ads.internal.client.zzq zzqVar = com.google.android.gms.ads.internal.client.zzq.zza;
        this.zze = new zzbpm();
        this.zzf = System.currentTimeMillis();
        this.zzj = new AtomicLong();
        this.zza = context;
        this.zzd = new AtomicReference(str);
        this.zzb = zzqVar;
        this.zzc = zzbxVar;
    }
}
