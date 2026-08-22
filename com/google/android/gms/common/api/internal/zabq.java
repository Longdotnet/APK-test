package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zabq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zau {
    public final /* synthetic */ GoogleApiManager zaa;
    public final Api.Client zac;
    public final ApiKey zad;
    public final zaad zae;
    public final int zah;
    public final zact zai;
    public boolean zaj;
    public final LinkedList zab = new LinkedList();
    public final HashSet zaf = new HashSet();
    public final HashMap zag = new HashMap();
    public final ArrayList zak = new ArrayList();
    public ConnectionResult zal = null;
    public int zam = 0;

    public zabq(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        this.zaa = googleApiManager;
        Api.Client clientZab = googleApi.zab(googleApiManager.zar.getLooper(), this);
        this.zac = clientZab;
        this.zad = googleApi.getApiKey();
        this.zae = new zaad();
        this.zah = googleApi.zaa();
        if (!clientZab.requiresSignIn()) {
            this.zai = null;
        } else {
            this.zai = googleApi.zac(googleApiManager.zai, googleApiManager.zar);
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Looper looperMyLooper = Looper.myLooper();
        GoogleApiManager googleApiManager = this.zaa;
        if (looperMyLooper == googleApiManager.zar.getLooper()) {
            zaH();
        } else {
            googleApiManager.zar.post(new zabm(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zar(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Looper looperMyLooper = Looper.myLooper();
        GoogleApiManager googleApiManager = this.zaa;
        if (looperMyLooper == googleApiManager.zar.getLooper()) {
            zaI(i);
        } else {
            googleApiManager.zar.post(new zabn(this, i));
        }
    }

    public final boolean zaA() {
        return this.zac.requiresSignIn();
    }

    @ResultIgnorabilityUnspecified
    public final boolean zaB() {
        return zaO(true);
    }

    public final Feature zaC(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] availableFeatures = this.zac.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.zza, Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l = (Long) arrayMap.getOrDefault(feature2.zza, null);
                if (l == null || l.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    public final void zaD(ConnectionResult connectionResult) {
        HashSet hashSet = this.zaf;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((zal) it.next()).zac(this.zad, connectionResult, zzah.equal(connectionResult, ConnectionResult.RESULT_SUCCESS) ? this.zac.getEndpointPackageName() : null);
        }
        hashSet.clear();
    }

    public final void zaE(Status status) {
        zzah.checkHandlerThread(this.zaa.zar);
        zaF(status, null, false);
    }

    public final void zaF(Status status, Exception exc, boolean z) {
        zzah.checkHandlerThread(this.zaa.zar);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.zab.iterator();
        while (it.hasNext()) {
            zai zaiVar = (zai) it.next();
            if (!z || zaiVar.zac == 2) {
                if (status != null) {
                    zaiVar.zad(status);
                } else {
                    zaiVar.zae(exc);
                }
                it.remove();
            }
        }
    }

    public final void zaG() {
        LinkedList linkedList = this.zab;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zai zaiVar = (zai) arrayList.get(i);
            if (!this.zac.isConnected()) {
                return;
            }
            if (zaM(zaiVar)) {
                linkedList.remove(zaiVar);
            }
        }
    }

    public final void zaH() {
        Api.Client client = this.zac;
        zan();
        zaD(ConnectionResult.RESULT_SUCCESS);
        if (this.zaj) {
            GoogleApiManager googleApiManager = this.zaa;
            com.google.android.gms.internal.base.zau zauVar = googleApiManager.zar;
            ApiKey apiKey = this.zad;
            zauVar.removeMessages(11, apiKey);
            googleApiManager.zar.removeMessages(9, apiKey);
            this.zaj = false;
        }
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            zaci zaciVar = (zaci) it.next();
            if (zaC(zaciVar.zaa.getRequiredFeatures()) != null) {
                it.remove();
            } else {
                try {
                    zaciVar.zaa.registerListener(client, new TaskCompletionSource());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    client.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        zaG();
        zaJ();
    }

    public final void zaI(int i) {
        zan();
        this.zaj = true;
        String lastDisconnectMessage = this.zac.getLastDisconnectMessage();
        zaad zaadVar = this.zae;
        zaadVar.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (lastDisconnectMessage != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(lastDisconnectMessage);
        }
        zaadVar.zah(new Status(20, sb.toString()), true);
        GoogleApiManager googleApiManager = this.zaa;
        com.google.android.gms.internal.base.zau zauVar = googleApiManager.zar;
        ApiKey apiKey = this.zad;
        zauVar.sendMessageDelayed(Message.obtain(zauVar, 9, apiKey), 5000L);
        com.google.android.gms.internal.base.zau zauVar2 = googleApiManager.zar;
        zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 11, apiKey), 120000L);
        googleApiManager.zak.zaa.clear();
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            ((zaci) it.next()).zac.run();
        }
    }

    public final void zaJ() {
        GoogleApiManager googleApiManager = this.zaa;
        com.google.android.gms.internal.base.zau zauVar = googleApiManager.zar;
        ApiKey apiKey = this.zad;
        zauVar.removeMessages(12, apiKey);
        com.google.android.gms.internal.base.zau zauVar2 = googleApiManager.zar;
        zauVar2.sendMessageDelayed(zauVar2.obtainMessage(12, apiKey), googleApiManager.zae);
    }

    public final boolean zaM(zai zaiVar) {
        if (!(zaiVar instanceof zac)) {
            zaiVar.zag(this.zae, zaA());
            try {
                zaiVar.zaf(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature featureZaC = zaC(zacVar.zab(this));
        if (featureZaC == null) {
            zaiVar.zag(this.zae, zaA());
            try {
                zaiVar.zaf(this);
            } catch (DeadObjectException unused2) {
                onConnectionSuspended(1);
                this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Log.w("GoogleApiManager", this.zac.getClass().getName() + " could not execute call because it requires feature (" + featureZaC.zza + ", " + featureZaC.getVersion() + ").");
        if (!this.zaa.zas || !zacVar.zaa(this)) {
            zacVar.zae(new UnsupportedApiCallException(featureZaC));
            return true;
        }
        zabs zabsVar = new zabs(this.zad, featureZaC);
        int iIndexOf = this.zak.indexOf(zabsVar);
        if (iIndexOf >= 0) {
            zabs zabsVar2 = (zabs) this.zak.get(iIndexOf);
            this.zaa.zar.removeMessages(15, zabsVar2);
            com.google.android.gms.internal.base.zau zauVar = this.zaa.zar;
            zauVar.sendMessageDelayed(Message.obtain(zauVar, 15, zabsVar2), 5000L);
            return false;
        }
        this.zak.add(zabsVar);
        com.google.android.gms.internal.base.zau zauVar2 = this.zaa.zar;
        zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 15, zabsVar), 5000L);
        com.google.android.gms.internal.base.zau zauVar3 = this.zaa.zar;
        zauVar3.sendMessageDelayed(Message.obtain(zauVar3, 16, zabsVar), 120000L);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (zaN(connectionResult)) {
            return false;
        }
        this.zaa.zaE(connectionResult, this.zah);
        return false;
    }

    public final boolean zaN(ConnectionResult connectionResult) {
        synchronized (GoogleApiManager.zac) {
            try {
                GoogleApiManager googleApiManager = this.zaa;
                if (googleApiManager.zao == null || !googleApiManager.zap.contains(this.zad)) {
                    return false;
                }
                this.zaa.zao.zah(connectionResult, this.zah);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zaO(boolean z) {
        zzah.checkHandlerThread(this.zaa.zar);
        Api.Client client = this.zac;
        if (!client.isConnected() || !this.zag.isEmpty()) {
            return false;
        }
        zaad zaadVar = this.zae;
        if (zaadVar.zaa.isEmpty() && zaadVar.zab.isEmpty()) {
            client.disconnect("Timing out service connection.");
            return true;
        }
        if (!z) {
            return false;
        }
        zaJ();
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void zaa(ConnectionResult connectionResult, Api api, boolean z) {
        throw null;
    }

    public final int zab() {
        return this.zah;
    }

    public final ConnectionResult zad() {
        zzah.checkHandlerThread(this.zaa.zar);
        return this.zal;
    }

    public final Api.Client zaf() {
        return this.zac;
    }

    public final Map zah() {
        return this.zag;
    }

    public final void zan() {
        zzah.checkHandlerThread(this.zaa.zar);
        this.zal = null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zao() {
        GoogleApiManager googleApiManager = this.zaa;
        zzah.checkHandlerThread(googleApiManager.zar);
        Api.Client client = this.zac;
        if (client.isConnected() || client.isConnecting()) {
            return;
        }
        try {
            int iZab = googleApiManager.zak.zab(googleApiManager.zai, client);
            if (iZab != 0) {
                ConnectionResult connectionResult = new ConnectionResult(iZab, null);
                Log.w("GoogleApiManager", "The service for " + client.getClass().getName() + " is not available: " + connectionResult.toString());
                zar(connectionResult, null);
                return;
            }
            zabu zabuVar = new zabu(googleApiManager, client, this.zad);
            if (client.requiresSignIn()) {
                zact zactVar = this.zai;
                zzah.checkNotNull(zactVar);
                zactVar.zae(zabuVar);
            }
            try {
                client.connect(zabuVar);
            } catch (SecurityException e) {
                zar(new ConnectionResult(10), e);
            }
        } catch (IllegalStateException e2) {
            zar(new ConnectionResult(10), e2);
        }
    }

    public final void zap(zai zaiVar) {
        zzah.checkHandlerThread(this.zaa.zar);
        boolean zIsConnected = this.zac.isConnected();
        LinkedList linkedList = this.zab;
        if (zIsConnected) {
            if (zaM(zaiVar)) {
                zaJ();
                return;
            } else {
                linkedList.add(zaiVar);
                return;
            }
        }
        linkedList.add(zaiVar);
        ConnectionResult connectionResult = this.zal;
        if (connectionResult == null || !connectionResult.hasResolution()) {
            zao();
        } else {
            zar(this.zal, null);
        }
    }

    public final void zar(ConnectionResult connectionResult, Exception exc) {
        zzah.checkHandlerThread(this.zaa.zar);
        zact zactVar = this.zai;
        if (zactVar != null) {
            zactVar.zaf();
        }
        zan();
        this.zaa.zak.zaa.clear();
        zaD(connectionResult);
        if ((this.zac instanceof com.google.android.gms.common.internal.service.zap) && connectionResult.zzb != 24) {
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zaf = true;
            com.google.android.gms.internal.base.zau zauVar = googleApiManager.zar;
            zauVar.sendMessageDelayed(zauVar.obtainMessage(19), 300000L);
        }
        if (connectionResult.zzb == 4) {
            zaE(GoogleApiManager.zab);
            return;
        }
        if (this.zab.isEmpty()) {
            this.zal = connectionResult;
            return;
        }
        if (exc != null) {
            zzah.checkHandlerThread(this.zaa.zar);
            zaF(null, exc, false);
            return;
        }
        if (!this.zaa.zas) {
            zaE(GoogleApiManager.zaF(this.zad, connectionResult));
            return;
        }
        zaF(GoogleApiManager.zaF(this.zad, connectionResult), null, true);
        if (this.zab.isEmpty() || zaN(connectionResult) || this.zaa.zaE(connectionResult, this.zah)) {
            return;
        }
        if (connectionResult.zzb == 18) {
            this.zaj = true;
        }
        if (!this.zaj) {
            zaE(GoogleApiManager.zaF(this.zad, connectionResult));
            return;
        }
        GoogleApiManager googleApiManager2 = this.zaa;
        ApiKey apiKey = this.zad;
        com.google.android.gms.internal.base.zau zauVar2 = googleApiManager2.zar;
        zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 9, apiKey), 5000L);
    }

    public final void zas(ConnectionResult connectionResult) {
        zzah.checkHandlerThread(this.zaa.zar);
        Api.Client client = this.zac;
        client.disconnect("onSignInFailed for " + client.getClass().getName() + " with " + String.valueOf(connectionResult));
        zar(connectionResult, null);
    }

    public final void zat(zal zalVar) {
        zzah.checkHandlerThread(this.zaa.zar);
        this.zaf.add(zalVar);
    }

    public final void zau() {
        zzah.checkHandlerThread(this.zaa.zar);
        if (this.zaj) {
            zao();
        }
    }

    public final void zav() {
        zzah.checkHandlerThread(this.zaa.zar);
        zaE(GoogleApiManager.zaa);
        this.zae.zaf();
        for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            zap(new zah(listenerKey, new TaskCompletionSource()));
        }
        zaD(new ConnectionResult(4));
        Api.Client client = this.zac;
        if (client.isConnected()) {
            client.onUserSignOut(new zabp(this));
        }
    }

    public final void zaw() {
        GoogleApiManager googleApiManager = this.zaa;
        zzah.checkHandlerThread(googleApiManager.zar);
        boolean z = this.zaj;
        if (z) {
            if (z) {
                com.google.android.gms.internal.base.zau zauVar = googleApiManager.zar;
                ApiKey apiKey = this.zad;
                zauVar.removeMessages(11, apiKey);
                googleApiManager.zar.removeMessages(9, apiKey);
                this.zaj = false;
            }
            zaE(googleApiManager.zaj.isGooglePlayServicesAvailable(googleApiManager.zai, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.zac.disconnect("Timing out connection while resuming.");
        }
    }
}
