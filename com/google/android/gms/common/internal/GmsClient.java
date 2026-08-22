package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class GmsClient extends BaseGmsClient implements Api.Client, zaj {
    private static volatile Executor zaa;
    private final ClientSettings zab;
    private final Set zac;
    private final Account zad;

    /* JADX WARN: Illegal instructions before constructor call */
    public GmsClient(Context context, Looper looper, int i, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzs gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        zzah.checkNotNull(connectionCallbacks);
        zzah.checkNotNull(onConnectionFailedListener);
        super(context, looper, gmsClientSupervisor, googleApiAvailability, i, new zah(connectionCallbacks), new zah(onConnectionFailedListener), clientSettings.zah);
        this.zab = clientSettings;
        this.zad = clientSettings.zaa;
        Set<Scope> set = clientSettings.zac;
        Set<Scope> setValidateScopes = validateScopes(set);
        Iterator<Scope> it = setValidateScopes.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.zac = setValidateScopes;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Account getAccount() {
        return this.zad;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public Executor getBindServiceExecutor() {
        return null;
    }

    public final ClientSettings getClientSettings() {
        return this.zab;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Set<Scope> getScopes() {
        return this.zac;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.emptySet();
    }

    public Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }
}
