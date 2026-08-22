package kotlinx.coroutines.internal;

import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MainDispatcherLoader {
    public static final HandlerContext dispatcher;

    static {
        String property;
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        Object next = null;
        try {
            property = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        try {
            Iterator it = Arrays.asList(new AndroidDispatcherFactory()).iterator();
            Intrinsics.checkNotNullParameter(it, "<this>");
            Iterator it2 = SequencesKt.toList(new ConstrainedOnceSequence(new GeneratorSequence(it, 2))).iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int loadPriority = ((AndroidDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it2.next();
                        int loadPriority2 = ((AndroidDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it2.hasNext());
                }
            }
            AndroidDispatcherFactory androidDispatcherFactory = (AndroidDispatcherFactory) next;
            if (androidDispatcherFactory == null) {
                throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
            }
            try {
                androidDispatcherFactory.getClass();
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper == null) {
                    throw new IllegalStateException("The main looper is not available");
                }
                dispatcher = new HandlerContext(HandlerDispatcherKt.asHandler(mainLooper));
            } catch (Throwable th) {
                androidDispatcherFactory.getClass();
                throw th;
            }
        } catch (Throwable th2) {
            throw new ServiceConfigurationError(th2.getMessage(), th2);
        }
    }
}
