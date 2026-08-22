package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes3.dex */
public final class DataMatrixSymbolInfo144 extends SymbolInfo {
    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public final int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? 156 : 155;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public final int getInterleavedBlockCount() {
        return 10;
    }
}
