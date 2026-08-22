package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfnc extends zzfmy {
    private WebView zza;
    private Long zzb;
    private final Map zzc;

    public zzfnc(String str, Map map, String str2) {
        super(str);
        this.zzb = null;
        this.zzc = map;
    }

    @Override // com.google.android.gms.internal.ads.zzfmy
    public final void zzc() {
        super.zzc();
        new Handler().postDelayed(new zzfnb(this), Math.max(4000 - (this.zzb == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfmy
    public final void zzi(zzflp zzflpVar, zzfln zzflnVar) {
        JSONObject jSONObject = new JSONObject();
        Map mapZzi = zzflnVar.zzi();
        Iterator it = mapZzi.keySet().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzj(zzflpVar, zzflnVar, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzfmy
    public final void zzo() {
        WebView webView = new WebView(zzfmn.zzb().zza());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.zza.getSettings().setAllowContentAccess(false);
        this.zza.getSettings().setAllowFileAccess(false);
        this.zza.setWebViewClient(new zzfna(this));
        zzn(this.zza);
        zzfmp.zzk(this.zza, null);
        Map map = this.zzc;
        Iterator it = map.keySet().iterator();
        if (it.hasNext()) {
            throw null;
        }
        this.zzb = Long.valueOf(System.nanoTime());
    }
}
