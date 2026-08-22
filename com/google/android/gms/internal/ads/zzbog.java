package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbog implements zzcao {
    final /* synthetic */ zzboh zza;

    public zzbog(zzboh zzbohVar) {
        Objects.requireNonNull(zzbohVar);
        this.zza = zzbohVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcao
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        final zzbnd zzbndVar = (zzbnd) obj;
        zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbof
            @Override // java.lang.Runnable
            public final void run() {
                zzbnd zzbndVar2 = zzbndVar;
                zzbndVar2.zzr("/result", zzbke.zzo);
                zzbndVar2.zzc();
            }
        });
    }
}
