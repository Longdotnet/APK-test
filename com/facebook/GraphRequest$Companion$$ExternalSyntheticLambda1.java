package com.facebook;

import android.app.Activity;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDelegate$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1;
import androidx.profileinstaller.ProfileInstallerInitializer;
import androidx.work.WorkContinuation;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.daerisoft.thespikerm.GoogleMobileAdsGM;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventCollection;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.appevents.AppEventsLogger$FlushBehavior;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.FlushReason;
import com.facebook.appevents.SessionEventsState;
import com.facebook.appevents.aam.MetadataViewObserver;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.appevents.suggestedevents.FeatureExtractor;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.LazySet;
import com.google.firebase.components.OptionalProvider;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Headers;
import okio.AsyncTimeout;
import okio.Okio;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GraphRequest$Companion$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ GraphRequest$Companion$$ExternalSyntheticLambda1(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Date date;
        boolean z = false;
        int i = 1;
        switch (this.$r8$classId) {
            case 0:
                ArrayList<Pair> arrayList = (ArrayList) this.f$0;
                GraphRequestBatch requests = (GraphRequestBatch) this.f$1;
                Intrinsics.checkNotNullParameter(requests, "$requests");
                for (Pair pair : arrayList) {
                    GraphRequest.Callback callback = (GraphRequest.Callback) pair.first;
                    Object obj = pair.second;
                    Intrinsics.checkNotNullExpressionValue(obj, "pair.second");
                    callback.onCompleted((GraphResponse) obj);
                }
                for (AccessTokenManager$$ExternalSyntheticLambda3 accessTokenManager$$ExternalSyntheticLambda3 : requests.callbacks) {
                    AccessToken accessToken = accessTokenManager$$ExternalSyntheticLambda3.f$1;
                    AccessTokenManager.RefreshResult refreshResult = accessTokenManager$$ExternalSyntheticLambda3.f$0;
                    AtomicBoolean atomicBoolean = accessTokenManager$$ExternalSyntheticLambda3.f$3;
                    Collection collection = accessTokenManager$$ExternalSyntheticLambda3.f$4;
                    Collection collection2 = accessTokenManager$$ExternalSyntheticLambda3.f$5;
                    Collection collection3 = accessTokenManager$$ExternalSyntheticLambda3.f$6;
                    AccessTokenManager this$0 = accessTokenManager$$ExternalSyntheticLambda3.f$7;
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    AtomicBoolean atomicBoolean2 = this$0.tokenRefreshInProgress;
                    String str = (String) refreshResult.accessToken;
                    int i2 = refreshResult.expiresAt;
                    Long l = (Long) refreshResult.dataAccessExpirationTime;
                    String str2 = (String) refreshResult.graphDomain;
                    try {
                        GraphRequest.Companion companion = AccessTokenManager.Companion;
                        if (companion.getInstance().currentAccessTokenField != null) {
                            try {
                                AccessToken accessToken2 = companion.getInstance().currentAccessTokenField;
                                if ((accessToken2 == null ? null : accessToken2.userId) != accessToken.userId) {
                                    atomicBoolean2.set(z);
                                } else if (!atomicBoolean.get() && str == null && i2 == 0) {
                                    atomicBoolean2.set(z);
                                } else {
                                    Date date2 = accessToken.expires;
                                    if (refreshResult.expiresAt != 0) {
                                        date = new Date(((long) refreshResult.expiresAt) * 1000);
                                        l = l;
                                    } else {
                                        if (refreshResult.expiresIn != 0) {
                                            date2 = new Date((((long) refreshResult.expiresIn) * 1000) + new Date().getTime());
                                        }
                                        date = date2;
                                    }
                                    if (str == null) {
                                        str = accessToken.token;
                                    }
                                    String str3 = str;
                                    String str4 = accessToken.applicationId;
                                    String str5 = accessToken.userId;
                                    if (!atomicBoolean.get()) {
                                        collection = accessToken.permissions;
                                    }
                                    Collection collection4 = collection;
                                    if (!atomicBoolean.get()) {
                                        collection2 = accessToken.declinedPermissions;
                                    }
                                    Collection collection5 = collection2;
                                    if (!atomicBoolean.get()) {
                                        collection3 = accessToken.expiredPermissions;
                                    }
                                    Collection collection6 = collection3;
                                    AccessTokenSource accessTokenSource = accessToken.source;
                                    Date date3 = new Date();
                                    Date date4 = l != null ? new Date(l.longValue() * 1000) : accessToken.dataAccessExpirationTime;
                                    if (str2 == null) {
                                        str2 = accessToken.graphDomain;
                                    }
                                    companion.getInstance().setCurrentAccessToken(new AccessToken(str3, str4, str5, collection4, collection5, collection6, accessTokenSource, date, date3, date4, str2), true);
                                    atomicBoolean2.set(false);
                                    z = false;
                                }
                            } catch (Throwable th) {
                                th = th;
                                z = false;
                                atomicBoolean2.set(z);
                                throw th;
                            }
                        } else {
                            atomicBoolean2.set(z);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return;
            case 1:
                ComponentActivity this$1 = (ComponentActivity) this.f$0;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                OnBackPressedDispatcher dispatcher = (OnBackPressedDispatcher) this.f$1;
                Intrinsics.checkNotNullParameter(dispatcher, "$dispatcher");
                this$1.getLifecycle().addObserver(new MenuHostHelper$$ExternalSyntheticLambda1(dispatcher, this$1, 1));
                return;
            case 2:
                Runnable runnable = (Runnable) this.f$1;
                AppCompatDelegate.SerialExecutor serialExecutor = (AppCompatDelegate.SerialExecutor) this.f$0;
                serialExecutor.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    serialExecutor.scheduleNext();
                }
            case 3:
                ((AppCompatTextHelper.AnonymousClass1) this.f$0).onFontRetrieved((Typeface) this.f$1);
                return;
            case 4:
                ((ProfileInstallerInitializer) this.f$0).getClass();
                (Build.VERSION.SDK_INT >= 28 ? ProfileInstallerInitializer.Handler28Impl.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new AppCompatDelegate$$ExternalSyntheticLambda0((Context) this.f$1, i), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
            case 5:
                ((GoogleMobileAdsGM.AdCleaner) this.f$0).clean(this.f$1);
                return;
            case 6:
                ((GoogleMobileAdsGM) this.f$0).lambda$AdMob_Consent_Load$23((Activity) this.f$1);
                return;
            case 7:
                ((GoogleMobileAdsGM) this.f$0).lambda$showAppOpenAd$17((String) this.f$1);
                return;
            case 8:
                GoogleMobileAdsGM.lambda$sendAsyncEvent$28((String) this.f$0, (Map) this.f$1);
                return;
            case 9:
                AccessTokenAppIdPair accessTokenAppId = (AccessTokenAppIdPair) this.f$0;
                AppEvent appEvent = (AppEvent) this.f$1;
                if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(accessTokenAppId, "$accessTokenAppId");
                    AppEventCollection appEventCollection = AppEventQueue.appEventCollection;
                    synchronized (appEventCollection) {
                        SessionEventsState sessionEventsState = appEventCollection.getSessionEventsState(accessTokenAppId);
                        if (sessionEventsState != null) {
                            sessionEventsState.addEvent(appEvent);
                            break;
                        }
                    }
                    if (GraphRequest.Companion.getFlushBehavior() != AppEventsLogger$FlushBehavior.EXPLICIT_ONLY && AppEventQueue.appEventCollection.getEventCount() > 100) {
                        AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
                        return;
                    } else {
                        if (AppEventQueue.scheduledFuture == null) {
                            AppEventQueue.scheduledFuture = AppEventQueue.singleThreadExecutor.schedule(AppEventQueue.flushRunnable, 15L, TimeUnit.SECONDS);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    CrashShieldHandler.handleThrowable(AppEventQueue.class, th3);
                    return;
                }
            case 10:
                AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) this.f$0;
                SessionEventsState sessionEventsState2 = (SessionEventsState) this.f$1;
                if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
                    return;
                }
                try {
                    AsyncTimeout.Companion.persistEvents(accessTokenAppIdPair, sessionEventsState2);
                    return;
                } catch (Throwable th4) {
                    CrashShieldHandler.handleThrowable(AppEventQueue.class, th4);
                    return;
                }
            case 11:
                Context context = (Context) this.f$0;
                AppEventsLoggerImpl appEventsLoggerImpl = (AppEventsLoggerImpl) this.f$1;
                Bundle bundle = new Bundle();
                String[] strArr = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.gamingservices.GamingServices", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"};
                String[] strArr2 = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", FETmZwrVHuasmL.PnjupUcVmQWnQ, "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int i5 = i3 + 1;
                    String str6 = strArr[i3];
                    String str7 = strArr2[i3];
                    try {
                        Class.forName(str6);
                        bundle.putInt(str7, 1);
                        i4 |= 1 << i3;
                    } catch (ClassNotFoundException unused) {
                    }
                    if (i5 > 10) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
                        String str8 = ehgOP.NYGAdgzrkg;
                        if (sharedPreferences.getInt(str8, 0) != i4) {
                            sharedPreferences.edit().putInt(str8, i4).apply();
                            appEventsLoggerImpl.logEventImplicitly(bundle, "fb_sdk_initialize");
                            return;
                        }
                        return;
                    }
                    i3 = i5;
                }
                break;
            case 12:
                View view = (View) this.f$0;
                MetadataViewObserver this$2 = (MetadataViewObserver) this.f$1;
                if (CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class)) {
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(view, MnHfHMYQDPUO.aqsYMScmowqNF);
                    Intrinsics.checkNotNullParameter(this$2, "this$0");
                    if (view instanceof EditText) {
                        this$2.processEditText(view);
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    CrashShieldHandler.handleThrowable(MetadataViewObserver.class, th5);
                    return;
                }
            case 13:
                List list = (List) this.f$1;
                HashSet hashSet = AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE;
                Integer num = (Integer) this.f$0;
                if (CollectionsKt.contains(hashSet, num) || !CollectionsKt.contains(AppEventsConversionsAPITransformerWebRequests.RETRY_EVENTS_HTTP_RESPONSE, num)) {
                    return;
                }
                if (AppEventsConversionsAPITransformerWebRequests.currentRetryCount >= 5) {
                    AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().clear();
                    AppEventsConversionsAPITransformerWebRequests.currentRetryCount = 0;
                    return;
                } else {
                    AppEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().addAll(0, list);
                    AppEventsConversionsAPITransformerWebRequests.currentRetryCount++;
                    return;
                }
            case 14:
                String str9 = (String) this.f$0;
                Bundle bundle2 = (Bundle) this.f$1;
                if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.Companion.class)) {
                    return;
                }
                try {
                    new AppEventsLoggerImpl(FacebookSdk.getApplicationContext(), (String) null).logEvent(str9, bundle2);
                    return;
                } catch (Throwable th6) {
                    CrashShieldHandler.handleThrowable(CodelessMatcher.Companion.class, th6);
                    return;
                }
            case 15:
                ViewIndexer this$3 = (ViewIndexer) this.f$0;
                ViewIndexer$schedule$indexingTask$1 viewIndexer$schedule$indexingTask$1 = (ViewIndexer$schedule$indexingTask$1) this.f$1;
                if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(this$3, "this$0");
                    try {
                        Timer timer = this$3.indexingTimer;
                        if (timer != null) {
                            timer.cancel();
                        }
                        this$3.previousDigest = null;
                        Timer timer2 = new Timer();
                        timer2.scheduleAtFixedRate(viewIndexer$schedule$indexingTask$1, 0L, 1000L);
                        this$3.indexingTimer = timer2;
                        return;
                    } catch (Exception e) {
                        Log.e(ViewIndexer.TAG, "Error scheduling indexing job", e);
                        return;
                    }
                } catch (Throwable th7) {
                    CrashShieldHandler.handleThrowable(ViewIndexer.class, th7);
                    return;
                }
            case 16:
                String str10 = (String) this.f$0;
                ViewIndexer this$4 = (ViewIndexer) this.f$1;
                if (CrashShieldHandler.isObjectCrashing(ViewIndexer.class)) {
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(this$4, "this$0");
                    byte[] bytes = str10.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    String strHashWithAlgorithm = Utility.hashWithAlgorithm("MD5", bytes);
                    Date date5 = AccessToken.DEFAULT_EXPIRATION_TIME;
                    AccessToken currentAccessToken = Headers.Companion.getCurrentAccessToken();
                    if (strHashWithAlgorithm == null || !strHashWithAlgorithm.equals(this$4.previousDigest)) {
                        String str11 = ViewIndexer.TAG;
                        this$4.processRequest(WorkContinuation.buildAppIndexingRequest(str10, currentAccessToken, FacebookSdk.getApplicationId()), strHashWithAlgorithm);
                        return;
                    }
                    return;
                } catch (Throwable th8) {
                    CrashShieldHandler.handleThrowable(ViewIndexer.class, th8);
                    return;
                }
            case 17:
                InAppPurchaseBillingClientWrapper this$5 = (InAppPurchaseBillingClientWrapper) this.f$0;
                AppEventQueue$$ExternalSyntheticLambda0 appEventQueue$$ExternalSyntheticLambda0 = (AppEventQueue$$ExternalSyntheticLambda0) this.f$1;
                if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapper.class)) {
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(this$5, "this$0");
                    this$5.querySkuDetailsAsync(new ArrayList(this$5.historyPurchaseSet), appEventQueue$$ExternalSyntheticLambda0);
                    return;
                } catch (Throwable th9) {
                    CrashShieldHandler.handleThrowable(InAppPurchaseBillingClientWrapper.class, th9);
                    return;
                }
            case 18:
                String applicationId = (String) this.f$0;
                AppEvent appEvent2 = (AppEvent) this.f$1;
                if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
                    return;
                }
                try {
                    Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
                    Intrinsics.checkNotNullParameter(appEvent2, FKidOcdAYt.oaog);
                    List listListOf = Okio.listOf(appEvent2);
                    if (CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
                        return;
                    }
                    try {
                        RemoteServiceWrapper.INSTANCE.sendEvents(RemoteServiceWrapper.EventType.CUSTOM_APP_EVENTS, applicationId, listListOf);
                        return;
                    } catch (Throwable th10) {
                        CrashShieldHandler.handleThrowable(RemoteServiceWrapper.class, th10);
                        return;
                    }
                } catch (Throwable th11) {
                    CrashShieldHandler.handleThrowable(OnDeviceProcessingManager.class, th11);
                    return;
                }
            case 19:
                String str12 = (String) this.f$0;
                String buttonText = (String) this.f$1;
                Intrinsics.checkNotNullParameter(buttonText, "$buttonText");
                HashSet hashSet2 = ViewOnClickListener.viewsAttachedListener;
                FeatureExtractor.processPredictedResult(str12, buttonText, new float[0]);
                return;
            case 20:
                int i6 = JobInfoSchedulerService.$r8$clinit;
                ((JobInfoSchedulerService) this.f$0).jobFinished((JobParameters) this.f$1, false);
                return;
            case 21:
                ComponentRuntime.lambda$processInstanceComponents$2((OptionalProvider) this.f$0, (Provider) this.f$1);
                return;
            case 22:
                ComponentRuntime.lambda$processSetComponents$3((LazySet) this.f$0, (Provider) this.f$1);
                return;
            default:
                ((EventHandler) ((Map.Entry) this.f$0).getKey()).handle((Event) this.f$1);
                return;
        }
    }
}
