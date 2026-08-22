package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbir implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzbx zzb;
    final /* synthetic */ zzbis zzc;

    public zzbir(zzbis zzbisVar, AdManagerAdView adManagerAdView, com.google.android.gms.ads.internal.client.zzbx zzbxVar) {
        this.zza = adManagerAdView;
        this.zzb = zzbxVar;
        Objects.requireNonNull(zzbisVar);
        this.zzc = zzbisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AdManagerAdView adManagerAdView = this.zza;
        com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.zzb;
        com.google.android.gms.ads.internal.client.zzen zzenVar = adManagerAdView.zza;
        zzenVar.getClass();
        try {
            IObjectWrapper iObjectWrapperZzo = zzbxVar.zzo();
            if (iObjectWrapperZzo != null && ((View) ObjectWrapper.unwrap(iObjectWrapperZzo)).getParent() == null) {
                zzenVar.zzm.addView((View) ObjectWrapper.unwrap(iObjectWrapperZzo));
                zzenVar.zzj = zzbxVar;
                zzbis.zzc(this.zzc);
                throw null;
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not bind.");
    }
}
