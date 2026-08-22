package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.auth.IJ.gZrKCJ;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfsb {
    private static zzfsb zzb;
    final zzfsc zza;

    private zzfsb(Context context) {
        this.zza = zzfsc.zzb(context);
    }

    public static final zzfsb zza(Context context) {
        zzfsb zzfsbVar;
        synchronized (zzfsb.class) {
            try {
                if (zzb == null) {
                    zzb = new zzfsb(context);
                }
                zzfsbVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfsbVar;
    }

    public final void zzb(boolean z) {
        synchronized (zzfsb.class) {
            this.zza.zzd("paidv2_user_option", Boolean.valueOf(z));
        }
    }

    public final boolean zzd() {
        boolean zZzf;
        synchronized (zzfsb.class) {
            zZzf = this.zza.zzf("paidv2_publisher_option", true);
        }
        return zZzf;
    }

    public final boolean zze() {
        boolean zZzf;
        synchronized (zzfsb.class) {
            zZzf = this.zza.zzf("paidv2_user_option", true);
        }
        return zZzf;
    }

    public final void zzc(boolean z) {
        synchronized (zzfsb.class) {
            try {
                zzfsc zzfscVar = this.zza;
                zzfscVar.zzd("paidv2_publisher_option", Boolean.valueOf(z));
                if (!z) {
                    zzfscVar.zze(gZrKCJ.zPjwyZxStdBFd);
                    zzfscVar.zze("paidv2_id");
                    zzfscVar.zze("vendor_scoped_gpid_v2_id");
                    zzfscVar.zze("vendor_scoped_gpid_v2_creation_time");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
