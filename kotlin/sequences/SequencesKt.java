package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SequencesKt extends SequencesKt__SequencesJVMKt {
    public static List toList(Sequence sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator it = sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
    }
}
