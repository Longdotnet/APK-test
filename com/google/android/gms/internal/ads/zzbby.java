package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class zzbby {
    private zzbbn zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    public zzbby(Context context) {
        this.zzc = context;
    }

    public static /* bridge */ /* synthetic */ void zze(zzbby zzbbyVar) {
        synchronized (zzbbyVar.zzd) {
            try {
                zzbbn zzbbnVar = zzbbyVar.zza;
                if (zzbbnVar == null) {
                    return;
                }
                zzbbnVar.disconnect();
                zzbbyVar.zza = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Future zzc(zzbbo zzbboVar) {
        zzbbs zzbbsVar = new zzbbs(this);
        zzbbw zzbbwVar = new zzbbw(this, zzbboVar, zzbbsVar);
        zzbbx zzbbxVar = new zzbbx(this, zzbbsVar);
        synchronized (this.zzd) {
            zzbbn zzbbnVar = new zzbbn(this.zzc, com.google.android.gms.ads.internal.zzv.zza.zzu.zzb(), zzbbwVar, zzbbxVar);
            this.zza = zzbbnVar;
            zzbbnVar.checkAvailabilityAndConnect();
        }
        return zzbbsVar;
    }
}
