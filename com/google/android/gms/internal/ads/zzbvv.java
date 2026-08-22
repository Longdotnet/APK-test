package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzbvv implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbvx zzb;

    public zzbvv(zzbvx zzbvxVar, Context context) {
        this.zza = context;
        Objects.requireNonNull(zzbvxVar);
        this.zzb = zzbvxVar;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x003b  */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzbvu zzbvuVarZza;
        zzbvx zzbvxVar = this.zzb;
        WeakHashMap weakHashMap = zzbvxVar.zza;
        Context context = this.zza;
        zzbvw zzbvwVar = (zzbvw) weakHashMap.get(context);
        if (zzbvwVar != null) {
            long jLongValue = zzbvwVar.zza + ((Long) zzbet.zzd.zze()).longValue();
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            if (jLongValue < System.currentTimeMillis()) {
                zzbvuVarZza = new zzbvt(context).zza();
            } else {
                zzbvuVarZza = new zzbvt(context, zzbvwVar.zzb).zza();
            }
        } else {
            zzbvuVarZza = new zzbvt(context).zza();
        }
        zzbvxVar.zza.put(context, new zzbvw(zzbvxVar, zzbvuVarZza));
        return zzbvuVarZza;
    }
}
