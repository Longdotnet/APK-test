package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.identity.zbn;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import kotlin.io.TextStreamsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zbay extends GoogleApi implements SignInClient {
    private static final Api.ClientKey zba;
    private static final Api.AbstractClientBuilder zbb;
    private static final Api zbc;
    private final String zbd;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        zbat zbatVar = new zbat();
        zbb = zbatVar;
        zbc = new Api("Auth.Api.Identity.SignIn.API", zbatVar, clientKey);
    }

    public zbay(Activity activity, zbn zbnVar) {
        super(activity, (Api<zbn>) zbc, zbnVar, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zbd = zbbb.zba();
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final Task beginSignIn(BeginSignInRequest beginSignInRequest) {
        zzah.checkNotNull(beginSignInRequest);
        BeginSignInRequest.GoogleIdTokenRequestOptions googleIdTokenRequestOptions = beginSignInRequest.zbb;
        zzah.checkNotNull(googleIdTokenRequestOptions);
        BeginSignInRequest.PasswordRequestOptions passwordRequestOptions = beginSignInRequest.zba;
        zzah.checkNotNull(passwordRequestOptions);
        String str = beginSignInRequest.zbc;
        final BeginSignInRequest beginSignInRequest2 = new BeginSignInRequest(passwordRequestOptions, googleIdTokenRequestOptions, this.zbd, beginSignInRequest.zbd, beginSignInRequest.zbe);
        return doRead(TaskApiCall.builder().setFeatures(zbba.zba).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbaq
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zbay zbayVar = this.zba;
                BeginSignInRequest beginSignInRequest3 = beginSignInRequest2;
                zbau zbauVar = new zbau(zbayVar, (TaskCompletionSource) obj2);
                zbai zbaiVar = (zbai) ((zbaz) obj).getService();
                zzah.checkNotNull(beginSignInRequest3);
                zbaiVar.zbc(zbauVar, beginSignInRequest3);
            }
        }).setAutoResolveMissingFeatures(false).setMethodKey(1553).build());
    }

    public final String getPhoneNumberFromIntent(Intent intent) throws ApiException {
        if (intent == null) {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
        Parcelable.Creator<Status> creator = Status.CREATOR;
        byte[] byteArrayExtra = intent.getByteArrayExtra("status");
        Status status = (Status) (byteArrayExtra == null ? null : TextStreamsKt.deserializeFromBytes(byteArrayExtra, creator));
        if (status == null) {
            throw new ApiException(Status.RESULT_CANCELED);
        }
        if (!status.isSuccess()) {
            throw new ApiException(status);
        }
        String stringExtra = intent.getStringExtra("phone_number_hint_result");
        if (stringExtra != null) {
            return stringExtra;
        }
        throw new ApiException(Status.RESULT_INTERNAL_ERROR);
    }

    public final Task getPhoneNumberHintIntent(final GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest) {
        return doRead(TaskApiCall.builder().setFeatures(zbba.zbh).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbar
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.zba.zba(getPhoneNumberHintIntentRequest, (zbaz) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(1653).build());
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final SignInCredential getSignInCredentialFromIntent(Intent intent) throws ApiException {
        if (intent == null) {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
        Parcelable.Creator<Status> creator = Status.CREATOR;
        byte[] byteArrayExtra = intent.getByteArrayExtra("status");
        Status status = (Status) (byteArrayExtra == null ? null : TextStreamsKt.deserializeFromBytes(byteArrayExtra, creator));
        if (status == null) {
            throw new ApiException(Status.RESULT_CANCELED);
        }
        if (!status.isSuccess()) {
            throw new ApiException(status);
        }
        Parcelable.Creator<SignInCredential> creator2 = SignInCredential.CREATOR;
        byte[] byteArrayExtra2 = intent.getByteArrayExtra("sign_in_credential");
        SignInCredential signInCredential = (SignInCredential) (byteArrayExtra2 != null ? TextStreamsKt.deserializeFromBytes(byteArrayExtra2, creator2) : null);
        if (signInCredential != null) {
            return signInCredential;
        }
        throw new ApiException(Status.RESULT_INTERNAL_ERROR);
    }

    public final Task getSignInIntent(GetSignInIntentRequest getSignInIntentRequest) {
        zzah.checkNotNull(getSignInIntentRequest);
        String str = getSignInIntentRequest.zba;
        zzah.checkNotNull(str);
        final GetSignInIntentRequest getSignInIntentRequest2 = new GetSignInIntentRequest(str, getSignInIntentRequest.zbb, this.zbd, getSignInIntentRequest.zbd, getSignInIntentRequest.zbe, getSignInIntentRequest.zbf);
        return doRead(TaskApiCall.builder().setFeatures(zbba.zbf).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbas
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zbay zbayVar = this.zba;
                GetSignInIntentRequest getSignInIntentRequest3 = getSignInIntentRequest2;
                zbaw zbawVar = new zbaw(zbayVar, (TaskCompletionSource) obj2);
                zbai zbaiVar = (zbai) ((zbaz) obj).getService();
                zzah.checkNotNull(getSignInIntentRequest3);
                zbaiVar.zbe(zbawVar, getSignInIntentRequest3);
            }
        }).setMethodKey(1555).build());
    }

    public final Task signOut() {
        getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
        Iterator<GoogleApiClient> it = GoogleApiClient.getAllClients().iterator();
        while (it.hasNext()) {
            it.next().maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
        return doRead(TaskApiCall.builder().setFeatures(zbba.zbb).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbap
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.zba.zbb((zbaz) obj, (TaskCompletionSource) obj2);
            }
        }).setAutoResolveMissingFeatures(false).setMethodKey(1554).build());
    }

    public final /* synthetic */ void zba(GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest, zbaz zbazVar, TaskCompletionSource taskCompletionSource) {
        ((zbai) zbazVar.getService()).zbd(new zbax(this, taskCompletionSource), getPhoneNumberHintIntentRequest, this.zbd);
    }

    public final /* synthetic */ void zbb(zbaz zbazVar, TaskCompletionSource taskCompletionSource) {
        ((zbai) zbazVar.getService()).zbf(new zbav(this, taskCompletionSource), this.zbd);
    }

    public zbay(Context context, zbn zbnVar) {
        super(context, (Api<zbn>) zbc, zbnVar, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zbd = zbbb.zba();
    }
}
