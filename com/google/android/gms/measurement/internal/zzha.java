package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzha implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzhx zzb;

    public /* synthetic */ zzha(zzhx zzhxVar, long j, int i) {
        this.$r8$classId = i;
        this.zzb = zzhxVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzhx zzhxVar = this.zzb;
                zzew zzewVar = ((zzfr) zzhxVar.mBuilder).zzl;
                zzfr.zzP(zzewVar);
                zzes zzesVar = zzewVar.zzf;
                long j = this.zza;
                zzesVar.zzb(j);
                zzeh zzehVar = ((zzfr) zzhxVar.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzk.zzb(Long.valueOf(j), "Session timeout duration set");
                break;
            default:
                long j2 = this.zza;
                zzhx zzhxVar2 = this.zzb;
                zzhxVar2.zzL(j2, true);
                ((zzfr) zzhxVar2.mBuilder).zzt().zzu(new AtomicReference());
                break;
        }
    }
}
