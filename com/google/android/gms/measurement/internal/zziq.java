package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zziq implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzjm zzb;

    public /* synthetic */ zziq(zzjm zzjmVar, zzq zzqVar, int i) {
        this.$r8$classId = i;
        this.zzb = zzjmVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                zzq zzqVar = this.zza;
                zzjm zzjmVar = this.zzb;
                zzdx zzdxVar = zzjmVar.zzb;
                zzfr zzfrVar = (zzfr) zzjmVar.mBuilder;
                if (zzdxVar != null) {
                    try {
                        zzdxVar.zzm(zzqVar);
                    } catch (RemoteException e) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzb(e, "Failed to reset data on the service: remote exception");
                    }
                    zzjmVar.zzQ();
                } else {
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zza("Failed to reset data on the service: not connected to service");
                }
                break;
            case 1:
                zzq zzqVar2 = this.zza;
                zzjm zzjmVar2 = this.zzb;
                zzdx zzdxVar2 = zzjmVar2.zzb;
                zzfr zzfrVar2 = (zzfr) zzjmVar2.mBuilder;
                if (zzdxVar2 == null) {
                    zzeh zzehVar3 = zzfrVar2.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zza("Discarding data. Failed to send app launch");
                } else {
                    try {
                        zzdxVar2.zzj(zzqVar2);
                        zzfrVar2.zzi().zzm();
                        zzjmVar2.zzD(zzdxVar2, null, zzqVar2);
                        zzjmVar2.zzQ();
                    } catch (RemoteException e2) {
                        zzeh zzehVar4 = zzfrVar2.zzm;
                        zzfr.zzR(zzehVar4);
                        zzehVar4.zzd.zzb(e2, "Failed to send app launch to the service");
                        return;
                    }
                }
                break;
            case 2:
                zzq zzqVar3 = this.zza;
                zzjm zzjmVar3 = this.zzb;
                zzdx zzdxVar3 = zzjmVar3.zzb;
                zzfr zzfrVar3 = (zzfr) zzjmVar3.mBuilder;
                if (zzdxVar3 == null) {
                    zzeh zzehVar5 = zzfrVar3.zzm;
                    zzfr.zzR(zzehVar5);
                    zzehVar5.zzd.zza("Failed to send measurementEnabled to service");
                } else {
                    try {
                        zzdxVar3.zzs(zzqVar3);
                        zzjmVar3.zzQ();
                    } catch (RemoteException e3) {
                        zzeh zzehVar6 = zzfrVar3.zzm;
                        zzfr.zzR(zzehVar6);
                        zzehVar6.zzd.zzb(e3, "Failed to send measurementEnabled to the service");
                        return;
                    }
                }
                break;
            default:
                zzq zzqVar4 = this.zza;
                zzjm zzjmVar4 = this.zzb;
                zzdx zzdxVar4 = zzjmVar4.zzb;
                zzfr zzfrVar4 = (zzfr) zzjmVar4.mBuilder;
                if (zzdxVar4 == null) {
                    zzeh zzehVar7 = zzfrVar4.zzm;
                    zzfr.zzR(zzehVar7);
                    zzehVar7.zzd.zza("Failed to send consent settings to service");
                } else {
                    try {
                        zzdxVar4.zzp(zzqVar4);
                        zzjmVar4.zzQ();
                    } catch (RemoteException e4) {
                        zzeh zzehVar8 = zzfrVar4.zzm;
                        zzfr.zzR(zzehVar8);
                        zzehVar8.zzd.zzb(e4, "Failed to send consent settings to the service");
                    }
                }
                break;
        }
    }
}
