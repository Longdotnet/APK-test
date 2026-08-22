package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbqk implements InitializationCompleteCallback {
    final /* synthetic */ zzbmh zza;

    public zzbqk(zzbqr zzbqrVar, zzbmh zzbmhVar) {
        this.zza = zzbmhVar;
        Objects.requireNonNull(zzbqrVar);
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }
}
