package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.ArraySet;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
    protected final GoogleApiManager zaa;
    private final Context zab;
    private final String zac;
    private final Api zad;
    private final Api.ApiOptions zae;
    private final ApiKey zaf;
    private final Looper zag;
    private final int zah;
    private final GoogleApiClient zai;
    private final StatusExceptionMapper zaj;

    public static class Settings {
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        public final StatusExceptionMapper zaa;
        public final Looper zab;

        public static class Builder {
            public StatusExceptionMapper zaa;
            public Looper zab;

            public Settings build() {
                if (this.zaa == null) {
                    this.zaa = new ApiExceptionMapper();
                }
                if (this.zab == null) {
                    this.zab = Looper.getMainLooper();
                }
                return new Settings(this.zaa, this.zab);
            }

            public Builder setLooper(Looper looper) {
                zzah.checkNotNull(looper, "Looper must not be null.");
                this.zab = looper;
                return this;
            }

            public Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
                zzah.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zaa = statusExceptionMapper;
                return this;
            }
        }

        public Settings(StatusExceptionMapper statusExceptionMapper, Looper looper) {
            this.zaa = statusExceptionMapper;
            this.zab = looper;
        }
    }

    public GoogleApi(Activity activity, Api<O> api, O o, Settings settings) {
        this(activity, activity, api, o, settings);
    }

    public GoogleApiClient asGoogleApiClient() {
        return this.zai;
    }

    public ClientSettings.Builder createClientSettingsBuilder() {
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        Api.ApiOptions apiOptions = this.zae;
        Account account = null;
        if (!(apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount()) == null) {
            Api.ApiOptions apiOptions2 = this.zae;
            if (apiOptions2 instanceof Api.ApiOptions.HasAccountOptions) {
                account = ((Api.ApiOptions.HasAccountOptions) apiOptions2).getAccount();
            }
        } else {
            String str = googleSignInAccount2.zaf;
            if (str != null) {
                account = new Account(str, "com.google");
            }
        }
        builder.zaa = account;
        Api.ApiOptions apiOptions3 = this.zae;
        Collection collectionEmptySet = (!(apiOptions3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions3).getGoogleSignInAccount()) == null) ? Collections.emptySet() : googleSignInAccount.getRequestedScopes();
        if (builder.zab == null) {
            builder.zab = new ArraySet(0);
        }
        builder.zab.addAll(collectionEmptySet);
        builder.zad = this.zab.getClass().getName();
        builder.zac = this.zab.getPackageName();
        return builder;
    }

    public Task disconnectService() {
        return this.zaa.zan(this);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T t) {
        t.zak();
        this.zaa.zau(this, 2, t);
        return t;
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T t) {
        t.zak();
        this.zaa.zau(this, 0, t);
        return t;
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task doRegisterEventListener(T t, U u) {
        zzah.checkNotNull(t);
        zzah.checkNotNull(u);
        zzah.checkNotNull(t.getListenerKey(), "Listener has already been released.");
        zzah.checkNotNull(u.getListenerKey(), "Listener has already been released.");
        zzah.checkArgument(zzah.equal(t.getListenerKey(), u.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.zao(this, t, u, zad.zaa);
    }

    @ResultIgnorabilityUnspecified
    public Task doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey) {
        return doUnregisterEventListener(listenerKey, 0);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T t) {
        t.zak();
        this.zaa.zau(this, 1, t);
        return t;
    }

    public String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    @Override // com.google.android.gms.common.api.HasApiKey
    public final ApiKey<O> getApiKey() {
        return this.zaf;
    }

    public O getApiOptions() {
        return (O) this.zae;
    }

    public Context getApplicationContext() {
        return this.zab;
    }

    public String getContextAttributionTag() {
        return this.zac;
    }

    @Deprecated
    public String getContextFeatureId() {
        return this.zac;
    }

    public Looper getLooper() {
        return this.zag;
    }

    public <L> ListenerHolder<L> registerListener(L l, String str) {
        return ListenerHolders.createListenerHolder(l, this.zag, str);
    }

    public final int zaa() {
        return this.zah;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Api.Client zab(Looper looper, zabq zabqVar) {
        ClientSettings.Builder builderCreateClientSettingsBuilder = createClientSettingsBuilder();
        ClientSettings clientSettings = new ClientSettings(builderCreateClientSettingsBuilder.zaa, builderCreateClientSettingsBuilder.zab, null, 0, null, builderCreateClientSettingsBuilder.zac, builderCreateClientSettingsBuilder.zad, SignInOptions.zaa);
        Api.AbstractClientBuilder abstractClientBuilderZaa = this.zad.zaa();
        zzah.checkNotNull(abstractClientBuilderZaa);
        Api.Client clientBuildClient = abstractClientBuilderZaa.buildClient(this.zab, looper, clientSettings, this.zae, (GoogleApiClient.ConnectionCallbacks) zabqVar, (GoogleApiClient.OnConnectionFailedListener) zabqVar);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (clientBuildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) clientBuildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (clientBuildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) clientBuildClient).zac(contextAttributionTag);
        }
        return clientBuildClient;
    }

    public final zact zac(Context context, Handler handler) {
        ClientSettings.Builder builderCreateClientSettingsBuilder = createClientSettingsBuilder();
        return new zact(context, handler, new ClientSettings(builderCreateClientSettingsBuilder.zaa, builderCreateClientSettingsBuilder.zab, null, 0, null, builderCreateClientSettingsBuilder.zac, builderCreateClientSettingsBuilder.zad, SignInOptions.zaa));
    }

    @Deprecated
    public GoogleApi(Activity activity, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setMapper(statusExceptionMapper);
        builder.setLooper(activity.getMainLooper());
        this(activity, (Api) api, (Api.ApiOptions) o, builder.build());
    }

    @ResultIgnorabilityUnspecified
    public Task doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey, int i) {
        zzah.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.zaa.zap(this, listenerKey, i);
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends Api.AnyClient> Task doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zav(this, 2, taskApiCall, taskCompletionSource, this.zaj);
        return taskCompletionSource.zza;
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends Api.AnyClient> Task doRead(TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zav(this, 0, taskApiCall, taskCompletionSource, this.zaj);
        return taskCompletionSource.zza;
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends Api.AnyClient> Task doWrite(TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zav(this, 1, taskApiCall, taskCompletionSource, this.zaj);
        return taskCompletionSource.zza;
    }

    public GoogleApi(Context context, Activity activity, Api api, Api.ApiOptions apiOptions, Settings settings) {
        String apiFallbackAttributionTag;
        zzah.checkNotNull(context, "Null context is not permitted.");
        zzah.checkNotNull(api, "Api must not be null.");
        zzah.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        zzah.checkNotNull(applicationContext, "The provided context did not have an application context.");
        this.zab = applicationContext;
        if (Build.VERSION.SDK_INT < 30) {
            apiFallbackAttributionTag = getApiFallbackAttributionTag(context);
        } else {
            apiFallbackAttributionTag = context.getAttributionTag();
        }
        this.zac = apiFallbackAttributionTag;
        this.zad = api;
        this.zae = apiOptions;
        this.zag = settings.zab;
        ApiKey sharedApiKey = ApiKey.getSharedApiKey(api, apiOptions, apiFallbackAttributionTag);
        this.zaf = sharedApiKey;
        this.zai = new zabv(this);
        GoogleApiManager googleApiManagerZak = GoogleApiManager.zak(applicationContext);
        this.zaa = googleApiManagerZak;
        this.zah = googleApiManagerZak.zaa();
        this.zaj = settings.zaa;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zaae.zad(activity, googleApiManagerZak, sharedApiKey);
        }
        googleApiManagerZak.zaz(this);
    }

    @ResultIgnorabilityUnspecified
    public <A extends Api.AnyClient> Task doRegisterEventListener(RegistrationMethods<A, ?> registrationMethods) {
        zzah.checkNotNull(registrationMethods);
        zzah.checkNotNull(registrationMethods.register.getListenerKey(), "Listener has already been released.");
        zzah.checkNotNull(registrationMethods.zaa.getListenerKey(), "Listener has already been released.");
        return this.zaa.zao(this, registrationMethods.register, registrationMethods.zaa, registrationMethods.zab);
    }

    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, Looper looper, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setLooper(looper);
        builder.setMapper(statusExceptionMapper);
        this(context, api, o, builder.build());
    }

    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        this(context, (Activity) null, api, o, settings);
    }

    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setMapper(statusExceptionMapper);
        this(context, api, o, builder.build());
    }
}
