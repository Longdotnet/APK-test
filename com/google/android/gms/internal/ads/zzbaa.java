package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbaa implements Runnable {
    final ValueCallback zza;
    final /* synthetic */ zzazs zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzbac zze;

    public zzbaa(zzbac zzbacVar, final zzazs zzazsVar, final WebView webView, final boolean z) {
        this.zzb = zzazsVar;
        this.zzc = webView;
        this.zzd = z;
        Objects.requireNonNull(zzbacVar);
        this.zze = zzbacVar;
        this.zza = new ValueCallback() { // from class: com.google.android.gms.internal.ads.zzazz
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                this.zza.zze.zzc(zzazsVar, webView, (String) obj, z);
            }
        };
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView = this.zzc;
        if (webView.getSettings().getJavaScriptEnabled()) {
            try {
                webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
