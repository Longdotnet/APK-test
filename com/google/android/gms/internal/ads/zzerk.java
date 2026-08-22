package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public final class zzerk implements zzeuc {
    private final zzgdy zza;
    private final zzfcw zzb;

    public zzerk(zzgdy zzgdyVar, zzfcw zzfcwVar) {
        this.zza = zzgdyVar;
        this.zzb = zzfcwVar;
    }

    public static /* synthetic */ zzerl zzc(zzerk zzerkVar) {
        return new zzerl("requester_type_2".equals(MediaType.Companion.zzc(zzerkVar.zzb.zzd)));
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 21;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzerj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzerk.zzc(this.zza);
            }
        });
    }
}
