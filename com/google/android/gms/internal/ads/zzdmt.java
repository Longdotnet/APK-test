package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdmt {
    private final Executor zza;
    private final zzcnx zzb;
    private final zzddx zzc;
    private final zzcmq zzd;

    public zzdmt(Executor executor, zzcnx zzcnxVar, zzddx zzddxVar, zzcmq zzcmqVar) {
        this.zza = executor;
        this.zzc = zzddxVar;
        this.zzb = zzcnxVar;
        this.zzd = zzcmqVar;
    }

    public final void zzc(final zzcfg zzcfgVar) {
        if (zzcfgVar == null) {
            return;
        }
        zzddx zzddxVar = this.zzc;
        zzddxVar.zza(zzcfgVar.zzF());
        zzazd zzazdVar = new zzazd() { // from class: com.google.android.gms.internal.ads.zzdmp
            @Override // com.google.android.gms.internal.ads.zzazd
            public final void zzdr(zzazc zzazcVar) {
                zzcgy zzcgyVarZzN = zzcfgVar.zzN();
                Rect rect = zzazcVar.zzd;
                zzcgyVarZzN.zzr(rect.left, rect.top, false);
            }
        };
        Executor executor = this.zza;
        zzddxVar.zzo(zzazdVar, executor);
        zzddxVar.zzo(new zzazd() { // from class: com.google.android.gms.internal.ads.zzdmq
            @Override // com.google.android.gms.internal.ads.zzazd
            public final void zzdr(zzazc zzazcVar) {
                HashMap map = new HashMap();
                map.put("isVisible", true != zzazcVar.zzj ? "0" : "1");
                zzcfgVar.zzd("onAdVisibilityChanged", map);
            }
        }, executor);
        zzcnx zzcnxVar = this.zzb;
        zzddxVar.zzo(zzcnxVar, executor);
        zzcnxVar.zzf(zzcfgVar);
        zzcgy zzcgyVarZzN = zzcfgVar.zzN();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkC)).booleanValue() && zzcgyVarZzN != null) {
            zzcmq zzcmqVar = this.zzd;
            zzcgyVarZzN.zzN(zzcmqVar);
            zzcgyVarZzN.zzO(zzcmqVar, null, null);
        }
        zzcfgVar.zzag("/trackActiveViewUnit", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdmr
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                this.zza.zzb.zzd();
            }
        });
        zzcfgVar.zzag("/untrackActiveViewUnit", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdms
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                this.zza.zzb.zzb();
            }
        });
    }
}
