package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentTransaction$Op {
    public int mCmd;
    public Lifecycle.State mCurrentMaxState;
    public int mEnterAnim;
    public int mExitAnim;
    public Fragment mFragment;
    public boolean mFromExpandedOp = true;
    public Lifecycle.State mOldMaxState;
    public int mPopEnterAnim;
    public int mPopExitAnim;

    public FragmentTransaction$Op(Fragment fragment, int i) {
        this.mCmd = i;
        this.mFragment = fragment;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.mOldMaxState = state;
        this.mCurrentMaxState = state;
    }

    public FragmentTransaction$Op(int i, Fragment fragment, int i2) {
        this.mCmd = i;
        this.mFragment = fragment;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.mOldMaxState = state;
        this.mCurrentMaxState = state;
    }
}
