package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzezh implements zzezr {
    private final zzezr zza;
    private zzcve zzb;

    public zzezh(zzezr zzezrVar) {
        this.zza = zzezrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcve zzd() {
        return this.zzb;
    }

    public final synchronized ListenableFuture zzb(zzezs zzezsVar, zzezq zzezqVar, zzcve zzcveVar) {
        zzbvq zzbvqVar;
        this.zzb = zzcveVar;
        if (zzcveVar == null || (zzbvqVar = zzezsVar.zza) == null) {
            return ((zzezg) this.zza).zzb(zzezsVar, zzezqVar, zzcveVar);
        }
        zzcse zzcseVarZzb = zzcveVar.zzb();
        return zzcseVarZzb.zzh(zzcseVarZzb.zzj(zzgdn.zzh(zzbvqVar)));
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzezs zzezsVar, zzezq zzezqVar, Object obj) {
        return zzb(zzezsVar, zzezqVar, null);
    }
}
