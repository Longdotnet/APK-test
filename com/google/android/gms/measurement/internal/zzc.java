package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long zza;
    public final /* synthetic */ zze zzb;

    public /* synthetic */ zzc(zze zzeVar, long j, int i) {
        this.$r8$classId = i;
        this.zzb = zzeVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((zzd) this.zzb).zzj(this.zza);
                break;
            default:
                zzim zzimVar = (zzim) this.zzb;
                ((zzfr) zzimVar.mBuilder).zzd().zzf(this.zza);
                zzimVar.zza = null;
                break;
        }
    }
}
