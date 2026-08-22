package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzffs implements zzhgr {
    public static zzffs zza() {
        return zzffr.zza;
    }

    public static zzgdy zzc() {
        zzgdy zzgdyVar;
        zzbcv zzbcvVar = zzbde.zzfZ;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzgdyVar = zzcaf.zzc;
        } else {
            zzgdyVar = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzfY)).booleanValue() ? zzcaf.zza : zzcaf.zzf;
        }
        zzhgz.zzb(zzgdyVar);
        return zzgdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc();
    }
}
