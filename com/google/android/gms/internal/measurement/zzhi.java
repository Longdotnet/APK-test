package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzhi {
    public static Object zza(zzhj zzhjVar) {
        try {
            return zzhjVar.zza();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzhjVar.zza();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
