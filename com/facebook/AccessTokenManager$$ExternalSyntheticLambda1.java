package com.facebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import com.android.billingclient.api.zzda;
import com.daerisoft.thespikerm.R;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.SessionEventsState;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DeviceAuthDialog;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AccessTokenManager$$ExternalSyntheticLambda1 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ AccessTokenManager$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    /* JADX WARN: Code duplicated, block: B:75:0x01c9  */
    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        JSONArray jSONArrayOptJSONArray;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f$0;
                HashSet hashSet = (HashSet) this.f$1;
                HashSet hashSet2 = (HashSet) this.f$2;
                HashSet hashSet3 = (HashSet) this.f$3;
                JSONObject jSONObject = graphResponse.jsonObject;
                if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(ZRqOdXiy.RywNBwXYA)) != null) {
                    atomicBoolean.set(true);
                    int length = jSONArrayOptJSONArray.length();
                    if (length > 0) {
                        while (true) {
                            int i2 = i + 1;
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                String strOptString = jSONObjectOptJSONObject.optString("permission");
                                String status = jSONObjectOptJSONObject.optString("status");
                                if (!Utility.isNullOrEmpty(strOptString) && !Utility.isNullOrEmpty(status)) {
                                    Intrinsics.checkNotNullExpressionValue(status, "status");
                                    Locale US = Locale.US;
                                    Intrinsics.checkNotNullExpressionValue(US, "US");
                                    String lowerCase = status.toLowerCase(US);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                    int iHashCode = lowerCase.hashCode();
                                    if (iHashCode != -1309235419) {
                                        if (iHashCode != 280295099) {
                                            if (iHashCode == 568196142 && lowerCase.equals("declined")) {
                                                hashSet2.add(strOptString);
                                            } else {
                                                Log.w("AccessTokenManager", Intrinsics.stringPlus(lowerCase, "Unexpected status: "));
                                            }
                                        } else if (lowerCase.equals(TSDAbK.bALQ)) {
                                            hashSet.add(strOptString);
                                        } else {
                                            Log.w("AccessTokenManager", Intrinsics.stringPlus(lowerCase, "Unexpected status: "));
                                        }
                                    } else if (lowerCase.equals("expired")) {
                                        hashSet3.add(strOptString);
                                    } else {
                                        Log.w("AccessTokenManager", Intrinsics.stringPlus(lowerCase, "Unexpected status: "));
                                    }
                                }
                            }
                            if (i2 < length) {
                                i = i2;
                            }
                        }
                    }
                }
                break;
            case 1:
                AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) this.f$0;
                GraphRequest graphRequest = (GraphRequest) this.f$1;
                SessionEventsState sessionEventsState = (SessionEventsState) this.f$2;
                zzda zzdaVar = (zzda) this.f$3;
                if (!CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
                    try {
                        AppEventQueue.handleResponse(accessTokenAppIdPair, graphRequest, graphResponse, sessionEventsState, zzdaVar);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(AppEventQueue.class, th);
                        return;
                    }
                    break;
                }
                break;
            default:
                final DeviceAuthDialog this$0 = (DeviceAuthDialog) this.f$0;
                final String str = (String) this.f$1;
                final Date date = (Date) this.f$2;
                final Date date2 = (Date) this.f$3;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (!this$0.completed.get()) {
                    FacebookRequestError facebookRequestError = graphResponse.error;
                    if (facebookRequestError != null) {
                        FacebookException facebookException = facebookRequestError.exception;
                        if (facebookException == null) {
                            facebookException = new FacebookException();
                        }
                        this$0.onError(facebookException);
                    } else {
                        try {
                            JSONObject jSONObject2 = graphResponse.graphObject;
                            if (jSONObject2 == null) {
                                jSONObject2 = new JSONObject();
                            }
                            final String string = jSONObject2.getString("id");
                            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"id\")");
                            final zzbf zzbfVarAccess$handlePermissionResponse = GraphRequest.Companion.access$handlePermissionResponse(jSONObject2);
                            String string2 = jSONObject2.getString("name");
                            Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"name\")");
                            DeviceAuthDialog.RequestState requestState = this$0.currentRequestState;
                            if (requestState != null) {
                                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.userCode);
                            }
                            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                            if (Intrinsics.areEqual(appSettingsWithoutQuery == null ? null : Boolean.valueOf(appSettingsWithoutQuery.smartLoginOptions.contains(SmartLoginOption.RequireConfirm)), Boolean.TRUE) && !this$0.isRetry) {
                                this$0.isRetry = true;
                                String string3 = this$0.getResources().getString(R.string.com_facebook_smart_login_confirmation_title);
                                Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.com_facebook_smart_login_confirmation_title)");
                                String string4 = this$0.getResources().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
                                Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.string.com_facebook_smart_login_confirmation_continue_as)");
                                String string5 = this$0.getResources().getString(R.string.com_facebook_smart_login_confirmation_cancel);
                                Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.string.com_facebook_smart_login_confirmation_cancel)");
                                String str2 = String.format(string4, Arrays.copyOf(new Object[]{string2}, 1));
                                AlertDialog.Builder builder = new AlertDialog.Builder(this$0.getContext());
                                builder.setMessage(string3).setCancelable(true).setNegativeButton(str2, new DialogInterface.OnClickListener() { // from class: com.facebook.login.DeviceAuthDialog$$ExternalSyntheticLambda5
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i3) {
                                        DeviceAuthDialog this$1 = this$0;
                                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                                        String userId = string;
                                        Intrinsics.checkNotNullParameter(userId, "$userId");
                                        zzbf permissions = zzbfVarAccess$handlePermissionResponse;
                                        Intrinsics.checkNotNullParameter(permissions, "$permissions");
                                        String accessToken = str;
                                        Intrinsics.checkNotNullParameter(accessToken, "$accessToken");
                                        this$1.completeLogin(userId, permissions, accessToken, date, date2);
                                    }
                                }).setPositiveButton(string5, new DialogInterface.OnClickListener() { // from class: com.facebook.login.DeviceAuthDialog$$ExternalSyntheticLambda6
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i3) {
                                        DeviceAuthDialog this$1 = this$0;
                                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                                        View viewInitializeContentView = this$1.initializeContentView(false);
                                        Dialog dialog = this$1.mDialog;
                                        if (dialog != null) {
                                            dialog.setContentView(viewInitializeContentView);
                                        }
                                        LoginClient.Request request = this$1.request;
                                        if (request == null) {
                                            return;
                                        }
                                        this$1.startLogin(request);
                                    }
                                });
                                builder.create().show();
                            } else {
                                this$0.completeLogin(string, zzbfVarAccess$handlePermissionResponse, str, date, date2);
                            }
                        } catch (JSONException e) {
                            this$0.onError(new FacebookException(e));
                        }
                    }
                    break;
                }
                break;
        }
    }
}
