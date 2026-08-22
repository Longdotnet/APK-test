package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.daerisoft.thespikerm.RunnerActivity;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;

/* JADX INFO: loaded from: classes.dex */
public abstract class EdgeToEdge {
    public static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    public static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);

    public static final void enable(RunnerActivity runnerActivity) {
        AsyncTimeout.Companion edgeToEdgeApi26;
        SystemBarStyle$Companion$auto$1 systemBarStyle$Companion$auto$1 = SystemBarStyle$Companion$auto$1.INSTANCE;
        SystemBarStyle systemBarStyle = new SystemBarStyle(0, 0, systemBarStyle$Companion$auto$1);
        SystemBarStyle systemBarStyle2 = new SystemBarStyle(DefaultLightScrim, DefaultDarkScrim, systemBarStyle$Companion$auto$1);
        View decorView = runnerActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        Resources resources = decorView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        boolean zBooleanValue = ((Boolean) systemBarStyle$Companion$auto$1.invoke(resources)).booleanValue();
        Resources resources2 = decorView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
        boolean zBooleanValue2 = ((Boolean) systemBarStyle$Companion$auto$1.invoke(resources2)).booleanValue();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            edgeToEdgeApi26 = new EdgeToEdgeApi30();
        } else if (i >= 29) {
            edgeToEdgeApi26 = new EdgeToEdgeApi29();
        } else if (i >= 28) {
            edgeToEdgeApi26 = new EdgeToEdgeApi28();
        } else {
            edgeToEdgeApi26 = i >= 26 ? new EdgeToEdgeApi26() : new EdgeToEdgeApi23();
        }
        Window window = runnerActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        edgeToEdgeApi26.setUp(systemBarStyle, systemBarStyle2, window, decorView, zBooleanValue, zBooleanValue2);
        Window window2 = runnerActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window2, "window");
        edgeToEdgeApi26.adjustLayoutInDisplayCutoutMode(window2);
    }
}
