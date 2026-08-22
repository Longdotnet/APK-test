package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzdm extends zzdu {
    final /* synthetic */ zzbz zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzef zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdm(zzef zzefVar, zzbz zzbzVar, int i) {
        super(zzefVar, true);
        this.zzc = zzefVar;
        this.zza = zzbzVar;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        zzcc zzccVar = this.zzc.zzj;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
        zzccVar.getTestFlag(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zzb() {
        this.zza.zze(null);
    }
}
