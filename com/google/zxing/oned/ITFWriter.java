package com.google.zxing.oned;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.WorkContinuation;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class ITFWriter extends WorkContinuation {
    public final /* synthetic */ int $r8$classId;
    public static final int[] START_PATTERN = {1, 1, 1, 1};
    public static final int[] END_PATTERN = {3, 1, 1};
    public static final int[][] PATTERNS = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    public /* synthetic */ ITFWriter(int i) {
        this.$r8$classId = i;
    }

    public static void appendPattern(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            zArr[i] = iArr[i2] != 0;
            i2++;
            i = i3;
        }
    }

    public static int computeChecksumIndex(int i, String str) {
        int iIndexOf = 0;
        int i2 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i2;
            i2++;
            if (i2 > i) {
                i2 = 1;
            }
        }
        return iIndexOf % 47;
    }

    public static int findCType(int i, String str) {
        int length = str.length();
        int i2 = 1;
        if (i >= length) {
            return 1;
        }
        char cCharAt = str.charAt(i);
        if (cCharAt == 241) {
            return 4;
        }
        if (cCharAt >= '0' && cCharAt <= '9') {
            int i3 = i + 1;
            i2 = 2;
            if (i3 >= length) {
                return 2;
            }
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                return 3;
            }
        }
        return i2;
    }

    public static void toIntArray(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    public static void toIntArray$1(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    @Override // androidx.work.WorkContinuation, com.google.zxing.Writer
    public final BitMatrix encode(String str, int i, EnumMap enumMap) {
        switch (this.$r8$classId) {
            case 0:
                if (i == 9) {
                    return super.encode(str, i, enumMap);
                }
                throw new IllegalArgumentException("Can only encode ITF, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
            case 1:
                if (i == 5) {
                    return super.encode(str, i, enumMap);
                }
                throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
            case 2:
                if (i == 3) {
                    return super.encode(str, i, enumMap);
                }
                throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
            default:
                if (i == 4) {
                    return super.encode(str, i, enumMap);
                }
                throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0264  */
    /* JADX WARN: Code duplicated, block: B:135:0x029b  */
    /* JADX WARN: Code duplicated, block: B:222:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0188  */
    /* JADX WARN: Code duplicated, block: B:82:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:84:0x01cb A[LOOP:4: B:83:0x01c9->B:84:0x01cb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:88:0x01ec A[LOOP:5: B:87:0x01ea->B:88:0x01ec, LOOP_END] */
    @Override // androidx.work.WorkContinuation
    public final boolean[] encode(String str) {
        int i;
        int iFindCType;
        char cCharAt;
        int i2;
        int iCharAt;
        int[] iArr;
        int i3;
        int i4;
        int[] iArr2;
        boolean[] zArr;
        int[] iArr3;
        int iAppendPattern;
        int i5;
        int i6;
        String string = str;
        switch (this.$r8$classId) {
            case 0:
                int length = str.length();
                if (length % 2 != 0) {
                    throw new IllegalArgumentException("The length of the input should be even");
                }
                if (length <= 80) {
                    boolean[] zArr2 = new boolean[(length * 9) + 9];
                    int iAppendPattern2 = WorkContinuation.appendPattern(zArr2, 0, START_PATTERN, true);
                    for (int i7 = 0; i7 < length; i7 += 2) {
                        int iDigit = Character.digit(string.charAt(i7), 10);
                        int iDigit2 = Character.digit(string.charAt(i7 + 1), 10);
                        int[] iArr4 = new int[10];
                        for (int i8 = 0; i8 < 5; i8++) {
                            int i9 = i8 * 2;
                            int[][] iArr5 = PATTERNS;
                            iArr4[i9] = iArr5[iDigit][i8];
                            iArr4[i9 + 1] = iArr5[iDigit2][i8];
                        }
                        iAppendPattern2 += WorkContinuation.appendPattern(zArr2, iAppendPattern2, iArr4, true);
                    }
                    WorkContinuation.appendPattern(zArr2, iAppendPattern2, END_PATTERN, true);
                    return zArr2;
                }
                throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            case 1:
                int length2 = str.length();
                if (length2 > 0 && length2 <= 80) {
                    for (int i10 = 0; i10 < length2; i10++) {
                        char cCharAt2 = string.charAt(i10);
                        switch (cCharAt2) {
                            case 241:
                            case 242:
                            case 243:
                            case 244:
                                break;
                            default:
                                if (cCharAt2 > 127) {
                                    throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(cCharAt2)));
                                }
                                break;
                                break;
                        }
                    }
                    ArrayList<int[]> arrayList = new ArrayList();
                    int i11 = 1;
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        int[][] iArr6 = Code39Reader.CODE_PATTERNS;
                        if (i12 < length2) {
                            int iFindCType2 = findCType(i12, string);
                            if (iFindCType2 == 2) {
                                i = 100;
                            } else if (iFindCType2 != 1) {
                                i = 99;
                                if (i14 != 99) {
                                    if (i14 == 100) {
                                        if (iFindCType2 != 4 && (iFindCType = findCType(i12 + 2, string)) != 1 && iFindCType != 2) {
                                            if (iFindCType != 4) {
                                                int i15 = i12 + 4;
                                                while (true) {
                                                    int iFindCType3 = findCType(i15, string);
                                                    if (iFindCType3 == 3) {
                                                        i15 += 2;
                                                    } else if (iFindCType3 != 2) {
                                                        i = 99;
                                                    }
                                                }
                                            } else if (findCType(i12 + 3, string) == 3) {
                                                i = 99;
                                            }
                                        }
                                        i = 100;
                                    } else {
                                        if (iFindCType2 == 4) {
                                            iFindCType2 = findCType(i12 + 1, string);
                                        }
                                        if (iFindCType2 == 3) {
                                            i = 99;
                                        } else {
                                            i = 100;
                                        }
                                    }
                                }
                            } else if (i12 >= str.length() || ((cCharAt = string.charAt(i12)) >= ' ' && (i14 != 101 || cCharAt >= '`'))) {
                                i = 100;
                            } else {
                                i = 101;
                            }
                            if (i == i14) {
                                switch (string.charAt(i12)) {
                                    case 241:
                                        iCharAt = TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE;
                                        break;
                                    case 242:
                                        iCharAt = 97;
                                        break;
                                    case 243:
                                        iCharAt = 96;
                                        break;
                                    case 244:
                                        iCharAt = i14 == 101 ? 101 : 100;
                                        break;
                                    default:
                                        if (i14 == 100) {
                                            iCharAt = string.charAt(i12) - ' ';
                                        } else if (i14 != 101) {
                                            iCharAt = Integer.parseInt(string.substring(i12, i12 + 2));
                                            i12++;
                                        } else {
                                            char cCharAt3 = string.charAt(i12);
                                            iCharAt = cCharAt3 - ' ';
                                            if (iCharAt < 0) {
                                                iCharAt = cCharAt3 + '@';
                                            }
                                        }
                                        break;
                                }
                                i12++;
                            } else {
                                if (i14 != 0) {
                                    i2 = i;
                                } else if (i != 100) {
                                    i2 = i != 101 ? TossType.TOSS_NETUPOPEN_VALUE : TossType.TOSS_OPEN_BALANCED_VALUE;
                                } else {
                                    i2 = TossType.TOSS_FIXED_LOW_FOR_BEGINNER_VALUE;
                                }
                                i14 = i;
                                iCharAt = i2;
                            }
                            arrayList.add(iArr6[iCharAt]);
                            i13 += iCharAt * i11;
                            if (i12 != 0) {
                                i11++;
                            }
                        } else {
                            arrayList.add(iArr6[i13 % TossType.TOSS_OPEN_BALANCED_VALUE]);
                            arrayList.add(iArr6[106]);
                            int i16 = 0;
                            for (int[] iArr7 : arrayList) {
                                for (int i17 : iArr7) {
                                    i16 += i17;
                                }
                            }
                            boolean[] zArr3 = new boolean[i16];
                            Iterator it = arrayList.iterator();
                            int iAppendPattern3 = 0;
                            while (it.hasNext()) {
                                iAppendPattern3 += WorkContinuation.appendPattern(zArr3, iAppendPattern3, (int[]) it.next(), true);
                            }
                            return zArr3;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length2)));
                }
                break;
            case 2:
                int length3 = str.length();
                if (length3 <= 80) {
                    for (int i18 = 0; i18 < length3; i18++) {
                        if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(string.charAt(i18)) < 0) {
                            int length4 = str.length();
                            StringBuilder sb = new StringBuilder();
                            for (int i19 = 0; i19 < length4; i19++) {
                                char cCharAt4 = string.charAt(i19);
                                if (cCharAt4 == 0) {
                                    sb.append("%U");
                                } else if (cCharAt4 == ' ') {
                                    sb.append(cCharAt4);
                                } else if (cCharAt4 == '@') {
                                    sb.append("%V");
                                } else if (cCharAt4 == '`') {
                                    sb.append("%W");
                                } else if (cCharAt4 == '-' || cCharAt4 == '.') {
                                    sb.append(cCharAt4);
                                } else if (cCharAt4 <= 26) {
                                    sb.append('$');
                                    sb.append((char) (cCharAt4 + '@'));
                                } else if (cCharAt4 < ' ') {
                                    sb.append('%');
                                    sb.append((char) (cCharAt4 + '&'));
                                } else if (cCharAt4 <= ',' || cCharAt4 == '/' || cCharAt4 == ':') {
                                    sb.append('/');
                                    sb.append((char) (cCharAt4 + ' '));
                                } else if (cCharAt4 <= '9') {
                                    sb.append(cCharAt4);
                                } else if (cCharAt4 <= '?') {
                                    sb.append('%');
                                    sb.append((char) (cCharAt4 + 11));
                                } else if (cCharAt4 <= 'Z') {
                                    sb.append(cCharAt4);
                                } else if (cCharAt4 <= '_') {
                                    sb.append('%');
                                    sb.append((char) (cCharAt4 - 16));
                                } else if (cCharAt4 <= 'z') {
                                    sb.append('+');
                                    sb.append((char) (cCharAt4 - ' '));
                                } else if (cCharAt4 <= 127) {
                                    sb.append('%');
                                    sb.append((char) (cCharAt4 - '+'));
                                } else {
                                    throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + string.charAt(i19) + "'");
                                }
                            }
                            string = sb.toString();
                            length3 = string.length();
                            if (length3 > 80) {
                                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(length3, "Requested contents should be less than 80 digits long, but got ", " (extended full ASCII mode)"));
                            }
                            iArr = new int[9];
                            i3 = length3 + 25;
                            i4 = 0;
                            while (true) {
                                iArr2 = Code39Reader.CHARACTER_ENCODINGS;
                                if (i4 < length3) {
                                    toIntArray(iArr2["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(string.charAt(i4))], iArr);
                                    for (i6 = 0; i6 < 9; i6++) {
                                        i3 += iArr[i6];
                                    }
                                    i4++;
                                } else {
                                    zArr = new boolean[i3];
                                    toIntArray(148, iArr);
                                    int iAppendPattern4 = WorkContinuation.appendPattern(zArr, 0, iArr, true);
                                    iArr3 = new int[]{1};
                                    iAppendPattern = WorkContinuation.appendPattern(zArr, iAppendPattern4, iArr3, false) + iAppendPattern4;
                                    for (i5 = 0; i5 < length3; i5++) {
                                        toIntArray(iArr2["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(string.charAt(i5))], iArr);
                                        int iAppendPattern5 = WorkContinuation.appendPattern(zArr, iAppendPattern, iArr, true) + iAppendPattern;
                                        iAppendPattern = WorkContinuation.appendPattern(zArr, iAppendPattern5, iArr3, false) + iAppendPattern5;
                                    }
                                    toIntArray(148, iArr);
                                    WorkContinuation.appendPattern(zArr, iAppendPattern, iArr, true);
                                    return zArr;
                                }
                            }
                        }
                    }
                    iArr = new int[9];
                    i3 = length3 + 25;
                    i4 = 0;
                    while (true) {
                        iArr2 = Code39Reader.CHARACTER_ENCODINGS;
                        if (i4 < length3) {
                            toIntArray(iArr2["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(string.charAt(i4))], iArr);
                            while (i6 < 9) {
                                i3 += iArr[i6];
                            }
                            i4++;
                        } else {
                            zArr = new boolean[i3];
                            toIntArray(148, iArr);
                            int iAppendPattern6 = WorkContinuation.appendPattern(zArr, 0, iArr, true);
                            iArr3 = new int[]{1};
                            iAppendPattern = WorkContinuation.appendPattern(zArr, iAppendPattern6, iArr3, false) + iAppendPattern6;
                            while (i5 < length3) {
                                toIntArray(iArr2["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(string.charAt(i5))], iArr);
                                int iAppendPattern7 = WorkContinuation.appendPattern(zArr, iAppendPattern, iArr, true) + iAppendPattern;
                                iAppendPattern = WorkContinuation.appendPattern(zArr, iAppendPattern7, iArr3, false) + iAppendPattern7;
                            }
                            toIntArray(148, iArr);
                            WorkContinuation.appendPattern(zArr, iAppendPattern, iArr, true);
                            return zArr;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length3)));
                }
                break;
            default:
                int length5 = str.length();
                if (length5 <= 80) {
                    int i20 = 9;
                    int[] iArr8 = new int[9];
                    int length6 = ((str.length() + 4) * 9) + 1;
                    toIntArray$1(Code93Reader.CHARACTER_ENCODINGS[47], iArr8);
                    boolean[] zArr4 = new boolean[length6];
                    appendPattern(zArr4, 0, iArr8);
                    for (int i21 = 0; i21 < length5; i21++) {
                        toIntArray$1(Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(string.charAt(i21))], iArr8);
                        appendPattern(zArr4, i20, iArr8);
                        i20 += 9;
                    }
                    int iComputeChecksumIndex = computeChecksumIndex(20, string);
                    int[] iArr9 = Code93Reader.CHARACTER_ENCODINGS;
                    toIntArray$1(iArr9[iComputeChecksumIndex], iArr8);
                    appendPattern(zArr4, i20, iArr8);
                    toIntArray$1(iArr9[computeChecksumIndex(15, string + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iComputeChecksumIndex))], iArr8);
                    appendPattern(zArr4, i20 + 9, iArr8);
                    toIntArray$1(iArr9[47], iArr8);
                    appendPattern(zArr4, i20 + 18, iArr8);
                    zArr4[i20 + 27] = true;
                    return zArr4;
                }
                throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length5)));
        }
    }
}
