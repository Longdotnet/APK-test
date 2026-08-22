package com.google.android.gms.measurement.internal;

import androidx.work.impl.WorkerWrapper;
import com.google.android.gms.internal.measurement.zzcf;

/* JADX INFO: loaded from: classes.dex */
public final class zzi implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public /* synthetic */ zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcfVar, int i) {
        this.$r8$classId = i;
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzjm zzjmVarZzt = this.zzb.zza.zzt();
                zzjmVarZzt.zzg();
                zzjmVarZzt.zza();
                zzjmVarZzt.zzR(new WorkerWrapper.AnonymousClass1(zzjmVarZzt, zzjmVarZzt.zzO(false), this.zza, 23));
                break;
            default:
                AppMeasurementDynamiteService appMeasurementDynamiteService = this.zzb;
                zzlb zzlbVar = appMeasurementDynamiteService.zza.zzp;
                zzfr.zzP(zzlbVar);
                zzfr zzfrVar = appMeasurementDynamiteService.zza;
                zzlbVar.zzP(this.zza, zzfrVar.zzE != null && zzfrVar.zzE.booleanValue());
                break;
        }
    }
}
