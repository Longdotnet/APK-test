package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextViewCompat$Api28Impl {
    public static CharSequence castToCharSequence(PrecomputedText precomputedText) {
        return precomputedText;
    }

    public static String[] getDigitStrings(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static PrecomputedText.Params getTextMetricsParams(TextView textView) {
        return textView.getTextMetricsParams();
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int i) {
        textView.setFirstBaselineToTopHeight(i);
    }
}
