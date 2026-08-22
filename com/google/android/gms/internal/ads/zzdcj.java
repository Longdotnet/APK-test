package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdcj implements zzhgr {
    private final zzdbw zza;

    private zzdcj(zzdbw zzdbwVar) {
        this.zza = zzdbwVar;
    }

    public static zzdcj zza(zzdbw zzdbwVar) {
        return new zzdcj(zzdbwVar);
    }

    public static Set zzc(zzdbw zzdbwVar) {
        return zzdbwVar.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return this.zza.zzj();
    }
}
