package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeau implements zzcxm, zzcwb {
    private static final Object zza = new Object();
    private static int zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private final zzebe zzd;

    public zzeau(zzebe zzebeVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzd = zzebeVar;
        this.zzc = zzgVar;
    }

    private final void zzb(boolean z) {
        int i;
        int iIntValue;
        zzbcv zzbcvVar = zzbde.zzgv;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && !((com.google.android.gms.ads.internal.util.zzj) this.zzc).zzN()) {
            Object obj = zza;
            synchronized (obj) {
                i = zzb;
                iIntValue = ((Integer) zzbdVar.zzd.zzb(zzbde.zzgw)).intValue();
            }
            if (i < iIntValue) {
                this.zzd.zzd(z);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        zzb(true);
    }
}
