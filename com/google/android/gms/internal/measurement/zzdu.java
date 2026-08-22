package com.google.android.gms.internal.measurement;

import android.os.SystemClock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: loaded from: classes.dex */
abstract class zzdu implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzef zzk;

    public zzdu(zzef zzefVar, boolean z) {
        this.zzk = zzefVar;
        ((DefaultClock) zzefVar.zza).getClass();
        this.zzh = System.currentTimeMillis();
        ((DefaultClock) zzefVar.zza).getClass();
        this.zzi = SystemClock.elapsedRealtime();
        this.zzj = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzk.zzh) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e) {
            this.zzk.zzT(e, false, this.zzj);
            zzb();
        }
    }

    public abstract void zza();

    public void zzb() {
    }
}
