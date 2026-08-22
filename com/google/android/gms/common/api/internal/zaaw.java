package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class zaaw implements zabf {
    public final zabi zaa;
    public final Lock zab;
    public final Context zac;
    public final GoogleApiAvailabilityLight zad;
    public ConnectionResult zae;
    public int zaf;
    public int zah;
    public com.google.android.gms.signin.zae zak;
    public boolean zal;
    public boolean zam;
    public boolean zan;
    public IAccountAccessor zao;
    public boolean zap;
    public boolean zaq;
    public final ClientSettings zar;
    public final Map zas;
    public final Api.AbstractClientBuilder zat;
    public int zag = 0;
    public final Bundle zai = new Bundle();
    public final HashSet zaj = new HashSet();
    public final ArrayList zau = new ArrayList();

    public zaaw(zabi zabiVar, ClientSettings clientSettings, Map map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder abstractClientBuilder, Lock lock, Context context) {
        this.zaa = zabiVar;
        this.zar = clientSettings;
        this.zas = map;
        this.zad = googleApiAvailabilityLight;
        this.zat = abstractClientBuilder;
        this.zab = lock;
        this.zac = context;
    }

    public final void zaA() {
        this.zam = false;
        zabi zabiVar = this.zaa;
        zabiVar.zag.zad = Collections.emptySet();
        for (Api.AnyClientKey anyClientKey : this.zaj) {
            HashMap map = zabiVar.zab;
            if (!map.containsKey(anyClientKey)) {
                map.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    public final void zaB(boolean z) {
        com.google.android.gms.signin.zae zaeVar = this.zak;
        if (zaeVar != null) {
            if (zaeVar.isConnected() && z) {
                zaeVar.zaa$1();
            }
            zaeVar.disconnect();
            zzah.checkNotNull(this.zar);
            this.zao = null;
        }
    }

    public final void zaC() {
        zabi zabiVar = this.zaa;
        zabiVar.zai.lock();
        try {
            zabiVar.zag.zak();
            zabiVar.zan = new zaaj(zabiVar);
            zabiVar.zan.zad();
            zabiVar.zaj.signalAll();
            zabiVar.zai.unlock();
            zabj.zaa().execute(new zaak(this));
            com.google.android.gms.signin.zae zaeVar = this.zak;
            if (zaeVar != null) {
                if (this.zap) {
                    IAccountAccessor iAccountAccessor = this.zao;
                    zzah.checkNotNull(iAccountAccessor);
                    zaeVar.zac(iAccountAccessor, this.zaq);
                }
                zaB(false);
            }
            Iterator it = this.zaa.zab.keySet().iterator();
            while (it.hasNext()) {
                Api.Client client = (Api.Client) this.zaa.zaa.get((Api.AnyClientKey) it.next());
                zzah.checkNotNull(client);
                client.disconnect();
            }
            this.zaa.zah.zab(this.zai.isEmpty() ? null : this.zai);
        } catch (Throwable th) {
            zabiVar.zai.unlock();
            throw th;
        }
    }

    public final void zaD(ConnectionResult connectionResult) {
        ArrayList arrayList = this.zau;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Future) arrayList.get(i)).cancel(true);
        }
        arrayList.clear();
        zaB(!connectionResult.hasResolution());
        zabi zabiVar = this.zaa;
        zabiVar.zak(connectionResult);
        zabiVar.zah.zaa(connectionResult);
    }

    public final void zaE(ConnectionResult connectionResult, Api api, boolean z) {
        int priority = api.zac().getPriority();
        if ((!z || connectionResult.hasResolution() || this.zad.getErrorResolutionIntent(null, null, connectionResult.zzb) != null) && (this.zae == null || priority < this.zaf)) {
            this.zae = connectionResult;
            this.zaf = priority;
        }
        this.zaa.zab.put(api.zab(), connectionResult);
    }

    public final void zaF() {
        if (this.zah != 0) {
            return;
        }
        if (!this.zam || this.zan) {
            ArrayList arrayList = new ArrayList();
            this.zag = 1;
            zabi zabiVar = this.zaa;
            this.zah = zabiVar.zaa.size();
            Map map = zabiVar.zaa;
            for (Api.AnyClientKey anyClientKey : map.keySet()) {
                if (!zabiVar.zab.containsKey(anyClientKey)) {
                    arrayList.add((Api.Client) map.get(anyClientKey));
                } else if (zaH()) {
                    zaC();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.zau.add(zabj.zaa().submit(new zaap(this, arrayList)));
        }
    }

    public final boolean zaG(int i) {
        if (this.zag == i) {
            return true;
        }
        Log.w("GACConnecting", this.zaa.zag.zaf());
        Log.w("GACConnecting", "Unexpected callback in ".concat(toString()));
        Log.w("GACConnecting", "mRemainingConnections=" + this.zah);
        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("GoogleApiClient connecting is in step ", this.zag != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN", " but received callback for step ");
        sbM21m.append(i != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN");
        Log.e("GACConnecting", sbM21m.toString(), new Exception());
        zaD(new ConnectionResult(8, null));
        return false;
    }

    public final boolean zaH() {
        int i = this.zah - 1;
        this.zah = i;
        if (i > 0) {
            return false;
        }
        zabi zabiVar = this.zaa;
        if (i < 0) {
            Log.w("GACConnecting", zabiVar.zag.zaf());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zaD(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.zae;
        if (connectionResult == null) {
            return true;
        }
        zabiVar.zaf = this.zaf;
        zaD(connectionResult);
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.zaa.zag.zaa.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zad() {
        Map map;
        zabi zabiVar = this.zaa;
        zabiVar.zab.clear();
        this.zam = false;
        this.zae = null;
        this.zag = 0;
        this.zal = true;
        this.zan = false;
        this.zap = false;
        HashMap map2 = new HashMap();
        Map map3 = this.zas;
        Iterator it = map3.keySet().iterator();
        boolean z = false;
        while (true) {
            boolean zHasNext = it.hasNext();
            map = zabiVar.zaa;
            if (!zHasNext) {
                break;
            }
            Api api = (Api) it.next();
            Api.Client client = (Api.Client) map.get(api.zab());
            zzah.checkNotNull(client);
            Api.Client client2 = client;
            z |= api.zac().getPriority() == 1;
            boolean zBooleanValue = ((Boolean) map3.get(api)).booleanValue();
            if (client2.requiresSignIn()) {
                this.zam = true;
                if (zBooleanValue) {
                    this.zaj.add(api.zab());
                } else {
                    this.zal = false;
                }
            }
            map2.put(client2, new zaal(this, api, zBooleanValue));
        }
        if (z) {
            this.zam = false;
        }
        if (this.zam) {
            ClientSettings clientSettings = this.zar;
            zzah.checkNotNull(clientSettings);
            zzah.checkNotNull(this.zat);
            zabe zabeVar = zabiVar.zag;
            clientSettings.zaj = Integer.valueOf(System.identityHashCode(zabeVar));
            zaat zaatVar = new zaat(this);
            this.zak = this.zat.buildClient(this.zac, zabeVar.getLooper(), clientSettings, clientSettings.zai, (GoogleApiClient.ConnectionCallbacks) zaatVar, (GoogleApiClient.OnConnectionFailedListener) zaatVar);
        }
        this.zah = map.size();
        this.zau.add(zabj.zaa().submit(new zaao(this, map2)));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zae() {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zag(Bundle bundle) {
        if (zaG(1)) {
            if (bundle != null) {
                this.zai.putAll(bundle);
            }
            if (zaH()) {
                zaC();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zah(ConnectionResult connectionResult, Api api, boolean z) {
        if (zaG(1)) {
            zaE(connectionResult, api, z);
            if (zaH()) {
                zaC();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zai(int i) {
        zaD(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean zaj() {
        ArrayList arrayList = this.zau;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Future) arrayList.get(i)).cancel(true);
        }
        arrayList.clear();
        zaB(true);
        this.zaa.zak(null);
        return true;
    }
}
