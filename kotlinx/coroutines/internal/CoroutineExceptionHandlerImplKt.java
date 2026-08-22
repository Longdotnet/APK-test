package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CoroutineExceptionHandlerImplKt {
    public static final List platformExceptionHandlers;

    static {
        try {
            Iterator it = Arrays.asList(new AndroidExceptionPreHandler()).iterator();
            Intrinsics.checkNotNullParameter(it, "<this>");
            platformExceptionHandlers = SequencesKt.toList(new ConstrainedOnceSequence(new GeneratorSequence(it, 2)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
