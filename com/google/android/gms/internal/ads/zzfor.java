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
final class zzfor implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfpn zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzfoi zzf;
    private final long zzg;
    private final int zzh;

    public zzfor(Context context, int i, int i2, String str, String str2, String str3, zzfoi zzfoiVar) {
        this.zzb = str;
        this.zzh = i2;
        this.zzc = str2;
        this.zzf = zzfoiVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        this.zzg = System.currentTimeMillis();
        zzfpn zzfpnVar = new zzfpn(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfpnVar;
        this.zzd = new LinkedBlockingQueue();
        zzfpnVar.checkAvailabilityAndConnect();
    }

    private final void zzd(int i, long j, Exception exc) {
        this.zzf.zzc(i, System.currentTimeMillis() - j, exc);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfps zzfpsVarZzc = zzc();
        if (zzfpsVarZzc != null) {
            try {
                zzfpz zzfpzVarZzf = zzfpsVarZzc.zzf(new zzfpx(1, this.zzh, this.zzb, this.zzc));
                zzd(5011, this.zzg, null);
                this.zzd.put(zzfpzVarZzf);
            } catch (Throwable th) {
                try {
                    zzd(2010, this.zzg, new Exception(th));
                } finally {
                    zzb();
                    this.zze.quit();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzd(4012, this.zzg, null);
            this.zzd.put(new zzfpz(null, 1));
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            zzd(4011, this.zzg, null);
            this.zzd.put(new zzfpz(null, 1));
        } catch (InterruptedException unused) {
        }
    }

    public final zzfpz zza(int i) {
        zzfpz zzfpzVar;
        try {
            zzfpzVar = (zzfpz) this.zzd.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzd(2009, this.zzg, e);
            zzfpzVar = null;
        }
        zzd(3004, this.zzg, null);
        if (zzfpzVar != null) {
            if (zzfpzVar.zzc == 7) {
                zzfoi.zzg(3);
            } else {
                zzfoi.zzg(2);
            }
        }
        return zzfpzVar == null ? new zzfpz(null, 1) : zzfpzVar;
    }

    public final void zzb() {
        zzfpn zzfpnVar = this.zza;
        if (zzfpnVar != null) {
            if (zzfpnVar.isConnected() || zzfpnVar.isConnecting()) {
                zzfpnVar.disconnect();
            }
        }
    }

    public final zzfps zzc() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
