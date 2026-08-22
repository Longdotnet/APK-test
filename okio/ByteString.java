package okio;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;
import okio.internal.ByteStringKt;

/* JADX INFO: loaded from: classes3.dex */
public class ByteString implements Serializable, Comparable {
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    public final byte[] data;
    public transient int hashCode;
    public transient String utf8;

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "byteCount < 0: ").toString());
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = objectInputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        ByteString byteString = new ByteString(bArr);
        Field field = ByteString.class.getDeclaredField("data");
        Intrinsics.checkNotNullExpressionValue(field, "field");
        field.setAccessible(true);
        field.set(this, byteString.data);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int compareTo(java.lang.Object r10) {
        /*
            r9 = this;
            okio.ByteString r10 = (okio.ByteString) r10
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r9.getSize$okio()
            int r1 = r10.getSize$okio()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L15:
            r5 = 1
            r6 = -1
            if (r4 >= r2) goto L30
            byte r7 = r9.internalGet$okio(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.internalGet$okio(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L2a
            int r4 = r4 + 1
            goto L15
        L2a:
            if (r7 >= r8) goto L2e
        L2c:
            r3 = r6
            goto L36
        L2e:
            r3 = r5
            goto L36
        L30:
            if (r0 != r1) goto L33
            goto L36
        L33:
            if (r0 >= r1) goto L2e
            goto L2c
        L36:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(java.lang.Object):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size$okio = byteString.getSize$okio();
            byte[] bArr = this.data;
            if (size$okio == bArr.length && byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int getSize$okio() {
        return this.data.length;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = ByteStringKt.HEX_DIGIT_CHARS;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public byte[] internalArray$okio() {
        return this.data;
    }

    public byte internalGet$okio(int i) {
        return this.data[i];
    }

    public boolean rangeEquals(int i, byte[] other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i >= 0) {
            byte[] bArr = this.data;
            if (i <= bArr.length - i3 && i2 >= 0 && i2 <= other.length - i3 && StringsKt__IndentKt.arrayRangeEquals(bArr, i, other, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public ByteString toAsciiLowercase() {
        byte b;
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b4 = bArrCopyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        bArrCopyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003c A[EDGE_INSN: B:22:0x003c->B:181:0x01a8 BREAK  A[LOOP:0: B:6:0x000f->B:239:0x000f]] */
    public String toString() {
        byte b;
        int i;
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        loop0: while (i2 < length) {
            byte b2 = bArr[i2];
            if (b2 < 0) {
                if ((b2 >> 5) != -2) {
                    if ((b2 >> 4) != -2) {
                        if ((b2 >> 3) != -2) {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                        int i5 = i2 + 3;
                        if (length > i5) {
                            byte b3 = bArr[i2 + 1];
                            if ((b3 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b4 = bArr[i2 + 2];
                            if ((b4 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b5 = bArr[i5];
                            if ((b5 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            int i6 = (((b5 ^ 3678080) ^ (b4 << 6)) ^ (b3 << 12)) ^ (b2 << 18);
                            if (i6 <= 1114111) {
                                if (55296 > i6 || 57343 < i6) {
                                    if (i6 >= 65536) {
                                        i = i4 + 1;
                                        if (i4 == 64) {
                                            break;
                                        }
                                        if ((i6 != 10 && i6 != 13 && ((i6 >= 0 && 31 >= i6) || (127 <= i6 && 159 >= i6))) || i6 == 65533) {
                                            i3 = -1;
                                            break;
                                        }
                                        i3 += i6 < 65536 ? 1 : 2;
                                        i2 += 4;
                                        i4 = i;
                                    } else {
                                        if (i4 == 64) {
                                            break;
                                        }
                                        i3 = -1;
                                        break;
                                    }
                                } else {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    } else {
                        int i7 = i2 + 2;
                        if (length > i7) {
                            byte b6 = bArr[i2 + 1];
                            if ((b6 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b7 = bArr[i7];
                            if ((b7 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            int i8 = ((b7 ^ (-123008)) ^ (b6 << 6)) ^ (b2 << 12);
                            if (i8 >= 2048) {
                                if (55296 > i8 || 57343 < i8) {
                                    i = i4 + 1;
                                    if (i4 == 64) {
                                        break;
                                    }
                                    if ((i8 != 10 && i8 != 13 && ((i8 >= 0 && 31 >= i8) || (127 <= i8 && 159 >= i8))) || i8 == 65533) {
                                        i3 = -1;
                                        break;
                                    }
                                    i3 += i8 < 65536 ? 1 : 2;
                                    i2 += 3;
                                    i4 = i;
                                } else {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    }
                } else {
                    int i9 = i2 + 1;
                    if (length > i9) {
                        byte b8 = bArr[i9];
                        if ((b8 & 192) != 128) {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                        int i10 = (b8 ^ 3968) ^ (b2 << 6);
                        if (i10 >= 128) {
                            i = i4 + 1;
                            if (i4 == 64) {
                                break;
                            }
                            if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && 31 >= i10) || (127 <= i10 && 159 >= i10))) || i10 == 65533) {
                                i3 = -1;
                                break;
                            }
                            i3 += i10 < 65536 ? 1 : 2;
                            i2 += 2;
                            i4 = i;
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    } else {
                        if (i4 == 64) {
                            break;
                        }
                        i3 = -1;
                        break;
                    }
                }
            } else {
                int i11 = i4 + 1;
                if (i4 == 64) {
                    break;
                }
                if ((b2 == 10 || b2 == 13 || ((b2 < 0 || 31 < b2) && (127 > b2 || 159 < b2))) && b2 != 65533) {
                    i3 += b2 < 65536 ? 1 : 2;
                    i2++;
                    while (true) {
                        i4 = i11;
                        if (i2 < length && (b = bArr[i2]) >= 0) {
                            i2++;
                            i11 = i4 + 1;
                            if (i4 == 64) {
                                break loop0;
                            }
                            if ((b == 10 || b == 13 || ((b < 0 || 31 < b) && (127 > b || 159 < b))) && b != 65533) {
                                i3 += b < 65536 ? 1 : 2;
                            }
                        }
                    }
                }
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            String strUtf8 = utf8();
            String strSubstring = strUtf8.substring(0, i3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String strReplace$default = StringsKt__StringsKt.replace$default(StringsKt__StringsKt.replace$default(StringsKt__StringsKt.replace$default(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i3 >= strUtf8.length()) {
                return "[text=" + strReplace$default + ']';
            }
            return "[size=" + this.data.length + " text=" + strReplace$default + "…]";
        }
        if (this.data.length <= 64) {
            return "[hex=" + hex() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(this.data.length);
        sb.append(" hex=");
        byte[] bArr2 = this.data;
        if (64 <= bArr2.length) {
            sb.append((64 == bArr2.length ? this : new ByteString(ArraysKt.copyOfRange(0, bArr2, 64))).hex());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + this.data.length + ')').toString());
    }

    public final String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        byte[] toUtf8String = internalArray$okio();
        Intrinsics.checkNotNullParameter(toUtf8String, "$this$toUtf8String");
        String str2 = new String(toUtf8String, Charsets.UTF_8);
        this.utf8 = str2;
        return str2;
    }

    public void write$okio(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(this.data, 0, i);
    }

    public ByteString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, FETmZwrVHuasmL.hRMVmTTQ);
        this.data = bArr;
    }

    public boolean rangeEquals(ByteString other, int i) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(0, this.data, 0, i);
    }
}
