package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UserDataStore$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$1;

    public /* synthetic */ UserDataStore$$ExternalSyntheticLambda0(String str, int i) {
        this.$r8$classId = i;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = true;
        Locale locale = null;
        switch (this.$r8$classId) {
            case 0:
                String str = this.f$1;
                if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
                    return;
                }
                try {
                    if (!UserDataStore.initialized.get()) {
                        UserDataStore.INSTANCE.initAndWait();
                    }
                    SharedPreferences sharedPreferences = UserDataStore.sharedPreferences;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putString("com.facebook.appevents.UserDataStore.internalUserData", str).apply();
                        return;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        throw null;
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(UserDataStore.class, th);
                    return;
                }
            default:
                String str2 = this.f$1;
                if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
                    return;
                }
                try {
                    Bundle bundle = new Bundle();
                    AttributionIdentifiers attributionIdentifiers = Validate.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                    JSONArray jSONArray = new JSONArray();
                    String str3 = Build.MODEL;
                    if (str3 == null) {
                        str3 = "";
                    }
                    jSONArray.put(str3);
                    if ((attributionIdentifiers == null ? null : attributionIdentifiers.getAndroidAdvertiserId()) != null) {
                        jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
                    } else {
                        jSONArray.put("");
                    }
                    jSONArray.put("0");
                    jSONArray.put(AppEventUtility.isEmulator() ? "1" : "0");
                    try {
                        locale = FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
                        break;
                    } catch (Exception unused) {
                    }
                    if (locale == null) {
                        locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                    }
                    jSONArray.put(locale.getLanguage() + '_' + ((Object) locale.getCountry()));
                    String string = jSONArray.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "extInfoArray.toString()");
                    bundle.putString("device_session_id", CodelessManager.getCurrentDeviceSessionID$facebook_core_release());
                    bundle.putString("extinfo", string);
                    String str4 = GraphRequest.MIME_BOUNDARY;
                    JSONObject jSONObject = new GraphRequest(null, String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{str2}, 1)), bundle, HttpMethod.POST, null).executeAndWait().graphObject;
                    AtomicBoolean atomicBoolean = CodelessManager.isAppIndexingEnabled;
                    if (jSONObject == null || !jSONObject.optBoolean("is_app_indexing_enabled", false)) {
                        z = false;
                    }
                    atomicBoolean.set(z);
                    if (atomicBoolean.get()) {
                        ViewIndexer viewIndexer = CodelessManager.viewIndexer;
                        if (viewIndexer != null) {
                            viewIndexer.schedule();
                        }
                    } else {
                        CodelessManager.deviceSessionID = null;
                    }
                    CodelessManager.isCheckingSession = false;
                    return;
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(CodelessManager.class, th2);
                    return;
                }
        }
    }
}
