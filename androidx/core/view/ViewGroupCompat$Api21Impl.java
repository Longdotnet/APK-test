package androidx.core.view;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewGroupCompat$Api21Impl {
    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        viewGroup.setTransitionGroup(z);
    }
}
