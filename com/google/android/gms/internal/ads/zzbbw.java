package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbbw implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbbo zza;
    final /* synthetic */ zzcak zzb;
    final /* synthetic */ zzbby zzc;

    public zzbbw(zzbby zzbbyVar, zzbbo zzbboVar, zzcak zzcakVar) {
        this.zza = zzbboVar;
        this.zzb = zzcakVar;
        Objects.requireNonNull(zzbbyVar);
        this.zzc = zzbbyVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbby zzbbyVar = this.zzc;
        synchronized (zzbbyVar.zzd) {
            try {
                if (zzbbyVar.zzb) {
                    return;
                }
                zzbbyVar.zzb = true;
                final zzbbn zzbbnVar = zzbbyVar.zza;
                if (zzbbnVar == null) {
                    return;
                }
                zzgdy zzgdyVar = zzcaf.zza;
                final zzbbo zzbboVar = this.zza;
                final zzcak zzcakVar = this.zzb;
                final ListenableFuture listenableFutureZza = zzgdyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbt
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbbw zzbbwVar = this.zza;
                        zzbbn zzbbnVar2 = zzbbnVar;
                        zzcak zzcakVar2 = zzcakVar;
                        try {
                            zzbbq zzbbqVarZzq = zzbbnVar2.zzq();
                            boolean zZzp = zzbbnVar2.zzp();
                            zzbbo zzbboVar2 = zzbboVar;
                            zzbbl zzbblVarZzg = zZzp ? zzbbqVarZzq.zzg(zzbboVar2) : zzbbqVarZzq.zzf(zzbboVar2);
                            if (!zzbblVarZzg.zze()) {
                                zzcakVar2.zzd(new RuntimeException("No entry contents."));
                                zzbby.zze(zzbbwVar.zzc);
                                return;
                            }
                            zzbbv zzbbvVar = new zzbbv(zzbbwVar, zzbblVarZzg.zzc(), 1);
                            int i = zzbbvVar.read();
                            if (i == -1) {
                                throw new IOException("Unable to read from cache.");
                            }
                            zzbbvVar.unread(i);
                            zzcakVar2.zzc(zzbca.zzb(zzbbvVar, zzbblVarZzg.zzd(), zzbblVarZzg.zzg(), zzbblVarZzg.zza(), zzbblVarZzg.zzf()));
                        } catch (RemoteException e) {
                            e = e;
                            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to obtain a cache service instance.", e);
                            zzcakVar2.zzd(e);
                            zzbby.zze(zzbbwVar.zzc);
                        } catch (IOException e2) {
                            e = e2;
                            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to obtain a cache service instance.", e);
                            zzcakVar2.zzd(e);
                            zzbby.zze(zzbbwVar.zzc);
                        }
                    }
                });
                zzcakVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbu
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (zzcakVar.isCancelled()) {
                            listenableFutureZza.cancel(true);
                        }
                    }
                }, zzcaf.zzg);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
