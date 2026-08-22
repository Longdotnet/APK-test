package androidx.work.impl.constraints.controllers;

import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintController {
    public WorkConstraintsTracker mCallback;
    public Object mCurrentValue;
    public final ArrayList mMatchingWorkSpecIds = new ArrayList();
    public final ConstraintTracker mTracker;

    public ConstraintController(ConstraintTracker constraintTracker) {
        this.mTracker = constraintTracker;
    }

    public abstract boolean hasConstraint(WorkSpec workSpec);

    public abstract boolean isConstrained(Object obj);

    public final void replace(Collection collection) {
        this.mMatchingWorkSpecIds.clear();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            WorkSpec workSpec = (WorkSpec) it.next();
            if (hasConstraint(workSpec)) {
                this.mMatchingWorkSpecIds.add(workSpec.id);
            }
        }
        if (this.mMatchingWorkSpecIds.isEmpty()) {
            this.mTracker.removeListener(this);
        } else {
            ConstraintTracker constraintTracker = this.mTracker;
            synchronized (constraintTracker.mLock) {
                try {
                    if (constraintTracker.mListeners.add(this)) {
                        if (constraintTracker.mListeners.size() == 1) {
                            constraintTracker.mCurrentState = constraintTracker.getInitialState();
                            Logger$LogcatLogger.get().debug(ConstraintTracker.TAG, String.format("%s: initial state = %s", constraintTracker.getClass().getSimpleName(), constraintTracker.mCurrentState), new Throwable[0]);
                            constraintTracker.startTracking();
                        }
                        Object obj = constraintTracker.mCurrentState;
                        this.mCurrentValue = obj;
                        updateCallback(this.mCallback, obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        updateCallback(this.mCallback, this.mCurrentValue);
    }

    public final void updateCallback(WorkConstraintsTracker workConstraintsTracker, Object obj) {
        if (this.mMatchingWorkSpecIds.isEmpty() || workConstraintsTracker == null) {
            return;
        }
        if (obj == null || isConstrained(obj)) {
            workConstraintsTracker.onConstraintNotMet(this.mMatchingWorkSpecIds);
            return;
        }
        ArrayList<String> arrayList = this.mMatchingWorkSpecIds;
        synchronized (workConstraintsTracker.mLock) {
            try {
                ArrayList arrayList2 = new ArrayList();
                for (String str : arrayList) {
                    if (workConstraintsTracker.areAllConstraintsMet(str)) {
                        Logger$LogcatLogger.get().debug(WorkConstraintsTracker.TAG, "Constraints met for " + str, new Throwable[0]);
                        arrayList2.add(str);
                    }
                }
                WorkConstraintsCallback workConstraintsCallback = workConstraintsTracker.mCallback;
                if (workConstraintsCallback != null) {
                    workConstraintsCallback.onAllConstraintsMet(arrayList2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
