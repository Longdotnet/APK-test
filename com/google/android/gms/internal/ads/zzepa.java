package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzepa implements zzeuc {
    private final zzgdy zza;
    private final zzdqe zzb;
    private final String zzc;
    private final zzfcw zzd;

    public zzepa(zzgdy zzgdyVar, zzdqe zzdqeVar, zzfcw zzfcwVar, String str) {
        this.zza = zzgdyVar;
        this.zzb = zzdqeVar;
        this.zzd = zzfcwVar;
        this.zzc = str;
    }

    public static /* synthetic */ zzepb zzc(zzepa zzepaVar) {
        zzfcw zzfcwVar = zzepaVar.zzd;
        zzdqe zzdqeVar = zzepaVar.zzb;
        return new zzepb(zzdqeVar.zzb(zzfcwVar.zzf, zzepaVar.zzc), zzdqeVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 17;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeoz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzepa.zzc(this.zza);
            }
        });
    }
}
