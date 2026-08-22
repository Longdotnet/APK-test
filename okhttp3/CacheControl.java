package okhttp3;

import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheControl {
    public static final /* synthetic */ int $r8$clinit = 0;
    public String headerValue;
    public final boolean immutable;
    public final boolean isPrivate;
    public final boolean isPublic;
    public final int maxAgeSeconds;
    public final int maxStaleSeconds;
    public final int minFreshSeconds;
    public final boolean mustRevalidate;
    public final boolean noCache;
    public final boolean noStore;
    public final boolean noTransform;
    public final boolean onlyIfCached;
    public final int sMaxAgeSeconds;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    public final String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        int i = this.maxAgeSeconds;
        String str2 = RDFWIi.lxDfHyNdFpM;
        if (i != -1) {
            sb.append("max-age=");
            sb.append(i);
            sb.append(str2);
        }
        int i2 = this.sMaxAgeSeconds;
        if (i2 != -1) {
            sb.append("s-maxage=");
            sb.append(i2);
            sb.append(str2);
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        int i3 = this.maxStaleSeconds;
        if (i3 != -1) {
            sb.append("max-stale=");
            sb.append(i3);
            sb.append(str2);
        }
        int i4 = this.minFreshSeconds;
        if (i4 != -1) {
            sb.append("min-fresh=");
            sb.append(i4);
            sb.append(str2);
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return JrbhsraGtto.KdLeOqPJhMjrW;
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = string;
        return string;
    }
}
