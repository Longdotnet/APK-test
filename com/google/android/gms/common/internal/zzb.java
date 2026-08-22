package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.common.zzi;

/* JADX INFO: loaded from: classes.dex */
public final class zzb extends zzi {
    public final /* synthetic */ BaseGmsClient zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        this.zza = baseGmsClient;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        if (this.zza.zzd.get() != message.arg1) {
            int i = message.what;
            if (i == 2 || i == 1 || i == 7) {
                zza zzaVar = (zza) message.obj;
                zzaVar.getClass();
                zzaVar.zzg();
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !this.zza.enableLocalFallback()) || message.what == 5)) && !this.zza.isConnecting()) {
            zza zzaVar2 = (zza) message.obj;
            zzaVar2.getClass();
            zzaVar2.zzg();
            return;
        }
        int i3 = message.what;
        if (i3 == 4) {
            this.zza.zzB = new ConnectionResult(message.arg2);
            if (BaseGmsClient.zzo(this.zza)) {
                BaseGmsClient baseGmsClient = this.zza;
                if (!baseGmsClient.zzC) {
                    baseGmsClient.zzp(3, null);
                    return;
                }
            }
            BaseGmsClient baseGmsClient2 = this.zza;
            ConnectionResult connectionResult = baseGmsClient2.zzB != null ? baseGmsClient2.zzB : new ConnectionResult(8);
            this.zza.zzc.onReportServiceBinding(connectionResult);
            this.zza.onConnectionFailed(connectionResult);
            return;
        }
        if (i3 == 5) {
            BaseGmsClient baseGmsClient3 = this.zza;
            ConnectionResult connectionResult2 = baseGmsClient3.zzB != null ? baseGmsClient3.zzB : new ConnectionResult(8);
            this.zza.zzc.onReportServiceBinding(connectionResult2);
            this.zza.onConnectionFailed(connectionResult2);
            return;
        }
        if (i3 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.zza.zzc.onReportServiceBinding(connectionResult3);
            this.zza.onConnectionFailed(connectionResult3);
            return;
        }
        if (i3 == 6) {
            this.zza.zzp(5, null);
            BaseGmsClient baseGmsClient4 = this.zza;
            if (baseGmsClient4.zzw != null) {
                baseGmsClient4.zzw.onConnectionSuspended(message.arg2);
            }
            this.zza.onConnectionSuspended(message.arg2);
            BaseGmsClient.zzn(this.zza, 5, 1, null);
            return;
        }
        if (i3 == 2 && !this.zza.isConnected()) {
            zza zzaVar3 = (zza) message.obj;
            zzaVar3.getClass();
            zzaVar3.zzg();
            return;
        }
        int i4 = message.what;
        if (i4 != 2 && i4 != 1 && i4 != 7) {
            Log.wtf("GmsClient", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i4, "Don't know how to handle message: "), new Exception());
            return;
        }
        zza zzaVar4 = (zza) message.obj;
        synchronized (zzaVar4) {
            try {
                bool = zzaVar4.zza$1;
                if (zzaVar4.zzb$1) {
                    Log.w("GmsClient", "Callback proxy " + zzaVar4.toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            BaseGmsClient baseGmsClient5 = zzaVar4.zzc;
            int i5 = zzaVar4.zza;
            if (i5 != 0) {
                baseGmsClient5.zzp(1, null);
                Bundle bundle = zzaVar4.zzb;
                zzaVar4.zzb(new ConnectionResult(i5, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
            } else if (!zzaVar4.zzd()) {
                baseGmsClient5.zzp(1, null);
                zzaVar4.zzb(new ConnectionResult(8, null));
            }
        }
        synchronized (zzaVar4) {
            zzaVar4.zzb$1 = true;
        }
        zzaVar4.zzg();
    }
}
