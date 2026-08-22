package androidx.loader.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class ModernAsyncTask$1 implements ThreadFactory {
    public final /* synthetic */ int $r8$classId;
    public final AtomicInteger mCount;

    public ModernAsyncTask$1(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 1:
                this.mCount = new AtomicInteger(0);
                break;
            case 2:
                this.mCount = new AtomicInteger(1);
                break;
            default:
                this.mCount = new AtomicInteger(1);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.mCount;
        switch (this.$r8$classId) {
            case 0:
                return new Thread(runnable, "ModernAsyncTask #" + atomicInteger.getAndIncrement());
            case 1:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + atomicInteger.getAndIncrement());
                return thread;
            default:
                return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(atomicInteger.getAndIncrement())));
        }
    }
}
