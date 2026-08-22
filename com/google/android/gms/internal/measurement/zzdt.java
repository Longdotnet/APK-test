package com.google.android.gms.internal.measurement;

import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
final class zzdt extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzef zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdt(zzef zzefVar, String str, String str2, Object obj, boolean z) {
        super(zzefVar, true);
        this.zze = zzefVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        zzcc zzccVar = this.zze.zzj;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
        zzccVar.setUserProperty(this.zza, this.zzb, new ObjectWrapper(this.zzc), this.zzd, this.zzh);
    }
}
