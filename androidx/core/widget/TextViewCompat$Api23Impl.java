package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextViewCompat$Api23Impl {
    public static int getBreakStrategy(TextView textView) {
        return textView.getBreakStrategy();
    }

    public static ColorStateList getCompoundDrawableTintList(TextView textView) {
        return textView.getCompoundDrawableTintList();
    }

    public static PorterDuff.Mode getCompoundDrawableTintMode(TextView textView) {
        return textView.getCompoundDrawableTintMode();
    }

    public static int getHyphenationFrequency(TextView textView) {
        return textView.getHyphenationFrequency();
    }

    public static void setBreakStrategy(TextView textView, int i) {
        textView.setBreakStrategy(i);
    }

    public static void setCompoundDrawableTintList(TextView textView, ColorStateList colorStateList) {
        textView.setCompoundDrawableTintList(colorStateList);
    }

    public static void setCompoundDrawableTintMode(TextView textView, PorterDuff.Mode mode) {
        textView.setCompoundDrawableTintMode(mode);
    }

    public static void setHyphenationFrequency(TextView textView, int i) {
        textView.setHyphenationFrequency(i);
    }
}
