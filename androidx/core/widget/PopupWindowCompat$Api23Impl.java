package androidx.core.widget;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public abstract class PopupWindowCompat$Api23Impl {
    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    public static int getWindowLayoutType(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        popupWindow.setOverlapAnchor(z);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        popupWindow.setWindowLayoutType(i);
    }
}
