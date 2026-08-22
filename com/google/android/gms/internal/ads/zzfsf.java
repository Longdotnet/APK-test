package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzfsf extends zzfsd {
    private static zzfsf zzd;

    private zzfsf(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfsf zzi(Context context) {
        zzfsf zzfsfVar;
        synchronized (zzfsf.class) {
            try {
                if (zzd == null) {
                    zzd = new zzfsf(context);
                }
                zzfsfVar = zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfsfVar;
    }

    public final zzfsa zzh(long j, boolean z) {
        synchronized (zzfsf.class) {
            try {
                if (this.zzc.zzd()) {
                    return zzb(null, null, j, z);
                }
                return new zzfsa();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzj() {
        synchronized (zzfsf.class) {
            try {
                if (zzg(false)) {
                    zzf(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
