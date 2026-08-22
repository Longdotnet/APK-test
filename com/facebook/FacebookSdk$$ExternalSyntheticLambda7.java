package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.room.RoomOpenHelper;
import androidx.work.Worker;
import com.daerisoft.thespikerm.RunnerActivity;
import com.facebook.appevents.AppEventCollection;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.FlushReason;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class FacebookSdk$$ExternalSyntheticLambda7 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ FacebookSdk$$ExternalSyntheticLambda7(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        AccessToken accessTokenCreateFromJSONObject$facebook_core_release;
        Profile profile;
        AccessToken currentAccessToken;
        String string;
        switch (this.$r8$classId) {
            case 0:
                RoomOpenHelper roomOpenHelper = (RoomOpenHelper) this.f$0;
                AccessTokenManager companion = AccessTokenManager.Companion.getInstance();
                SharedPreferences sharedPreferences = (SharedPreferences) companion.accessTokenCache.sharedPreferences;
                if (sharedPreferences.contains("com.facebook.AccessTokenManager.CachedAccessToken") && (string = sharedPreferences.getString("com.facebook.AccessTokenManager.CachedAccessToken", null)) != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
                        accessTokenCreateFromJSONObject$facebook_core_release = Headers.Companion.createFromJSONObject$facebook_core_release(jSONObject);
                    } catch (JSONException unused) {
                        accessTokenCreateFromJSONObject$facebook_core_release = null;
                    }
                    break;
                } else {
                    accessTokenCreateFromJSONObject$facebook_core_release = null;
                }
                if (accessTokenCreateFromJSONObject$facebook_core_release != null) {
                    companion.setCurrentAccessToken(accessTokenCreateFromJSONObject$facebook_core_release, false);
                }
                GraphRequest.Companion companion2 = ProfileManager.Companion;
                ProfileManager profileManagerM64getInstance = companion2.m64getInstance();
                String string2 = ((SharedPreferences) profileManagerM64getInstance.profileCache.sharedPreferences).getString("com.facebook.ProfileManager.CachedProfile", null);
                if (string2 != null) {
                    try {
                        profile = new Profile(new JSONObject(string2));
                    } catch (JSONException unused2) {
                        profile = null;
                    }
                    break;
                } else {
                    profile = null;
                }
                if (profile != null) {
                    profileManagerM64getInstance.setCurrentProfile(profile, false);
                }
                Date date2 = AccessToken.DEFAULT_EXPIRATION_TIME;
                if (Headers.Companion.isCurrentAccessTokenActive() && companion2.m64getInstance().currentProfileField == null && (currentAccessToken = Headers.Companion.getCurrentAccessToken()) != null) {
                    if (Headers.Companion.isCurrentAccessTokenActive()) {
                        Utility.getGraphMeRequestWithCacheAsync(new GraphRequest.Companion(5), currentAccessToken.token);
                    } else {
                        companion2.m64getInstance().setCurrentProfile(null, true);
                    }
                }
                if (roomOpenHelper != null) {
                    ((RunnerActivity) roomOpenHelper.mConfiguration).runOnUiThread(new Worker.AnonymousClass1(roomOpenHelper, 20));
                }
                Context applicationContext = FacebookSdk.getApplicationContext();
                String str = FacebookSdk.applicationId;
                if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                    AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(applicationContext, str);
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
                    if (scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp == null) {
                        throw new IllegalStateException(wsbWxekY.IGkgyYRuTnXyB);
                    }
                    scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp.execute(new GraphRequest$Companion$$ExternalSyntheticLambda1(applicationContext, appEventsLoggerImpl, 11));
                }
                if (!CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
                    try {
                        Context applicationContext2 = FacebookSdk.getApplicationContext();
                        ApplicationInfo applicationInfo = applicationContext2.getPackageManager().getApplicationInfo(applicationContext2.getPackageName(), 128);
                        Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
                        Bundle bundle = applicationInfo.metaData;
                        if (bundle != null && bundle.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                            AppEventsLoggerImpl appEventsLoggerImpl2 = new AppEventsLoggerImpl(applicationContext2, (String) null);
                            Bundle bundle2 = new Bundle();
                            if (!Utility.isAutoAppLinkSetup()) {
                                bundle2.putString("SchemeWarning", "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                                Log.w("com.facebook.UserSettingsManager", "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                            }
                            if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                                appEventsLoggerImpl2.logEvent("fb_auto_applink", bundle2);
                            }
                        }
                        break;
                    } catch (PackageManager.NameNotFoundException unused3) {
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(UserSettingsManager.class, th);
                    }
                }
                Context applicationContext3 = FacebookSdk.getApplicationContext().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext().applicationContext");
                AppEventsLoggerImpl appEventsLoggerImpl3 = new AppEventsLoggerImpl(applicationContext3, (String) null);
                if (!CrashShieldHandler.isObjectCrashing(appEventsLoggerImpl3)) {
                    try {
                        AppEventCollection appEventCollection = AppEventQueue.appEventCollection;
                        AppEventQueue.flush(FlushReason.EXPLICIT);
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(appEventsLoggerImpl3, th2);
                    }
                    break;
                }
                return null;
            default:
                return ((FirebaseInstallations) this.f$0).deleteFirebaseInstallationId();
        }
    }
}
