package androidx.core.view;

import android.content.ClipData;
import android.content.pm.ApkChecksum;
import android.media.metrics.PlaybackMetrics;
import android.view.ContentInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class ContentInfoCompat$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ ApkChecksum m(Object obj) {
        return (ApkChecksum) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ PlaybackMetrics.Builder m14m(Object obj) {
        return (PlaybackMetrics.Builder) obj;
    }

    public static /* synthetic */ ContentInfo.Builder m(ClipData clipData, int i) {
        return new ContentInfo.Builder(clipData, i);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ContentInfo m15m(Object obj) {
        return (ContentInfo) obj;
    }
}
