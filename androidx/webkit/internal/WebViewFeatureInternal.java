package androidx.webkit.internal;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.loader.app.gv.DYYbQc;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import androidx.webkit.WebViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.io.TextStreamsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WebViewFeatureInternal {
    public static final ApiFeature.M DOCUMENT_START_SCRIPT;
    public static final ApiFeature.M GET_VARIATIONS_HEADER;
    public static final ApiFeature.M GET_WEB_VIEW_CLIENT;
    public static final ApiFeature.M MULTI_PROCESS;
    public static final ApiFeature.M MUTE_AUDIO;
    public static final ApiFeature.M WEB_MESSAGE_ARRAY_BUFFER;
    public static final ApiFeature.M WEB_MESSAGE_LISTENER;

    /* JADX INFO: renamed from: androidx.webkit.internal.WebViewFeatureInternal$1 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass1 extends ApiFeature {
        public final Pattern mVersionPattern = Pattern.compile("\\A\\d+");

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 33;
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByWebView() {
            int i;
            PackageInfo loadedWebViewPackageInfo;
            boolean zIsSupportedByWebView = super.isSupportedByWebView();
            if (!zIsSupportedByWebView || (i = Build.VERSION.SDK_INT) >= 29) {
                return zIsSupportedByWebView;
            }
            int i2 = WebViewCompat.$r8$clinit;
            if (i >= 26) {
                loadedWebViewPackageInfo = ApiHelperForO.getCurrentWebViewPackage();
            } else {
                try {
                    loadedWebViewPackageInfo = WebViewCompat.getLoadedWebViewPackageInfo();
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    loadedWebViewPackageInfo = null;
                }
            }
            if (loadedWebViewPackageInfo == null) {
                return false;
            }
            Matcher matcher = this.mVersionPattern.matcher(loadedWebViewPackageInfo.versionName);
            return matcher.find() && Integer.parseInt(loadedWebViewPackageInfo.versionName.substring(matcher.start(), matcher.end())) >= 105;
        }
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.WebViewFeatureInternal$2 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass2 extends ApiFeature.M {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByWebView() {
            if (!super.isSupportedByWebView() || !TextStreamsKt.isFeatureSupported("MULTI_PROCESS")) {
                return false;
            }
            int i = WebViewCompat.$r8$clinit;
            if (WebViewFeatureInternal.MULTI_PROCESS.isSupportedByWebView()) {
                return WebViewGlueCommunicator$LAZY_FACTORY_HOLDER.INSTANCE.getStatics().isMultiProcessEnabled();
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static UnsupportedOperationException getUnsupportedOperationException() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    static {
        new ApiFeature.M(0, "VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");
        new ApiFeature.M(0, "OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");
        new ApiFeature.M(3, "SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");
        new ApiFeature.M(1, "DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");
        new ApiFeature.M(4, "START_SAFE_BROWSING", "START_SAFE_BROWSING");
        new ApiFeature.M(4, "SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");
        new ApiFeature.M(4, "SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");
        new ApiFeature.M(4, "SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");
        new ApiFeature.M(4, "SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");
        new ApiFeature.M(4, "SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");
        new ApiFeature.M(1, "SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");
        new ApiFeature.M(1, "SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");
        new ApiFeature.M(1, "SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");
        new ApiFeature.M(1, "SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");
        new ApiFeature.M(1, "SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");
        new ApiFeature.M(1, "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");
        new ApiFeature.M(0, "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");
        new ApiFeature.M(0, "RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");
        new ApiFeature.M(1, "SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");
        new ApiFeature.M(4, "SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");
        String str = DYYbQc.jmMEdChowsKPf;
        new ApiFeature.M(1, str, str);
        new ApiFeature.M(0, "WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");
        new ApiFeature.M(0, "WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");
        new ApiFeature.M(4, "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");
        new ApiFeature.M(4, "SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");
        new ApiFeature.M(4, "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
        new ApiFeature.M(0, "WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
        new ApiFeature.M(0, "WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
        WEB_MESSAGE_ARRAY_BUFFER = new ApiFeature.M(2, "WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");
        new ApiFeature.M(0, "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
        new ApiFeature.M(0, "CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
        new ApiFeature.M(0, "POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
        new ApiFeature.M(0, "WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
        GET_WEB_VIEW_CLIENT = new ApiFeature.M(3, "GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
        new ApiFeature.M(3, "GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
        new ApiFeature.M(6, "GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
        new ApiFeature.M(6, "WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
        new ApiFeature.M(5, "TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
        new Object() { // from class: androidx.webkit.internal.StartupApiFeature$P
            public static final HashSet sValues = new HashSet();

            {
                sValues.add(this);
            }
        };
        new Object() { // from class: androidx.webkit.internal.StartupApiFeature$P
            public static final HashSet sValues = new HashSet();

            {
                sValues.add(this);
            }
        };
        new ApiFeature.M(6, "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
        new ApiFeature() { // from class: androidx.webkit.internal.WebViewFeatureInternal.1
            public final Pattern mVersionPattern = Pattern.compile("\\A\\d+");

            @Override // androidx.webkit.internal.ApiFeature
            public final boolean isSupportedByFramework() {
                return Build.VERSION.SDK_INT >= 33;
            }

            @Override // androidx.webkit.internal.ApiFeature
            public final boolean isSupportedByWebView() {
                int i;
                PackageInfo loadedWebViewPackageInfo;
                boolean zIsSupportedByWebView = super.isSupportedByWebView();
                if (!zIsSupportedByWebView || (i = Build.VERSION.SDK_INT) >= 29) {
                    return zIsSupportedByWebView;
                }
                int i2 = WebViewCompat.$r8$clinit;
                if (i >= 26) {
                    loadedWebViewPackageInfo = ApiHelperForO.getCurrentWebViewPackage();
                } else {
                    try {
                        loadedWebViewPackageInfo = WebViewCompat.getLoadedWebViewPackageInfo();
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                        loadedWebViewPackageInfo = null;
                    }
                }
                if (loadedWebViewPackageInfo == null) {
                    return false;
                }
                Matcher matcher = this.mVersionPattern.matcher(loadedWebViewPackageInfo.versionName);
                return matcher.find() && Integer.parseInt(loadedWebViewPackageInfo.versionName.substring(matcher.start(), matcher.end())) >= 105;
            }
        };
        new ApiFeature.M(2, "PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
        MULTI_PROCESS = new ApiFeature.M(2, "MULTI_PROCESS", "MULTI_PROCESS_QUERY");
        new ApiFeature.M(6, "FORCE_DARK", "FORCE_DARK");
        new ApiFeature.M(2, "FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
        WEB_MESSAGE_LISTENER = new ApiFeature.M(2, "WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
        DOCUMENT_START_SCRIPT = new ApiFeature.M(2, "DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
        new ApiFeature.M(2, "PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
        GET_VARIATIONS_HEADER = new ApiFeature.M(2, "GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
        new ApiFeature.M(2, "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");
        new ApiFeature.M(2, "GET_COOKIE_INFO", "GET_COOKIE_INFO");
        new ApiFeature.M(2, "REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");
        new ApiFeature.M(2, "USER_AGENT_METADATA", "USER_AGENT_METADATA");
        new AnonymousClass2(2, "MULTI_PROFILE", "MULTI_PROFILE");
        new ApiFeature.M(2, "ATTRIBUTION_REGISTRATION_BEHAVIOR", YcVWhnLsj.FwyEreuaUUz);
        new ApiFeature.M(2, "WEBVIEW_MEDIA_INTEGRITY_API_STATUS", "WEBVIEW_INTEGRITY_API_STATUS");
        MUTE_AUDIO = new ApiFeature.M(2, "MUTE_AUDIO", "MUTE_AUDIO");
    }
}
