package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzesg implements zzeuc {
    private final zzgdy zza;
    private final zzfcw zzb;
    private final PackageInfo zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;

    public zzesg(zzgdy zzgdyVar, zzfcw zzfcwVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgdyVar;
        this.zzb = zzfcwVar;
        this.zzc = packageInfo;
        this.zzd = zzgVar;
    }

    public static /* synthetic */ zzesh zzc(zzesg zzesgVar) {
        return new zzesh(zzesgVar.zzb, zzesgVar.zzc, zzesgVar.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 26;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzesg.zzc(this.zza);
            }
        });
    }
}
