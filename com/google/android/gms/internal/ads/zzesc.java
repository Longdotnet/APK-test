package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzesc implements zzeuc {
    private final zzfbz zza;

    public zzesc(zzfbz zzfbzVar) {
        this.zza = zzfbzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 25;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return zzgdn.zzh(new zzesd(this.zza));
    }
}
