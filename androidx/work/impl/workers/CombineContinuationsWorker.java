package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.pairip.VMRunner;

/* JADX INFO: loaded from: classes2.dex */
public class CombineContinuationsWorker extends Worker {
    public CombineContinuationsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        return (ListenableWorker.Result) VMRunner.invoke("ahWiknELvBTDRlkV", new Object[]{this});
    }
}
