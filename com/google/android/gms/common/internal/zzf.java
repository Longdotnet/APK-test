package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class zzf extends zza {
    public final IBinder zze;
    public final /* synthetic */ BaseGmsClient zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(BaseGmsClient baseGmsClient, int i, IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i, bundle);
        this.zzf = baseGmsClient;
        this.zze = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.zzf;
        if (baseGmsClient.zzx != null) {
            baseGmsClient.zzx.onConnectionFailed(connectionResult);
        }
        baseGmsClient.onConnectionFailed(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        IBinder iBinder = this.zze;
        try {
            zzah.checkNotNull(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            BaseGmsClient baseGmsClient = this.zzf;
            if (!baseGmsClient.getServiceDescriptor().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + baseGmsClient.getServiceDescriptor() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceCreateServiceInterface = baseGmsClient.createServiceInterface(iBinder);
            if (iInterfaceCreateServiceInterface == null || !(BaseGmsClient.zzn(baseGmsClient, 2, 4, iInterfaceCreateServiceInterface) || BaseGmsClient.zzn(baseGmsClient, 3, 4, iInterfaceCreateServiceInterface))) {
                return false;
            }
            baseGmsClient.zzB = null;
            Bundle connectionHint = baseGmsClient.getConnectionHint();
            if (baseGmsClient.zzw == null) {
                return true;
            }
            baseGmsClient.zzw.onConnected(connectionHint);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
