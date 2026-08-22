package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections$KeySet;
import androidx.fragment.app.FragmentActivity;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zada;
import com.google.android.gms.common.api.internal.zak;
import com.google.android.gms.common.api.internal.zat;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.signin.SignInOptions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.google.firebase.inject.PVS.jIKWv;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class GoogleApiClient {
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    public static final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    }

    @Deprecated
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Set<GoogleApiClient> set = zaa;
        synchronized (set) {
            try {
                String str2 = str + "  ";
                int i = 0;
                for (GoogleApiClient googleApiClient : set) {
                    printWriter.append((CharSequence) str).append("GoogleApiClient#").println(i);
                    googleApiClient.dump(str2, fileDescriptor, printWriter, strArr);
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Set<GoogleApiClient> getAllClients() {
        Set<GoogleApiClient> set = zaa;
        synchronized (set) {
        }
        return set;
    }

    @ResultIgnorabilityUnspecified
    public abstract ConnectionResult blockingConnect();

    @ResultIgnorabilityUnspecified
    public abstract ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @ResultIgnorabilityUnspecified
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        throw new UnsupportedOperationException();
    }

    @ResultIgnorabilityUnspecified
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new UnsupportedOperationException();
    }

    public <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public boolean hasApi(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    public boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    public void maybeSignOut() {
        throw new UnsupportedOperationException();
    }

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public <L> ListenerHolder<L> registerListener(L l) {
        throw new UnsupportedOperationException();
    }

    public abstract void stopAutoManage(FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public void zao(zada zadaVar) {
        throw new UnsupportedOperationException();
    }

    public void zap(zada zadaVar) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: loaded from: classes2.dex */
    @Deprecated
    public static final class Builder {
        public Account zaa;
        public final HashSet zab;
        public final HashSet zac;
        public int zad;
        public View zae;
        public final String zaf;
        public final String zag;
        public final ArrayMap zah;
        public final Context zai;
        public final ArrayMap zaj;
        public LifecycleActivity zak;
        public int zal;
        public OnConnectionFailedListener zam;
        public Looper zan;
        public final GoogleApiAvailability zao;
        public final com.google.android.gms.signin.zaa zap;
        public final ArrayList zaq;
        public final ArrayList zar;

        public Builder(Context context) {
            this.zab = new HashSet();
            this.zac = new HashSet();
            this.zah = new ArrayMap();
            this.zaj = new ArrayMap();
            this.zal = -1;
            this.zao = GoogleApiAvailability.zab;
            this.zap = com.google.android.gms.signin.zad.zac;
            this.zaq = new ArrayList();
            this.zar = new ArrayList();
            this.zai = context;
            this.zan = context.getMainLooper();
            this.zaf = context.getPackageName();
            this.zag = context.getClass().getName();
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzah.checkNotNull(api, "Api must not be null");
            this.zaj.put(api, null);
            Api.BaseClientBuilder baseClientBuilderZac = api.zac();
            zzah.checkNotNull(baseClientBuilderZac, "Base client builder must not be null");
            List<Scope> impliedScopes = baseClientBuilderZac.getImpliedScopes(null);
            this.zac.addAll(impliedScopes);
            this.zab.addAll(impliedScopes);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> api, O o, Scope... scopeArr) {
            zzah.checkNotNull(api, jIKWv.EspQ);
            zzah.checkNotNull(o, "Null options are not permitted for this Api");
            this.zaj.put(api, o);
            zab(api, o, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            zzah.checkNotNull(connectionCallbacks, "Listener must not be null");
            this.zaq.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            zzah.checkNotNull(onConnectionFailedListener, "Listener must not be null");
            this.zar.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(Scope scope) {
            zzah.checkNotNull(scope, "Scope must not be null");
            this.zab.add(scope);
            return this;
        }

        @ResultIgnorabilityUnspecified
        public GoogleApiClient build() {
            zzah.checkArgument(!this.zaj.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings clientSettingsZaa = zaa();
            Map map = clientSettingsZaa.zad;
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api = null;
            boolean z = false;
            for (Api api2 : (MapCollections$KeySet) this.zaj.keySet()) {
                Object orDefault = this.zaj.getOrDefault(api2, null);
                boolean z2 = map.get(api2) != null;
                arrayMap.put(api2, Boolean.valueOf(z2));
                zat zatVar = new zat(api2, z2);
                arrayList.add(zatVar);
                Api.AbstractClientBuilder abstractClientBuilderZaa = api2.zaa();
                zzah.checkNotNull(abstractClientBuilderZaa);
                Api.Client clientBuildClient = abstractClientBuilderZaa.buildClient(this.zai, this.zan, clientSettingsZaa, orDefault, (ConnectionCallbacks) zatVar, (OnConnectionFailedListener) zatVar);
                arrayMap2.put(api2.zab(), clientBuildClient);
                if (abstractClientBuilderZaa.getPriority() == 1) {
                    z = orDefault != null;
                }
                if (clientBuildClient.providesSignIn()) {
                    if (api != null) {
                        throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(api2.zad(), " cannot be used with ", api.zad()));
                    }
                    api = api2;
                }
            }
            if (api != null) {
                if (z) {
                    throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("With using ", api.zad(), ", GamesOptions can only be specified within GoogleSignInOptions.Builder"));
                }
                boolean z3 = this.zaa == null;
                String strZad = api.zad();
                if (!z3) {
                    throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Must not set an account in GoogleApiClient.Builder when using ", strZad, ". Set account in GoogleSignInOptions.Builder instead"));
                }
                boolean zEquals = this.zab.equals(this.zac);
                String strZad2 = api.zad();
                if (!zEquals) {
                    throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Must not set scopes in GoogleApiClient.Builder when using ", strZad2, ". Set account in GoogleSignInOptions.Builder instead."));
                }
            }
            zabe zabeVar = new zabe(this.zai, new ReentrantLock(), this.zan, clientSettingsZaa, this.zao, this.zap, arrayMap, this.zaq, this.zar, arrayMap2, this.zal, zabe.zad(arrayMap2.values(), true), arrayList);
            Set set = GoogleApiClient.zaa;
            synchronized (set) {
                set.add(zabeVar);
            }
            if (this.zal >= 0) {
                zak.zaa(this.zak).zad(this.zal, zabeVar, this.zam);
            }
            return zabeVar;
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
            zzah.checkArgument(i >= 0, "clientId must be non-negative");
            this.zal = i;
            this.zam = onConnectionFailedListener;
            this.zak = lifecycleActivity;
            return this;
        }

        public Builder setAccountName(String str) {
            this.zaa = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.zad = i;
            return this;
        }

        public Builder setHandler(Handler handler) {
            zzah.checkNotNull(handler, "Handler must not be null");
            this.zan = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View view) {
            zzah.checkNotNull(view, "View must not be null");
            this.zae = view;
            return this;
        }

        public Builder useDefaultAccount() {
            setAccountName("<<default account>>");
            return this;
        }

        public final ClientSettings zaa() {
            SignInOptions signInOptions = SignInOptions.zaa;
            Api api = com.google.android.gms.signin.zad.zag;
            ArrayMap arrayMap = this.zaj;
            if (arrayMap.containsKey(api)) {
                signInOptions = (SignInOptions) arrayMap.getOrDefault(api, null);
            }
            Account account = this.zaa;
            HashSet hashSet = this.zab;
            int i = this.zad;
            View view = this.zae;
            String str = this.zag;
            String str2 = this.zaf;
            return new ClientSettings(account, hashSet, this.zah, i, view, str2, str, signInOptions);
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, OnConnectionFailedListener onConnectionFailedListener) {
            enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
            return this;
        }

        public final void zab(Api api, Api.ApiOptions.HasOptions hasOptions, Scope... scopeArr) {
            Api.BaseClientBuilder baseClientBuilderZac = api.zac();
            zzah.checkNotNull(baseClientBuilderZac, MnHfHMYQDPUO.fjzxvildnChVt);
            HashSet hashSet = new HashSet(baseClientBuilderZac.getImpliedScopes(hasOptions));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.zah.put(api, new com.google.android.gms.common.internal.zab(hashSet));
        }

        public <T extends Api.ApiOptions.NotRequiredOptions> Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            zzah.checkNotNull(api, "Api must not be null");
            this.zaj.put(api, null);
            zab(api, null, scopeArr);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o) {
            zzah.checkNotNull(api, "Api must not be null");
            zzah.checkNotNull(o, "Null options are not permitted for this Api");
            this.zaj.put(api, o);
            Api.BaseClientBuilder baseClientBuilderZac = api.zac();
            zzah.checkNotNull(baseClientBuilderZac, "Base client builder must not be null");
            List<Scope> impliedScopes = baseClientBuilderZac.getImpliedScopes(o);
            this.zac.addAll(impliedScopes);
            this.zab.addAll(impliedScopes);
            return this;
        }

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzah.checkNotNull(connectionCallbacks, "Must provide a connected listener");
            this.zaq.add(connectionCallbacks);
            zzah.checkNotNull(onConnectionFailedListener, "Must provide a connection failed listener");
            this.zar.add(onConnectionFailedListener);
        }
    }
}
