package androidx.webkit.internal;

import android.os.Looper;
import android.webkit.TracingController;
import android.webkit.WebView;
import androidx.activity.EdgeToEdgeApi28$$ExternalSyntheticApiModelOutline0;
import androidx.webkit.TracingConfig;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApiHelperForP {
    public static TracingController getTracingControllerInstance() {
        return TracingController.getInstance();
    }

    public static ClassLoader getWebViewClassLoader() {
        return WebView.getWebViewClassLoader();
    }

    public static Looper getWebViewLooper(WebView webView) {
        return webView.getWebViewLooper();
    }

    public static boolean isTracing(TracingController tracingController) {
        return tracingController.isTracing();
    }

    public static void setDataDirectorySuffix(String str) {
        WebView.setDataDirectorySuffix(str);
    }

    public static void start(TracingController tracingController, TracingConfig tracingConfig) {
        EdgeToEdgeApi28$$ExternalSyntheticApiModelOutline0.m10m();
        throw null;
    }

    public static boolean stop(TracingController tracingController, OutputStream outputStream, Executor executor) {
        return tracingController.stop(outputStream, executor);
    }
}
