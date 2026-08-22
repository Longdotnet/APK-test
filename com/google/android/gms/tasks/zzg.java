package com.google.android.gms.tasks;

import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import com.android.billingclient.api.zzn;
import com.daerisoft.thespikerm.RunnerActivity;
import com.daerisoft.thespikerm.RunnerKeyboardController;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzag;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzen;
import com.google.android.gms.measurement.internal.zzes;
import com.google.android.gms.measurement.internal.zzew;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjx;
import com.google.android.gms.measurement.internal.zzka;
import com.google.android.gms.measurement.internal.zzkc;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.android.gms.measurement.internal.zzs;
import com.google.firebase.auth.zzy;
import com.google.firebase.auth.zzz;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;

/* JADX INFO: loaded from: classes.dex */
public final class zzg implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;

    public zzg(zzkt zzktVar, WorkDatabase.AnonymousClass1 anonymousClass1) {
        this.$r8$classId = 2;
        this.zza = zzktVar;
    }

    private final void run$com$google$android$gms$tasks$zzg() {
        synchronized (((zzh) this.zza).zzb) {
            try {
                OnCanceledListener onCanceledListener = (OnCanceledListener) ((zzh) this.zza).zzc;
                if (onCanceledListener != null) {
                    onCanceledListener.onCanceled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        okhttp3.internal.concurrent.Task taskAwaitTaskToRun;
        long jNanoTime;
        switch (this.$r8$classId) {
            case 0:
                run$com$google$android$gms$tasks$zzg();
                return;
            case 1:
                zzjx zzjxVar = (zzjx) this.zza;
                zzz zzzVar = zzjxVar.zzc;
                ((zzkc) zzzVar.zzb).zzg();
                zzkc zzkcVar = (zzkc) zzzVar.zzb;
                zzeh zzehVar = ((zzfr) zzkcVar.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzk.zza("Application going to the background");
                zzfr zzfrVar = (zzfr) zzkcVar.mBuilder;
                zzew zzewVar = zzfrVar.zzl;
                zzfr.zzP(zzewVar);
                zzewVar.zzm.zza(true);
                Bundle bundle = new Bundle();
                if (!zzfrVar.zzk.zzu()) {
                    zzka zzkaVar = zzkcVar.zzb;
                    zzkaVar.zzd.zzb();
                    zzkaVar.zzd(zzjxVar.zzb, false, false);
                }
                zzhx zzhxVar = zzfrVar.zzt;
                zzfr.zzQ(zzhxVar);
                zzhxVar.zzH("auto", "_ab", bundle, zzjxVar.zza);
                return;
            case 2:
                zzkt zzktVar = (zzkt) this.zza;
                zzktVar.zzaz().zzg();
                zzktVar.zzm = new zzs(zzktVar);
                zzam zzamVar = new zzam(zzktVar);
                zzamVar.zzX();
                zzktVar.zze = zzamVar;
                zzag zzagVarZzg = zzktVar.zzg();
                zzfi zzfiVar = zzktVar.zzc;
                zzah.checkNotNull(zzfiVar);
                zzagVarZzg.zzb = zzfiVar;
                zzjo zzjoVar = new zzjo(zzktVar);
                zzjoVar.zzX();
                zzktVar.zzk = zzjoVar;
                zzaa zzaaVar = new zzaa(zzktVar);
                zzaaVar.zzX();
                zzktVar.zzh = zzaaVar;
                zzen zzenVar = new zzen(zzktVar, 1);
                zzenVar.zzX();
                zzktVar.zzj = zzenVar;
                zzkf zzkfVar = new zzkf(zzktVar);
                zzkfVar.zzX();
                zzktVar.zzg = zzkfVar;
                zzktVar.zzf = new zzn(zzktVar);
                if (zzktVar.zzr != zzktVar.zzs) {
                    zzeh zzehVarZzay = zzktVar.zzay();
                    zzehVarZzay.zzd.zzc(Integer.valueOf(zzktVar.zzr), "Not all upload components initialized", Integer.valueOf(zzktVar.zzs));
                }
                zzktVar.zzo = true;
                zzktVar.zzaz().zzg();
                zzam zzamVar2 = zzktVar.zze;
                zzkt.zzal(zzamVar2);
                zzamVar2.zzz();
                if (zzktVar.zzk.zzc.zza() == 0) {
                    zzes zzesVar = zzktVar.zzk.zzc;
                    ((DefaultClock) zzktVar.zzav()).getClass();
                    zzesVar.zzb(System.currentTimeMillis());
                }
                zzktVar.zzag();
                return;
            case 3:
                RunnerKeyboardController runnerKeyboardControllerGetKeyboardController = RunnerActivity.CurrentActivity.GetKeyboardController();
                if (runnerKeyboardControllerGetKeyboardController == null || !runnerKeyboardControllerGetKeyboardController.m_bufferedTextInput) {
                    return;
                }
                runnerKeyboardControllerGetKeyboardController.SetInputString((int[]) this.zza);
                return;
        }
        while (true) {
            synchronized (((TaskRunner) this.zza)) {
                taskAwaitTaskToRun = ((TaskRunner) this.zza).awaitTaskToRun();
            }
            if (taskAwaitTaskToRun == null) {
                return;
            }
            TaskQueue taskQueue = taskAwaitTaskToRun.queue;
            Intrinsics.checkNotNull(taskQueue);
            boolean zIsLoggable = TaskRunner.logger.isLoggable(Level.FINE);
            if (zIsLoggable) {
                zzy zzyVar = taskQueue.taskRunner.backend;
                jNanoTime = System.nanoTime();
                JvmClassMappingKt.access$log(taskAwaitTaskToRun, taskQueue, "starting");
            } else {
                jNanoTime = -1;
            }
            try {
                TaskRunner.access$runTask((TaskRunner) this.zza, taskAwaitTaskToRun);
                if (zIsLoggable) {
                    zzy zzyVar2 = taskQueue.taskRunner.backend;
                    JvmClassMappingKt.access$log(taskAwaitTaskToRun, taskQueue, "finished run in ".concat(JvmClassMappingKt.formatDuration(System.nanoTime() - jNanoTime)));
                }
            } catch (Throwable th) {
                try {
                    ((ThreadPoolExecutor) ((TaskRunner) this.zza).backend.zza).execute(this);
                    throw th;
                } catch (Throwable th2) {
                    if (zIsLoggable) {
                        zzy zzyVar3 = taskQueue.taskRunner.backend;
                        JvmClassMappingKt.access$log(taskAwaitTaskToRun, taskQueue, "failed a run in ".concat(JvmClassMappingKt.formatDuration(System.nanoTime() - jNanoTime)));
                    }
                    throw th2;
                }
            }
        }
    }

    public /* synthetic */ zzg(Object obj, int i) {
        this.$r8$classId = i;
        this.zza = obj;
    }
}
