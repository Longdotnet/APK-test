package androidx.appcompat.view;

import android.view.View;
import android.view.animation.BaseInterpolator;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompatSet {
    public BaseInterpolator mInterpolator;
    public boolean mIsStarted;
    public MediaType.Companion mListener;
    public long mDuration = -1;
    public final ToolbarWidgetWrapper.AnonymousClass2 mProxyListener = new ToolbarWidgetWrapper.AnonymousClass2(this);
    public final ArrayList mAnimators = new ArrayList();

    public final void cancel() {
        if (this.mIsStarted) {
            Iterator it = this.mAnimators.iterator();
            while (it.hasNext()) {
                ((ViewPropertyAnimatorCompat) it.next()).cancel();
            }
            this.mIsStarted = false;
        }
    }

    public final void start() {
        View view;
        if (this.mIsStarted) {
            return;
        }
        for (ViewPropertyAnimatorCompat viewPropertyAnimatorCompat : this.mAnimators) {
            long j = this.mDuration;
            if (j >= 0) {
                viewPropertyAnimatorCompat.setDuration(j);
            }
            BaseInterpolator baseInterpolator = this.mInterpolator;
            if (baseInterpolator != null && (view = (View) viewPropertyAnimatorCompat.mView.get()) != null) {
                view.animate().setInterpolator(baseInterpolator);
            }
            if (this.mListener != null) {
                viewPropertyAnimatorCompat.setListener(this.mProxyListener);
            }
            View view2 = (View) viewPropertyAnimatorCompat.mView.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.mIsStarted = true;
    }
}
