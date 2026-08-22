package androidx.work;

import androidx.work.impl.model.WorkSpec;
import java.util.HashSet;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class OneTimeWorkRequest {
    public UUID mId;
    public HashSet mTags;
    public WorkSpec mWorkSpec;
}
