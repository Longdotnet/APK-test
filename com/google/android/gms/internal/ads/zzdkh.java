package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdkh {
    private final zzdpj zza;
    private final zzdny zzb;
    private final zzcnx zzc;
    private final zzdjb zzd;

    public zzdkh(zzdpj zzdpjVar, zzdny zzdnyVar, zzcnx zzcnxVar, zzdjb zzdjbVar) {
        this.zza = zzdpjVar;
        this.zzb = zzdnyVar;
        this.zzc = zzcnxVar;
        this.zzd = zzdjbVar;
    }

    public static /* synthetic */ void zzb(zzdkh zzdkhVar, zzcfg zzcfgVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Hiding native ads overlay.");
        zzcfgVar.zzF().setVisibility(8);
        zzdkhVar.zzc.zze(false);
    }

    public static /* synthetic */ void zzd(zzdkh zzdkhVar, zzcfg zzcfgVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Showing native ads overlay.");
        zzcfgVar.zzF().setVisibility(0);
        zzdkhVar.zzc.zze(true);
    }

    public static /* synthetic */ void zze(zzdkh zzdkhVar, Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "htmlLoaded");
        map2.put("id", (String) map.get("id"));
        zzdkhVar.zzb.zzj("sendMessageToNativeJs", map2);
    }

    public final View zza() {
        zzcfg zzcfgVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzr.zzc(), null, null);
        zzcfgVarZza.zzF().setVisibility(8);
        zzcfgVarZza.zzag("/sendMessageToSdk", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkb
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                this.zza.zzb.zzj("sendMessageToNativeJs", map);
            }
        });
        zzcfgVarZza.zzag("/adMuted", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkc
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                this.zza.zzd.zzi();
            }
        });
        WeakReference weakReference = new WeakReference(zzcfgVarZza);
        zzbkf zzbkfVar = new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkd
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, final Map map) {
                zzcfg zzcfgVar = (zzcfg) obj;
                zzcgy zzcgyVarZzN = zzcfgVar.zzN();
                final zzdkh zzdkhVar = this.zza;
                zzcgyVarZzN.zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdkg
                    @Override // com.google.android.gms.internal.ads.zzcgw
                    public final void zza(boolean z, int i, String str, String str2) {
                        zzdkh.zze(zzdkhVar, map, z, i, str, str2);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzcfgVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzcfgVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        };
        zzdny zzdnyVar = this.zzb;
        zzdnyVar.zzm(weakReference, "/loadHtml", zzbkfVar);
        zzdnyVar.zzm(new WeakReference(zzcfgVarZza), "/showOverlay", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdke
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkh.zzd(this.zza, (zzcfg) obj, map);
            }
        });
        zzdnyVar.zzm(new WeakReference(zzcfgVarZza), "/hideOverlay", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdkf
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdkh.zzb(this.zza, (zzcfg) obj, map);
            }
        });
        return zzcfgVarZza.zzF();
    }
}
