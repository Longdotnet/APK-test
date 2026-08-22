package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcix implements zzeyo {
    private final zzcio zza;
    private Context zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzr zzd;

    public /* synthetic */ zzcix(zzcio zzcioVar, zzcjs zzcjsVar) {
        this.zza = zzcioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeyo
    public final /* bridge */ /* synthetic */ zzeyo zza(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzrVar.getClass();
        this.zzd = zzrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeyo
    public final /* bridge */ /* synthetic */ zzeyo zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeyo
    public final /* bridge */ /* synthetic */ zzeyo zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeyo
    public final zzeyp zzd() {
        zzhgz.zzc(this.zzb, Context.class);
        zzhgz.zzc(this.zzc, String.class);
        zzhgz.zzc(this.zzd, com.google.android.gms.ads.internal.client.zzr.class);
        return new zzciy(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
