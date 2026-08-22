package com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class IntMath$1 {
    public static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

    static {
        int[] iArr = new int[RoundingMode.values().length];
        $SwitchMap$java$math$RoundingMode = iArr;
        try {
            iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
