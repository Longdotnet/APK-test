package com.google.android.gms.internal.auth;

import android.os.Binder;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzci {
    public static <V> V zza(zzcj<V> zzcjVar) {
        try {
            return zzcjVar.zza();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzcjVar.zza();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
