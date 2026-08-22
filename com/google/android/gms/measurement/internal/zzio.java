package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzio implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ AbstractSafeParcelable zzc;
    public final /* synthetic */ zzjm zzd;

    public /* synthetic */ zzio(zzjm zzjmVar, zzq zzqVar, boolean z, AbstractSafeParcelable abstractSafeParcelable, int i) {
        this.$r8$classId = i;
        this.zzd = zzjmVar;
        this.zza = zzqVar;
        this.zzb = z;
        this.zzc = abstractSafeParcelable;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                zzjm zzjmVar = this.zzd;
                zzdx zzdxVar = zzjmVar.zzb;
                if (zzdxVar != null) {
                    zzjmVar.zzD(zzdxVar, this.zzb ? null : (zzkw) this.zzc, this.zza);
                    zzjmVar.zzQ();
                } else {
                    zzeh zzehVar = ((zzfr) zzjmVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zza("Discarding data. Failed to set user property");
                }
                break;
            case 1:
                zzjm zzjmVar2 = this.zzd;
                zzdx zzdxVar2 = zzjmVar2.zzb;
                if (zzdxVar2 != null) {
                    zzjmVar2.zzD(zzdxVar2, this.zzb ? null : (zzaw) this.zzc, this.zza);
                    zzjmVar2.zzQ();
                } else {
                    zzeh zzehVar2 = ((zzfr) zzjmVar2.mBuilder).zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zza("Discarding data. Failed to send event to service");
                }
                break;
            default:
                zzjm zzjmVar3 = this.zzd;
                zzdx zzdxVar3 = zzjmVar3.zzb;
                if (zzdxVar3 != null) {
                    zzjmVar3.zzD(zzdxVar3, this.zzb ? null : (zzac) this.zzc, this.zza);
                    zzjmVar3.zzQ();
                } else {
                    zzeh zzehVar3 = ((zzfr) zzjmVar3.mBuilder).zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zza("Discarding data. Failed to send conditional user property to service");
                }
                break;
        }
    }
}
