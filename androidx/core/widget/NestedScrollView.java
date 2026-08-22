package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.VelocityTrackerFallback;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.ViewParentCompat$Api21Impl;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentState;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.zxing.qrcode.decoder.Version;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlin.jvm.JvmClassMappingKt;

/* JADX INFO: loaded from: classes2.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild {
    public int mActivePointerId;
    public final NestedScrollingChildHelper mChildHelper;
    public View mChildToScrollTo;
    public final DifferentialMotionFlingController mDifferentialMotionFlingController;
    public final EdgeEffect mEdgeGlowBottom;
    public final EdgeEffect mEdgeGlowTop;
    public boolean mFillViewport;
    public boolean mIsBeingDragged;
    public boolean mIsLaidOut;
    public boolean mIsLayoutDirty;
    public int mLastMotionY;
    public long mLastScroll;
    public int mLastScrollerY;
    public final int mMaximumVelocity;
    public final int mMinimumVelocity;
    public int mNestedYOffset;
    public final Version.ECB mParentHelper;
    public final float mPhysicalCoeff;
    public SavedState mSavedState;
    public final int[] mScrollConsumed;
    public final int[] mScrollOffset;
    public final OverScroller mScroller;
    public boolean mSmoothScrollingEnabled;
    public final Rect mTempRect;
    public final int mTouchSlop;
    public VelocityTracker mVelocityTracker;
    public float mVerticalScrollFactor;
    public static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    public static final int[] SCROLLVIEW_STYLEABLE = {R.attr.fillViewport};

    /* JADX INFO: loaded from: classes.dex */
    public final class AccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            View.AccessibilityDelegate accessibilityDelegate = this.mOriginalDelegate;
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfo.setClassName(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfo.setScrollable(true);
            if (nestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.mAction);
                accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP.mAction);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.mAction);
                accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN.mAction);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollBy(0 - nestedScrollView.getScrollX(), iMax - nestedScrollView.getScrollY(), true);
                    return true;
                }
                if (i != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.smoothScrollBy(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
            return true;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public abstract class Api21Impl {
        public static boolean getClipToPadding(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface OnScrollChangeListener {
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new FragmentState.AnonymousClass1(14);
        public int scrollPosition;

        public final String toString() {
            StringBuilder sb = new StringBuilder("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.scrollPosition, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.scrollPosition);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.daerisoft.thespikerm.R.attr.nestedScrollViewStyle);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(getContext(), new Fragment.AnonymousClass7(this, 9));
        int i = Build.VERSION.SDK_INT;
        this.mEdgeGlowTop = i >= 31 ? EdgeEffectCompat$Api31Impl.create(context, attributeSet) : new EdgeEffect(context);
        this.mEdgeGlowBottom = i >= 31 ? EdgeEffectCompat$Api31Impl.create(context, attributeSet) : new EdgeEffect(context);
        this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, com.daerisoft.thespikerm.R.attr.nestedScrollViewStyle, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.mParentHelper = new Version.ECB();
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    public static boolean isViewDescendantOf(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewDescendantOf((View) parent, nestedScrollView);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public final boolean arrowScroll(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !isWithinDeltaOfScreen(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            scrollBy(true, maxScrollAmount, 0, 1);
        } else {
            Rect rect = this.mTempRect;
            viewFindNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, rect);
            scrollBy(true, computeScrollDeltaToGetChildRectOnScreen(rect), 0, 1);
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && !isWithinDeltaOfScreen(viewFindFocus, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007f  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e5  */
    @Override // android.view.View
    public final void computeScroll() {
        int iRound;
        int[] iArr;
        int i;
        int scrollRange;
        int overScrollMode;
        if (this.mScroller.isFinished()) {
            return;
        }
        this.mScroller.computeScrollOffset();
        int currY = this.mScroller.getCurrY();
        int i2 = currY - this.mLastScrollerY;
        int height = getHeight();
        EdgeEffect edgeEffect = this.mEdgeGlowBottom;
        EdgeEffect edgeEffect2 = this.mEdgeGlowTop;
        if (i2 <= 0 || JvmClassMappingKt.getDistance(edgeEffect2) == 0.0f) {
            if (i2 < 0 && JvmClassMappingKt.getDistance(edgeEffect) != 0.0f) {
                float f = height;
                iRound = Math.round(JvmClassMappingKt.onPullDistance(edgeEffect, (i2 * 4.0f) / f, 0.5f) * (f / 4.0f));
                if (iRound != i2) {
                    edgeEffect.finish();
                }
            }
            this.mLastScrollerY = currY;
            iArr = this.mScrollConsumed;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, i2, 1, iArr, null);
            i = i2 - iArr[1];
            scrollRange = getScrollRange();
            if (i != 0) {
                int scrollY = getScrollY();
                overScrollByCompat(i, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i3 = i - scrollY2;
                iArr[1] = 0;
                this.mChildHelper.dispatchNestedScrollInternal(0, scrollY2, 0, i3, this.mScrollOffset, 1, iArr);
                i = i3 - iArr[1];
            }
            if (i != 0) {
                overScrollMode = getOverScrollMode();
                if (overScrollMode != 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    if (i < 0) {
                        if (edgeEffect2.isFinished()) {
                            edgeEffect2.onAbsorb((int) this.mScroller.getCurrVelocity());
                        }
                    } else if (edgeEffect.isFinished()) {
                        edgeEffect.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                }
                this.mScroller.abortAnimation();
                stopNestedScroll(1);
            }
            if (this.mScroller.isFinished()) {
                stopNestedScroll(1);
            } else {
                postInvalidateOnAnimation();
            }
        }
        iRound = Math.round(JvmClassMappingKt.onPullDistance(edgeEffect2, ((-i2) * 4.0f) / height, 0.5f) * ((-height) / 4.0f));
        if (iRound != i2) {
            edgeEffect2.finish();
        }
        i2 -= iRound;
        this.mLastScrollerY = currY;
        iArr = this.mScrollConsumed;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, i2, 1, iArr, null);
        i = i2 - iArr[1];
        scrollRange = getScrollRange();
        if (i != 0) {
            int scrollY3 = getScrollY();
            overScrollByCompat(i, getScrollX(), scrollY3, scrollRange);
            int scrollY4 = getScrollY() - scrollY3;
            int i4 = i - scrollY4;
            iArr[1] = 0;
            this.mChildHelper.dispatchNestedScrollInternal(0, scrollY4, 0, i4, this.mScrollOffset, 1, iArr);
            i = i4 - iArr[1];
        }
        if (i != 0) {
            overScrollMode = getOverScrollMode();
            if (overScrollMode != 0) {
                if (i < 0) {
                    if (edgeEffect2.isFinished()) {
                        edgeEffect2.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                } else if (edgeEffect.isFinished()) {
                    edgeEffect.onAbsorb((int) this.mScroller.getCurrVelocity());
                }
            } else if (i < 0) {
                if (edgeEffect2.isFinished()) {
                    edgeEffect2.onAbsorb((int) this.mScroller.getCurrVelocity());
                }
            } else if (edgeEffect.isFinished()) {
                edgeEffect.onAbsorb((int) this.mScroller.getCurrVelocity());
            }
            this.mScroller.abortAnimation();
            stopNestedScroll(1);
        }
        if (this.mScroller.isFinished()) {
            postInvalidateOnAnimation();
        } else {
            stopNestedScroll(1);
        }
    }

    public final int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        int i3 = rect.bottom;
        if (i3 > i2 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i2, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        }
        if (rect.top >= scrollY || i3 >= i2) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    public final boolean dispatchNestedPreScroll(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        ViewParent nestedScrollingParentForType;
        int i4;
        int i5;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.mChildHelper;
        if (!nestedScrollingChildHelper.mIsNestedScrollingEnabled || (nestedScrollingParentForType = nestedScrollingChildHelper.getNestedScrollingParentForType(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        NestedScrollView nestedScrollView = nestedScrollingChildHelper.mView;
        if (iArr2 != null) {
            nestedScrollView.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (nestedScrollingChildHelper.mTempNestedScrollConsumed == null) {
                nestedScrollingChildHelper.mTempNestedScrollConsumed = new int[2];
            }
            iArr = nestedScrollingChildHelper.mTempNestedScrollConsumed;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        if (nestedScrollingParentForType instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) nestedScrollingParentForType).onNestedPreScroll(iArr, i, i2, i3);
        } else if (i3 == 0) {
            try {
                ViewParentCompat$Api21Impl.onNestedPreScroll(nestedScrollingParentForType, nestedScrollView, i, i2, iArr);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedPreScroll", e);
            }
        }
        if (iArr2 != null) {
            nestedScrollView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.dispatchNestedScrollInternal(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        int paddingLeft2 = 0;
        if (!edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (Api21Impl.getClipToPadding(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (Api21Impl.getClipToPadding(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect2 = this.mEdgeGlowBottom;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (Api21Impl.getClipToPadding(this)) {
            width2 -= getPaddingRight() + getPaddingLeft();
            paddingLeft2 = getPaddingLeft();
        }
        if (Api21Impl.getClipToPadding(this)) {
            height2 -= getPaddingBottom() + getPaddingTop();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    public final boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19) {
                    return keyEvent.isAltPressed() ? fullScroll(33) : arrowScroll(33);
                }
                if (keyCode == 20) {
                    return keyEvent.isAltPressed() ? fullScroll(130) : arrowScroll(130);
                }
                if (keyCode == 62) {
                    pageScroll(keyEvent.isShiftPressed() ? 33 : 130);
                    return false;
                }
                if (keyCode == 92) {
                    return fullScroll(33);
                }
                if (keyCode == 93) {
                    return fullScroll(130);
                }
                if (keyCode == 122) {
                    pageScroll(33);
                    return false;
                }
                if (keyCode != 123) {
                    return false;
                }
                pageScroll(130);
                return false;
            }
        }
        if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
        return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
    }

    public final void fling(int i) {
        if (getChildCount() > 0) {
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            startNestedScroll(2, 1);
            this.mLastScrollerY = getScrollY();
            postInvalidateOnAnimation();
        }
    }

    public final boolean fullScroll(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.mTempRect;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return scrollAndFocus(i, rect.top, rect.bottom);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        Version.ECB ecb = this.mParentHelper;
        return ecb.dataCodewords | ecb.count;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.mVerticalScrollFactor;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.mChildHelper.getNestedScrollingParentForType(0) != null;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.mChildHelper.mIsNestedScrollingEnabled;
    }

    public final boolean isWithinDeltaOfScreen(View view, int i, int i2) {
        Rect rect = this.mTempRect;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i >= getScrollY() && rect.top - i <= getScrollY() + i2;
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:66:0x0105  */
    /* JADX WARN: Code duplicated, block: B:69:0x010a A[PHI: r5
  0x010a: PHI (r5v18 int) = (r5v16 int), (r5v16 int), (r5v16 int), (r5v17 int) binds: [B:68:0x0108, B:78:0x0125, B:80:0x012b, B:82:0x012e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x010c  */
    /* JADX WARN: Code duplicated, block: B:75:0x011f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0125  */
    /* JADX WARN: Code duplicated, block: B:83:0x0130  */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue;
        int i;
        int width;
        char c;
        int scaledMinimumFlingVelocity;
        int scaledMinimumFlingVelocity2;
        int deviceId;
        int source;
        InputDevice device;
        boolean z;
        int i2;
        int identifier;
        int scaledMaximumFlingVelocity;
        int dimensionPixelSize;
        char c2;
        boolean z2;
        VelocityTracker velocityTracker;
        float yVelocity;
        float f;
        long j;
        float fSqrt;
        int i3;
        int i4;
        if (motionEvent.getAction() != 8 || this.mIsBeingDragged) {
            return false;
        }
        if ((motionEvent.getSource() & 2) == 2) {
            i = 9;
            axisValue = motionEvent.getAxisValue(9);
            width = (int) motionEvent.getX();
        } else if ((motionEvent.getSource() & 4194304) == 4194304) {
            axisValue = motionEvent.getAxisValue(26);
            width = getWidth() / 2;
            i = 26;
        } else {
            axisValue = 0.0f;
            i = 0;
            width = 0;
        }
        if (axisValue == 0.0f) {
            return false;
        }
        scrollBy((motionEvent.getSource() & 8194) == 8194, -((int) (getVerticalScrollFactorCompat() * axisValue)), width, 1);
        if (i == 0) {
            return true;
        }
        DifferentialMotionFlingController differentialMotionFlingController = this.mDifferentialMotionFlingController;
        differentialMotionFlingController.getClass();
        int source2 = motionEvent.getSource();
        int deviceId2 = motionEvent.getDeviceId();
        int i5 = differentialMotionFlingController.mLastProcessedSource;
        int[] iArr = differentialMotionFlingController.mFlingVelocityThresholds;
        if (i5 == source2 && differentialMotionFlingController.mLastProcessedDeviceId == deviceId2 && differentialMotionFlingController.mLastProcessedAxis == i) {
            c2 = 0;
            z2 = false;
        } else {
            Context context = differentialMotionFlingController.mContext;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int deviceId3 = motionEvent.getDeviceId();
            int source3 = motionEvent.getSource();
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 34) {
                int i7 = ViewConfigurationCompat.$r8$clinit;
                scaledMinimumFlingVelocity = ViewConfigurationCompat.Api34Impl.getScaledMinimumFlingVelocity(viewConfiguration, deviceId3, i, source3);
            } else {
                int i8 = ViewConfigurationCompat.$r8$clinit;
                InputDevice device2 = InputDevice.getDevice(deviceId3);
                if (device2 == null || device2.getMotionRange(i, source3) == null) {
                    c = 0;
                    scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                } else {
                    Resources resources = context.getResources();
                    int identifier2 = (source3 == 4194304 && i == 26) ? resources.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                    Objects.requireNonNull(viewConfiguration);
                    if (identifier2 == -1) {
                        scaledMinimumFlingVelocity2 = viewConfiguration.getScaledMinimumFlingVelocity();
                    } else if (identifier2 != 0) {
                        scaledMinimumFlingVelocity2 = resources.getDimensionPixelSize(identifier2);
                        if (scaledMinimumFlingVelocity2 < 0) {
                            scaledMinimumFlingVelocity2 = Integer.MAX_VALUE;
                        }
                    } else {
                        scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                    }
                    scaledMinimumFlingVelocity = scaledMinimumFlingVelocity2;
                }
                iArr[c] = scaledMinimumFlingVelocity;
                deviceId = motionEvent.getDeviceId();
                source = motionEvent.getSource();
                if (i6 >= 34) {
                    scaledMaximumFlingVelocity = ViewConfigurationCompat.Api34Impl.getScaledMaximumFlingVelocity(viewConfiguration, deviceId, i, source);
                } else {
                    device = InputDevice.getDevice(deviceId);
                    if (device != null || device.getMotionRange(i, source) == null) {
                        z = false;
                    } else {
                        z = true;
                    }
                    i2 = Integer.MIN_VALUE;
                    if (z) {
                        Resources resources2 = context.getResources();
                        if (source == 4194304 || i != 26) {
                            identifier = -1;
                        } else {
                            identifier = resources2.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", "android");
                        }
                        Objects.requireNonNull(viewConfiguration);
                        if (identifier != -1) {
                            if (identifier != 0 && (dimensionPixelSize = resources2.getDimensionPixelSize(identifier)) >= 0) {
                                i2 = dimensionPixelSize;
                            }
                            scaledMaximumFlingVelocity = i2;
                        } else {
                            scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                        }
                    } else {
                        scaledMaximumFlingVelocity = i2;
                    }
                }
                iArr[1] = scaledMaximumFlingVelocity;
                differentialMotionFlingController.mLastProcessedSource = source2;
                differentialMotionFlingController.mLastProcessedDeviceId = deviceId2;
                differentialMotionFlingController.mLastProcessedAxis = i;
                c2 = 0;
                z2 = true;
            }
            c = 0;
            iArr[c] = scaledMinimumFlingVelocity;
            deviceId = motionEvent.getDeviceId();
            source = motionEvent.getSource();
            if (i6 >= 34) {
                scaledMaximumFlingVelocity = ViewConfigurationCompat.Api34Impl.getScaledMaximumFlingVelocity(viewConfiguration, deviceId, i, source);
            } else {
                device = InputDevice.getDevice(deviceId);
                if (device != null) {
                    z = false;
                } else {
                    z = false;
                }
                i2 = Integer.MIN_VALUE;
                if (z) {
                    scaledMaximumFlingVelocity = i2;
                } else {
                    Resources resources3 = context.getResources();
                    if (source == 4194304) {
                        identifier = -1;
                    } else {
                        identifier = -1;
                    }
                    Objects.requireNonNull(viewConfiguration);
                    if (identifier != -1) {
                        if (identifier != 0) {
                            i2 = dimensionPixelSize;
                        }
                        scaledMaximumFlingVelocity = i2;
                    } else {
                        scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                    }
                }
            }
            iArr[1] = scaledMaximumFlingVelocity;
            differentialMotionFlingController.mLastProcessedSource = source2;
            differentialMotionFlingController.mLastProcessedDeviceId = deviceId2;
            differentialMotionFlingController.mLastProcessedAxis = i;
            c2 = 0;
            z2 = true;
        }
        if (iArr[c2] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker2 = differentialMotionFlingController.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                differentialMotionFlingController.mVelocityTracker = null;
            }
        } else {
            if (differentialMotionFlingController.mVelocityTracker == null) {
                differentialMotionFlingController.mVelocityTracker = VelocityTracker.obtain();
            }
            VelocityTracker velocityTracker3 = differentialMotionFlingController.mVelocityTracker;
            Map map = VelocityTrackerCompat.sFallbackTrackers;
            velocityTracker3.addMovement(motionEvent);
            if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
                Map map2 = VelocityTrackerCompat.sFallbackTrackers;
                if (!map2.containsKey(velocityTracker3)) {
                    map2.put(velocityTracker3, new VelocityTrackerFallback());
                }
                VelocityTrackerFallback velocityTrackerFallback = (VelocityTrackerFallback) map2.get(velocityTracker3);
                velocityTrackerFallback.getClass();
                long eventTime = motionEvent.getEventTime();
                int i9 = velocityTrackerFallback.mDataPointsBufferSize;
                long[] jArr = velocityTrackerFallback.mEventTimes;
                if (i9 != 0 && eventTime - jArr[velocityTrackerFallback.mDataPointsBufferLastUsedIndex] > 40) {
                    velocityTrackerFallback.mDataPointsBufferSize = 0;
                    velocityTrackerFallback.mLastComputedVelocity = 0.0f;
                }
                int i10 = (velocityTrackerFallback.mDataPointsBufferLastUsedIndex + 1) % 20;
                velocityTrackerFallback.mDataPointsBufferLastUsedIndex = i10;
                int i11 = velocityTrackerFallback.mDataPointsBufferSize;
                if (i11 != 20) {
                    velocityTrackerFallback.mDataPointsBufferSize = i11 + 1;
                }
                velocityTrackerFallback.mMovements[i10] = motionEvent.getAxisValue(26);
                jArr[velocityTrackerFallback.mDataPointsBufferLastUsedIndex] = eventTime;
            }
            velocityTracker3.computeCurrentVelocity(1000, Float.MAX_VALUE);
            VelocityTrackerFallback velocityTrackerFallback2 = (VelocityTrackerFallback) VelocityTrackerCompat.sFallbackTrackers.get(velocityTracker3);
            if (velocityTrackerFallback2 != null) {
                int i12 = velocityTrackerFallback2.mDataPointsBufferSize;
                if (i12 < 2) {
                    velocityTracker = velocityTracker3;
                    i3 = 1000;
                    fSqrt = 0.0f;
                } else {
                    int i13 = velocityTrackerFallback2.mDataPointsBufferLastUsedIndex;
                    int i14 = ((i13 + 20) - (i12 - 1)) % 20;
                    long[] jArr2 = velocityTrackerFallback2.mEventTimes;
                    long j2 = jArr2[i13];
                    while (true) {
                        j = jArr2[i14];
                        if (j2 - j <= 100) {
                            break;
                        }
                        velocityTrackerFallback2.mDataPointsBufferSize--;
                        i14 = (i14 + 1) % 20;
                    }
                    int i15 = velocityTrackerFallback2.mDataPointsBufferSize;
                    if (i15 < 2) {
                        velocityTracker = velocityTracker3;
                        i3 = 1000;
                        fSqrt = 0.0f;
                    } else {
                        float[] fArr = velocityTrackerFallback2.mMovements;
                        if (i15 == 2) {
                            int i16 = (i14 + 1) % 20;
                            long j3 = jArr2[i16];
                            if (j == j3) {
                                velocityTracker = velocityTracker3;
                                i3 = 1000;
                                fSqrt = 0.0f;
                            } else {
                                velocityTracker = velocityTracker3;
                                i3 = 1000;
                                fSqrt = fArr[i16] / (j3 - j);
                            }
                        } else {
                            float f2 = 0.0f;
                            int i17 = 0;
                            int i18 = 0;
                            while (true) {
                                if (i17 >= velocityTrackerFallback2.mDataPointsBufferSize - 1) {
                                    break;
                                }
                                int i19 = i17 + i14;
                                long j4 = jArr2[i19 % 20];
                                int i20 = (i19 + 1) % 20;
                                if (jArr2[i20] == j4) {
                                    i4 = 1;
                                } else {
                                    i18++;
                                    float fSqrt2 = (f2 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f2) * 2.0f));
                                    float f3 = fArr[i20] / (jArr2[i20] - j4);
                                    float fAbs = (Math.abs(f3) * (f3 - fSqrt2)) + f2;
                                    i4 = 1;
                                    if (i18 == 1) {
                                        fAbs *= 0.5f;
                                    }
                                    f2 = fAbs;
                                }
                                i17 += i4;
                                fArr = fArr;
                                velocityTracker3 = velocityTracker3;
                            }
                            velocityTracker = velocityTracker3;
                            fSqrt = ((float) Math.sqrt(Math.abs(f2) * 2.0f)) * (f2 < 0.0f ? -1.0f : 1.0f);
                            i3 = 1000;
                        }
                    }
                }
                float f4 = fSqrt * i3;
                velocityTrackerFallback2.mLastComputedVelocity = f4;
                if (f4 < (-Math.abs(Float.MAX_VALUE))) {
                    velocityTrackerFallback2.mLastComputedVelocity = -Math.abs(Float.MAX_VALUE);
                } else if (velocityTrackerFallback2.mLastComputedVelocity > Math.abs(Float.MAX_VALUE)) {
                    velocityTrackerFallback2.mLastComputedVelocity = Math.abs(Float.MAX_VALUE);
                }
            } else {
                velocityTracker = velocityTracker3;
            }
            if (Build.VERSION.SDK_INT >= 34) {
                yVelocity = VelocityTrackerCompat.Api34Impl.getAxisVelocity(velocityTracker, i);
            } else {
                VelocityTracker velocityTracker4 = velocityTracker;
                if (i == 0) {
                    yVelocity = velocityTracker4.getXVelocity();
                } else if (i == 1) {
                    yVelocity = velocityTracker4.getYVelocity();
                } else {
                    VelocityTrackerFallback velocityTrackerFallback3 = (VelocityTrackerFallback) VelocityTrackerCompat.sFallbackTrackers.get(velocityTracker4);
                    yVelocity = (velocityTrackerFallback3 == null || i != 26) ? 0.0f : velocityTrackerFallback3.mLastComputedVelocity;
                }
            }
            NestedScrollView nestedScrollView = (NestedScrollView) differentialMotionFlingController.mTarget.this$0;
            float f5 = yVelocity * (-nestedScrollView.getVerticalScrollFactorCompat());
            float fSignum = Math.signum(f5);
            if (z2 || (fSignum != Math.signum(differentialMotionFlingController.mLastFlingVelocity) && fSignum != 0.0f)) {
                nestedScrollView.mScroller.abortAnimation();
            }
            if (Math.abs(f5) >= iArr[0]) {
                int i21 = iArr[1];
                float fMax = Math.max(-i21, Math.min(f5, i21));
                if (fMax == 0.0f) {
                    f = 0.0f;
                } else {
                    nestedScrollView.mScroller.abortAnimation();
                    nestedScrollView.fling((int) fMax);
                    f = fMax;
                }
                differentialMotionFlingController.mLastFlingVelocity = f;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x008b  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x0117  */
    /* JADX WARN: Code duplicated, block: B:70:0x012d  */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i = action & 255;
        if (i == 0) {
            int y = (int) motionEvent.getY();
            int x = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y < childAt.getTop() - scrollY || y >= childAt.getBottom() - scrollY || x < childAt.getLeft() || x >= childAt.getRight()) {
                    if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                        z = false;
                    }
                    this.mIsBeingDragged = z;
                    velocityTracker = this.mVelocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                } else {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker3 = this.mVelocityTracker;
                    if (velocityTracker3 == null) {
                        this.mVelocityTracker = VelocityTracker.obtain();
                    } else {
                        velocityTracker3.clear();
                    }
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mScroller.computeScrollOffset();
                    if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                        z = false;
                    }
                    this.mIsBeingDragged = z;
                    startNestedScroll(2, 0);
                }
            } else {
                if (!stopGlowAnimations(motionEvent)) {
                    z = false;
                }
                this.mIsBeingDragged = z;
                velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
            }
        } else if (i == 1) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else if (i == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y2 - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionY = y2;
                        if (this.mVelocityTracker == null) {
                            this.mVelocityTracker = VelocityTracker.obtain();
                        }
                        this.mVelocityTracker.addMovement(motionEvent);
                        this.mNestedYOffset = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i == 3) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else if (i == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            View view2 = this.mChildToScrollTo;
            Rect rect = this.mTempRect;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < measuredHeight && scrollY >= 0) {
                i5 = paddingTop + scrollY > measuredHeight ? measuredHeight - paddingTop : scrollY;
            }
            if (i5 != scrollY) {
                scrollTo(getScrollX(), i5);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mFillViewport && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        fling((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, 0, iArr, null);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScrollInternal(iArr, i4, i5);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        Version.ECB ecb = this.mParentHelper;
        if (i2 == 1) {
            ecb.dataCodewords = i;
        } else {
            ecb.count = i;
        }
        startNestedScroll(2, i2);
    }

    public final void onNestedScrollInternal(int[] iArr, int i, int i2) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.mChildHelper.dispatchNestedScrollInternal(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus != null && isWithinDeltaOfScreen(viewFindNextFocus, 0, getHeight())) {
            return viewFindNextFocus.requestFocus(i, rect);
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public final void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionY = (int) motionEvent.getY(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !isWithinDeltaOfScreen(viewFindFocus, 0, i4)) {
            return;
        }
        Rect rect = this.mTempRect;
        viewFindFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(viewFindFocus, rect);
        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen, false);
            } else {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View view, int i) {
        Version.ECB ecb = this.mParentHelper;
        if (i == 1) {
            ecb.dataCodewords = 0;
        } else {
            ecb.count = 0;
        }
        stopNestedScroll(i);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        float f = 0.0f;
        motionEventObtain.offsetLocation(0.0f, this.mNestedYOffset);
        if (actionMasked != 0) {
            EdgeEffect edgeEffect = this.mEdgeGlowBottom;
            EdgeEffect edgeEffect2 = this.mEdgeGlowTop;
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) >= this.mMinimumVelocity) {
                    if (JvmClassMappingKt.getDistance(edgeEffect2) != 0.0f) {
                        if (shouldAbsorb(edgeEffect2, yVelocity)) {
                            edgeEffect2.onAbsorb(yVelocity);
                        } else {
                            fling(-yVelocity);
                        }
                    } else if (JvmClassMappingKt.getDistance(edgeEffect) != 0.0f) {
                        int i = -yVelocity;
                        if (shouldAbsorb(edgeEffect, i)) {
                            edgeEffect.onAbsorb(i);
                        } else {
                            fling(i);
                        }
                    } else {
                        int i2 = -yVelocity;
                        float f2 = i2;
                        if (!this.mChildHelper.dispatchNestedPreFling(0.0f, f2)) {
                            dispatchNestedFling(0.0f, f2, true);
                            fling(i2);
                        }
                    }
                } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.mActivePointerId = -1;
                this.mIsBeingDragged = false;
                VelocityTracker velocityTracker2 = this.mVelocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.mVelocityTracker = null;
                }
                stopNestedScroll(0);
                this.mEdgeGlowTop.onRelease();
                this.mEdgeGlowBottom.onRelease();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i3 = this.mLastMotionY - y;
                    float x = motionEvent.getX(iFindPointerIndex) / getWidth();
                    float height = i3 / getHeight();
                    if (JvmClassMappingKt.getDistance(edgeEffect2) != 0.0f) {
                        float f3 = -JvmClassMappingKt.onPullDistance(edgeEffect2, -height, x);
                        if (JvmClassMappingKt.getDistance(edgeEffect2) == 0.0f) {
                            edgeEffect2.onRelease();
                        }
                        f = f3;
                    } else if (JvmClassMappingKt.getDistance(edgeEffect) != 0.0f) {
                        float fOnPullDistance = JvmClassMappingKt.onPullDistance(edgeEffect, height, 1.0f - x);
                        if (JvmClassMappingKt.getDistance(edgeEffect) == 0.0f) {
                            edgeEffect.onRelease();
                        }
                        f = fOnPullDistance;
                    }
                    int iRound = Math.round(f * getHeight());
                    if (iRound != 0) {
                        invalidate();
                    }
                    int i4 = i3 - iRound;
                    if (!this.mIsBeingDragged && Math.abs(i4) > this.mTouchSlop) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        i4 = i4 > 0 ? i4 - this.mTouchSlop : i4 + this.mTouchSlop;
                    }
                    if (this.mIsBeingDragged) {
                        int iScrollBy = scrollBy(false, i4, (int) motionEvent.getX(iFindPointerIndex), 0);
                        this.mLastMotionY = y - iScrollBy;
                        this.mNestedYOffset += iScrollBy;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.mIsBeingDragged && getChildCount() > 0 && this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.mActivePointerId = -1;
                this.mIsBeingDragged = false;
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.mVelocityTracker = null;
                }
                stopNestedScroll(0);
                this.mEdgeGlowTop.onRelease();
                this.mEdgeGlowBottom.onRelease();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.mLastMotionY = (int) motionEvent.getY(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.mIsBeingDragged && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                stopNestedScroll(1);
            }
            int y2 = (int) motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            this.mLastMotionY = y2;
            this.mActivePointerId = pointerId;
            startNestedScroll(2, 0);
        }
        VelocityTracker velocityTracker4 = this.mVelocityTracker;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public final boolean overScrollByCompat(int i, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i5 = i3 + i;
        if (i2 <= 0 && i2 >= 0) {
            z = false;
        } else {
            i2 = 0;
            z = true;
        }
        if (i5 > i4) {
            z2 = true;
        } else if (i5 < 0) {
            i4 = 0;
            z2 = true;
        } else {
            i4 = i5;
            z2 = false;
        }
        if (z2 && this.mChildHelper.getNestedScrollingParentForType(1) == null) {
            this.mScroller.springBack(i2, i4, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i2, i4);
        return z || z2;
    }

    public final void pageScroll(int i) {
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.mTempRect;
        if (z) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i2 = rect.top;
        int i3 = height + i2;
        rect.bottom = i3;
        scrollAndFocus(i, i2, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.mIsLayoutDirty) {
            this.mChildToScrollTo = view2;
        } else {
            Rect rect = this.mTempRect;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = iComputeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen, false);
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        VelocityTracker velocityTracker;
        if (z && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    public final boolean scrollAndFocus(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z2 = i == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4 && z5) {
                            view = view2;
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (z5) {
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i2 < scrollY || i3 > i4) {
            scrollBy(true, z2 ? i2 - scrollY : i3 - i4, 0, 1);
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    public final int scrollBy(boolean z, int i, int i2, int i3) {
        int i4;
        int i5;
        VelocityTracker velocityTracker;
        if (i3 == 1) {
            startNestedScroll(2, i3);
        }
        boolean zDispatchNestedPreScroll = dispatchNestedPreScroll(0, i, i3, this.mScrollConsumed, this.mScrollOffset);
        int[] iArr = this.mScrollConsumed;
        int[] iArr2 = this.mScrollOffset;
        if (zDispatchNestedPreScroll) {
            i4 = i - iArr[1];
            i5 = iArr2[1];
        } else {
            i4 = i;
            i5 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z2 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z;
        boolean z3 = overScrollByCompat(i4, 0, scrollY, scrollRange) && this.mChildHelper.getNestedScrollingParentForType(i3) == null;
        int scrollY2 = getScrollY() - scrollY;
        iArr[1] = 0;
        this.mChildHelper.dispatchNestedScrollInternal(0, scrollY2, 0, i4 - scrollY2, this.mScrollOffset, i3, iArr);
        int i6 = i5 + iArr2[1];
        int i7 = i4 - iArr[1];
        int i8 = scrollY + i7;
        EdgeEffect edgeEffect = this.mEdgeGlowBottom;
        EdgeEffect edgeEffect2 = this.mEdgeGlowTop;
        if (i8 < 0) {
            if (z2) {
                JvmClassMappingKt.onPullDistance(edgeEffect2, (-i7) / getHeight(), i2 / getWidth());
                if (!edgeEffect.isFinished()) {
                    edgeEffect.onRelease();
                }
            }
        } else if (i8 > scrollRange && z2) {
            JvmClassMappingKt.onPullDistance(edgeEffect, i7 / getHeight(), 1.0f - (i2 / getWidth()));
            if (!edgeEffect2.isFinished()) {
                edgeEffect2.onRelease();
            }
        }
        if (!edgeEffect2.isFinished() || !edgeEffect.isFinished()) {
            postInvalidateOnAnimation();
            z3 = false;
        }
        if (z3 && i3 == 0 && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.clear();
        }
        if (i3 == 1) {
            stopNestedScroll(i3);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i6;
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i < 0) {
                i = 0;
            } else if (width + i > width2) {
                i = width2 - width;
            }
            if (height >= height2 || i2 < 0) {
                i2 = 0;
            } else if (height + i2 > height2) {
                i2 = height2 - height;
            }
            if (i == getScrollX() && i2 == getScrollY()) {
                return;
            }
            super.scrollTo(i, i2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.mFillViewport) {
            this.mFillViewport = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.mChildHelper;
        if (nestedScrollingChildHelper.mIsNestedScrollingEnabled) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.stopNestedScroll(nestedScrollingChildHelper.mView);
        }
        nestedScrollingChildHelper.mIsNestedScrollingEnabled = z;
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.mSmoothScrollingEnabled = z;
    }

    public final boolean shouldAbsorb(EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        float distance = JvmClassMappingKt.getDistance(edgeEffect) * getHeight();
        float fAbs = Math.abs(-i) * 0.35f;
        float f = this.mPhysicalCoeff * 0.015f;
        double dLog = Math.log(fAbs / f);
        double d = DECELERATION_RATE;
        return ((float) (Math.exp((d / (d - 1.0d)) * dLog) * ((double) f))) < distance;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i, int i2, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
            if (z) {
                startNestedScroll(2, 1);
            } else {
                stopNestedScroll(1);
            }
            this.mLastScrollerY = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                stopNestedScroll(1);
            }
            scrollBy(i, i2);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean startNestedScroll(int i, int i2) {
        boolean zOnStartNestedScroll;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.mChildHelper;
        if (!(nestedScrollingChildHelper.getNestedScrollingParentForType(i2) != null)) {
            if (!nestedScrollingChildHelper.mIsNestedScrollingEnabled) {
                return false;
            }
            NestedScrollView nestedScrollView = nestedScrollingChildHelper.mView;
            View view = nestedScrollView;
            for (ViewParent parent = nestedScrollView.getParent(); parent != null; parent = parent.getParent()) {
                boolean z = parent instanceof NestedScrollingParent2;
                if (z) {
                    zOnStartNestedScroll = ((NestedScrollingParent2) parent).onStartNestedScroll(view, nestedScrollView, i, i2);
                } else if (i2 == 0) {
                    try {
                        zOnStartNestedScroll = ViewParentCompat$Api21Impl.onStartNestedScroll(parent, view, nestedScrollView, i);
                    } catch (AbstractMethodError e) {
                        Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                        zOnStartNestedScroll = false;
                    }
                } else {
                    zOnStartNestedScroll = false;
                }
                if (zOnStartNestedScroll) {
                    if (i2 == 0) {
                        nestedScrollingChildHelper.mNestedScrollingParentTouch = parent;
                    } else if (i2 == 1) {
                        nestedScrollingChildHelper.mNestedScrollingParentNonTouch = parent;
                    }
                    if (z) {
                        ((NestedScrollingParent2) parent).onNestedScrollAccepted(view, nestedScrollView, i, i2);
                    } else if (i2 == 0) {
                        try {
                            ViewParentCompat$Api21Impl.onNestedScrollAccepted(parent, view, nestedScrollView, i);
                        } catch (AbstractMethodError e2) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                        }
                    }
                } else {
                    if (parent instanceof View) {
                        view = (View) parent;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z;
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (JvmClassMappingKt.getDistance(edgeEffect) != 0.0f) {
            JvmClassMappingKt.onPullDistance(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mEdgeGlowBottom;
        if (JvmClassMappingKt.getDistance(edgeEffect2) == 0.0f) {
            return z;
        }
        JvmClassMappingKt.onPullDistance(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void stopNestedScroll(int i) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.mChildHelper;
        ViewParent nestedScrollingParentForType = nestedScrollingChildHelper.getNestedScrollingParentForType(i);
        if (nestedScrollingParentForType != null) {
            boolean z = nestedScrollingParentForType instanceof NestedScrollingParent2;
            NestedScrollView nestedScrollView = nestedScrollingChildHelper.mView;
            if (z) {
                ((NestedScrollingParent2) nestedScrollingParentForType).onStopNestedScroll(nestedScrollView, i);
            } else if (i == 0) {
                try {
                    ViewParentCompat$Api21Impl.onStopNestedScroll(nestedScrollingParentForType, nestedScrollView);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (i == 0) {
                nestedScrollingChildHelper.mNestedScrollingParentTouch = null;
            } else {
                if (i != 1) {
                    return;
                }
                nestedScrollingChildHelper.mNestedScrollingParentNonTouch = null;
            }
        }
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        ViewParent nestedScrollingParentForType;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.mChildHelper;
        if (!nestedScrollingChildHelper.mIsNestedScrollingEnabled || (nestedScrollingParentForType = nestedScrollingChildHelper.getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        try {
            return ViewParentCompat$Api21Impl.onNestedFling(nestedScrollingParentForType, nestedScrollingChildHelper.mView, f, f2, z);
        } catch (AbstractMethodError e) {
            Log.e(xPQrbOSWiEdU.ESyQbeXDaAQpy, "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(int[] iArr, int i, int i2, int i3) {
        dispatchNestedPreScroll(i, i2, i3, iArr, null);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4, int i5) {
        onNestedScrollInternal(null, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScrollInternal(null, i4, 0);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, 0, iArr, iArr2);
    }
}
