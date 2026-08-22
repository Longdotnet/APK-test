package kotlin.collections;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CollectionsKt extends CollectionsKt__MutableCollectionsKt {
    public static boolean contains(Collection collection, Object obj) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return collection.contains(obj);
    }

    public static Object first(List list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final void joinTo(Collection collection, StringBuilder sb, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1 function1) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        sb.append(prefix);
        int i2 = 0;
        for (Object obj : collection) {
            i2++;
            if (i2 > 1) {
                sb.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            } else {
                StringsKt__IndentKt.appendElement(sb, obj, function1);
            }
        }
        if (i >= 0 && i2 > i) {
            sb.append(truncated);
        }
        sb.append(postfix);
    }

    public static Object last(List list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(list.size() - 1);
    }

    public static List sortedWith(ArrayList arrayList, Comparator comparator) {
        if (arrayList.size() <= 1) {
            return toList(arrayList);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNullParameter(array, "<this>");
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return ArraysKt.asList(array);
    }

    public static final void toCollection(Iterable iterable, AbstractCollection abstractCollection) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List toList(Iterable iterable) {
        ArrayList mutableList;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        boolean z = iterable instanceof Collection;
        if (!z) {
            if (z) {
                mutableList = toMutableList((Collection) iterable);
            } else {
                ArrayList arrayList = new ArrayList();
                toCollection(iterable, arrayList);
                mutableList = arrayList;
            }
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(mutableList);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return EmptyList.INSTANCE;
        }
        if (size != 1) {
            return toMutableList(collection);
        }
        return Okio.listOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static ArrayList toMutableList(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }
}
