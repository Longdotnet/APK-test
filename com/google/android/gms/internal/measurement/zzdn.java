package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzdn extends zzdu {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdn(zzef zzefVar, boolean z) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        zzcc zzccVar = this.zzb.zzj;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
        zzccVar.setDataCollectionEnabled(this.zza);
    }
}
