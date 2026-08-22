package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzes implements zzdt {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzes(Handler handler) {
        this.zzb = handler;
    }

    public static /* bridge */ /* synthetic */ void zzm(zzeq zzeqVar) {
        List list = zza;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(zzeqVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static zzeq zzn() {
        zzeq zzeqVar;
        List list = zza;
        synchronized (list) {
            try {
                zzeqVar = list.isEmpty() ? new zzeq(null) : (zzeq) list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzeqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final Looper zza() {
        return this.zzb.getLooper();
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final zzds zzb(int i) {
        Handler handler = this.zzb;
        zzeq zzeqVarZzn = zzn();
        zzeqVarZzn.zzb(handler.obtainMessage(i), this);
        return zzeqVarZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final zzds zzc(int i, Object obj) {
        Handler handler = this.zzb;
        zzeq zzeqVarZzn = zzn();
        zzeqVarZzn.zzb(handler.obtainMessage(i, obj), this);
        return zzeqVarZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final zzds zzd(int i, int i2, int i3) {
        Handler handler = this.zzb;
        zzeq zzeqVarZzn = zzn();
        zzeqVarZzn.zzb(handler.obtainMessage(i, i2, i3), this);
        return zzeqVarZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final zzds zze(int i, int i2, int i3, Object obj) {
        Handler handler = this.zzb;
        zzeq zzeqVarZzn = zzn();
        zzeqVarZzn.zzb(handler.obtainMessage(31, 0, 0, obj), this);
        return zzeqVarZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zzf(Object obj) {
        this.zzb.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zzg(int i) {
        this.zzb.removeMessages(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final boolean zzh(int i) {
        return this.zzb.hasMessages(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final boolean zzi(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final boolean zzj(int i) {
        return this.zzb.sendEmptyMessage(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final boolean zzk(int i, long j) {
        return this.zzb.sendEmptyMessageAtTime(2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final boolean zzl(zzds zzdsVar) {
        return ((zzeq) zzdsVar).zzc(this.zzb);
    }
}
