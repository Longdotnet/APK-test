package kotlin.internal.jdk8;

import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;

/* JADX INFO: loaded from: classes3.dex */
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    public abstract class ReflectSdkVersion {
        public static final Integer sdkVersion;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
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
    public final Random defaultPlatformRandom() {
        Integer num = ReflectSdkVersion.sdkVersion;
        return (num == null || num.intValue() >= 34) ? new PlatformThreadLocalRandom() : new FallbackThreadLocalRandom();
    }
}
