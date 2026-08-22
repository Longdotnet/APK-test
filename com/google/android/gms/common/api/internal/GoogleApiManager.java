package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.collection.MapCollections$ArrayIterator;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class GoogleApiManager implements Handler.Callback {
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    public static final Object zac = new Object();
    public static GoogleApiManager zad;
    public long zae;
    public boolean zaf;
    public TelemetryData zag;
    public com.google.android.gms.common.internal.service.zao zah;
    public final Context zai;
    public final GoogleApiAvailability zaj;
    public final com.google.android.gms.common.internal.zal zak;
    public final AtomicInteger zal;
    public final AtomicInteger zam;
    public final ConcurrentHashMap zan;
    public zaae zao;
    public final ArraySet zap;
    public final ArraySet zaq;
    public final com.google.android.gms.internal.base.zau zar;
    public volatile boolean zas;

    public GoogleApiManager(Context context, Looper looper) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        this.zae = 10000L;
        this.zaf = false;
        this.zal = new AtomicInteger(1);
        this.zam = new AtomicInteger(0);
        this.zan = new ConcurrentHashMap(5, 0.75f, 1);
        this.zao = null;
        this.zap = new ArraySet(0);
        this.zaq = new ArraySet(0);
        this.zas = true;
        this.zai = context;
        com.google.android.gms.internal.base.zau zauVar = new com.google.android.gms.internal.base.zau(looper, this);
        this.zar = zauVar;
        this.zaj = googleApiAvailability;
        this.zak = new com.google.android.gms.common.internal.zal(googleApiAvailability);
        PackageManager packageManager = context.getPackageManager();
        if (Hex.zzj == null) {
            Hex.zzj = Boolean.valueOf(Hex.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (Hex.zzj.booleanValue()) {
            this.zas = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    public static void reportSignOut() {
        synchronized (zac) {
            try {
                GoogleApiManager googleApiManager = zad;
                if (googleApiManager != null) {
                    googleApiManager.zam.incrementAndGet();
                    com.google.android.gms.internal.base.zau zauVar = googleApiManager.zar;
                    zauVar.sendMessageAtFrontOfQueue(zauVar.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Status zaF(ApiKey apiKey, ConnectionResult connectionResult) {
        return new Status(connectionResult, CoroutineAdapterKt$$ExternalSyntheticLambda0.m("API: ", apiKey.zaa(), " is not available on this device. Connection failed with: ", String.valueOf(connectionResult)));
    }

    public static GoogleApiManager zaj() {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            zzah.checkNotNull(zad, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zad;
        }
        return googleApiManager;
    }

    @ResultIgnorabilityUnspecified
    public static GoogleApiManager zak(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            try {
                if (zad == null) {
                    Looper looper = GmsClientSupervisor.getOrStartHandlerThread().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = GoogleApiAvailability.zaa;
                    zad = new GoogleApiManager(applicationContext, looper);
                }
                googleApiManager = zad;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x028e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0292  */
    /* JADX WARN: Code duplicated, block: B:114:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:115:0x02c5  */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Feature[] featureArrZab;
        int i = message.what;
        com.google.android.gms.internal.base.zau zauVar = this.zar;
        ConcurrentHashMap concurrentHashMap = this.zan;
        TelemetryLoggingOptions telemetryLoggingOptions = TelemetryLoggingOptions.zaa;
        Context context = this.zai;
        zabq zabqVar = null;
        switch (i) {
            case 1:
                this.zae = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                zauVar.removeMessages(12);
                Iterator it = concurrentHashMap.keySet().iterator();
                while (it.hasNext()) {
                    zauVar.sendMessageDelayed(zauVar.obtainMessage(12, (ApiKey) it.next()), this.zae);
                }
                return true;
            case 2:
                zal zalVar = (zal) message.obj;
                for (ApiKey apiKey : zalVar.zab()) {
                    zabq zabqVar2 = (zabq) concurrentHashMap.get(apiKey);
                    if (zabqVar2 == null) {
                        zalVar.zac(apiKey, new ConnectionResult(13), null);
                        return true;
                    }
                    if (zabqVar2.zac.isConnected()) {
                        zalVar.zac(apiKey, ConnectionResult.RESULT_SUCCESS, zabqVar2.zaf().getEndpointPackageName());
                    } else {
                        ConnectionResult connectionResultZad = zabqVar2.zad();
                        if (connectionResultZad != null) {
                            zalVar.zac(apiKey, connectionResultZad, null);
                        } else {
                            zabqVar2.zat(zalVar);
                            zabqVar2.zao();
                        }
                    }
                }
                return true;
            case 3:
                for (zabq zabqVar3 : concurrentHashMap.values()) {
                    zabqVar3.zan();
                    zabqVar3.zao();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zach zachVar = (zach) message.obj;
                zabq zabqVarZaG = (zabq) concurrentHashMap.get(zachVar.zac.getApiKey());
                if (zabqVarZaG == null) {
                    zabqVarZaG = zaG(zachVar.zac);
                }
                if (!zabqVarZaG.zaA() || this.zam.get() == zachVar.zab) {
                    zabqVarZaG.zap(zachVar.zaa);
                } else {
                    zachVar.zaa.zad(zaa);
                    zabqVarZaG.zav();
                }
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (zabq zabqVar4 : concurrentHashMap.values()) {
                    if (zabqVar4.zab() == i2) {
                        zabqVar = zabqVar4;
                        if (zabqVar != null) {
                            Log.wtf("GoogleApiManager", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "Could not find API instance ", " while trying to fail enqueued calls."), new Exception());
                        } else if (connectionResult.zzb == 13) {
                            this.zaj.getClass();
                            int i3 = GooglePlayServicesUtil.$r8$clinit;
                            StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Error resolution was canceled by the user, original error message: ", ConnectionResult.zza(connectionResult.zzb), ": ");
                            sbM21m.append(connectionResult.zzd);
                            zabqVar.zaE(new Status(17, sbM21m.toString()));
                        } else {
                            zabqVar.zaE(zaF(zabqVar.zad, connectionResult));
                        }
                        return true;
                    }
                }
                if (zabqVar != null) {
                    Log.wtf("GoogleApiManager", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "Could not find API instance ", " while trying to fail enqueued calls."), new Exception());
                } else if (connectionResult.zzb == 13) {
                    this.zaj.getClass();
                    int i4 = GooglePlayServicesUtil.$r8$clinit;
                    StringBuilder sbM21m2 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Error resolution was canceled by the user, original error message: ", ConnectionResult.zza(connectionResult.zzb), ": ");
                    sbM21m2.append(connectionResult.zzd);
                    zabqVar.zaE(new Status(17, sbM21m2.toString()));
                } else {
                    zabqVar.zaE(zaF(zabqVar.zad, connectionResult));
                }
                return true;
            case 6:
                if (context.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) context.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabl(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zae = 300000L;
                    }
                }
                return true;
            case 7:
                zaG((GoogleApi) message.obj);
                return true;
            case 9:
                if (concurrentHashMap.containsKey(message.obj)) {
                    ((zabq) concurrentHashMap.get(message.obj)).zau();
                }
                return true;
            case 10:
                ArraySet arraySet = this.zaq;
                Iterator it2 = arraySet.iterator();
                while (true) {
                    MapCollections$ArrayIterator mapCollections$ArrayIterator = (MapCollections$ArrayIterator) it2;
                    if (!mapCollections$ArrayIterator.hasNext()) {
                        arraySet.clear();
                        return true;
                    }
                    zabq zabqVar5 = (zabq) concurrentHashMap.remove((ApiKey) mapCollections$ArrayIterator.next());
                    if (zabqVar5 != null) {
                        zabqVar5.zav();
                    }
                }
                break;
            case 11:
                if (concurrentHashMap.containsKey(message.obj)) {
                    ((zabq) concurrentHashMap.get(message.obj)).zaw();
                }
                return true;
            case 12:
                if (concurrentHashMap.containsKey(message.obj)) {
                    ((zabq) concurrentHashMap.get(message.obj)).zaB();
                }
                return true;
            case 14:
                zaaf zaafVar = (zaaf) message.obj;
                ApiKey apiKeyZaa = zaafVar.zaa();
                if (concurrentHashMap.containsKey(apiKeyZaa)) {
                    zaafVar.zab().setResult(Boolean.valueOf(((zabq) concurrentHashMap.get(apiKeyZaa)).zaO(false)));
                } else {
                    zaafVar.zab().setResult(Boolean.FALSE);
                }
                return true;
            case 15:
                zabs zabsVar = (zabs) message.obj;
                if (concurrentHashMap.containsKey(zabsVar.zaa)) {
                    zabq zabqVar6 = (zabq) concurrentHashMap.get(zabsVar.zaa);
                    if (zabqVar6.zak.contains(zabsVar) && !zabqVar6.zaj) {
                        if (zabqVar6.zac.isConnected()) {
                            zabqVar6.zaG();
                        } else {
                            zabqVar6.zao();
                        }
                    }
                }
                return true;
            case 16:
                zabs zabsVar2 = (zabs) message.obj;
                if (concurrentHashMap.containsKey(zabsVar2.zaa)) {
                    zabq zabqVar7 = (zabq) concurrentHashMap.get(zabsVar2.zaa);
                    if (zabqVar7.zak.remove(zabsVar2)) {
                        GoogleApiManager googleApiManager = zabqVar7.zaa;
                        googleApiManager.zar.removeMessages(15, zabsVar2);
                        googleApiManager.zar.removeMessages(16, zabsVar2);
                        LinkedList linkedList = zabqVar7.zab;
                        ArrayList arrayList = new ArrayList(linkedList.size());
                        Iterator it3 = linkedList.iterator();
                        while (true) {
                            boolean zHasNext = it3.hasNext();
                            Feature feature = zabsVar2.zab;
                            if (zHasNext) {
                                zai zaiVar = (zai) it3.next();
                                if ((zaiVar instanceof zac) && (featureArrZab = ((zac) zaiVar).zab(zabqVar7)) != null && Hex.contains(featureArrZab, feature)) {
                                    arrayList.add(zaiVar);
                                }
                            } else {
                                int size = arrayList.size();
                                for (int i5 = 0; i5 < size; i5++) {
                                    zai zaiVar2 = (zai) arrayList.get(i5);
                                    linkedList.remove(zaiVar2);
                                    zaiVar2.zae(new UnsupportedApiCallException(feature));
                                }
                            }
                        }
                    }
                }
                return true;
            case 17:
                TelemetryData telemetryData = this.zag;
                if (telemetryData != null) {
                    if (telemetryData.zaa > 0 || zaD()) {
                        if (this.zah == null) {
                            this.zah = new com.google.android.gms.common.internal.service.zao(context, com.google.android.gms.common.internal.service.zao.zae, telemetryLoggingOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
                        }
                        this.zah.log(telemetryData);
                    }
                    this.zag = null;
                }
                return true;
            case 18:
                zace zaceVar = (zace) message.obj;
                long j = zaceVar.zac;
                MethodInvocation methodInvocation = zaceVar.zaa;
                int i6 = zaceVar.zab;
                if (j == 0) {
                    TelemetryData telemetryData2 = new TelemetryData(i6, Arrays.asList(methodInvocation));
                    if (this.zah == null) {
                        this.zah = new com.google.android.gms.common.internal.service.zao(context, com.google.android.gms.common.internal.service.zao.zae, telemetryLoggingOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
                    }
                    this.zah.log(telemetryData2);
                } else {
                    TelemetryData telemetryData3 = this.zag;
                    if (telemetryData3 != null) {
                        List list = telemetryData3.zab;
                        if (telemetryData3.zaa != i6 || (list != null && list.size() >= zaceVar.zad)) {
                            zauVar.removeMessages(17);
                            TelemetryData telemetryData4 = this.zag;
                            if (telemetryData4 != null) {
                                if (telemetryData4.zaa > 0 || zaD()) {
                                    if (this.zah == null) {
                                        this.zah = new com.google.android.gms.common.internal.service.zao(context, com.google.android.gms.common.internal.service.zao.zae, telemetryLoggingOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
                                    }
                                    this.zah.log(telemetryData4);
                                }
                                this.zag = null;
                            }
                        } else {
                            TelemetryData telemetryData5 = this.zag;
                            if (telemetryData5.zab == null) {
                                telemetryData5.zab = new ArrayList();
                            }
                            telemetryData5.zab.add(methodInvocation);
                        }
                    }
                    if (this.zag == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(methodInvocation);
                        this.zag = new TelemetryData(i6, arrayList2);
                        zauVar.sendMessageDelayed(zauVar.obtainMessage(17), zaceVar.zac);
                    }
                }
                return true;
            case 19:
                this.zaf = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i);
                return false;
        }
    }

    public final void zaA(zaae zaaeVar) {
        synchronized (zac) {
            try {
                if (this.zao != zaaeVar) {
                    this.zao = zaaeVar;
                    this.zap.clear();
                }
                this.zap.addAll(zaaeVar.zad);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zaD() {
        if (this.zaf) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) com.google.android.gms.common.internal.zah.getInstance().zaa;
        if (rootTelemetryConfiguration != null && !rootTelemetryConfiguration.zzb) {
            return false;
        }
        int i = this.zak.zaa.get(203400000, -1);
        return i == -1 || i == 0;
    }

    public final boolean zaE(ConnectionResult connectionResult, int i) {
        PendingIntent activity;
        GoogleApiAvailability googleApiAvailability = this.zaj;
        googleApiAvailability.getClass();
        Context context = this.zai;
        if (CloseableKt.isInstantApp(context)) {
            return false;
        }
        boolean zHasResolution = connectionResult.hasResolution();
        int i2 = connectionResult.zzb;
        if (zHasResolution) {
            activity = connectionResult.zzc;
        } else {
            activity = null;
            Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(context, null, i2);
            if (errorResolutionIntent != null) {
                activity = PendingIntent.getActivity(context, 0, errorResolutionIntent, com.google.android.gms.internal.common.zzd.zza | 134217728);
            }
        }
        if (activity == null) {
            return false;
        }
        googleApiAvailability.zae(context, i2, PendingIntent.getActivity(context, 0, GoogleApiActivity.zaa(context, activity, i, true), com.google.android.gms.internal.base.zap.zaa | 134217728));
        return true;
    }

    public final zabq zaG(GoogleApi googleApi) {
        ConcurrentHashMap concurrentHashMap = this.zan;
        ApiKey apiKey = googleApi.getApiKey();
        zabq zabqVar = (zabq) concurrentHashMap.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq(this, googleApi);
            concurrentHashMap.put(apiKey, zabqVar);
        }
        if (zabqVar.zaA()) {
            this.zaq.add(apiKey);
        }
        zabqVar.zao();
        return zabqVar;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    public final void zaJ(TaskCompletionSource taskCompletionSource, int i, GoogleApi googleApi) {
        zacd zacdVar;
        if (i != 0) {
            ApiKey apiKey = googleApi.getApiKey();
            if (zaD()) {
                RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) com.google.android.gms.common.internal.zah.getInstance().zaa;
                boolean z = true;
                if (rootTelemetryConfiguration != null) {
                    if (rootTelemetryConfiguration.zzb) {
                        zabq zabqVar = (zabq) this.zan.get(apiKey);
                        if (zabqVar == null) {
                            z = rootTelemetryConfiguration.zzc;
                        } else if (zabqVar.zaf() instanceof BaseGmsClient) {
                            BaseGmsClient baseGmsClient = (BaseGmsClient) zabqVar.zaf();
                            if (!baseGmsClient.hasConnectionInfo() || baseGmsClient.isConnecting()) {
                                z = rootTelemetryConfiguration.zzc;
                            } else {
                                ConnectionTelemetryConfiguration connectionTelemetryConfigurationZab = zacd.zab(zabqVar, baseGmsClient, i);
                                if (connectionTelemetryConfigurationZab != null) {
                                    zabqVar.zam++;
                                    z = connectionTelemetryConfigurationZab.zzc;
                                }
                            }
                        }
                    }
                    zacdVar = null;
                }
                zacdVar = new zacd(this, i, apiKey, z ? System.currentTimeMillis() : 0L, z ? SystemClock.elapsedRealtime() : 0L);
            } else {
                zacdVar = null;
            }
            if (zacdVar != null) {
                zzw zzwVar = taskCompletionSource.zza;
                final com.google.android.gms.internal.base.zau zauVar = this.zar;
                zauVar.getClass();
                zzwVar.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.zabk
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        zauVar.post(runnable);
                    }
                }, zacdVar);
            }
        }
    }

    public final int zaa() {
        return this.zal.getAndIncrement();
    }

    public final Task zam(Iterable iterable) {
        zal zalVar = new zal(iterable);
        com.google.android.gms.internal.base.zau zauVar = this.zar;
        zauVar.sendMessage(zauVar.obtainMessage(2, zalVar));
        return zalVar.zaa();
    }

    @ResultIgnorabilityUnspecified
    public final Task zan(GoogleApi googleApi) {
        zaaf zaafVar = new zaaf(googleApi.getApiKey());
        com.google.android.gms.internal.base.zau zauVar = this.zar;
        zauVar.sendMessage(zauVar.obtainMessage(14, zaafVar));
        return zaafVar.zab().zza;
    }

    public final Task zao(GoogleApi googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaJ(taskCompletionSource, registerListenerMethod.zaa(), googleApi);
        zach zachVar = new zach(new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource), this.zam.get(), googleApi);
        com.google.android.gms.internal.base.zau zauVar = this.zar;
        zauVar.sendMessage(zauVar.obtainMessage(8, zachVar));
        return taskCompletionSource.zza;
    }

    public final Task zap(GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, int i) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaJ(taskCompletionSource, i, googleApi);
        zach zachVar = new zach(new zah(listenerKey, taskCompletionSource), this.zam.get(), googleApi);
        com.google.android.gms.internal.base.zau zauVar = this.zar;
        zauVar.sendMessage(zauVar.obtainMessage(13, zachVar));
        return taskCompletionSource.zza;
    }

    public final void zau(GoogleApi googleApi, int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zach zachVar = new zach(new zae(i, apiMethodImpl), this.zam.get(), googleApi);
        com.google.android.gms.internal.base.zau zauVar = this.zar;
        zauVar.sendMessage(zauVar.obtainMessage(4, zachVar));
    }

    public final void zav(GoogleApi googleApi, int i, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zaJ(taskCompletionSource, taskApiCall.zaa(), googleApi);
        zach zachVar = new zach(new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper), this.zam.get(), googleApi);
        com.google.android.gms.internal.base.zau zauVar = this.zar;
        zauVar.sendMessage(zauVar.obtainMessage(4, zachVar));
    }

    public final void zax(ConnectionResult connectionResult, int i) {
        if (zaE(connectionResult, i)) {
            return;
        }
        com.google.android.gms.internal.base.zau zauVar = this.zar;
        zauVar.sendMessage(zauVar.obtainMessage(5, i, 0, connectionResult));
    }

    public final void zay() {
        com.google.android.gms.internal.base.zau zauVar = this.zar;
        zauVar.sendMessage(zauVar.obtainMessage(3));
    }

    public final void zaz(GoogleApi googleApi) {
        com.google.android.gms.internal.base.zau zauVar = this.zar;
        zauVar.sendMessage(zauVar.obtainMessage(7, googleApi));
    }
}
