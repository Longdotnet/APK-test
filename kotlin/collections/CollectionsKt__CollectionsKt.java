package kotlin.collections;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CollectionsKt__CollectionsKt extends Okio {
    public static ArrayList arrayListOf(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(elements, true));
    }

    public static List listOf(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length > 0 ? ArraysKt.asList(elements) : EmptyList.INSTANCE;
    }

    public static List optimizeReadOnlyList(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : Okio.listOf(list.get(0));
        }
        return EmptyList.INSTANCE;
    }
}
