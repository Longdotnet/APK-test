package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbkn implements zzgdj {
    final /* synthetic */ Map zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zza zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbkr zzd;

    public zzbkn(zzbkr zzbkrVar, Map map, com.google.android.gms.ads.internal.client.zza zzaVar, String str) {
        this.zza = map;
        this.zzb = zzaVar;
        this.zzc = str;
        Objects.requireNonNull(zzbkrVar);
        this.zzd = zzbkrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "OpenGmsgHandler.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        String str = (String) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzky)).booleanValue()) {
            this.zza.put("u", str);
        }
        this.zzd.zzh(str, this.zzb, this.zza, this.zzc);
    }
}
