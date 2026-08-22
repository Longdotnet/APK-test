package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcji implements zzfaf {
    private final zzcio zza;
    private Context zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzr zzd;

    public /* synthetic */ zzcji(zzcio zzcioVar, zzcjs zzcjsVar) {
        this.zza = zzcioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfaf
    public final /* bridge */ /* synthetic */ zzfaf zza(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzrVar.getClass();
        this.zzd = zzrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfaf
    public final /* bridge */ /* synthetic */ zzfaf zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfaf
    public final /* bridge */ /* synthetic */ zzfaf zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfaf
    public final zzfag zzd() {
        zzhgz.zzc(this.zzb, Context.class);
        zzhgz.zzc(this.zzc, String.class);
        zzhgz.zzc(this.zzd, com.google.android.gms.ads.internal.client.zzr.class);
        return new zzcjj(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
