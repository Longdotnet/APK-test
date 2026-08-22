package androidx.work.impl.model;

/* JADX INFO: loaded from: classes.dex */
public final class SystemIdInfo {
    public final int systemId;
    public final String workSpecId;

    public SystemIdInfo(String str, int i) {
        this.workSpecId = str;
        this.systemId = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        if (this.systemId != systemIdInfo.systemId) {
            return false;
        }
        return this.workSpecId.equals(systemIdInfo.workSpecId);
    }

    public final int hashCode() {
        return (this.workSpecId.hashCode() * 31) + this.systemId;
    }
}
