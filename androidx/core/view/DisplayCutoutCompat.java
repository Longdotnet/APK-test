package androidx.core.view;

import android.view.DisplayCutout;
import java.util.Objects;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class DisplayCutoutCompat {
    public final DisplayCutout mDisplayCutout;

    public DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.mDisplayCutout = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mDisplayCutout, ((DisplayCutoutCompat) obj).mDisplayCutout);
    }

    public final int hashCode() {
        return this.mDisplayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + ygoi.NoginPiDgHLwuKv;
    }
}
