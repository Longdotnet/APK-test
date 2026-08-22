package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentAnim$EndViewTransitionAnimation extends AnimationSet implements Runnable {
    public boolean mAnimating;
    public final View mChild;
    public boolean mEnded;
    public final ViewGroup mParent;
    public boolean mTransitionEnded;

    public FragmentAnim$EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.mAnimating = true;
        this.mParent = viewGroup;
        this.mChild = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation) {
        this.mAnimating = true;
        if (this.mEnded) {
            return !this.mTransitionEnded;
        }
        if (!super.getTransformation(j, transformation)) {
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.mEnded;
        ViewGroup viewGroup = this.mParent;
        if (z || !this.mAnimating) {
            viewGroup.endViewTransition(this.mChild);
            this.mTransitionEnded = true;
        } else {
            this.mAnimating = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation, float f) {
        this.mAnimating = true;
        if (this.mEnded) {
            return !this.mTransitionEnded;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        }
        return true;
    }
}
