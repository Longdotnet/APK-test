package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzdq extends zzdu {
    final /* synthetic */ zzdw zza;
    final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdq(zzef zzefVar, zzdw zzdwVar) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = zzdwVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        zzcc zzccVar = this.zzb.zzj;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
        zzccVar.registerOnMeasurementEventListener(this.zza);
    }
}
