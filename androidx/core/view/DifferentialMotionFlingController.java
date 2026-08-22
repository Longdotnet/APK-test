package androidx.core.view;

import android.content.Context;
import android.view.VelocityTracker;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public final class DifferentialMotionFlingController {
    public final Context mContext;
    public float mLastFlingVelocity;
    public final Fragment.AnonymousClass7 mTarget;
    public VelocityTracker mVelocityTracker;
    public int mLastProcessedAxis = -1;
    public int mLastProcessedSource = -1;
    public int mLastProcessedDeviceId = -1;
    public final int[] mFlingVelocityThresholds = {Integer.MAX_VALUE, 0};

    public DifferentialMotionFlingController(Context context, Fragment.AnonymousClass7 anonymousClass7) {
        this.mContext = context;
        this.mTarget = anonymousClass7;
    }
}
