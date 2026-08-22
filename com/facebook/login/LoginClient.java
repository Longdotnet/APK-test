package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.FragmentActivity;
import com.daerisoft.thespikerm.R;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.ProfileCache;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.appset.zzb;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.internal.concurrent.onZL.mnwSv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class LoginClient implements Parcelable {
    public static final Parcelable.Creator<LoginClient> CREATOR = new zzb(4);
    public ProfileCache backgroundProcessingListener;
    public boolean checkedInternetPermission;
    public int currentHandler;
    public LinkedHashMap extraData;
    public LoginFragment fragment;
    public LoginMethodHandler[] handlersToTry;
    public Map loggingExtras;
    public LoginLogger loginLogger;
    public int numActivitiesReturned;
    public int numTotalIntentsFired;
    public InputConnectionCompat$$ExternalSyntheticLambda0 onCompletedListener;
    public Request pendingRequest;

    /* JADX INFO: loaded from: classes.dex */
    public final class Request implements Parcelable {
        public static final Parcelable.Creator<Request> CREATOR = new zzb(5);
        public final String applicationId;
        public final String authId;
        public final String authType;
        public final String codeChallenge;
        public final CodeChallengeMethod codeChallengeMethod;
        public final String codeVerifier;
        public final DefaultAudience defaultAudience;
        public final String deviceAuthTargetUserId;
        public final String deviceRedirectUriString;
        public final boolean isFamilyLogin;
        public final boolean isRerequest;
        public final LoginBehavior loginBehavior;
        public final LoginTargetApp loginTargetApp;
        public final String messengerPageId;
        public final String nonce;
        public HashSet permissions;
        public final boolean resetMessengerState;
        public final boolean shouldSkipAccountDeduplication;

        public Request(Parcel parcel) {
            String string = parcel.readString();
            Validate.notNullOrEmpty(string, "loginBehavior");
            this.loginBehavior = LoginBehavior.valueOf(string);
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            String string2 = parcel.readString();
            this.defaultAudience = string2 != null ? DefaultAudience.valueOf(string2) : DefaultAudience.NONE;
            String string3 = parcel.readString();
            Validate.notNullOrEmpty(string3, "applicationId");
            this.applicationId = string3;
            String string4 = parcel.readString();
            Validate.notNullOrEmpty(string4, "authId");
            this.authId = string4;
            this.isRerequest = parcel.readByte() != 0;
            this.deviceRedirectUriString = parcel.readString();
            String string5 = parcel.readString();
            Validate.notNullOrEmpty(string5, "authType");
            this.authType = string5;
            this.deviceAuthTargetUserId = parcel.readString();
            this.messengerPageId = parcel.readString();
            this.resetMessengerState = parcel.readByte() != 0;
            String string6 = parcel.readString();
            this.loginTargetApp = string6 != null ? LoginTargetApp.valueOf(string6) : LoginTargetApp.FACEBOOK;
            this.isFamilyLogin = parcel.readByte() != 0;
            this.shouldSkipAccountDeduplication = parcel.readByte() != 0;
            String string7 = parcel.readString();
            Validate.notNullOrEmpty(string7, "nonce");
            this.nonce = string7;
            this.codeVerifier = parcel.readString();
            this.codeChallenge = parcel.readString();
            String string8 = parcel.readString();
            this.codeChallengeMethod = string8 == null ? null : CodeChallengeMethod.valueOf(string8);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean hasPublishPermission() {
            for (String str : this.permissions) {
                Set set = LoginManager.OTHER_PUBLISH_PERMISSIONS;
                if (str != null && (StringsKt__StringsKt.startsWith(str, "publish", false) || StringsKt__StringsKt.startsWith(str, "manage", false) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(str))) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isInstagramLogin() {
            return this.loginTargetApp == LoginTargetApp.INSTAGRAM;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int i) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.loginBehavior.name());
            dest.writeStringList(new ArrayList(this.permissions));
            dest.writeString(this.defaultAudience.name());
            dest.writeString(this.applicationId);
            dest.writeString(this.authId);
            dest.writeByte(this.isRerequest ? (byte) 1 : (byte) 0);
            dest.writeString(this.deviceRedirectUriString);
            dest.writeString(this.authType);
            dest.writeString(this.deviceAuthTargetUserId);
            dest.writeString(this.messengerPageId);
            dest.writeByte(this.resetMessengerState ? (byte) 1 : (byte) 0);
            dest.writeString(this.loginTargetApp.name());
            dest.writeByte(this.isFamilyLogin ? (byte) 1 : (byte) 0);
            dest.writeByte(this.shouldSkipAccountDeduplication ? (byte) 1 : (byte) 0);
            dest.writeString(this.nonce);
            dest.writeString(this.codeVerifier);
            dest.writeString(this.codeChallenge);
            CodeChallengeMethod codeChallengeMethod = this.codeChallengeMethod;
            dest.writeString(codeChallengeMethod == null ? null : codeChallengeMethod.name());
        }
    }

    public final void addLoggingExtra(String str, String str2, boolean z) {
        Map map = this.loggingExtras;
        if (map == null) {
            map = new HashMap();
        }
        if (this.loggingExtras == null) {
            this.loggingExtras = map;
        }
        if (map.containsKey(str) && z) {
            str2 = map.get(str) + ',' + str2;
        }
        map.put(str, str2);
    }

    public final boolean checkInternetPermission() {
        if (this.checkedInternetPermission) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if ((activity == null ? -1 : activity.checkCallingOrSelfPermission("android.permission.INTERNET")) == 0) {
            this.checkedInternetPermission = true;
            return true;
        }
        FragmentActivity activity2 = getActivity();
        String string = activity2 == null ? null : activity2.getString(R.string.com_facebook_internet_permission_error_title);
        String string2 = activity2 != null ? activity2.getString(R.string.com_facebook_internet_permission_error_message) : null;
        Request request = this.pendingRequest;
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            arrayList.add(string);
        }
        if (string2 != null) {
            arrayList.add(string2);
        }
        complete(new Result(request, Result.Code.ERROR, null, null, TextUtils.join(": ", arrayList), null));
        return false;
    }

    public final void complete(Result outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        LoginMethodHandler currentHandler = getCurrentHandler();
        Result.Code code = outcome.code;
        if (currentHandler != null) {
            logAuthorizationMethodComplete(currentHandler.getNameForLogging(), code.loggingValue, outcome.errorMessage, outcome.errorCode, currentHandler.methodLoggingExtras);
        }
        Map map = this.loggingExtras;
        if (map != null) {
            outcome.loggingExtras = map;
        }
        LinkedHashMap linkedHashMap = this.extraData;
        if (linkedHashMap != null) {
            outcome.extraData = linkedHashMap;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        this.numActivitiesReturned = 0;
        this.numTotalIntentsFired = 0;
        InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda0 = this.onCompletedListener;
        if (inputConnectionCompat$$ExternalSyntheticLambda0 == null) {
            return;
        }
        LoginFragment this$0 = (LoginFragment) inputConnectionCompat$$ExternalSyntheticLambda0.f$0;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.request = null;
        int i = code == Result.Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", outcome);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        FragmentActivity activity = this$0.getActivity();
        if (!this$0.isAdded() || activity == null) {
            return;
        }
        activity.setResult(i, intent);
        activity.finish();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final FragmentActivity getActivity() {
        LoginFragment loginFragment = this.fragment;
        if (loginFragment == null) {
            return null;
        }
        return loginFragment.getActivity();
    }

    public final LoginMethodHandler getCurrentHandler() {
        LoginMethodHandler[] loginMethodHandlerArr;
        int i = this.currentHandler;
        if (i < 0 || (loginMethodHandlerArr = this.handlersToTry) == null) {
            return null;
        }
        return loginMethodHandlerArr[i];
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0022  */
    /* JADX WARN: Code duplicated, block: B:19:0x002a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0032  */
    /* JADX WARN: Code duplicated, block: B:23:0x0037  */
    public final LoginLogger getLogger() {
        Context activity;
        Request request;
        String applicationId;
        String str;
        LoginLogger loginLogger = this.loginLogger;
        if (loginLogger != null) {
            if (CrashShieldHandler.isObjectCrashing(loginLogger)) {
                str = null;
            } else {
                try {
                    str = loginLogger.applicationId;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(loginLogger, th);
                    str = null;
                }
            }
            Request request2 = this.pendingRequest;
            if (!Intrinsics.areEqual(str, request2 != null ? request2.applicationId : null)) {
                activity = getActivity();
                if (activity == null) {
                    activity = FacebookSdk.getApplicationContext();
                }
                request = this.pendingRequest;
                if (request == null) {
                    applicationId = FacebookSdk.getApplicationId();
                } else {
                    applicationId = request.applicationId;
                }
                loginLogger = new LoginLogger(activity, applicationId);
                this.loginLogger = loginLogger;
            }
        } else {
            activity = getActivity();
            if (activity == null) {
                activity = FacebookSdk.getApplicationContext();
            }
            request = this.pendingRequest;
            if (request == null) {
                applicationId = FacebookSdk.getApplicationId();
            } else {
                applicationId = request.applicationId;
            }
            loginLogger = new LoginLogger(activity, applicationId);
            this.loginLogger = loginLogger;
        }
        return loginLogger;
    }

    public final void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, HashMap map) {
        Request request = this.pendingRequest;
        if (request == null) {
            LoginLogger logger = getLogger();
            if (CrashShieldHandler.isObjectCrashing(logger)) {
                return;
            }
            try {
                ScheduledExecutorService scheduledExecutorService = LoginLogger.worker;
                Bundle bundleAccess$newAuthorizationLoggingBundle = GraphRequest.Companion.access$newAuthorizationLoggingBundle("");
                bundleAccess$newAuthorizationLoggingBundle.putString("2_result", "error");
                bundleAccess$newAuthorizationLoggingBundle.putString("5_error_message", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
                bundleAccess$newAuthorizationLoggingBundle.putString("3_method", str);
                logger.logger.logEventImplicitly(bundleAccess$newAuthorizationLoggingBundle, "fb_mobile_login_method_complete");
                return;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(logger, th);
                return;
            }
        }
        LoginLogger logger2 = getLogger();
        String str5 = request.authId;
        String str6 = request.isFamilyLogin ? "foa_mobile_login_method_complete" : "fb_mobile_login_method_complete";
        if (CrashShieldHandler.isObjectCrashing(logger2)) {
            return;
        }
        try {
            ScheduledExecutorService scheduledExecutorService2 = LoginLogger.worker;
            Bundle bundleAccess$newAuthorizationLoggingBundle2 = GraphRequest.Companion.access$newAuthorizationLoggingBundle(str5);
            bundleAccess$newAuthorizationLoggingBundle2.putString("2_result", str2);
            if (str3 != null) {
                bundleAccess$newAuthorizationLoggingBundle2.putString("5_error_message", str3);
            }
            if (str4 != null) {
                bundleAccess$newAuthorizationLoggingBundle2.putString("4_error_code", str4);
            }
            if (map != null && !map.isEmpty()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (((String) entry.getKey()) != null) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                bundleAccess$newAuthorizationLoggingBundle2.putString("6_extras", new JSONObject((Map) linkedHashMap).toString());
            }
            bundleAccess$newAuthorizationLoggingBundle2.putString("3_method", str);
            logger2.logger.logEventImplicitly(bundleAccess$newAuthorizationLoggingBundle2, str6);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(logger2, th2);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        this.numActivitiesReturned++;
        if (this.pendingRequest != null) {
            if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
                tryNextHandler();
                return;
            }
            LoginMethodHandler currentHandler = getCurrentHandler();
            if (currentHandler != null) {
                if ((currentHandler instanceof KatanaProxyLoginMethodHandler) && intent == null && this.numActivitiesReturned < this.numTotalIntentsFired) {
                    return;
                }
                currentHandler.onActivityResult(i, i2, intent);
            }
        }
    }

    public final void tryNextHandler() {
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            logAuthorizationMethodComplete(currentHandler.getNameForLogging(), "skipped", null, null, currentHandler.methodLoggingExtras);
        }
        LoginMethodHandler[] loginMethodHandlerArr = this.handlersToTry;
        while (loginMethodHandlerArr != null) {
            int i = this.currentHandler;
            if (i >= loginMethodHandlerArr.length - 1) {
                break;
            }
            this.currentHandler = i + 1;
            LoginMethodHandler currentHandler2 = getCurrentHandler();
            if (currentHandler2 != null) {
                if (!(currentHandler2 instanceof WebViewLoginMethodHandler) || checkInternetPermission()) {
                    Request request = this.pendingRequest;
                    if (request == null) {
                        continue;
                    } else {
                        int iTryAuthorize = currentHandler2.tryAuthorize(request);
                        this.numActivitiesReturned = 0;
                        boolean z = request.isFamilyLogin;
                        String str = request.authId;
                        if (iTryAuthorize > 0) {
                            LoginLogger logger = getLogger();
                            String nameForLogging = currentHandler2.getNameForLogging();
                            String str2 = z ? "foa_mobile_login_method_start" : "fb_mobile_login_method_start";
                            if (!CrashShieldHandler.isObjectCrashing(logger)) {
                                try {
                                    ScheduledExecutorService scheduledExecutorService = LoginLogger.worker;
                                    Bundle bundleAccess$newAuthorizationLoggingBundle = GraphRequest.Companion.access$newAuthorizationLoggingBundle(str);
                                    bundleAccess$newAuthorizationLoggingBundle.putString("3_method", nameForLogging);
                                    logger.logger.logEventImplicitly(bundleAccess$newAuthorizationLoggingBundle, str2);
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(logger, th);
                                }
                            }
                            this.numTotalIntentsFired = iTryAuthorize;
                        } else {
                            LoginLogger logger2 = getLogger();
                            String nameForLogging2 = currentHandler2.getNameForLogging();
                            String str3 = z ? "foa_mobile_login_method_not_tried" : "fb_mobile_login_method_not_tried";
                            if (!CrashShieldHandler.isObjectCrashing(logger2)) {
                                try {
                                    ScheduledExecutorService scheduledExecutorService2 = LoginLogger.worker;
                                    Bundle bundleAccess$newAuthorizationLoggingBundle2 = GraphRequest.Companion.access$newAuthorizationLoggingBundle(str);
                                    bundleAccess$newAuthorizationLoggingBundle2.putString("3_method", nameForLogging2);
                                    logger2.logger.logEventImplicitly(bundleAccess$newAuthorizationLoggingBundle2, str3);
                                } catch (Throwable th2) {
                                    CrashShieldHandler.handleThrowable(logger2, th2);
                                }
                            }
                            addLoggingExtra("not_tried", currentHandler2.getNameForLogging(), true);
                        }
                        if (iTryAuthorize > 0) {
                            return;
                        }
                    }
                } else {
                    addLoggingExtra("no_internet_permission", "1", false);
                }
            }
        }
        Request request2 = this.pendingRequest;
        if (request2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("Login attempt failed.");
            complete(new Result(request2, Result.Code.ERROR, null, null, TextUtils.join(": ", arrayList), null));
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelableArray(this.handlersToTry, i);
        dest.writeInt(this.currentHandler);
        dest.writeParcelable(this.pendingRequest, i);
        Utility.writeNonnullStringMapToParcel(dest, this.loggingExtras);
        Utility.writeNonnullStringMapToParcel(dest, this.extraData);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:8:0x001c, B:10:0x0026, B:14:0x0053, B:13:0x0039), top: B:22:0x001c }] */
    public final void completeAndValidate(Result result) {
        Result result2;
        Intrinsics.checkNotNullParameter(result, mnwSv.XvxzaN);
        AccessToken accessToken = result.token;
        if (accessToken != null) {
            Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
            if (Headers.Companion.isCurrentAccessTokenActive()) {
                AccessToken currentAccessToken = Headers.Companion.getCurrentAccessToken();
                Result.Code code = Result.Code.ERROR;
                if (currentAccessToken != null) {
                    try {
                        if (Intrinsics.areEqual(currentAccessToken.userId, accessToken.userId)) {
                            result2 = new Result(this.pendingRequest, Result.Code.SUCCESS, result.token, result.authenticationToken, null, null);
                        } else {
                            Request request = this.pendingRequest;
                            ArrayList arrayList = new ArrayList();
                            arrayList.add("User logged in as different Facebook user.");
                            result2 = new Result(request, code, null, null, TextUtils.join(": ", arrayList), null);
                        }
                    } catch (Exception e) {
                        Request request2 = this.pendingRequest;
                        String message = e.getMessage();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add("Caught exception");
                        if (message != null) {
                            arrayList2.add(message);
                        }
                        complete(new Result(request2, code, null, null, TextUtils.join(": ", arrayList2), null));
                        return;
                    }
                } else {
                    Request request3 = this.pendingRequest;
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add("User logged in as different Facebook user.");
                    result2 = new Result(request3, code, null, null, TextUtils.join(": ", arrayList3), null);
                }
                complete(result2);
                return;
            }
        }
        complete(result);
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new zzb(6);
        public final AuthenticationToken authenticationToken;
        public final Code code;
        public final String errorCode;
        public final String errorMessage;
        public HashMap extraData;
        public Map loggingExtras;
        public final Request request;
        public final AccessToken token;

        public enum Code {
            SUCCESS(FirebaseAnalytics.Param.SUCCESS),
            CANCEL("cancel"),
            ERROR("error");

            public final String loggingValue;

            Code(String str) {
                this.loggingValue = str;
            }

            /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
            public static Code[] valuesCustom() {
                return (Code[]) Arrays.copyOf(values(), 3);
            }
        }

        public Result(Request request, Code code, AccessToken accessToken, AuthenticationToken authenticationToken, String str, String str2) {
            this.request = request;
            this.token = accessToken;
            this.authenticationToken = authenticationToken;
            this.errorMessage = str;
            this.code = code;
            this.errorCode = str2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int i) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.code.name());
            dest.writeParcelable(this.token, i);
            dest.writeParcelable(this.authenticationToken, i);
            dest.writeString(this.errorMessage);
            dest.writeString(this.errorCode);
            dest.writeParcelable(this.request, i);
            Utility.writeNonnullStringMapToParcel(dest, this.loggingExtras);
            Utility.writeNonnullStringMapToParcel(dest, this.extraData);
        }

        public Result(Parcel parcel) {
            String string = parcel.readString();
            this.code = Code.valueOf(string == null ? "error" : string);
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.authenticationToken = (AuthenticationToken) parcel.readParcelable(AuthenticationToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readNonnullStringMapFromParcel(parcel);
            this.extraData = Utility.readNonnullStringMapFromParcel(parcel);
        }
    }
}
