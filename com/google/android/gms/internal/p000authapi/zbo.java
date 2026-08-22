package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.firebase.auth.zzz;

/* JADX INFO: loaded from: classes.dex */
public final class zbo extends GmsClient {
    private final Auth.AuthCredentialsOptions zba;

    public zbo(Context context, Looper looper, ClientSettings clientSettings, Auth.AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, clientSettings, connectionCallbacks, onConnectionFailedListener);
        authCredentialsOptions = authCredentialsOptions == null ? Auth.AuthCredentialsOptions.zba : authCredentialsOptions;
        zzz zzzVar = new zzz();
        zzzVar.zza = Boolean.FALSE;
        Auth.AuthCredentialsOptions authCredentialsOptions2 = Auth.AuthCredentialsOptions.zba;
        authCredentialsOptions.getClass();
        zzzVar.zza = Boolean.valueOf(authCredentialsOptions.zbc);
        zzzVar.zzb = authCredentialsOptions.zbd;
        zzzVar.zzb = zbbb.zba();
        this.zba = new Auth.AuthCredentialsOptions(zzzVar);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return iInterfaceQueryLocalInterface instanceof zbt ? (zbt) iInterfaceQueryLocalInterface : new zbt(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Auth.AuthCredentialsOptions authCredentialsOptions = this.zba;
        authCredentialsOptions.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", null);
        bundle.putBoolean("force_save_dialog", authCredentialsOptions.zbc);
        bundle.putString("log_session_id", authCredentialsOptions.zbd);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    public final Auth.AuthCredentialsOptions zba() {
        return this.zba;
    }
}
