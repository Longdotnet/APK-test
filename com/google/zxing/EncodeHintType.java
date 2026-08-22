package com.google.zxing;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class EncodeHintType {
    public static final /* synthetic */ EncodeHintType[] $VALUES;
    public static final EncodeHintType AZTEC_LAYERS;
    public static final EncodeHintType CHARACTER_SET;
    public static final EncodeHintType DATA_MATRIX_SHAPE;
    public static final EncodeHintType ERROR_CORRECTION;
    public static final EncodeHintType GS1_FORMAT;
    public static final EncodeHintType MARGIN;
    public static final EncodeHintType MAX_SIZE;
    public static final EncodeHintType MIN_SIZE;
    public static final EncodeHintType PDF417_COMPACT;
    public static final EncodeHintType PDF417_COMPACTION;
    public static final EncodeHintType PDF417_DIMENSIONS;
    public static final EncodeHintType QR_VERSION;

    static {
        EncodeHintType encodeHintType = new EncodeHintType("ERROR_CORRECTION", 0);
        ERROR_CORRECTION = encodeHintType;
        EncodeHintType encodeHintType2 = new EncodeHintType("CHARACTER_SET", 1);
        CHARACTER_SET = encodeHintType2;
        EncodeHintType encodeHintType3 = new EncodeHintType("DATA_MATRIX_SHAPE", 2);
        DATA_MATRIX_SHAPE = encodeHintType3;
        EncodeHintType encodeHintType4 = new EncodeHintType("MIN_SIZE", 3);
        MIN_SIZE = encodeHintType4;
        EncodeHintType encodeHintType5 = new EncodeHintType("MAX_SIZE", 4);
        MAX_SIZE = encodeHintType5;
        EncodeHintType encodeHintType6 = new EncodeHintType("MARGIN", 5);
        MARGIN = encodeHintType6;
        EncodeHintType encodeHintType7 = new EncodeHintType("PDF417_COMPACT", 6);
        PDF417_COMPACT = encodeHintType7;
        EncodeHintType encodeHintType8 = new EncodeHintType("PDF417_COMPACTION", 7);
        PDF417_COMPACTION = encodeHintType8;
        EncodeHintType encodeHintType9 = new EncodeHintType("PDF417_DIMENSIONS", 8);
        PDF417_DIMENSIONS = encodeHintType9;
        EncodeHintType encodeHintType10 = new EncodeHintType("AZTEC_LAYERS", 9);
        AZTEC_LAYERS = encodeHintType10;
        EncodeHintType encodeHintType11 = new EncodeHintType("QR_VERSION", 10);
        QR_VERSION = encodeHintType11;
        EncodeHintType encodeHintType12 = new EncodeHintType("GS1_FORMAT", 11);
        GS1_FORMAT = encodeHintType12;
        $VALUES = new EncodeHintType[]{encodeHintType, encodeHintType2, encodeHintType3, encodeHintType4, encodeHintType5, encodeHintType6, encodeHintType7, encodeHintType8, encodeHintType9, encodeHintType10, encodeHintType11, encodeHintType12};
    }

    public static EncodeHintType valueOf(String str) {
        return (EncodeHintType) Enum.valueOf(EncodeHintType.class, str);
    }

    public static EncodeHintType[] values() {
        return (EncodeHintType[]) $VALUES.clone();
    }
}
