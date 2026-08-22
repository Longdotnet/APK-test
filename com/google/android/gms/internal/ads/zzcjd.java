package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcjd implements zzdtt {
    private final zzcio zza;
    private Context zzb;
    private zzble zzc;

    public /* synthetic */ zzcjd(zzcio zzcioVar, zzcjs zzcjsVar) {
        this.zza = zzcioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtt
    public final /* bridge */ /* synthetic */ zzdtt zza(zzble zzbleVar) {
        zzbleVar.getClass();
        this.zzc = zzbleVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtt
    public final /* bridge */ /* synthetic */ zzdtt zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtt
    public final zzdtu zzc() {
        zzhgz.zzc(this.zzb, Context.class);
        zzhgz.zzc(this.zzc, zzble.class);
        return new zzcje(this.zza, this.zzb, this.zzc);
    }
}
