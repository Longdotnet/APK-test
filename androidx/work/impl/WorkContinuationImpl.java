package androidx.work.impl;

import androidx.work.Logger$LogcatLogger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WorkContinuationImpl extends WorkContinuation {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkContinuationImpl");
    public final ArrayList mAllIds = new ArrayList();
    public boolean mEnqueued;
    public final ArrayList mIds;
    public final List mWork;
    public final WorkManagerImpl mWorkManagerImpl;

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, List list) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWork = list;
        this.mIds = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            String string = ((OneTimeWorkRequest) list.get(i)).mId.toString();
            this.mIds.add(string);
            this.mAllIds.add(string);
        }
    }

    public static boolean hasCycles(WorkContinuationImpl workContinuationImpl, HashSet hashSet) {
        hashSet.addAll(workContinuationImpl.mIds);
        HashSet hashSetPrerequisitesFor = prerequisitesFor(workContinuationImpl);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (hashSetPrerequisitesFor.contains((String) it.next())) {
                return true;
            }
        }
        hashSet.removeAll(workContinuationImpl.mIds);
        return false;
    }

    public static HashSet prerequisitesFor(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        workContinuationImpl.getClass();
        return hashSet;
    }
}
