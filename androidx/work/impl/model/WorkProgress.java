package androidx.work.impl.model;

import androidx.work.Data;

/* JADX INFO: loaded from: classes.dex */
public final class WorkProgress {
    public final Data mProgress;
    public final String mWorkSpecId;

    public WorkProgress(String str, Data data) {
        this.mWorkSpecId = str;
        this.mProgress = data;
    }
}
