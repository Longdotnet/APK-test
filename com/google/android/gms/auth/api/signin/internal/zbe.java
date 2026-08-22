package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.internal.p000authapi.zbbb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zbe extends GmsClient {
    public final GoogleSignInOptions zba;

    public zbe(Context context, Looper looper, ClientSettings clientSettings, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, clientSettings, connectionCallbacks, onConnectionFailedListener);
        GoogleSignInOptions.Builder builder = googleSignInOptions != null ? new GoogleSignInOptions.Builder(googleSignInOptions) : new GoogleSignInOptions.Builder();
        builder.zai = zbbb.zba();
        Set<Scope> set = clientSettings.zac;
        if (!set.isEmpty()) {
            for (Scope scope : set) {
                HashSet hashSet = builder.zaa;
                hashSet.add(scope);
                hashSet.addAll(Arrays.asList(new Scope[0]));
            }
        }
        Scope scope2 = GoogleSignInOptions.zae;
        HashSet hashSet2 = builder.zaa;
        if (hashSet2.contains(scope2)) {
            Scope scope3 = GoogleSignInOptions.zad;
            if (hashSet2.contains(scope3)) {
                hashSet2.remove(scope3);
            }
        }
        if (builder.zad && (builder.zaf == null || !hashSet2.isEmpty())) {
            builder.zaa.add(GoogleSignInOptions.zac);
        }
        this.zba = new GoogleSignInOptions(3, new ArrayList(hashSet2), builder.zaf, builder.zad, builder.zab, builder.zac, builder.zae, builder.zag, builder.zah, builder.zai);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zbs ? (zbs) iInterfaceQueryLocalInterface : new zbs(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final Intent getSignInIntent() {
        return zbm.zbc(getContext(), this.zba);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean providesSignIn() {
        return true;
    }
}
