package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.stats.ConnectionTracker;

/* JADX INFO: loaded from: classes.dex */
public final class zzjl implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    public final /* synthetic */ zzjm zza;
    public volatile boolean zzb;
    public volatile zzed zzc;

    public zzjl(zzjm zzjmVar) {
        this.zza = zzjmVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                com.google.android.gms.common.internal.zzah.checkNotNull(this.zzc);
                zzdx zzdxVar = (zzdx) this.zzc.getService();
                zzfo zzfoVar = ((zzfr) this.zza.mBuilder).zzn;
                zzfr.zzR(zzfoVar);
                zzfoVar.zzp(new zzjg(this, zzdxVar, 1));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("MeasurementServiceConnection.onConnectionFailed");
        zzeh zzehVar = ((zzfr) this.zza.mBuilder).zzm;
        if (zzehVar == null || !((zzgl) zzehVar).zza) {
            zzehVar = null;
        }
        if (zzehVar != null) {
            zzehVar.zzg.zzb(connectionResult, "Service connection failed");
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        zzfo zzfoVar = ((zzfr) this.zza.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzjj(this, 1));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("MeasurementServiceConnection.onConnectionSuspended");
        zzjm zzjmVar = this.zza;
        zzeh zzehVar = ((zzfr) zzjmVar.mBuilder).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zza("Service connection suspended");
        zzfo zzfoVar = ((zzfr) zzjmVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzjj(this, 0));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zzb = false;
                zzeh zzehVar = ((zzfr) this.zza.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zza("Service connected with null binder");
                return;
            }
            zzdx zzdvVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    zzdvVar = iInterfaceQueryLocalInterface instanceof zzdx ? (zzdx) iInterfaceQueryLocalInterface : new zzdv(iBinder);
                    zzeh zzehVar2 = ((zzfr) this.zza.mBuilder).zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzl.zza("Bound to IMeasurementService interface");
                } else {
                    zzeh zzehVar3 = ((zzfr) this.zza.mBuilder).zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zzb(interfaceDescriptor, "Got binder with a wrong descriptor");
                }
            } catch (RemoteException unused) {
                zzeh zzehVar4 = ((zzfr) this.zza.mBuilder).zzm;
                zzfr.zzR(zzehVar4);
                zzehVar4.zzd.zza("Service connect failed to get IMeasurementService");
            }
            if (zzdvVar == null) {
                this.zzb = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    zzjm zzjmVar = this.zza;
                    connectionTracker.unbindService(((zzfr) zzjmVar.mBuilder).zze, zzjmVar.zza);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                zzfo zzfoVar = ((zzfr) this.zza.mBuilder).zzn;
                zzfr.zzR(zzfoVar);
                zzfoVar.zzp(new zzjg(this, zzdvVar, 0));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("MeasurementServiceConnection.onServiceDisconnected");
        zzjm zzjmVar = this.zza;
        zzeh zzehVar = ((zzfr) zzjmVar.mBuilder).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zza("Service disconnected");
        zzfo zzfoVar = ((zzfr) zzjmVar.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new com.google.android.gms.tasks.zzc(this, componentName, 6));
    }

    public final void zzc() {
        this.zza.zzg();
        Context context = ((zzfr) this.zza.mBuilder).zze;
        synchronized (this) {
            try {
                if (this.zzb) {
                    zzeh zzehVar = ((zzfr) this.zza.mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzl.zza("Connection attempt already in progress");
                } else {
                    if (this.zzc != null && (this.zzc.isConnecting() || this.zzc.isConnected())) {
                        zzeh zzehVar2 = ((zzfr) this.zza.mBuilder).zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzl.zza("Already awaiting connection attempt");
                        return;
                    }
                    this.zzc = new zzed(context, Looper.getMainLooper(), this, this, 93);
                    zzeh zzehVar3 = ((zzfr) this.zza.mBuilder).zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzl.zza("Connecting to remote service");
                    this.zzb = true;
                    com.google.android.gms.common.internal.zzah.checkNotNull(this.zzc);
                    this.zzc.checkAvailabilityAndConnect();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
