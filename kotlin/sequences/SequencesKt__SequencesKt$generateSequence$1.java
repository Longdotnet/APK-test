package kotlin.sequences;

import androidx.activity.result.ActivityResultRegistry$generateRandomNumber$1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class SequencesKt__SequencesKt$generateSequence$1 extends Lambda implements Function1 {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ActivityResultRegistry$generateRandomNumber$1.INSTANCE.invoke();
    }
}
