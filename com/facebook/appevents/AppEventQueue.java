package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.billingclient.api.zzda;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda1;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.facebook.GraphResponse;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppEventQueue {
    public static ScheduledFuture scheduledFuture;
    public static volatile AppEventCollection appEventCollection = new AppEventCollection();
    public static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    public static final AppEventQueue$$ExternalSyntheticLambda0 flushRunnable = new AppEventQueue$$ExternalSyntheticLambda0(0);

    public static final GraphRequest buildRequestForSession(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState, boolean z, zzda zzdaVar) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            String str = accessTokenAppIdPair.applicationId;
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(str, false);
            String str2 = GraphRequest.MIME_BOUNDARY;
            GraphRequest graphRequestNewPostRequest = GraphRequest.Companion.newPostRequest(null, String.format("%s/activities", Arrays.copyOf(new Object[]{str}, 1)), null, null);
            graphRequestNewPostRequest.forceApplicationRequest = true;
            Bundle bundle = graphRequestNewPostRequest.parameters;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("access_token", accessTokenAppIdPair.accessTokenString);
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class);
            }
            String installReferrer = GraphRequest.Companion.getInstallReferrer();
            if (installReferrer != null) {
                bundle.putString("install_referrer", installReferrer);
            }
            graphRequestNewPostRequest.parameters = bundle;
            int iPopulateRequest = sessionEventsState.populateRequest(graphRequestNewPostRequest, FacebookSdk.getApplicationContext(), fetchedAppSettingsQueryAppSettings != null ? fetchedAppSettingsQueryAppSettings.supportsImplicitLogging : false, z);
            if (iPopulateRequest == 0) {
                return null;
            }
            zzdaVar.zzb += iPopulateRequest;
            graphRequestNewPostRequest.setCallback(new AccessTokenManager$$ExternalSyntheticLambda1(accessTokenAppIdPair, graphRequestNewPostRequest, sessionEventsState, zzdaVar, 1));
            return graphRequestNewPostRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(AppEventQueue.class, th);
            return null;
        }
    }

    public static final ArrayList buildRequests(AppEventCollection appEventCollection2, zzda zzdaVar) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(appEventCollection2, "appEventCollection");
            boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
            ArrayList arrayList = new ArrayList();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection2.keySet()) {
                SessionEventsState sessionEventsState = appEventCollection2.get(accessTokenAppIdPair);
                if (sessionEventsState == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                GraphRequest graphRequestBuildRequestForSession = buildRequestForSession(accessTokenAppIdPair, sessionEventsState, limitEventAndDataUsage, zzdaVar);
                if (graphRequestBuildRequestForSession != null) {
                    arrayList.add(graphRequestBuildRequestForSession);
                    if (MapsKt__MapsKt.isEnabled) {
                        HashSet hashSet = AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE;
                        Utility.runOnNonUiThread(new AccessTokenManager$$ExternalSyntheticLambda0(graphRequestBuildRequestForSession, 8));
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(AppEventQueue.class, th);
            return null;
        }
    }

    public static final void flush(FlushReason flushReason) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            singleThreadExecutor.execute(new AccessTokenManager$$ExternalSyntheticLambda0(flushReason, 7));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(AppEventQueue.class, th);
        }
    }

    public static final void flushAndWait(FlushReason flushReason) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            appEventCollection.addPersistedEvents(StringsKt__IndentKt.readAndClearStore());
            try {
                zzda zzdaVarSendEventsToServer = sendEventsToServer(flushReason, appEventCollection);
                if (zzdaVarSendEventsToServer != null) {
                    Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                    intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", zzdaVarSendEventsToServer.zzb);
                    intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", (FlushResult) zzdaVarSendEventsToServer.zza);
                    LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(intent);
                }
            } catch (Exception e) {
                Log.w("com.facebook.appevents.AppEventQueue", "Caught unexpected exception while flushing app events: ", e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(AppEventQueue.class, th);
        }
    }

    public static final void handleResponse(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, SessionEventsState sessionEventsState, zzda zzdaVar) {
        FlushResult flushResult;
        boolean z = true;
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            FacebookRequestError facebookRequestError = graphResponse.error;
            FlushResult flushResult2 = FlushResult.SUCCESS;
            FlushResult flushResult3 = FlushResult.NO_CONNECTIVITY;
            if (facebookRequestError == null) {
                flushResult = flushResult2;
            } else if (facebookRequestError.errorCode == -1) {
                flushResult = flushResult3;
            } else {
                String.format(DaWYVMJ.EtbDm, Arrays.copyOf(new Object[]{graphResponse.toString(), facebookRequestError.toString()}, 2));
                flushResult = FlushResult.SERVER_ERROR;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            synchronized (FacebookSdk.loggingBehaviors) {
            }
            if (facebookRequestError == null) {
                z = false;
            }
            sessionEventsState.clearInFlightAndStats(z);
            if (flushResult == flushResult3) {
                FacebookSdk.getExecutor().execute(new GraphRequest$Companion$$ExternalSyntheticLambda1(accessTokenAppIdPair, sessionEventsState, 10));
            }
            if (flushResult == flushResult2 || ((FlushResult) zzdaVar.zza) == flushResult3) {
                return;
            }
            zzdaVar.zza = flushResult;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(AppEventQueue.class, th);
        }
    }

    public static final zzda sendEventsToServer(FlushReason flushReason, AppEventCollection appEventCollection2) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(appEventCollection2, "appEventCollection");
            zzda zzdaVar = new zzda();
            zzdaVar.zza = FlushResult.SUCCESS;
            ArrayList arrayListBuildRequests = buildRequests(appEventCollection2, zzdaVar);
            if (arrayListBuildRequests.isEmpty()) {
                return null;
            }
            GraphRequest.Companion companion = Logger.Companion;
            flushReason.toString();
            synchronized (FacebookSdk.loggingBehaviors) {
            }
            Iterator it = arrayListBuildRequests.iterator();
            while (it.hasNext()) {
                ((GraphRequest) it.next()).executeAndWait();
            }
            return zzdaVar;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(AppEventQueue.class, th);
            return null;
        }
    }
}
