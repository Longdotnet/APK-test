package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R$styleable;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.R;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentContainerView extends FrameLayout {
    public View.OnApplyWindowInsetsListener applyWindowInsetsListener;
    public final ArrayList disappearingFragmentChildren;
    public boolean drawDisappearingViewsFirst;
    public final ArrayList transitioningFragmentViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attrs, FragmentManager fm) {
        View view;
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(fm, "fm");
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        String classAttribute = attrs.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(0) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentFindFragmentById = fm.findFragmentById(id);
        if (classAttribute != null && fragmentFindFragmentById == null) {
            if (id == -1) {
                throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            FragmentManager.AnonymousClass3 fragmentFactory = fm.getFragmentFactory();
            context.getClassLoader();
            Fragment fragmentInstantiate = Fragment.instantiate(FragmentManager.this.mHost.mContext, classAttribute, null);
            Intrinsics.checkNotNullExpressionValue(fragmentInstantiate, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            fragmentInstantiate.onInflate(context, attrs, (Bundle) null);
            BackStackRecord backStackRecord = new BackStackRecord(fm);
            backStackRecord.mReorderingAllowed = true;
            fragmentInstantiate.mContainer = this;
            backStackRecord.doAddOp(getId(), fragmentInstantiate, string);
            if (backStackRecord.mAddToBackStack) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            FragmentManager fragmentManager = backStackRecord.mManager;
            if (fragmentManager.mHost != null && !fragmentManager.mDestroyed) {
                fragmentManager.ensureExecReady(true);
                backStackRecord.generateOps(fragmentManager.mTmpRecords, fragmentManager.mTmpIsPop);
                fragmentManager.mExecutingActions = true;
                try {
                    fragmentManager.removeRedundantOperationsAndExecute(fragmentManager.mTmpRecords, fragmentManager.mTmpIsPop);
                    fragmentManager.cleanupExec();
                    fragmentManager.updateOnBackPressedCallbackEnabled();
                    if (fragmentManager.mHavePendingDeferredStart) {
                        fragmentManager.mHavePendingDeferredStart = false;
                        fragmentManager.startPendingDeferredFragments();
                    }
                    ((HashMap) fragmentManager.mFragmentStore.readyAsyncCalls).values().removeAll(Collections.singleton(null));
                } catch (Throwable th) {
                    fragmentManager.cleanupExec();
                    throw th;
                }
            }
        }
        for (FragmentStateManager fragmentStateManager : fm.mFragmentStore.getActiveFragmentStateManagers()) {
            Fragment fragment = fragmentStateManager.mFragment;
            if (fragment.mContainerId == getId() && (view = fragment.mView) != null && view.getParent() == null) {
                fragment.mContainer = this;
                fragmentStateManager.addViewToContainer();
            }
        }
    }

    public final void addDisappearingFragmentView(View view) {
        if (this.transitioningFragmentViews.contains(view)) {
            this.disappearingFragmentChildren.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View child, int i, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(child, "child");
        Object tag = child.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(child, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets;
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(insets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.applyWindowInsetsListener;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, insets);
            Intrinsics.checkNotNullExpressionValue(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            windowInsetsCompatOnApplyWindowInsets = WindowInsetsCompat.toWindowInsetsCompat(windowInsetsOnApplyWindowInsets, null);
        } else {
            windowInsetsCompatOnApplyWindowInsets = ViewCompat.onApplyWindowInsets(this, windowInsetsCompat);
        }
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!windowInsetsCompatOnApplyWindowInsets.mImpl.isConsumed()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                WindowInsets windowInsets = windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
                if (windowInsets != null) {
                    WindowInsets windowInsetsDispatchApplyWindowInsets = ViewCompat.Api20Impl.dispatchApplyWindowInsets(childAt, windowInsets);
                    if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsets)) {
                        WindowInsetsCompat.toWindowInsetsCompat(windowInsetsDispatchApplyWindowInsets, childAt);
                    }
                }
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.transitioningFragmentViews.remove(view);
        if (this.disappearingFragmentChildren.remove(view)) {
            this.drawDisappearingViewsFirst = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        FragmentActivity fragmentActivity;
        Fragment fragment;
        FragmentManager supportFragmentManager;
        View view = this;
        while (true) {
            fragmentActivity = null;
            if (view == null) {
                fragment = null;
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            fragment = tag instanceof Fragment ? (Fragment) tag : null;
            if (fragment != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (fragment == null) {
            for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                }
            }
            if (fragmentActivity == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        } else {
            if (!fragment.isAdded()) {
                throw new IllegalStateException("The Fragment " + fragment + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            supportFragmentManager = fragment.getChildFragmentManager();
        }
        return (F) supportFragmentManager.findFragmentById(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View view = getChildAt(childCount);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                addDisappearingFragmentView(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        addDisappearingFragmentView(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View view = getChildAt(i);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        addDisappearingFragmentView(view);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View view = getChildAt(i4);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            addDisappearingFragmentView(view);
        }
        super.removeViews(i, i2);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.drawDisappearingViewsFirst = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.applyWindowInsetsListener = listener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getParent() == this) {
            this.transitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, ZRqOdXiy.MAbDJrvbEu);
        if (this.drawDisappearingViewsFirst) {
            Iterator it = this.disappearingFragmentChildren.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, gZrKCJ.DxrUNMocpeq);
        if (this.drawDisappearingViewsFirst) {
            ArrayList arrayList = this.disappearingFragmentChildren;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            Intrinsics.checkNotNullExpressionValue(childAt, JrbhsraGtto.DWRE);
            addDisappearingFragmentView(childAt);
        }
        super.removeViewsInLayout(i, i2);
    }
}
