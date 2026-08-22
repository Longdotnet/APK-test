package com.google.common.io;

import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public final class BaseEncoding$Base64Encoding extends BaseEncoding$StandardBaseEncoding {
    public BaseEncoding$Base64Encoding(String str, String str2) {
        BaseEncoding$Alphabet baseEncoding$Alphabet = new BaseEncoding$Alphabet(str, str2.toCharArray());
        super(baseEncoding$Alphabet, (Character) '=');
        if (baseEncoding$Alphabet.chars.length != 64) {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.google.common.io.BaseEncoding$StandardBaseEncoding
    public final int decodeTo(byte[] bArr, CharSequence charSequence) throws BaseEncoding$DecodingException {
        CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(charSequence);
        int length = charSequenceTrimTrailingPadding.length();
        BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
        if (!baseEncoding$Alphabet.validPadding[length % baseEncoding$Alphabet.charsPerChunk]) {
            throw new BaseEncoding$DecodingException("Invalid input length " + charSequenceTrimTrailingPadding.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequenceTrimTrailingPadding.length()) {
            int i3 = i + 2;
            int iDecode = (baseEncoding$Alphabet.decode(charSequenceTrimTrailingPadding.charAt(i + 1)) << 12) | (baseEncoding$Alphabet.decode(charSequenceTrimTrailingPadding.charAt(i)) << 18);
            int i4 = i2 + 1;
            bArr[i2] = (byte) (iDecode >>> 16);
            if (i3 < charSequenceTrimTrailingPadding.length()) {
                int i5 = i + 3;
                int iDecode2 = iDecode | (baseEncoding$Alphabet.decode(charSequenceTrimTrailingPadding.charAt(i3)) << 6);
                int i6 = i2 + 2;
                bArr[i4] = (byte) ((iDecode2 >>> 8) & 255);
                if (i5 < charSequenceTrimTrailingPadding.length()) {
                    i += 4;
                    i2 += 3;
                    bArr[i6] = (byte) ((iDecode2 | baseEncoding$Alphabet.decode(charSequenceTrimTrailingPadding.charAt(i5))) & 255);
                } else {
                    i2 = i6;
                    i = i5;
                }
            } else {
                i2 = i4;
                i = i3;
            }
        }
        return i2;
    }

    public final void encodeTo(Appendable appendable, byte[] bArr, int i) {
        BaseEncoding$Alphabet baseEncoding$Alphabet;
        int i2 = 0;
        StringsKt__IndentKt.checkPositionIndexes(0, i, bArr.length);
        int i3 = i;
        int i4 = 0;
        while (true) {
            baseEncoding$Alphabet = this.alphabet;
            if (i3 < 3) {
                break;
            }
            int i5 = i4 + 2;
            int i6 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16);
            i4 += 3;
            int i7 = i6 | (bArr[i5] & 255);
            StringBuilder sb = (StringBuilder) appendable;
            sb.append(baseEncoding$Alphabet.chars[i7 >>> 18]);
            char[] cArr = baseEncoding$Alphabet.chars;
            sb.append(cArr[(i7 >>> 12) & 63]);
            sb.append(cArr[(i7 >>> 6) & 63]);
            sb.append(cArr[i7 & 63]);
            i3 -= 3;
        }
        if (i4 < i) {
            int i8 = i - i4;
            StringBuilder sb2 = (StringBuilder) appendable;
            StringsKt__IndentKt.checkPositionIndexes(i4, i4 + i8, bArr.length);
            if (i8 > baseEncoding$Alphabet.bytesPerChunk) {
                throw new IllegalArgumentException();
            }
            long j = 0;
            for (int i9 = 0; i9 < i8; i9++) {
                j = (j | ((long) (bArr[i4 + i9] & 255))) << 8;
            }
            int i10 = baseEncoding$Alphabet.bitsPerChar;
            int i11 = ((i8 + 1) * 8) - i10;
            while (i2 < i8 * 8) {
                sb2.append(baseEncoding$Alphabet.chars[((int) (j >>> (i11 - i2))) & baseEncoding$Alphabet.mask]);
                i2 += i10;
            }
            Character ch = this.paddingChar;
            if (ch != null) {
                while (i2 < baseEncoding$Alphabet.bytesPerChunk * 8) {
                    sb2.append(ch.charValue());
                    i2 += i10;
                }
            }
        }
    }
}
