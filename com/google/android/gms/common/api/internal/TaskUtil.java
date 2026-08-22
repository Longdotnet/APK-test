package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: loaded from: classes.dex */
public class TaskUtil {
    public static void setResultOrApiException(Status status, TaskCompletionSource taskCompletionSource) {
        setResultOrApiException(status, null, taskCompletionSource);
    }

    @Deprecated
    public static Task toVoidTaskThatFailsOnFalse(Task task) {
        zacx zacxVar = new zacx();
        zzw zzwVar = (zzw) task;
        zzwVar.getClass();
        return zzwVar.continueWith(TaskExecutors.MAIN_THREAD, zacxVar);
    }

    @ResultIgnorabilityUnspecified
    public static <ResultT> boolean trySetResultOrApiException(Status status, ResultT resultt, TaskCompletionSource taskCompletionSource) {
        return status.isSuccess() ? taskCompletionSource.trySetResult(resultt) : taskCompletionSource.trySetException(zzah.fromStatus(status));
    }

    public static <ResultT> void setResultOrApiException(Status status, ResultT resultt, TaskCompletionSource taskCompletionSource) {
        if (status.isSuccess()) {
            taskCompletionSource.setResult(resultt);
        } else {
            taskCompletionSource.setException(zzah.fromStatus(status));
        }
    }
}
