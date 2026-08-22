package com.google.android.gms.ads.admanager;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.client.zzgc;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public final class AdManagerAdView extends BaseAdView {
    public AdManagerAdView(Context context) {
        super(context);
        zzah.checkNotNull(context, "Context cannot be null");
    }

    public AdSize[] getAdSizes() {
        return this.zza.zzh;
    }

    public AppEventListener getAppEventListener() {
        return this.zza.zzi;
    }

    public VideoController getVideoController() {
        return this.zza.zze;
    }

    public VideoOptions getVideoOptions() {
        return this.zza.zzk;
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zza.zzu(adSizeArr);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zza.zzw(appEventListener);
    }

    public void setManualImpressionsEnabled(boolean z) {
        zzen zzenVar = this.zza;
        zzenVar.zzo = z;
        try {
            zzbx zzbxVar = zzenVar.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzO(z);
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public void setVideoOptions(VideoOptions videoOptions) {
        zzen zzenVar = this.zza;
        zzenVar.zzk = videoOptions;
        try {
            zzbx zzbxVar = zzenVar.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzW(videoOptions == null ? null : new zzgc(videoOptions));
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
