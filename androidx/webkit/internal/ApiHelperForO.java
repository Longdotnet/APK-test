package androidx.webkit.internal;

import android.content.pm.PackageInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApiHelperForO {
    public static PackageInfo getCurrentWebViewPackage() {
        return WebView.getCurrentWebViewPackage();
    }

    public static boolean getSafeBrowsingEnabled(WebSettings webSettings) {
        return webSettings.getSafeBrowsingEnabled();
    }

    public static WebChromeClient getWebChromeClient(WebView webView) {
        return webView.getWebChromeClient();
    }

    public static WebViewClient getWebViewClient(WebView webView) {
        return webView.getWebViewClient();
    }

    public static void setSafeBrowsingEnabled(WebSettings webSettings, boolean z) {
        webSettings.setSafeBrowsingEnabled(z);
    }
}
