package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseGmsClient {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private ConnectionResult zzB;
    private boolean zzC;
    private volatile zzk zzD;
    zzv zza;
    final Handler zzb;
    protected ConnectionProgressReportCallbacks zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    private IGmsServiceBroker zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private zze zzu;
    private int zzv;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;
    private static final Feature[] zze = new Feature[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* JADX INFO: loaded from: classes.dex */
    public interface BaseConnectionCallbacks {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(ConnectionResult connectionResult) {
            boolean zIsSuccess = connectionResult.isSuccess();
            BaseGmsClient baseGmsClient = BaseGmsClient.this;
            if (zIsSuccess) {
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else if (baseGmsClient.zzx != null) {
                baseGmsClient.zzx.onConnectionFailed(connectionResult);
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface SignOutCallbacks {
        void onSignOutComplete();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BaseGmsClient(Context context, Looper looper, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, int i) {
        zzs gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.zza;
        zzah.checkNotNull(baseConnectionCallbacks);
        zzah.checkNotNull(baseOnConnectionFailedListener);
        this(context, looper, gmsClientSupervisor, googleApiAvailabilityLight, i, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    public static void zzj(BaseGmsClient baseGmsClient, zzk zzkVar) {
        baseGmsClient.zzD = zzkVar;
        if (baseGmsClient.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar.zzd;
            zah zahVar = zah.getInstance();
            RootTelemetryConfiguration rootTelemetryConfiguration = connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.zza;
            synchronized (zahVar) {
                try {
                    if (rootTelemetryConfiguration == null) {
                        rootTelemetryConfiguration = zah.zzb;
                    } else {
                        RootTelemetryConfiguration rootTelemetryConfiguration2 = (RootTelemetryConfiguration) zahVar.zaa;
                        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.zza < rootTelemetryConfiguration.zza) {
                        }
                    }
                    zahVar.zaa = rootTelemetryConfiguration;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static /* bridge */ /* synthetic */ void zzk(BaseGmsClient baseGmsClient, int i) {
        int i2;
        int i3;
        synchronized (baseGmsClient.zzp) {
            i2 = baseGmsClient.zzv;
        }
        if (i2 == 3) {
            baseGmsClient.zzC = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = baseGmsClient.zzb;
        handler.sendMessage(handler.obtainMessage(i3, baseGmsClient.zzd.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean zzn(BaseGmsClient baseGmsClient, int i, int i2, IInterface iInterface) {
        synchronized (baseGmsClient.zzp) {
            try {
                if (baseGmsClient.zzv != i) {
                    return false;
                }
                baseGmsClient.zzp(i2, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzo(BaseGmsClient baseGmsClient) {
        if (baseGmsClient.zzC || TextUtils.isEmpty(baseGmsClient.getServiceDescriptor()) || TextUtils.isEmpty(baseGmsClient.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(baseGmsClient.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void checkAvailabilityAndConnect() {
        int iIsGooglePlayServicesAvailable = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
        if (iIsGooglePlayServicesAvailable == 0) {
            connect(new LegacyClientCallbackAdapter());
        } else {
            zzp(1, null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), iIsGooglePlayServicesAvailable, null);
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        zzah.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        zzp(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i = 0; i < size; i++) {
                    ((zza) this.zzt.get(i)).zzf();
                }
                this.zzt.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, null);
    }

    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public Feature[] getApiFeatures() {
        return zze;
    }

    public final Feature[] getAvailableFeatures() {
        zzk zzkVar = this.zzD;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.zzb;
    }

    public Executor getBindServiceExecutor() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        zzv zzvVar;
        if (!isConnected() || (zzvVar = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return zzvVar.zzb;
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = this.zzA;
        int i = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        int i2 = this.zzy;
        Feature[] featureArr = GetServiceRequest.zzb;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i2, i, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.zzf = this.zzl.getPackageName();
        getServiceRequest.zzi = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzh = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.zzj = account;
            if (iAccountAccessor != null) {
                getServiceRequest.zzg = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zzj = getAccount();
        }
        getServiceRequest.zzk = zze;
        getServiceRequest.zzl = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.zzo = true;
        }
        try {
            synchronized (this.zzq) {
                try {
                    IGmsServiceBroker iGmsServiceBroker = this.zzr;
                    if (iGmsServiceBroker != null) {
                        ((zzad) iGmsServiceBroker).getService(new zzd(this, this.zzd.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            triggerConnectionSuspended(3);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public final IInterface getService() {
        IInterface iInterface;
        synchronized (this.zzp) {
            try {
                if (this.zzv == 5) {
                    throw new DeadObjectException();
                }
                checkConnected();
                iInterface = this.zzs;
                zzah.checkNotNull(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            try {
                IGmsServiceBroker iGmsServiceBroker = this.zzr;
                if (iGmsServiceBroker == null) {
                    return null;
                }
                return ((zzad) iGmsServiceBroker).asBinder();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public abstract String getStartServiceAction();

    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzk zzkVar = this.zzD;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.zzd;
    }

    public boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i = this.zzv;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    public void onConnectedLocked(IInterface iInterface) {
        this.zzh = System.currentTimeMillis();
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzi = connectionResult.zzb;
        this.zzj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int i) {
        this.zzf = i;
        this.zzg = System.currentTimeMillis();
    }

    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.zzb.sendMessage(this.zzb.obtainMessage(1, i2, -1, new zzf(this, i, iBinder, bundle)));
    }

    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i) {
        this.zzb.sendMessage(this.zzb.obtainMessage(6, this.zzd.get(), i));
    }

    public void triggerNotAvailable(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, PendingIntent pendingIntent) {
        zzah.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        this.zzb.sendMessage(this.zzb.obtainMessage(3, this.zzd.get(), i, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    public final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zzl(int i, Bundle bundle, int i2) {
        this.zzb.sendMessage(this.zzb.obtainMessage(7, i2, -1, new zzg(this, i)));
    }

    public final void zzp(int i, IInterface iInterface) {
        zzv zzvVar;
        zzah.checkArgument((i == 4) == (iInterface != null));
        synchronized (this.zzp) {
            try {
                this.zzv = i;
                this.zzs = iInterface;
                if (i == 1) {
                    zze zzeVar = this.zzu;
                    if (zzeVar != null) {
                        GmsClientSupervisor gmsClientSupervisor = this.zzn;
                        String str = this.zza.zza;
                        zzah.checkNotNull(str);
                        String str2 = this.zza.zzb;
                        zze();
                        gmsClientSupervisor.zzb(str, str2, zzeVar, this.zza.zzc);
                        this.zzu = null;
                    }
                } else if (i == 2 || i == 3) {
                    zze zzeVar2 = this.zzu;
                    if (zzeVar2 != null && (zzvVar = this.zza) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzvVar.zza + " on " + zzvVar.zzb);
                        GmsClientSupervisor gmsClientSupervisor2 = this.zzn;
                        String str3 = this.zza.zza;
                        zzah.checkNotNull(str3);
                        String str4 = this.zza.zzb;
                        zze();
                        gmsClientSupervisor2.zzb(str3, str4, zzeVar2, this.zza.zzc);
                        this.zzd.incrementAndGet();
                    }
                    zze zzeVar3 = new zze(this, this.zzd.get());
                    this.zzu = zzeVar3;
                    zzv zzvVar2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new zzv(getStartServicePackage(), getStartServiceAction(), getUseDynamicLookup()) : new zzv(getContext().getPackageName(), getLocalStartServiceAction(), false);
                    this.zza = zzvVar2;
                    if (zzvVar2.zzc && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.zza)));
                    }
                    GmsClientSupervisor gmsClientSupervisor3 = this.zzn;
                    String str5 = this.zza.zza;
                    zzah.checkNotNull(str5);
                    if (!gmsClientSupervisor3.zzc(new zzo(str5, this.zza.zzb, this.zza.zzc), zzeVar3, zze(), getBindServiceExecutor())) {
                        zzv zzvVar3 = this.zza;
                        Log.w("GmsClient", "unable to connect to service: " + zzvVar3.zza + " on " + zzvVar3.zzb);
                        zzl(16, null, this.zzd.get());
                    }
                } else if (i == 4) {
                    zzah.checkNotNull(iInterface);
                    onConnectedLocked(iInterface);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.zzp) {
            i = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            iGmsServiceBroker = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append((CharSequence) sgtsHsWT.jRSdTS).append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((zzad) iGmsServiceBroker).asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FETmZwrVHuasmL.fIHmioLCdt, Locale.US);
        if (this.zzh > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.zzh;
            printWriterAppend.println(j + wsbWxekY.dwiYpvcuKo + simpleDateFormat.format(new Date(j)));
        }
        if (this.zzg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.zzf;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i2 != 3) {
                printWriter.append((CharSequence) String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzg;
            printWriterAppend2.println(j2 + " " + simpleDateFormat.format(new Date(j2)));
        }
        if (this.zzj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzi));
            PrintWriter printWriterAppend3 = printWriter.append((CharSequence) TSDAbK.blDNV);
            long j3 = this.zzj;
            printWriterAppend3.println(j3 + " " + simpleDateFormat.format(new Date(j3)));
        }
    }

    public BaseGmsClient(Context context, Looper looper, zzs zzsVar, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        zzah.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        zzah.checkNotNull(looper, "Looper must not be null");
        this.zzm = looper;
        zzah.checkNotNull(zzsVar, "Supervisor must not be null");
        this.zzn = zzsVar;
        zzah.checkNotNull(googleApiAvailabilityLight, mnwSv.GbfDRoqsHFg);
        this.zzo = googleApiAvailabilityLight;
        this.zzb = new zzb(this, looper);
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }
}
