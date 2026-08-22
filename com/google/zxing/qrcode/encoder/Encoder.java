package com.google.zxing.qrcode.encoder;

import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Arrays;
import okhttp3.internal.http2.Huffman;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Encoder {
    public static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    public static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    public static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    public static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE, -1, -1}, new int[]{6, 28, 54, 80, TossType.TOSS_NETUPC_VALUE, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE, 126, -1}, new int[]{6, 26, 52, 78, TossType.TOSS_FIXED_LOW_FOR_BEGINNER_VALUE, 130, -1}, new int[]{6, 30, 56, 82, TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE, 126, 150}, new int[]{6, 24, 50, 76, TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE, 128, 154}, new int[]{6, 28, 54, 80, TossType.TOSS_NETUPC_VALUE, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    public static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static int applyMaskPenaltyRule1Internal(Huffman.Node node, boolean z) {
        int i = node.symbol;
        int i2 = node.terminalBitCount;
        int i3 = z ? i2 : i;
        if (!z) {
            i = i2;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            byte b = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < i; i7++) {
                byte[][] bArr = (byte[][]) node.children;
                byte b2 = z ? bArr[i5][i7] : bArr[i7][i5];
                if (b2 == b) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i4 += i6 - 2;
                    }
                    i6 = 1;
                    b = b2;
                }
            }
            if (i6 >= 5) {
                i4 = (i6 - 2) + i4;
            }
        }
        return i4;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0246  */
    /* JADX WARN: Code duplicated, block: B:116:0x0249  */
    /* JADX WARN: Code duplicated, block: B:118:0x024d  */
    public static void buildMatrix(BitArray bitArray, int i, Version version, int i2, Huffman.Node node) throws WriterException {
        boolean z;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        for (byte[] bArr : (byte[][]) node.children) {
            Arrays.fill(bArr, (byte) -1);
        }
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, node);
        int i6 = node.symbol;
        int i7 = i6 - length;
        embedPositionDetectionPattern(i7, 0, node);
        embedPositionDetectionPattern(0, i7, node);
        embedHorizontalSeparationPattern(0, 7, node);
        int i8 = i6 - 8;
        embedHorizontalSeparationPattern(i8, 7, node);
        embedHorizontalSeparationPattern(0, i8, node);
        embedVerticalSeparationPattern(7, 0, node);
        int i9 = node.terminalBitCount;
        int i10 = i9 - 8;
        embedVerticalSeparationPattern(i10, 0, node);
        int i11 = i9 - 7;
        embedVerticalSeparationPattern(7, i11, node);
        if (node.get(8, i10) == 0) {
            throw new WriterException();
        }
        node.set(8, i10, 1);
        int i12 = version.versionNumber;
        if (i12 >= 2) {
            int[] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[i12 - 1];
            int length2 = iArr.length;
            int i13 = 0;
            while (i13 < length2) {
                int i14 = iArr[i13];
                if (i14 >= 0) {
                    int length3 = iArr.length;
                    int i15 = 0;
                    while (i15 < length3) {
                        int i16 = iArr[i15];
                        if (i16 >= 0 && isEmpty(node.get(i16, i14))) {
                            int i17 = i16 - 2;
                            int i18 = i14 - 2;
                            int i19 = 5;
                            int i20 = 0;
                            while (i20 < i19) {
                                int[] iArr2 = POSITION_ADJUSTMENT_PATTERN[i20];
                                int i21 = length2;
                                int i22 = 0;
                                while (i22 < i19) {
                                    node.set(i17 + i22, i18 + i20, iArr2[i22]);
                                    i22++;
                                    i14 = i14;
                                    i17 = i17;
                                    i19 = 5;
                                }
                                i20++;
                                length2 = i21;
                                i19 = 5;
                            }
                        }
                        i15++;
                        length3 = length3;
                        iArr = iArr;
                        length2 = length2;
                        i14 = i14;
                    }
                }
                i13++;
                iArr = iArr;
                length2 = length2;
            }
        }
        int i23 = 8;
        while (i23 < i8) {
            int i24 = i23 + 1;
            int i25 = i24 % 2;
            if (isEmpty(node.get(i23, 6))) {
                node.set(i23, 6, i25);
            }
            if (isEmpty(node.get(6, i23))) {
                node.set(6, i23, i25);
            }
            i23 = i24;
        }
        BitArray bitArray2 = new BitArray();
        if (i2 < 0 || i2 >= 8) {
            throw new WriterException("Invalid mask pattern");
        }
        int i26 = 1;
        if (i != 1) {
            i26 = 2;
            if (i == 2) {
                i26 = 0;
            } else if (i == 3) {
                i26 = 3;
            } else if (i != 4) {
                throw null;
            }
        }
        int i27 = (i26 << 3) | i2;
        bitArray2.appendBits(i27, 5);
        bitArray2.appendBits(calculateBCHCode(i27, 1335), 10);
        BitArray bitArray3 = new BitArray();
        bitArray3.appendBits(21522, 15);
        if (bitArray2.size != bitArray3.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i28 = 0;
        while (true) {
            int[] iArr3 = bitArray2.bits;
            if (i28 >= iArr3.length) {
                break;
            }
            iArr3[i28] = iArr3[i28] ^ bitArray3.bits[i28];
            i28++;
        }
        if (bitArray2.size != 15) {
            throw new WriterException("should not happen but we got: " + bitArray2.size);
        }
        int i29 = 0;
        while (true) {
            int i30 = bitArray2.size;
            if (i29 >= i30) {
                break;
            }
            boolean z5 = bitArray2.get((i30 - 1) - i29);
            int[] iArr4 = TYPE_INFO_COORDINATES[i29];
            node.set(iArr4[0], iArr4[1], z5);
            if (i29 < 8) {
                node.set((i6 - i29) - 1, 8, z5);
            } else {
                node.set(8, (i29 - 8) + i11, z5);
            }
            i29++;
        }
        if (i12 >= 7) {
            BitArray bitArray4 = new BitArray();
            bitArray4.appendBits(i12, 6);
            bitArray4.appendBits(calculateBCHCode(i12, 7973), 12);
            if (bitArray4.size != 18) {
                throw new WriterException("should not happen but we got: " + bitArray4.size);
            }
            int i31 = 17;
            for (int i32 = 0; i32 < 6; i32++) {
                for (int i33 = 0; i33 < 3; i33++) {
                    boolean z6 = bitArray4.get(i31);
                    i31--;
                    int i34 = (i9 - 11) + i33;
                    node.set(i32, i34, z6);
                    node.set(i34, i32, z6);
                }
            }
        }
        int i35 = i6 - 1;
        int i36 = i9 - 1;
        int i37 = 0;
        int i38 = -1;
        while (i35 > 0) {
            if (i35 == 6) {
                i35--;
            }
            while (i36 >= 0 && i36 < i9) {
                for (int i39 = 0; i39 < 2; i39++) {
                    int i40 = i35 - i39;
                    if (isEmpty(node.get(i40, i36))) {
                        if (i37 < bitArray.size) {
                            z = bitArray.get(i37);
                            i37++;
                        } else {
                            z = false;
                        }
                        if (i2 != -1) {
                            switch (i2) {
                                case 0:
                                    z2 = true;
                                    i3 = (i36 + i40) & 1;
                                    if (i3 == 0) {
                                        z4 = z2;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        z = !z;
                                    }
                                    break;
                                case 1:
                                    i3 = i36 & 1;
                                    z2 = true;
                                    if (i3 == 0) {
                                        z4 = z2;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        z = !z;
                                    }
                                    break;
                                case 2:
                                    i3 = i40 % 3;
                                    z2 = true;
                                    if (i3 == 0) {
                                        z4 = z2;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        z = !z;
                                    }
                                    break;
                                case 3:
                                    i3 = (i36 + i40) % 3;
                                    z2 = true;
                                    if (i3 == 0) {
                                        z4 = z2;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        z = !z;
                                    }
                                    break;
                                case 4:
                                    z2 = true;
                                    i3 = ((i40 / 3) + (i36 / 2)) & 1;
                                    if (i3 == 0) {
                                        z4 = z2;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        z = !z;
                                    }
                                    break;
                                case 5:
                                    int i41 = i36 * i40;
                                    i3 = (i41 % 3) + (i41 & 1);
                                    z2 = true;
                                    if (i3 == 0) {
                                        z4 = z2;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        z = !z;
                                    }
                                    break;
                                case 6:
                                    z3 = true;
                                    int i42 = i36 * i40;
                                    i4 = i42 & 1;
                                    i5 = i42 % 3;
                                    i3 = (i5 + i4) & 1;
                                    z2 = z3;
                                    if (i3 == 0) {
                                        z4 = z2;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        z = !z;
                                    }
                                    break;
                                case 7:
                                    i5 = (i36 * i40) % 3;
                                    z3 = true;
                                    i4 = (i36 + i40) & 1;
                                    i3 = (i5 + i4) & 1;
                                    z2 = z3;
                                    if (i3 == 0) {
                                        z4 = z2;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        z = !z;
                                    }
                                    break;
                                default:
                                    throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i2)));
                            }
                        }
                        node.set(i40, i36, z);
                    }
                }
                i36 += i38;
            }
            i38 = -i38;
            i36 += i38;
            i35 -= 2;
        }
        if (i37 == bitArray.size) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i37 + '/' + bitArray.size);
    }

    public static int calculateBCHCode(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i2);
        int i3 = 32 - iNumberOfLeadingZeros;
        int iNumberOfLeadingZeros2 = i << (31 - iNumberOfLeadingZeros);
        while (32 - Integer.numberOfLeadingZeros(iNumberOfLeadingZeros2) >= i3) {
            iNumberOfLeadingZeros2 ^= i2 << ((32 - Integer.numberOfLeadingZeros(iNumberOfLeadingZeros2)) - i3);
        }
        return iNumberOfLeadingZeros2;
    }

    public static void embedHorizontalSeparationPattern(int i, int i2, Huffman.Node node) throws WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (!isEmpty(node.get(i4, i2))) {
                throw new WriterException();
            }
            node.set(i4, i2, 0);
        }
    }

    public static void embedPositionDetectionPattern(int i, int i2, Huffman.Node node) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = POSITION_DETECTION_PATTERN[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                node.set(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    public static void embedVerticalSeparationPattern(int i, int i2, Huffman.Node node) throws WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (!isEmpty(node.get(i, i4))) {
                throw new WriterException();
            }
            node.set(i, i4, 0);
        }
    }

    public static boolean isEmpty(int i) {
        return i == -1;
    }
}
