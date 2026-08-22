package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class ChildHandleNode extends JobCancellingNode implements ChildHandle {
    public final JobSupport childJob;

    public ChildHandleNode(JobSupport jobSupport) {
        this.childJob = jobSupport;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean childCancelled(Throwable th) {
        JobSupport job = getJob();
        if (th instanceof CancellationException) {
            return true;
        }
        return job.cancelImpl$kotlinx_coroutines_core(th) && job.getHandlesException$kotlinx_coroutines_core();
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        this.childJob.cancelImpl$kotlinx_coroutines_core(getJob());
    }
}
