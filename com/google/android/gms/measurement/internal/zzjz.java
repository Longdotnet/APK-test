package com.google.android.gms.measurement.internal;

import android.os.SystemClock;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;

/* JADX INFO: loaded from: classes2.dex */
public final class zzjz extends zzap {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zzjz(Object obj, zzgm zzgmVar, int i) {
        super(zzgmVar);
        this.$r8$classId = i;
        this.zza = obj;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                zzka zzkaVar = (zzka) this.zza;
                zzkaVar.zzc.zzg();
                zzkc zzkcVar = zzkaVar.zzc;
                ((zzfr) zzkcVar.mBuilder).zzr.getClass();
                zzkaVar.zzd(SystemClock.elapsedRealtime(), false, false);
                zzfr zzfrVar = (zzfr) zzkcVar.mBuilder;
                zzd zzdVarZzd = zzfrVar.zzd();
                zzfrVar.zzr.getClass();
                zzdVarZzd.zzf(SystemClock.elapsedRealtime());
                break;
            default:
                zzkf zzkfVar = (zzkf) this.zza;
                zzkfVar.zza();
                zzeh zzehVar = ((zzfr) zzkfVar.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zza(yzwzcWHcnH.pfbLWU);
                zzkfVar.zzf.zzX();
                break;
        }
    }
}
