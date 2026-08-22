package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;

/* JADX INFO: loaded from: classes.dex */
public final class zzbll {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    private zzblh zzc;

    public zzbll(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        com.google.android.gms.common.internal.zzah.checkNotNull(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
        zzbde.zza(context);
    }

    public static final boolean zzc(String str) {
        zzbcv zzbcvVar = zzbde.zzkr;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            return false;
        }
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        if (str.length() > ((Integer) zzbdVar.zzd.zzb(zzbde.zzkt)).intValue()) {
            com.google.android.gms.ads.internal.util.client.zzo.zze("H5 GMSG exceeds max length");
            return false;
        }
        Uri uri = Uri.parse(str);
        return "gmsg".equals(uri.getScheme()) && "mobileads.google.com".equals(uri.getHost()) && "/h5ads".equals(uri.getPath());
    }

    private final void zzd() {
        if (this.zzc != null) {
            return;
        }
        Context context = this.zza;
        TooltipPopup tooltipPopup = com.google.android.gms.ads.internal.client.zzbb.zzb.zzd;
        zzbpm zzbpmVar = new zzbpm();
        OnH5AdsEventListener onH5AdsEventListener = this.zzb;
        tooltipPopup.getClass();
        this.zzc = (zzblh) new com.google.android.gms.ads.internal.client.zzak(tooltipPopup, context, zzbpmVar, onH5AdsEventListener).zzd(context, false);
    }

    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkr)).booleanValue()) {
            zzd();
            zzblh zzblhVar = this.zzc;
            if (zzblhVar != null) {
                try {
                    zzblhVar.zze();
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean zzb(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzblh zzblhVar = this.zzc;
        if (zzblhVar == null) {
            return false;
        }
        try {
            zzblhVar.zzf(str);
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return true;
        }
    }
}
