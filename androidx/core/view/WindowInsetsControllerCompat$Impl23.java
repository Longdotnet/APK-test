package androidx.core.view;

import android.view.View;
import android.view.Window;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl23 extends CloseableKt {
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl23(Window window) {
        this.mWindow = window;
    }

    @Override // kotlin.io.CloseableKt
    public final void setAppearanceLightStatusBars(boolean z) {
        Window window = this.mWindow;
        if (!z) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } else {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
        }
    }
}
