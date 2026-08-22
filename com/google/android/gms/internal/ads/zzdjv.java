package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjv {
    private final zzdsj zza;

    public zzdjv(zzdsj zzdsjVar) {
        this.zza = zzdsjVar;
    }

    public final void zza(View view, zzfca zzfcaVar) {
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznn)).booleanValue() || view == null) {
            return;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass().getName().startsWith("androidx.compose.ui")) {
                str = "1";
                zzdsi zzdsiVarZza = this.zza.zza();
                zzdsiVarZza.zzb("action", "hcp");
                zzdsiVarZza.zzb("hcp", str);
                zzdsiVarZza.zzc(zzfcaVar);
                zzdsiVarZza.zzj();
            }
        }
        str = "0";
        zzdsi zzdsiVarZza2 = this.zza.zza();
        zzdsiVarZza2.zzb("action", "hcp");
        zzdsiVarZza2.zzb("hcp", str);
        zzdsiVarZza2.zzc(zzfcaVar);
        zzdsiVarZza2.zzj();
    }
}
