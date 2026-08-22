package com.google.android.gms.ads;

import android.content.Context;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.internal.client.zzas;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzck;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.ads.zzbpm;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzb {
    public static volatile zzck zza;

    /* JADX INFO: renamed from: zza */
    public static final Feature f0zza;
    public static final Feature[] zzb;

    static {
        Feature feature = new Feature("additional_video_csi", 1L);
        f0zza = feature;
        zzb = new Feature[]{feature};
    }

    public static zzck zza(Context context) {
        if (zza == null) {
            synchronized (zzb.class) {
                try {
                    if (zza == null) {
                        TooltipPopup tooltipPopup = zzbb.zzb.zzd;
                        zzbpm zzbpmVar = new zzbpm();
                        tooltipPopup.getClass();
                        zza = (zzck) new zzas(tooltipPopup, context, zzbpmVar).zzd(context, false);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zza;
    }
}
