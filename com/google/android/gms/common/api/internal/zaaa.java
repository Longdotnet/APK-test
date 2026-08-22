package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections$KeySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes2.dex */
final class zaaa implements zaca {
    public final Context zaa;
    public final zabe zab;
    public final Looper zac;
    public final zabi zad;
    public final zabi zae;
    public final Map zaf;
    public final Api.Client zah;
    public Bundle zai;
    public final Lock zam;
    public final Set zag = Collections.newSetFromMap(new WeakHashMap());
    public ConnectionResult zaj = null;
    public ConnectionResult zak = null;
    public boolean zal = false;
    public int zan = 0;

    public zaaa(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, ArrayMap arrayMap, ArrayMap arrayMap2, ClientSettings clientSettings, Api.AbstractClientBuilder abstractClientBuilder, Api.Client client, ArrayList arrayList, ArrayList arrayList2, ArrayMap arrayMap3, ArrayMap arrayMap4) {
        this.zaa = context;
        this.zab = zabeVar;
        this.zam = lock;
        this.zac = looper;
        this.zah = client;
        this.zad = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, arrayMap2, null, arrayMap4, null, arrayList2, new zax(this));
        this.zae = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, arrayMap, clientSettings, arrayMap3, abstractClientBuilder, arrayList, new zaz(this));
        ArrayMap arrayMap5 = new ArrayMap();
        Iterator it = ((MapCollections$KeySet) arrayMap2.keySet()).iterator();
        while (it.hasNext()) {
            arrayMap5.put((Api.AnyClientKey) it.next(), this.zad);
        }
        Iterator it2 = ((MapCollections$KeySet) arrayMap.keySet()).iterator();
        while (it2.hasNext()) {
            arrayMap5.put((Api.AnyClientKey) it2.next(), this.zae);
        }
        this.zaf = Collections.unmodifiableMap(arrayMap5);
    }

    public static zaaa zag(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, ClientSettings clientSettings, Map map2, Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry entry : map.entrySet()) {
            Api.Client client2 = (Api.Client) entry.getValue();
            if (true == client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) entry.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) entry.getKey(), client2);
            }
        }
        zzah.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            Api.AnyClientKey anyClientKeyZab = api.zab();
            if (arrayMap.containsKey(anyClientKeyZab)) {
                arrayMap3.put(api, (Boolean) map2.get(api));
            } else {
                if (!arrayMap2.containsKey(anyClientKeyZab)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                arrayMap4.put(api, (Boolean) map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zat zatVar = (zat) arrayList.get(i);
            if (arrayMap3.containsKey(zatVar.zaa)) {
                arrayList2.add(zatVar);
            } else {
                if (!arrayMap4.containsKey(zatVar.zaa)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(zatVar);
            }
        }
        return new zaaa(context, zabeVar, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    public final void zaA(ConnectionResult connectionResult) {
        int i = this.zan;
        if (i == 1) {
            zaB();
        } else if (i != 2) {
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        } else {
            this.zab.zaa(connectionResult);
            zaB();
        }
        this.zan = 0;
    }

    public final void zaB() {
        Set set = this.zag;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((SignInConnectionListener) it.next()).onComplete();
        }
        set.clear();
    }

    public final boolean zaC() {
        ConnectionResult connectionResult = this.zak;
        return connectionResult != null && connectionResult.zzb == 4;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zab() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zac(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zad(Api api) {
        Object obj = this.zaf.get(api.zab());
        zabi zabiVar = this.zae;
        if (zzah.equal(obj, zabiVar)) {
            return zaC() ? new ConnectionResult(4, zaz()) : zabiVar.zad(api);
        }
        return this.zad.zad(api);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl zae(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = (zabi) this.zaf.get(apiMethodImpl.getClientKey());
        zzah.checkNotNull(zabiVar, "GoogleApiClient is not configured to use the API required for this call.");
        zabi zabiVar2 = this.zae;
        if (!zabiVar.equals(zabiVar2)) {
            this.zad.zae(apiMethodImpl);
            return apiMethodImpl;
        }
        if (zaC()) {
            apiMethodImpl.setFailedResult(new Status(4, (String) null, zaz()));
            return apiMethodImpl;
        }
        zabiVar2.zae(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl zaf(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = (zabi) this.zaf.get(apiMethodImpl.getClientKey());
        zzah.checkNotNull(zabiVar, "GoogleApiClient is not configured to use the API required for this call.");
        zabi zabiVar2 = this.zae;
        if (!zabiVar.equals(zabiVar2)) {
            return this.zad.zaf(apiMethodImpl);
        }
        if (!zaC()) {
            return zabiVar2.zaf(apiMethodImpl);
        }
        apiMethodImpl.setFailedResult(new Status(4, (String) null, zaz()));
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zaq() {
        this.zan = 2;
        this.zal = false;
        this.zak = null;
        this.zaj = null;
        this.zad.zaq();
        this.zae.zaq();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zar() {
        this.zak = null;
        this.zaj = null;
        this.zan = 0;
        this.zad.zar();
        this.zae.zar();
        zaB();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zas(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.zae.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.zad.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zat() {
        this.zad.zat();
        this.zae.zat();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zau() {
        Lock lock = this.zam;
        lock.lock();
        try {
            boolean zZax = zax();
            this.zae.zar();
            this.zak = new ConnectionResult(4);
            if (zZax) {
                new com.google.android.gms.internal.base.zau(this.zac).post(new zav(this));
            } else {
                zaB();
            }
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zaw() {
        Lock lock = this.zam;
        lock.lock();
        try {
            boolean z = false;
            if (this.zad.zaw() && (this.zae.zaw() || zaC() || this.zan == 1)) {
                z = true;
            }
            return z;
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zax() {
        Lock lock = this.zam;
        lock.lock();
        try {
            return this.zan == 2;
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        zabi zabiVar = this.zae;
        Lock lock = this.zam;
        lock.lock();
        try {
            boolean z = false;
            if (zax() || zaw()) {
                if (!zabiVar.zaw()) {
                    this.zag.add(signInConnectionListener);
                    z = true;
                    if (this.zan == 0) {
                        this.zan = 1;
                    }
                    this.zak = null;
                    zabiVar.zaq();
                }
            }
            return z;
        } finally {
            lock.unlock();
        }
    }

    public final PendingIntent zaz() {
        Api.Client client = this.zah;
        if (client == null) {
            return null;
        }
        return PendingIntent.getActivity(this.zaa, System.identityHashCode(this.zab), client.getSignInIntent(), com.google.android.gms.internal.base.zap.zaa | 134217728);
    }

    public static void zap(zaaa zaaaVar) {
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        ConnectionResult connectionResult3 = zaaaVar.zaj;
        boolean z = connectionResult3 != null && connectionResult3.isSuccess();
        zabi zabiVar = zaaaVar.zad;
        if (!z) {
            ConnectionResult connectionResult4 = zaaaVar.zaj;
            zabi zabiVar2 = zaaaVar.zae;
            if (connectionResult4 != null && (connectionResult2 = zaaaVar.zak) != null && connectionResult2.isSuccess()) {
                zabiVar2.zar();
                ConnectionResult connectionResult5 = zaaaVar.zaj;
                zzah.checkNotNull(connectionResult5);
                zaaaVar.zaA(connectionResult5);
                return;
            }
            ConnectionResult connectionResult6 = zaaaVar.zaj;
            if (connectionResult6 == null || (connectionResult = zaaaVar.zak) == null) {
                return;
            }
            if (zabiVar2.zaf < zabiVar.zaf) {
                connectionResult6 = connectionResult;
            }
            zaaaVar.zaA(connectionResult6);
            return;
        }
        ConnectionResult connectionResult7 = zaaaVar.zak;
        if (!(connectionResult7 != null && connectionResult7.isSuccess()) && !zaaaVar.zaC()) {
            ConnectionResult connectionResult8 = zaaaVar.zak;
            if (connectionResult8 != null) {
                if (zaaaVar.zan == 1) {
                    zaaaVar.zaB();
                    return;
                } else {
                    zaaaVar.zaA(connectionResult8);
                    zabiVar.zar();
                    return;
                }
            }
            return;
        }
        int i = zaaaVar.zan;
        if (i == 1) {
            zaaaVar.zaB();
        } else if (i != 2) {
            Log.wtf("CompositeGAC", JrbhsraGtto.FdhwlIoGrPd, new AssertionError());
        } else {
            zabe zabeVar = zaaaVar.zab;
            zzah.checkNotNull(zabeVar);
            zabeVar.zab(zaaaVar.zai);
            zaaaVar.zaB();
        }
        zaaaVar.zan = 0;
    }
}
