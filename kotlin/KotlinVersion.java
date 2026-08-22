package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public final class KotlinVersion implements Comparable {
    public static final KotlinVersion CURRENT = new KotlinVersion();
    public final int version;

    public KotlinVersion() {
        if (!new IntRange(0, 255, 1).contains(1) || !new IntRange(0, 255, 1).contains(8) || !new IntRange(0, 255, 1).contains(22)) {
            throw new IllegalArgumentException("Version components are out of range: 1.8.22".toString());
        }
        this.version = 67606;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        KotlinVersion other = (KotlinVersion) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.version - other.version;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        KotlinVersion kotlinVersion = obj instanceof KotlinVersion ? (KotlinVersion) obj : null;
        return kotlinVersion != null && this.version == kotlinVersion.version;
    }

    public final int hashCode() {
        return this.version;
    }

    public final String toString() {
        return "1.8.22";
    }
}
