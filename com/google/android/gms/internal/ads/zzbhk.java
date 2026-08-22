package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhk {
    private final zzbhj zza;

    public zzbhk(zzbhj zzbhjVar) {
        Context context;
        this.zza = zzbhjVar;
        try {
            context = (Context) ObjectWrapper.unwrap(zzbhjVar.zzh());
        } catch (RemoteException | NullPointerException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            context = null;
        }
        if (context != null) {
            try {
                this.zza.zzs(new ObjectWrapper(new MediaView(context)));
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
            }
        }
    }

    public final zzbhj zza() {
        return this.zza;
    }

    public final String zzb() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }
}
