package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzezu implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzezu(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
    }

    public static zzezu zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzezu(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza */
    public final zzezr zzb() {
        zzbzm zzbzmVarZzg;
        Context context = (Context) this.zza.zzb();
        zzfef zzfefVar = (zzfef) this.zzb.zzb();
        zzfex zzfexVar = (zzfex) this.zzc.zzb();
        zzbcv zzbcvVar = zzbde.zzgA;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzbzmVarZzg = ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzg();
        } else {
            com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi();
            synchronized (zzjVar.zza) {
                zzbzmVarZzg = zzjVar.zzn;
            }
        }
        boolean z = false;
        if (zzbzmVarZzg != null && zzbzmVarZzg.zzh()) {
            z = true;
        }
        if (((Integer) zzbdVar.zzd.zzb(zzbde.zzgC)).intValue() > 0) {
            if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzgz)).booleanValue() || z) {
                zzfew zzfewVarZza = zzfexVar.zza(zzfen.Rewarded, context, zzfefVar, new zzeyv(new zzeys()));
                zzezh zzezhVar = new zzezh(new zzezg());
                zzfej zzfejVar = zzfewVarZza.zza;
                zzgdy zzgdyVar = zzcaf.zza;
                return new zzeyx(zzezhVar, new zzezd(zzfejVar, zzgdyVar), zzfewVarZza.zzb, zzfejVar.zza().zzf, zzgdyVar);
            }
        }
        return new zzezg();
    }
}
