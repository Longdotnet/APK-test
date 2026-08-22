package okio;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Segment {
    public final byte[] data;
    public int limit;
    public Segment next;
    public final boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        Intrinsics.checkNotNull(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        Intrinsics.checkNotNull(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final void push(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        Intrinsics.checkNotNull(segment2);
        segment2.prev = segment;
        this.next = segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true);
    }

    public final void writeTo(Segment sink, int i) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int i2 = sink.limit;
        int i3 = i2 + i;
        byte[] bArr = sink.data;
        if (i3 > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i4 = sink.pos;
            if (i3 - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            ArraysKt.copyInto(bArr, 0, bArr, i4, i2);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        int i5 = sink.limit;
        int i6 = this.pos;
        ArraysKt.copyInto(this.data, i5, bArr, i6, i6 + i);
        sink.limit += i;
        this.pos += i;
    }

    public Segment(byte[] data, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = false;
    }
}
