package androidx.core.view;

import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsControllerCompat$Impl26 extends WindowInsetsControllerCompat$Impl23 {
    @Override // kotlin.io.CloseableKt
    public final void setAppearanceLightNavigationBars(boolean z) {
        Window window = this.mWindow;
        if (!z) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-17));
        } else {
            window.clearFlags(134217728);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 16);
        }
    }
}
