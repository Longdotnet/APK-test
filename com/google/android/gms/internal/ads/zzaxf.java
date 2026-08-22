package com.google.android.gms.internal.ads;

import android.app.AppOpsManager$OnOpActiveChangedListener;

/* JADX INFO: loaded from: classes.dex */
final class zzaxf implements AppOpsManager$OnOpActiveChangedListener {
    final /* synthetic */ zzaxg zza;

    public zzaxf(zzaxg zzaxgVar) {
        this.zza = zzaxgVar;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            zzaxg zzaxgVar = this.zza;
            zzaxgVar.zzb = System.currentTimeMillis();
            zzaxgVar.zze = true;
        } else {
            zzaxg zzaxgVar2 = this.zza;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (zzaxgVar2.zzc > 0 && jCurrentTimeMillis >= zzaxgVar2.zzc) {
                zzaxgVar2.zzd = jCurrentTimeMillis - zzaxgVar2.zzc;
            }
            zzaxgVar2.zze = false;
        }
    }
}
