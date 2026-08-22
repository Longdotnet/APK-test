package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzcs extends zzdu {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcs(zzef zzefVar, Boolean bool) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = bool;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        if (this.zza != null) {
            zzcc zzccVar = this.zzb.zzj;
            com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
            zzccVar.setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
        } else {
            zzcc zzccVar2 = this.zzb.zzj;
            com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar2);
            zzccVar2.clearMeasurementEnabled(this.zzh);
        }
    }
}
