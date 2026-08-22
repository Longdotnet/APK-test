package okhttp3.internal.http2;

import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.RealBufferedSource;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Hpack {
    public static final Map NAME_TO_FIRST_INDEX;
    public static final Header[] STATIC_HEADER_TABLE;

    public final class Reader {
        public int dynamicTableByteCount;
        public int headerCount;
        public final RealBufferedSource source;
        public int maxDynamicTableByteCount = 4096;
        public final ArrayList headerList = new ArrayList();
        public Header[] dynamicTable = new Header[8];
        public int nextHeaderIndex = 7;

        public Reader(Http2Reader.ContinuationSource continuationSource) {
            this.source = new RealBufferedSource(continuationSource);
        }

        public final int evictToRecoverBytes(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header);
                    int i4 = header.hpackSize;
                    i -= i4;
                    this.dynamicTableByteCount -= i4;
                    this.headerCount--;
                    i3++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i2 + 1, headerArr, i2 + 1 + i3, this.headerCount);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        public final ByteString getName(int i) throws IOException {
            if (i >= 0) {
                Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                if (i <= headerArr.length - 1) {
                    return headerArr[i].name;
                }
            }
            int length = this.nextHeaderIndex + 1 + (i - Hpack.STATIC_HEADER_TABLE.length);
            if (length >= 0) {
                Header[] headerArr2 = this.dynamicTable;
                if (length < headerArr2.length) {
                    Header header = headerArr2[length];
                    Intrinsics.checkNotNull(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public final void insertIntoDynamicTable(Header header) {
            this.headerList.add(header);
            int i = this.maxDynamicTableByteCount;
            int i2 = header.hpackSize;
            if (i2 > i) {
                Header[] headerArr = this.dynamicTable;
                ArraysKt.fill(headerArr, 0, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i2) - i);
            int i3 = this.headerCount + 1;
            Header[] headerArr2 = this.dynamicTable;
            if (i3 > headerArr2.length) {
                Header[] headerArr3 = new Header[headerArr2.length * 2];
                System.arraycopy(headerArr2, 0, headerArr3, headerArr2.length, headerArr2.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr3;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i2;
        }

        public final ByteString readByteString() {
            int i;
            RealBufferedSource source = this.source;
            byte b = source.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            int i2 = b & 255;
            int i3 = 0;
            boolean z = (b & 128) == 128;
            long j = readInt(i2, 127);
            if (!z) {
                return source.readByteString(j);
            }
            Buffer buffer = new Buffer();
            int[] iArr = Huffman.CODES;
            Intrinsics.checkNotNullParameter(source, "source");
            Huffman.Node node = Huffman.root;
            Huffman.Node node2 = node;
            int i4 = 0;
            for (long j2 = 0; j2 < j; j2++) {
                byte b2 = source.readByte();
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                i3 = (i3 << 8) | (b2 & 255);
                i4 += 8;
                while (i4 >= 8) {
                    int i5 = i4 - 8;
                    Huffman.Node[] nodeArr = (Huffman.Node[]) node2.children;
                    Intrinsics.checkNotNull(nodeArr);
                    node2 = nodeArr[(i3 >>> i5) & 255];
                    Intrinsics.checkNotNull(node2);
                    if (((Huffman.Node[]) node2.children) == null) {
                        buffer.writeByte(node2.symbol);
                        i4 -= node2.terminalBitCount;
                        node2 = node;
                    } else {
                        i4 = i5;
                    }
                }
            }
            while (i4 > 0) {
                Huffman.Node[] nodeArr2 = (Huffman.Node[]) node2.children;
                Intrinsics.checkNotNull(nodeArr2);
                Huffman.Node node3 = nodeArr2[(i3 << (8 - i4)) & 255];
                Intrinsics.checkNotNull(node3);
                if (((Huffman.Node[]) node3.children) != null || (i = node3.terminalBitCount) > i4) {
                    break;
                }
                buffer.writeByte(node3.symbol);
                i4 -= i;
                node2 = node;
            }
            return buffer.readByteString(buffer.size);
        }

        public final int readInt(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte b = this.source.readByte();
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                int i5 = b & 255;
                if ((b & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (b & 127) << i4;
                i4 += 7;
            }
        }
    }

    public final class Writer {
        public int dynamicTableByteCount;
        public boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public final Buffer out;
        public final boolean useCompression = true;
        public int smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
        public int maxDynamicTableByteCount = 4096;
        public Header[] dynamicTable = new Header[8];
        public int nextHeaderIndex = 7;

        public Writer(Buffer buffer) {
            this.out = buffer;
        }

        public final void evictToRecoverBytes(int i) {
            int i2;
            if (i > 0) {
                int length = this.dynamicTable.length - 1;
                int i3 = 0;
                while (true) {
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header);
                    i -= header.hpackSize;
                    int i4 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header2);
                    this.dynamicTableByteCount = i4 - header2.hpackSize;
                    this.headerCount--;
                    i3++;
                    length--;
                }
                Header[] headerArr = this.dynamicTable;
                int i5 = i2 + 1;
                System.arraycopy(headerArr, i5, headerArr, i5 + i3, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i6 = this.nextHeaderIndex + 1;
                Arrays.fill(headerArr2, i6, i6 + i3, (Object) null);
                this.nextHeaderIndex += i3;
            }
        }

        public final void insertIntoDynamicTable(Header header) {
            int i = this.maxDynamicTableByteCount;
            int i2 = header.hpackSize;
            if (i2 > i) {
                Header[] headerArr = this.dynamicTable;
                ArraysKt.fill(headerArr, 0, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i2) - i);
            int i3 = this.headerCount + 1;
            Header[] headerArr2 = this.dynamicTable;
            if (i3 > headerArr2.length) {
                Header[] headerArr3 = new Header[headerArr2.length * 2];
                System.arraycopy(headerArr2, 0, headerArr3, headerArr2.length, headerArr2.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr3;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i2;
        }

        public final void writeByteString(ByteString data) throws EOFException {
            Intrinsics.checkNotNullParameter(data, "data");
            Buffer buffer = this.out;
            if (this.useCompression) {
                int[] iArr = Huffman.CODES;
                int size$okio = data.getSize$okio();
                long j = 0;
                for (int i = 0; i < size$okio; i++) {
                    byte bInternalGet$okio = data.internalGet$okio(i);
                    byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                    j += (long) Huffman.CODE_BIT_COUNTS[bInternalGet$okio & 255];
                }
                if (((int) ((j + ((long) 7)) >> 3)) < data.getSize$okio()) {
                    Buffer buffer2 = new Buffer();
                    int[] iArr2 = Huffman.CODES;
                    int size$okio2 = data.getSize$okio();
                    long j2 = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < size$okio2; i3++) {
                        byte bInternalGet$okio2 = data.internalGet$okio(i3);
                        byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                        int i4 = bInternalGet$okio2 & 255;
                        int i5 = Huffman.CODES[i4];
                        byte b = Huffman.CODE_BIT_COUNTS[i4];
                        j2 = (j2 << b) | ((long) i5);
                        i2 += b;
                        while (i2 >= 8) {
                            i2 -= 8;
                            buffer2.writeByte((int) (j2 >> i2));
                        }
                    }
                    if (i2 > 0) {
                        buffer2.writeByte((int) ((255 >>> i2) | (j2 << (8 - i2))));
                    }
                    ByteString byteString = buffer2.readByteString(buffer2.size);
                    writeInt(byteString.getSize$okio(), 127, 128);
                    buffer.write(byteString);
                    return;
                }
            }
            writeInt(data.getSize$okio(), 127, 0);
            buffer.write(data);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0069  */
        public final void writeHeaders(ArrayList arrayList) throws EOFException {
            int length;
            int length2;
            if (this.emitDynamicTableSizeUpdate) {
                int i = this.smallestHeaderTableSizeSetting;
                if (i < this.maxDynamicTableByteCount) {
                    writeInt(i, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Header header = (Header) arrayList.get(i2);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                Integer num = (Integer) Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                ByteString byteString = header.value;
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (2 <= length2 && 7 >= length2) {
                        Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                        if (Intrinsics.areEqual(headerArr[iIntValue].value, byteString)) {
                            length = length2;
                        } else if (Intrinsics.areEqual(headerArr[length2].value, byteString)) {
                            length2 = iIntValue + 2;
                            length = length2;
                        } else {
                            length = length2;
                            length2 = -1;
                        }
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int length3 = this.dynamicTable.length;
                    for (int i3 = this.nextHeaderIndex + 1; i3 < length3; i3++) {
                        Header header2 = this.dynamicTable[i3];
                        Intrinsics.checkNotNull(header2);
                        if (Intrinsics.areEqual(header2.name, asciiLowercase)) {
                            Header header3 = this.dynamicTable[i3];
                            Intrinsics.checkNotNull(header3);
                            if (Intrinsics.areEqual(header3.value, byteString)) {
                                length2 = Hpack.STATIC_HEADER_TABLE.length + (i3 - this.nextHeaderIndex);
                                break;
                            } else if (length == -1) {
                                length = (i3 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    writeInt(length2, 127, 128);
                } else if (length == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    ByteString prefix = Header.PSEUDO_PREFIX;
                    asciiLowercase.getClass();
                    Intrinsics.checkNotNullParameter(prefix, "prefix");
                    if (!asciiLowercase.rangeEquals(prefix, prefix.getSize$okio()) || Intrinsics.areEqual(Header.TARGET_AUTHORITY, asciiLowercase)) {
                        writeInt(length, 63, 64);
                        writeByteString(byteString);
                        insertIntoDynamicTable(header);
                    } else {
                        writeInt(length, 15, 0);
                        writeByteString(byteString);
                    }
                }
            }
        }

        public final void writeInt(int i, int i2, int i3) {
            Buffer buffer = this.out;
            if (i < i2) {
                buffer.writeByte(i | i3);
                return;
            }
            buffer.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                buffer.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            buffer.writeByte(i4);
        }
    }

    public static void checkLowercase(ByteString name) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        int size$okio = name.getSize$okio();
        for (int i = 0; i < size$okio; i++) {
            byte b = (byte) 65;
            byte b2 = (byte) 90;
            byte bInternalGet$okio = name.internalGet$okio(i);
            if (b <= bInternalGet$okio && b2 >= bInternalGet$okio) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(name.utf8()));
            }
        }
    }

    static {
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header(byteString, "GET");
        Header header3 = new Header(byteString, "POST");
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, kBfGXgdfpo.jehjPbKJfQJAM);
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.RESPONSE_STATUS;
        Header[] headerArr = {header, header2, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, kBfGXgdfpo.atyDKvjRGcZSWd), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(FirebaseAnalytics.Param.LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header(GsPcpBmONXh.RXK, "")};
        STATIC_HEADER_TABLE = headerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i = 0; i < 61; i++) {
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(headerArr[i].name, Integer.valueOf(i));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        NAME_TO_FIRST_INDEX = mapUnmodifiableMap;
    }
}
