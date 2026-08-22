package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes2.dex */
public final class zabe extends GoogleApiClient implements zabz {
    public static final /* synthetic */ int $r8$clinit = 0;
    public zabx zab;
    public final Map zac;
    public final ClientSettings zae;
    public final Map zaf;
    public final Api.AbstractClientBuilder zag;
    public final zadc zai;
    public final Lock zaj;
    public final com.google.android.gms.common.internal.zak zak;
    public final int zam;
    public final Context zan;
    public final Looper zao;
    public volatile boolean zap;
    public final zabc zas;
    public final GoogleApiAvailability zat;
    public final ArrayList zav;
    public Integer zaw;
    public zaca zal = null;
    public final LinkedList zaa = new LinkedList();
    public final long zaq = 120000;
    public final long zar = 5000;
    public Set zad = new HashSet();
    public final ListenerHolders zau = new ListenerHolders();
    public HashSet zah = null;

    public zabe(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder abstractClientBuilder, Map map, List list, List list2, Map map2, int i, int i2, ArrayList arrayList) {
        this.zaw = null;
        zaay zaayVar = new zaay(this);
        this.zan = context;
        this.zaj = lock;
        this.zak = new com.google.android.gms.common.internal.zak(looper, zaayVar);
        this.zao = looper;
        this.zas = new zabc(this, looper);
        this.zat = googleApiAvailability;
        this.zam = i;
        if (i >= 0) {
            this.zaw = Integer.valueOf(i2);
        }
        this.zaf = map;
        this.zac = map2;
        this.zav = arrayList;
        this.zai = new zadc();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.zak.zaf((GoogleApiClient.ConnectionCallbacks) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.zak.zag((GoogleApiClient.OnConnectionFailedListener) it2.next());
        }
        this.zae = clientSettings;
        this.zag = abstractClientBuilder;
    }

    public static int zad(Iterable iterable, boolean z) {
        Iterator it = iterable.iterator();
        boolean zRequiresSignIn = false;
        boolean zProvidesSignIn = false;
        while (it.hasNext()) {
            Api.Client client = (Api.Client) it.next();
            zRequiresSignIn |= client.requiresSignIn();
            zProvidesSignIn |= client.providesSignIn();
        }
        if (zRequiresSignIn) {
            return (zProvidesSignIn && z) ? 2 : 1;
        }
        return 3;
    }

