package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyo extends zzdyi {
    private String zzg;
    private int zzh = 1;

    public zzdyo(Context context) {
        this.zzf = new zzbuv(context, com.google.android.gms.ads.internal.zzv.zza.zzu.zzb(), this, this);
    }

    @Override // com.google.android.gms.internal.ads.zzdyi, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            try {
                if (!this.zzd) {
                    this.zzd = true;
                    try {
                        int i = this.zzh;
                        if (i == 2) {
                            this.zzf.zzp().zze(this.zze, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznp)).booleanValue() ? new zzdyh(this.zza, this.zze) : new zzdyg(this));
                        } else if (i == 3) {
                            this.zzf.zzp().zzh(this.zzg, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznp)).booleanValue() ? new zzdyh(this.zza, this.zze) : new zzdyg(this));
                        } else {
                            this.zza.zzd(new zzdyx(1));
                        }
                    } catch (RemoteException | IllegalArgumentException unused) {
                        this.zza.zzd(new zzdyx(1));
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                        this.zza.zzd(new zzdyx(1));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyi, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzdyx(1));
    }

    public final ListenableFuture zza(zzbvq zzbvqVar) {
        synchronized (this.zzb) {
            try {
                int i = this.zzh;
                if (i != 1 && i != 2) {
                    return zzgdn.zzg(new zzdyx(2));
                }
                if (this.zzc) {
                    return this.zza;
                }
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzbvqVar;
                this.zzf.checkAvailabilityAndConnect();
                zzcak zzcakVar = this.zza;
                zzcakVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdym
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzb();
                    }
                }, zzcaf.zzg);
                return zzcakVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ListenableFuture zzd(String str) {
        synchronized (this.zzb) {
            try {
                int i = this.zzh;
                if (i != 1 && i != 3) {
                    return zzgdn.zzg(new zzdyx(2));
                }
                if (this.zzc) {
                    return this.zza;
                }
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                zzcak zzcakVar = this.zza;
                zzcakVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyn
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzb();
                    }
                }, zzcaf.zzg);
                return zzcakVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
