package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbsx implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzbhj zza;

    public zzbsx(zzbhj zzbhjVar) {
        this.zza = zzbhjVar;
        try {
            zzbhjVar.zzm();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final void setView(View view) {
        try {
            this.zza.zzp(new ObjectWrapper(view));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final boolean start() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return false;
        }
    }
}
