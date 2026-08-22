package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class JobImpl extends JobSupport {
    public final boolean handlesException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobImpl(Job job) {
        super(true);
        boolean z = true;
        initParentJob(job);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport._parentHandle$FU;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        ChildHandleNode childHandleNode = childHandle instanceof ChildHandleNode ? (ChildHandleNode) childHandle : null;
        if (childHandleNode == null) {
            z = false;
            break;
        }
        JobSupport job2 = childHandleNode.getJob();
        while (!job2.getHandlesException$kotlinx_coroutines_core()) {
            ChildHandle childHandle2 = (ChildHandle) atomicReferenceFieldUpdater.get(job2);
            ChildHandleNode childHandleNode2 = childHandle2 instanceof ChildHandleNode ? (ChildHandleNode) childHandle2 : null;
            if (childHandleNode2 == null) {
                z = false;
                break;
            }
            job2 = childHandleNode2.getJob();
        }
        this.handlesException = z;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }
}
