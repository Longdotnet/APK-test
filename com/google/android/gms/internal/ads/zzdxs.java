package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes.dex */
final class zzdxs implements zzgdj {
    final /* synthetic */ zzdxt zza;

    public zzdxs(zzdxt zzdxtVar) {
        Objects.requireNonNull(zzdxtVar);
        this.zza = zzdxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgv)).booleanValue()) {
            Matcher matcher = zzdxt.zza.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzi(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        zzfcn zzfcnVar = (zzfcn) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgv)).booleanValue()) {
            zzdxt zzdxtVar = this.zza;
            zzeaw zzeawVar = zzdxtVar.zzf;
            zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
            zzeawVar.zzi(zzfcdVar.zzf);
            zzdxtVar.zzf.zzj(zzfcdVar.zzg);
        }
    }
}
