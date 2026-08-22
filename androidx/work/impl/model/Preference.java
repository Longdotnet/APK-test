package androidx.work.impl.model;

/* JADX INFO: loaded from: classes.dex */
public final class Preference {
    public final String mKey;
    public final Long mValue;

    public Preference(String str, long j) {
        this.mKey = str;
        this.mValue = Long.valueOf(j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        if (!this.mKey.equals(preference.mKey)) {
            return false;
        }
        Long l = preference.mValue;
        Long l2 = this.mValue;
        if (l2 != null) {
            return l2.equals(l);
        }
        return l == null;
    }

    public final int hashCode() {
        int iHashCode = this.mKey.hashCode() * 31;
        Long l = this.mValue;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }
}
