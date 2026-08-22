package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzeoh implements zzeuc {
    private final zzfcw zza;

    public zzeoh(zzfcw zzfcwVar) {
        this.zza = zzfcwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 58;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return zzgdn.zzh(new zzeoi(this.zza.zzp));
    }
}
