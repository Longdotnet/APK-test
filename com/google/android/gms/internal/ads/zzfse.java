package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzfse extends zzfsd {
    private static zzfse zzd;

    private zzfse(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfse zzj(Context context) {
        zzfse zzfseVar;
        synchronized (zzfse.class) {
            try {
                if (zzd == null) {
                    zzd = new zzfse(context);
                }
                zzfseVar = zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfseVar;
    }

    public final zzfsa zzh(long j, boolean z) {
        zzfsa zzfsaVarZzb;
        synchronized (zzfse.class) {
            zzfsaVarZzb = zzb(null, null, j, z);
        }
        return zzfsaVarZzb;
    }

    public final zzfsa zzi(String str, String str2, long j, boolean z) {
        zzfsa zzfsaVarZzb;
        synchronized (zzfse.class) {
            zzfsaVarZzb = zzb(str, str2, j, z);
        }
        return zzfsaVarZzb;
    }

    public final void zzk() {
        synchronized (zzfse.class) {
            zzf(false);
        }
    }

    public final void zzl() {
        synchronized (zzfse.class) {
            zzf(true);
        }
    }
}
