package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbk {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbbg(this);
    private final Object zzc = new Object();
    private zzbbn zzd;
    private Context zze;
    private zzbbq zzf;

    public static /* bridge */ /* synthetic */ void zzh(zzbbk zzbbkVar) {
        synchronized (zzbbkVar.zzc) {
            try {
                zzbbn zzbbnVar = zzbbkVar.zzd;
                if (zzbbnVar == null) {
                    return;
                }
                if (zzbbnVar.isConnected() || zzbbkVar.zzd.isConnecting()) {
                    zzbbkVar.zzd.disconnect();
                }
                zzbbkVar.zzd = null;
                zzbbkVar.zzf = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl() {
        synchronized (this.zzc) {
            try {
                if (this.zze != null && this.zzd == null) {
                    zzbbn zzbbnVarZzd = zzd(new zzbbi(this), new zzbbj(this));
                    this.zzd = zzbbnVarZzd;
                    zzbbnVarZzd.checkAvailabilityAndConnect();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final long zza(zzbbo zzbboVar) {
        synchronized (this.zzc) {
            try {
                if (this.zzf == null) {
                    return -2L;
                }
                if (this.zzd.zzp()) {
                    try {
                        return this.zzf.zze(zzbboVar);
                    } catch (RemoteException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to call into cache service.", e);
                    }
                }
                return -2L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzbbl zzb(zzbbo zzbboVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return new zzbbl();
            }
            try {
                if (this.zzd.zzp()) {
                    return this.zzf.zzg(zzbboVar);
                }
                return this.zzf.zzf(zzbboVar);
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to call into cache service.", e);
                return new zzbbl();
            }
        }
    }

    public final synchronized zzbbn zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbbn(this.zze, com.google.android.gms.ads.internal.zzv.zza.zzu.zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    public final void zzi(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.zzc) {
            try {
                if (this.zze != null) {
                    return;
                }
                this.zze = context.getApplicationContext();
                zzbcv zzbcvVar = zzbde.zzez;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                    zzl();
                } else {
                    if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzey)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzv.zza.zzh.zzc(new zzbbh(this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzj() {
        zzbcv zzbcvVar = zzbde.zzeA;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            synchronized (this.zzc) {
                try {
                    zzl();
                    ScheduledFuture scheduledFuture = this.zza;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.zza = zzcaf.zzd.schedule(this.zzb, ((Long) zzbdVar.zzd.zzb(zzbde.zzeB)).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
