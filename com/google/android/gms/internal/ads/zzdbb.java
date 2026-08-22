package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdbb implements zzcza {
    private int zza;
    private int zzb;

    public zzdbb() {
        zzbcv zzbcvVar = zzbde.zzbt;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        this.zza = ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue();
        this.zzb = ((Integer) zzbdVar.zzd.zzb(zzbde.zznl)).intValue();
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final synchronized void zzdo(zzfcn zzfcnVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbu)).booleanValue()) {
            try {
                zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
                this.zza = zzfcdVar.zzc;
                this.zzb = zzfcdVar.zzd;
            } catch (NullPointerException unused) {
            }
        }
    }
}
