package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzetn implements zzeub {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final Long zze;

    public zzetn(String str, String str2, String str3, String str4, Long l) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = l;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzfdk.zzc(((zzcva) obj).zzb, "fbs_aeid", this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        zzfdk.zzc(bundle, "gmp_app_id", this.zza);
        zzfdk.zzc(bundle, "fbs_aiid", this.zzb);
        zzfdk.zzc(bundle, "fbs_aeid", this.zzc);
        zzfdk.zzc(bundle, "apm_id_origin", this.zzd);
        Long l = this.zze;
        if (l != null) {
            bundle.putLong("sai_timeout", l.longValue());
        }
    }
}
