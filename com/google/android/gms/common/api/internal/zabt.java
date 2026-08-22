package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.IAccountAccessor;

/* JADX INFO: loaded from: classes.dex */
final class zabt implements Runnable {
    public final /* synthetic */ ConnectionResult zaa;
    public final /* synthetic */ zabu zab;

    public zabt(zabu zabuVar, ConnectionResult connectionResult) {
        this.zab = zabuVar;
        this.zaa = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAccountAccessor iAccountAccessor;
        zabu zabuVar = this.zab;
        zabq zabqVar = (zabq) zabuVar.zaa.zan.get(zabuVar.zac);
        if (zabqVar == null) {
            return;
        }
        ConnectionResult connectionResult = this.zaa;
        if (!connectionResult.isSuccess()) {
            zabqVar.zar(connectionResult, null);
            return;
        }
        zabuVar.zaf = true;
        Api.Client client = zabuVar.zab;
        if (client.requiresSignIn()) {
            if (!zabuVar.zaf || (iAccountAccessor = zabuVar.zad) == null) {
                return;
            }
            client.getRemoteService(iAccountAccessor, zabuVar.zae);
            return;
        }
        try {
            client.getRemoteService(null, client.getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            client.disconnect("Failed to get service from broker.");
            zabqVar.zar(new ConnectionResult(10), null);
        }
    }
}
