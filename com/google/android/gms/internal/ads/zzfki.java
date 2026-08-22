package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzfki extends zzfld {
    public zzfki(ClientApi clientApi, Context context, int i, zzbpq zzbpqVar, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfkg zzfkgVar, Clock clock) {
        super(clientApi, context, i, zzbpqVar, zzfvVar, zzceVar, scheduledExecutorService, zzfkgVar, clock);
    }

    @Override // com.google.android.gms.internal.ads.zzfld
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzea zza(Object obj) {
        try {
            return ((com.google.android.gms.ads.internal.client.zzbx) obj).zzl();
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get response info for  the interstitial ad.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfld
    public final ListenableFuture zzb(Context context) {
        zzgeh zzgehVarZze = zzgeh.zze();
        com.google.android.gms.ads.internal.client.zzbx zzbxVarZze = this.zza.zze(new ObjectWrapper(context), new com.google.android.gms.ads.internal.client.zzr(), this.zze.zza, this.zzd, this.zzc);
        if (zzbxVarZze != null) {
            try {
                zzbxVarZze.zzz(this.zze.zzc, new zzfkh(this, zzgehVarZze, zzbxVarZze));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to load interstitial ad.", e);
                zzgehVarZze.zzd(new zzfka(1, "remote exception"));
            }
        } else {
            zzgehVarZze.zzd(new zzfka(1, "Failed to create an interstitial ad manager."));
        }
        return zzgehVarZze;
    }

    public zzfki(String str, ClientApi clientApi, Context context, int i, zzbpq zzbpqVar, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzch zzchVar, ScheduledExecutorService scheduledExecutorService, zzfkg zzfkgVar, Clock clock) {
        super(str, clientApi, context, i, zzbpqVar, zzfvVar, zzchVar, scheduledExecutorService, zzfkgVar, clock);
    }
}
