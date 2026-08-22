package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
public abstract class CompoundButtonCompat$Api21Impl {
    public static ColorStateList getButtonTintList(CompoundButton compoundButton) {
        return compoundButton.getButtonTintList();
    }

    public static PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
        return compoundButton.getButtonTintMode();
    }

    public static void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
        compoundButton.setButtonTintList(colorStateList);
    }

    public static void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
        compoundButton.setButtonTintMode(mode);
    }
}
