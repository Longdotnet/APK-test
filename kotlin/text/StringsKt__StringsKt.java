package kotlin.text;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.ExceptionsKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;
import kotlinx.coroutines.internal.Jbo.ygoi;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StringsKt__StringsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static boolean contains$default(CharSequence charSequence, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return indexOf$default(charSequence, c, 0, false, 2) >= 0;
    }

    public static boolean equals(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int indexOf(int i, CharSequence charSequence, String string, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i);
        }
        int length = charSequence.length();
        if (i < 0) {
            i = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        IntRange intRange = new IntRange(i, length, 1);
        boolean z2 = charSequence instanceof String;
        int i2 = intRange.step;
        int i3 = intRange.last;
        int i4 = intRange.first;
        if (!z2 || !(string instanceof String)) {
            if ((i2 > 0 && i4 <= i3) || (i2 < 0 && i3 <= i4)) {
                while (!regionMatchesImpl(string, 0, charSequence, i4, string.length(), z)) {
                    if (i4 != i3) {
                        i4 += i2;
                    }
                }
                return i4;
            }
            return -1;
        }
        if ((i2 > 0 && i4 <= i3) || (i2 < 0 && i3 <= i4)) {
            while (!regionMatches(0, i4, string.length(), string, (String) charSequence, z)) {
                if (i4 != i3) {
                    i4 += i2;
                }
            }
            return i4;
        }
        return -1;
    }

    public static int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? indexOfAny(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        int i2;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length == 1) {
                return ((String) charSequence).indexOf(cArr[0], i);
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        if (i < 0) {
            i = 0;
        }
        int i3 = new IntRange(i, getLastIndex(charSequence), 1).last;
        boolean z2 = i <= i3;
        if (!z2) {
            i = i3;
        }
        while (z2) {
            if (i != i3) {
                i2 = i + 1;
            } else {
                if (!z2) {
                    throw new NoSuchElementException();
                }
                i2 = i;
                z2 = false;
            }
            char cCharAt = charSequence.charAt(i);
            for (char c : cArr) {
                if (ExceptionsKt.equals(c, cCharAt, z)) {
                    return i;
                }
            }
            i = i2;
        }
        return -1;
    }

    public static boolean isBlank(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return true;
        }
        Iterable intRange = new IntRange(0, str.length() - 1, 1);
        if ((intRange instanceof Collection) && ((Collection) intRange).isEmpty()) {
            return true;
        }
        Iterator it = intRange.iterator();
        while (((IntProgressionIterator) it).hasNext) {
            char cCharAt = str.charAt(((IntProgressionIterator) it).nextInt());
            if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static int lastIndexOf$default(String str, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(str);
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.lastIndexOf(c, i);
    }

    public static DelimitedRangesSequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, boolean z, int i) {
        requireNonNegativeLimit(i);
        return new DelimitedRangesSequence(charSequence, 0, i, new StringsKt__StringsKt$rangesDelimitedBy$1(ArraysKt.asList(strArr), z, 1));
    }

    public static final boolean regionMatches(int i, int i2, int i3, String str, String other, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return !z ? str.regionMatches(i, other, i2, i3) : str.regionMatches(z, i, other, i2, i3);
    }

    public static final boolean regionMatchesImpl(String str, int i, CharSequence other, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i2 < 0 || i < 0 || i > str.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!ExceptionsKt.equals(str.charAt(i + i4), other.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String removePrefix(String str, String str2) {
        if (!startsWith(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static String replace$default(String str, String oldValue, String newValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int iIndexOf = indexOf(0, str, oldValue, false);
        if (iIndexOf < 0) {
            return str;
        }
        int length = oldValue.length();
        int i = length >= 1 ? length : 1;
        int length2 = newValue.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i2 = 0;
        do {
            sb.append((CharSequence) str, i2, iIndexOf);
            sb.append(newValue);
            i2 = iIndexOf + length;
            if (iIndexOf >= str.length()) {
                break;
            }
            iIndexOf = indexOf(iIndexOf + i, str, oldValue, false);
        } while (iIndexOf > 0);
        sb.append((CharSequence) str, i2, str.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List split$StringsKt__StringsKt(int i, CharSequence charSequence, String str, boolean z) {
        requireNonNegativeLimit(i);
        int length = 0;
        int iIndexOf = indexOf(0, charSequence, str, z);
        if (iIndexOf == -1 || i == 1) {
            return Okio.listOf(charSequence.toString());
        }
        boolean z2 = i > 0;
        int i2 = 10;
        if (z2 && i <= 10) {
            i2 = i;
        }
        ArrayList arrayList = new ArrayList(i2);
        do {
            arrayList.add(charSequence.subSequence(length, iIndexOf).toString());
            length = str.length() + iIndexOf;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iIndexOf = indexOf(length, charSequence, str, z);
        } while (iIndexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List split$default(CharSequence charSequence, String[] strArr, int i, int i2) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return split$StringsKt__StringsKt(i, charSequence, str, false);
            }
        }
        SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 = new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, false, i));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1));
        Iterator it = sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1.iterator();
        while (true) {
            DelimitedRangesSequence.AnonymousClass1 anonymousClass1 = (DelimitedRangesSequence.AnonymousClass1) it;
            if (!anonymousClass1.hasNext()) {
                return arrayList;
            }
            arrayList.add(substring(charSequence, (IntRange) anonymousClass1.next()));
        }
    }

    public static boolean startsWith(String str, String prefix, boolean z) {
        Intrinsics.checkNotNullParameter(str, ygoi.eWpRNCTCBWrvZ);
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return !z ? str.startsWith(prefix) : regionMatches(0, 0, prefix.length(), str, prefix, z);
    }

    public static final String substring(CharSequence charSequence, IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.first, range.last + 1).toString();
    }

    public static String substringAfter$default(String str, String delimiter) {
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        int iIndexOf$default = indexOf$default((CharSequence) str, delimiter, 0, false, 6);
        if (iIndexOf$default == -1) {
            return str;
        }
        String strSubstring = str.substring(delimiter.length() + iIndexOf$default, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String substringAfterLast$default(String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default(missingDelimiterValue, '.', 0, 6);
        if (iLastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(iLastIndexOf$default + 1, missingDelimiterValue.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static Integer toIntOrNull(String str) {
        boolean z;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        ExceptionsKt.checkRadix(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        int i4 = -2147483647;
        if (Intrinsics.compare(cCharAt, 48) < 0) {
            i = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i4 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
            }
        } else {
            z = false;
            i = 0;
        }
        int i5 = -59652323;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i3 < i5 && (i5 != -59652323 || i3 < (i5 = i4 / 10))) || (i2 = i3 * 10) < i4 + iDigit) {
                return null;
            }
            i3 = i2 - iDigit;
            i++;
        }
        return z ? Integer.valueOf(i3) : Integer.valueOf(-i3);
    }

    public static CharSequence trim(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            char cCharAt = str.charAt(!z ? i : length);
            boolean z2 = Character.isWhitespace(cCharAt) || Character.isSpaceChar(cCharAt);
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1);
    }

    public static boolean contains$default(CharSequence charSequence, String other) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf$default(charSequence, other, 0, false, 2) >= 0;
    }

    public static boolean startsWith(String str, int i, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!z) {
            return str.startsWith(str2, i);
        }
        return regionMatches(i, 0, str2.length(), str, str2, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(i, charSequence, str, z);
    }

    public static List split$default(String str, char[] cArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z = false;
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(0, str, String.valueOf(cArr[0]), false);
        }
        requireNonNegativeLimit(0);
        SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 = new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(new DelimitedRangesSequence(str, 0, 0, new StringsKt__StringsKt$rangesDelimitedBy$1(cArr, z, 0)));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1));
        Iterator it = sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1.iterator();
        while (true) {
            DelimitedRangesSequence.AnonymousClass1 anonymousClass1 = (DelimitedRangesSequence.AnonymousClass1) it;
            if (!anonymousClass1.hasNext()) {
                return arrayList;
            }
            arrayList.add(substring(str, (IntRange) anonymousClass1.next()));
        }
    }
}
