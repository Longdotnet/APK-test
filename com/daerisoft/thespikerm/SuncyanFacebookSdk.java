package com.daerisoft.thespikerm;

import android.util.Log;
import androidx.room.RoomOpenHelper;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.UserSettingsManager;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class SuncyanFacebookSdk extends RunnerSocial {
    public static double msInitialized;
    public CallbackManager callbackManager = null;

    public String fb_init() {
        if (msInitialized == 1.0d) {
            return "false";
        }
        RunnerActivity runnerActivity = RunnerActivity.CurrentActivity;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        if (!CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            try {
                UserSettingsManager.UserSetting userSetting = UserSettingsManager.autoInitEnabled;
                userSetting.value = Boolean.TRUE;
                userSetting.lastTS = System.currentTimeMillis();
                boolean z = UserSettingsManager.isInitialized.get();
                UserSettingsManager userSettingsManager2 = UserSettingsManager.INSTANCE;
                if (z) {
                    userSettingsManager2.writeSettingToCache(userSetting);
                } else {
                    userSettingsManager2.initializeIfNotInitialized();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(UserSettingsManager.class, th);
            }
        }
        FacebookSdk.isFullyInitialized = true;
        try {
            String applicationId = runnerActivity.getResources().getString(R.string.facebook_app_id);
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Validate.notEmpty(applicationId, "applicationId");
            FacebookSdk.applicationId = applicationId;
            FacebookSdk.appClientToken = runnerActivity.getResources().getString(R.string.facebook_client_token);
            FacebookSdk.sdkInitialize(runnerActivity.getApplicationContext(), new RoomOpenHelper(this, runnerActivity, 21));
            return "true";
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "Error initializing Facebook SDK: " + e.getMessage());
            return "false";
        }
    }

    public double fb_ready() {
        return msInitialized;
    }
}
