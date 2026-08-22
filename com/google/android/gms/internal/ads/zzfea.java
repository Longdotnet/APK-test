package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public final class zzfea {
    static Task zza;
    public static AppSetIdClient zzb;
    private static final Object zzc = new Object();

    public static Task zza(Context context) {
        Task task;
        zzb(context, false);
        synchronized (zzc) {
            task = zza;
        }
        return task;
    }

    public static void zzb(Context context, boolean z) {
        synchronized (zzc) {
            try {
                if (zzb == null) {
                    zzb = new com.google.android.gms.internal.appset.zzr(context);
                }
                Task task = zza;
                if (task == null || ((task.isComplete() && !zza.isSuccessful()) || (z && zza.isComplete()))) {
                    AppSetIdClient appSetIdClient = zzb;
                    com.google.android.gms.common.internal.zzah.checkNotNull(appSetIdClient, "the appSetIdClient shouldn't be null");
                    zza = appSetIdClient.getAppSetIdInfo();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
