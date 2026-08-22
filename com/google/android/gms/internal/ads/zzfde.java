package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzfde implements zzbkf {
    public final /* synthetic */ zzded zza;
    public final /* synthetic */ zzcmq zzb;
    public final /* synthetic */ zzfjy zzc;
    public final /* synthetic */ zzeca zzd;

    public /* synthetic */ zzfde(zzded zzdedVar, zzcmq zzcmqVar, zzfjy zzfjyVar, zzeca zzecaVar) {
        this.zza = zzdedVar;
        this.zzb = zzcmqVar;
        this.zzc = zzfjyVar;
        this.zzd = zzecaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        zzbke.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("URL missing from click GMSG.");
        } else {
            zzeca zzecaVar = this.zzd;
            zzfjy zzfjyVar = this.zzc;
            zzgdn.zzr(zzbke.zza(zzcfgVar, str), new zzfdg(zzcfgVar, this.zzb, zzfjyVar, zzecaVar), zzcaf.zza);
        }
    }
}
