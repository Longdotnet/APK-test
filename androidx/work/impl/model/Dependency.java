package androidx.work.impl.model;

/* JADX INFO: loaded from: classes.dex */
public final class Dependency {
    public final String prerequisiteId;
    public final String workSpecId;

    public Dependency(String str, String str2) {
        this.workSpecId = str;
        this.prerequisiteId = str2;
    }
}
