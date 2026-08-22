package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzdtw implements zzdtk {
    private final long zza;
    private final zzelg zzb;

    public zzdtw(long j, Context context, zzdtp zzdtpVar, zzche zzcheVar, String str) {
        this.zza = j;
        zzfaf zzfafVarZzu = zzcheVar.zzu();
        zzfafVarZzu.zzc(context);
        zzfafVarZzu.zza(new com.google.android.gms.ads.internal.client.zzr());
        zzfafVarZzu.zzb(str);
        zzelg zzelgVarZza = zzfafVarZzu.zzd().zza();
        this.zzb = zzelgVarZza;
        zzelgVarZza.zzE(new zzdtv(this, zzdtpVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zza() {
        this.zzb.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzb(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zzb.zzad(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzc() {
        this.zzb.zzY(new ObjectWrapper(null));
    }
}
