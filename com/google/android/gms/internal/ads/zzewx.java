package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzewx implements zzeuc {
    private final zzgdy zza;

    public zzewx(zzgdy zzgdyVar) {
        this.zza = zzgdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 51;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeww
            @Override // java.util.concurrent.Callable
            public final Object call() {
                HashMap map = new HashMap();
                zzbcv zzbcvVar = zzbde.zzab;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                String str = (String) zzbdVar.zzd.zzb(zzbcvVar);
                if (str != null && !str.isEmpty()) {
                    if (Build.VERSION.SDK_INT >= ((Integer) zzbdVar.zzd.zzb(zzbde.zzac)).intValue()) {
                        for (String str2 : str.split(",", -1)) {
                            map.put(str2, com.google.android.gms.ads.internal.util.zzcj.zza(str2));
                        }
                    }
                }
                return new zzewy(map);
            }
        });
    }
}
