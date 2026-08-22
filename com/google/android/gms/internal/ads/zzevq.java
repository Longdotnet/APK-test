package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzevq implements zzeuc {
    final zzgdy zza;

    public zzevq(zzbbr zzbbrVar, zzgdy zzgdyVar, Context context) {
        this.zza = zzgdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 45;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzevp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzevr(new JSONObject());
            }
        });
    }
}
