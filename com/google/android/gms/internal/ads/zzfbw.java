package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfbw implements OnAdMetadataChangedListener {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzcb zza;
    final /* synthetic */ zzfbx zzb;

    public zzfbw(zzfbx zzfbxVar, com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        this.zza = zzcbVar;
        Objects.requireNonNull(zzfbxVar);
        this.zzb = zzfbxVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        if (this.zzb.zzd != null) {
            try {
                com.google.android.gms.ads.internal.client.zzbz zzbzVar = (com.google.android.gms.ads.internal.client.zzbz) this.zza;
                zzbzVar.zzdb(1, zzbzVar.zza());
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
