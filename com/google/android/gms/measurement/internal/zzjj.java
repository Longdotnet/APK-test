package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzjj implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzjl zza;

    public /* synthetic */ zzjj(zzjl zzjlVar, int i) {
        this.$r8$classId = i;
        this.zza = zzjlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzjl zzjlVar = this.zza;
                zzjm zzjmVar = zzjlVar.zza;
                Context context = ((zzfr) zzjmVar.mBuilder).zze;
                ((zzfr) zzjlVar.zza.mBuilder).getClass();
                zzjm.zzo(zzjmVar, new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
                break;
            default:
                zzjm zzjmVar2 = this.zza.zza;
                zzjmVar2.zzb = null;
                zzjmVar2.zzP$1();
                break;
        }
    }
}
