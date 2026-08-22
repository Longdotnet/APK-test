package com.google.android.gms.internal.appset;

import android.content.Context;
import androidx.work.WorkContinuation;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;

/* JADX INFO: loaded from: classes2.dex */
public final class zzr implements AppSetIdClient {
    private final AppSetIdClient zza;
    private final AppSetIdClient zzb;

    public zzr(Context context) {
        this.zza = new zzp(context, GoogleApiAvailabilityLight.zza);
        this.zzb = zzl.zzc(context);
    }

    @Override // com.google.android.gms.appset.AppSetIdClient
    public final Task getAppSetIdInfo() {
        Task appSetIdInfo = this.zza.getAppSetIdInfo();
        Continuation continuation = new Continuation() { // from class: com.google.android.gms.internal.appset.zzq
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzr.zza(this.zza, task);
            }
        };
        zzw zzwVar = (zzw) appSetIdInfo;
        zzwVar.getClass();
        return zzwVar.continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    public static Task zza(zzr zzrVar, Task task) {
        if (!task.isSuccessful() && !((zzw) task).zzd) {
            Exception exception = task.getException();
            if (exception instanceof ApiException) {
                int statusCode = ((ApiException) exception).getStatusCode();
                if (statusCode != 43001 && statusCode != 43002 && statusCode != 43003 && statusCode != 17) {
                    if (statusCode == 43000) {
                        return WorkContinuation.forException(new Exception("Failed to get app set ID due to an internal error. Please try again later."));
                    }
                    if (statusCode == 15) {
                        return WorkContinuation.forException(new Exception(FKidOcdAYt.OiEjqcWewAu));
                    }
                    return task;
                }
                return zzrVar.zzb.getAppSetIdInfo();
            }
            return task;
        }
        return task;
    }
}
