package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzfop implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfpn zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;

    public zzfop(Context context, String str, String str2) {
        this.zzb = str;
        this.zzc = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzfpn zzfpnVar = new zzfpn(context, handlerThread.getLooper(), this, this, 9200000);
        this.zza = zzfpnVar;
        this.zzd = new LinkedBlockingQueue();
        zzfpnVar.checkAvailabilityAndConnect();
    }

    public static zzatq zza() {
        zzast zzastVarZza = zzatq.zza();
        zzastVarZza.zzB(32768L);
        return (zzatq) zzastVarZza.zzbr();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfps zzfpsVarZzd = zzd();
        if (zzfpsVarZzd != null) {
            try {
                try {
                    this.zzd.put(zzfpsVarZzd.zze(new zzfpo(this.zzb, this.zzc)).zza());
                } catch (InterruptedException unused) {
                } finally {
                    zzc();
                    this.zze.quit();
                }
            } catch (Throwable unused2) {
                this.zzd.put(zza());
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzatq zzb(int i) {
        zzatq zzatqVar;
        try {
            zzatqVar = (zzatq) this.zzd.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzatqVar = null;
        }
        return zzatqVar == null ? zza() : zzatqVar;
    }

    public final void zzc() {
        zzfpn zzfpnVar = this.zza;
        if (zzfpnVar != null) {
            if (zzfpnVar.isConnected() || zzfpnVar.isConnecting()) {
                zzfpnVar.disconnect();
            }
        }
    }

    public final zzfps zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
