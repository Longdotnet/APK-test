package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzi;
import com.google.android.gms.internal.tasks.zza;
import com.google.firebase.auth.zzaa;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzu implements Executor {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;

    public /* synthetic */ zzu(Object obj, int i) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                ((zza) this.zza).post(runnable);
                return;
            case 1:
                runnable.getClass();
                Handler handler = (Handler) this.zza;
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            case 2:
                ((Handler) ((zzaa) this.zza).zzb).post(runnable);
                return;
            case 3:
                ((ExecutorService) this.zza).execute(new com.google.android.gms.common.util.concurrent.zza(1, runnable));
                return;
            default:
                ((zzi) this.zza).post(runnable);
                return;
        }
    }

    public zzu() {
        this.$r8$classId = 0;
        this.zza = new zza(Looper.getMainLooper());
    }

    public zzu(Looper looper) {
        this.$r8$classId = 4;
        this.zza = new zzi(looper);
    }
}
