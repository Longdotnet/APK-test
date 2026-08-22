package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzcy extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcy(zzef zzefVar, String str) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        zzcc zzccVar = this.zzb.zzj;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
        zzccVar.beginAdUnitExposure(this.zza, this.zzi);
    }
}
