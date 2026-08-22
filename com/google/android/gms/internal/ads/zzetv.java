package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzetv implements zzeuc {
    private final boolean zza;

    public zzetv(zzezv zzezvVar) {
        this.zza = zzezvVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 36;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return zzgdn.zzh(new zzett(this.zza, null));
    }
}
