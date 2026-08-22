package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.zzah;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zact extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final com.google.android.gms.signin.zaa zaa = com.google.android.gms.signin.zad.zac;
    public final Context zab;
    public final Handler zac;
    public final com.google.android.gms.signin.zaa zad;
    public final Set zae;
    public final ClientSettings zaf;
    public com.google.android.gms.signin.zae zag;
    public zacs zah;

    public zact(Context context, Handler handler, ClientSettings clientSettings) {
        this.zab = context;
        this.zac = handler;
        zzah.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.zaf = clientSettings;
        this.zae = clientSettings.zab;
        this.zad = zaa;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zag.zad(this);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zah.zae(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zah.zag(i);
    }

    @Override // com.google.android.gms.signin.internal.zae
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        this.zac.post(new zacr(this, zakVar));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    public final void zae(zacs zacsVar) {
        com.google.android.gms.signin.zae zaeVar = this.zag;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
        Integer numValueOf = Integer.valueOf(System.identityHashCode(this));
        ClientSettings clientSettings = this.zaf;
        clientSettings.zaj = numValueOf;
        Handler handler = this.zac;
        Looper looper = handler.getLooper();
        this.zag = this.zad.buildClient(this.zab, looper, clientSettings, (Object) clientSettings.zai, (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
        this.zah = zacsVar;
        Set set = this.zae;
        if (set == null || set.isEmpty()) {
            handler.post(new zacq(this));
        } else {
            this.zag.zab();
        }
    }

    public final void zaf() {
        com.google.android.gms.signin.zae zaeVar = this.zag;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
    }
}
