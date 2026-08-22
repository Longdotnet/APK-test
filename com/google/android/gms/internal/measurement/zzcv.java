package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzcv extends zzdu {
    final /* synthetic */ zzef zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcv(zzef zzefVar) {
        super(zzefVar, true);
        this.zza = zzefVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        zzcc zzccVar = this.zza.zzj;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
        zzccVar.resetAnalyticsData(this.zzh);
    }
}
