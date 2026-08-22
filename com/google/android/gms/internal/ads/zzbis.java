package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbis extends zzbhz {
    private final OnAdManagerAdViewLoadedListener zza;

    public zzbis(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
    }

    public static /* bridge */ /* synthetic */ OnAdManagerAdViewLoadedListener zzc(zzbis zzbisVar) {
        zzbisVar.getClass();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbia
    public final void zze(com.google.android.gms.ads.internal.client.zzbx zzbxVar, IObjectWrapper iObjectWrapper) {
        if (zzbxVar == null || iObjectWrapper == null) {
            return;
        }
        AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
        try {
            if (zzbxVar.zzj() instanceof com.google.android.gms.ads.internal.client.zzg) {
                com.google.android.gms.ads.internal.client.zzg zzgVar = (com.google.android.gms.ads.internal.client.zzg) zzbxVar.zzj();
                adManagerAdView.setAdListener(zzgVar != null ? zzgVar.zza : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        try {
            if (zzbxVar.zzk() instanceof zzazr) {
                zzazr zzazrVar = (zzazr) zzbxVar.zzk();
                adManagerAdView.setAppEventListener(zzazrVar != null ? zzazrVar.zzb() : null);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
        }
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzbir(this, adManagerAdView, zzbxVar));
    }
}
