package kotlin.collections;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AbstractCollection$toString$1 extends Lambda implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractCollection$toString$1(Object obj, int i) {
        super(1);
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return obj == ((AbstractList) this.this$0) ? "(this Collection)" : String.valueOf(obj);
            default:
                IntRange it = (IntRange) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return StringsKt__StringsKt.substring((String) this.this$0, it);
        }
    }
}
