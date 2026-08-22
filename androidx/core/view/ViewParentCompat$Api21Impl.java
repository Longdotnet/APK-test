package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewParentCompat$Api21Impl {
    public static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return viewParent.onNestedFling(view, f, f2, z);
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
        return viewParent.onNestedPreFling(view, f, f2);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        viewParent.onNestedPreScroll(view, i, i2, iArr);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        viewParent.onNestedScroll(view, i, i2, i3, i4);
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i) {
        viewParent.onNestedScrollAccepted(view, view2, i);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i) {
        return viewParent.onStartNestedScroll(view, view2, i);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        viewParent.onStopNestedScroll(view);
    }
}
