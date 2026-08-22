package com.facebook;

import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.Log;
import android.util.Pair;
import android.view.ContentInfo;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TooltipPopup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ContentInfoCompat$$ExternalSyntheticApiModelOutline0;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatApi25Impl;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.RoomOpenHelper;
import androidx.work.impl.WorkerWrapper;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProxyBillingActivityV2;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.android.installreferrer.api.InstallReferrerClientImpl;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent;
import com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory$InstanceHolder;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzk;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.nonagon.signalgeneration.zzau;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.gms.common.internal.service.zao;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzgdj;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.measurement.internal.zzdu;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzew;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzkc;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.android.gms.measurement.internal.zzla;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzc;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1$1;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.zzaa;
import com.google.protobuf.DescriptorProtos;
import com.yoyogames.runner.RunnerJNILib;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AccessTokenCache implements AppCompatTextView.SuperCaller, ContentInfoCompat.BuilderCompat, Observer, ActivityResultCallback, CancellationSignal.OnCancelListener, SkuDetailsResponseListener, Factory, zzk, zzgdj, RemoteCall, zzla, OnSuccessListener, OnFailureListener, OnCanceledListener, Splitter.Strategy {
    public final /* synthetic */ int $r8$classId;
    public Object sharedPreferences;

    public /* synthetic */ AccessTokenCache(int i, boolean z) {
        this.$r8$classId = i;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public void accept(Object obj, Object obj2) {
        Api api = zao.zae;
        zai zaiVar = (zai) ((zap) obj).getService();
        Parcel parcelZaa = zaiVar.zaa();
        zac.zac(parcelZaa, (TelemetryData) this.sharedPreferences);
        zaiVar.zad(1, parcelZaa);
        ((TaskCompletionSource) obj2).setResult(null);
    }

    /* JADX INFO: renamed from: build */
    public DaggerTransportRuntimeComponent m62build() {
        Context context = (Context) this.sharedPreferences;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        DaggerTransportRuntimeComponent daggerTransportRuntimeComponent = new DaggerTransportRuntimeComponent();
        daggerTransportRuntimeComponent.executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory$InstanceHolder.INSTANCE);
        InstanceFactory instanceFactory = new InstanceFactory(context);
        daggerTransportRuntimeComponent.setApplicationContextProvider = instanceFactory;
        daggerTransportRuntimeComponent.metadataBackendRegistryProvider = DoubleCheck.provider(new RoomOpenHelper(instanceFactory, new CreationContextFactory_Factory(instanceFactory, 0), 25, false));
        InstanceFactory instanceFactory2 = daggerTransportRuntimeComponent.setApplicationContextProvider;
        daggerTransportRuntimeComponent.schemaManagerProvider = new CreationContextFactory_Factory(instanceFactory2, 1);
        Provider provider = DoubleCheck.provider(new RoomOpenHelper(daggerTransportRuntimeComponent.schemaManagerProvider, DoubleCheck.provider(new AccessTokenCache(instanceFactory2, 17)), 26, false));
        daggerTransportRuntimeComponent.sQLiteEventStoreProvider = provider;
        GraphRequest.Companion companion = new GraphRequest.Companion(16);
        InstanceFactory instanceFactory3 = daggerTransportRuntimeComponent.setApplicationContextProvider;
        zzaa zzaaVar = new zzaa(instanceFactory3, provider, companion, 17);
        Provider provider2 = daggerTransportRuntimeComponent.executorProvider;
        Provider provider3 = daggerTransportRuntimeComponent.metadataBackendRegistryProvider;
        Request.Builder builder = new Request.Builder(provider2, provider3, zzaaVar, provider, provider);
        TooltipPopup tooltipPopup = new TooltipPopup();
        tooltipPopup.mContext = instanceFactory3;
        tooltipPopup.mContentView = provider3;
        tooltipPopup.mMessageView = provider;
        tooltipPopup.mLayoutParams = zzaaVar;
        tooltipPopup.mTmpDisplayFrame = provider2;
        tooltipPopup.mTmpAnchorPos = provider;
        tooltipPopup.mTmpAppPos = provider;
        daggerTransportRuntimeComponent.transportRuntimeProvider = DoubleCheck.provider(new zzaa(builder, tooltipPopup, new Dispatcher(provider2, provider, zzaaVar, provider), 16));
        return daggerTransportRuntimeComponent;
    }

    @Override // javax.inject.Provider
    public Object get() {
        String packageName = ((Context) ((InstanceFactory) this.sharedPreferences).instance).getPackageName();
        if (packageName != null) {
            return packageName;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.common.base.Splitter.Strategy
    public Iterator iterator(Splitter splitter, String str) {
        return new Splitter$1$1(this, splitter, str);
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.$r8$classId) {
            case 8:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
                }
                FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this.sharedPreferences;
                FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = (FragmentManager.LaunchedFragmentInfo) fragmentManagerImpl.mLaunchedFragments.pollFirst();
                if (launchedFragmentInfo == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                } else {
                    String str = launchedFragmentInfo.mWho;
                    Fragment fragmentFindFragmentByWho = fragmentManagerImpl.mFragmentStore.findFragmentByWho(str);
                    if (fragmentFindFragmentByWho == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                    } else {
                        fragmentFindFragmentByWho.onRequestPermissionsResult(launchedFragmentInfo.mRequestCode, strArr, iArr);
                    }
                }
                break;
            default:
                ActivityResult activityResult = (ActivityResult) obj;
                ProxyBillingActivityV2 proxyBillingActivityV2 = (ProxyBillingActivityV2) this.sharedPreferences;
                proxyBillingActivityV2.getClass();
                Intent intent = activityResult.data;
                int i2 = zzb.zze(intent, "ProxyBillingActivityV2").zza;
                ResultReceiver resultReceiver = proxyBillingActivityV2.zzc;
                if (resultReceiver != null) {
                    resultReceiver.send(i2, intent == null ? null : intent.getExtras());
                }
                int i3 = activityResult.resultCode;
                if (i3 != -1 || i2 != 0) {
                    zzb.zzk("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + i3 + " and billing's responseCode: " + i2);
                }
                proxyBillingActivityV2.finish();
                break;
        }
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        ((SpecialEffectsController$FragmentStateManagerOperation) this.sharedPreferences).cancel();
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public void onCanceled() {
        ((CountDownLatch) this.sharedPreferences).countDown();
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(Object obj) {
        if (((LifecycleOwner) obj) != null) {
            DialogFragment dialogFragment = (DialogFragment) this.sharedPreferences;
            if (dialogFragment.mShowsDialog) {
                View viewRequireView = dialogFragment.requireView();
                if (viewRequireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if (dialogFragment.mDialog != null) {
                    if (Log.isLoggable("FragmentManager", 3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + dialogFragment.mDialog);
                    }
                    dialogFragment.mDialog.setContentView(viewRequireView);
                }
            }
        }
    }

    public void onConsumeResponse(BillingResult billingResult, String str) {
        String strM$1;
        GooglePlayBillingService.AnonymousClass6 anonymousClass6 = (GooglePlayBillingService.AnonymousClass6) this.sharedPreferences;
        if (anonymousClass6.this$0.m_purchaseRequests.containsKey(str)) {
            anonymousClass6.this$0.m_purchaseRequests.remove(str);
        }
        String[] strArr = {"id"};
        double[] dArr = {12007.0d};
        if (billingResult.zza == 0) {
            strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("{ \"success\":true, \"purchaseToken\" : \"", str, "\" }");
        } else {
            Log.d(GooglePlayBillingService.TAG, "purchaseToken: " + str);
            strM$1 = "{ \"success\":false, \"responseCode\" : " + Integer.toString(billingResult.zza) + ", \"purchaseToken\" : \"" + str + "\" }";
        }
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(strArr, null, dArr);
        RunnerJNILib.DsMapAddString(iJCreateDsMap, "response_json", strM$1);
        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 66);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        switch (this.$r8$classId) {
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                ((CountDownLatch) this.sharedPreferences).countDown();
                break;
            default:
                if (exc instanceof FirebaseNetworkException) {
                    zzam.zzg.v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
                    ((zzam) ((zzc) this.sharedPreferences).zzb).zzd();
                }
                break;
        }
    }

    public void onInstallReferrerSetupFinished(int i) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (i != 0) {
                if (i != 2) {
                    return;
                }
                FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("is_referrer_updated", true).apply();
                return;
            }
            try {
                String string = ((InstallReferrerClientImpl) this.sharedPreferences).getInstallReferrer().mOriginalBundle.getString("install_referrer");
                if (string != null && (StringsKt__StringsKt.contains$default(string, "fb") || StringsKt__StringsKt.contains$default(string, "facebook"))) {
                    FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("install_referrer", string).apply();
                }
                FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("is_referrer_updated", true).apply();
            } catch (RemoteException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    @Override // com.android.billingclient.api.SkuDetailsResponseListener
    public void onSkuDetailsResponse(BillingResult billingResult, ArrayList arrayList) {
        if (billingResult.zza != 0) {
            try {
                Log.w(GooglePlayBillingService.TAG, "onSkuDetailsResponse response was unsuccessful! Error Code: " + Integer.toString(billingResult.zza));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(FirebaseAnalytics.Param.SUCCESS, false);
                jSONObject.put("responseCode", billingResult.zza);
                String string = jSONObject.toString();
                int iJCreateDsMap = RunnerJNILib.jCreateDsMap(new String[]{"id"}, null, new double[]{12003.0d});
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "response_json", string);
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 66);
                return;
            } catch (JSONException unused) {
                Log.e(GooglePlayBillingService.TAG, "Malformed JSON data from queryPurchases.");
                return;
            }
        }
        try {
            ((GooglePlayBillingService) this.sharedPreferences).m_skuDetails = arrayList;
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(((SkuDetails) it.next()).zza));
            }
            jSONObject2.put("skuDetails", jSONArray);
            jSONObject2.put(FirebaseAnalytics.Param.SUCCESS, true);
            String string2 = jSONObject2.toString();
            int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(new String[]{"id"}, null, new double[]{12003.0d});
            RunnerJNILib.DsMapAddString(iJCreateDsMap2, "response_json", string2);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 66);
        } catch (JSONException unused2) {
            Log.e(GooglePlayBillingService.TAG, "Malformed JSON data from queryPurchases.");
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((CountDownLatch) this.sharedPreferences).countDown();
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.sharedPreferences).setExtras(bundle);
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setFlags(int i) {
        ((ContentInfo.Builder) this.sharedPreferences).setFlags(i);
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setLinkUri(Uri uri) {
        ((ContentInfo.Builder) this.sharedPreferences).setLinkUri(uri);
    }

    public void zza() {
        zzkc zzkcVar = (zzkc) this.sharedPreferences;
        zzkcVar.zzg();
        zzfr zzfrVar = (zzfr) zzkcVar.mBuilder;
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        zzfrVar.zzr.getClass();
        if (zzewVar.zzk(System.currentTimeMillis())) {
            zzew zzewVar2 = zzfrVar.zzl;
            zzfr.zzP(zzewVar2);
            zzewVar2.zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zza("Detected application was in foreground");
                zzfrVar.zzr.getClass();
                zzc(System.currentTimeMillis(), false);
            }
        }
    }

    public void zzb(long j, boolean z) {
        zzkc zzkcVar = (zzkc) this.sharedPreferences;
        zzkcVar.zzg();
        zzkcVar.zzm$2();
        zzfr zzfrVar = (zzfr) zzkcVar.mBuilder;
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        if (zzewVar.zzk(j)) {
            zzew zzewVar2 = zzfrVar.zzl;
            zzfr.zzP(zzewVar2);
            zzewVar2.zzg.zza(true);
            zzpd.zzc();
            if (zzfrVar.zzk.zzs(null, zzdu.zzam)) {
                zzfrVar.zzh().zzo();
            }
        }
        zzew zzewVar3 = zzfrVar.zzl;
        zzfr.zzP(zzewVar3);
        zzewVar3.zzj.zzb(j);
        zzew zzewVar4 = zzfrVar.zzl;
        zzfr.zzP(zzewVar4);
        if (zzewVar4.zzg.zzb()) {
            zzc(j, z);
        }
    }

    public void zzc(long j, boolean z) {
        zzkc zzkcVar = (zzkc) this.sharedPreferences;
        zzkcVar.zzg();
        zzfr zzfrVar = (zzfr) zzkcVar.mBuilder;
        if (zzfrVar.zzJ()) {
            zzew zzewVar = zzfrVar.zzl;
            zzfr.zzP(zzewVar);
            zzewVar.zzj.zzb(j);
            zzfrVar.zzr.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zzb(Long.valueOf(jElapsedRealtime), "Session started, time");
            long j2 = j / 1000;
            Long lValueOf = Long.valueOf(j2);
            zzhx zzhxVar = zzfrVar.zzt;
            zzfr.zzQ(zzhxVar);
            zzhxVar.zzY(j, lValueOf, "auto", "_sid");
            zzew zzewVar2 = zzfrVar.zzl;
            zzfr.zzP(zzewVar2);
            zzewVar2.zzk.zzb(j2);
            zzew zzewVar3 = zzfrVar.zzl;
            zzfr.zzP(zzewVar3);
            zzewVar3.zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j2);
            if (zzfrVar.zzk.zzs(null, zzdu.zzZ) && z) {
                bundle.putLong("_aib", 1L);
            }
            zzhx zzhxVar2 = zzfrVar.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzH("auto", "_s", bundle, j);
            zznw.zzc();
            if (zzfrVar.zzk.zzs(null, zzdu.zzac)) {
                zzew zzewVar4 = zzfrVar.zzl;
                zzfr.zzP(zzewVar4);
                String strZza = zzewVar4.zzp.zza();
                if (TextUtils.isEmpty(strZza)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", strZza);
                zzhx zzhxVar3 = zzfrVar.zzt;
                zzfr.zzQ(zzhxVar3);
                zzhxVar3.zzH("auto", "_ssr", bundle2, j);
            }
        }
    }

    public /* synthetic */ AccessTokenCache(Object obj, int i) {
        this.$r8$classId = i;
        this.sharedPreferences = obj;
    }

    public AccessTokenCache(zzau zzauVar) {
        this.$r8$classId = 21;
        Objects.requireNonNull(zzauVar);
        this.sharedPreferences = zzauVar;
    }

    public AccessTokenCache(InstallReferrerClientImpl installReferrerClientImpl, GraphRequest.Companion companion) {
        this.$r8$classId = 15;
        this.sharedPreferences = installReferrerClientImpl;
    }

    public AccessTokenCache(int i) {
        Handler handler;
        Handler handlerCreateAsync;
        this.$r8$classId = i;
        switch (i) {
            case 11:
                Looper mainLooper = Looper.getMainLooper();
                if (Build.VERSION.SDK_INT >= 28) {
                    handlerCreateAsync = Handler.createAsync(mainLooper);
                } else {
                    try {
                        handler = (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(mainLooper, null, Boolean.TRUE);
                    } catch (IllegalAccessException e) {
                        e = e;
                        Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                        handler = new Handler(mainLooper);
                    } catch (InstantiationException e2) {
                        e = e2;
                        Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                        handler = new Handler(mainLooper);
                    } catch (NoSuchMethodException e3) {
                        e = e3;
                        Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                        handler = new Handler(mainLooper);
                    } catch (InvocationTargetException e4) {
                        Throwable cause = e4.getCause();
                        if (!(cause instanceof RuntimeException)) {
                            if (cause instanceof Error) {
                                throw ((Error) cause);
                            }
                            throw new RuntimeException(cause);
                        }
                        throw ((RuntimeException) cause);
                    }
                    handlerCreateAsync = handler;
                    break;
                }
                this.sharedPreferences = handlerCreateAsync;
                return;
            case 19:
                this.sharedPreferences = new ConcurrentHashMap();
                new AtomicInteger(0);
                return;
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                this.sharedPreferences = new CountDownLatch(1);
                return;
            default:
                SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicationContext()\n              .getSharedPreferences(\n                  AccessTokenManager.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)");
                this.sharedPreferences = sharedPreferences;
                return;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzk
    public void zza(JsonWriter jsonWriter) throws IOException {
        Object obj = zzl.zzb;
        jsonWriter.name("params").beginObject();
        byte[] bArr = (byte[]) this.sharedPreferences;
        int length = bArr.length;
        String strEncodeToString = Base64.encodeToString(bArr, 0);
        if (length < 10000) {
            jsonWriter.name("body").value(strEncodeToString);
        } else {
            String strZzE = zzf.zzE(strEncodeToString, "MD5");
            if (strZzE != null) {
                jsonWriter.name("bodydigest").value(strZzE);
            }
        }
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public void zzb(Object obj) {
        int i = zze.$r8$clinit;
        zzo.zze("Initialized webview successfully for SDKCore.");
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzkf)).booleanValue()) {
            zzau zzauVar = (zzau) this.sharedPreferences;
            MediaType.Companion.zzd(zzauVar.zzp, "sgs", new Pair("se", "query_g"), new Pair(FirebaseAnalytics.Param.AD_FORMAT, "BANNER"), new Pair("rtype", Integer.toString(6)), new Pair("scar", "true"), new Pair("sgi_rn", Integer.toString(zzauVar.zzH.get())));
            zzauVar.zzG.set(true);
        }
    }

    public AccessTokenCache(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.$r8$classId = 6;
        if (Build.VERSION.SDK_INT >= 25) {
            this.sharedPreferences = new InputContentInfoCompat$InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.sharedPreferences = new zzaa(uri, clipDescription, uri2, 3);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
    public void setFirstBaselineToTopHeight(int i) {
    }

    @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
    public void setLastBaselineToBottomHeight(int i) {
    }

    @Override // com.google.android.gms.measurement.internal.zzla
    public void zza(String str, Bundle bundle) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zzkt zzktVar = (zzkt) this.sharedPreferences;
        if (zIsEmpty) {
            zzfr zzfrVar = zzktVar.zzn;
            if (zzfrVar != null) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzb("_err", "AppId not known when logging event");
                return;
            }
            return;
        }
        zzktVar.zzaz().zzp(new WorkerWrapper.AnonymousClass1(this, str, bundle, 26));
    }

    public AccessTokenCache(ClipData clipData, int i) {
        this.$r8$classId = 5;
        this.sharedPreferences = ContentInfoCompat$$ExternalSyntheticApiModelOutline0.m(clipData, i);
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public ContentInfoCompat build() {
        return new ContentInfoCompat(new Fragment.AnonymousClass7(((ContentInfo.Builder) this.sharedPreferences).build()));
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public void zza(Throwable th) {
        zzv.zza.zzi.zzw(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzau zzauVar = (zzau) this.sharedPreferences;
        zzdso zzdsoVar = zzauVar.zzp;
        Pair pair = new Pair("sgf_reason", th.getMessage());
        Pair pair2 = new Pair("se", "query_g");
        Pair pair3 = new Pair(FirebaseAnalytics.Param.AD_FORMAT, "BANNER");
        Pair pair4 = new Pair("rtype", Integer.toString(6));
        Pair pair5 = new Pair("scar", "true");
        AtomicInteger atomicInteger = zzauVar.zzH;
        MediaType.Companion.zzd(zzdsoVar, "sgf", pair, pair2, pair3, pair4, pair5, new Pair("sgi_rn", Integer.toString(atomicInteger.get())));
        int i = zze.$r8$clinit;
        zzo.zzh("Failed to initialize webview for loading SDKCore. ", th);
        zzbcv zzbcvVar = zzbde.zzkf;
        zzbd zzbdVar = zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() || zzauVar.zzG.get() || atomicInteger.getAndIncrement() >= ((Integer) zzbdVar.zzd.zzb(zzbde.zzkg)).intValue()) {
            return;
        }
        zzauVar.zzT();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
    public void setLineHeight(int i, float f) {
    }

    /* JADX INFO: renamed from: zza */
    public boolean m63zza() {
        zzfr zzfrVar = (zzfr) this.sharedPreferences;
        if (!TextUtils.isEmpty(zzfrVar.zzf)) {
            return false;
        }
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        return Log.isLoggable(zzehVar.zzq(), 3);
    }
}
