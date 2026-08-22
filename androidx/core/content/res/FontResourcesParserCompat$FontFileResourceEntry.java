package androidx.core.content.res;

/* JADX INFO: loaded from: classes.dex */
public final class FontResourcesParserCompat$FontFileResourceEntry {
    public final String mFileName;
    public final boolean mItalic;
    public final int mResourceId;
    public final int mTtcIndex;
    public final String mVariationSettings;
    public final int mWeight;

    public FontResourcesParserCompat$FontFileResourceEntry(int i, int i2, int i3, String str, String str2, boolean z) {
        this.mFileName = str;
        this.mWeight = i;
        this.mItalic = z;
        this.mVariationSettings = str2;
        this.mTtcIndex = i2;
        this.mResourceId = i3;
    }
}
