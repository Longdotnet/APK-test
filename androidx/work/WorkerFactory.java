package androidx.work;

import android.content.Context;
import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WorkerFactory {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkerFactory");

    /* JADX INFO: renamed from: androidx.work.WorkerFactory$1 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass1 extends WorkerFactory {
    }

    public final ListenableWorker createWorkerWithDefaultFallback(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        String str2 = TAG;
        ListenableWorker listenableWorker = null;
        try {
            clsAsSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
        } catch (Throwable th) {
            Logger$LogcatLogger.get().error(str2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Invalid class: ", str), th);
            clsAsSubclass = null;
        }
        if (clsAsSubclass != null) {
            try {
                listenableWorker = (ListenableWorker) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Throwable th2) {
                Logger$LogcatLogger.get().error(str2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(DYYbQc.zARuzZjRApN, str), th2);
            }
        }
        if (listenableWorker == null || !listenableWorker.isUsed()) {
            return listenableWorker;
        }
        throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("WorkerFactory (", getClass().getName(), ") returned an instance of a ListenableWorker (", str, ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker."));
    }
}
