package com.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.provider.FontProvider$$ExternalSyntheticLambda2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentState;
import androidx.loader.app.gv.DYYbQc;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.installreferrer.api.InstallReferrerClientImpl;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventCollection;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda0;
import com.facebook.appevents.AppEventsLogger$FlushBehavior;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility$$ExternalSyntheticLambda5;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.anrreport.ANRHandler$$ExternalSyntheticLambda1;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginLogger;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzad;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil$ResultConverter;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzded;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.Protocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class GraphRequest {
    public static final String MIME_BOUNDARY;
    public static volatile String userAgent;
    public static final Pattern versionPattern;
    public final AccessToken accessToken;
    public Callback callback;
    public boolean forceApplicationRequest;
    public JSONObject graphObject;
    public final String graphPath;
    public HttpMethod httpMethod;
    public Bundle parameters;
    public String tag;
    public final String version;

    /* JADX INFO: loaded from: classes.dex */
    public final class Attachment {
        public final GraphRequest request;
        public final Object value;

        public Attachment(GraphRequest graphRequest, Object obj) {
            this.request = graphRequest;
            this.value = obj;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    public final class Companion implements Utility.GraphMeRequestWithCacheCallback, Factory, CustomEventBannerListener, CustomEventInterstitialListener, CustomEventNativeListener, RewardItem, PendingResultUtil$ResultConverter, DynamiteModule$VersionPolicy$IVersions {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ Companion(int i) {
            this.$r8$classId = i;
        }

        public static final zzbf access$handlePermissionResponse(JSONObject jSONObject) {
            String strOptString;
            JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int length = jSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    String permission = jSONObjectOptJSONObject.optString("permission");
                    Intrinsics.checkNotNullExpressionValue(permission, "permission");
                    if (permission.length() != 0 && !permission.equals("installed") && (strOptString = jSONObjectOptJSONObject.optString("status")) != null) {
                        int iHashCode = strOptString.hashCode();
                        if (iHashCode != -1309235419) {
                            if (iHashCode != 280295099) {
                                if (iHashCode == 568196142 && strOptString.equals("declined")) {
                                    arrayList2.add(permission);
                                }
                            } else if (strOptString.equals("granted")) {
                                arrayList.add(permission);
                            }
                        } else if (strOptString.equals("expired")) {
                            arrayList3.add(permission);
                        }
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            zzbf zzbfVar = new zzbf();
            zzbfVar.zza = arrayList;
            zzbfVar.zzb = arrayList2;
            zzbfVar.zzc = arrayList3;
            return zzbfVar;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x005c  */
        /* JADX WARN: Code duplicated, block: B:28:0x0061 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:16:0x0042, B:28:0x0061, B:24:0x0058, B:20:0x004d), top: B:52:0x0042, inners: #2 }] */
        public static final void access$logEvent(AppEvent appEvent, AccessTokenAppIdPair accessTokenAppId) {
            boolean z;
            AppEventCollection appEventCollection = AppEventQueue.appEventCollection;
            if (!CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
                try {
                    Intrinsics.checkNotNullParameter(accessTokenAppId, "accessTokenAppId");
                    AppEventQueue.singleThreadExecutor.execute(new GraphRequest$Companion$$ExternalSyntheticLambda1(accessTokenAppId, appEvent, 9));
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(AppEventQueue.class, th);
                }
            }
            FeatureManager featureManager = FeatureManager.INSTANCE;
            boolean zIsEnabled = FeatureManager.isEnabled(FeatureManager.Feature.OnDevicePostInstallEventProcessing);
            String str = appEvent.name;
            boolean z2 = appEvent.isImplicit;
            boolean z3 = false;
            if (zIsEnabled && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                String str2 = accessTokenAppId.applicationId;
                if (!CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
                    try {
                        OnDeviceProcessingManager onDeviceProcessingManager = OnDeviceProcessingManager.INSTANCE;
                        if (!CrashShieldHandler.isObjectCrashing(onDeviceProcessingManager)) {
                            if (z2) {
                                try {
                                    if (OnDeviceProcessingManager.ALLOWED_IMPLICIT_EVENTS.contains(str)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z2 || z) {
                                        FacebookSdk.getExecutor().execute(new GraphRequest$Companion$$ExternalSyntheticLambda1(str2, appEvent, 18));
                                    }
                                } catch (Throwable th2) {
                                    CrashShieldHandler.handleThrowable(onDeviceProcessingManager, th2);
                                }
                            } else {
                                z = false;
                                if (z2) {
                                    FacebookSdk.getExecutor().execute(new GraphRequest$Companion$$ExternalSyntheticLambda1(str2, appEvent, 18));
                                } else {
                                    FacebookSdk.getExecutor().execute(new GraphRequest$Companion$$ExternalSyntheticLambda1(str2, appEvent, 18));
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        CrashShieldHandler.handleThrowable(OnDeviceProcessingManager.class, th3);
                    }
                }
            }
            if (z2) {
                return;
            }
            if (!CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
                try {
                    z3 = AppEventsLoggerImpl.isActivateAppEventRequested;
                } catch (Throwable th4) {
                    CrashShieldHandler.handleThrowable(AppEventsLoggerImpl.class, th4);
                }
            }
            if (z3) {
                return;
            }
            if (!Intrinsics.areEqual(str, "fb_mobile_activate_app")) {
                Companion companion = Logger.Companion;
                log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            } else {
                if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
                    return;
                }
                try {
                    AppEventsLoggerImpl.isActivateAppEventRequested = true;
                } catch (Throwable th5) {
                    CrashShieldHandler.handleThrowable(AppEventsLoggerImpl.class, th5);
                }
            }
        }

        public static final Bundle access$newAuthorizationLoggingBundle(String str) {
            ScheduledExecutorService scheduledExecutorService = LoginLogger.worker;
            Bundle bundle = new Bundle();
            bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
            bundle.putString("0_auth_logger_id", str);
            bundle.putString("3_method", "");
            bundle.putString("2_result", "");
            bundle.putString("5_error_message", "");
            bundle.putString("4_error_code", "");
            bundle.putString("6_extras", "");
            return bundle;
        }

        public static final String access$parameterToString(Object obj) {
            String str = GraphRequest.MIME_BOUNDARY;
            if (obj instanceof String) {
                return (String) obj;
            }
            if ((obj instanceof Boolean) || (obj instanceof Number)) {
                return obj.toString();
            }
            if (!(obj instanceof Date)) {
                throw new IllegalArgumentException("Unsupported parameter type.");
            }
            String str2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
            Intrinsics.checkNotNullExpressionValue(str2, "iso8601DateFormat.format(value)");
            return str2;
        }

        public static final void access$validateIdentifier(String str) {
            boolean zContains;
            HashSet hashSet = AppEvent.validatedIdentifiers;
            String str2 = UUFMQdNK.hUfeYfpOZCXEi;
            if (str == null || str.length() == 0 || str.length() > 40) {
                if (str == null) {
                    str = "<None Provided>";
                }
                throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(new Object[]{str, 40}, 2)));
            }
            HashSet hashSet2 = AppEvent.validatedIdentifiers;
            synchronized (hashSet2) {
                zContains = hashSet2.contains(str);
            }
            if (zContains) {
                return;
            }
            Pattern patternCompile = Pattern.compile(str2);
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
            if (!patternCompile.matcher(str).matches()) {
                throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", Arrays.copyOf(new Object[]{str}, 1)));
            }
            synchronized (hashSet2) {
                hashSet2.add(str);
            }
        }

        public static HttpURLConnection createConnection(URL url) throws IOException {
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            if (uRLConnectionOpenConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            if (GraphRequest.userAgent == null) {
                GraphRequest.userAgent = String.format("%s.%s", Arrays.copyOf(new Object[]{"FBAndroidSDK", "16.0.0"}, 2));
            }
            httpURLConnection.setRequestProperty("User-Agent", GraphRequest.userAgent);
            httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
            httpURLConnection.setChunkedStreamingMode(0);
            return httpURLConnection;
        }

        public static ArrayList executeBatchAndWait(GraphRequestBatch requests) throws Throwable {
            Exception exc;
            HttpURLConnection httpConnection;
            ArrayList arrayListExecuteConnectionAndWait;
            Intrinsics.checkNotNullParameter(requests, "requests");
            Validate.notEmptyAndContainsNoNulls(requests);
            HttpURLConnection httpURLConnection = null;
            try {
                httpConnection = toHttpConnection(requests);
                exc = null;
            } catch (Exception e) {
                exc = e;
                httpConnection = null;
            } catch (Throwable th) {
                th = th;
                Utility.disconnectQuietly(httpURLConnection);
                throw th;
            }
            try {
                if (httpConnection != null) {
                    arrayListExecuteConnectionAndWait = executeConnectionAndWait(requests, httpConnection);
                } else {
                    ArrayList requests2 = requests.requests;
                    FacebookException facebookException = new FacebookException(exc);
                    Intrinsics.checkNotNullParameter(requests2, "requests");
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(requests2));
                    Iterator it = requests2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new GraphResponse((GraphRequest) it.next(), null, new FacebookRequestError(facebookException)));
                    }
                    runCallbacks$facebook_core_release(requests, arrayList);
                    arrayListExecuteConnectionAndWait = arrayList;
                }
                Utility.disconnectQuietly(httpConnection);
                return arrayListExecuteConnectionAndWait;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpConnection;
                Utility.disconnectQuietly(httpURLConnection);
                throw th;
            }
        }

        public static ArrayList executeConnectionAndWait(GraphRequestBatch requests, HttpURLConnection httpURLConnection) {
            ArrayList arrayListConstructErrorResponses;
            Intrinsics.checkNotNullParameter(requests, "requests");
            LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
            InputStream errorStream = null;
            try {
                try {
                    try {
                        if (!FacebookSdk.isFullyInitialized()) {
                            Log.e("com.facebook.GraphResponse", "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                            throw new FacebookException("GraphRequest can't be used when Facebook SDK isn't fully initialized");
                        }
                        errorStream = httpURLConnection.getResponseCode() >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                        arrayListConstructErrorResponses = Protocol.Companion.createResponsesFromStream$facebook_core_release(errorStream, httpURLConnection, requests);
                        Utility.closeQuietly(errorStream);
                        Utility.disconnectQuietly(httpURLConnection);
                        int size = requests.requests.size();
                        if (size != arrayListConstructErrorResponses.size()) {
                            throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{Integer.valueOf(arrayListConstructErrorResponses.size()), Integer.valueOf(size)}, 2)));
                        }
                        runCallbacks$facebook_core_release(requests, arrayListConstructErrorResponses);
                        AccessTokenManager companion = AccessTokenManager.Companion.getInstance();
                        AccessToken accessToken = companion.currentAccessTokenField;
                        if (accessToken != null) {
                            long time = new Date().getTime();
                            if (accessToken.source.canExtendToken && time - companion.lastAttemptedTokenExtendDate.getTime() > 3600000 && time - accessToken.lastRefresh.getTime() > 86400000) {
                                if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                                    companion.refreshCurrentAccessTokenImpl();
                                } else {
                                    new Handler(Looper.getMainLooper()).post(new AccessTokenManager$$ExternalSyntheticLambda0(companion, 0));
                                }
                            }
                        }
                        return arrayListConstructErrorResponses;
                    } catch (Exception e) {
                        Companion companion2 = Logger.Companion;
                        synchronized (FacebookSdk.loggingBehaviors) {
                            arrayListConstructErrorResponses = Protocol.Companion.constructErrorResponses(requests, httpURLConnection, new FacebookException(e));
                        }
                    }
                } catch (FacebookException e2) {
                    Companion companion3 = Logger.Companion;
                    log(loggingBehavior, "Response", "Response <Error>: %s", e2);
                    arrayListConstructErrorResponses = Protocol.Companion.constructErrorResponses(requests, httpURLConnection, e2);
                }
            } catch (Throwable th) {
                Utility.closeQuietly(null);
                throw th;
            }
        }

        public static FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
            return new FacebookRequestErrorClassification(null, MapsKt__MapsKt.hashMapOf(new Pair(2, null), new Pair(4, null), new Pair(9, null), new Pair(17, null), new Pair(341, null)), MapsKt__MapsKt.hashMapOf(new Pair(Integer.valueOf(TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE), null), new Pair(190, null), new Pair(412, null)), null, null, null);
        }

        public static AppEventsLogger$FlushBehavior getFlushBehavior() {
            AppEventsLogger$FlushBehavior appEventsLogger$FlushBehavior;
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                appEventsLogger$FlushBehavior = null;
                if (!CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
                    try {
                        appEventsLogger$FlushBehavior = AppEventsLogger$FlushBehavior.AUTO;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(AppEventsLoggerImpl.class, th);
                    }
                }
            }
            return appEventsLogger$FlushBehavior;
        }

        public static void initializeTimersIfNeeded() {
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                if (AppEventsLoggerImpl.access$getBackgroundExecutor$cp() != null) {
                    return;
                }
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                if (!CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
                    try {
                        AppEventsLoggerImpl.backgroundExecutor = scheduledThreadPoolExecutor;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(AppEventsLoggerImpl.class, th);
                    }
                }
                AppEventQueue$$ExternalSyntheticLambda0 appEventQueue$$ExternalSyntheticLambda0 = new AppEventQueue$$ExternalSyntheticLambda0(3);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
                if (scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp.scheduleAtFixedRate(appEventQueue$$ExternalSyntheticLambda0, 0L, 86400L, TimeUnit.SECONDS);
            }
        }

        public static boolean isSupportedAttachmentType(Object obj) {
            return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
        }

        public static boolean isSupportedParameterType(Object obj) {
            return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
        }

        public static void log(LoggingBehavior loggingBehavior, String tag, String str) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(str, GsPcpBmONXh.HeZkjwOTGmhqDfM);
            log$1(loggingBehavior, tag, str);
        }

        public static void log$1(LoggingBehavior loggingBehavior, String tag, String string) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(string, "string");
            synchronized (FacebookSdk.loggingBehaviors) {
            }
        }

        public static GraphRequest newGraphPathRequest(AccessToken accessToken, String str, Callback callback) {
            return new GraphRequest(accessToken, str, null, null, callback);
        }

        public static GraphRequest newPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, Callback callback) {
            GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.POST, callback);
            graphRequest.graphObject = jSONObject;
            return graphRequest;
        }

        public static HashMap parseJSONDefinition(JSONObject jSONObject) {
            int iOptInt;
            HashSet hashSet;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(FirebaseAnalytics.Param.ITEMS);
            if (jSONArrayOptJSONArray.length() == 0) {
                return null;
            }
            HashMap map = new HashMap();
            int length = jSONArrayOptJSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (iOptInt = jSONObjectOptJSONObject.optInt("code")) != 0) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("subcodes");
                        if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                            hashSet = null;
                        } else {
                            hashSet = new HashSet();
                            int length2 = jSONArrayOptJSONArray2.length();
                            if (length2 > 0) {
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3 + 1;
                                    int iOptInt2 = jSONArrayOptJSONArray2.optInt(i3);
                                    if (iOptInt2 != 0) {
                                        hashSet.add(Integer.valueOf(iOptInt2));
                                    }
                                    if (i4 >= length2) {
                                        break;
                                    }
                                    i3 = i4;
                                }
                            }
                        }
                        map.put(Integer.valueOf(iOptInt), hashSet);
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return map;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x002a  */
        public static void processGraphObject(JSONObject jSONObject, String str, KeyValueSerializer keyValueSerializer) {
            String strGroup;
            boolean z;
            Matcher matcher = GraphRequest.versionPattern.matcher(str);
            if (matcher.matches()) {
                strGroup = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(strGroup, "matcher.group(1)");
            } else {
                strGroup = str;
            }
            if (StringsKt__StringsKt.startsWith(strGroup, "me/", false) || StringsKt__StringsKt.startsWith(strGroup, "/me/", false)) {
                int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ":", 0, false, 6);
                int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, "?", 0, false, 6);
                if (iIndexOf$default <= 3 || (iIndexOf$default2 != -1 && iIndexOf$default >= iIndexOf$default2)) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String key = (String) itKeys.next();
                Object value = jSONObject.opt(key);
                boolean z2 = z && StringsKt__StringsKt.equals(key, "image");
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                processGraphObjectProperty(key, value, keyValueSerializer, z2);
            }
        }

        public static void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z) {
            Class<?> cls = obj.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                JSONObject jSONObject = (JSONObject) obj;
                if (z) {
                    Iterator itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String str2 = (String) itKeys.next();
                        String str3 = String.format("%s[%s]", Arrays.copyOf(new Object[]{str, str2}, 2));
                        Object objOpt = jSONObject.opt(str2);
                        Intrinsics.checkNotNullExpressionValue(objOpt, "jsonObject.opt(propertyName)");
                        processGraphObjectProperty(str3, objOpt, keyValueSerializer, z);
                    }
                    return;
                }
                if (jSONObject.has("id")) {
                    String strOptString = jSONObject.optString("id");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "jsonObject.optString(\"id\")");
                    processGraphObjectProperty(str, strOptString, keyValueSerializer, z);
                    return;
                } else if (jSONObject.has("url")) {
                    String strOptString2 = jSONObject.optString("url");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "jsonObject.optString(\"url\")");
                    processGraphObjectProperty(str, strOptString2, keyValueSerializer, z);
                    return;
                } else {
                    if (jSONObject.has("fbsdk:create_object")) {
                        String string = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
                        processGraphObjectProperty(str, string, keyValueSerializer, z);
                        return;
                    }
                    return;
                }
            }
            if (!JSONArray.class.isAssignableFrom(cls)) {
                if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                    keyValueSerializer.writeString(str, obj.toString());
                    return;
                }
                if (!Date.class.isAssignableFrom(cls)) {
                    String str4 = GraphRequest.MIME_BOUNDARY;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    return;
                } else {
                    String str5 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
                    Intrinsics.checkNotNullExpressionValue(str5, "iso8601DateFormat.format(date)");
                    keyValueSerializer.writeString(str, str5);
                    return;
                }
            }
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            if (length <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                String str6 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i)}, 2));
                Object objOpt2 = jSONArray.opt(i);
                Intrinsics.checkNotNullExpressionValue(objOpt2, "jsonArray.opt(i)");
                processGraphObjectProperty(str6, objOpt2, keyValueSerializer, z);
                if (i2 >= length) {
                    return;
                } else {
                    i = i2;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r16v0 */
        /* JADX WARN: Type inference failed for: r16v1 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r7v3, types: [org.json.JSONArray] */
        public static void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i, URL url, FilterOutputStream filterOutputStream, boolean z) {
            String applicationId;
            int i2 = 1;
            ConnectionSpec.Builder builder = new ConnectionSpec.Builder();
            builder.cipherSuites = filterOutputStream;
            builder.tlsVersions = logger;
            builder.tls = true;
            builder.supportsTlsExtensions = z;
            if (i == 1) {
                GraphRequest graphRequest = (GraphRequest) graphRequestBatch.requests.get(0);
                HashMap map = new HashMap();
                for (String key : graphRequest.parameters.keySet()) {
                    Object obj = graphRequest.parameters.get(key);
                    if (isSupportedAttachmentType(obj)) {
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        map.put(key, new Attachment(graphRequest, obj));
                    }
                }
                logger.shouldLog();
                Bundle bundle = graphRequest.parameters;
                for (String key2 : bundle.keySet()) {
                    Object obj2 = bundle.get(key2);
                    if (isSupportedParameterType(obj2)) {
                        Intrinsics.checkNotNullExpressionValue(key2, "key");
                        builder.writeObject(key2, obj2, graphRequest);
                    }
                }
                logger.shouldLog();
                serializeAttachments(map, builder);
                JSONObject jSONObject = graphRequest.graphObject;
                if (jSONObject != null) {
                    String path = url.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "url.path");
                    processGraphObject(jSONObject, path, builder);
                    return;
                }
                return;
            }
            graphRequestBatch.getClass();
            Iterator it = graphRequestBatch.iterator();
            while (true) {
                if (it.hasNext()) {
                    AccessToken accessToken = ((GraphRequest) it.next()).accessToken;
                    if (accessToken != null) {
                        applicationId = accessToken.applicationId;
                        break;
                    }
                } else {
                    String str = GraphRequest.MIME_BOUNDARY;
                    applicationId = FacebookSdk.getApplicationId();
                    break;
                }
            }
            if (applicationId.length() == 0) {
                throw new FacebookException("App ID was not specified at the request or Settings.");
            }
            builder.writeString("batch_app_id", applicationId);
            HashMap map2 = new HashMap();
            ?? jSONArray = new JSONArray();
            Iterator it2 = graphRequestBatch.iterator();
            while (it2.hasNext()) {
                GraphRequest graphRequest2 = (GraphRequest) it2.next();
                graphRequest2.getClass();
                JSONObject jSONObject2 = new JSONObject();
                Object[] objArr = new Object[i2];
                objArr[0] = FacebookSdk.getGraphDomain();
                String urlWithGraphPath = graphRequest2.getUrlWithGraphPath(String.format("https://graph.%s", Arrays.copyOf(objArr, i2)));
                graphRequest2.addCommonParameters();
                Uri uri = Uri.parse(graphRequest2.appendParametersToBaseUrl(urlWithGraphPath, i2));
                String path2 = uri.getPath();
                String query = uri.getQuery();
                Object[] objArr2 = new Object[2];
                objArr2[0] = path2;
                objArr2[i2] = query;
                String str2 = String.format("%s?%s", Arrays.copyOf(objArr2, 2));
                jSONObject2.put("relative_url", str2);
                jSONObject2.put(FirebaseAnalytics.Param.METHOD, graphRequest2.httpMethod);
                AccessToken accessToken2 = graphRequest2.accessToken;
                if (accessToken2 != null) {
                    Logger.Companion.registerAccessToken(accessToken2.token);
                }
                ArrayList arrayList = new ArrayList();
                Iterator<String> it3 = graphRequest2.parameters.keySet().iterator();
                while (true) {
                    boolean zHasNext = it3.hasNext();
                    String str3 = GraphRequest.MIME_BOUNDARY;
                    if (!zHasNext) {
                        break;
                    }
                    Object obj3 = graphRequest2.parameters.get(it3.next());
                    if (isSupportedAttachmentType(obj3)) {
                        String str4 = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(new Object[]{"file", Integer.valueOf(map2.size())}, 2));
                        arrayList.add(str4);
                        map2.put(str4, new Attachment(graphRequest2, obj3));
                        i2 = 1;
                    }
                }
                ?? r16 = i2 == true ? 1 : 0;
                if (!arrayList.isEmpty()) {
                    jSONObject2.put("attached_files", TextUtils.join(",", arrayList));
                }
                JSONObject jSONObject3 = graphRequest2.graphObject;
                if (jSONObject3 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    processGraphObject(jSONObject3, str2, new Fragment.AnonymousClass7(arrayList2, 17));
                    jSONObject2.put("body", TextUtils.join("&", arrayList2));
                }
                jSONArray.put(jSONObject2);
                i2 = r16 == true ? 1 : 0;
            }
            String string = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(string, "requestJsonArray.toString()");
            builder.writeString("batch", string);
            logger.shouldLog();
            serializeAttachments(map2, builder);
        }

        public static void runCallbacks$facebook_core_release(GraphRequestBatch requests, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            int size = requests.requests.size();
            ArrayList arrayList2 = new ArrayList();
            if (size > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    GraphRequest graphRequest = (GraphRequest) requests.requests.get(i);
                    if (graphRequest.callback != null) {
                        arrayList2.add(new android.util.Pair(graphRequest.callback, arrayList.get(i)));
                    }
                    if (i2 >= size) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            if (arrayList2.size() > 0) {
                GraphRequest$Companion$$ExternalSyntheticLambda1 graphRequest$Companion$$ExternalSyntheticLambda1 = new GraphRequest$Companion$$ExternalSyntheticLambda1(arrayList2, requests, 0);
                Handler handler = requests.callbackHandler;
                if ((handler == null ? null : Boolean.valueOf(handler.post(graphRequest$Companion$$ExternalSyntheticLambda1))) == null) {
                    graphRequest$Companion$$ExternalSyntheticLambda1.run();
                }
            }
        }

        public static void sendExceptionReports() {
            File[] fileArrListFiles;
            if (Utility.isDataProcessingRestricted()) {
                return;
            }
            File instrumentReportDir = Headers.Companion.getInstrumentReportDir();
            if (instrumentReportDir == null) {
                fileArrListFiles = new File[0];
            } else {
                fileArrListFiles = instrumentReportDir.listFiles(new Utility$$ExternalSyntheticLambda5(1));
                if (fileArrListFiles == null) {
                    fileArrListFiles = new File[0];
                }
            }
            ArrayList arrayList = new ArrayList(fileArrListFiles.length);
            for (File file : fileArrListFiles) {
                arrayList.add(GamepadHandler_API19.load(file));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((InstrumentData) obj).isValid()) {
                    arrayList2.add(obj);
                }
            }
            List listSortedWith = CollectionsKt.sortedWith(arrayList2, new FontProvider$$ExternalSyntheticLambda2(2));
            JSONArray jSONArray = new JSONArray();
            Iterator it = RangesKt.until(0, Math.min(listSortedWith.size(), 5)).iterator();
            while (((IntProgressionIterator) it).hasNext) {
                jSONArray.put(listSortedWith.get(((IntProgressionIterator) it).nextInt()));
            }
            Headers.Companion.sendReports("crash_reports", jSONArray, new ANRHandler$$ExternalSyntheticLambda1(1, listSortedWith));
        }

        public static void serializeAttachments(HashMap map, ConnectionSpec.Builder builder) {
            for (Map.Entry entry : map.entrySet()) {
                String str = GraphRequest.MIME_BOUNDARY;
                if (isSupportedAttachmentType(((Attachment) entry.getValue()).value)) {
                    builder.writeObject((String) entry.getKey(), ((Attachment) entry.getValue()).value, ((Attachment) entry.getValue()).request);
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:49:0x0137  */
        public static void serializeToUrlConnection$facebook_core_release(GraphRequestBatch requests, HttpURLConnection httpURLConnection) throws Throwable {
            boolean z;
            FilterOutputStream gZIPOutputStream;
            Intrinsics.checkNotNullParameter(requests, "requests");
            Logger logger = new Logger();
            int size = requests.requests.size();
            Iterator<E> it = requests.iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                GraphRequest graphRequest = (GraphRequest) it.next();
                Iterator<String> it2 = graphRequest.parameters.keySet().iterator();
                while (it2.hasNext()) {
                    if (isSupportedAttachmentType(graphRequest.parameters.get(it2.next()))) {
                        z = false;
                        break loop0;
                    }
                }
            }
            FilterOutputStream filterOutputStream = null;
            HttpMethod httpMethod = size == 1 ? ((GraphRequest) requests.requests.get(0)).httpMethod : null;
            HttpMethod httpMethod2 = HttpMethod.POST;
            if (httpMethod == null) {
                httpMethod = httpMethod2;
            }
            httpURLConnection.setRequestMethod(httpMethod.name());
            if (z) {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            } else {
                httpURLConnection.setRequestProperty("Content-Type", String.format("multipart/form-data; boundary=%s", Arrays.copyOf(new Object[]{GraphRequest.MIME_BOUNDARY}, 1)));
            }
            URL url = httpURLConnection.getURL();
            logger.shouldLog();
            logger.appendKeyValue(requests.id, "Id");
            Intrinsics.checkNotNullExpressionValue(url, "url");
            logger.appendKeyValue(url, "URL");
            String requestMethod = httpURLConnection.getRequestMethod();
            Intrinsics.checkNotNullExpressionValue(requestMethod, "connection.requestMethod");
            logger.appendKeyValue(requestMethod, "Method");
            String requestProperty = httpURLConnection.getRequestProperty("User-Agent");
            Intrinsics.checkNotNullExpressionValue(requestProperty, "connection.getRequestProperty(\"User-Agent\")");
            logger.appendKeyValue(requestProperty, "User-Agent");
            String requestProperty2 = httpURLConnection.getRequestProperty("Content-Type");
            Intrinsics.checkNotNullExpressionValue(requestProperty2, "connection.getRequestProperty(\"Content-Type\")");
            logger.appendKeyValue(requestProperty2, "Content-Type");
            httpURLConnection.setConnectTimeout(0);
            httpURLConnection.setReadTimeout(0);
            LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
            String str = logger.tag;
            if (httpMethod != httpMethod2) {
                String string = logger.contents.toString();
                Intrinsics.checkNotNullExpressionValue(string, "contents.toString()");
                log$1(loggingBehavior, str, string);
                logger.contents = new StringBuilder();
                return;
            }
            httpURLConnection.setDoOutput(true);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                if (z) {
                    try {
                        gZIPOutputStream = new GZIPOutputStream(bufferedOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        filterOutputStream = bufferedOutputStream;
                        if (filterOutputStream != null) {
                            filterOutputStream.close();
                        }
                        throw th;
                    }
                } else {
                    gZIPOutputStream = bufferedOutputStream;
                }
                try {
                    for (AccessTokenManager$$ExternalSyntheticLambda3 accessTokenManager$$ExternalSyntheticLambda3 : requests.callbacks) {
                    }
                    Iterator<E> it3 = requests.iterator();
                    while (it3.hasNext()) {
                        Callback callback = ((GraphRequest) it3.next()).callback;
                    }
                    processRequest(requests, logger, size, url, gZIPOutputStream, z);
                    gZIPOutputStream.close();
                    String string2 = logger.contents.toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "contents.toString()");
                    log$1(loggingBehavior, str, string2);
                    logger.contents = new StringBuilder();
                } catch (Throwable th2) {
                    th = th2;
                    filterOutputStream = gZIPOutputStream;
                    if (filterOutputStream != null) {
                        filterOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public static HttpURLConnection toHttpConnection(GraphRequestBatch requests) throws Throwable {
            Intrinsics.checkNotNullParameter(requests, "requests");
            Iterator<E> it = requests.iterator();
            while (it.hasNext()) {
                GraphRequest graphRequest = (GraphRequest) it.next();
                if (HttpMethod.GET == graphRequest.httpMethod && Utility.isNullOrEmpty(graphRequest.parameters.getString("fields"))) {
                    Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                    StringBuilder sb = new StringBuilder("GET requests for /");
                    String str = graphRequest.graphPath;
                    if (str == null) {
                        str = "";
                    }
                    sb.append(str);
                    sb.append(" should contain an explicit \"fields\" parameter.");
                    log$1(loggingBehavior, RDFWIi.meQIMbldXgYtq, sb.toString());
                }
            }
            try {
                HttpURLConnection httpURLConnectionCreateConnection = null;
                try {
                    httpURLConnectionCreateConnection = createConnection(requests.requests.size() == 1 ? new URL(((GraphRequest) requests.requests.get(0)).getUrlForSingleRequest()) : new URL(String.format("https://graph.%s", Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1))));
                    serializeToUrlConnection$facebook_core_release(requests, httpURLConnectionCreateConnection);
                    return httpURLConnectionCreateConnection;
                } catch (IOException e) {
                    Utility.disconnectQuietly(httpURLConnectionCreateConnection);
                    throw new FacebookException("could not construct request body", e);
                } catch (JSONException e2) {
                    Utility.disconnectQuietly(httpURLConnectionCreateConnection);
                    throw new FacebookException("could not construct request body", e2);
                }
            } catch (MalformedURLException e3) {
                throw new FacebookException("could not construct URL for request", e3);
            }
        }

        @Override // com.google.android.gms.common.internal.PendingResultUtil$ResultConverter
        public /* bridge */ /* synthetic */ Object convert(Result result) {
            return null;
        }

        @Override // javax.inject.Provider
        public Object get() {
            Companion companion = new Companion(18);
            HashMap map = new HashMap();
            Priority priority = Priority.DEFAULT;
            Set setEmptySet = Collections.emptySet();
            if (setEmptySet == null) {
                throw new NullPointerException("Null flags");
            }
            map.put(priority, new AutoValue_SchedulerConfig_ConfigValue(30000L, 86400000L, setEmptySet));
            Priority priority2 = Priority.HIGHEST;
            Set setEmptySet2 = Collections.emptySet();
            if (setEmptySet2 == null) {
                throw new NullPointerException("Null flags");
            }
            map.put(priority2, new AutoValue_SchedulerConfig_ConfigValue(1000L, 86400000L, setEmptySet2));
            Priority priority3 = Priority.VERY_LOW;
            if (Collections.emptySet() == null) {
                throw new NullPointerException("Null flags");
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(SchedulerConfig$Flag.DEVICE_IDLE)));
            if (setUnmodifiableSet == null) {
                throw new NullPointerException("Null flags");
            }
            map.put(priority3, new AutoValue_SchedulerConfig_ConfigValue(86400000L, 86400000L, setUnmodifiableSet));
            if (map.keySet().size() < Priority.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            new HashMap();
            return new AutoValue_SchedulerConfig(companion, map);
        }

        @Override // com.google.android.gms.ads.rewarded.RewardItem
        public int getAmount() {
            return 1;
        }

        public synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
            FacebookRequestErrorClassification facebookRequestErrorClassification;
            try {
                if (FacebookRequestErrorClassification.defaultInstance == null) {
                    FacebookRequestErrorClassification.defaultInstance = getDefaultErrorClassificationImpl();
                }
                facebookRequestErrorClassification = FacebookRequestErrorClassification.defaultInstance;
                if (facebookRequestErrorClassification == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
                }
            } catch (Throwable th) {
                throw th;
            }
            return facebookRequestErrorClassification;
        }

        public synchronized FacebookRequestErrorClassification getErrorClassification() {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                return FacebookRequestErrorClassification.Companion.getDefaultErrorClassification();
            }
            return appSettingsWithoutQuery.errorClassification;
        }

        /* JADX INFO: renamed from: getInstance */
        public synchronized ProfileManager m64getInstance() {
            ProfileManager profileManager;
            try {
                if (ProfileManager.instance == null) {
                    LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(applicationContext)");
                    ProfileManager.instance = new ProfileManager(localBroadcastManager, new ProfileCache(0));
                }
                profileManager = ProfileManager.instance;
                if (profileManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("instance");
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
            return profileManager;
        }

        public long getTime() {
            switch (this.$r8$classId) {
                case 17:
                    return SystemClock.elapsedRealtime();
                default:
                    return System.currentTimeMillis();
            }
        }

        @Override // com.google.android.gms.ads.rewarded.RewardItem
        public String getType() {
            return "";
        }

        @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
        public void onSuccess(JSONObject jSONObject) {
            String strOptString = jSONObject == null ? null : jSONObject.optString("id");
            if (strOptString == null) {
                Log.w("Profile", "No user ID returned on Me request");
                return;
            }
            String strOptString2 = jSONObject.optString("link");
            String strOptString3 = jSONObject.optString("profile_picture", null);
            ProfileManager.Companion.m64getInstance().setCurrentProfile(new Profile(strOptString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), strOptString2 != null ? Uri.parse(strOptString2) : null, strOptString3 != null ? Uri.parse(strOptString3) : null), true);
        }

        public synchronized void registerAccessToken(String accessToken) {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
            registerStringToReplace(accessToken);
        }

        public synchronized void registerStringToReplace(String original) {
            Intrinsics.checkNotNullParameter(original, "original");
            Logger.stringsToReplace.put(original, "ACCESS_TOKEN_REMOVED");
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions
        public int zza(Context context, String str) {
            return DynamiteModule.getLocalVersion(context, str);
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions
        public int zzb(Context context, String str, boolean z) {
            return DynamiteModule.zza(context, str, z);
        }

        public static final String access$md5Checksum(String str) {
            HashSet hashSet = AppEvent.validatedIdentifiers;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(DYYbQc.FotcdkvZ);
                Charset charsetForName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(charsetForName, "Charset.forName(charsetName)");
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = str.getBytes(charsetForName);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes, 0, bytes.length);
                byte[] bArrDigest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest.digest()");
                return AppEventUtility.bytesToHex(bArrDigest);
            } catch (UnsupportedEncodingException unused) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                return "1";
            } catch (NoSuchAlgorithmException unused2) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                return "0";
            }
        }

        public static String getInstallReferrer() {
            Companion companion = new Companion(8);
            if (!FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("is_referrer_updated", false)) {
                InstallReferrerClientImpl installReferrerClientImpl = new InstallReferrerClientImpl(FacebookSdk.getApplicationContext());
                try {
                    installReferrerClientImpl.startConnection(new AccessTokenCache(installReferrerClientImpl, companion));
                } catch (Exception unused) {
                }
            }
            return FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString(xPQrbOSWiEdU.NEWLdDnm, null);
        }

        public static void log(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
            synchronized (FacebookSdk.loggingBehaviors) {
            }
        }

        public static final void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z, zzdsj zzdsjVar) {
            if (adOverlayInfoParcel.zzk == 4 && adOverlayInfoParcel.zzc == null) {
                zza zzaVar = adOverlayInfoParcel.zzb;
                if (zzaVar != null) {
                    zzaVar.onAdClicked();
                }
                zzded zzdedVar = adOverlayInfoParcel.zzu;
                if (zzdedVar != null) {
                    zzdedVar.zzdf();
                }
                Activity activityZzi = adOverlayInfoParcel.zzd.zzi();
                zzc zzcVar = adOverlayInfoParcel.zza;
                Context context2 = (zzcVar == null || !zzcVar.zzj || activityZzi == null) ? context : activityZzi;
                Companion companion = zzv.zza.zzb;
                zzb(context2, zzcVar, adOverlayInfoParcel.zzi, zzcVar != null ? zzcVar.zzi : null, zzdsjVar, adOverlayInfoParcel.zzq);
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
            intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzm.isClientJar);
            intent.putExtra("shouldCallOnOverlayOpened", z);
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
            intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zznx)).booleanValue()) {
                zzs zzsVar = zzv.zza.zzd;
                zzs.zzY(context, intent, zzdsjVar, adOverlayInfoParcel.zzq);
            } else {
                zzs zzsVar2 = zzv.zza.zzd;
                zzs.zzU(context, intent);
            }
        }

        public static final boolean zzb(Context context, zzc zzcVar, zzad zzadVar, zzaa zzaaVar, zzdsj zzdsjVar, String str) {
            int i = 0;
            if (zzcVar == null) {
                int i2 = zze.$r8$clinit;
                zzo.zzj("No intent data for launcher overlay.");
                return false;
            }
            zzbde.zza(context);
            Intent intent = zzcVar.zzh;
            if (intent != null) {
                return zza(context, intent, zzadVar, zzaaVar, zzcVar.zzj, zzdsjVar, str);
            }
            Intent intent2 = new Intent();
            String str2 = zzcVar.zzb;
            if (TextUtils.isEmpty(str2)) {
                int i3 = zze.$r8$clinit;
                zzo.zzj("Open GMSG did not contain a URL.");
                return false;
            }
            String str3 = zzcVar.zzc;
            if (TextUtils.isEmpty(str3)) {
                intent2.setData(Uri.parse(str2));
            } else {
                intent2.setDataAndType(Uri.parse(str2), str3);
            }
            intent2.setAction("android.intent.action.VIEW");
            String str4 = zzcVar.zzd;
            if (!TextUtils.isEmpty(str4)) {
                intent2.setPackage(str4);
            }
            String str5 = zzcVar.zze;
            if (!TextUtils.isEmpty(str5)) {
                String[] strArrSplit = str5.split("/", 2);
                if (strArrSplit.length < 2) {
                    int i4 = zze.$r8$clinit;
                    zzo.zzj("Could not parse component name from open GMSG: ".concat(str5));
                    return false;
                }
                intent2.setClassName(strArrSplit[0], strArrSplit[1]);
            }
            String str6 = zzcVar.zzf;
            if (!TextUtils.isEmpty(str6)) {
                try {
                    i = Integer.parseInt(str6);
                } catch (NumberFormatException unused) {
                    int i5 = zze.$r8$clinit;
                    zzo.zzj("Could not parse intent flags.");
                }
                intent2.addFlags(i);
            }
            zzbcv zzbcvVar = zzbde.zzeQ;
            zzbd zzbdVar = zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                intent2.addFlags(268435456);
                intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
            } else {
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzeP)).booleanValue()) {
                    zzs zzsVar = zzv.zza.zzd;
                    zzs.zzp(context, intent2);
                }
            }
            return zza(context, intent2, zzadVar, zzaaVar, zzcVar.zzj, zzdsjVar, str);
        }

        @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
        public void onFailure(FacebookException facebookException) {
            Log.e("Profile", Intrinsics.stringPlus(facebookException, oKjScaD.EupDSSIFFWFPhx));
        }

        public AccessTokenManager getInstance() {
            AccessTokenManager accessTokenManager;
            AccessTokenManager accessTokenManager2 = AccessTokenManager.instanceField;
            if (accessTokenManager2 != null) {
                return accessTokenManager2;
            }
            synchronized (this) {
                accessTokenManager = AccessTokenManager.instanceField;
                if (accessTokenManager == null) {
                    LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(applicationContext)");
                    AccessTokenManager accessTokenManager3 = new AccessTokenManager(localBroadcastManager, new AccessTokenCache(0));
                    AccessTokenManager.instanceField = accessTokenManager3;
                    accessTokenManager = accessTokenManager3;
                }
            }
            return accessTokenManager;
        }

        public static final boolean zza(Context context, Intent intent, zzad zzadVar, zzaa zzaaVar, boolean z, zzdsj zzdsjVar, String str) {
            int iZzn;
            if (z) {
                try {
                    iZzn = zzv.zza.zzd.zzn(context, intent.getData());
                    if (zzadVar != null) {
                        zzadVar.zzg();
                    }
                } catch (ActivityNotFoundException e) {
                    String message = e.getMessage();
                    int i = zze.$r8$clinit;
                    zzo.zzj(message);
                    iZzn = 6;
                }
                if (zzaaVar != null) {
                    zzaaVar.zzb(iZzn);
                }
                return iZzn == 5;
            }
            try {
                zze.zza("Launching an intent: " + intent.toURI());
                if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zznx)).booleanValue()) {
                    zzs zzsVar = zzv.zza.zzd;
                    zzs.zzY(context, intent, zzdsjVar, str);
                } else {
                    zzs zzsVar2 = zzv.zza.zzd;
                    zzs.zzU(context, intent);
                }
                if (zzadVar != null) {
                    zzadVar.zzg();
                }
                if (zzaaVar != null) {
                    zzaaVar.zza(true);
                }
                return true;
            } catch (ActivityNotFoundException e2) {
                String message2 = e2.getMessage();
                int i2 = zze.$r8$clinit;
                zzo.zzj(message2);
                if (zzaaVar != null) {
                    zzaaVar.zza(false);
                }
                return false;
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface KeyValueSerializer {
        void writeString(String str, String str2);
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int iNextInt = secureRandom.nextInt(11) + 30;
        if (iNextInt > 0) {
            int i = 0;
            do {
                i++;
                sb.append(charArray[secureRandom.nextInt(charArray.length)]);
            } while (i < iNextInt);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
        MIME_BOUNDARY = string;
        versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback) {
        this.accessToken = accessToken;
        this.graphPath = str;
        this.version = null;
        setCallback(callback);
        this.httpMethod = httpMethod == null ? HttpMethod.GET : httpMethod;
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        this.version = FacebookSdk.getGraphApiVersion();
    }

    public static String getClientTokenForRequest() {
        String applicationId = FacebookSdk.getApplicationId();
        Validate.sdkInitialized();
        String str = FacebookSdk.appClientToken;
        if (str == null) {
            throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
        }
        if (applicationId.length() <= 0 || str.length() <= 0) {
            return null;
        }
        return applicationId + '|' + str;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    public final void addCommonParameters() {
        Bundle bundle = this.parameters;
        String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
        boolean zContains$default = accessTokenToUseForRequest == null ? false : StringsKt__StringsKt.contains$default(accessTokenToUseForRequest, "|");
        if (accessTokenToUseForRequest == null || !StringsKt__StringsKt.startsWith(accessTokenToUseForRequest, "IG", false) || zContains$default || !isApplicationRequest()) {
            if ((Intrinsics.areEqual(FacebookSdk.getGraphDomain(), "instagram.com") ? true ^ isApplicationRequest() : true) || zContains$default) {
                String accessTokenToUseForRequest2 = getAccessTokenToUseForRequest();
                if (accessTokenToUseForRequest2 != null) {
                    bundle.putString("access_token", accessTokenToUseForRequest2);
                }
            } else {
                bundle.putString("access_token", getClientTokenForRequest());
            }
        } else {
            bundle.putString("access_token", getClientTokenForRequest());
        }
        if (!bundle.containsKey("access_token")) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Validate.sdkInitialized();
            String str = FacebookSdk.appClientToken;
            if (str == null) {
                throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
            }
            if (Utility.isNullOrEmpty(str)) {
                Log.w("GraphRequest", "Starting with v13 of the SDK, a client token must be embedded in your client code before making Graph API calls. Visit https://developers.facebook.com/docs/android/getting-started#client-token to learn how to implement this change.");
            }
        }
        bundle.putString("sdk", "android");
        bundle.putString("format", "json");
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        synchronized (FacebookSdk.loggingBehaviors) {
        }
        FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
    }

    public final String appendParametersToBaseUrl(String str, boolean z) {
        if (!z && this.httpMethod == HttpMethod.POST) {
            return str;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (Companion.isSupportedParameterType(obj)) {
                builderBuildUpon.appendQueryParameter(str2, Companion.access$parameterToString(obj).toString());
            } else if (this.httpMethod != HttpMethod.GET) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1)));
            }
        }
        String string = builderBuildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uriBuilder.toString()");
        return string;
    }

    public final GraphResponse executeAndWait() throws Throwable {
        ArrayList arrayListExecuteBatchAndWait = Companion.executeBatchAndWait(new GraphRequestBatch(ArraysKt.toList(new GraphRequest[]{this})));
        if (arrayListExecuteBatchAndWait.size() == 1) {
            return (GraphResponse) arrayListExecuteBatchAndWait.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    public final GraphRequestAsyncTask executeAsync() {
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch(ArraysKt.toList(new GraphRequest[]{this}));
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch);
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        return graphRequestAsyncTask;
    }

    public final String getAccessTokenToUseForRequest() {
        AccessToken accessToken = this.accessToken;
        if (accessToken != null) {
            if (!this.parameters.containsKey("access_token")) {
                Companion companion = Logger.Companion;
                String str = accessToken.token;
                companion.registerAccessToken(str);
                return str;
            }
        } else if (!this.parameters.containsKey("access_token")) {
            return getClientTokenForRequest();
        }
        return this.parameters.getString("access_token");
    }

    public final String getUrlForSingleRequest() {
        String str;
        String str2;
        if (this.httpMethod == HttpMethod.POST && (str2 = this.graphPath) != null && str2.endsWith("/videos")) {
            str = String.format(ZRqOdXiy.SXvmXwBgcmuHlEZ, Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
        } else {
            String subdomain = FacebookSdk.getGraphDomain();
            Intrinsics.checkNotNullParameter(subdomain, "subdomain");
            str = String.format("https://graph.%s", Arrays.copyOf(new Object[]{subdomain}, 1));
        }
        String urlWithGraphPath = getUrlWithGraphPath(str);
        addCommonParameters();
        return appendParametersToBaseUrl(urlWithGraphPath, false);
    }

    public final String getUrlWithGraphPath(String str) {
        if (!(!Intrinsics.areEqual(FacebookSdk.getGraphDomain(), "instagram.com") ? true : !isApplicationRequest())) {
            str = String.format("https://graph.%s", Arrays.copyOf(new Object[]{FacebookSdk.facebookDomain}, 1));
        }
        Pattern pattern = versionPattern;
        String str2 = this.graphPath;
        if (!pattern.matcher(str2).matches()) {
            str2 = String.format("%s/%s", Arrays.copyOf(new Object[]{this.version, str2}, 2));
        }
        return String.format("%s/%s", Arrays.copyOf(new Object[]{str, str2}, 2));
    }

    public final boolean isApplicationRequest() {
        String str = this.graphPath;
        if (str == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder("^/?");
        sb.append(FacebookSdk.getApplicationId());
        sb.append("/?.*");
        return this.forceApplicationRequest || Pattern.matches(sb.toString(), str) || Pattern.matches("^/?app/?.*", str);
    }

    public final void setCallback(Callback callback) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        synchronized (FacebookSdk.loggingBehaviors) {
        }
        FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
        this.callback = callback;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{Request:  accessToken: ");
        Object obj = this.accessToken;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.graphPath);
        sb.append(", graphObject: ");
        sb.append(this.graphObject);
        sb.append(", httpMethod: ");
        sb.append(this.httpMethod);
        sb.append(", parameters: ");
        sb.append(this.parameters);
        sb.append("}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder()\n        .append(\"{Request: \")\n        .append(\" accessToken: \")\n        .append(if (accessToken == null) \"null\" else accessToken)\n        .append(\", graphPath: \")\n        .append(graphPath)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", httpMethod: \")\n        .append(httpMethod)\n        .append(\", parameters: \")\n        .append(parameters)\n        .append(\"}\")\n        .toString()");
        return string;
    }

    public final class ParcelableResourceWithMimeType implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new FragmentState.AnonymousClass1(25);
        public final String mimeType;
        public final Parcelable resource;

        public ParcelableResourceWithMimeType(Parcelable parcelable) {
            this.mimeType = "image/png";
            this.resource = parcelable;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 1;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.mimeType);
            out.writeParcelable(this.resource, i);
        }

        public ParcelableResourceWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            this.resource = parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }
    }
}
