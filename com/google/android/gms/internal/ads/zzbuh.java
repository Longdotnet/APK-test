package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbuh {
    private static zzbza zza;
    private final Context zzb;
    private final AdFormat zzc;
    private final com.google.android.gms.ads.internal.client.zzek zzd;
    private final String zze;

    public zzbuh(Context context, AdFormat adFormat, com.google.android.gms.ads.internal.client.zzek zzekVar, String str) {
        this.zzb = context;
        this.zzc = adFormat;
        this.zzd = zzekVar;
        this.zze = str;
    }

    public static zzbza zza(Context context) {
        zzbza zzbzaVar;
        synchronized (zzbuh.class) {
            try {
                if (zza == null) {
                    TooltipPopup tooltipPopup = com.google.android.gms.ads.internal.client.zzbb.zzb.zzd;
                    zzbpm zzbpmVar = new zzbpm();
                    tooltipPopup.getClass();
                    zza = (zzbza) new com.google.android.gms.ads.internal.client.zzag(tooltipPopup, context, zzbpmVar).zzd(context, false);
                }
                zzbzaVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbzaVar;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        com.google.android.gms.ads.internal.client.zzm zzmVarZza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context context = this.zzb;
        zzbza zzbzaVarZza = zza(context);
        if (zzbzaVarZza == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        ObjectWrapper objectWrapper = new ObjectWrapper(context);
        com.google.android.gms.ads.internal.client.zzek zzekVar = this.zzd;
        if (zzekVar == null) {
            zzmVarZza = new com.google.android.gms.ads.internal.client.zzm(8, -1L, new Bundle(), -1, new ArrayList(), false, -1, false, null, null, null, null, new Bundle(), new Bundle(), new ArrayList(), null, null, false, null, -1, null, new ArrayList(), 60000, null, 0, jCurrentTimeMillis, 0L);
        } else {
            zzekVar.zzn = jCurrentTimeMillis;
            zzmVarZza = com.google.android.gms.ads.internal.client.zzq.zza(context, zzekVar);
        }
        try {
            zzbzaVarZza.zzf(objectWrapper, new zzbze(this.zze, this.zzc.name(), null, zzmVarZza, 0, null), new zzbug(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
