package com.google.zxing.pdf417.encoder;

import com.android.billingclient.api.zzda;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public final class BarcodeMatrix {
    public int currentRow;
    public final int height;
    public final zzda[] matrix;
    public final int width;

    public BarcodeMatrix(int i, int i2) {
        this.matrix = new zzda[i];
        for (int i3 = 0; i3 < i; i3++) {
            zzda[] zzdaVarArr = this.matrix;
            zzda zzdaVar = new zzda();
            zzdaVar.zza = new byte[((i2 + 4) * 17) + 1];
            zzdaVar.zzb = 0;
            zzdaVarArr[i3] = zzdaVar;
        }
        this.width = i2 * 17;
        this.height = i;
        this.currentRow = -1;
    }

    public final zzda getCurrentRow() {
        return this.matrix[this.currentRow];
    }

    public final byte[][] getScaledMatrix(int i, int i2) {
        int i3 = this.height;
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i3 * i2, this.width * i);
        int i4 = i3 * i2;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i4 - i5) - 1;
            byte[] bArr2 = (byte[]) this.matrix[i5 / i2].zza;
            int length = bArr2.length * i;
            byte[] bArr3 = new byte[length];
            for (int i7 = 0; i7 < length; i7++) {
                bArr3[i7] = bArr2[i7 / i];
            }
            bArr[i6] = bArr3;
        }
        return bArr;
    }
}
