package androidx.webkit.internal;

import androidx.fragment.app.Fragment;
import androidx.work.WorkContinuation;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.JvmClassMappingKt;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class WebViewGlueCommunicator$LAZY_FACTORY_HOLDER {
    public static final WebViewProviderFactory INSTANCE;

    static {
        WebViewProviderFactory incompatibleApkWebViewProviderFactory;
        try {
            incompatibleApkWebViewProviderFactory = new Fragment.AnonymousClass7((WebViewProviderFactoryBoundaryInterface) WorkContinuation.castToSuppLibClass(WebViewProviderFactoryBoundaryInterface.class, JvmClassMappingKt.fetchGlueProviderFactoryImpl()), 13);
        } catch (ClassNotFoundException unused) {
            incompatibleApkWebViewProviderFactory = new IncompatibleApkWebViewProviderFactory();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
        INSTANCE = incompatibleApkWebViewProviderFactory;
    }
}
