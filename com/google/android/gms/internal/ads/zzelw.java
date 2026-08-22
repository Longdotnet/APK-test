package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzelw implements zzeuc {
    private final Context zza;

    public zzelw(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return zzgdn.zzh(new zzelx(ContextCompat.checkSelfPermission(this.zza, "com.google.android.gms.permission.AD_ID") == 0));
    }
}
