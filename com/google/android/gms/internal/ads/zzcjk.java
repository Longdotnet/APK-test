package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcjk implements zzfbt {
    private final zzcio zza;
    private Context zzb;
    private String zzc;

    public /* synthetic */ zzcjk(zzcio zzcioVar, zzcjs zzcjsVar) {
        this.zza = zzcioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfbt
    public final /* synthetic */ zzfbt zza(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfbt
    public final /* bridge */ /* synthetic */ zzfbt zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfbt
    public final zzfbu zzc() {
        zzhgz.zzc(this.zzb, Context.class);
        return new zzcjl(this.zza, this.zzb, this.zzc);
    }
}
