package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzawv implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzawx zzb;

    public zzawv(zzawx zzawxVar, int i, boolean z) {
        this.zza = i;
        this.zzb = zzawxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzatq zzatqVarZza;
        int i = this.zza;
        zzawx zzawxVar = this.zzb;
        if (i > 0) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            Context context = zzawxVar.zza;
            zzatqVarZza = zzfoq.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused2) {
            zzatqVarZza = null;
        }
        zzawx zzawxVar2 = this.zzb;
        zzawxVar2.zzk = zzatqVarZza;
        int i2 = this.zza;
        if (i2 < 4) {
            if (zzatqVarZza != null && zzatqVarZza.zzaf() && !zzatqVarZza.zzg().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzatqVarZza.zzag() && zzatqVarZza.zzf().zzg() && zzatqVarZza.zzf().zza() != -2) {
                return;
            }
            zzawxVar2.zzn(i2 + 1, true);
        }
    }
}
