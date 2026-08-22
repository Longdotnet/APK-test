package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzerg implements zzeuc {
    private final Context zza;
    private final zzgdy zzb;

    public zzerg(zzgdy zzgdyVar, Context context) {
        this.zzb = zzgdyVar;
        this.zza = context;
    }

    public static zzerh zzc(zzerg zzergVar) {
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        Object systemService = zzergVar.zza.getSystemService("display");
        return new zzerh(systemService instanceof DisplayManager ? Integer.valueOf(((DisplayManager) systemService).getDisplays().length) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 57;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzerf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzerg.zzc(this.zza);
            }
        });
    }
}
