package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpj {
    private final Context zza;
    private final zzavu zzb;
    private final zzbel zzc;
    private final VersionInfoParcel zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbcc zzf;
    private final zzcyv zzg;
    private final zzecl zzh;
    private final zzfda zzi;
    private final zzdsj zzj;

    public zzdpj(zzcft zzcftVar, Context context, zzavu zzavuVar, zzbel zzbelVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbcc zzbccVar, zzcyv zzcyvVar, zzecl zzeclVar, zzfda zzfdaVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = zzavuVar;
        this.zzc = zzbelVar;
        this.zzd = versionInfoParcel;
        this.zze = zzaVar;
        this.zzf = zzbccVar;
        this.zzg = zzcyvVar;
        this.zzh = zzeclVar;
        this.zzi = zzfdaVar;
        this.zzj = zzdsjVar;
    }

    public final zzcfg zza(com.google.android.gms.ads.internal.client.zzr zzrVar, zzfca zzfcaVar, zzfcd zzfcdVar) {
        zzchd zzchdVarZzc = zzchd.zzc(zzrVar);
        String str = zzrVar.zza;
        zzdoy zzdoyVar = new zzdoy(this);
        zzecl zzeclVar = this.zzh;
        zzfda zzfdaVar = this.zzi;
        zzdsj zzdsjVar = this.zzj;
        com.google.android.gms.ads.internal.zza zzaVar = this.zze;
        zzbcc zzbccVar = this.zzf;
        return zzcft.zza(this.zza, zzchdVarZzc, str, false, false, this.zzb, this.zzc, this.zzd, null, zzdoyVar, zzaVar, zzbccVar, zzfcaVar, zzfcdVar, zzeclVar, zzfdaVar, zzdsjVar);
    }
}
