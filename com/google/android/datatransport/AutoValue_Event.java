package com.google.android.datatransport;

import com.google.android.gms.internal.play_billing.zzhe;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_Event {
    public final zzhe payload;

    public AutoValue_Event(zzhe zzheVar) {
        if (zzheVar == null) {
            throw new NullPointerException("Null payload");
        }
        this.payload = zzheVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_Event)) {
            return false;
        }
        AutoValue_Event autoValue_Event = (AutoValue_Event) obj;
        autoValue_Event.getClass();
        if (this.payload.equals(autoValue_Event.payload)) {
            Object obj2 = Priority.DEFAULT;
            if (obj2.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Priority.DEFAULT.hashCode() ^ (((1000003 * 1000003) ^ this.payload.hashCode()) * 1000003);
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.payload + ", priority=" + Priority.DEFAULT + "}";
    }
}
