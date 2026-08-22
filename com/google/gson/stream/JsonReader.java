package com.google.gson.stream;

import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class JsonReader implements Closeable {
    public final Reader in;
    public int[] pathIndices;
    public String[] pathNames;
    public long peekedLong;
    public int peekedNumberLength;
    public String peekedString;
    public int[] stack;
    public boolean lenient = false;
    public final char[] buffer = new char[1024];
    public int pos = 0;
    public int limit = 0;
    public int lineNumber = 0;
    public int lineStart = 0;
    public int peeked = 0;
    public int stackSize = 1;

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    public final void checkLenient() throws MalformedJsonException {
        if (this.lenient) {
            return;
        }
        syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0179 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:116:0x017a  */
    /* JADX WARN: Code duplicated, block: B:119:0x018a  */
    /* JADX WARN: Code duplicated, block: B:122:0x0190  */
    /* JADX WARN: Code duplicated, block: B:125:0x019b  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a1 A[PHI: r2 r4
  0x01a1: PHI (r2v46 int) = (r2v45 int), (r2v48 int) binds: [B:118:0x0188, B:125:0x019b] A[DONT_GENERATE, DONT_INLINE]
  0x01a1: PHI (r4v10 int) = (r4v9 int), (r4v12 int) binds: [B:118:0x0188, B:125:0x019b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:128:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:170:0x0216  */
    /* JADX WARN: Code duplicated, block: B:171:0x0218  */
    /* JADX WARN: Code duplicated, block: B:183:0x0239 A[DONT_INVERT, PHI: r1
  0x0239: PHI (r1v65 int) = (r1v64 int), (r1v68 int) binds: [B:169:0x0214, B:175:0x0221] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:184:0x023b  */
    /* JADX WARN: Code duplicated, block: B:197:0x025e  */
    /* JADX WARN: Code duplicated, block: B:199:0x0264  */
    /* JADX WARN: Code duplicated, block: B:202:0x0269  */
    /* JADX WARN: Code duplicated, block: B:207:0x0279 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:208:0x027a  */
    /* JADX WARN: Code duplicated, block: B:210:0x0284  */
    /* JADX WARN: Code duplicated, block: B:212:0x028c  */
    /* JADX WARN: Code duplicated, block: B:222:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:231:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:233:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:275:0x018d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x018d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e6  */
    public final int doPeek() {
        int iNextNonWhitespace;
        int i;
        int iNextNonWhitespace2;
        int i2;
        String str;
        String str2;
        int i3;
        char c;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        char c2;
        int i8;
        int i9;
        int i10;
        int i11;
        int[] iArr = this.stack;
        int i12 = 1;
        int i13 = this.stackSize - 1;
        int i14 = iArr[i13];
        char[] cArr = this.buffer;
        if (i14 == 1) {
            iArr[i13] = 2;
        } else if (i14 == 2) {
            int iNextNonWhitespace3 = nextNonWhitespace(true);
            if (iNextNonWhitespace3 != 44) {
                if (iNextNonWhitespace3 != 59) {
                    if (iNextNonWhitespace3 == 93) {
                        this.peeked = 4;
                        return 4;
                    }
                    syntaxError("Unterminated array");
                    throw null;
                }
                checkLenient();
            }
        } else {
            if (i14 == 3 || i14 == 5) {
                iArr[i13] = 4;
                if (i14 == 5 && (iNextNonWhitespace = nextNonWhitespace(true)) != 44) {
                    if (iNextNonWhitespace != 59) {
                        if (iNextNonWhitespace == 125) {
                            this.peeked = 2;
                            return 2;
                        }
                        syntaxError("Unterminated object");
                        throw null;
                    }
                    checkLenient();
                }
                int iNextNonWhitespace4 = nextNonWhitespace(true);
                if (iNextNonWhitespace4 == 34) {
                    this.peeked = 13;
                    return 13;
                }
                if (iNextNonWhitespace4 == 39) {
                    checkLenient();
                    this.peeked = 12;
                    return 12;
                }
                if (iNextNonWhitespace4 == 125) {
                    if (i14 != 5) {
                        this.peeked = 2;
                        return 2;
                    }
                    syntaxError("Expected name");
                    throw null;
                }
                checkLenient();
                this.pos--;
                if (isLiteral((char) iNextNonWhitespace4)) {
                    this.peeked = 14;
                    return 14;
                }
                syntaxError("Expected name");
                throw null;
            }
            if (i14 != 4) {
                if (i14 == 6) {
                    if (this.lenient) {
                        nextNonWhitespace(true);
                        int i15 = this.pos;
                        int i16 = i15 - 1;
                        this.pos = i16;
                        if ((i15 + 4 <= this.limit || fillBuffer(5)) && cArr[i16] == ')' && cArr[i15] == ']' && cArr[i15 + 1] == '}' && cArr[i15 + 2] == '\'' && cArr[i15 + 3] == '\n') {
                            this.pos += 5;
                        }
                    }
                    this.stack[this.stackSize - 1] = 7;
                } else if (i14 == 7) {
                    i = 0;
                    if (nextNonWhitespace(false) == -1) {
                        this.peeked = 17;
                        return 17;
                    }
                    checkLenient();
                    this.pos--;
                } else {
                    i = 0;
                    if (i14 == 8) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                }
                iNextNonWhitespace2 = nextNonWhitespace(true);
                if (iNextNonWhitespace2 != 34) {
                    this.peeked = 9;
                    return 9;
                }
                if (iNextNonWhitespace2 != 39) {
                    checkLenient();
                    this.peeked = 8;
                    return 8;
                }
                if (iNextNonWhitespace2 != 44 || iNextNonWhitespace2 == 59) {
                    i2 = 1;
                } else {
                    if (iNextNonWhitespace2 == 91) {
                        this.peeked = 3;
                        return 3;
                    }
                    if (iNextNonWhitespace2 != 93) {
                        if (iNextNonWhitespace2 == 123) {
                            this.peeked = 1;
                            return 1;
                        }
                        int i17 = this.pos - 1;
                        this.pos = i17;
                        char c3 = cArr[i17];
                        if (c3 == 't' || c3 == 'T') {
                            str = "true";
                            str2 = "TRUE";
                            i3 = 5;
                        } else {
                            if (c3 != 'f' && c3 != 'F') {
                                if (c3 != 'n' && c3 != 'N') {
                                    i3 = i;
                                    break;
                                }
                                str = "null";
                                str2 = "NULL";
                                i3 = 7;
                                if (i3 != 0) {
                                    return i3;
                                }
                                i4 = this.pos;
                                i5 = this.limit;
                                i6 = i;
                                i7 = i6;
                                int i18 = i7;
                                z = true;
                                long j = 0;
                                while (true) {
                                    if (i4 + i7 != i5) {
                                        c2 = cArr[i4 + i7];
                                        if (c2 != '+') {
                                            if (c2 != 'E' || c2 == 'e') {
                                                i8 = i5;
                                                i9 = 6;
                                                if (i6 != 2 || i6 == 4) {
                                                    i6 = 5;
                                                    i7++;
                                                    i5 = i8;
                                                    i12 = 1;
                                                }
                                            } else if (c2 == '-') {
                                                i8 = i5;
                                                i9 = 6;
                                                if (i6 == 0) {
                                                    i6 = 1;
                                                    i18 = 1;
                                                } else {
                                                    if (i6 != 5) {
                                                    }
                                                    i6 = i9;
                                                }
                                                i7++;
                                                i5 = i8;
                                                i12 = 1;
                                            } else if (c2 == '.') {
                                                i8 = i5;
                                                i9 = 6;
                                                if (i6 == 2) {
                                                    i6 = 3;
                                                    i7++;
                                                    i5 = i8;
                                                    i12 = 1;
                                                }
                                            } else if (c2 >= '0' && c2 <= '9') {
                                                if (i6 == i12 || i6 == 0) {
                                                    i8 = i5;
                                                    i9 = 6;
                                                    j = -(c2 - '0');
                                                    i6 = 2;
                                                } else if (i6 != 2) {
                                                    i8 = i5;
                                                    if (i6 == 3) {
                                                        i9 = 6;
                                                        i6 = 4;
                                                    } else {
                                                        i9 = 6;
                                                        if (i6 == 5 || i6 == 6) {
                                                            i6 = 7;
                                                        }
                                                    }
                                                } else if (j != 0) {
                                                    i8 = i5;
                                                    long j2 = (10 * j) - ((long) (c2 - '0'));
                                                    z &= j > -922337203685477580L || (j == -922337203685477580L && j2 < j);
                                                    j = j2;
                                                    i9 = 6;
                                                }
                                                i7++;
                                                i5 = i8;
                                                i12 = 1;
                                            } else if (!isLiteral(c2)) {
                                                i11 = 2;
                                                if (i6 != 2) {
                                                    if (i6 != i11 || i6 == 4 || i6 == 7) {
                                                        this.peekedNumberLength = i7;
                                                        i10 = 16;
                                                        this.peeked = 16;
                                                    }
                                                } else if (z || ((j == Long.MIN_VALUE && i18 == 0) || (j == 0 && i18 != 0))) {
                                                    i11 = 2;
                                                    if (i6 != i11) {
                                                    }
                                                    this.peekedNumberLength = i7;
                                                    i10 = 16;
                                                    this.peeked = 16;
                                                } else {
                                                    if (i18 == 0) {
                                                        j = -j;
                                                    }
                                                    this.peekedLong = j;
                                                    this.pos += i7;
                                                    i10 = 15;
                                                    this.peeked = 15;
                                                }
                                            }
                                            if (i10 != 0) {
                                                return i10;
                                            }
                                            if (isLiteral(cArr[this.pos])) {
                                                syntaxError("Expected value");
                                                throw null;
                                            }
                                            checkLenient();
                                            this.peeked = 10;
                                            return 10;
                                        }
                                        i8 = i5;
                                        i9 = 6;
                                        if (i6 != 5) {
                                        }
                                        i6 = i9;
                                        i7++;
                                        i5 = i8;
                                        i12 = 1;
                                    } else if (i7 != cArr.length) {
                                        if (!fillBuffer(i7 + 1)) {
                                            int i19 = this.pos;
                                            i5 = this.limit;
                                            i4 = i19;
                                            c2 = cArr[i4 + i7];
                                            if (c2 != '+') {
                                                if (c2 != 'E') {
                                                    i8 = i5;
                                                    i9 = 6;
                                                    if (i6 != 2) {
                                                    }
                                                    i6 = 5;
                                                    i7++;
                                                    i5 = i8;
                                                    i12 = 1;
                                                } else {
                                                    i8 = i5;
                                                    i9 = 6;
                                                    if (i6 != 2) {
                                                    }
                                                    i6 = 5;
                                                    i7++;
                                                    i5 = i8;
                                                    i12 = 1;
                                                }
                                                if (i10 != 0) {
                                                    return i10;
                                                }
                                                if (isLiteral(cArr[this.pos])) {
                                                    syntaxError("Expected value");
                                                    throw null;
                                                }
                                                checkLenient();
                                                this.peeked = 10;
                                                return 10;
                                            }
                                            i8 = i5;
                                            i9 = 6;
                                            if (i6 != 5) {
                                            }
                                            i6 = i9;
                                            i7++;
                                            i5 = i8;
                                            i12 = 1;
                                        }
                                        i11 = 2;
                                        if (i6 != 2) {
                                            if (i6 != i11) {
                                            }
                                            this.peekedNumberLength = i7;
                                            i10 = 16;
                                            this.peeked = 16;
                                        } else {
                                            if (z) {
                                            }
                                            i11 = 2;
                                            if (i6 != i11) {
                                            }
                                            this.peekedNumberLength = i7;
                                            i10 = 16;
                                            this.peeked = 16;
                                        }
                                        if (i10 != 0) {
                                            return i10;
                                        }
                                        if (isLiteral(cArr[this.pos])) {
                                            syntaxError("Expected value");
                                            throw null;
                                        }
                                        checkLenient();
                                        this.peeked = 10;
                                        return 10;
                                    }
                                    i10 = 0;
                                    if (i10 != 0) {
                                        return i10;
                                    }
                                    if (isLiteral(cArr[this.pos])) {
                                        syntaxError("Expected value");
                                        throw null;
                                    }
                                    checkLenient();
                                    this.peeked = 10;
                                    return 10;
                                }
                            }
                            str = "false";
                            str2 = "FALSE";
                            i3 = 6;
                        }
                        int length = str.length();
                        int i20 = 1;
                        while (true) {
                            if (i20 >= length) {
                                if ((this.pos + length >= this.limit && !fillBuffer(length + 1)) || !isLiteral(cArr[this.pos + length])) {
                                    this.pos += length;
                                    this.peeked = i3;
                                    break;
                                }
                                break;
                            }
                            if ((this.pos + i20 < this.limit || fillBuffer(i20 + 1)) && ((c = cArr[this.pos + i20]) == str.charAt(i20) || c == str2.charAt(i20))) {
                                i20++;
                            }
                            i3 = i;
                            break;
                        }
                        if (i3 != 0) {
                            return i3;
                        }
                        i4 = this.pos;
                        i5 = this.limit;
                        i6 = i;
                        i7 = i6;
                        int i110 = i7;
                        z = true;
                        long j3 = 0;
                        while (true) {
                            if (i4 + i7 != i5) {
                                c2 = cArr[i4 + i7];
                                if (c2 != '+') {
                                    if (c2 != 'E') {
                                        i8 = i5;
                                        i9 = 6;
                                        if (i6 != 2) {
                                        }
                                        i6 = 5;
                                        i7++;
                                        i5 = i8;
                                        i12 = 1;
                                    } else {
                                        i8 = i5;
                                        i9 = 6;
                                        if (i6 != 2) {
                                        }
                                        i6 = 5;
                                        i7++;
                                        i5 = i8;
                                        i12 = 1;
                                    }
                                    if (i10 != 0) {
                                        return i10;
                                    }
                                    if (isLiteral(cArr[this.pos])) {
                                        syntaxError("Expected value");
                                        throw null;
                                    }
                                    checkLenient();
                                    this.peeked = 10;
                                    return 10;
                                }
                                i8 = i5;
                                i9 = 6;
                                if (i6 != 5) {
                                }
                                i6 = i9;
                                i7++;
                                i5 = i8;
                                i12 = 1;
                            } else if (i7 != cArr.length) {
                                if (!fillBuffer(i7 + 1)) {
                                    int i111 = this.pos;
                                    i5 = this.limit;
                                    i4 = i111;
                                    c2 = cArr[i4 + i7];
                                    if (c2 != '+') {
                                        if (c2 != 'E') {
                                            i8 = i5;
                                            i9 = 6;
                                            if (i6 != 2) {
                                            }
                                            i6 = 5;
                                            i7++;
                                            i5 = i8;
                                            i12 = 1;
                                        } else {
                                            i8 = i5;
                                            i9 = 6;
                                            if (i6 != 2) {
                                            }
                                            i6 = 5;
                                            i7++;
                                            i5 = i8;
                                            i12 = 1;
                                        }
                                        if (i10 != 0) {
                                            return i10;
                                        }
                                        if (isLiteral(cArr[this.pos])) {
                                            syntaxError("Expected value");
                                            throw null;
                                        }
                                        checkLenient();
                                        this.peeked = 10;
                                        return 10;
                                    }
                                    i8 = i5;
                                    i9 = 6;
                                    if (i6 != 5) {
                                    }
                                    i6 = i9;
                                    i7++;
                                    i5 = i8;
                                    i12 = 1;
                                }
                                i11 = 2;
                                if (i6 != 2) {
                                    if (i6 != i11) {
                                    }
                                    this.peekedNumberLength = i7;
                                    i10 = 16;
                                    this.peeked = 16;
                                } else {
                                    if (z) {
                                    }
                                    i11 = 2;
                                    if (i6 != i11) {
                                    }
                                    this.peekedNumberLength = i7;
                                    i10 = 16;
                                    this.peeked = 16;
                                }
                                if (i10 != 0) {
                                    return i10;
                                }
                                if (isLiteral(cArr[this.pos])) {
                                    syntaxError("Expected value");
                                    throw null;
                                }
                                checkLenient();
                                this.peeked = 10;
                                return 10;
                            }
                            i10 = 0;
                            if (i10 != 0) {
                                return i10;
                            }
                            if (isLiteral(cArr[this.pos])) {
                                syntaxError("Expected value");
                                throw null;
                            }
                            checkLenient();
                            this.peeked = 10;
                            return 10;
                        }
                    }
                    i2 = 1;
                    if (i14 == 1) {
                        this.peeked = 4;
                        return 4;
                    }
                }
                if (i14 == i2 && i14 != 2) {
                    syntaxError("Unexpected value");
                    throw null;
                }
                checkLenient();
                this.pos -= i2;
                this.peeked = 7;
                return 7;
            }
            iArr[i13] = 5;
            int iNextNonWhitespace5 = nextNonWhitespace(true);
            if (iNextNonWhitespace5 != 58) {
                if (iNextNonWhitespace5 != 61) {
                    syntaxError("Expected ':'");
                    throw null;
                }
                checkLenient();
                if (this.pos < this.limit || fillBuffer(1)) {
                    int i21 = this.pos;
                    if (cArr[i21] == '>') {
                        this.pos = i21 + 1;
                    }
                }
            }
        }
        i = 0;
        iNextNonWhitespace2 = nextNonWhitespace(true);
        if (iNextNonWhitespace2 != 34) {
            this.peeked = 9;
            return 9;
        }
        if (iNextNonWhitespace2 != 39) {
            checkLenient();
            this.peeked = 8;
            return 8;
        }
        if (iNextNonWhitespace2 != 44) {
            i2 = 1;
        } else {
            i2 = 1;
        }
        if (i14 == i2) {
        }
        checkLenient();
        this.pos -= i2;
        this.peeked = 7;
        return 7;
    }

    public final boolean fillBuffer(int i) throws IOException {
        int i2;
        int i3;
        int i4 = this.lineStart;
        int i5 = this.pos;
        this.lineStart = i4 - i5;
        int i6 = this.limit;
        char[] cArr = this.buffer;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.limit = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int i8 = this.limit;
            int i9 = this.in.read(cArr, i8, cArr.length - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.limit + i9;
            this.limit = i2;
            if (this.lineNumber == 0 && (i3 = this.lineStart) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    public final boolean hasNext() {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        return (iDoPeek == 2 || iDoPeek == 4) ? false : true;
    }

    public final boolean isLiteral(char c) throws MalformedJsonException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    public final int nextNonWhitespace(boolean z) throws IOException {
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (!fillBuffer(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + locationString());
                }
                i = this.pos;
                i2 = this.limit;
            }
            int i3 = i + 1;
            char[] cArr = this.buffer;
            char c = cArr[i];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.pos = i3;
                    if (i3 == i2) {
                        this.pos = i;
                        boolean zFillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!zFillBuffer) {
                            return c;
                        }
                    }
                    checkLenient();
                    int i4 = this.pos;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.pos = i4 + 1;
                        while (true) {
                            if (this.pos + 2 > this.limit && !fillBuffer(2)) {
                                syntaxError("Unterminated comment");
                                throw null;
                            }
                            int i5 = this.pos;
                            if (cArr[i5] != '\n') {
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= 2) {
                                        i = this.pos + 2;
                                        i2 = this.limit;
                                        break;
                                    }
                                    if (cArr[this.pos + i6] != "*/".charAt(i6)) {
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                this.lineNumber++;
                                this.lineStart = i5 + 1;
                            }
                            this.pos++;
                        }
                    } else {
                        if (c2 != '/') {
                            return c;
                        }
                        this.pos = i4 + 1;
                        skipToEndOfLine();
                        i = this.pos;
                        i2 = this.limit;
                    }
                } else {
                    if (c != '#') {
                        this.pos = i3;
                        return c;
                    }
                    this.pos = i3;
                    checkLenient();
                    skipToEndOfLine();
                    i = this.pos;
                    i2 = this.limit;
                }
            }
            i = i3;
        }
    }

    public final String nextQuotedValue(char c) {
        int i;
        char[] cArr;
        int i2;
        StringBuilder sb = null;
        do {
            int i3 = this.pos;
            int i4 = this.limit;
            while (true) {
                int i5 = i4;
                i = i3;
                while (true) {
                    cArr = this.buffer;
                    if (i3 < i5) {
                        int i6 = i3 + 1;
                        char c2 = cArr[i3];
                        if (c2 == c) {
                            this.pos = i6;
                            int i7 = (i6 - i) - 1;
                            if (sb == null) {
                                return new String(cArr, i, i7);
                            }
                            sb.append(cArr, i, i7);
                            return sb.toString();
                        }
                        if (c2 == '\\') {
                            this.pos = i6;
                            int i8 = i6 - i;
                            int i9 = i8 - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max(i8 * 2, 16));
                            }
                            sb.append(cArr, i, i9);
                            if (this.pos == this.limit && !fillBuffer(1)) {
                                syntaxError("Unterminated escape sequence");
                                throw null;
                            }
                            int i10 = this.pos;
                            int i11 = i10 + 1;
                            this.pos = i11;
                            char[] cArr2 = this.buffer;
                            char c3 = cArr2[i10];
                            if (c3 == '\n') {
                                this.lineNumber++;
                                this.lineStart = i11;
                            } else if (c3 != '\"' && c3 != '\'' && c3 != '/' && c3 != '\\') {
                                if (c3 == 'b') {
                                    c3 = '\b';
                                } else if (c3 == 'f') {
                                    c3 = '\f';
                                } else if (c3 == 'n') {
                                    c3 = '\n';
                                } else if (c3 == 'r') {
                                    c3 = '\r';
                                } else if (c3 == 't') {
                                    c3 = '\t';
                                } else {
                                    if (c3 != 'u') {
                                        syntaxError("Invalid escape sequence");
                                        throw null;
                                    }
                                    if (i10 + 5 > this.limit && !fillBuffer(4)) {
                                        syntaxError("Unterminated escape sequence");
                                        throw null;
                                    }
                                    int i12 = this.pos;
                                    int i13 = i12 + 4;
                                    char c4 = 0;
                                    while (i12 < i13) {
                                        char c5 = cArr2[i12];
                                        char c6 = (char) (c4 << 4);
                                        if (c5 >= '0' && c5 <= '9') {
                                            i2 = c5 - '0';
                                        } else if (c5 >= 'a' && c5 <= 'f') {
                                            i2 = c5 - 'W';
                                        } else {
                                            if (c5 < 'A' || c5 > 'F') {
                                                throw new NumberFormatException("\\u".concat(new String(cArr2, this.pos, 4)));
                                            }
                                            i2 = c5 - '7';
                                        }
                                        c4 = (char) (i2 + c6);
                                        i12++;
                                    }
                                    this.pos += 4;
                                    c3 = c4;
                                }
                            }
                            sb.append(c3);
                            i3 = this.pos;
                            i4 = this.limit;
                        } else {
                            if (c2 == '\n') {
                                this.lineNumber++;
                                this.lineStart = i6;
                            }
                            i3 = i6;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i3 - i) * 2, 16));
            }
            sb.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (fillBuffer(1));
        syntaxError("Unterminated string");
        throw null;
    }

    public final String nextString() {
        String str;
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 10) {
            str = nextUnquotedValue();
        } else if (iDoPeek == 8) {
            str = nextQuotedValue('\'');
        } else if (iDoPeek == 9) {
            str = nextQuotedValue('\"');
        } else if (iDoPeek == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (iDoPeek == 15) {
            str = Long.toString(this.peekedLong);
        } else {
            if (iDoPeek != 16) {
                throw new IllegalStateException("Expected a string but was " + BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf(peek()) + locationString());
            }
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    public final String nextUnquotedValue() {
        String string;
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = this.pos;
                int i4 = i3 + i2;
                int i5 = this.limit;
                char[] cArr = this.buffer;
                if (i4 < i5) {
                    char c = cArr[i3 + i2];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        checkLenient();
                    }
                    i = i2;
                } else if (i2 >= cArr.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(cArr, this.pos, i2);
                    this.pos += i2;
                    if (!fillBuffer(1)) {
                    }
                } else if (!fillBuffer(i2 + 1)) {
                    i = i2;
                }
                if (sb == null) {
                    string = new String(cArr, this.pos, i);
                } else {
                    sb.append(cArr, this.pos, i);
                    string = sb.toString();
                }
                this.pos += i;
                return string;
            }
        }
    }

    public final int peek() {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        switch (iDoPeek) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void push(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.stack;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.stack = Arrays.copyOf(iArr, i3);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i3);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i3);
        }
        int[] iArr2 = this.stack;
        int i4 = this.stackSize;
        this.stackSize = i4 + 1;
        iArr2[i4] = i;
    }

    public final void skipToEndOfLine() {
        char c;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            int i = this.pos;
            int i2 = i + 1;
            this.pos = i2;
            c = this.buffer[i];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i2;
                return;
            }
        } while (c != '\r');
    }

    public final void syntaxError(String str) throws MalformedJsonException {
        throw new MalformedJsonException(str + locationString());
    }

    public final String toString() {
        return "JsonReader" + locationString();
    }

    public final String locationString() {
        StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(" at line ", this.lineNumber + 1, " column ", (this.pos - this.lineStart) + 1, CyjpdoedCdLTIO.VYyJMtKWXZRQmt);
        StringBuilder sb = new StringBuilder("$");
        int i = this.stackSize;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.stack[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.pathIndices[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.pathNames[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        sbM.append(sb.toString());
        return sbM.toString();
    }
}
