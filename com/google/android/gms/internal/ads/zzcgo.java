package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.loader.app.gv.DYYbQc;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class zzcgo extends zzcfo {
    public zzcgo(zzcfg zzcfgVar, zzbcc zzbccVar, boolean z, zzecl zzeclVar) {
        super(zzcfgVar, zzbccVar, z, new zzbst(zzcfgVar, zzcfgVar.zzE(), new zzbcm(zzcfgVar.getContext())), null, zzeclVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebResourceResponse zzY(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcfg)) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcfg zzcfgVar = (zzcfg) webView;
        zzbya zzbyaVar = this.zza;
        if (zzbyaVar != null) {
            zzbyaVar.zze(str, map, 1);
        }
        zzfqs.zza();
        zzfqy zzfqyVar = zzfqy.zza;
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return zzc(str, map);
        }
        if (zzcfgVar.zzN() != null) {
            zzcfgVar.zzN().zzI();
        }
        if (zzcfgVar.zzO().zzi()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzaf);
        } else if (zzcfgVar.zzaF()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzae);
        } else {
            str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzad);
        }
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        Context context = zzcfgVar.getContext();
        String str3 = zzcfgVar.zzm().afmaVersion;
        try {
            HashMap map2 = new HashMap();
            map2.put("User-Agent", zzvVar.zzd.zzc(context, str3));
            map2.put("Cache-Control", DYYbQc.OzdxWsIcKnf);
            String str4 = (String) new com.google.android.gms.ads.internal.util.zzbo(context).zzb(0, str2, map2, null).get(60L, TimeUnit.SECONDS);
            if (str4 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str4.getBytes("UTF-8")));
            }
            return null;
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not fetch MRAID JS.", e);
            return null;
        }
    }
}
