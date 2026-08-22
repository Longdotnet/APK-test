package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmu implements zzcwb {
    private final zzfcd zza;
    private final zzfcn zzb;
    private final zzfju zzc;
    private final zzfjy zzd;

    public zzcmu(zzfcn zzfcnVar, zzfjy zzfjyVar, zzfju zzfjuVar) {
        this.zzb = zzfcnVar;
        this.zzd = zzfjyVar;
        this.zzc = zzfjuVar;
        this.zza = zzfcnVar.zzb.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(com.google.android.gms.ads.internal.client.zze zzeVar) {
        List list = this.zza.zza;
        this.zzd.zze(this.zzc.zzd(this.zzb, null, list), null);
    }
}
