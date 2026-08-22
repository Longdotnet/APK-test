package androidx.webkit;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator$LAZY_FACTORY_HOLDER;
import com.facebook.AccessTokenCache;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class WebViewCompat {
    public static final /* synthetic */ int $r8$clinit = 0;

    public interface WebMessageListener {
        void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy);
    }

    static {
        Uri.parse("*");
        Uri.parse("");
    }

    public static PackageInfo getLoadedWebViewPackageInfo() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    public static AccessTokenCache getProvider(WebView webView) {
        WebViewProviderBoundaryInterface webViewProviderBoundaryInterfaceCreateWebView = WebViewGlueCommunicator$LAZY_FACTORY_HOLDER.INSTANCE.createWebView(webView);
        AccessTokenCache accessTokenCache = new AccessTokenCache(10, false);
        accessTokenCache.sharedPreferences = webViewProviderBoundaryInterfaceCreateWebView;
        return accessTokenCache;
    }

    public static String getVariationsHeader() {
        if (WebViewFeatureInternal.GET_VARIATIONS_HEADER.isSupportedByWebView()) {
            return WebViewGlueCommunicator$LAZY_FACTORY_HOLDER.INSTANCE.getStatics().getVariationsHeader();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
