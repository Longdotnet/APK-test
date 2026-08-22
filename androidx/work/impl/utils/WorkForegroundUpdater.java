package androidx.work.impl.utils;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.ForegroundInfo;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.measurement.internal.zzdx;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzjm;
import com.google.android.gms.measurement.internal.zzlb;
import com.google.android.gms.measurement.internal.zzq;
import com.google.firebase.auth.zzaa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class WorkForegroundUpdater {
    public final Processor mForegroundProcessor;
    public final zzaa mTaskExecutor;
    public final WorkSpecDao_Impl mWorkSpecDao;

    /* JADX INFO: renamed from: androidx.work.impl.utils.WorkForegroundUpdater$1, reason: invalid class name */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;
        public final /* synthetic */ Object val$context;
        public final /* synthetic */ Object val$foregroundInfo;
        public final /* synthetic */ Object val$future;
        public final /* synthetic */ Object val$id;

        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
            this.$r8$classId = i;
            this.this$0 = obj;
            this.val$future = obj2;
            this.val$id = obj3;
            this.val$foregroundInfo = obj4;
            this.val$context = obj5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AtomicReference atomicReference;
            switch (this.$r8$classId) {
                case 0:
                    try {
                        if (!(((SettableFuture) this.val$future).value instanceof AbstractFuture.Cancellation)) {
                            String string = ((UUID) this.val$id).toString();
                            int state = ((WorkForegroundUpdater) this.this$0).mWorkSpecDao.getState(string);
                            if (state == 0 || CoroutineAdapterKt$$ExternalSyntheticLambda0._isFinished(state)) {
                                throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                            }
                            ((WorkForegroundUpdater) this.this$0).mForegroundProcessor.startForeground(string, (ForegroundInfo) this.val$foregroundInfo);
                            ((Context) this.val$context).startService(SystemForegroundDispatcher.createNotifyIntent((Context) this.val$context, string, (ForegroundInfo) this.val$foregroundInfo));
                        }
                        ((SettableFuture) this.val$future).set(null);
                        return;
                    } catch (Throwable th) {
                        ((SettableFuture) this.val$future).setException(th);
                        return;
                    }
                case 1:
                    synchronized (((AtomicReference) this.val$future)) {
                        try {
                            try {
                                zzjm zzjmVar = (zzjm) this.this$0;
                                zzdx zzdxVar = zzjmVar.zzb;
                                if (zzdxVar == null) {
                                    zzeh zzehVar = ((zzfr) zzjmVar.mBuilder).zzm;
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzd.zzd("(legacy) Failed to get conditional properties; not connected to service", null, (String) this.val$id, (String) this.val$foregroundInfo);
                                    ((AtomicReference) this.val$future).set(Collections.emptyList());
                                    ((AtomicReference) this.val$future).notify();
                                    return;
                                }
                                if (TextUtils.isEmpty(null)) {
                                    ((AtomicReference) this.val$future).set(zzdxVar.zzf((String) this.val$id, (String) this.val$foregroundInfo, (zzq) this.val$context));
                                } else {
                                    ((AtomicReference) this.val$future).set(zzdxVar.zzg(null, (String) this.val$id, (String) this.val$foregroundInfo));
                                }
                                ((zzjm) this.this$0).zzQ();
                                atomicReference = (AtomicReference) this.val$future;
                                atomicReference.notify();
                                return;
                            } catch (Throwable th2) {
                                ((AtomicReference) this.val$future).notify();
                                throw th2;
                            }
                        } catch (RemoteException e) {
                            zzeh zzehVar2 = ((zzfr) ((zzjm) this.this$0).mBuilder).zzm;
                            zzfr.zzR(zzehVar2);
                            zzehVar2.zzd.zzd("(legacy) Failed to get conditional properties; remote exception", null, (String) this.val$id, e);
                            ((AtomicReference) this.val$future).set(Collections.emptyList());
                            atomicReference = (AtomicReference) this.val$future;
                        }
                    }
                    break;
                default:
                    zzq zzqVar = (zzq) this.val$foregroundInfo;
                    String str = (String) this.val$id;
                    String str2 = (String) this.val$future;
                    zzcf zzcfVar = (zzcf) this.val$context;
                    zzjm zzjmVar2 = (zzjm) this.this$0;
                    zzfr zzfrVar = (zzfr) zzjmVar2.mBuilder;
                    ArrayList arrayList = new ArrayList();
                    try {
                        try {
                            zzdx zzdxVar2 = zzjmVar2.zzb;
                            if (zzdxVar2 == null) {
                                zzeh zzehVar3 = zzfrVar.zzm;
                                zzfr.zzR(zzehVar3);
                                zzehVar3.zzd.zzc(str2, "Failed to get conditional properties; not connected to service", str);
                            } else {
                                arrayList = zzlb.zzH(zzdxVar2.zzf(str2, str, zzqVar));
                                zzjmVar2.zzQ();
                            }
                            break;
                        } catch (RemoteException e2) {
                            zzeh zzehVar4 = zzfrVar.zzm;
                            zzfr.zzR(zzehVar4);
                            zzehVar4.zzd.zzd("Failed to get conditional properties; remote exception", str2, str, e2);
                            break;
                        }
                        return;
                    } finally {
                        zzlb zzlbVar = zzfrVar.zzp;
                        zzfr.zzP(zzlbVar);
                        zzlbVar.zzQ(zzcfVar, arrayList);
                    }
            }
        }
    }

    static {
        Logger$LogcatLogger.tagWithPrefix("WMFgUpdater");
    }

    public WorkForegroundUpdater(WorkDatabase workDatabase, Processor processor, zzaa zzaaVar) {
        this.mForegroundProcessor = processor;
        this.mTaskExecutor = zzaaVar;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }
}
