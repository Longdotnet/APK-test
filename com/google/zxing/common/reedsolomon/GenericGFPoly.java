package com.google.zxing.common.reedsolomon;

/* JADX INFO: loaded from: classes3.dex */
public final class GenericGFPoly {
    public final int[] coefficients;
    public final GenericGF field;

    public GenericGFPoly(GenericGF genericGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.field = genericGF;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.coefficients = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.coefficients = new int[]{0};
            return;
        }
        int i2 = length - i;
        int[] iArr2 = new int[i2];
        this.coefficients = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, i2);
    }

    public final GenericGFPoly addOrSubtract(GenericGFPoly genericGFPoly) {
        GenericGF genericGF = genericGFPoly.field;
        GenericGF genericGF2 = this.field;
        if (!genericGF2.equals(genericGF)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        int[] iArr = this.coefficients;
        if (iArr[0] == 0) {
            return genericGFPoly;
        }
        int[] iArr2 = genericGFPoly.coefficients;
        if (iArr2[0] == 0) {
            return this;
        }
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = iArr2[i - length] ^ iArr[i];
        }
        return new GenericGFPoly(genericGF2, iArr3);
    }

    public final int getDegree() {
        return this.coefficients.length - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int[] iArr = this.coefficients;
            int i = iArr[(iArr.length - 1) - degree];
            if (i != 0) {
                if (i < 0) {
                    sb.append(" - ");
                    i = -i;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (degree == 0 || i != 1) {
                    GenericGF genericGF = this.field;
                    if (i == 0) {
                        genericGF.getClass();
                        throw new IllegalArgumentException();
                    }
                    int i2 = genericGF.logTable[i];
                    if (i2 == 0) {
                        sb.append('1');
                    } else if (i2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i2);
                    }
                }
                if (degree != 0) {
                    if (degree == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(degree);
                    }
                }
            }
        }
        return sb.toString();
    }
}
