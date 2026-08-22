package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzw;

/* JADX INFO: loaded from: classes.dex */
final class zacd implements OnCompleteListener {
    public final GoogleApiManager zaa;
    public final int zab;
    public final ApiKey zac;
    public final long zad;
    public final long zae;

    public zacd(GoogleApiManager googleApiManager, int i, ApiKey apiKey, long j, long j2) {
        this.zaa = googleApiManager;
        this.zab = i;
        this.zac = apiKey;
        this.zad = j;
        this.zae = j2;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x002d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x002e A[RETURN] */
    public static ConnectionTelemetryConfiguration zab(zabq zabqVar, BaseGmsClient baseGmsClient, int i) {
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration != null && telemetryConfiguration.zzb) {
            int i2 = 0;
            int[] iArr = telemetryConfiguration.zzd;
            if (iArr == null) {
                int[] iArr2 = telemetryConfiguration.zzf;
                if (iArr2 != null) {
                    while (i2 < iArr2.length) {
                        if (iArr2[i2] != i) {
                            i2++;
                        }
                    }
                }
                if (zabqVar.zam < telemetryConfiguration.zze) {
                    return telemetryConfiguration;
                }
                return null;
            }
            while (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    if (zabqVar.zam < telemetryConfiguration.zze) {
                        return telemetryConfiguration;
                    }
                    return null;
                }
                i2++;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0092 A[PHI: r9
  0x0092: PHI (r9v3 int) = (r9v0 int), (r9v2 int) binds: [B:38:0x0090, B:44:0x00ab] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int i;
        int i2;
        int i3;
        int i4;
        long j;
        long j2;
        int iElapsedRealtime;
        if (this.zaa.zaD()) {
            RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) com.google.android.gms.common.internal.zah.getInstance().zaa;
            if (rootTelemetryConfiguration == null || rootTelemetryConfiguration.zzb) {
                zabq zabqVar = (zabq) this.zaa.zan.get(this.zac);
                if (zabqVar == null || !(zabqVar.zaf() instanceof BaseGmsClient)) {
                    return;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) zabqVar.zaf();
                int i5 = 0;
                boolean z = this.zad > 0;
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                int statusCode = 100;
                if (rootTelemetryConfiguration != null) {
                    z &= rootTelemetryConfiguration.zzc;
                    int i6 = rootTelemetryConfiguration.zzd;
                    int i7 = rootTelemetryConfiguration.zze;
                    i = rootTelemetryConfiguration.zza;
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration connectionTelemetryConfigurationZab = zab(zabqVar, baseGmsClient, this.zab);
                        if (connectionTelemetryConfigurationZab == null) {
                            return;
                        }
                        boolean z2 = connectionTelemetryConfigurationZab.zzc && this.zad > 0;
                        i7 = connectionTelemetryConfigurationZab.zze;
                        z = z2;
                    }
                    i3 = i6;
                    i2 = i7;
                } else {
                    i = 0;
                    i2 = 100;
                    i3 = 5000;
                }
                GoogleApiManager googleApiManager = this.zaa;
                if (task.isSuccessful()) {
                    i4 = 0;
                } else if (((zzw) task).zzd) {
                    i5 = statusCode;
                    i4 = -1;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        Status status = ((ApiException) exception).getStatus();
                        statusCode = status.getStatusCode();
                        ConnectionResult connectionResult = status.getConnectionResult();
                        if (connectionResult == null) {
                            i5 = statusCode;
                            i4 = -1;
                        } else {
                            i4 = connectionResult.zzb;
                            i5 = statusCode;
                        }
                    } else {
                        i5 = 101;
                        i4 = -1;
                    }
                }
                if (z) {
                    long j3 = this.zad;
                    long j4 = this.zae;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j4);
                    j2 = jCurrentTimeMillis;
                    j = j3;
                } else {
                    j = 0;
                    j2 = 0;
                    iElapsedRealtime = -1;
                }
                googleApiManager.getClass();
                zace zaceVar = new zace(new MethodInvocation(this.zab, i5, i4, j, j2, null, null, gCoreServiceId, iElapsedRealtime), i, i3, i2);
                com.google.android.gms.internal.base.zau zauVar = googleApiManager.zar;
                zauVar.sendMessage(zauVar.obtainMessage(18, zaceVar));
            }
        }
    }
}
