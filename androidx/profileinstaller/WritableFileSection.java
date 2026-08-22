package androidx.profileinstaller;

/* JADX INFO: loaded from: classes.dex */
public final class WritableFileSection {
    public final byte[] mContents;
    public final boolean mNeedsCompression;
    public final int mType;

    public WritableFileSection(byte[] bArr, int i, boolean z) {
        this.mType = i;
        this.mContents = bArr;
        this.mNeedsCompression = z;
    }
}
