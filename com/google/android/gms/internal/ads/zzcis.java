package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcis implements zzexa {
    private final zzcio zza;
    private Context zzb;
    private String zzc;

    public /* synthetic */ zzcis(zzcio zzcioVar, zzcjs zzcjsVar) {
        this.zza = zzcioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexa
    public final /* bridge */ /* synthetic */ zzexa zza(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzexa
    public final /* bridge */ /* synthetic */ zzexa zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzexa
    public final zzexb zzc() {
        zzhgz.zzc(this.zzb, Context.class);
        zzhgz.zzc(this.zzc, String.class);
        return new zzcit(this.zza, this.zzb, this.zzc);
    }
}
