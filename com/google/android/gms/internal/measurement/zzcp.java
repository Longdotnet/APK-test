package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzcp extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbz zzc;
    final /* synthetic */ zzef zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcp(zzef zzefVar, String str, String str2, zzbz zzbzVar) {
        super(zzefVar, true);
        this.zzd = zzefVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        zzcc zzccVar = this.zzd.zzj;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
        zzccVar.getConditionalUserProperties(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zzb() {
        this.zzc.zze(null);
    }
}
