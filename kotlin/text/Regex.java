package kotlin.text;

import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.io.Serializable;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Regex implements Serializable {
    public final Pattern nativePattern;

    public final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;
        public final int flags;
        public final String pattern;

        public Serialized(String str, int i) {
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern, flags)");
            return new Regex(patternCompile);
        }
    }

    public Regex(Pattern pattern) {
        this.nativePattern = pattern;
    }

    private final Object writeReplace() {
        Pattern pattern = this.nativePattern;
        String strPattern = pattern.pattern();
        Intrinsics.checkNotNullExpressionValue(strPattern, "nativePattern.pattern()");
        return new Serialized(strPattern, pattern.flags());
    }

    public final String toString() {
        String string = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(string, wsbWxekY.oehkmllAAwxVpQ);
        return string;
    }

    public Regex(String str) {
        Pattern patternCompile = Pattern.compile(str);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
        this.nativePattern = patternCompile;
    }
}
