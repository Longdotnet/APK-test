package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyk extends zzdyi {
    private final Context zzg;
    private final Executor zzh;

    public zzdyk(Context context, Executor executor) {
        this.zzg = context;
        this.zzh = executor;
        this.zzf = new zzbuv(context, com.google.android.gms.ads.internal.zzv.zza.zzu.zzb(), this, this);
    }

    @Override // com.google.android.gms.internal.ads.zzdyi, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            try {
                if (!this.zzd) {
                    this.zzd = true;
                    try {
                        this.zzf.zzp().zzf(this.zze, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznp)).booleanValue() ? new zzdyh(this.zza, this.zze) : new zzdyg(this));
                    } catch (RemoteException | IllegalArgumentException unused) {
                        this.zza.zzd(new zzdyx(1));
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "RemoteSignalsClientTask.onConnected");
                        this.zza.zzd(new zzdyx(1));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final ListenableFuture zza(zzbvq zzbvqVar) {
        synchronized (this.zzb) {
            try {
                if (this.zzc) {
                    return this.zza;
                }
                this.zzc = true;
                this.zze = zzbvqVar;
                this.zzf.checkAvailabilityAndConnect();
                zzcak zzcakVar = this.zza;
                zzcakVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyj
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzb();
                    }
                }, zzcaf.zzg);
                zzdyi.zzc(this.zzg, zzcakVar, this.zzh);
                return zzcakVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
