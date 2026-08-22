package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public final class RtlSpacingHelper {
    public int mEnd;
    public int mExplicitLeft;
    public int mExplicitRight;
    public boolean mIsRelative;
    public boolean mIsRtl;
    public int mLeft;
    public int mRight;
    public int mStart;

    public final void setRelative(int i, int i2) {
        this.mStart = i;
        this.mEnd = i2;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i2 != Integer.MIN_VALUE) {
                this.mLeft = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.mRight = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.mLeft = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.mRight = i2;
        }
    }
}
