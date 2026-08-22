package androidx.core.widget;

/* JADX INFO: loaded from: classes.dex */
public final class AutoScrollHelper$ClampedScroller {
    public long mDeltaTime;
    public int mEffectiveRampDown;
    public int mRampDownDuration;
    public int mRampUpDuration;
    public long mStartTime;
    public long mStopTime;
    public float mStopValue;
    public float mTargetVelocityX;
    public float mTargetVelocityY;

    public final float getValueAt(long j) {
        long j2 = this.mStartTime;
        if (j < j2) {
            return 0.0f;
        }
        long j3 = this.mStopTime;
        if (j3 < 0 || j < j3) {
            return ListViewAutoScrollHelper.constrain((j - j2) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
        }
        float f = this.mStopValue;
        return (ListViewAutoScrollHelper.constrain((j - j3) / this.mEffectiveRampDown, 0.0f, 1.0f) * f) + (1.0f - f);
    }
}
