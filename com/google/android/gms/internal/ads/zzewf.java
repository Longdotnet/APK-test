package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzewf implements zzeuc {
    final ScheduledExecutorService zza;

    public zzewf(zzbtu zzbtuVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 49;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return zzgdn.zzm(zzgdn.zzo(zzgdn.zzh(new Bundle()), ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzex)).longValue(), TimeUnit.MILLISECONDS, this.zza), new zzfve() { // from class: com.google.android.gms.internal.ads.zzewe
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return new zzewg((Bundle) obj);
            }
        }, zzcaf.zza);
    }
}
