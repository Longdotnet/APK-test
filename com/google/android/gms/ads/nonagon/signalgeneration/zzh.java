package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Build;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebViewCompat;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.ApiHelperForO;
import androidx.webkit.internal.WebViewFeatureInternal;
import com.google.android.gms.ads.internal.util.zzs;
import kotlin.io.TextStreamsKt;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzh implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzj zza;

    public /* synthetic */ zzh(zzj zzjVar, int i) {
        this.$r8$classId = i;
        this.zza = zzjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebViewClient webViewClient;
        zzj zzjVar = this.zza;
        switch (this.$r8$classId) {
            case 0:
                try {
                    zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    WebView webView = zzjVar.zza;
                    if (Build.VERSION.SDK_INT < 26) {
                        if (TextStreamsKt.isFeatureSupported("GET_WEB_VIEW_CLIENT")) {
                            try {
                                int i = WebViewCompat.$r8$clinit;
                                ApiFeature.M m = WebViewFeatureInternal.GET_WEB_VIEW_CLIENT;
                                if (m.isSupportedByFramework()) {
                                    webViewClient = ApiHelperForO.getWebViewClient(webView);
                                } else {
                                    if (!m.isSupportedByWebView()) {
                                        throw WebViewFeatureInternal.getUnsupportedOperationException();
                                    }
                                    webViewClient = ((WebViewProviderBoundaryInterface) WebViewCompat.getProvider(webView).sharedPreferences).getWebViewClient();
                                }
                            } catch (RuntimeException e) {
                                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdUtil.getWebViewClient");
                            }
                        }
                        throw new IllegalStateException("getWebViewClient not supported");
                    }
                    webViewClient = webView.getWebViewClient();
                    if (webViewClient == zzjVar) {
                        return;
                    }
                    if (webViewClient != null) {
                        zzjVar.zzd = webViewClient;
                    }
                    zzjVar.zza.setWebViewClient(zzjVar);
                    zzjVar.zzc();
                    return;
                } catch (IllegalStateException unused) {
                    return;
                }
            default:
                zzjVar.zzc.execute(new zzh(zzjVar, 0));
                return;
        }
    }
}
