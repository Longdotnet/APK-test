package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdim implements zzgdj {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdio zzb;

    public zzdim(zzdio zzdioVar, String str, boolean z) {
        Objects.requireNonNull(zzdioVar);
        this.zzb = zzdioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfH)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdio zzdioVar = this.zzb;
        zzdioVar.zze.zzT((zzcfg) obj);
        zzcak zzcakVarZzp = zzdioVar.zze.zzp();
        zzedh zzedhVarZzf = zzdioVar.zzf(this.zza, true);
        if (zzedhVarZzf != null && zzcakVarZzp != null) {
            zzcakVarZzp.zzc(zzedhVarZzf);
        } else if (zzcakVarZzp != null) {
            zzcakVarZzp.cancel(false);
        }
    }
}
