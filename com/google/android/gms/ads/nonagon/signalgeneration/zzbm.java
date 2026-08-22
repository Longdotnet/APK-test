package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.zza;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzdep;

/* JADX INFO: loaded from: classes.dex */
public final class zzbm implements zzdep {
    public final zzb zza;
    public final int zzb;
    public final String zzc;

    public zzbm(zzb zzbVar, int i, String str) {
        this.zza = zzbVar;
        this.zzb = i;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zze(zzbk zzbkVar) {
        if (zzbkVar == null || this.zzb != 2 || TextUtils.isEmpty(this.zzc)) {
            return;
        }
        zza zzaVar = new zza(this, zzbkVar, 24);
        com.google.android.gms.ads.internal.util.zzf zzfVar = zzs.zza;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            zzaVar.run();
        } else {
            zzcaf.zza.execute(zzaVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zzf(String str) {
    }
}
