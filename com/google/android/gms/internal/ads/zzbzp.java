package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbzp extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzbzs zza;

    public zzbzp(zzbzs zzbzsVar) {
        Objects.requireNonNull(zzbzsVar);
        this.zza = zzbzsVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.zza.zzo.set(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.zza.zzo.set(false);
    }
}
