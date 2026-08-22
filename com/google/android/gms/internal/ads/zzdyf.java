package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzdyf implements zzgdj {
    final /* synthetic */ Context zza;

    public zzdyf(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        if (((Boolean) zzbew.zzh.zze()).booleanValue() && (th instanceof com.google.android.gms.ads.internal.util.zzba)) {
            zzbco.zze(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        if (((Boolean) zzbew.zzj.zze()).booleanValue()) {
            zzbco.zze(this.zza);
        }
    }
}
