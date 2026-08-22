package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzjg implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzdx zza;
    public final /* synthetic */ zzjl zzb;

    public /* synthetic */ zzjg(zzjl zzjlVar, zzdx zzdxVar, int i) {
        this.$r8$classId = i;
        this.zzb = zzjlVar;
        this.zza = zzdxVar;
    }

    private final void run$com$google$android$gms$measurement$internal$zzjg() {
        synchronized (this.zzb) {
            try {
                this.zzb.zzb = false;
                if (!this.zzb.zza.zzL()) {
                    zzeh zzehVar = ((zzfr) this.zzb.zza.mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzl.zza("Connected to service");
                    zzjm zzjmVar = this.zzb.zza;
                    zzdx zzdxVar = this.zza;
                    zzjmVar.zzg();
                    zzjmVar.zzb = zzdxVar;
                    zzjmVar.zzQ();
                    zzjmVar.zzP$1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                run$com$google$android$gms$measurement$internal$zzjg();
                return;
            default:
                synchronized (this.zzb) {
                    try {
                        this.zzb.zzb = false;
                        if (!this.zzb.zza.zzL()) {
                            zzeh zzehVar = ((zzfr) this.zzb.zza.mBuilder).zzm;
                            zzfr.zzR(zzehVar);
                            zzehVar.zzk.zza("Connected to remote service");
                            zzjm zzjmVar = this.zzb.zza;
                            zzdx zzdxVar = this.zza;
                            zzjmVar.zzg();
                            com.google.android.gms.common.internal.zzah.checkNotNull(zzdxVar);
                            zzjmVar.zzb = zzdxVar;
                            zzjmVar.zzQ();
                            zzjmVar.zzP$1();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }
}
