package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class GmsClientSupervisor {
    public static HandlerThread zza;
    public static final Object zzb = new Object();
    public static zzs zzc;

    public static zzs getInstance(Context context) {
        synchronized (zzb) {
            try {
                if (zzc == null) {
                    zzc = new zzs(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzc;
    }

    public static HandlerThread getOrStartHandlerThread() {
        synchronized (zzb) {
            try {
                HandlerThread handlerThread = zza;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                zza = handlerThread2;
                handlerThread2.start();
                return zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb(String str, String str2, ServiceConnection serviceConnection, boolean z) {
        zzo zzoVar = new zzo(str, str2, z);
        zzs zzsVar = (zzs) this;
        zzah.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (zzsVar.zzb) {
            try {
                zzp zzpVar = (zzp) zzsVar.zzb.get(zzoVar);
                if (zzpVar == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(zzoVar.toString()));
                }
                if (!zzpVar.zzb.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(zzoVar.toString()));
                }
                zzpVar.zzb.remove(serviceConnection);
                if (zzpVar.zzb.isEmpty()) {
                    zzsVar.zzd.sendMessageDelayed(zzsVar.zzd.obtainMessage(0, zzoVar), zzsVar.zzg);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract boolean zzc(zzo zzoVar, zze zzeVar, String str, Executor executor);
}
