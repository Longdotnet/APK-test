package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdok implements zzbkw {
    private final zzcxf zza;
    private final zzbwo zzb;
    private final String zzc;
    private final String zzd;

    public zzdok(zzcxf zzcxfVar, zzfca zzfcaVar) {
        this.zza = zzcxfVar;
        this.zzb = zzfcaVar.zzl;
        this.zzc = zzfcaVar.zzj;
        this.zzd = zzfcaVar.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzbkw
    public final void zzb() {
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbkw
    public final void zzc() {
        this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbkw
    public final void zza(zzbwo zzbwoVar) {
        int i;
        String str;
        zzbwo zzbwoVar2 = this.zzb;
        if (zzbwoVar2 != null) {
            zzbwoVar = zzbwoVar2;
        }
        if (zzbwoVar != null) {
            str = zzbwoVar.zza;
            i = zzbwoVar.zzb;
        } else {
            i = 1;
            str = yzwzcWHcnH.qdDsNekTp;
        }
        this.zza.zzd(new zzbvz(str, i), this.zzc, this.zzd);
    }
}
