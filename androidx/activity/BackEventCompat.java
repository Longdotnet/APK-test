package androidx.activity;

import android.window.BackEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class BackEventCompat {
    public final float progress;
    public final int swipeEdge;
    public final float touchX;
    public final float touchY;

    public BackEventCompat(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        Api34Impl api34Impl = Api34Impl.INSTANCE;
        float f = api34Impl.touchX(backEvent);
        float f2 = api34Impl.touchY(backEvent);
        float fProgress = api34Impl.progress(backEvent);
        int iSwipeEdge = api34Impl.swipeEdge(backEvent);
        this.touchX = f;
        this.touchY = f2;
        this.progress = fProgress;
        this.swipeEdge = iSwipeEdge;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + '}';
    }
}
