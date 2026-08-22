package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwo implements zzcza, zzdep, zzcxm {
    private final Context zza;
    private final zzdsj zzb;

    public zzdwo(Context context, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = zzdsjVar;
    }

    public static void zzc(zzdwo zzdwoVar, Context context) {
        com.google.android.gms.ads.internal.zzv.zza.zzo.zzd(context, zzdwoVar.zzb);
    }

    private final void zzd(final Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeT)).booleanValue()) {
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdwn
                @Override // java.lang.Runnable
                public final void run() {
                    zzdwo.zzc(this.zza, context);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeV)).booleanValue()) {
            zzd(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbk zzbkVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeW)).booleanValue()) {
            zzd(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zzf(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeX)).booleanValue()) {
            zzd(this.zza);
        }
    }
}
