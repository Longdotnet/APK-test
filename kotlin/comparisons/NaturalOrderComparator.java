package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NaturalOrderComparator implements Comparator {
    public static final NaturalOrderComparator INSTANCE = new NaturalOrderComparator(0);
    public static final NaturalOrderComparator INSTANCE$1 = new NaturalOrderComparator(1);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ NaturalOrderComparator(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                Comparable a = (Comparable) obj;
                Comparable b = (Comparable) obj2;
                Intrinsics.checkNotNullParameter(a, "a");
                Intrinsics.checkNotNullParameter(b, "b");
                return a.compareTo(b);
            default:
                Comparable a2 = (Comparable) obj;
                Comparable b2 = (Comparable) obj2;
                Intrinsics.checkNotNullParameter(a2, "a");
                Intrinsics.checkNotNullParameter(b2, "b");
                return b2.compareTo(a2);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.$r8$classId) {
            case 0:
                return INSTANCE$1;
            default:
                return INSTANCE;
        }
    }
}
