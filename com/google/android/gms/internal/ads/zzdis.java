package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzdis extends com.google.android.gms.ads.internal.client.zzec {
    private final Object zza = new Object();
    private final com.google.android.gms.ads.internal.client.zzed zzb;
    private final zzbqf zzc;

    public zzdis(com.google.android.gms.ads.internal.client.zzed zzedVar, zzbqf zzbqfVar) {
        this.zzb = zzedVar;
        this.zzc = zzbqfVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzf() {
        zzbqf zzbqfVar = this.zzc;
        if (zzbqfVar != null) {
            return zzbqfVar.zzg();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzg() {
        zzbqf zzbqfVar = this.zzc;
        if (zzbqfVar != null) {
            return zzbqfVar.zzh();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final com.google.android.gms.ads.internal.client.zzeg zzi() {
        synchronized (this.zza) {
            try {
                com.google.android.gms.ads.internal.client.zzed zzedVar = this.zzb;
                if (zzedVar == null) {
                    return null;
                }
                return zzedVar.zzi();
            } catch (Throwable th) {
                throw th;
            }
        }
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
            try {
                com.google.android.gms.ads.internal.client.zzed zzedVar = this.zzb;
                if (zzedVar != null) {
                    zzedVar.zzm(zzegVar);
                }
            } catch (Throwable th) {
                throw th;
            }
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
