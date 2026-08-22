package kotlinx.coroutines;

import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Dispatchers {
    public static final DefaultScheduler Default = DefaultScheduler.INSTANCE;
    public static final DefaultIoScheduler IO;

    static {
        int i = Unconfined.$r8$clinit;
        IO = DefaultIoScheduler.INSTANCE;
    }
}
