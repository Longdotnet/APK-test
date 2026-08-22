package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class zzawa {
    private NetworkCapabilities zza;

    public zzawa(ConnectivityManager connectivityManager) {
        if (connectivityManager == null || Build.VERSION.SDK_INT < 24) {
            return;
        }
        try {
            connectivityManager.registerDefaultNetworkCallback(new zzavz(this));
        } catch (RuntimeException unused) {
            synchronized (zzawa.class) {
                this.zza = null;
            }
        }
    }

    public static zzawa zzc(Context context) {
        if (context != null) {
            return new zzawa((ConnectivityManager) context.getSystemService("connectivity"));
        }
        return null;
    }

    public final long zza() {
        synchronized (zzawa.class) {
            try {
                NetworkCapabilities networkCapabilities = this.zza;
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(4)) {
                        return 2L;
                    }
                    if (this.zza.hasTransport(1)) {
                        return 1L;
                    }
                    if (this.zza.hasTransport(0)) {
                        return 0L;
                    }
                }
                return -1L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final NetworkCapabilities zzb() {
        return this.zza;
    }
}
