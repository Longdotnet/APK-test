package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzfsg {
    private static zzfsg zzb;
    final zzfsc zza;

    private zzfsg(Context context) {
        this.zza = zzfsc.zzb(context);
        zzfsb.zza(context);
    }

    public static final zzfsg zza(Context context) {
        zzfsg zzfsgVar;
        synchronized (zzfsg.class) {
            try {
                if (zzb == null) {
                    zzb = new zzfsg(context);
                }
                zzfsgVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfsgVar;
    }

    public final void zzb(zzfsa zzfsaVar) {
        synchronized (zzfsg.class) {
            zzfsc zzfscVar = this.zza;
            zzfscVar.zze("vendor_scoped_gpid_v2_id");
            zzfscVar.zze("vendor_scoped_gpid_v2_creation_time");
        }
    }
}
