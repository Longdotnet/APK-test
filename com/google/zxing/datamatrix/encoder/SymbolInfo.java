package com.google.zxing.datamatrix.encoder;

import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;

/* JADX INFO: loaded from: classes3.dex */
public class SymbolInfo {
    public static final SymbolInfo[] symbols = {new SymbolInfo(3, 5, 8, 8, 1, 3, 5, false), new SymbolInfo(5, 7, 10, 10, 1, 5, 7, false), new SymbolInfo(5, 7, 16, 6, 1, 5, 7, true), new SymbolInfo(8, 10, 12, 12, 1, 8, 10, false), new SymbolInfo(10, 11, 14, 6, 2, 10, 11, true), new SymbolInfo(12, 12, 14, 14, 1, 12, 12, false), new SymbolInfo(16, 14, 24, 10, 1, 16, 14, true), new SymbolInfo(18, 14, 16, 16, 1, 18, 14, false), new SymbolInfo(22, 18, 18, 18, 1, 22, 18, false), new SymbolInfo(22, 18, 16, 10, 2, 22, 18, true), new SymbolInfo(30, 20, 20, 20, 1, 30, 20, false), new SymbolInfo(32, 24, 16, 14, 2, 32, 24, true), new SymbolInfo(36, 24, 22, 22, 1, 36, 24, false), new SymbolInfo(44, 28, 24, 24, 1, 44, 28, false), new SymbolInfo(49, 28, 22, 14, 2, 49, 28, true), new SymbolInfo(62, 36, 14, 14, 4, 62, 36, false), new SymbolInfo(86, 42, 16, 16, 4, 86, 42, false), new SymbolInfo(114, 48, 18, 18, 4, 114, 48, false), new SymbolInfo(144, 56, 20, 20, 4, 144, 56, false), new SymbolInfo(174, 68, 22, 22, 4, 174, 68, false), new SymbolInfo(204, 84, 24, 24, 4, TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE, 42, false), new SymbolInfo(280, 112, 14, 14, 16, 140, 56, false), new SymbolInfo(368, 144, 16, 16, 16, 92, 36, false), new SymbolInfo(456, 192, 18, 18, 16, 114, 48, false), new SymbolInfo(576, 224, 20, 20, 16, 144, 56, false), new SymbolInfo(696, 272, 22, 22, 16, 174, 68, false), new SymbolInfo(816, 336, 24, 24, 16, 136, 56, false), new SymbolInfo(1050, 408, 18, 18, 36, 175, 68, false), new SymbolInfo(1304, 496, 20, 20, 36, 163, 62, false), new DataMatrixSymbolInfo144(1558, 620, 22, 22, 36, -1, 62, false)};
    public final int dataCapacity;
    public final int dataRegions;
    public final int errorCodewords;
    public final int matrixHeight;
    public final int matrixWidth;
    public final boolean rectangular;
    public final int rsBlockData;
    public final int rsBlockError;

    public SymbolInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.rectangular = z;
        this.dataCapacity = i;
        this.errorCodewords = i2;
        this.matrixWidth = i3;
        this.matrixHeight = i4;
        this.dataRegions = i5;
        this.rsBlockData = i6;
        this.rsBlockError = i7;
    }

    public static SymbolInfo lookup(int i, SymbolShapeHint symbolShapeHint) {
        SymbolInfo[] symbolInfoArr = symbols;
        for (int i2 = 0; i2 < 30; i2++) {
            SymbolInfo symbolInfo = symbolInfoArr[i2];
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && symbolInfo.rectangular) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.rectangular) && i <= symbolInfo.dataCapacity)) {
                return symbolInfo;
            }
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i)));
    }

    public int getDataLengthForInterleavedBlock(int i) {
        return this.rsBlockData;
    }

    public final int getHorizontalDataRegions() {
        int i = 1;
        int i2 = this.dataRegions;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2 && i2 != 4) {
                if (i2 == 16) {
                    return 4;
                }
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i;
    }

    public int getInterleavedBlockCount() {
        return this.dataCapacity / this.rsBlockData;
    }

    public final int getVerticalDataRegions() {
        int i = this.dataRegions;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.rectangular ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        int i = this.matrixWidth;
        sb.append(i);
        sb.append('x');
        int i2 = this.matrixHeight;
        sb.append(i2);
        sb.append(", symbol size ");
        sb.append((getHorizontalDataRegions() * i) + (getHorizontalDataRegions() << 1));
        sb.append('x');
        sb.append((getVerticalDataRegions() * i2) + (getVerticalDataRegions() << 1));
        sb.append(", symbol data size ");
        sb.append(getHorizontalDataRegions() * i);
        sb.append('x');
        sb.append(getVerticalDataRegions() * i2);
        sb.append(", codewords ");
        sb.append(this.dataCapacity);
        sb.append('+');
        sb.append(this.errorCodewords);
        return sb.toString();
    }
}
