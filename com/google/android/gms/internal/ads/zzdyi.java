package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzdyi implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzcak zza = new zzcak();
    protected final Object zzb = new Object();
    protected boolean zzc = false;
    protected boolean zzd = false;
    protected zzbvq zze;
    protected zzbuv zzf;

    public static void zzc(Context context, ListenableFuture listenableFuture, Executor executor) {
        if (((Boolean) zzbew.zzj.zze()).booleanValue() || ((Boolean) zzbew.zzh.zze()).booleanValue()) {
            zzgdn.zzr(listenableFuture, new zzdyf(context), executor);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public abstract /* synthetic */ void onConnected(Bundle bundle);

    public void onConnectionFailed(ConnectionResult connectionResult) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Disconnected from remote ad request service.");
        this.zza.zzd(new zzdyx(1));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Cannot connect to remote service, fallback to local instance.");
    }

    public final void zzb() {
        synchronized (this.zzb) {
            try {
                this.zzd = true;
                if (this.zzf.isConnected() || this.zzf.isConnecting()) {
                    this.zzf.disconnect();
                }
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
