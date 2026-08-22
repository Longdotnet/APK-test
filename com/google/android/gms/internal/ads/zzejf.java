package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzejf implements zzedm {
    private final zzbdz zza;
    private final zzgdy zzb;
    private final zzfha zzc;
    private final zzejo zzd;

    public zzejf(zzfha zzfhaVar, zzgdy zzgdyVar, zzbdz zzbdzVar, zzejo zzejoVar) {
        this.zzc = zzfhaVar;
        this.zzb = zzgdyVar;
        this.zza = zzbdzVar;
        this.zzd = zzejoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(zzfcn zzfcnVar, zzfca zzfcaVar) {
        zzcak zzcakVar = new zzcak();
        zzejk zzejkVar = new zzejk();
        zzejkVar.zzd(new zzeje(this, zzcakVar, zzfcnVar, zzfcaVar, zzejkVar));
        zzfcf zzfcfVar = zzfcaVar.zzs;
        final zzbdu zzbduVar = new zzbdu(zzejkVar, zzfcfVar.zzb, zzfcfVar.zza);
        zzfgu zzfguVar = zzfgu.CUSTOM_RENDER_SYN;
        zzfha zzfhaVar = this.zzc;
        Objects.requireNonNull(zzfhaVar);
        return zzfgk.zzd(new zzfgf() { // from class: com.google.android.gms.internal.ads.zzejd
            @Override // com.google.android.gms.internal.ads.zzfgf
            public final void zza() {
                this.zza.zza.zze(zzbduVar);
            }
        }, this.zzb, zzfguVar, zzfhaVar).zzb(zzfgu.zzu).zzd(zzcakVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        zzfcf zzfcfVar;
        return (this.zza == null || (zzfcfVar = zzfcaVar.zzs) == null || zzfcfVar.zza == null) ? false : true;
    }
}
