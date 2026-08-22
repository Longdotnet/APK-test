package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyu implements zzdyw {
    private final Map zza;
    private final zzgdy zzb;
    private final zzcyy zzc;

    public zzdyu(Map map, zzgdy zzgdyVar, zzcyy zzcyyVar) {
        this.zza = map;
        this.zzb = zzgdyVar;
        this.zzc = zzcyyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyw
    public final ListenableFuture zzc(final zzbvq zzbvqVar) {
        this.zzc.zzdn(zzbvqVar);
        ListenableFuture listenableFutureZzg = zzgdn.zzg(new zzdwm(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziD)).split(",")) {
            final zzhhg zzhhgVar = (zzhhg) this.zza.get(str.trim());
            if (zzhhgVar != null) {
                listenableFutureZzg = zzgdn.zzf(listenableFutureZzg, zzdwm.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdys
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        return ((zzdyw) zzhhgVar.zzb()).zzc(zzbvqVar);
                    }
                }, this.zzb);
            }
        }
        zzgdn.zzr(listenableFutureZzg, new zzdyt(this), zzcaf.zzg);
        return listenableFutureZzg;
    }
}
