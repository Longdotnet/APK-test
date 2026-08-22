package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcnh implements zzbkf {
    final /* synthetic */ zzcni zza;

    public zzcnh(zzcni zzcniVar) {
        Objects.requireNonNull(zzcniVar);
        this.zza = zzcniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcni zzcniVar = this.zza;
        if (zzcni.zzg(zzcniVar, map)) {
            zzcniVar.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcng
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza.zzd.zzj();
                }
            });
        }
    }
}
