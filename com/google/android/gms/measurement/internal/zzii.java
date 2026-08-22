package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzii implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzim zza;

    public /* synthetic */ zzii(zzim zzimVar, int i) {
        this.$r8$classId = i;
        this.zza = zzimVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzim zzimVar = this.zza;
                zzimVar.zza = zzimVar.zzh;
                break;
            default:
                this.zza.zzh = null;
                break;
        }
    }
}
