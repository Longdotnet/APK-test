package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzedn implements zzedm {
    public final zzedm zza;
    private final zzfve zzb;

    public zzedn(zzedm zzedmVar, zzfve zzfveVar) {
        this.zza = zzedmVar;
        this.zzb = zzfveVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(zzfcn zzfcnVar, zzfca zzfcaVar) {
        return zzgdn.zzm(this.zza.zza(zzfcnVar, zzfcaVar), this.zzb, zzcaf.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        return this.zza.zzb(zzfcnVar, zzfcaVar);
    }
}
