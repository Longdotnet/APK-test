package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
public final class zzcoa {
    private final zzdsj zza;
    private final zzfcn zzb;

    public zzcoa(zzdsj zzdsjVar, zzfcn zzfcnVar) {
        this.zza = zzdsjVar;
        this.zzb = zzfcnVar;
    }

    public final void zza(long j, int i) {
        String str;
        zzdsi zzdsiVarZza = this.zza.zza();
        zzdsiVarZza.zzd(this.zzb.zzb.zzb);
        zzdsiVarZza.zzb("action", "ad_closed");
        zzdsiVarZza.zzb("show_time", String.valueOf(j));
        zzdsiVarZza.zzb(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        int i2 = i - 1;
        if (i2 == 0) {
            str = "h";
        } else if (i2 == 1) {
            str = "bb";
        } else if (i2 == 2) {
            str = "cc";
        } else if (i2 != 3) {
            str = i2 != 4 ? "u" : "ac";
        } else {
            str = "cb";
        }
        zzdsiVarZza.zzb("acr", str);
        zzdsiVarZza.zzj();
    }
}
