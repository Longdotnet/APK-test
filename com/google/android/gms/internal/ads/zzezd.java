package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzezd implements zzezr {
    private final zzfej zza;
    private final Executor zzb;
    private final zzgdj zzc = new zzezb(this);

    public zzezd(zzfej zzfejVar, Executor executor) {
        this.zza = zzfejVar;
        this.zzb = executor;
    }

    public static /* synthetic */ ListenableFuture zza(zzezd zzezdVar, zzcve zzcveVar, zzezl zzezlVar) {
        zzfej zzfejVar = zzezdVar.zza;
        zzfet zzfetVar = zzezlVar.zzb;
        zzbvq zzbvqVar = zzezlVar.zza;
        zzfes zzfesVarZzb = zzfejVar.zzb(zzfetVar);
        if (zzfesVarZzb != null && zzbvqVar != null) {
            zzgdn.zzr(zzcveVar.zzb().zzg(zzbvqVar), zzezdVar.zzc, zzezdVar.zzb);
        }
        return zzgdn.zzh(new zzezc(zzfetVar, zzbvqVar, zzfesVarZzb));
    }

    public final ListenableFuture zzb(zzezs zzezsVar, zzezq zzezqVar, final zzcve zzcveVar) {
        zzfej zzfejVar = this.zza;
        Executor executor = this.zzb;
        return (zzgde) zzgdn.zze((zzgde) zzgdn.zzn(zzgde.zzw(new zzezn(zzfejVar, zzcveVar, executor).zzc()), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeyz
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzezd.zza(this.zza, zzcveVar, (zzezl) obj);
            }
        }, executor), Exception.class, new zzeza(this), executor);
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzezs zzezsVar, zzezq zzezqVar, Object obj) {
        return zzb(zzezsVar, zzezqVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
