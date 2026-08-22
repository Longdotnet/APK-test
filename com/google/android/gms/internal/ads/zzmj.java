package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzmj {
    private final zziw zza;

    @Deprecated
    public zzmj(Context context, zzcem zzcemVar) {
        this.zza = new zziw(context, zzcemVar);
    }

    @Deprecated
    public final zzmj zza(final zzkx zzkxVar) {
        zziw zziwVar = this.zza;
        zzdd.zzf(!zziwVar.zzs);
        zzkxVar.getClass();
        zziwVar.zzf = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzio
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return zzkxVar;
            }
        };
        return this;
    }

    @Deprecated
    public final zzmj zzb(final zzzd zzzdVar) {
        zziw zziwVar = this.zza;
        zzdd.zzf(!zziwVar.zzs);
        zzzdVar.getClass();
        zziwVar.zze = new zzfwh() { // from class: com.google.android.gms.internal.ads.zziv
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return zzzdVar;
            }
        };
        return this;
    }

    @Deprecated
    public final zzmk zzc() {
        zziw zziwVar = this.zza;
        zzdd.zzf(!zziwVar.zzs);
        zziwVar.zzs = true;
        return new zzmk(zziwVar);
    }
}
