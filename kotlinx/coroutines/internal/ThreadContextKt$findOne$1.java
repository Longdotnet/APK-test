package kotlinx.coroutines.internal;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadContextKt$findOne$1 extends Lambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public static final ThreadContextKt$findOne$1 INSTANCE$1 = new ThreadContextKt$findOne$1(2, 1);
    public static final ThreadContextKt$findOne$1 INSTANCE = new ThreadContextKt$findOne$1(2, 0);
    public static final ThreadContextKt$findOne$1 INSTANCE$2 = new ThreadContextKt$findOne$1(2, 2);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThreadContextKt$findOne$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                BarcodeFormat$EnumUnboxingLocalUtility.m(obj);
                return null;
            case 1:
                return obj;
            default:
                return (ThreadState) obj;
        }
    }
}
