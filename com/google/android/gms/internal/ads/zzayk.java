package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzayk implements Callable {
    protected final zzawx zza;
    protected final String zzb;
    protected final String zzc;
    protected final zzast zzd;
    protected Method zze;
    protected final int zzf;
    protected final int zzg;

    public zzayk(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        this.zza = zzawxVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzastVar;
        this.zzf = i;
        this.zzg = i2;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        int i;
        try {
            long jNanoTime = System.nanoTime();
            zzawx zzawxVar = this.zza;
            Method methodZzi = zzawxVar.zzi(this.zzb, this.zzc);
            this.zze = methodZzi;
            if (methodZzi == null) {
                return null;
            }
            zza();
            zzavo zzavoVarZzd = zzawxVar.zzd();
            if (zzavoVarZzd == null || (i = this.zzf) == Integer.MIN_VALUE) {
                return null;
            }
            zzavoVarZzd.zzc(this.zzg, i, (System.nanoTime() - jNanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public abstract void zza();
}
