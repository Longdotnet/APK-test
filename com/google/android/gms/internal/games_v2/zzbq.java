package com.google.android.gms.internal.games_v2;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import androidx.work.WorkContinuation;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.gamessignin.AuthResponse;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbq implements zzaw {
    private final AtomicReference zza = new AtomicReference(zzba.UNINITIALIZED);
    private final AtomicReference zzb = new AtomicReference(zzaz.AUTOMATIC);
    private final Queue zzc = new ArrayDeque();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final Application zzf;
    private final com.google.android.gms.games.internal.zzf zzg;
    private final zzbr zzh;

    public zzbq(Application application, com.google.android.gms.games.internal.zzf zzfVar, com.google.android.gms.games.internal.v2.resolution.zzb zzbVar, zzbr zzbrVar) {
        this.zzf = application;
        this.zzg = zzfVar;
        this.zzh = zzbrVar;
    }

    private final void zzm(int i) {
        int i2;
        zzaz zzazVar;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 45);
        sb.append("startAuthenticationIfNecessary() signInType: ");
        sb.append(i);
        zzfn.zza("GamesApiManager", sb.toString());
        com.google.android.gms.common.internal.zzah.checkMainThread$1("Must be called on the main thread.");
        AtomicReference atomicReference = this.zza;
        zzba zzbaVar = zzba.UNINITIALIZED;
        zzba zzbaVar2 = zzba.AUTHENTICATING;
        while (true) {
            i2 = 0;
            boolean z = false;
            if (atomicReference.compareAndSet(zzbaVar, zzbaVar2)) {
                break;
            }
            if (atomicReference.get() != zzbaVar) {
                if (i != 1) {
                    zzba zzbaVar3 = zzba.AUTHENTICATION_FAILED;
                    while (!atomicReference.compareAndSet(zzbaVar3, zzbaVar2)) {
                        if (atomicReference.get() != zzbaVar3) {
                            AtomicReference atomicReference2 = this.zzb;
                            zzaz zzazVar2 = zzaz.AUTOMATIC;
                            zzaz zzazVar3 = zzaz.AUTOMATIC_PENDING_EXPLICIT;
                            do {
                                if (atomicReference2.compareAndSet(zzazVar2, zzazVar3)) {
                                    z = true;
                                    break;
                                }
                            } while (atomicReference2.get() == zzazVar2);
                            StringBuilder sb2 = new StringBuilder(String.valueOf(z).length() + 83);
                            sb2.append("Explicit sign-in during existing authentication. Marking pending explicit sign-in: ");
                            sb2.append(z);
                            zzfn.zza("GamesApiManager", sb2.toString());
                        }
                    }
                    i = 0;
                    break;
                }
                zzfn.zza("GamesApiManager", "Authentication attempt skipped. Already authenticated or authenticating. State: ".concat(String.valueOf(atomicReference.get())));
                return;
            }
        }
        AtomicReference atomicReference3 = this.zzd;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) atomicReference3.get();
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(new IllegalStateException("New authentication attempt in progress"));
        }
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        atomicReference3.set(taskCompletionSource2);
        AtomicReference atomicReference4 = this.zzb;
        if (i == 0) {
            zzazVar = zzaz.EXPLICIT;
        } else {
            zzazVar = zzaz.AUTOMATIC;
            i2 = 1;
        }
        atomicReference4.set(zzazVar);
        zzn(taskCompletionSource2, zzq.zza(i2));
    }

    private final void zzn(final TaskCompletionSource taskCompletionSource, final zzq zzqVar) {
        zzfn.zza("GamesApiManager", "Attempting authentication: ".concat(zzqVar.toString()));
        this.zzh.zza(zzqVar).addOnCompleteListener(TaskExecutors.MAIN_THREAD, new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzbi
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                this.zza.zzk(taskCompletionSource, zzqVar, task);
            }
        });
    }

    private static boolean zzp() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static Task zzq(final zzip zzipVar) {
        if (zzp()) {
            return (Task) zzipVar.zza();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        TaskExecutors.MAIN_THREAD.execute(new Runnable() { // from class: com.google.android.gms.internal.games_v2.zzbk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Task task = (Task) zzipVar.zza();
                final TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                task.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzbm
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final /* synthetic */ void onComplete(Task task2) {
                        TaskCompletionSource taskCompletionSource3 = taskCompletionSource2;
                        if (task2.isSuccessful()) {
                            taskCompletionSource3.trySetResult(task2.getResult());
                            return;
                        }
                        Exception exception = task2.getException();
                        zzfw.zza(exception);
                        taskCompletionSource3.trySetException(exception);
                    }
                });
            }
        });
        return taskCompletionSource.zza;
    }

    private static ApiException zzr() {
        return new ApiException(new Status(4));
    }

    private static Task zzs(AtomicReference atomicReference, TaskCompletionSource taskCompletionSource) {
        int iOrdinal = ((zzba) atomicReference.get()).ordinal();
        if (iOrdinal == 0) {
            return WorkContinuation.forException(new ApiException(new Status(10)));
        }
        if (iOrdinal == 2) {
            return WorkContinuation.forResult(AuthenticationResult.zza);
        }
        if (iOrdinal == 3) {
            return WorkContinuation.forResult(AuthenticationResult.zzb);
        }
        if (taskCompletionSource == null) {
            return WorkContinuation.forResult(AuthenticationResult.zzb);
        }
        com.google.android.gms.tasks.zzw zzwVar = taskCompletionSource.zza;
        if (zzwVar.isSuccessful()) {
            return ((Boolean) zzwVar.getResult()).booleanValue() ? WorkContinuation.forResult(AuthenticationResult.zza) : WorkContinuation.forResult(AuthenticationResult.zzb);
        }
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        zzwVar.addOnCompleteListener(zzio.zza(), new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzbl
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                TaskCompletionSource taskCompletionSource3 = taskCompletionSource2;
                if (task.isSuccessful() && ((Boolean) task.getResult()).booleanValue()) {
                    taskCompletionSource3.trySetResult(AuthenticationResult.zza);
                } else {
                    taskCompletionSource3.trySetResult(AuthenticationResult.zzb);
                }
            }
        });
        return taskCompletionSource2.zza;
    }

    @Override // com.google.android.gms.internal.games_v2.zzaw
    public final Task zza(zzav zzavVar) {
        zzba zzbaVar = (zzba) this.zza.get();
        zzfn.zzc("GamesApiManager", "Executing API call with authentication state: ".concat(String.valueOf(zzbaVar)));
        if (zzbaVar == zzba.AUTHENTICATED) {
            return zzavVar.zza((GoogleApi) this.zze.get());
        }
        if (zzbaVar == zzba.AUTHENTICATION_FAILED) {
            return WorkContinuation.forException(zzr());
        }
        if (zzbaVar == zzba.UNINITIALIZED) {
            return WorkContinuation.forException(new ApiException(new Status(10)));
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final zzbc zzbcVar = new zzbc(zzavVar, taskCompletionSource);
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.games_v2.zzbn
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzf(zzbcVar);
            }
        };
        if (zzp()) {
            runnable.run();
        } else {
            TaskExecutors.MAIN_THREAD.execute(runnable);
        }
        return taskCompletionSource.zza;
    }

    @Override // com.google.android.gms.internal.games_v2.zzaw
    public final Task zzb(final zzau zzauVar, final List list) {
        Task taskZza = zza(new zzav() { // from class: com.google.android.gms.internal.games_v2.zzbd
            @Override // com.google.android.gms.internal.games_v2.zzav
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                return zzauVar.zza(googleApi, list);
            }
        });
        Continuation continuation = new Continuation() { // from class: com.google.android.gms.internal.games_v2.zzbe
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                return this.zza.zzg(zzauVar, list, task);
            }
        };
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskZza;
        zzwVar.getClass();
        return zzwVar.continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.internal.games_v2.zzaw
    public final Task zzc() {
        return zzs(this.zza, (TaskCompletionSource) this.zzd.get());
    }

    @Override // com.google.android.gms.internal.games_v2.zzaw
    public final Task zzd() {
        return zzq(new zzip() { // from class: com.google.android.gms.internal.games_v2.zzbg
            @Override // com.google.android.gms.internal.games_v2.zzip
            public final /* synthetic */ Object zza() {
                return this.zza.zzi();
            }
        });
    }

    @Override // com.google.android.gms.internal.games_v2.zzaw
    public final Task zze() {
        return zzq(new zzip() { // from class: com.google.android.gms.internal.games_v2.zzbh
            @Override // com.google.android.gms.internal.games_v2.zzip
            public final /* synthetic */ Object zza() {
                return this.zza.zzj();
            }
        });
    }

    public final /* synthetic */ void zzf(zzbc zzbcVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("Must be called on the main thread.");
        zzba zzbaVar = (zzba) this.zza.get();
        if (zzbaVar == zzba.AUTHENTICATED) {
            zzbcVar.zza((GoogleApi) this.zze.get());
        } else if (zzbaVar == zzba.AUTHENTICATION_FAILED) {
            zzbcVar.zzb(zzr());
        } else {
            this.zzc.add(zzbcVar);
        }
    }

    public final /* synthetic */ Task zzh(List list, zzau zzauVar, com.google.android.gms.games.internal.v2.resolution.zzc zzcVar) {
        if (!zzcVar.zzc()) {
            list = zzhd.zzi();
        }
        return zzauVar.zza((GoogleApi) this.zze.get(), list);
    }

    public final /* synthetic */ Task zzi() {
        zzm(1);
        return zzs(this.zza, (TaskCompletionSource) this.zzd.get());
    }

    public final /* synthetic */ Task zzj() {
        zzm(0);
        return zzs(this.zza, (TaskCompletionSource) this.zzd.get());
    }

    public final /* synthetic */ void zzk(TaskCompletionSource taskCompletionSource, zzq zzqVar, Task task) {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            zzfw.zza(exception);
            zzfn.zzb("GamesApiManager", "Authentication task failed", exception);
            zzo(taskCompletionSource, zzqVar.zzc(), null, false, !zzqVar.zzd());
            return;
        }
        zzbv zzbvVar = (zzbv) task.getResult();
        if (!zzbvVar.zzc()) {
            zzfn.zza("GamesApiManager", "Failed to authenticate: ".concat(String.valueOf(zzbvVar)));
            zzo(taskCompletionSource, zzqVar.zzc(), zzbvVar.zze(), true, !zzqVar.zzd());
            return;
        }
        String strZzd = zzbvVar.zzd();
        if (strZzd == null) {
            zzfn.zze("GamesApiManager", "Unexpected state: game run token absent");
            zzo(taskCompletionSource, zzqVar.zzc(), null, false, !zzqVar.zzd());
            return;
        }
        zzfn.zza("GamesApiManager", "Successfully authenticated");
        com.google.android.gms.common.internal.zzah.checkMainThread$1("Must be called on the main thread.");
        com.google.android.gms.games.zzh zzhVarZza = com.google.android.gms.games.zzi.zza();
        zzhVarZza.zza(2101523);
        zzhVarZza.zzb(strZzd);
        com.google.android.gms.games.internal.zzh zzhVarZzd = com.google.android.gms.games.internal.zzi.zzd();
        zzhVarZzd.zza(true);
        zzhVarZzd.zzb(true);
        zzhVarZzd.zzc(true);
        zzhVarZza.zzc(zzhVarZzd.zzd());
        zzf zzfVar = new zzf(this.zzf, zzhVarZza.zzd());
        this.zze.set(zzfVar);
        this.zza.set(zzba.AUTHENTICATED);
        taskCompletionSource.trySetResult(Boolean.TRUE);
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            ((zzbc) it.next()).zza(zzfVar);
            it.remove();
        }
    }

    public final /* synthetic */ void zzl(TaskCompletionSource taskCompletionSource, int i, Task task) {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            zzfw.zza(exception);
            zzfn.zzf("GamesApiManager", "Resolution failed", exception);
            zzo(taskCompletionSource, i, null, false, true);
            return;
        }
        com.google.android.gms.games.internal.v2.resolution.zzc zzcVar = (com.google.android.gms.games.internal.v2.resolution.zzc) task.getResult();
        if (zzcVar.zzc()) {
            zzfn.zza("GamesApiManager", "Resolution successful");
            zzn(taskCompletionSource, zzq.zzb(i, zzx.zza(zzcVar.zzd())));
        } else {
            zzfn.zza("GamesApiManager", "Resolution attempt was canceled");
            zzo(taskCompletionSource, i, null, false, true);
        }
    }

    private final void zzo(final TaskCompletionSource taskCompletionSource, final int i, PendingIntent pendingIntent, boolean z, boolean z2) {
        PackageInfo packageInfo;
        boolean z3;
        Activity activityZzd;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        com.google.android.gms.common.internal.zzah.checkMainThread$1("Must be called on the main thread.");
        Application application = this.zzf;
        PackageInfo packageInfo2 = null;
        try {
            packageInfo = Wrappers.packageManager(application).getPackageInfo(128, "com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        int i2 = -1;
        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && (bundle = applicationInfo.metaData) != null) {
            i2 = bundle.getInt("com.google.android.gms.version", -1);
        }
        Locale locale = Locale.US;
        zzfn.zza("GamesApiManager", "GmsCore version is " + i2);
        if (i2 < 220812000) {
            try {
                packageInfo2 = Wrappers.packageManager(application).getPackageInfo(128, "com.android.vending");
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            if (packageInfo2 == null) {
                zzfn.zza("GamesApiManager", "PlayStore is not installed");
            } else {
                int i3 = packageInfo2.versionCode;
                if (i3 < 82470600) {
                    zzfn.zza("GamesApiManager", "PlayStore version is below resolution threshold: " + i3);
                } else {
                    zzfn.zza("GamesApiManager", "Installed PlayStore version can be used for resolution.");
                }
            }
            zzfn.zze("GamesApiManager", "PlayStore is too old or not available and the version of GmsCore would attempt PGA installation on automatic sign-in. Skipping it.");
            taskCompletionSource.trySetResult(Boolean.FALSE);
            this.zza.set(zzba.AUTHENTICATION_FAILED);
            return;
        }
        if (z && pendingIntent != null && (activityZzd = this.zzg.zzd()) != null) {
            com.google.android.gms.games.internal.v2.resolution.zzb.zzb(activityZzd, pendingIntent).addOnCompleteListener(TaskExecutors.MAIN_THREAD, new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzbj
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final /* synthetic */ void onComplete(Task task) {
                    this.zza.zzl(taskCompletionSource, i, task);
                }
            });
            zzfn.zza("GamesApiManager", "Resolution triggered");
            return;
        }
        AtomicReference atomicReference = this.zzb;
        zzaz zzazVar = zzaz.AUTOMATIC_PENDING_EXPLICIT;
        zzaz zzazVar2 = zzaz.EXPLICIT;
        while (true) {
            if (atomicReference.compareAndSet(zzazVar, zzazVar2)) {
                z3 = true;
                break;
            } else if (atomicReference.get() != zzazVar) {
                z3 = false;
                break;
            }
        }
        if (!z2 && z3) {
            zzfn.zza("GamesApiManager", QTaELkFI.TIjLC);
            zzn(taskCompletionSource, zzq.zza(0));
            return;
        }
        taskCompletionSource.trySetResult(Boolean.FALSE);
        this.zza.set(zzba.AUTHENTICATION_FAILED);
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            ((zzbc) it.next()).zzb(zzr());
            it.remove();
        }
    }

    public final Task zzg(final zzau zzauVar, final List list, Task task) {
        com.google.android.gms.tasks.zzw zzwVarForException;
        if (task.isSuccessful()) {
            return WorkContinuation.forResult((AuthResponse) task.getResult());
        }
        Exception exception = task.getException();
        if (exception instanceof ResolvableApiException) {
            PendingIntent resolution = ((ResolvableApiException) exception).getResolution();
            if (resolution == null) {
                zzwVarForException = WorkContinuation.forException(new IllegalArgumentException("Resolution intent must not be null."));
            } else {
                Activity activityZzd = this.zzg.zzd();
                if (activityZzd == null) {
                    zzwVarForException = WorkContinuation.forException(new IllegalStateException(eoBKjVuj.Zuwer));
                } else {
                    final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                    Task taskZzb = com.google.android.gms.games.internal.v2.resolution.zzb.zzb(activityZzd, resolution);
                    OnSuccessListener onSuccessListener = new OnSuccessListener() { // from class: com.google.android.gms.internal.games_v2.zzbp
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final /* synthetic */ void onSuccess(Object obj) {
                            taskCompletionSource.setResult(obj);
                        }
                    };
                    com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskZzb;
                    zzwVar.getClass();
                    zzwVar.addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
                    zzwVar.addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.internal.games_v2.zzbo
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public final /* synthetic */ void onFailure(Exception exc) {
                            taskCompletionSource.setException(exc);
                        }
                    });
                    zzwVarForException = taskCompletionSource.zza;
                }
            }
            SuccessContinuation successContinuation = new SuccessContinuation() { // from class: com.google.android.gms.internal.games_v2.zzbf
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final /* synthetic */ Task then(Object obj) {
                    return this.zza.zzh(list, zzauVar, (com.google.android.gms.games.internal.v2.resolution.zzc) obj);
                }
            };
            zzwVarForException.getClass();
            com.google.android.gms.tasks.zzu zzuVar = TaskExecutors.MAIN_THREAD;
            com.google.android.gms.tasks.zzw zzwVar2 = new com.google.android.gms.tasks.zzw();
            zzwVarForException.zzb.zza(new com.google.android.gms.tasks.zzh(zzuVar, successContinuation, zzwVar2));
            zzwVarForException.zzi();
            return zzwVar2;
        }
        if (exception == null) {
            exception = new ApiException(new Status(8));
        }
        return WorkContinuation.forException(exception);
    }
}
