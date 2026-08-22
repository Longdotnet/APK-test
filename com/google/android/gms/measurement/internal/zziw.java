package com.google.android.gms.measurement.internal;

import com.google.android.gms.ads.internal.gMU.QTaELkFI;

/* JADX INFO: loaded from: classes2.dex */
public final class zziw extends zzap {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzjm zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zziw(zzjm zzjmVar, zzfr zzfrVar, int i) {
        super(zzfrVar);
        this.$r8$classId = i;
        this.zza = zzjmVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        switch (this.$r8$classId) {
            case 0:
                zzjm zzjmVar = this.zza;
                zzjmVar.zzg();
                if (zzjmVar.zzL()) {
                    zzeh zzehVar = ((zzfr) zzjmVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzl.zza("Inactivity, disconnecting from the service");
                    zzjmVar.zzs$1();
                    break;
                }
                break;
            default:
                zzeh zzehVar2 = ((zzfr) this.zza.mBuilder).zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzg.zza(QTaELkFI.odaceGw);
                break;
        }
    }
}
