package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends GmsClientSupervisor {
    public final HashMap zzb = new HashMap();
    public final Context zzc;
    public volatile zzi zzd;
    public final ConnectionTracker zzf;
    public final long zzg;
    public final long zzh;

    public zzs(Context context, Looper looper) {
        zzr zzrVar = new zzr(this);
        this.zzc = context.getApplicationContext();
        this.zzd = new zzi(looper, zzrVar);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = 5000L;
        this.zzh = 300000L;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zzc(zzo zzoVar, zze zzeVar, String str, Executor executor) {
        boolean z;
        synchronized (this.zzb) {
            try {
                zzp zzpVar = (zzp) this.zzb.get(zzoVar);
                if (executor == null) {
                    executor = null;
                }
                if (zzpVar == null) {
                    zzpVar = new zzp(this, zzoVar);
                    zzpVar.zzb.put(zzeVar, zzeVar);
                    zzpVar.zze(str, executor);
                    this.zzb.put(zzoVar, zzpVar);
                } else {
                    this.zzd.removeMessages(0, zzoVar);
                    if (zzpVar.zzb.containsKey(zzeVar)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(zzoVar.toString()));
                    }
                    zzpVar.zzb.put(zzeVar, zzeVar);
                    int i = zzpVar.zzc;
                    if (i == 1) {
                        zzeVar.onServiceConnected(zzpVar.zzg, zzpVar.zze);
                    } else if (i == 2) {
                        zzpVar.zze(str, executor);
                    }
                }
                z = zzpVar.zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
