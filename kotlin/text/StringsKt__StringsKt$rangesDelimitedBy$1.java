package kotlin.text;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public final class StringsKt__StringsKt$rangesDelimitedBy$1 extends Lambda implements Function2 {
    public final /* synthetic */ Object $delimiters;
    public final /* synthetic */ boolean $ignoreCase;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StringsKt__StringsKt$rangesDelimitedBy$1(Object obj, boolean z, int i) {
        super(2);
        this.$r8$classId = i;
        this.$delimiters = obj;
        this.$ignoreCase = z;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a5 A[LOOP:0: B:26:0x0072->B:37:0x00a5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:63:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00e9 A[SYNTHETIC] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i;
        boolean z;
        Object next;
        Pair pair;
        Object next2;
        String str;
        String str2;
        switch (this.$r8$classId) {
            case 0:
                CharSequence $receiver = (CharSequence) obj;
                int iIntValue = ((Number) obj2).intValue();
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                int iIndexOfAny = StringsKt__StringsKt.indexOfAny($receiver, (char[]) this.$delimiters, iIntValue, this.$ignoreCase);
                if (iIndexOfAny < 0) {
                    return null;
                }
                return new Pair(Integer.valueOf(iIndexOfAny), 1);
            default:
                CharSequence $receiver2 = (CharSequence) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                Intrinsics.checkNotNullParameter($receiver2, "$this$$receiver");
                List list = (List) this.$delimiters;
                boolean z2 = this.$ignoreCase;
                if (z2 || list.size() != 1) {
                    if (iIntValue2 < 0) {
                        iIntValue2 = 0;
                    }
                    boolean z3 = $receiver2 instanceof String;
                    int i2 = new IntRange(iIntValue2, $receiver2.length(), 1).last;
                    if (z3) {
                        if (iIntValue2 > i2) {
                            pair = null;
                        } else {
                            while (true) {
                                Iterator it = list.iterator();
                                do {
                                    if (it.hasNext()) {
                                        next2 = it.next();
                                        str2 = (String) next2;
                                    } else {
                                        next2 = null;
                                    }
                                    str = (String) next2;
                                    if (str != null) {
                                        pair = new Pair(Integer.valueOf(iIntValue2), str);
                                    } else if (iIntValue2 != i2) {
                                        iIntValue2++;
                                    } else {
                                        pair = null;
                                    }
                                } while (!StringsKt__StringsKt.regionMatches(0, iIntValue2, str2.length(), str2, (String) $receiver2, z2));
                                str = (String) next2;
                                if (str != null) {
                                    pair = new Pair(Integer.valueOf(iIntValue2), str);
                                } else if (iIntValue2 != i2) {
                                    iIntValue2++;
                                } else {
                                    pair = null;
                                }
                            }
                        }
                    } else if (iIntValue2 > i2) {
                        pair = null;
                    } else {
                        int i3 = iIntValue2;
                        while (true) {
                            Iterator it2 = list.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    next = it2.next();
                                    String str3 = (String) next;
                                    i = i2;
                                    z = z2;
                                    if (!StringsKt__StringsKt.regionMatchesImpl(str3, 0, $receiver2, i3, str3.length(), z2)) {
                                        z2 = z;
                                        i2 = i;
                                    }
                                } else {
                                    i = i2;
                                    z = z2;
                                    next = null;
                                }
                            }
                            String str4 = (String) next;
                            if (str4 != null) {
                                pair = new Pair(Integer.valueOf(i3), str4);
                            } else if (i3 != i) {
                                i3++;
                                z2 = z;
                                i2 = i;
                            } else {
                                pair = null;
                            }
                        }
                    }
                } else {
                    int size = list.size();
                    if (size == 0) {
                        throw new NoSuchElementException("List is empty.");
                    }
                    if (size != 1) {
                        throw new IllegalArgumentException("List has more than one element.");
                    }
                    String str5 = (String) list.get(0);
                    int iIndexOf$default = StringsKt__StringsKt.indexOf$default($receiver2, str5, iIntValue2, false, 4);
                    if (iIndexOf$default < 0) {
                        pair = null;
                    } else {
                        pair = new Pair(Integer.valueOf(iIndexOf$default), str5);
                    }
                }
                if (pair == null) {
                    return null;
                }
                return new Pair(pair.first, Integer.valueOf(((String) pair.second).length()));
        }
    }
}
