package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbjw implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        if (zzcfgVar.zzJ() != null) {
            zzcfgVar.zzJ().zza();
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzcfgVar.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzb();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzM = zzcfgVar.zzM();
        if (zzmVarZzM != null) {
            zzmVarZzM.zzb();
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
