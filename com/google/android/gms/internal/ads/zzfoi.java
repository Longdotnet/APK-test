package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfoi {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    public zzfoi(Context context, Executor executor, Task task, boolean z) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z;
    }

    public static zzfoi zza(final Context context, Executor executor, boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfog
                @Override // java.lang.Runnable
                public final void run() {
                    taskCompletionSource.setResult(zzfqi.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfoh
                @Override // java.lang.Runnable
                public final void run() {
                    taskCompletionSource.setResult(zzfqi.zzc());
                }
            });
        }
        return new zzfoi(context, executor, taskCompletionSource.zza, z);
    }

    public static void zzg(int i) {
        zzf = i;
    }

    private final Task zzh(final int i, long j, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfoe
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return Boolean.valueOf(task.isSuccessful());
                }
            });
        }
        Context context = this.zzb;
        final zzarz zzarzVarZza = zzasd.zza();
        zzarzVarZza.zza(context.getPackageName());
        zzarzVarZza.zze(j);
        zzarzVarZza.zzg(zzf);
        if (exc != null) {
            int i2 = zzfwm.zza;
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zzarzVarZza.zzf(stringWriter.toString());
            zzarzVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zzarzVarZza.zzb(str2);
        }
        if (str != null) {
            zzarzVarZza.zzc(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfof
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                if (!task.isSuccessful()) {
                    return Boolean.FALSE;
                }
                int i3 = i;
                zzfqg zzfqgVarZza = ((zzfqi) task.getResult()).zza(((zzasd) zzarzVarZza.zzbn()).zzaV());
                zzfqgVarZza.zza(i3);
                zzfqgVarZza.zzc();
                return Boolean.TRUE;
            }
        });
    }

    public final Task zzb(int i, String str) {
        return zzh(i, 0L, null, null, null, str);
    }

    public final Task zzc(int i, long j, Exception exc) {
        return zzh(i, j, exc, null, null, null);
    }

    public final Task zzd(int i, long j) {
        return zzh(i, j, null, null, null, null);
    }

    public final Task zze(int i, long j, String str) {
        return zzh(i, j, null, null, null, str);
    }

    public final Task zzf(int i, long j, String str, Map map) {
        return zzh(i, j, null, str, null, null);
    }
}
