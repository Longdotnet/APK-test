package androidx.core.view;

import android.view.View;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent2 {
    void onNestedPreScroll(int[] iArr, int i, int i2, int i3);

    void onNestedScroll(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4, int i5);

    void onNestedScrollAccepted(View view, View view2, int i, int i2);

    boolean onStartNestedScroll(View view, View view2, int i, int i2);

    void onStopNestedScroll(View view, int i);
}
