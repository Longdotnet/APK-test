package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class ThemeUtils {
    public static final ThreadLocal TL_TYPED_VALUE = new ThreadLocal();
    public static final int[] DISABLED_STATE_SET = {-16842910};
    public static final int[] FOCUSED_STATE_SET = {R.attr.state_focused};
    public static final int[] PRESSED_STATE_SET = {R.attr.state_pressed};
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public static final int[] TEMP_ARRAY = new int[1];

    public static void checkAppCompatTheme(Context context, View view) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int getDisabledThemeAttrColor(Context context, int i) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(DISABLED_STATE_SET, themeAttrColorStateList.getDefaultColor());
        }
        ThreadLocal threadLocal = TL_TYPED_VALUE;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f = typedValue.getFloat();
        int themeAttrColor = getThemeAttrColor(context, i);
        int iRound = Math.round(Color.alpha(themeAttrColor) * f);
        int i2 = ColorUtils.$r8$clinit;
        if (iRound < 0 || iRound > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (themeAttrColor & 16777215) | (iRound << 24);
    }

    public static int getThemeAttrColor(Context context, int i) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int i) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = ContextCompat.getColorStateList(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
