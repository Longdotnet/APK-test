package com.google.android.gms.internal.ads;

import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpu implements zzcws {
    private final zzcfg zza;
    private final zzdsj zzb;
    private final zzfca zzc;

    public zzcpu(zzcfg zzcfgVar, zzdsj zzdsjVar, zzfca zzfcaVar) {
        this.zza = zzcfgVar;
        this.zzb = zzdsjVar;
        this.zzc = zzfcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        zzcfg zzcfgVar;
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznn)).booleanValue() || (zzcfgVar = this.zza) == null) {
            return;
        }
        for (ViewParent parent = zzcfgVar.zzF().getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass().getName().startsWith("androidx.compose.ui")) {
                str = "1";
                zzdsi zzdsiVarZza = this.zzb.zza();
                zzdsiVarZza.zzb("action", "hcp");
                zzdsiVarZza.zzb("hcp", str);
                zzdsiVarZza.zzc(this.zzc);
                zzdsiVarZza.zzj();
            }
        }
        str = "0";
        zzdsi zzdsiVarZza2 = this.zzb.zza();
        zzdsiVarZza2.zzb("action", "hcp");
        zzdsiVarZza2.zzb("hcp", str);
        zzdsiVarZza2.zzc(this.zzc);
        zzdsiVarZza2.zzj();
    }
}
