package kotlin.internal.jdk7;

import androidx.core.text.jp.CyjpdoedCdLTIO;
import java.lang.reflect.InvocationTargetException;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class JDK7PlatformImplementations extends PlatformImplementations {

    public abstract class ReflectSdkVersion {
        public static final Integer sdkVersion;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField(CyjpdoedCdLTIO.JswvsEfqAIcK).get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            sdkVersion = num2;
        }
    }

    @Override // kotlin.internal.PlatformImplementations
    public final void addSuppressed(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Integer num = ReflectSdkVersion.sdkVersion;
        if (num == null || num.intValue() >= 19) {
            cause.addSuppressed(exception);
        } else {
            super.addSuppressed(cause, exception);
        }
    }
}
