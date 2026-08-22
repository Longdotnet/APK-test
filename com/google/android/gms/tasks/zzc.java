package com.google.android.gms.tasks;

import android.content.ComponentName;
import android.os.RemoteException;
import com.facebook.AccessTokenCache;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzpa;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzdu;
import com.google.android.gms.measurement.internal.zzdx;
import com.google.android.gms.measurement.internal.zzdy;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzew;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzie;
import com.google.android.gms.measurement.internal.zzjl;
import com.google.android.gms.measurement.internal.zzjm;
import com.google.android.gms.measurement.internal.zzkc;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.android.gms.measurement.internal.zzlb;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.zzz;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.scheduling.UnlimitedIoScheduler;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public Object zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzc(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.zzb = obj;
        this.zza = obj2;
    }

    private final void run$com$google$android$gms$tasks$zzk() {
        synchronized (((zzh) this.zzb).zzb) {
            try {
                OnFailureListener onFailureListener = (OnFailureListener) ((zzh) this.zzb).zzc;
                if (onFailureListener != null) {
                    Exception exception = ((Task) this.zza).getException();
                    zzah.checkNotNull(exception);
                    onFailureListener.onFailure(exception);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void run$com$google$android$gms$tasks$zzm() {
        synchronized (((zzh) this.zzb).zzb) {
            try {
                OnSuccessListener onSuccessListener = (OnSuccessListener) ((zzh) this.zzb).zzc;
                if (onSuccessListener != null) {
                    onSuccessListener.onSuccess(((Task) this.zza).getResult());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0299  */
    /* JADX WARN: Code duplicated, block: B:162:0x02a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Long lValueOf;
        zzfr zzfrVar;
        zzcf zzcfVar;
        LimitedDispatcher limitedDispatcher;
        switch (this.$r8$classId) {
            case 0:
                if (((zzw) ((Task) this.zza)).zzd) {
                    ((zzd) this.zzb).zzc.zzc();
                    return;
                }
                try {
                    ((zzd) this.zzb).zzc.zzb(((zzd) this.zzb).zzb.then((Task) this.zza));
                    return;
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        ((zzd) this.zzb).zzc.zza((Exception) e.getCause());
                        return;
                    } else {
                        ((zzd) this.zzb).zzc.zza(e);
                        return;
                    }
                } catch (Exception e2) {
                    ((zzd) this.zzb).zzc.zza(e2);
                    return;
                }
            case 1:
                zzgj zzgjVar = (zzgj) this.zzb;
                zzgjVar.zza.zzA$1();
                zzac zzacVar = (zzac) this.zza;
                Object objZza = zzacVar.zzc.zza();
                zzkt zzktVar = zzgjVar.zza;
                if (objZza == null) {
                    zzktVar.getClass();
                    String str = zzacVar.zza;
                    zzah.checkNotNull(str);
                    com.google.android.gms.measurement.internal.zzq zzqVarZzac = zzktVar.zzac(str);
                    if (zzqVarZzac != null) {
                        zzktVar.zzO(zzacVar, zzqVarZzac);
                        return;
                    }
                    return;
                }
                zzktVar.getClass();
                String str2 = zzacVar.zza;
                zzah.checkNotNull(str2);
                com.google.android.gms.measurement.internal.zzq zzqVarZzac2 = zzktVar.zzac(str2);
                if (zzqVarZzac2 != null) {
                    zzktVar.zzU(zzacVar, zzqVarZzac2);
                    return;
                }
                return;
            case 2:
                zzhx zzhxVar = (zzhx) this.zza;
                zzdy zzdyVarZzh = ((zzfr) zzhxVar.mBuilder).zzh();
                String str3 = zzdyVarZzh.zzo;
                String str4 = (String) this.zzb;
                boolean z = false;
                if (str3 != null && !str3.equals(str4)) {
                    z = true;
                }
                zzdyVarZzh.zzo = str4;
                if (z) {
                    ((zzfr) zzhxVar.mBuilder).zzh().zzo();
                    return;
                }
                return;
            case 3:
                zzhx zzhxVar2 = (zzhx) this.zzb;
                zzkc zzkcVar = ((zzfr) zzhxVar2.mBuilder).zzo;
                zzfr.zzQ(zzkcVar);
                zzpa.zzc();
                zzfr zzfrVar2 = (zzfr) zzkcVar.mBuilder;
                boolean zZzs = zzfrVar2.zzk.zzs(null, zzdu.zzau);
                zzeh zzehVar = zzfrVar2.zzm;
                if (zZzs) {
                    zzew zzewVar = zzfrVar2.zzl;
                    zzfr.zzP(zzewVar);
                    if (zzewVar.zzc().zzi(com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE)) {
                        zzfr.zzP(zzewVar);
                        zzfrVar2.zzr.getClass();
                        if (!zzewVar.zzk(System.currentTimeMillis())) {
                            zzfr.zzP(zzewVar);
                            if (zzewVar.zzk.zza() != 0) {
                                zzfr.zzP(zzewVar);
                                lValueOf = Long.valueOf(zzewVar.zzk.zza());
                            }
                        }
                        zzfrVar = (zzfr) zzhxVar2.mBuilder;
                        zzcfVar = (zzcf) this.zza;
                        if (lValueOf == null) {
                            zzlb zzlbVar = zzfrVar.zzp;
                            zzfr.zzP(zzlbVar);
                            zzlbVar.zzU(zzcfVar, lValueOf.longValue());
                            return;
                        } else {
                            try {
                                zzcfVar.zze(null);
                                return;
                            } catch (RemoteException e3) {
                                zzeh zzehVar2 = zzfrVar.zzm;
                                zzfr.zzR(zzehVar2);
                                zzehVar2.zzd.zzb(e3, "getSessionId failed with exception");
                                return;
                            }
                        }
                    }
                    zzfr.zzR(zzehVar);
                    zzehVar.zzi.zza("Analytics storage consent denied; will not get session id");
                } else {
                    zzfr.zzR(zzehVar);
                    zzehVar.zzi.zza("getSessionId has been disabled.");
                }
                lValueOf = null;
                zzfrVar = (zzfr) zzhxVar2.mBuilder;
                zzcfVar = (zzcf) this.zza;
                if (lValueOf == null) {
                    zzcfVar.zze(null);
                    return;
                }
                zzlb zzlbVar2 = zzfrVar.zzp;
                zzfr.zzP(zzlbVar2);
                zzlbVar2.zzU(zzcfVar, lValueOf.longValue());
                return;
            case 4:
                ((zzhx) this.zzb).zzaa((Boolean) this.zza, true);
                return;
            case 5:
                zzjm zzjmVar = (zzjm) this.zzb;
                zzdx zzdxVar = zzjmVar.zzb;
                zzfr zzfrVar3 = (zzfr) zzjmVar.mBuilder;
                if (zzdxVar == null) {
                    zzeh zzehVar3 = zzfrVar3.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zza("Failed to send current screen to service");
                    return;
                }
                try {
                    zzie zzieVar = (zzie) this.zza;
                    if (zzieVar == null) {
                        zzdxVar.zzq(null, null, 0L, zzfrVar3.zze.getPackageName());
                    } else {
                        zzdxVar.zzq(zzieVar.zza, zzieVar.zzb, zzieVar.zzc, zzfrVar3.zze.getPackageName());
                    }
                    zzjmVar.zzQ();
                    return;
                } catch (RemoteException e4) {
                    zzeh zzehVar4 = ((zzfr) zzjmVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar4);
                    zzehVar4.zzd.zzb(e4, "Failed to send current screen to the service");
                    return;
                }
            case 6:
                zzjm.zzo(((zzjl) this.zzb).zza, (ComponentName) this.zza);
                return;
            case 7:
                zzkt zzktVar2 = (zzkt) this.zza;
                zzktVar2.zzA$1();
                zzktVar2.zzaz().zzg();
                if (zzktVar2.zzq == null) {
                    zzktVar2.zzq = new ArrayList();
                }
                zzktVar2.zzq.add((Runnable) this.zzb);
                zzktVar2.zzX();
                return;
            case 8:
                zzhx zzhxVar3 = ((AppMeasurementDynamiteService) this.zzb).zza.zzt;
                zzfr.zzQ(zzhxVar3);
                zzz zzzVar = (zzz) this.zza;
                zzhxVar3.zzg();
                zzhxVar3.zza();
                zzgr zzgrVar = zzhxVar3.zzd;
                if (zzzVar != zzgrVar) {
                    zzah.checkState(zzgrVar == null, "EventInterceptor already set.");
                }
                zzhxVar3.zzd = zzzVar;
                return;
            case 9:
                zzd zzdVar = (zzd) this.zzb;
                try {
                    Task task = (Task) zzdVar.zzb.then((Task) this.zza);
                    if (task == null) {
                        zzdVar.onFailure(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    zzt zztVar = TaskExecutors.zza;
                    task.addOnSuccessListener(zztVar, zzdVar);
                    task.addOnFailureListener(zztVar, zzdVar);
                    zzw zzwVar = (zzw) task;
                    zzwVar.zzb.zza(new zzh(zztVar, (OnCanceledListener) zzdVar));
                    zzwVar.zzi();
                    return;
                } catch (RuntimeExecutionException e5) {
                    if (e5.getCause() instanceof Exception) {
                        zzdVar.zzc.zza((Exception) e5.getCause());
                        return;
                    } else {
                        zzdVar.zzc.zza(e5);
                        return;
                    }
                } catch (Exception e6) {
                    zzdVar.zzc.zza(e6);
                    return;
                }
            case 10:
                synchronized (((zzh) this.zzb).zzb) {
                    try {
                        OnCompleteListener onCompleteListener = (OnCompleteListener) ((zzh) this.zzb).zzc;
                        if (onCompleteListener != null) {
                            onCompleteListener.onComplete((Task) this.zza);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            case 11:
                run$com$google$android$gms$tasks$zzk();
                return;
            case 12:
                run$com$google$android$gms$tasks$zzm();
                return;
            case 13:
                zzh zzhVar = (zzh) this.zzb;
                try {
                    Task taskThen = ((SuccessContinuation) zzhVar.zzb).then(((Task) this.zza).getResult());
                    if (taskThen == null) {
                        zzhVar.onFailure(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    zzt zztVar2 = TaskExecutors.zza;
                    taskThen.addOnSuccessListener(zztVar2, zzhVar);
                    taskThen.addOnFailureListener(zztVar2, zzhVar);
                    zzw zzwVar2 = (zzw) taskThen;
                    zzwVar2.zzb.zza(new zzh(zztVar2, (OnCanceledListener) zzhVar));
                    zzwVar2.zzi();
                    return;
                } catch (RuntimeExecutionException e7) {
                    if (e7.getCause() instanceof Exception) {
                        zzhVar.onFailure((Exception) e7.getCause());
                        return;
                    } else {
                        zzhVar.onFailure(e7);
                        return;
                    }
                } catch (CancellationException unused) {
                    zzhVar.onCanceled();
                    return;
                } catch (Exception e8) {
                    zzhVar.onFailure(e8);
                    return;
                }
            case 14:
                zzw zzwVar3 = (zzw) this.zza;
                try {
                    zzwVar3.zzb(((Callable) this.zzb).call());
                    return;
                } catch (Exception e9) {
                    zzwVar3.zza(e9);
                    return;
                } catch (Throwable th2) {
                    zzwVar3.zza(new RuntimeException(th2));
                    return;
                }
            case 15:
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance((String) this.zza));
                if (firebaseAuth.getCurrentUser() != null) {
                    Task accessToken = firebaseAuth.getAccessToken(true);
                    zzam.zzg.v("Token refreshing started", new Object[0]);
                    accessToken.addOnFailureListener(new AccessTokenCache(this, 29));
                    return;
                }
                return;
            default:
                int i = 0;
                do {
                    try {
                        ((Runnable) this.zza).run();
                    } catch (Throwable th3) {
                        BuildersKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th3);
                    }
                    limitedDispatcher = (LimitedDispatcher) this.zzb;
                    Runnable runnableObtainTaskOrDeallocateWorker = limitedDispatcher.obtainTaskOrDeallocateWorker();
                    if (runnableObtainTaskOrDeallocateWorker == null) {
                        return;
                    }
                    this.zza = runnableObtainTaskOrDeallocateWorker;
                    i++;
                    break;
                } while (i < 16);
                UnlimitedIoScheduler unlimitedIoScheduler = limitedDispatcher.dispatcher;
                unlimitedIoScheduler.getClass();
                unlimitedIoScheduler.dispatch(limitedDispatcher, this);
                return;
        }
    }

    public /* synthetic */ zzc(Object obj, Object obj2, int i, boolean z) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = obj2;
    }

    public zzc(zzam zzamVar, String str) {
        this.$r8$classId = 15;
        this.zzb = zzamVar;
        zzah.checkNotEmpty(str);
        this.zza = str;
    }
}
