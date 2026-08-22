package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class BuildCompat {

    public final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        public final int getExtensionVersion(int i) {
            return SdkExtensions.getExtensionVersion(i);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        Api30Impl api30Impl = Api30Impl.INSTANCE;
        if (i >= 30) {
            api30Impl.getExtensionVersion(30);
        }
        if (i >= 30) {
            api30Impl.getExtensionVersion(31);
        }
        if (i >= 30) {
            api30Impl.getExtensionVersion(33);
        }
        if (i >= 30) {
            api30Impl.getExtensionVersion(1000000);
        }
    }

    public static final boolean isAtLeastS() {
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            if (i >= 30) {
                String CODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
                if (!"REL".equals(CODENAME)) {
                    Locale locale = Locale.ROOT;
                    String upperCase = CODENAME.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    String upperCase2 = "S".toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    if (upperCase.compareTo(upperCase2) >= 0) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}
