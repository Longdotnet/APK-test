package androidx.work;

import android.net.Uri;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class ContentUriTriggers {
    public final HashSet mTriggers = new HashSet();

    public final class Trigger {
        public final boolean mTriggerForDescendants;
        public final Uri mUri;

        public Trigger(Uri uri, boolean z) {
            this.mUri = uri;
            this.mTriggerForDescendants = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Trigger.class != obj.getClass()) {
                return false;
            }
            Trigger trigger = (Trigger) obj;
            return this.mTriggerForDescendants == trigger.mTriggerForDescendants && this.mUri.equals(trigger.mUri);
        }

        public final int hashCode() {
            return (this.mUri.hashCode() * 31) + (this.mTriggerForDescendants ? 1 : 0);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ContentUriTriggers.class != obj.getClass()) {
            return false;
        }
        return this.mTriggers.equals(((ContentUriTriggers) obj).mTriggers);
    }

    public final int hashCode() {
        return this.mTriggers.hashCode();
    }
}
