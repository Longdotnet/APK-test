package androidx.activity.result;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultRegistry$generateRandomNumber$1 extends Lambda implements Function0 {
    public static final ActivityResultRegistry$generateRandomNumber$1 INSTANCE = new ActivityResultRegistry$generateRandomNumber$1(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Random.Default.getClass();
        return Integer.valueOf(Random.defaultRandom.nextInt$1() + 65536);
    }
}
