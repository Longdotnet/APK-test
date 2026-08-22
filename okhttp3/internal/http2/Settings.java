package okhttp3.internal.http2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Settings {
    public int set;
    public final int[] values = new int[10];

    public final int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    public final void merge(Settings other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i = 0; i < 10; i++) {
            if (((1 << i) & other.set) != 0) {
                set(i, other.values[i]);
            }
        }
    }

    public final void set(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.values;
            if (i >= iArr.length) {
                return;
            }
            this.set = (1 << i) | this.set;
            iArr[i] = i2;
        }
    }
}
