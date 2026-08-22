package androidx.activity;

import android.view.Window;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class EdgeToEdgeApi28 extends EdgeToEdgeApi26 {
    @Override // okio.AsyncTimeout.Companion
    public void adjustLayoutInDisplayCutoutMode(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        window.getAttributes().layoutInDisplayCutoutMode = 1;
    }
}
