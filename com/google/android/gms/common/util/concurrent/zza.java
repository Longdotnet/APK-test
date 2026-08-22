package com.google.android.gms.common.util.concurrent;

import android.os.Process;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final Runnable zza;

    public /* synthetic */ zza(int i, Runnable runnable) {
        this.$r8$classId = i;
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                Process.setThreadPriority(0);
                this.zza.run();
                break;
            default:
                try {
                    this.zza.run();
                } catch (Exception e) {
                    RangesKt.e(e, "Executor", "Background execution failure.");
                    return;
                }
                break;
        }
    }
}
