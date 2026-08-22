package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzezg implements zzezr {
    private zzcve zza;

    @Override // com.google.android.gms.internal.ads.zzezr
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcve zzd() {
        return this.zza;
    }

    public final synchronized ListenableFuture zzb(zzezs zzezsVar, zzezq zzezqVar, zzcve zzcveVar) {
        zzcse zzcseVarZzb;
        try {
            if (zzcveVar != null) {
                this.zza = zzcveVar;
            } else {
                this.zza = (zzcve) zzezqVar.zza(zzezsVar.zzb).zzh();
            }
            zzcseVarZzb = this.zza.zzb();
        } catch (Throwable th) {
            throw th;
        }
        return zzcseVarZzb.zzh(zzcseVarZzb.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzezs zzezsVar, zzezq zzezqVar, Object obj) {
        return zzb(zzezsVar, zzezqVar, null);
    }
}
