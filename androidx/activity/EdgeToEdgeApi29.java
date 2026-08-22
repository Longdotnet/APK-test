package androidx.activity;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat$Impl23;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public class EdgeToEdgeApi29 extends EdgeToEdgeApi28 {
    @Override // androidx.activity.EdgeToEdgeApi26, okio.AsyncTimeout.Companion
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean z, boolean z2) {
        CloseableKt windowInsetsControllerCompat$Impl26;
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(view, "view");
        Protocol.Companion.setDecorFitsSystemWindows(window);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        window.setStatusBarContrastEnforced(false);
        window.setNavigationBarContrastEnforced(true);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            windowInsetsControllerCompat$Impl26 = new WindowInsetsControllerCompat$Impl30(window);
        } else {
            windowInsetsControllerCompat$Impl26 = i >= 26 ? new WindowInsetsControllerCompat$Impl26(window) : new WindowInsetsControllerCompat$Impl23(window);
        }
        windowInsetsControllerCompat$Impl26.setAppearanceLightStatusBars(!z);
        windowInsetsControllerCompat$Impl26.setAppearanceLightNavigationBars(!z2);
    }
}
