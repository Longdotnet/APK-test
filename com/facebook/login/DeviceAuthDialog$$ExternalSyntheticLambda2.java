package com.facebook.login;

import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.onZL.mnwSv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DeviceAuthDialog$$ExternalSyntheticLambda2 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DeviceAuthDialog f$0;

    public /* synthetic */ DeviceAuthDialog$$ExternalSyntheticLambda2(DeviceAuthDialog deviceAuthDialog, int i) {
        this.$r8$classId = i;
        this.f$0 = deviceAuthDialog;
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        switch (this.$r8$classId) {
            case 0:
                DeviceAuthDialog this$0 = this.f$0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (!this$0.completed.get()) {
                    FacebookRequestError facebookRequestError = graphResponse.error;
                    if (facebookRequestError != null) {
                        int i = facebookRequestError.subErrorCode;
                        if (i == 1349174 || i == 1349172) {
                            this$0.schedulePoll();
                        } else if (i == 1349152) {
                            DeviceAuthDialog.RequestState requestState = this$0.currentRequestState;
                            if (requestState != null) {
                                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.userCode);
                            }
                            LoginClient.Request request = this$0.request;
                            if (request == null) {
                                this$0.onCancel();
                            } else {
                                this$0.startLogin(request);
                            }
                        } else if (i != 1349173) {
                            FacebookException facebookException = facebookRequestError.exception;
                            if (facebookException == null) {
                                facebookException = new FacebookException();
                            }
                            this$0.onError(facebookException);
                        } else {
                            this$0.onCancel();
                        }
                    } else {
                        try {
                            JSONObject jSONObject = graphResponse.graphObject;
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            String string = jSONObject.getString("access_token");
                            Intrinsics.checkNotNullExpressionValue(string, mnwSv.ZnoR);
                            this$0.onSuccess(string, jSONObject.getLong("expires_in"), Long.valueOf(jSONObject.optLong("data_access_expiration_time")));
                        } catch (JSONException e) {
                            this$0.onError(new FacebookException(e));
                            return;
                        }
                    }
                    break;
                }
                break;
            default:
                DeviceAuthDialog this$1 = this.f$0;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                if (!this$1.isBeingDestroyed) {
                    FacebookRequestError facebookRequestError2 = graphResponse.error;
                    if (facebookRequestError2 != null) {
                        FacebookException facebookException2 = facebookRequestError2.exception;
                        if (facebookException2 == null) {
                            facebookException2 = new FacebookException();
                        }
                        this$1.onError(facebookException2);
                    } else {
                        JSONObject jSONObject2 = graphResponse.graphObject;
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        DeviceAuthDialog.RequestState requestState2 = new DeviceAuthDialog.RequestState();
                        try {
                            String string2 = jSONObject2.getString("user_code");
                            requestState2.userCode = string2;
                            requestState2.authorizationUri = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", Arrays.copyOf(new Object[]{string2}, 1));
                            requestState2.requestCode = jSONObject2.getString("code");
                            requestState2.interval = jSONObject2.getLong("interval");
                            this$1.setCurrentRequestState(requestState2);
                        } catch (JSONException e2) {
                            this$1.onError(new FacebookException(e2));
                        }
                    }
                    break;
                }
                break;
        }
    }
}
