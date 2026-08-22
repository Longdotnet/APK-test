package androidx.work.impl.constraints;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface WorkConstraintsCallback {
    void onAllConstraintsMet(List list);

    void onAllConstraintsNotMet(ArrayList arrayList);
}
