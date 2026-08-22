package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzbqg extends com.google.android.gms.ads.internal.client.zzec {
    private final Object zza = new Object();
    private volatile com.google.android.gms.ads.internal.client.zzeg zzb;

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzf() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzg() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final com.google.android.gms.ads.internal.client.zzeg zzi() {
        com.google.android.gms.ads.internal.client.zzeg zzegVar;
        synchronized (this.zza) {
            zzegVar = this.zzb;
        }
        return zzegVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzj(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzk() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzm(com.google.android.gms.ads.internal.client.zzeg zzegVar) {
        synchronized (this.zza) {
            this.zzb = zzegVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzn() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzo() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzq() throws RemoteException {
        throw new RemoteException();
    }
}