    public static /* bridge */ /* synthetic */ void zai(zabe zabeVar) {
        zabeVar.zaj.lock();
        try {
            if (zabeVar.zap) {
                zabeVar.zan();
            }
        } finally {
            zabeVar.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @ResultIgnorabilityUnspecified
    public final ConnectionResult blockingConnect() {
        zzah.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zaj.lock();
        try {
            if (this.zam >= 0) {
                zzah.checkState(this.zaw != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            Integer num2 = this.zaw;
            zzah.checkNotNull(num2);
            zal(num2.intValue());
            this.zak.zae = true;
            zaca zacaVar = this.zal;
            zzah.checkNotNull(zacaVar);
            ConnectionResult connectionResultZab = zacaVar.zab();
            this.zaj.unlock();
            return connectionResultZab;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzah.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Integer num = this.zaw;
        boolean z = true;
        if (num != null && num.intValue() == 2) {
            z = false;
        }
        zzah.checkState(z, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.zac.containsKey(Common.CLIENT_KEY)) {
            Common.zaa.getClass();
            execute(new com.google.android.gms.common.internal.service.zac(this)).setResultCallback(new zabb(this, statusPendingResult, false, this));
        } else {
            AtomicReference atomicReference = new AtomicReference();
            zaaz zaazVar = new zaaz(this, atomicReference, statusPendingResult);
            zaba zabaVar = new zaba(statusPendingResult);
            GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.zan);
            builder.addApi(Common.API);
            builder.addConnectionCallbacks(zaazVar);
            builder.addOnConnectionFailedListener(zabaVar);
            builder.setHandler(this.zas);
            GoogleApiClient googleApiClientBuild = builder.build();
            atomicReference.set(googleApiClientBuild);
            googleApiClientBuild.connect();
        }
        return statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect() {
        Lock lock = this.zaj;
        lock.lock();
        try {
            int i = 2;
            boolean z = false;
            if (this.zam >= 0) {
                zzah.checkState(this.zaw != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            Integer num2 = this.zaw;
            zzah.checkNotNull(num2);
            int iIntValue = num2.intValue();
            lock.lock();
            try {
                if (iIntValue != 3 && iIntValue != 1) {
                    if (iIntValue != 2) {
                        i = iIntValue;
                    }
                    zzah.checkArgument(z, "Illegal sign-in mode: " + i);
                    zal(i);
                    zan();
                    lock.unlock();
                    return;
                }
                i = iIntValue;
                zzah.checkArgument(z, "Illegal sign-in mode: " + i);
                zal(i);
                zan();
                lock.unlock();
                return;
            } finally {
                lock.unlock();
            }
            z = true;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void disconnect() {
        Lock lock = this.zaj;
        lock.lock();
        try {
            this.zai.zab();
            zaca zacaVar = this.zal;
            if (zacaVar != null) {
                zacaVar.zar();
            }
            this.zau.zab();
            LinkedList<BaseImplementation.ApiMethodImpl> linkedList = this.zaa;
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : linkedList) {
                apiMethodImpl.zan(null);
                apiMethodImpl.cancel();
            }
            linkedList.clear();
            if (this.zal != null) {
                zak();
                com.google.android.gms.common.internal.zak zakVar = this.zak;
                zakVar.zae = false;
                zakVar.zaf.incrementAndGet();
            }
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.zan);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.zap);
        printWriter.append(" mWorkQueue.size()=").print(this.zaa.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zai.zab.size());
        zaca zacaVar = this.zal;
        if (zacaVar != null) {
            zacaVar.zas(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @ResultIgnorabilityUnspecified
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        Api<?> api = t.getApi();
        zzah.checkArgument(this.zac.containsKey(t.getClientKey()), "GoogleApiClient is not configured to use " + (api != null ? api.zad() : "the API") + " required for this call.");
        Lock lock = this.zaj;
        lock.lock();
        try {
            zaca zacaVar = this.zal;
            if (zacaVar == null) {
                this.zaa.add(t);
            } else {
                t = (T) zacaVar.zae(t);
            }
            return t;
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @ResultIgnorabilityUnspecified
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        Map map = this.zac;
        Api<?> api = t.getApi();
        zzah.checkArgument(map.containsKey(t.getClientKey()), "GoogleApiClient is not configured to use " + (api != null ? api.zad() : "the API") + " required for this call.");
        this.zaj.lock();
        try {
            zaca zacaVar = this.zal;
            if (zacaVar == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.zap) {
                this.zaa.add(t);
                while (!this.zaa.isEmpty()) {
                    BaseImplementation.ApiMethodImpl apiMethodImpl = (BaseImplementation.ApiMethodImpl) this.zaa.remove();
                    zadc zadcVar = this.zai;
                    zadcVar.zab.add(apiMethodImpl);
                    apiMethodImpl.zan(zadcVar.zac);
                    apiMethodImpl.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                }
            } else {
                t = (T) zacaVar.zaf(t);
            }
            this.zaj.unlock();
            return t;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        C c = (C) this.zac.get(anyClientKey);
        zzah.checkNotNull(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult getConnectionResult(Api<?> api) {
        ConnectionResult connectionResult;
        this.zaj.lock();
        try {
            if (!isConnected() && !this.zap) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.zac.containsKey(api.zab())) {
                throw new IllegalArgumentException(api.zad() + " was never registered with GoogleApiClient");
            }
            zaca zacaVar = this.zal;
            zzah.checkNotNull(zacaVar);
            ConnectionResult connectionResultZad = zacaVar.zad(api);
            if (connectionResultZad != null) {
                this.zaj.unlock();
                return connectionResultZad;
            }
            if (this.zap) {
                connectionResult = ConnectionResult.RESULT_SUCCESS;
            } else {
                Log.w("GoogleApiClientImpl", zaf());
                Log.wtf("GoogleApiClientImpl", api.zad() + " requested in getConnectionResult is not connected but is not present in the failed  connections map", new Exception());
                connectionResult = new ConnectionResult(8, null);
            }
            this.zaj.unlock();
            return connectionResult;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.zan;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.zao;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasApi(Api<?> api) {
        return this.zac.containsKey(api.zab());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasConnectedApi(Api<?> api) {
        Api.Client client;
        return isConnected() && (client = (Api.Client) this.zac.get(api.zab())) != null && client.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnected() {
        zaca zacaVar = this.zal;
        return zacaVar != null && zacaVar.zaw();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnecting() {
        zaca zacaVar = this.zal;
        return zacaVar != null && zacaVar.zax();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean zContains;
        com.google.android.gms.common.internal.zak zakVar = this.zak;
        zakVar.getClass();
        zzah.checkNotNull(connectionCallbacks);
        synchronized (zakVar.zai) {
            zContains = zakVar.zac.contains(connectionCallbacks);
        }
        return zContains;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean zContains;
        com.google.android.gms.common.internal.zak zakVar = this.zak;
        zakVar.getClass();
        zzah.checkNotNull(onConnectionFailedListener);
        synchronized (zakVar.zai) {
            zContains = zakVar.zad.contains(onConnectionFailedListener);
        }
        return zContains;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zaca zacaVar = this.zal;
        return zacaVar != null && zacaVar.zay(signInConnectionListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void maybeSignOut() {
        zaca zacaVar = this.zal;
        if (zacaVar != null) {
            zacaVar.zau();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zaf(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zag(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <L> ListenerHolder<L> registerListener(L l) {
        Lock lock = this.zaj;
        lock.lock();
        try {
            return this.zau.zaa(l, this.zao, "NO_TYPE");
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void stopAutoManage(FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
        int i = this.zam;
        if (i < 0) {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
        zak.zaa(lifecycleActivity).zae(i);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        com.google.android.gms.common.internal.zak zakVar = this.zak;
        zakVar.getClass();
        zzah.checkNotNull(connectionCallbacks);
        synchronized (zakVar.zai) {
            try {
                if (!zakVar.zac.remove(connectionCallbacks)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + String.valueOf(connectionCallbacks) + " not found");
                } else if (zakVar.zag) {
                    zakVar.zaa.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        com.google.android.gms.common.internal.zak zakVar = this.zak;
        zakVar.getClass();
        zzah.checkNotNull(onConnectionFailedListener);
        synchronized (zakVar.zai) {
            try {
                if (!zakVar.zad.remove(onConnectionFailedListener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + String.valueOf(onConnectionFailedListener) + " not found");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        GoogleApiAvailability googleApiAvailability = this.zat;
        Context context = this.zan;
        int i = connectionResult.zzb;
        googleApiAvailability.getClass();
        int i2 = GooglePlayServicesUtil.$r8$clinit;
        if (!(i == 18 ? true : i == 1 ? GooglePlayServicesUtil.zza(context) : false)) {
            zak();
        }
        if (this.zap) {
            return;
        }
        com.google.android.gms.common.internal.zak zakVar = this.zak;
        if (Looper.myLooper() != zakVar.zah.getLooper()) {
            throw new IllegalStateException("onConnectionFailure must only be called on the Handler thread");
        }
        zakVar.zah.removeMessages(1);
        synchronized (zakVar.zai) {
            try {
                ArrayList<GoogleApiClient.OnConnectionFailedListener> arrayList = new ArrayList(zakVar.zad);
                int i3 = zakVar.zaf.get();
                for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : arrayList) {
                    if (zakVar.zae && zakVar.zaf.get() == i3) {
                        if (zakVar.zad.contains(onConnectionFailedListener)) {
                            onConnectionFailedListener.onConnectionFailed(connectionResult);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.common.internal.zak zakVar2 = this.zak;
        zakVar2.zae = false;
        zakVar2.zaf.incrementAndGet();
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(Bundle bundle) {
        while (!this.zaa.isEmpty()) {
            execute((BaseImplementation.ApiMethodImpl) this.zaa.remove());
        }
        com.google.android.gms.common.internal.zak zakVar = this.zak;
        if (Looper.myLooper() != zakVar.zah.getLooper()) {
            throw new IllegalStateException("onConnectionSuccess must only be called on the Handler thread");
        }
        synchronized (zakVar.zai) {
            try {
                zzah.checkState$1(!zakVar.zag);
                zakVar.zah.removeMessages(1);
                zakVar.zag = true;
                zzah.checkState$1(zakVar.zaa.isEmpty());
                ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList = new ArrayList(zakVar.zac);
                int i = zakVar.zaf.get();
                for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : arrayList) {
                    if (!zakVar.zae || !zakVar.zab.isConnected() || zakVar.zaf.get() != i) {
                        break;
                        break;
                        break;
                    } else if (!zakVar.zaa.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(bundle);
                    }
                }
                zakVar.zaa.clear();
                zakVar.zag = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zac(int i, boolean z) {
        if (i == 1) {
            if (!z && !this.zap) {
                this.zap = true;
                if (this.zab == null) {
                    try {
                        GoogleApiAvailability googleApiAvailability = this.zat;
                        Context applicationContext = this.zan.getApplicationContext();
                        zabd zabdVar = new zabd(this);
                        googleApiAvailability.getClass();
                        this.zab = GoogleApiAvailability.zac(applicationContext, zabdVar);
                    } catch (SecurityException unused) {
                    }
                }
                zabc zabcVar = this.zas;
                zabcVar.sendMessageDelayed(zabcVar.obtainMessage(1), this.zaq);
                zabc zabcVar2 = this.zas;
                zabcVar2.sendMessageDelayed(zabcVar2.obtainMessage(2), this.zar);
            }
            i = 1;
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zai.zab.toArray(new BasePendingResult[0])) {
            basePendingResult.forceFailureUnlessReady(zadc.zaa);
        }
        com.google.android.gms.common.internal.zak zakVar = this.zak;
        if (Looper.myLooper() != zakVar.zah.getLooper()) {
            throw new IllegalStateException("onUnintentionalDisconnection must only be called on the Handler thread");
        }
        zakVar.zah.removeMessages(1);
        synchronized (zakVar.zai) {
            try {
                zakVar.zag = true;
                ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList = new ArrayList(zakVar.zac);
                int i2 = zakVar.zaf.get();
                for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : arrayList) {
                    if (!zakVar.zae || zakVar.zaf.get() != i2) {
                        break;
                        break;
                    } else if (zakVar.zac.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnectionSuspended(i);
                    }
                }
                zakVar.zaa.clear();
                zakVar.zag = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.common.internal.zak zakVar2 = this.zak;
        zakVar2.zae = false;
        zakVar2.zaf.incrementAndGet();
        if (i == 2) {
            zan();
        }
    }

    public final boolean zak() {
        if (!this.zap) {
            return false;
        }
        this.zap = false;
        this.zas.removeMessages(2);
        this.zas.removeMessages(1);
        zabx zabxVar = this.zab;
        if (zabxVar != null) {
            zabxVar.zab();
            this.zab = null;
        }
        return true;
    }

    public final void zal(int i) {
        String str;
        Integer num = this.zaw;
        if (num == null) {
            this.zaw = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            int iIntValue = this.zaw.intValue();
            String str2 = "SIGN_IN_MODE_REQUIRED";
            if (iIntValue == 1) {
                str = "SIGN_IN_MODE_REQUIRED";
            } else if (iIntValue != 2) {
                str = iIntValue != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE";
            } else {
                str = "SIGN_IN_MODE_OPTIONAL";
            }
            StringBuilder sb = new StringBuilder("Cannot use sign-in mode: ");
            if (i != 1) {
                str2 = i != 2 ? i != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL";
            }
            throw new IllegalStateException(Fragment$$ExternalSyntheticOutline0.m(sb, str2, ". Mode was already set to ", str));
        }
        if (this.zal != null) {
            return;
        }
        boolean zRequiresSignIn = false;
        boolean zProvidesSignIn = false;
        for (Api.Client client : this.zac.values()) {
            zRequiresSignIn |= client.requiresSignIn();
            zProvidesSignIn |= client.providesSignIn();
        }
        int iIntValue2 = this.zaw.intValue();
        if (iIntValue2 == 1) {
            if (!zRequiresSignIn) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (zProvidesSignIn) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else if (iIntValue2 == 2 && zRequiresSignIn) {
            this.zal = zaaa.zag(this.zan, this, this.zaj, this.zao, this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav);
            return;
        }
        this.zal = new zabi(this.zan, this, this.zaj, this.zao, this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav, this);
    }

    public final void zan() {
        this.zak.zae = true;
        zaca zacaVar = this.zal;
        zzah.checkNotNull(zacaVar);
        zacaVar.zaq();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zao(zada zadaVar) {
        Lock lock = this.zaj;
        lock.lock();
        try {
            if (this.zah == null) {
                this.zah = new HashSet();
            }
            this.zah.add(zadaVar);
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zap(zada zadaVar) {
        Lock lock = this.zaj;
        lock.lock();
        try {
            HashSet hashSet = this.zah;
            if (hashSet == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (hashSet.remove(zadaVar)) {
                lock.lock();
                try {
                    HashSet hashSet2 = this.zah;
                    if (hashSet2 == null) {
                        lock.unlock();
                    } else {
                        boolean zIsEmpty = hashSet2.isEmpty();
                        lock.unlock();
                        if (zIsEmpty) {
                        }
                    }
                    zaca zacaVar = this.zal;
                    if (zacaVar != null) {
                        zacaVar.zat();
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            }
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public final String zaf() {
        StringWriter stringWriter = new StringWriter();
        dump(wsbWxekY.xud, null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        zzah.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        zzah.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zaj.lock();
        try {
            Integer num = this.zaw;
            if (num == null) {
                this.zaw = Integer.valueOf(zad(this.zac.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            Integer num2 = this.zaw;
            zzah.checkNotNull(num2);
            zal(num2.intValue());
            this.zak.zae = true;
            zaca zacaVar = this.zal;
            zzah.checkNotNull(zacaVar);
            ConnectionResult connectionResultZac = zacaVar.zac(j, timeUnit);
            this.zaj.unlock();
            return connectionResultZac;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect(int i) {
        Lock lock = this.zaj;
        lock.lock();
        boolean z = true;
        if (i != 3 && i != 1) {
            if (i == 2) {
                i = 2;
            } else {
                z = false;
            }
        }
        try {
            zzah.checkArgument(z, "Illegal sign-in mode: " + i);
            zal(i);
            zan();
        } finally {
            lock.unlock();
        }
    }
}
