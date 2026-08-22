package com.google.android.gms.ads.nonagon.signalgeneration;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbla;
import com.google.android.gms.internal.ads.zzgdy;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzj extends zzbla {
    public final WebView zza;
    public final zzf zzb;
    public final zzgdy zzc;
    public WebViewClient zzd;

    public zzj(WebView webView, zzf zzfVar, zzgdy zzgdyVar) {
        this.zza = webView;
        this.zzb = zzfVar;
        this.zzc = zzgdyVar;
    }

    public static boolean zzd() {
        if (!((Boolean) zzbfj.zza.zze()).booleanValue()) {
            return false;
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null || !allStackTraces.containsKey(Thread.currentThread())) {
            return true;
        }
        boolean z = false;
        boolean z2 = false;
        for (StackTraceElement stackTraceElement : allStackTraces.get(Thread.currentThread())) {
            if (stackTraceElement.getClassName().contains(zzj.class.getName())) {
                if (z && z2) {
                    return true;
                }
                z = true;
            } else if (z) {
                z2 = true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (zzd()) {
            return;
        }
        super.doUpdateVisitedHistory(webView, str, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbla
    public final WebViewClient getDelegate() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        if (zzd()) {
            return;
        }
        super.onFormResubmission(webView, message, message2);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        if (zzd()) {
            return;
        }
        super.onLoadResource(webView, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        if (zzd()) {
            return;
        }
        super.onPageCommitVisible(webView, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        if (zzd()) {
            return;
        }
        zzc();
        super.onPageFinished(webView, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (zzd()) {
            return;
        }
        zzc();
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        if (zzd()) {
            return;
        }
        super.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (zzd()) {
            return;
        }
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (zzd()) {
            return;
        }
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (zzd()) {
            return;
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (zzd()) {
            return;
        }
        super.onReceivedLoginRequest(webView, str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (zzd()) {
            return;
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (zzd()) {
            return false;
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        if (zzd()) {
            return;
        }
        super.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onScaleChanged(WebView webView, float f, float f2) {
        if (zzd()) {
            return;
        }
        super.onScaleChanged(webView, f, f2);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        if (zzd()) {
            return;
        }
        super.onTooManyRedirects(webView, message, message2);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (zzd()) {
            return;
        }
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (zzd()) {
            return null;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (zzd()) {
            return false;
        }
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (zzd()) {
            return false;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public final void zzc() {
        this.zza.evaluateJavascript(String.format(Locale.getDefault(), (String) zzbd.zza.zzd.zzb(zzbde.zzkj), this.zzb.zza()), null);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (zzd()) {
            return;
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (zzd()) {
            return null;
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbla, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (zzd()) {
            return false;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
