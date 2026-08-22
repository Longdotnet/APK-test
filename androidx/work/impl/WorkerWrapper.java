package androidx.work.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.app.job.JobParameters;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.TextureView;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.core.provider.FontRequestWorker;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.InputMergerFactory$1;
import androidx.work.ListenableWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import com.android.billingclient.api.BillingClientImpl;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.zzcb;
import com.android.billingclient.api.zzce;
import com.android.billingclient.api.zzo;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.daerisoft.thespikerm.R;
import com.daerisoft.thespikerm.VideoPlayback;
import com.facebook.AccessTokenCache;
import com.facebook.ProfileCache;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.nonagon.signalgeneration.TaggingLibraryJsInterface;
import com.google.android.gms.ads.nonagon.signalgeneration.zzbu;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.ads.zza;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.zac;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzbuh;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzah;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzdx;
import com.google.android.gms.measurement.internal.zzef;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzen;
import com.google.android.gms.measurement.internal.zzew;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfo;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzg;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzhz;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzjm;
import com.google.android.gms.measurement.internal.zzjs;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzlb;
import com.google.android.gms.measurement.internal.zzq;
import com.google.android.gms.measurement.internal.zzs;
import com.google.android.gms.tasks.zzu;
import com.google.common.base.Joiner;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.auth.zzaa;
import com.google.protobuf.DescriptorProtos;
import com.yoyogames.runner.RunnerJNILib;
import com.yoyogames.runner.RunnerJNILib$5$1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import okhttp3.Dispatcher;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkerWrapper implements Runnable {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkerWrapper");
    public Context mAppContext;
    public Configuration mConfiguration;
    public RoomOpenHelper mDependencyDao;
    public Processor mForegroundProcessor;
    public SettableFuture mFuture;
    public ListenableFuture mInnerFuture;
    public volatile boolean mInterrupted;
    public ListenableWorker.Result mResult;
    public zzaa mRuntimeExtras;
    public List mSchedulers;
    public ArrayList mTags;
    public WorkDatabase mWorkDatabase;
    public String mWorkDescription;
    public WorkSpec mWorkSpec;
    public WorkSpecDao_Impl mWorkSpecDao;
    public String mWorkSpecId;
    public RoomOpenHelper mWorkTagDao;
    public zzaa mWorkTaskExecutor;
    public ListenableWorker mWorker;

    /* JADX INFO: renamed from: androidx.work.impl.WorkerWrapper$1 */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public Object this$0;
        public Object val$future;
        public Object val$runExpedited;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }

        private final void run$com$google$android$gms$measurement$internal$zzgc() {
            zzau zzauVar;
            zzgj zzgjVar = (zzgj) this.this$0;
            zzgjVar.getClass();
            zzaw zzawVar = (zzaw) this.val$runExpedited;
            boolean zEquals = "_cmp".equals(zzawVar.zza);
            zzkt zzktVar = zzgjVar.zza;
            if (zEquals && (zzauVar = zzawVar.zzb) != null) {
                Bundle bundle = zzauVar.zza;
                if (bundle.size() != 0) {
                    String string = bundle.getString("_cis");
                    if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                        zzktVar.zzay().zzj.zzb(zzawVar.toString(), "Event has been filtered ");
                        zzawVar = new zzaw("_cmpx", zzawVar.zzb, zzawVar.zzc, zzawVar.zzd);
                    }
                }
            }
            String str = zzawVar.zza;
            zzfi zzfiVar = zzktVar.zzc;
            zzen zzenVar = zzktVar.zzi;
            zzkt.zzal(zzfiVar);
            zzq zzqVar = (zzq) this.val$future;
            String str2 = zzqVar.zza;
            if (!TextUtils.isEmpty(str2)) {
                zzff zzffVar = (zzff) zzfiVar.zzh.getOrDefault(str2, null);
                if (zzffVar != null && zzffVar.zza() != 0) {
                    zzef zzefVar = zzktVar.zzay().zzl;
                    String str3 = zzqVar.zza;
                    zzefVar.zzb(str3, "EES config found for");
                    zzfi zzfiVar2 = zzktVar.zzc;
                    zzkt.zzal(zzfiVar2);
                    zzc zzcVar = TextUtils.isEmpty(str3) ? null : (zzc) zzfiVar2.zzd.get(str3);
                    if (zzcVar == null) {
                        zzktVar.zzay().zzl.zzb(str3, "EES not loaded for");
                        zzgjVar.zzA(zzawVar, zzqVar);
                        return;
                    }
                    try {
                        zzkt.zzal(zzenVar);
                        HashMap mapZzs = zzen.zzs(zzawVar.zzb.zzc(), true);
                        String strZzb = zzg.zzb(str, zzg.zzc, zzg.f3zza);
                        if (strZzb == null) {
                            strZzb = str;
                        }
                        if (zzcVar.zze(new com.google.android.gms.internal.measurement.zzaa(strZzb, zzawVar.zzd, mapZzs))) {
                            if (zzcVar.zzg()) {
                                zzktVar.zzay().zzl.zzb(str, "EES edited event");
                                zzkt.zzal(zzenVar);
                                zzgjVar.zzA(zzen.zzi(zzcVar.zza().zzb()), zzqVar);
                            } else {
                                zzgjVar.zzA(zzawVar, zzqVar);
                            }
                            if (zzcVar.zzf()) {
                                for (com.google.android.gms.internal.measurement.zzaa zzaaVar : zzcVar.zza().zzc()) {
                                    zzktVar.zzay().zzl.zzb(zzaaVar.zzd(), "EES logging created event");
                                    zzkt.zzal(zzenVar);
                                    zzgjVar.zzA(zzen.zzi(zzaaVar), zzqVar);
                                }
                                return;
                            }
                            return;
                        }
                    } catch (zzd unused) {
                        zzktVar.zzay().zzd.zzc(zzqVar.zzb, "EES error. appId, eventName", str);
                    }
                    zzktVar.zzay().zzl.zzb(str, "EES was not applied to event");
                    zzgjVar.zzA(zzawVar, zzqVar);
                    return;
                }
            }
            zzgjVar.zzA(zzawVar, zzqVar);
        }

        /* JADX WARN: Code duplicated, block: B:47:0x009e  */
        /* JADX WARN: Code duplicated, block: B:52:0x00aa  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [androidx.work.impl.WorkerWrapper$1] */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r4v9 */
        private final void run$com$google$android$gms$measurement$internal$zzia() throws Throwable {
            HttpURLConnection httpURLConnection;
            ?? r4;
            ?? r5;
            Throwable th;
            int responseCode;
            IOException e;
            InputStream inputStream;
            zzib zzibVar = (zzib) this.val$future;
            zzfr zzfrVar = (zzfr) zzibVar.mBuilder;
            zzfr zzfrVar2 = (zzfr) zzibVar.mBuilder;
            zzfo zzfoVar = zzfrVar.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzax();
            try {
                URLConnection uRLConnectionOpenConnection = ((URL) this.val$runExpedited).openConnection();
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    throw new IOException("Failed to obtain HTTP connection");
                }
                httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                httpURLConnection.setDefaultUseCaches(false);
                zzfrVar2.getClass();
                r4 = 60000;
                r5 = 60000;
                httpURLConnection.setConnectTimeout(60000);
                zzfrVar2.getClass();
                httpURLConnection.setReadTimeout(61000);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoInput(true);
                try {
                    responseCode = httpURLConnection.getResponseCode();
                    try {
                        try {
                            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                inputStream = httpURLConnection.getInputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i = inputStream.read(bArr);
                                        if (i <= 0) {
                                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                                            inputStream.close();
                                            httpURLConnection.disconnect();
                                            zzb(responseCode, null, byteArray, headerFields);
                                            return;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, i);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            r5 = 0;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzb(responseCode, e, null, r5);
                        } catch (Throwable th4) {
                            th = th4;
                            r4 = 0;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzb(responseCode, null, null, r4);
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzb(responseCode, e, null, r5);
                    } catch (Throwable th5) {
                        th = th5;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzb(responseCode, null, null, r4);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    r5 = 0;
                    e = e;
                    responseCode = 0;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(responseCode, e, null, r5);
                } catch (Throwable th6) {
                    th = th6;
                    r4 = 0;
                    th = th;
                    responseCode = 0;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(responseCode, null, null, r4);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                httpURLConnection = null;
                r5 = 0;
            } catch (Throwable th7) {
                th = th7;
                httpURLConnection = null;
                r4 = 0;
            }
        }

        private final void run$com$google$android$gms$measurement$internal$zzir() {
            AtomicReference atomicReference;
            synchronized (((AtomicReference) this.val$runExpedited)) {
                try {
                    try {
                        zzew zzewVar = ((zzfr) ((zzjm) this.this$0).mBuilder).zzl;
                        zzfr.zzP(zzewVar);
                        if (!zzewVar.zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                            zzeh zzehVar = ((zzfr) ((zzjm) this.this$0).mBuilder).zzm;
                            zzfr.zzR(zzehVar);
                            zzehVar.zzi.zza("Analytics storage consent denied; will not get app instance id");
                            zzhx zzhxVar = ((zzfr) ((zzjm) this.this$0).mBuilder).zzt;
                            zzfr.zzQ(zzhxVar);
                            zzhxVar.zzg.set(null);
                            zzew zzewVar2 = ((zzfr) ((zzjm) this.this$0).mBuilder).zzl;
                            zzfr.zzP(zzewVar2);
                            zzewVar2.zze.zzb(null);
                            ((AtomicReference) this.val$runExpedited).set(null);
                            ((AtomicReference) this.val$runExpedited).notify();
                            return;
                        }
                        zzjm zzjmVar = (zzjm) this.this$0;
                        zzdx zzdxVar = zzjmVar.zzb;
                        if (zzdxVar == null) {
                            zzeh zzehVar2 = ((zzfr) zzjmVar.mBuilder).zzm;
                            zzfr.zzR(zzehVar2);
                            zzehVar2.zzd.zza("Failed to get app instance id");
                            ((AtomicReference) this.val$runExpedited).notify();
                            return;
                        }
                        ((AtomicReference) this.val$runExpedited).set(zzdxVar.zzd((zzq) this.val$future));
                        String str = (String) ((AtomicReference) this.val$runExpedited).get();
                        if (str != null) {
                            zzhx zzhxVar2 = ((zzfr) ((zzjm) this.this$0).mBuilder).zzt;
                            zzfr.zzQ(zzhxVar2);
                            zzhxVar2.zzg.set(str);
                            zzew zzewVar3 = ((zzfr) ((zzjm) this.this$0).mBuilder).zzl;
                            zzfr.zzP(zzewVar3);
                            zzewVar3.zze.zzb(str);
                        }
                        ((zzjm) this.this$0).zzQ();
                        atomicReference = (AtomicReference) this.val$runExpedited;
                        atomicReference.notify();
                    } catch (Throwable th) {
                        ((AtomicReference) this.val$runExpedited).notify();
                        throw th;
                    }
                } catch (RemoteException e) {
                    zzeh zzehVar3 = ((zzfr) ((zzjm) this.this$0).mBuilder).zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zzb(e, "Failed to get app instance id");
                    atomicReference = (AtomicReference) this.val$runExpedited;
                }
            }
        }

        private final void run$com$google$android$gms$measurement$internal$zzis() {
            zzq zzqVar = (zzq) this.val$runExpedited;
            zzcf zzcfVar = (zzcf) this.val$future;
            zzjm zzjmVar = (zzjm) this.this$0;
            zzfr zzfrVar = (zzfr) zzjmVar.mBuilder;
            try {
                try {
                    zzew zzewVar = zzfrVar.zzl;
                    zzfr.zzP(zzewVar);
                    if (!zzewVar.zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzi.zza("Analytics storage consent denied; will not get app instance id");
                        zzhx zzhxVar = zzfrVar.zzt;
                        zzfr.zzQ(zzhxVar);
                        zzhxVar.zzg.set(null);
                        zzew zzewVar2 = zzfrVar.zzl;
                        zzfr.zzP(zzewVar2);
                        zzewVar2.zze.zzb(null);
                        zzlb zzlbVar = zzfrVar.zzp;
                        zzfr.zzP(zzlbVar);
                        zzlbVar.zzV(null, zzcfVar);
                        return;
                    }
                    zzdx zzdxVar = zzjmVar.zzb;
                    if (zzdxVar == null) {
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzd.zza("Failed to get app instance id");
                        zzlb zzlbVar2 = zzfrVar.zzp;
                        zzfr.zzP(zzlbVar2);
                        zzlbVar2.zzV(null, zzcfVar);
                        return;
                    }
                    String strZzd = zzdxVar.zzd(zzqVar);
                    if (strZzd != null) {
                        zzhx zzhxVar2 = zzfrVar.zzt;
                        zzfr.zzQ(zzhxVar2);
                        zzhxVar2.zzg.set(strZzd);
                        zzew zzewVar3 = zzfrVar.zzl;
                        zzfr.zzP(zzewVar3);
                        zzewVar3.zze.zzb(strZzd);
                    }
                    zzjmVar.zzQ();
                    zzlb zzlbVar3 = zzfrVar.zzp;
                    zzfr.zzP(zzlbVar3);
                    zzlbVar3.zzV(strZzd, zzcfVar);
                } catch (RemoteException e) {
                    zzeh zzehVar3 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zzb(e, "Failed to get app instance id");
                    zzlb zzlbVar4 = zzfrVar.zzp;
                    zzfr.zzP(zzlbVar4);
                    zzlbVar4.zzV(null, zzcfVar);
                }
            } catch (Throwable th) {
                zzlb zzlbVar5 = zzfrVar.zzp;
                zzfr.zzP(zzlbVar5);
                zzlbVar5.zzV(null, zzcfVar);
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            zzau zzauVar;
            Bitmap bitmapDecodeFileDescriptor = null;
            Object objCall = null;
            bitmapDecodeFileDescriptor = null;
            boolean zBooleanValue = true;
            boolean zAcceptThirdPartyCookies = false;
            int i = 0;
            zAcceptThirdPartyCookies = false;
            boolean zAcceptThirdPartyCookies2 = false;
            switch (this.$r8$classId) {
                case 0:
                    SettableFuture settableFuture = (SettableFuture) this.val$future;
                    WorkerWrapper workerWrapper = (WorkerWrapper) this.this$0;
                    try {
                        ((SettableFuture) this.val$runExpedited).get();
                        Logger$LogcatLogger.get().debug(WorkerWrapper.TAG, "Starting work for " + workerWrapper.mWorkSpec.workerClassName, new Throwable[0]);
                        ListenableFuture listenableFutureStartWork = workerWrapper.mWorker.startWork();
                        workerWrapper.mInnerFuture = listenableFutureStartWork;
                        settableFuture.setFuture(listenableFutureStartWork);
                        return;
                    } catch (Throwable th) {
                        settableFuture.setException(th);
                        return;
                    }
                case 1:
                    try {
                        objCall = ((FontRequestWorker.AnonymousClass1) this.val$runExpedited).call();
                        break;
                    } catch (Exception unused) {
                    }
                    ((Handler) this.this$0).post(new zza((FontRequestWorker.AnonymousClass2) this.val$future, objCall, 5));
                    return;
                case 2:
                    ArrayList arrayList = (ArrayList) this.val$runExpedited;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) this.val$future;
                    if (arrayList.contains(specialEffectsController$FragmentStateManagerOperation)) {
                        arrayList.remove(specialEffectsController$FragmentStateManagerOperation);
                        ((DefaultSpecialEffectsController) this.this$0).getClass();
                        Fragment$$ExternalSyntheticOutline0._applyState(specialEffectsController$FragmentStateManagerOperation.mFragment.mView, specialEffectsController$FragmentStateManagerOperation.mFinalState);
                        return;
                    }
                    return;
                case 3:
                    try {
                        zBooleanValue = ((Boolean) ((SettableFuture) this.val$runExpedited).get()).booleanValue();
                        break;
                    } catch (InterruptedException | ExecutionException unused2) {
                    }
                    ((Processor) this.val$future).onExecuted((String) this.this$0, zBooleanValue);
                    return;
                case 4:
                    String str = (String) this.val$future;
                    WorkerWrapper workerWrapper2 = (WorkerWrapper) this.this$0;
                    try {
                        try {
                            ListenableWorker.Result result = (ListenableWorker.Result) ((SettableFuture) this.val$runExpedited).get();
                            if (result == null) {
                                Logger$LogcatLogger.get().error(WorkerWrapper.TAG, workerWrapper2.mWorkSpec.workerClassName + " returned a null result. Treating it as a failure.", new Throwable[0]);
                            } else {
                                Logger$LogcatLogger.get().debug(WorkerWrapper.TAG, String.format("%s returned a %s result.", workerWrapper2.mWorkSpec.workerClassName, result), new Throwable[0]);
                                workerWrapper2.mResult = result;
                            }
                            break;
                        } catch (InterruptedException e) {
                            e = e;
                            Logger$LogcatLogger.get().error(WorkerWrapper.TAG, str + " failed because it threw an exception/error", e);
                        } catch (CancellationException e2) {
                            Logger$LogcatLogger.get().info(WorkerWrapper.TAG, str + " was cancelled", e2);
                        } catch (ExecutionException e3) {
                            e = e3;
                            Logger$LogcatLogger.get().error(WorkerWrapper.TAG, str + " failed because it threw an exception/error", e);
                        }
                        workerWrapper2.onWorkFinished();
                        return;
                    } catch (Throwable th2) {
                        workerWrapper2.onWorkFinished();
                        throw th2;
                    }
                case 5:
                    BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.this$0;
                    Context context = (Context) this.val$future;
                    Intent intent = (Intent) this.val$runExpedited;
                    try {
                        boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                        boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                        boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                        Logger$LogcatLogger.get().debug(ConstraintProxyUpdateReceiver.TAG, "Updating proxies: BatteryNotLowProxy enabled (" + booleanExtra + "), BatteryChargingProxy enabled (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy enabled (" + booleanExtra4 + ")", new Throwable[0]);
                        PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                        PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                        PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                        PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                        return;
                    } finally {
                        pendingResult.finish();
                    }
                case 6:
                    WorkSpec workSpec = ((WorkDatabase) this.val$runExpedited).workSpecDao().getWorkSpec((String) this.val$future);
                    if (workSpec == null || !workSpec.hasConstraints()) {
                        return;
                    }
                    synchronized (((SystemForegroundDispatcher) this.this$0).mLock) {
                        ((SystemForegroundDispatcher) this.this$0).mWorkSpecById.put((String) this.val$future, workSpec);
                        ((SystemForegroundDispatcher) this.this$0).mTrackedWorkSpecs.add(workSpec);
                        SystemForegroundDispatcher systemForegroundDispatcher = (SystemForegroundDispatcher) this.this$0;
                        systemForegroundDispatcher.mConstraintsTracker.replace(systemForegroundDispatcher.mTrackedWorkSpecs);
                        break;
                    }
                    return;
                case 7:
                    ((WorkManagerImpl) this.val$runExpedited).mProcessor.startWork((String) this.val$future, (zzaa) this.this$0);
                    return;
                case 8:
                    BillingClientImpl billingClientImpl = (BillingClientImpl) this.val$runExpedited;
                    billingClientImpl.getClass();
                    BillingResult billingResult = zzce.zzn;
                    billingClientImpl.zzap(zzcb.zza(24, 4, billingResult));
                    ((AccessTokenCache) this.val$future).onConsumeResponse(billingResult, ((Joiner) this.this$0).separator);
                    return;
                case 9:
                    VideoPlayback videoPlayback = (VideoPlayback) this.this$0;
                    String str2 = (String) this.val$future;
                    VideoPlayback videoPlayback2 = (VideoPlayback) this.val$runExpedited;
                    try {
                        try {
                            if (VideoPlayback.mInitialised) {
                                Log.i(GooglePlayBillingService.TAG, "Please close video player before attempting to play a new one");
                            } else {
                                Context context2 = RunnerJNILib.ms_context;
                                VideoPlayback.mContext = context2;
                                VideoPlayback.mAssetManager = context2.getResources().getAssets();
                                MediaPlayer mediaPlayer = new MediaPlayer();
                                VideoPlayback.mMediaPlayer = mediaPlayer;
                                mediaPlayer.setAudioStreamType(3);
                                VideoPlayback.mMediaPlayer.setOnCompletionListener(videoPlayback2);
                                VideoPlayback.mMediaPlayer.setOnInfoListener(videoPlayback2);
                                VideoPlayback.mMediaPlayer.setOnErrorListener(videoPlayback2);
                                VideoPlayback.mMediaPlayer.setOnPreparedListener(videoPlayback2);
                                VideoPlayback.mMediaPlayer.setOnBufferingUpdateListener(videoPlayback2);
                                VideoPlayback.mMediaPlayer.setOnSeekCompleteListener(videoPlayback2);
                                VideoPlayback.mMediaPlayer.setOnVideoSizeChangedListener(videoPlayback2);
                                TextureView textureView = new TextureView(VideoPlayback.mContext);
                                VideoPlayback.mTextureView = textureView;
                                textureView.setSurfaceTextureListener(videoPlayback2);
                                ((ViewGroup) ((Activity) VideoPlayback.mContext).findViewById(R.id.demogl).getParent()).addView(VideoPlayback.mTextureView, 0, new FrameLayout.LayoutParams(1, 1));
                                if (VideoPlayback.mTextureView == null) {
                                    Log.i(GooglePlayBillingService.TAG, "VideoPlayback, failed to create textureview");
                                } else {
                                    VideoPlayback.mMediaPlayer.reset();
                                    AssetFileDescriptor assetFileDescriptorOpenFd = VideoPlayback.mAssetManager.openFd(str2);
                                    VideoPlayback.mMediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                                    assetFileDescriptorOpenFd.close();
                                    VideoPlayback.mMediaPlayer.prepareAsync();
                                    videoPlayback.VideoPlayback_Status = 0;
                                    videoPlayback.player_status = 1;
                                }
                            }
                            return;
                        } catch (Exception unused3) {
                            Log.i(GooglePlayBillingService.TAG, "Unable to find media:" + str2 + " in bundle, trying to play from URL");
                            VideoPlayback.mMediaPlayer.setDataSource(str2);
                            VideoPlayback.mMediaPlayer.prepareAsync();
                            videoPlayback.VideoPlayback_Status = 0;
                            videoPlayback.player_status = 1;
                            return;
                        }
                    } catch (IOException e4) {
                        videoPlayback.VideoPlayback_Status = -1;
                        Log.i(GooglePlayBillingService.TAG, "Exception thrown initing video player:" + e4);
                        return;
                    }
                case 10:
                    zzcfg zzcfgVar = (zzcfg) ((zzo) this.val$runExpedited).zze;
                    if (zzcfgVar != null) {
                        zzcfgVar.zzd((String) this.val$future, (HashMap) this.this$0);
                        return;
                    }
                    return;
                case 11:
                    zzt zztVar = zzv.zza.zzg;
                    TaggingLibraryJsInterface taggingLibraryJsInterface = (TaggingLibraryJsInterface) this.val$runExpedited;
                    Context context3 = taggingLibraryJsInterface.zza;
                    CookieManager cookieManagerZza = zztVar.zza();
                    zAcceptThirdPartyCookies = cookieManagerZza != null ? cookieManagerZza.acceptThirdPartyCookies(taggingLibraryJsInterface.zzb) : false;
                    Bundle bundle = (Bundle) this.val$future;
                    bundle.putBoolean("accept_3p_cookie", zAcceptThirdPartyCookies);
                    QueryInfo.generate(context3, new AdRequest((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(bundle)), (zzbu) this.this$0);
                    return;
                case 12:
                    Object obj = this.val$future;
                    boolean z = obj instanceof WebView;
                    com.google.android.gms.ads.nonagon.signalgeneration.zzo zzoVar = (com.google.android.gms.ads.nonagon.signalgeneration.zzo) this.val$runExpedited;
                    if (z) {
                        Context context4 = zzoVar.zzc;
                        CookieManager cookieManagerZza2 = zzv.zza.zzg.zza();
                        if (cookieManagerZza2 != null) {
                            zAcceptThirdPartyCookies2 = cookieManagerZza2.acceptThirdPartyCookies((WebView) obj);
                        }
                    }
                    HashMap map = zzoVar.zza;
                    Boolean boolValueOf = Boolean.valueOf(zAcceptThirdPartyCookies2);
                    com.google.android.gms.ads.nonagon.signalgeneration.zzq zzqVar = (com.google.android.gms.ads.nonagon.signalgeneration.zzq) map.get(boolValueOf);
                    Pair pair = (Pair) this.this$0;
                    if (zzqVar != null) {
                        zzv.zza.zzl.getClass();
                        if (zzqVar.zzc > System.currentTimeMillis()) {
                            zzoVar.zzi(zzqVar, pair, true);
                            return;
                        }
                    }
                    HashMap map2 = zzoVar.zzb;
                    List arrayList2 = (List) map2.get(boolValueOf);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        map2.put(boolValueOf, arrayList2);
                    }
                    arrayList2.add(pair);
                    return;
                case 13:
                    zzdso zzdsoVar = (zzdso) this.val$runExpedited;
                    ConcurrentHashMap concurrentHashMapZzc = zzdsoVar.zzc();
                    String str3 = (String) this.val$future;
                    if (!TextUtils.isEmpty("action") && !TextUtils.isEmpty(str3)) {
                        concurrentHashMapZzc.put("action", str3);
                    }
                    while (true) {
                        Pair[] pairArr = (Pair[]) this.this$0;
                        if (i >= pairArr.length) {
                            zzdsoVar.zzg(concurrentHashMapZzc);
                            return;
                        }
                        Pair pair2 = pairArr[i];
                        String str4 = (String) pair2.first;
                        String str5 = (String) pair2.second;
                        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                            concurrentHashMapZzc.put(str4, str5);
                        }
                        i++;
                    }
                    break;
                case 14:
                    new zzbuh((Context) this.val$runExpedited, AdFormat.BANNER, ((AdRequest) this.val$future).zza, null).zzb((QueryInfoGenerationCallback) this.this$0);
                    return;
                case 15:
                    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                        Log.e("Asserts", CoroutineAdapterKt$$ExternalSyntheticLambda0.m("checkNotMainThread: current thread ", String.valueOf(Thread.currentThread()), " IS the main thread ", String.valueOf(Looper.getMainLooper().getThread()), "!"));
                        throw new IllegalStateException("LoadBitmapFromDiskRunnable can't be executed in the main thread");
                    }
                    Uri uri = (Uri) this.val$runExpedited;
                    ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) this.val$future;
                    if (parcelFileDescriptor != null) {
                        try {
                            bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                        } catch (OutOfMemoryError e5) {
                            Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(uri)), e5);
                        }
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException e6) {
                            Log.e("ImageManager", "closed failed", e6);
                        }
                    }
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    ImageManager imageManager = (ImageManager) this.this$0;
                    imageManager.zae.post(new zac(imageManager, uri, bitmapDecodeFileDescriptor, countDownLatch));
                    try {
                        countDownLatch.await();
                        return;
                    } catch (InterruptedException unused4) {
                        Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(uri)));
                        return;
                    }
                case 16:
                    zzam zzamVar = ((zzgj) this.val$runExpedited).zza.zze;
                    zzkt.zzal(zzamVar);
                    zzamVar.zzg();
                    zzamVar.zzW();
                    String str6 = (String) this.val$future;
                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str6);
                    com.google.android.gms.common.internal.zzah.checkNotEmpty("dep");
                    TextUtils.isEmpty("");
                    Bundle bundle2 = (Bundle) this.this$0;
                    zzfr zzfrVar = (zzfr) zzamVar.mBuilder;
                    if (bundle2 == null || bundle2.isEmpty()) {
                        zzauVar = new zzau(new Bundle());
                    } else {
                        Bundle bundle3 = new Bundle(bundle2);
                        Iterator<String> it = bundle3.keySet().iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next == null) {
                                zzeh zzehVar = zzfrVar.zzm;
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zza("Param name can't be null");
                                it.remove();
                            } else {
                                zzlb zzlbVar = zzfrVar.zzp;
                                zzfr.zzP(zzlbVar);
                                Object objZzA = zzlbVar.zzA(bundle3.get(next), next);
                                if (objZzA == null) {
                                    zzeh zzehVar2 = zzfrVar.zzm;
                                    zzfr.zzR(zzehVar2);
                                    zzehVar2.zzg.zzb(zzfrVar.zzq.zze(next), "Param value can't be null");
                                    it.remove();
                                } else {
                                    zzlb zzlbVar2 = zzfrVar.zzp;
                                    zzfr.zzP(zzlbVar2);
                                    zzlbVar2.zzO(bundle3, next, objZzA);
                                }
                            }
                        }
                        zzauVar = new zzau(bundle3);
                    }
                    zzen zzenVar = zzamVar.zzf.zzi;
                    zzkt.zzal(zzenVar);
                    zzfs zzfsVarZze = zzft.zze();
                    zzfsVarZze.zzl(0L);
                    Bundle bundle4 = zzauVar.zza;
                    for (String str7 : bundle4.keySet()) {
                        zzfw zzfwVarZze = zzfx.zze();
                        zzfwVarZze.zzj(str7);
                        Object obj2 = bundle4.get(str7);
                        com.google.android.gms.common.internal.zzah.checkNotNull(obj2);
                        zzenVar.zzt(zzfwVarZze, obj2);
                        zzfsVarZze.zze(zzfwVarZze);
                    }
                    byte[] bArrZzbu = ((zzft) zzfsVarZze.zzaC()).zzbu();
                    zzeh zzehVar3 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzl.zzc(zzfrVar.zzq.zzd(str6), mnwSv.AWtQnWbyyy, Integer.valueOf(bArrZzbu.length));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str6);
                    contentValues.put("parameters", bArrZzbu);
                    try {
                        if (zzamVar.zzh().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                            zzfr.zzR(zzehVar3);
                            zzehVar3.zzd.zzb(zzeh.zzn(str6), "Failed to insert default event parameters (got -1). appId");
                            return;
                        }
                        return;
                    } catch (SQLiteException e7) {
                        zzfr.zzR(zzehVar3);
                        zzehVar3.zzd.zzc(zzeh.zzn(str6), "Error storing default event parameters. appId", e7);
                        return;
                    }
                case 17:
                    zzgj zzgjVar = (zzgj) this.this$0;
                    zzgjVar.zza.zzA$1();
                    zzac zzacVar = (zzac) this.val$runExpedited;
                    Object objZza = zzacVar.zzc.zza();
                    zzkt zzktVar = zzgjVar.zza;
                    zzq zzqVar2 = (zzq) this.val$future;
                    if (objZza == null) {
                        zzktVar.zzO(zzacVar, zzqVar2);
                        return;
                    } else {
                        zzktVar.zzU(zzacVar, zzqVar2);
                        return;
                    }
                case 18:
                    run$com$google$android$gms$measurement$internal$zzgc();
                    return;
                case 19:
                    zzgj zzgjVar2 = (zzgj) this.this$0;
                    zzgjVar2.zza.zzA$1();
                    zzgjVar2.zza.zzF((zzaw) this.val$runExpedited, (String) this.val$future);
                    return;
                case 20:
                    zzgj zzgjVar3 = (zzgj) this.this$0;
                    zzgjVar3.zza.zzA$1();
                    zzkw zzkwVar = (zzkw) this.val$runExpedited;
                    Object objZza2 = zzkwVar.zza();
                    zzkt zzktVar2 = zzgjVar3.zza;
                    zzq zzqVar3 = (zzq) this.val$future;
                    if (objZza2 == null) {
                        zzktVar2.zzP(zzkwVar, zzqVar3);
                        return;
                    } else {
                        zzktVar2.zzW(zzkwVar, zzqVar3);
                        return;
                    }
                case 21:
                    run$com$google$android$gms$measurement$internal$zzia();
                    return;
                case 22:
                    run$com$google$android$gms$measurement$internal$zzir();
                    return;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    run$com$google$android$gms$measurement$internal$zzis();
                    return;
                case 24:
                    zzq zzqVar4 = (zzq) this.val$runExpedited;
                    zzjm zzjmVar = (zzjm) this.this$0;
                    zzdx zzdxVar = zzjmVar.zzb;
                    zzfr zzfrVar2 = (zzfr) zzjmVar.mBuilder;
                    if (zzdxVar == null) {
                        zzeh zzehVar4 = zzfrVar2.zzm;
                        zzfr.zzR(zzehVar4);
                        zzehVar4.zzd.zza("Failed to send default event parameters to service");
                        return;
                    } else {
                        try {
                            zzdxVar.zzr((Bundle) this.val$future, zzqVar4);
                            return;
                        } catch (RemoteException e8) {
                            zzeh zzehVar5 = zzfrVar2.zzm;
                            zzfr.zzR(zzehVar5);
                            zzehVar5.zzd.zzb(e8, "Failed to send default event parameters to service");
                            return;
                        }
                    }
                case 25:
                    ProfileCache profileCache = (ProfileCache) this.val$runExpedited;
                    ((zzeh) this.val$future).zzl.zza("AppMeasurementJobService processed last upload request.");
                    ((zzjs) ((Service) profileCache.sharedPreferences)).zzb((JobParameters) this.this$0);
                    return;
                case 26:
                    AccessTokenCache accessTokenCache = (AccessTokenCache) this.this$0;
                    zzlb zzlbVarZzv = ((zzkt) accessTokenCache.sharedPreferences).zzv();
                    zzkt zzktVar3 = (zzkt) accessTokenCache.sharedPreferences;
                    ((DefaultClock) zzktVar3.zzav()).getClass();
                    zzaw zzawVarZzz = zzlbVarZzv.zzz("_err", (Bundle) this.val$future, "auto", System.currentTimeMillis(), false);
                    com.google.android.gms.common.internal.zzah.checkNotNull(zzawVarZzz);
                    zzktVar3.zzF(zzawVarZzz, (String) this.val$runExpedited);
                    return;
                default:
                    AlertDialog.Builder builder = new AlertDialog.Builder(RunnerJNILib.ms_context);
                    EditText editText = new EditText(RunnerJNILib.ms_context);
                    editText.setText((String) this.val$runExpedited);
                    builder.setView(editText);
                    builder.setMessage((String) this.val$future).setCancelable(false).setPositiveButton("OK", new RunnerJNILib$5$1(this, editText, zAcceptThirdPartyCookies ? 1 : 0));
                    builder.setNegativeButton(JuorMn.ZEpKOsfAdTuiY, new RunnerJNILib.AnonymousClass2.DialogInterfaceOnClickListenerC00072(this, 7));
                    builder.create().show();
                    return;
            }
        }

        public void zzb(int i, IOException iOException, byte[] bArr, Map map) {
            zzfo zzfoVar = ((zzfr) ((zzib) this.val$future).mBuilder).zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new zzhz(this, i, iOException, bArr, map));
        }

        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Object obj3, int i) {
            this.$r8$classId = i;
            this.this$0 = obj;
            this.val$runExpedited = obj2;
            this.val$future = obj3;
        }

        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Object obj3, int i, boolean z) {
            this.$r8$classId = i;
            this.val$runExpedited = obj;
            this.val$future = obj2;
            this.this$0 = obj3;
        }

        public AnonymousClass1(zzib zzibVar, String str, URL url, zzs zzsVar) {
            this.$r8$classId = 21;
            this.val$future = zzibVar;
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
            this.val$runExpedited = url;
            this.this$0 = zzsVar;
        }
    }

    public final void handleResult(ListenableWorker.Result result) {
        boolean z = result instanceof ListenableWorker.Result.Success;
        String str = TAG;
        if (!z) {
            if (result instanceof ListenableWorker.Result.Retry) {
                Logger$LogcatLogger.get().info(str, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Worker result RETRY for ", this.mWorkDescription), new Throwable[0]);
                rescheduleAndResolve();
                return;
            }
            Logger$LogcatLogger.get().info(str, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Worker result FAILURE for ", this.mWorkDescription), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                resetPeriodicAndResolve();
                return;
            } else {
                setFailedAndResolve();
                return;
            }
        }
        Logger$LogcatLogger.get().info(str, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Worker result SUCCESS for ", this.mWorkDescription), new Throwable[0]);
        if (this.mWorkSpec.isPeriodic()) {
            resetPeriodicAndResolve();
            return;
        }
        RoomOpenHelper roomOpenHelper = this.mDependencyDao;
        String str2 = this.mWorkSpecId;
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            workSpecDao_Impl.setState(3, str2);
            workSpecDao_Impl.setOutput(str2, ((ListenableWorker.Result.Success) this.mResult).mOutputData);
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (String str3 : roomOpenHelper.getDependentWorkIds(str2)) {
                if (workSpecDao_Impl.getState(str3) == 5) {
                    RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
                    if (str3 == null) {
                        roomSQLiteQueryAcquire.bindNull(1);
                    } else {
                        roomSQLiteQueryAcquire.bindString(1, str3);
                    }
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) roomOpenHelper.mConfiguration;
                    workDatabase_Impl.assertNotSuspendingTransaction();
                    Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
                    try {
                        boolean z2 = cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        if (z2) {
                            Logger$LogcatLogger.get().info(str, "Setting status to enqueued for " + str3, new Throwable[0]);
                            workSpecDao_Impl.setState(1, str3);
                            workSpecDao_Impl.setPeriodStartTime(jCurrentTimeMillis, str3);
                        }
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            resolve(false);
        } catch (Throwable th2) {
            workDatabase.endTransaction();
            resolve(false);
            throw th2;
        }
    }

    public final void onWorkFinished() {
        boolean zTryCheckForInterruptionAndResolve = tryCheckForInterruptionAndResolve();
        String str = this.mWorkSpecId;
        WorkDatabase workDatabase = this.mWorkDatabase;
        if (!zTryCheckForInterruptionAndResolve) {
            workDatabase.beginTransaction();
            try {
                int state = this.mWorkSpecDao.getState(str);
                Dispatcher dispatcherWorkProgressDao = workDatabase.workProgressDao();
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) dispatcherWorkProgressDao.executorServiceOrNull;
                workDatabase_Impl.assertNotSuspendingTransaction();
                WorkSpecDao_Impl.AnonymousClass2 anonymousClass2 = (WorkSpecDao_Impl.AnonymousClass2) dispatcherWorkProgressDao.runningAsyncCalls;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
                if (str == null) {
                    frameworkSQLiteStatementAcquire.bindNull(1);
                } else {
                    frameworkSQLiteStatementAcquire.bindString(1, str);
                }
                workDatabase_Impl.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire.executeUpdateDelete();
                    workDatabase_Impl.setTransactionSuccessful();
                    workDatabase_Impl.endTransaction();
                    anonymousClass2.release(frameworkSQLiteStatementAcquire);
                    if (state == 0) {
                        resolve(false);
                    } else if (state == 2) {
                        handleResult(this.mResult);
                    } else if (!CoroutineAdapterKt$$ExternalSyntheticLambda0._isFinished(state)) {
                        rescheduleAndResolve();
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                } catch (Throwable th) {
                    workDatabase_Impl.endTransaction();
                    anonymousClass2.release(frameworkSQLiteStatementAcquire);
                    throw th;
                }
            } catch (Throwable th2) {
                workDatabase.endTransaction();
                throw th2;
            }
        }
        List list = this.mSchedulers;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Scheduler) it.next()).cancel(str);
            }
            Schedulers.schedule(this.mConfiguration, workDatabase, list);
        }
    }

    public final void rescheduleAndResolve() {
        String str = this.mWorkSpecId;
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            workSpecDao_Impl.setState(1, str);
            workSpecDao_Impl.setPeriodStartTime(System.currentTimeMillis(), str);
            workSpecDao_Impl.markWorkSpecScheduled(-1L, str);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
            resolve(true);
        }
    }

    public final void resetPeriodicAndResolve() {
        String str = this.mWorkSpecId;
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            workSpecDao_Impl.setPeriodStartTime(System.currentTimeMillis(), str);
            workSpecDao_Impl.setState(1, str);
            workSpecDao_Impl.resetWorkSpecRunAttemptCount(str);
            workSpecDao_Impl.markWorkSpecScheduled(-1L, str);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
            resolve(false);
        }
    }

    public final void resolve(boolean z) {
        ListenableWorker listenableWorker;
        this.mWorkDatabase.beginTransaction();
        try {
            WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = this.mWorkDatabase.workSpecDao();
            workSpecDao_ImplWorkSpecDao.getClass();
            RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(0, "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1");
            WorkDatabase_Impl workDatabase_Impl = workSpecDao_ImplWorkSpecDao.__db;
            workDatabase_Impl.assertNotSuspendingTransaction();
            Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
            try {
                boolean z2 = cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0;
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                if (!z2) {
                    PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);
                }
                if (z) {
                    this.mWorkSpecDao.setState(1, this.mWorkSpecId);
                    this.mWorkSpecDao.markWorkSpecScheduled(-1L, this.mWorkSpecId);
                }
                if (this.mWorkSpec != null && (listenableWorker = this.mWorker) != null && listenableWorker.isRunInForeground()) {
                    Processor processor = this.mForegroundProcessor;
                    String str = this.mWorkSpecId;
                    synchronized (processor.mLock) {
                        processor.mForegroundWorkMap.remove(str);
                        processor.stopForegroundService();
                    }
                }
                this.mWorkDatabase.setTransactionSuccessful();
                this.mWorkDatabase.endTransaction();
                this.mFuture.set(Boolean.valueOf(z));
            } catch (Throwable th) {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                throw th;
            }
        } catch (Throwable th2) {
            this.mWorkDatabase.endTransaction();
            throw th2;
        }
    }

    public final void resolveIncorrectStatus() {
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        String str = this.mWorkSpecId;
        int state = workSpecDao_Impl.getState(str);
        String str2 = TAG;
        if (state == 2) {
            Logger$LogcatLogger.get().debug(str2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Status for ", str, " is RUNNING;not doing any work and rescheduling for later execution"), new Throwable[0]);
            resolve(true);
            return;
        }
        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Status for ", str, " is ");
        sbM21m.append(CoroutineAdapterKt$$ExternalSyntheticLambda0.stringValueOf$3(state));
        sbM21m.append("; not doing any work");
        logger$LogcatLogger.debug(str2, sbM21m.toString(), new Throwable[0]);
        resolve(false);
    }

    public final void setFailedAndResolve() {
        String str = this.mWorkSpecId;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            while (!linkedList.isEmpty()) {
                String str2 = (String) linkedList.remove();
                WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
                if (workSpecDao_Impl.getState(str2) != 6) {
                    workSpecDao_Impl.setState(4, str2);
                }
                linkedList.addAll(this.mDependencyDao.getDependentWorkIds(str2));
            }
            this.mWorkSpecDao.setOutput(str, ((ListenableWorker.Result.Failure) this.mResult).mOutputData);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
            resolve(false);
        }
    }

    public final boolean tryCheckForInterruptionAndResolve() {
        if (!this.mInterrupted) {
            return false;
        }
        Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Work interrupted for ", this.mWorkDescription), new Throwable[0]);
        int state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == 0) {
            resolve(false);
        } else {
            resolve(!CoroutineAdapterKt$$ExternalSyntheticLambda0._isFinished(state));
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00be A[Catch: all -> 0x007d, TryCatch #3 {all -> 0x007d, blocks: (B:14:0x0053, B:17:0x005d, B:21:0x0080, B:23:0x0084, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:39:0x00fb, B:33:0x00be, B:36:0x00cd, B:38:0x00d5), top: B:100:0x0053 }] */
    @Override // java.lang.Runnable
    public final void run() {
        WorkSpec workSpec;
        InputMerger inputMerger;
        Data dataMerge;
        RoomOpenHelper roomOpenHelper = this.mWorkTagDao;
        String str = this.mWorkSpecId;
        ArrayList<String> tagsForWorkSpecId = roomOpenHelper.getTagsForWorkSpecId(str);
        this.mTags = tagsForWorkSpecId;
        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Work [ id=", str, ", tags={ ");
        boolean z = true;
        for (String str2 : tagsForWorkSpecId) {
            if (z) {
                z = false;
            } else {
                sbM21m.append(iafHZUfOuHNwvy.rMfvZbNV);
            }
            sbM21m.append(str2);
        }
        sbM21m.append(" } ]");
        this.mWorkDescription = sbM21m.toString();
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        if (tryCheckForInterruptionAndResolve()) {
            return;
        }
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            WorkSpec workSpec2 = workSpecDao_Impl.getWorkSpec(str);
            this.mWorkSpec = workSpec2;
            String str3 = TAG;
            if (workSpec2 == null) {
                Logger$LogcatLogger.get().error(str3, "Didn't find WorkSpec for id " + str, new Throwable[0]);
                resolve(false);
                workDatabase.setTransactionSuccessful();
            } else {
                if (workSpec2.state == 1) {
                    if (workSpec2.isPeriodic()) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        workSpec = this.mWorkSpec;
                        if (workSpec.periodStartTime != 0) {
                            Logger$LogcatLogger.get().debug(str3, "Delaying execution for " + this.mWorkSpec.workerClassName + " because it is being executed before schedule.", new Throwable[0]);
                            resolve(true);
                            workDatabase.setTransactionSuccessful();
                        }
                    } else {
                        WorkSpec workSpec3 = this.mWorkSpec;
                        if (workSpec3.state == 1 && workSpec3.runAttemptCount > 0) {
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            workSpec = this.mWorkSpec;
                            if (workSpec.periodStartTime != 0 && jCurrentTimeMillis2 < workSpec.calculateNextRunTime()) {
                                Logger$LogcatLogger.get().debug(str3, "Delaying execution for " + this.mWorkSpec.workerClassName + " because it is being executed before schedule.", new Throwable[0]);
                                resolve(true);
                                workDatabase.setTransactionSuccessful();
                            }
                        }
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    boolean zIsPeriodic = this.mWorkSpec.isPeriodic();
                    Configuration configuration = this.mConfiguration;
                    if (zIsPeriodic) {
                        dataMerge = this.mWorkSpec.input;
                    } else {
                        InputMergerFactory$1 inputMergerFactory$1 = configuration.mInputMergerFactory;
                        String str4 = this.mWorkSpec.inputMergerClassName;
                        inputMergerFactory$1.getClass();
                        String str5 = InputMerger.TAG;
                        try {
                            inputMerger = (InputMerger) Class.forName(str4).newInstance();
                        } catch (Exception e) {
                            Logger$LogcatLogger.get().error(InputMerger.TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Trouble instantiating + ", str4), e);
                            inputMerger = null;
                        }
                        if (inputMerger == null) {
                            Logger$LogcatLogger.get().error(str3, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Could not create Input Merger ", this.mWorkSpec.inputMergerClassName), new Throwable[0]);
                            setFailedAndResolve();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.mWorkSpec.input);
                        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(1, "SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)");
                        if (str == null) {
                            roomSQLiteQueryAcquire.bindNull(1);
                        } else {
                            roomSQLiteQueryAcquire.bindString(1, str);
                        }
                        WorkDatabase_Impl workDatabase_Impl = workSpecDao_Impl.__db;
                        workDatabase_Impl.assertNotSuspendingTransaction();
                        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
                        try {
                            ArrayList arrayList2 = new ArrayList(cursorQuery.getCount());
                            while (cursorQuery.moveToNext()) {
                                arrayList2.add(Data.fromByteArray(cursorQuery.getBlob(0)));
                            }
                            cursorQuery.close();
                            roomSQLiteQueryAcquire.release();
                            arrayList.addAll(arrayList2);
                            dataMerge = inputMerger.merge(arrayList);
                        } catch (Throwable th) {
                            cursorQuery.close();
                            roomSQLiteQueryAcquire.release();
                            throw th;
                        }
                    }
                    UUID uuidFromString = UUID.fromString(str);
                    ArrayList arrayList3 = this.mTags;
                    int i = this.mWorkSpec.runAttemptCount;
                    ExecutorService executorService = configuration.mExecutor;
                    zzaa zzaaVar = this.mWorkTaskExecutor;
                    WorkProgressUpdater workProgressUpdater = new WorkProgressUpdater(workDatabase, zzaaVar);
                    WorkForegroundUpdater workForegroundUpdater = new WorkForegroundUpdater(workDatabase, this.mForegroundProcessor, zzaaVar);
                    WorkerParameters workerParameters = new WorkerParameters();
                    workerParameters.mId = uuidFromString;
                    workerParameters.mInputData = dataMerge;
                    workerParameters.mTags = new HashSet(arrayList3);
                    workerParameters.mRuntimeExtras = this.mRuntimeExtras;
                    workerParameters.mRunAttemptCount = i;
                    workerParameters.mBackgroundExecutor = executorService;
                    workerParameters.mWorkTaskExecutor = zzaaVar;
                    WorkerFactory.AnonymousClass1 anonymousClass1 = configuration.mWorkerFactory;
                    workerParameters.mWorkerFactory = anonymousClass1;
                    workerParameters.mProgressUpdater = workProgressUpdater;
                    workerParameters.mForegroundUpdater = workForegroundUpdater;
                    if (this.mWorker == null) {
                        this.mWorker = anonymousClass1.createWorkerWithDefaultFallback(this.mAppContext, this.mWorkSpec.workerClassName, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.mWorker;
                    if (listenableWorker == null) {
                        Logger$LogcatLogger.get().error(str3, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Could not create Worker ", this.mWorkSpec.workerClassName), new Throwable[0]);
                        setFailedAndResolve();
                        return;
                    }
                    if (listenableWorker.isUsed()) {
                        Logger$LogcatLogger.get().error(str3, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Received an already-used Worker ", this.mWorkSpec.workerClassName, "; WorkerFactory should return new instances"), new Throwable[0]);
                        setFailedAndResolve();
                        return;
                    }
                    this.mWorker.setUsed();
                    workDatabase.beginTransaction();
                    try {
                        boolean z2 = true;
                        if (workSpecDao_Impl.getState(str) == 1) {
                            workSpecDao_Impl.setState(2, str);
                            workSpecDao_Impl.incrementWorkSpecRunAttemptCount(str);
                        } else {
                            z2 = false;
                        }
                        workDatabase.setTransactionSuccessful();
                        workDatabase.endTransaction();
                        if (!z2) {
                            resolveIncorrectStatus();
                            return;
                        }
                        if (tryCheckForInterruptionAndResolve()) {
                            return;
                        }
                        SettableFuture settableFuture = new SettableFuture();
                        WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, workForegroundUpdater, this.mWorkTaskExecutor);
                        ((zzu) zzaaVar.zzc).execute(workForegroundRunnable);
                        SettableFuture settableFuture2 = workForegroundRunnable.mFuture;
                        settableFuture2.addListener(new AnonymousClass1(this, settableFuture2, settableFuture, 0), (zzu) zzaaVar.zzc);
                        settableFuture.addListener(new AnonymousClass1(this, settableFuture, this.mWorkDescription, 4), (SerialExecutor) zzaaVar.zza);
                        return;
                    } catch (Throwable th2) {
                        workDatabase.endTransaction();
                        throw th2;
                    }
                }
                resolveIncorrectStatus();
                workDatabase.setTransactionSuccessful();
                Logger$LogcatLogger.get().debug(str3, this.mWorkSpec.workerClassName + " is not in ENQUEUED state. Nothing more to do.", new Throwable[0]);
            }
            workDatabase.endTransaction();
        } catch (Throwable th3) {
            workDatabase.endTransaction();
            throw th3;
        }
    }
}
