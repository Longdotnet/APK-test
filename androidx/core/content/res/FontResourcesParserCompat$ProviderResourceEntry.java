package androidx.core.content.res;

import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public final class FontResourcesParserCompat$ProviderResourceEntry implements FontResourcesParserCompat$FamilyResourceEntry {
    public final Request.Builder mRequest;
    public final int mStrategy;
    public final String mSystemFontFamilyName;
    public final int mTimeoutMs;

    public FontResourcesParserCompat$ProviderResourceEntry(Request.Builder builder, int i, int i2, String str) {
        this.mRequest = builder;
        this.mStrategy = i;
        this.mTimeoutMs = i2;
        this.mSystemFontFamilyName = str;
    }
}
