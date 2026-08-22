package com.google.android.gms.internal.games_v2;

import android.app.Application;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzay {
    private static final AtomicReference zza = new AtomicReference();

    public static zzaw zza(Application application) {
        AtomicReference atomicReference = zza;
        zzaw zzawVar = (zzaw) atomicReference.get();
        if (zzawVar != null) {
            return zzawVar;
        }
        zzh zzhVarZza = zzi.zza();
        zzhVarZza.zza(9);
        zzhVarZza.zzb(application.getPackageName());
        zzi zziVarZzc = zzhVarZza.zzc();
        com.google.android.gms.games.internal.zzf zzfVarZza = com.google.android.gms.games.internal.zzf.zza(application);
        zzbq zzbqVar = new zzbq(application, zzfVarZza, com.google.android.gms.games.internal.v2.resolution.zzb.zza(), new zzbu(application, zzfVarZza, new zzax(application, zziVarZzc)));
        while (!atomicReference.compareAndSet(null, zzbqVar) && atomicReference.get() == null) {
        }
        zzaw zzawVar2 = (zzaw) atomicReference.get();
        com.google.android.gms.common.internal.zzah.checkNotNull(zzawVar2);
        return zzawVar2;
    }
}
