package androidx.core.widget;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.appcompat.widget.DropDownListView;
import androidx.core.view.ViewCompat;
import androidx.work.Worker;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ListViewAutoScrollHelper implements View.OnTouchListener {
    public static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    public final int mActivationDelay;
    public boolean mAlreadyDelayed;
    public boolean mAnimating;
    public final AccelerateInterpolator mEdgeInterpolator;
    public final int mEdgeType;
    public boolean mEnabled;
    public final float[] mMaximumEdges;
    public final float[] mMaximumVelocity;
    public final float[] mMinimumVelocity;
    public boolean mNeedsCancel;
    public boolean mNeedsReset;
    public final float[] mRelativeEdges;
    public final float[] mRelativeVelocity;
    public Worker.AnonymousClass1 mRunnable;
    public final AutoScrollHelper$ClampedScroller mScroller;
    public final DropDownListView mTarget;
    public final ListView mTarget$1;

    public ListViewAutoScrollHelper(DropDownListView dropDownListView) {
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = new AutoScrollHelper$ClampedScroller();
        autoScrollHelper$ClampedScroller.mStartTime = Long.MIN_VALUE;
        autoScrollHelper$ClampedScroller.mStopTime = -1L;
        autoScrollHelper$ClampedScroller.mDeltaTime = 0L;
        this.mScroller = autoScrollHelper$ClampedScroller;
        this.mEdgeInterpolator = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.mRelativeEdges = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.mMaximumEdges = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.mRelativeVelocity = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.mMinimumVelocity = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.mMaximumVelocity = fArr5;
        this.mTarget$1 = dropDownListView;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.mEdgeType = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.mActivationDelay = DEFAULT_ACTIVATION_DELAY;
        autoScrollHelper$ClampedScroller.mRampUpDuration = 500;
        autoScrollHelper$ClampedScroller.mRampDownDuration = 500;
        this.mTarget = dropDownListView;
    }

    public static float constrain(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        return f < f2 ? f2 : f;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0051  */
    public final float computeTargetVelocity(int i, float f, float f2, float f3) {
        float fConstrain;
        float interpolation;
        float fConstrain2 = constrain(this.mRelativeEdges[i] * f2, 0.0f, this.mMaximumEdges[i]);
        float fConstrainEdgeValue = constrainEdgeValue(f2 - f, fConstrain2) - constrainEdgeValue(f, fConstrain2);
        AccelerateInterpolator accelerateInterpolator = this.mEdgeInterpolator;
        if (fConstrainEdgeValue >= 0.0f) {
            if (fConstrainEdgeValue > 0.0f) {
                interpolation = accelerateInterpolator.getInterpolation(fConstrainEdgeValue);
            } else {
                fConstrain = 0.0f;
            }
            if (fConstrain == 0.0f) {
                return 0.0f;
            }
            float f4 = this.mRelativeVelocity[i];
            float f5 = this.mMinimumVelocity[i];
            float f6 = this.mMaximumVelocity[i];
            float f7 = f4 * f3;
            return fConstrain > 0.0f ? constrain(fConstrain * f7, f5, f6) : -constrain((-fConstrain) * f7, f5, f6);
        }
        interpolation = -accelerateInterpolator.getInterpolation(-fConstrainEdgeValue);
        fConstrain = constrain(interpolation, -1.0f, 1.0f);
        if (fConstrain == 0.0f) {
            return 0.0f;
        }
        float f8 = this.mRelativeVelocity[i];
        float f9 = this.mMinimumVelocity[i];
        float f10 = this.mMaximumVelocity[i];
        float f11 = f8 * f3;
        if (fConstrain > 0.0f) {
        }
    }

    public final float constrainEdgeValue(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.mEdgeType;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.mAnimating && i == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        if (!this.mEnabled) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                requestStop();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    requestStop();
                }
            }
            return false;
        }
        this.mNeedsCancel = true;
        this.mAlreadyDelayed = false;
        float x = motionEvent.getX();
        float width = view.getWidth();
        ListView listView = this.mTarget$1;
        float fComputeTargetVelocity = computeTargetVelocity(0, x, width, listView.getWidth());
        float fComputeTargetVelocity2 = computeTargetVelocity(1, motionEvent.getY(), view.getHeight(), listView.getHeight());
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
        autoScrollHelper$ClampedScroller.mTargetVelocityX = fComputeTargetVelocity;
        autoScrollHelper$ClampedScroller.mTargetVelocityY = fComputeTargetVelocity2;
        if (!this.mAnimating && shouldAnimate()) {
            if (this.mRunnable == null) {
                this.mRunnable = new Worker.AnonymousClass1(this, 7);
            }
            this.mAnimating = true;
            this.mNeedsReset = true;
            if (this.mAlreadyDelayed || (i = this.mActivationDelay) <= 0) {
                this.mRunnable.run();
            } else {
                Worker.AnonymousClass1 anonymousClass1 = this.mRunnable;
                long j = i;
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                listView.postOnAnimationDelayed(anonymousClass1, j);
            }
            this.mAlreadyDelayed = true;
        }
        return false;
    }

    public final void requestStop() {
        int i = 0;
        if (this.mNeedsReset) {
            this.mAnimating = false;
            return;
        }
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (jCurrentAnimationTimeMillis - autoScrollHelper$ClampedScroller.mStartTime);
        int i3 = autoScrollHelper$ClampedScroller.mRampDownDuration;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        autoScrollHelper$ClampedScroller.mEffectiveRampDown = i;
        autoScrollHelper$ClampedScroller.mStopValue = autoScrollHelper$ClampedScroller.getValueAt(jCurrentAnimationTimeMillis);
        autoScrollHelper$ClampedScroller.mStopTime = jCurrentAnimationTimeMillis;
    }

    public final boolean shouldAnimate() {
        DropDownListView dropDownListView;
        int count;
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
        float f = autoScrollHelper$ClampedScroller.mTargetVelocityY;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(autoScrollHelper$ClampedScroller.mTargetVelocityX);
        if (iAbs == 0 || (count = (dropDownListView = this.mTarget).getCount()) == 0) {
            return false;
        }
        int childCount = dropDownListView.getChildCount();
        int firstVisiblePosition = dropDownListView.getFirstVisiblePosition();
        int i = firstVisiblePosition + childCount;
        if (iAbs > 0) {
            if (i >= count && dropDownListView.getChildAt(childCount - 1).getBottom() <= dropDownListView.getHeight()) {
                return false;
            }
        } else {
            if (iAbs >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && dropDownListView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
