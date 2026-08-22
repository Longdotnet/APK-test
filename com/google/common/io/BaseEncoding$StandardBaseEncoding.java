package com.google.common.io;

import java.util.Objects;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public class BaseEncoding$StandardBaseEncoding {
    public static final BaseEncoding$Base64Encoding BASE64 = new BaseEncoding$Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    public static final BaseEncoding$Base64Encoding BASE64_URL = new BaseEncoding$Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
    public final BaseEncoding$Alphabet alphabet;
    public final Character paddingChar;

    static {
        new BaseEncoding$StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
        new BaseEncoding$StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV");
        new BaseEncoding$StandardBaseEncoding() { // from class: com.google.common.io.BaseEncoding$Base16Encoding
            public final char[] encoding;

            {
                BaseEncoding$Alphabet baseEncoding$Alphabet = new BaseEncoding$Alphabet("base16()", "0123456789ABCDEF".toCharArray());
                this.encoding = new char[512];
                char[] cArr = baseEncoding$Alphabet.chars;
                if (cArr.length != 16) {
                    throw new IllegalArgumentException();
                }
                for (int i = 0; i < 256; i++) {
                    char[] cArr2 = this.encoding;
                    cArr2[i] = cArr[i >>> 4];
                    cArr2[i | 256] = cArr[i & 15];
                }
            }

            @Override // com.google.common.io.BaseEncoding$StandardBaseEncoding
            public final int decodeTo(byte[] bArr, CharSequence charSequence) throws BaseEncoding$DecodingException {
                if (charSequence.length() % 2 == 1) {
                    throw new BaseEncoding$DecodingException("Invalid input length " + charSequence.length());
                }
                int i = 0;
                int i2 = 0;
                while (i < charSequence.length()) {
                    char cCharAt = charSequence.charAt(i);
                    BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
                    bArr[i2] = (byte) ((baseEncoding$Alphabet.decode(cCharAt) << 4) | baseEncoding$Alphabet.decode(charSequence.charAt(i + 1)));
                    i += 2;
                    i2++;
                }
                return i2;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    public BaseEncoding$StandardBaseEncoding(BaseEncoding$Alphabet baseEncoding$Alphabet, Character ch) {
        boolean z;
        this.alphabet = baseEncoding$Alphabet;
        if (ch != null) {
            char cCharValue = ch.charValue();
            byte[] bArr = baseEncoding$Alphabet.decodabet;
            if (cCharValue >= bArr.length || bArr[cCharValue] == -1) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        StringsKt__IndentKt.checkArgument(z, "Padding character %s was already in alphabet", ch);
        this.paddingChar = ch;
    }

    public final byte[] decode(String str) {
        try {
            CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(str);
            int length = (int) (((((long) this.alphabet.bitsPerChar) * ((long) charSequenceTrimTrailingPadding.length())) + 7) / 8);
            byte[] bArr = new byte[length];
            int iDecodeTo = decodeTo(bArr, charSequenceTrimTrailingPadding);
            if (iDecodeTo == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[iDecodeTo];
            System.arraycopy(bArr, 0, bArr2, 0, iDecodeTo);
            return bArr2;
        } catch (BaseEncoding$DecodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int decodeTo(byte[] bArr, CharSequence charSequence) throws BaseEncoding$DecodingException {
        int i;
        int i2;
        CharSequence charSequenceTrimTrailingPadding = trimTrailingPadding(charSequence);
        int length = charSequenceTrimTrailingPadding.length();
        BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
        if (!baseEncoding$Alphabet.validPadding[length % baseEncoding$Alphabet.charsPerChunk]) {
            throw new BaseEncoding$DecodingException("Invalid input length " + charSequenceTrimTrailingPadding.length());
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < charSequenceTrimTrailingPadding.length()) {
            long jDecode = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                i = baseEncoding$Alphabet.bitsPerChar;
                i2 = baseEncoding$Alphabet.charsPerChunk;
                if (i5 >= i2) {
                    break;
                }
                jDecode <<= i;
                if (i3 + i5 < charSequenceTrimTrailingPadding.length()) {
                    jDecode |= (long) baseEncoding$Alphabet.decode(charSequenceTrimTrailingPadding.charAt(i6 + i3));
                    i6++;
                }
                i5++;
            }
            int i7 = baseEncoding$Alphabet.bytesPerChunk;
            int i8 = (i7 * 8) - (i6 * i);
            int i9 = (i7 - 1) * 8;
            while (i9 >= i8) {
                bArr[i4] = (byte) ((jDecode >>> i9) & 255);
                i9 -= 8;
                i4++;
            }
            i3 += i2;
        }
        return i4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BaseEncoding$StandardBaseEncoding)) {
            return false;
        }
        BaseEncoding$StandardBaseEncoding baseEncoding$StandardBaseEncoding = (BaseEncoding$StandardBaseEncoding) obj;
        return this.alphabet.equals(baseEncoding$StandardBaseEncoding.alphabet) && Objects.equals(this.paddingChar, baseEncoding$StandardBaseEncoding.paddingChar);
    }

    public final int hashCode() {
        return this.alphabet.hashCode() ^ Objects.hashCode(this.paddingChar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
        sb.append(baseEncoding$Alphabet);
        if (8 % baseEncoding$Alphabet.bitsPerChar != 0) {
            Character ch = this.paddingChar;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    public final CharSequence trimTrailingPadding(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.paddingChar;
        if (ch == null) {
            return charSequence;
        }
        char cCharValue = ch.charValue();
        int length = charSequence.length() - 1;
        while (length >= 0 && charSequence.charAt(length) == cCharValue) {
            length--;
        }
        return charSequence.subSequence(0, length + 1);
    }

    public BaseEncoding$StandardBaseEncoding(String str, String str2) {
        this(new BaseEncoding$Alphabet(str, str2.toCharArray()), (Character) '=');
    }
}
