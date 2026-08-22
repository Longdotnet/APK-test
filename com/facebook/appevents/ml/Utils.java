package com.facebook.appevents.ml;

import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    public static final int access$getCapacity(int[] iArr) {
        if (iArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int i = iArr[0];
        int i2 = 1;
        int length = iArr.length - 1;
        if (1 <= length) {
            while (true) {
                i *= iArr[i2];
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    public static final File getMlDir() {
        if (CrashShieldHandler.isObjectCrashing(Utils.class)) {
            return null;
        }
        try {
            File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), "facebook_ml/");
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(Utils.class, th);
            return null;
        }
    }

    public String normalizeString(String str) {
        List listListOf;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "str");
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare(str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String input = str.subSequence(i, length + 1).toString();
            Pattern patternCompile = Pattern.compile("\\s+");
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
            Intrinsics.checkNotNullParameter(input, "input");
            StringsKt__StringsKt.requireNonNegativeLimit(0);
            Matcher matcher = patternCompile.matcher(input);
            if (matcher.find()) {
                ArrayList arrayList = new ArrayList(10);
                int iEnd = 0;
                do {
                    arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
                    iEnd = matcher.end();
                } while (matcher.find());
                arrayList.add(input.subSequence(iEnd, input.length()).toString());
                listListOf = arrayList;
            } else {
                listListOf = Okio.listOf(input.toString());
            }
            Object[] array = listListOf.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String strJoin = TextUtils.join(" ", (String[]) array);
            Intrinsics.checkNotNullExpressionValue(strJoin, "join(\" \", strArray)");
            return strJoin;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public int[] vectorize(String texts) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(texts, "texts");
            int[] iArr = new int[128];
            String strNormalizeString = normalizeString(texts);
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-8\")");
            if (strNormalizeString == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = strNormalizeString.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i < bytes.length) {
                    iArr[i] = bytes[i] & 255;
                } else {
                    iArr[i] = 0;
                }
                if (i2 >= 128) {
                    return iArr;
                }
                i = i2;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }
}
