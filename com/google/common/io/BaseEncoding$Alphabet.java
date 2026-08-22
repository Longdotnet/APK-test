package com.google.common.io;

import com.daerisoft.thespikerm.GamepadHandler_API19;
import java.math.RoundingMode;
import java.util.Arrays;
import okio.AsyncTimeout;

/* JADX INFO: loaded from: classes.dex */
public final class BaseEncoding$Alphabet {
    public final int bitsPerChar;
    public final int bytesPerChunk;
    public final char[] chars;
    public final int charsPerChunk;
    public final byte[] decodabet;
    public final int mask;
    public final String name;
    public final boolean[] validPadding;

    public BaseEncoding$Alphabet(String str, char[] cArr) {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            if (!(c < 128)) {
                throw new IllegalArgumentException(AsyncTimeout.Companion.lenientFormat("Non-ASCII character: %s", Character.valueOf(c)));
            }
            if (!(bArr[c] == -1)) {
                throw new IllegalArgumentException(AsyncTimeout.Companion.lenientFormat("Duplicate character: %s", Character.valueOf(c)));
            }
            bArr[c] = (byte) i;
        }
        this.name = str;
        this.chars = cArr;
        try {
            int iLog2 = GamepadHandler_API19.log2(cArr.length, RoundingMode.UNNECESSARY);
            this.bitsPerChar = iLog2;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iLog2);
            int i2 = 1 << (3 - iNumberOfTrailingZeros);
            this.charsPerChunk = i2;
            this.bytesPerChunk = iLog2 >> iNumberOfTrailingZeros;
            this.mask = cArr.length - 1;
            this.decodabet = bArr;
            boolean[] zArr = new boolean[i2];
            for (int i3 = 0; i3 < this.bytesPerChunk; i3++) {
                zArr[GamepadHandler_API19.divide(i3 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
            }
            this.validPadding = zArr;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
        }
    }

    public final int decode(char c) throws BaseEncoding$DecodingException {
        if (c > 127) {
            throw new BaseEncoding$DecodingException("Unrecognized character: 0x" + Integer.toHexString(c));
        }
        byte b = this.decodabet[c];
        if (b != -1) {
            return b;
        }
        if (c <= ' ' || c == 127) {
            throw new BaseEncoding$DecodingException("Unrecognized character: 0x" + Integer.toHexString(c));
        }
        throw new BaseEncoding$DecodingException("Unrecognized character: " + c);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BaseEncoding$Alphabet)) {
            return false;
        }
        BaseEncoding$Alphabet baseEncoding$Alphabet = (BaseEncoding$Alphabet) obj;
        baseEncoding$Alphabet.getClass();
        return Arrays.equals(this.chars, baseEncoding$Alphabet.chars);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.chars) + 1237;
    }

    public final String toString() {
        return this.name;
    }
}
