package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.nio.ByteBuffer;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class TypefaceEmojiRasterizer {
    public static final ThreadLocal sMetadataItem = new ThreadLocal();
    public volatile int mCache = 0;
    public final int mIndex;
    public final Dispatcher mMetadataRepo;

    public TypefaceEmojiRasterizer(Dispatcher dispatcher, int i) {
        this.mMetadataRepo = dispatcher;
        this.mIndex = i;
    }

    public final int getCodepointAt(int i) {
        MetadataItem metadataItem = getMetadataItem();
        int i__offset = metadataItem.__offset(16);
        if (i__offset == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) metadataItem.bb;
        int i2 = i__offset + metadataItem.bb_pos;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final int getCodepointsLength() {
        MetadataItem metadataItem = getMetadataItem();
        int i__offset = metadataItem.__offset(16);
        if (i__offset == 0) {
            return 0;
        }
        int i = i__offset + metadataItem.bb_pos;
        return ((ByteBuffer) metadataItem.bb).getInt(((ByteBuffer) metadataItem.bb).getInt(i) + i);
    }

    public final MetadataItem getMetadataItem() {
        ThreadLocal threadLocal = sMetadataItem;
        MetadataItem metadataItem = (MetadataItem) threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        MetadataList metadataList = (MetadataList) this.mMetadataRepo.executorServiceOrNull;
        int i__offset = metadataList.__offset(6);
        if (i__offset != 0) {
            int i = i__offset + metadataList.bb_pos;
            int i2 = (this.mIndex * 4) + ((ByteBuffer) metadataList.bb).getInt(i) + i + 4;
            int i3 = ((ByteBuffer) metadataList.bb).getInt(i2) + i2;
            ByteBuffer byteBuffer = (ByteBuffer) metadataList.bb;
            metadataItem.bb = byteBuffer;
            if (byteBuffer != null) {
                metadataItem.bb_pos = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                metadataItem.vtable_start = i4;
                metadataItem.vtable_size = ((ByteBuffer) metadataItem.bb).getShort(i4);
            } else {
                metadataItem.bb_pos = 0;
                metadataItem.vtable_start = 0;
                metadataItem.vtable_size = 0;
            }
        }
        return metadataItem;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        MetadataItem metadataItem = getMetadataItem();
        int i__offset = metadataItem.__offset(4);
        sb.append(Integer.toHexString(i__offset != 0 ? ((ByteBuffer) metadataItem.bb).getInt(i__offset + metadataItem.bb_pos) : 0));
        sb.append(", codepoints:");
        int codepointsLength = getCodepointsLength();
        for (int i = 0; i < codepointsLength; i++) {
            sb.append(Integer.toHexString(getCodepointAt(i)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
