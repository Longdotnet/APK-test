package com.google.zxing.aztec.encoder;

/* JADX INFO: loaded from: classes3.dex */
public final class State {
    public static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    public final int binaryShiftByteCount;
    public final int bitCount;
    public final int mode;
    public final Token token;

    public State(Token token, int i, int i2, int i3) {
        this.token = token;
        this.mode = i;
        this.binaryShiftByteCount = i2;
        this.bitCount = i3;
    }

    public final State addBinaryShiftChar(int i) {
        int i2;
        Token simpleToken = this.token;
        int i3 = this.mode;
        int i4 = this.bitCount;
        if (i3 == 4 || i3 == 2) {
            int[] iArr = HighLevelEncoder.LATCH_TABLE[i3];
            i3 = 0;
            int i5 = iArr[0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            simpleToken.getClass();
            i4 += i7;
            simpleToken = new SimpleToken(simpleToken, i6, i7);
        }
        int i8 = this.binaryShiftByteCount;
        if (i8 == 0 || i8 == 31) {
            i2 = 18;
        } else {
            i2 = i8 == 62 ? 9 : 8;
        }
        int i9 = i8 + 1;
        State state = new State(simpleToken, i3, i9, i4 + i2);
        return i9 == 2078 ? state.endBinaryShift(i + 1) : state;
    }

    public final State endBinaryShift(int i) {
        int i2 = this.binaryShiftByteCount;
        if (i2 == 0) {
            return this;
        }
        Token token = this.token;
        token.getClass();
        return new State(new BinaryShiftToken(token, i - i2, i2), this.mode, 0, this.bitCount);
    }

    public final boolean isBetterThanOrEqualTo(State state) {
        int i;
        int i2 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i3 = state.binaryShiftByteCount;
        if (i3 > 0 && ((i = this.binaryShiftByteCount) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= state.bitCount;
    }

    public final State latchAndAppend(int i, int i2) {
        int i3 = this.bitCount;
        Token simpleToken = this.token;
        int i4 = this.mode;
        if (i != i4) {
            int i5 = HighLevelEncoder.LATCH_TABLE[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            simpleToken.getClass();
            i3 += i7;
            simpleToken = new SimpleToken(simpleToken, i6, i7);
        }
        int i8 = i == 2 ? 4 : 5;
        simpleToken.getClass();
        return new State(new SimpleToken(simpleToken, i2, i8), i, 0, i3 + i8);
    }

    public final State shiftAndAppend(int i, int i2) {
        int i3 = this.mode;
        int i4 = i3 == 2 ? 4 : 5;
        int i5 = HighLevelEncoder.SHIFT_TABLE[i3][i];
        Token token = this.token;
        token.getClass();
        return new State(new SimpleToken(new SimpleToken(token, i5, i4), i2, 5), i3, 0, this.bitCount + i4 + 5);
    }

    public final String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount));
    }
}
