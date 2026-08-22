package androidx.appcompat.widget;

import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: loaded from: classes.dex */
public final class AbsActionBarView$VisibilityAnimListener implements ViewPropertyAnimatorListener {
    public boolean mCanceled;
    public int mFinalVisibility;
    public Object this$0;

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel() {
        this.mCanceled = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd() {
        if (this.mCanceled) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.this$0;
        actionBarContextView.mVisibilityAnim = null;
        super/*android.view.ViewGroup*/.setVisibility(this.mFinalVisibility);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart() {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.mCanceled = false;
    }
}
