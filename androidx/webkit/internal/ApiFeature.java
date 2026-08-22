package androidx.webkit.internal;

import android.os.Build;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApiFeature implements ConditionallySupportedFeature {
    public static final HashSet sValues = new HashSet();
    public final String mInternalFeatureValue;
    public final String mPublicFeatureValue;

    public abstract class LAZY_HOLDER {
        public static final HashSet WEBVIEW_APK_FEATURES = new HashSet(Arrays.asList(WebViewGlueCommunicator$LAZY_FACTORY_HOLDER.INSTANCE.getWebViewFeatures()));
    }

    public class M extends ApiFeature {
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ M(int i, String str, String str2) {
            super(str, str2);
            this.$r8$classId = i;
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            switch (this.$r8$classId) {
                case 0:
                    return true;
                case 1:
                    return Build.VERSION.SDK_INT >= 24;
                case 2:
                    return false;
                case 3:
                    return Build.VERSION.SDK_INT >= 26;
                case 4:
                    return Build.VERSION.SDK_INT >= 27;
                case 5:
                    return Build.VERSION.SDK_INT >= 28;
                default:
                    return Build.VERSION.SDK_INT >= 29;
            }
        }
    }

    public ApiFeature(String str, String str2) {
        this.mPublicFeatureValue = str;
        this.mInternalFeatureValue = str2;
        sValues.add(this);
    }

    public abstract boolean isSupportedByFramework();

    public boolean isSupportedByWebView() {
        HashSet hashSet = LAZY_HOLDER.WEBVIEW_APK_FEATURES;
        String str = this.mInternalFeatureValue;
        if (!hashSet.contains(str)) {
            String str2 = Build.TYPE;
            if ((!"eng".equals(str2) && !"userdebug".equals(str2)) || !hashSet.contains(str.concat(":dev"))) {
                return false;
            }
        }
        return true;
    }
}
