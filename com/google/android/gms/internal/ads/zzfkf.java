package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkf extends zzfld {
    public zzfkf(ClientApi clientApi, Context context, int i, zzbpq zzbpqVar, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfkg zzfkgVar, Clock clock) {
        super(clientApi, context, i, zzbpqVar, zzfvVar, zzceVar, scheduledExecutorService, zzfkgVar, clock);
    }

    @Override // com.google.android.gms.internal.ads.zzfld
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzea zza(Object obj) {
        try {
            return ((zzbaw) obj).zzg();
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get response info for the app open ad.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfld
    public final ListenableFuture zzb(Context context) {
        zzgeh zzgehVarZze = zzgeh.zze();
        com.google.android.gms.ads.internal.client.zzbx zzbxVarZzc = this.zza.zzc(new ObjectWrapper(context), com.google.android.gms.ads.internal.client.zzr.zzb(), this.zze.zza, this.zzd, this.zzc);
        if (zzbxVarZzc != null) {
            try {
                zzbxVarZzc.zzI(new zzfke(this, zzgehVarZze, this.zze));
                zzbxVarZzc.zzad(this.zze.zzc);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to load app open ad.", e);
                zzgehVarZze.zzd(new zzfka(1, "remote exception"));
            }
        } else {
            zzgehVarZze.zzd(new zzfka(1, "Failed to create an app open ad manager."));
        }
        return zzgehVarZze;
    }

    public zzfkf(String str, ClientApi clientApi, Context context, int i, zzbpq zzbpqVar, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzch zzchVar, ScheduledExecutorService scheduledExecutorService, zzfkg zzfkgVar, Clock clock) {
        super(str, clientApi, context, i, zzbpqVar, zzfvVar, zzchVar, scheduledExecutorService, zzfkgVar, clock);
    }
}
