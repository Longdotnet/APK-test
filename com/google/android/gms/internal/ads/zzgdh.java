package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class zzgdh extends zzgdi {
    private final ListenableFuture zza;

    public zzgdh(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgdg, com.google.android.gms.internal.ads.zzfyh
    public final /* synthetic */ Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgdi, com.google.android.gms.internal.ads.zzgdg
    public final /* synthetic */ Future zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgdi
    public final ListenableFuture zzc() {
        return this.zza;
    }
}
