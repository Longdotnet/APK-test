package com.google.android.datatransport.runtime;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.firebase.auth.zzaa;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_TransportContext {
    public final String backendName;
    public final byte[] extras;
    public final Priority priority;

    public AutoValue_TransportContext(String str, byte[] bArr, Priority priority) {
        this.backendName = str;
        this.extras = bArr;
        this.priority = priority;
    }

    public static zzaa builder() {
        zzaa zzaaVar = new zzaa(13);
        zzaaVar.zzc = Priority.DEFAULT;
        return zzaaVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_TransportContext)) {
            return false;
        }
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) obj;
        return this.backendName.equals(autoValue_TransportContext.backendName) && Arrays.equals(this.extras, autoValue_TransportContext.extras) && this.priority.equals(autoValue_TransportContext.priority);
    }

    public final int hashCode() {
        return ((((this.backendName.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.extras)) * 1000003) ^ this.priority.hashCode();
    }

    public final String toString() {
        byte[] bArr = this.extras;
        return "TransportContext(" + this.backendName + ", " + this.priority + ", " + (bArr == null ? "" : Base64.encodeToString(bArr, 2)) + ")";
    }
}
