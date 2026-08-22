package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public final class SignInClientImpl extends GmsClient implements com.google.android.gms.signin.zae {
    public final boolean zab;
    public final ClientSettings zac;
    public final Bundle zad;
    public final Integer zae;

    public SignInClientImpl(Context context, Looper looper, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zab = true;
        this.zac = clientSettings;
        this.zad = bundle;
        this.zae = clientSettings.zaj;
    }

    public static Bundle createBundleFromClientSettings(ClientSettings clientSettings) {
        clientSettings.getClass();
        Integer num = clientSettings.zaj;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.zaa);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zaf ? (zaf) iInterfaceQueryLocalInterface : new zaf(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        ClientSettings clientSettings = this.zac;
        boolean zEquals = getContext().getPackageName().equals(clientSettings.zag);
        Bundle bundle = this.zad;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", clientSettings.zag);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return this.zab;
    }

    @Override // com.google.android.gms.signin.zae
    public final void zaa$1() {
        try {
            zaf zafVar = (zaf) getService();
            Integer num = this.zae;
            zzah.checkNotNull(num);
            int iIntValue = num.intValue();
            Parcel parcelZaa = zafVar.zaa();
            parcelZaa.writeInt(iIntValue);
            zafVar.zac(7, parcelZaa);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.signin.zae
    public final void zab() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
    }

    @Override // com.google.android.gms.signin.zae
    public final void zac(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            zaf zafVar = (zaf) getService();
            Integer num = this.zae;
            zzah.checkNotNull(num);
            int iIntValue = num.intValue();
            Parcel parcelZaa = zafVar.zaa();
            com.google.android.gms.internal.base.zac.zad(parcelZaa, iAccountAccessor);
            parcelZaa.writeInt(iIntValue);
            parcelZaa.writeInt(z ? 1 : 0);
            zafVar.zac(9, parcelZaa);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.signin.zae
    public final void zad(zac zacVar) {
        try {
            Account account = this.zac.zaa;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            GoogleSignInAccount savedDefaultGoogleSignInAccount = "<<default account>>".equals(account.name) ? Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount() : null;
            Integer num = this.zae;
            zzah.checkNotNull(num);
            zat zatVar = new zat(2, account, num.intValue(), savedDefaultGoogleSignInAccount);
            zaf zafVar = (zaf) getService();
            zai zaiVar = new zai(1, zatVar);
            Parcel parcelZaa = zafVar.zaa();
            com.google.android.gms.internal.base.zac.zac(parcelZaa, zaiVar);
            com.google.android.gms.internal.base.zac.zad(parcelZaa, zacVar);
            zafVar.zac(12, parcelZaa);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zacVar.zab(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }
}
