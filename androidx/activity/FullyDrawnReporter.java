package androidx.activity;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FullyDrawnReporter {
    public final Object lock;
    public final ArrayList onReportCallbacks;
    public boolean reportedFullyDrawn;

    public FullyDrawnReporter(ComponentActivity.ReportFullyDrawnExecutor executor, ComponentActivity$fullyDrawnReporter$2 componentActivity$fullyDrawnReporter$2) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
    }
}
