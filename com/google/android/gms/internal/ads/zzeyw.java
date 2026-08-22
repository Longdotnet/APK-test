package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzeyw implements zzffe {
    public final zzezq zza;
    public final zzezs zzb;
    public final com.google.android.gms.ads.internal.client.zzm zzc;
    public final String zzd;
    public final Executor zze;
    public final com.google.android.gms.ads.internal.client.zzx zzf;
    public final zzfet zzg;

    public zzeyw(zzezq zzezqVar, zzezs zzezsVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, Executor executor, com.google.android.gms.ads.internal.client.zzx zzxVar, zzfet zzfetVar) {
        this.zza = zzezqVar;
        this.zzb = zzezsVar;
        this.zzc = zzmVar;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzxVar;
        this.zzg = zzfetVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffe
    public final zzfet zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzffe
    public final Executor zzb() {
        return this.zze;
    }
}
