package com.google.zxing.oned;

import androidx.work.WorkContinuation;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

/* JADX INFO: loaded from: classes3.dex */
public final class EAN8Writer extends WorkContinuation {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ EAN8Writer(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.work.WorkContinuation, com.google.zxing.Writer
    public final BitMatrix encode(String str, int i, EnumMap enumMap) {
        switch (this.$r8$classId) {
            case 0:
                if (i == 7) {
                    return super.encode(str, i, enumMap);
                }
                throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
            case 1:
                if (i == 8) {
                    return super.encode(str, i, enumMap);
                }
                throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
            default:
                if (i == 16) {
                    return super.encode(str, i, enumMap);
                }
                throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
        }
    }

    @Override // androidx.work.WorkContinuation
    public final int getDefaultMargin() {
        return 9;
    }

    @Override // androidx.work.WorkContinuation
    public final boolean[] encode(String str) {
        switch (this.$r8$classId) {
            case 0:
                int length = str.length();
                if (length == 7) {
                    try {
                        str = str + UPCEANReader.getStandardUPCEANChecksum(str);
                    } catch (FormatException e) {
                        throw new IllegalArgumentException(e);
                    }
                } else if (length == 8) {
                    try {
                        if (!UPCEANReader.checkStandardUPCEANChecksum(str)) {
                            throw new IllegalArgumentException("Contents do not pass checksum");
                        }
                    } catch (FormatException unused) {
                        throw new IllegalArgumentException("Illegal contents");
                    }
                } else {
                    throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
                }
                boolean[] zArr = new boolean[67];
                int iAppendPattern = WorkContinuation.appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true);
                for (int i = 0; i <= 3; i++) {
                    iAppendPattern += WorkContinuation.appendPattern(zArr, iAppendPattern, UPCEANReader.L_PATTERNS[Character.digit(str.charAt(i), 10)], false);
                }
                int iAppendPattern2 = WorkContinuation.appendPattern(zArr, iAppendPattern, UPCEANReader.MIDDLE_PATTERN, false) + iAppendPattern;
                for (int i2 = 4; i2 <= 7; i2++) {
                    iAppendPattern2 += WorkContinuation.appendPattern(zArr, iAppendPattern2, UPCEANReader.L_PATTERNS[Character.digit(str.charAt(i2), 10)], true);
                }
                WorkContinuation.appendPattern(zArr, iAppendPattern2, UPCEANReader.START_END_PATTERN, true);
                return zArr;
            case 1:
                int length2 = str.length();
                if (length2 == 12) {
                    try {
                        str = str + UPCEANReader.getStandardUPCEANChecksum(str);
                    } catch (FormatException e2) {
                        throw new IllegalArgumentException(e2);
                    }
                } else if (length2 == 13) {
                    try {
                        if (!UPCEANReader.checkStandardUPCEANChecksum(str)) {
                            throw new IllegalArgumentException("Contents do not pass checksum");
                        }
                    } catch (FormatException unused2) {
                        throw new IllegalArgumentException("Illegal contents");
                    }
                } else {
                    throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length2)));
                }
                int i3 = UPCEReader.FIRST_DIGIT_ENCODINGS[Character.digit(str.charAt(0), 10)];
                boolean[] zArr2 = new boolean[95];
                int iAppendPattern3 = WorkContinuation.appendPattern(zArr2, 0, UPCEANReader.START_END_PATTERN, true);
                for (int i4 = 1; i4 <= 6; i4++) {
                    int iDigit = Character.digit(str.charAt(i4), 10);
                    if (((i3 >> (6 - i4)) & 1) == 1) {
                        iDigit += 10;
                    }
                    iAppendPattern3 += WorkContinuation.appendPattern(zArr2, iAppendPattern3, UPCEANReader.L_AND_G_PATTERNS[iDigit], false);
                }
                int iAppendPattern4 = WorkContinuation.appendPattern(zArr2, iAppendPattern3, UPCEANReader.MIDDLE_PATTERN, false) + iAppendPattern3;
                for (int i5 = 7; i5 <= 12; i5++) {
                    iAppendPattern4 += WorkContinuation.appendPattern(zArr2, iAppendPattern4, UPCEANReader.L_PATTERNS[Character.digit(str.charAt(i5), 10)], true);
                }
                WorkContinuation.appendPattern(zArr2, iAppendPattern4, UPCEANReader.START_END_PATTERN, true);
                return zArr2;
            default:
                int length3 = str.length();
                if (length3 == 7) {
                    try {
                        str = str + UPCEANReader.getStandardUPCEANChecksum(UPCEReader.convertUPCEtoUPCA(str));
                    } catch (FormatException e3) {
                        throw new IllegalArgumentException(e3);
                    }
                } else if (length3 == 8) {
                    try {
                        if (!UPCEANReader.checkStandardUPCEANChecksum(str)) {
                            throw new IllegalArgumentException("Contents do not pass checksum");
                        }
                    } catch (FormatException unused3) {
                        throw new IllegalArgumentException("Illegal contents");
                    }
                } else {
                    throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length3)));
                }
                int iDigit2 = Character.digit(str.charAt(0), 10);
                if (iDigit2 != 0 && iDigit2 != 1) {
                    throw new IllegalArgumentException("Number system must be 0 or 1");
                }
                int i6 = UPCEReader.NUMSYS_AND_CHECK_DIGIT_PATTERNS[iDigit2][Character.digit(str.charAt(7), 10)];
                boolean[] zArr3 = new boolean[51];
                int iAppendPattern5 = WorkContinuation.appendPattern(zArr3, 0, UPCEANReader.START_END_PATTERN, true);
                for (int i7 = 1; i7 <= 6; i7++) {
                    int iDigit3 = Character.digit(str.charAt(i7), 10);
                    if (((i6 >> (6 - i7)) & 1) == 1) {
                        iDigit3 += 10;
                    }
                    iAppendPattern5 += WorkContinuation.appendPattern(zArr3, iAppendPattern5, UPCEANReader.L_AND_G_PATTERNS[iDigit3], false);
                }
                WorkContinuation.appendPattern(zArr3, iAppendPattern5, UPCEANReader.END_PATTERN, false);
                return zArr3;
        }
    }
}
