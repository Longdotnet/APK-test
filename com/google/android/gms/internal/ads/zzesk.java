package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzesk implements zzeuc {
    private static String zza;
    private final zzgdy zzb;
    private final Context zzc;

    public zzesk(zzgdy zzgdyVar, Context context) {
        this.zzb = zzgdyVar;
        this.zzc = context;
    }

    public static zzesl zzc(zzesk zzeskVar) {
        zzbcv zzbcvVar = zzbde.zzfz;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            return new zzesl(null);
        }
        if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzfI)).booleanValue()) {
            return new zzesl(com.google.android.gms.ads.internal.zzv.zza.zzz.zzf(zzeskVar.zzc));
        }
        if (zza == null) {
            zza = com.google.android.gms.ads.internal.zzv.zza.zzz.zzf(zzeskVar.zzc);
        }
        return new zzesl(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 27;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzesk.zzc(this.zza);
            }
        });
    }
}
