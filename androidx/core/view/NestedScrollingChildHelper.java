package androidx.core.view;

import android.util.Log;
import android.view.ViewParent;
import androidx.core.widget.NestedScrollView;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;

/* JADX INFO: loaded from: classes2.dex */
public final class NestedScrollingChildHelper {
    public boolean mIsNestedScrollingEnabled;
    public ViewParent mNestedScrollingParentNonTouch;
    public ViewParent mNestedScrollingParentTouch;
    public int[] mTempNestedScrollConsumed;
    public final NestedScrollView mView;

    public NestedScrollingChildHelper(NestedScrollView nestedScrollView) {
        this.mView = nestedScrollView;
    }

    public final boolean dispatchNestedScrollInternal(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent nestedScrollingParentForType;
        int i6;
        int i7;
        int[] iArr3;
        if (!this.mIsNestedScrollingEnabled || (nestedScrollingParentForType = getNestedScrollingParentForType(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        NestedScrollView nestedScrollView = this.mView;
        if (iArr != null) {
            nestedScrollView.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            if (this.mTempNestedScrollConsumed == null) {
                this.mTempNestedScrollConsumed = new int[2];
            }
            int[] iArr4 = this.mTempNestedScrollConsumed;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        if (nestedScrollingParentForType instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) nestedScrollingParentForType).onNestedScroll(nestedScrollView, i, i2, i3, i4, i5, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i3;
            iArr3[1] = iArr3[1] + i4;
            if (nestedScrollingParentForType instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) nestedScrollingParentForType).onNestedScroll(nestedScrollView, i, i2, i3, i4, i5);
            } else if (i5 == 0) {
                try {
                    ViewParentCompat$Api21Impl.onNestedScroll(nestedScrollingParentForType, nestedScrollView, i, i2, i3, i4);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedScroll", e);
                }
            }
        }
        if (iArr != null) {
            nestedScrollView.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public final ViewParent getNestedScrollingParentForType(int i) {
        if (i == 0) {
            return this.mNestedScrollingParentTouch;
        }
        if (i != 1) {
            return null;
        }
        return this.mNestedScrollingParentNonTouch;
    }

    public final boolean dispatchNestedPreFling(float f, float f2) {
        ViewParent nestedScrollingParentForType;
        if (!this.mIsNestedScrollingEnabled || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        try {
            return ViewParentCompat$Api21Impl.onNestedPreFling(nestedScrollingParentForType, this.mView, f, f2);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", DaWYVMJ.SiYpmwGmgAZHzlh + nestedScrollingParentForType + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }
}
