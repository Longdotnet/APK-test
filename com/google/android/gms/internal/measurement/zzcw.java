package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzcw extends zzdu {
    final /* synthetic */ long zza;
    final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcw(zzef zzefVar, long j) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = j;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        zzcc zzccVar = this.zzb.zzj;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
        zzccVar.setSessionTimeoutDuration(this.zza);
    }
}
