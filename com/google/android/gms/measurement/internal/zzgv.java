package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzgv implements Runnable {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzgv(zzhx zzhxVar, Bundle bundle, long j) {
        this.zza = zzhxVar;
        this.zzb = bundle;
        this.zzc = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzhx zzhxVar = (zzhx) this.zza;
                if (!TextUtils.isEmpty(((zzfr) zzhxVar.mBuilder).zzh().zzm())) {
                    zzeh zzehVar = ((zzfr) zzhxVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzi.zza("Using developer consent only; google app id found");
                } else {
                    zzhxVar.zzR((Bundle) this.zzb, 0, this.zzc);
                }
                break;
            default:
                zzie zzieVar = (zzie) this.zza;
                long j = this.zzc;
                zzim zzimVar = (zzim) this.zzb;
                zzimVar.zzB(zzieVar, false, j);
                zzimVar.zza = null;
                zzjm zzjmVarZzt = ((zzfr) zzimVar.mBuilder).zzt();
                zzjmVarZzt.zzg();
                zzjmVarZzt.zza();
                zzjmVarZzt.zzR(new com.google.android.gms.tasks.zzc(zzjmVarZzt, null, 5));
                break;
        }
    }

    public zzgv(zzim zzimVar, zzie zzieVar, long j) {
        this.zzb = zzimVar;
        this.zza = zzieVar;
        this.zzc = j;
    }
}
