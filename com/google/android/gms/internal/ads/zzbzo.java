package com.google.android.gms.internal.ads;

import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzbzo extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzbzs zza;

    public zzbzo(zzbzs zzbzsVar) {
        Objects.requireNonNull(zzbzsVar);
        this.zza = zzbzsVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        zzbzs zzbzsVar = this.zza;
        zzbdh zzbdhVar = new zzbdh(zzbzsVar.zze, zzbzsVar.zzf.afmaVersion);
        synchronized (zzbzsVar.zza) {
            try {
                zzbdk zzbdkVar = com.google.android.gms.ads.internal.zzv.zza.zzn;
                zzbdk.zza(zzbzsVar.zzh, zzbdhVar);
            } catch (IllegalArgumentException e) {
                String str = JrbhsraGtto.YEjxuZ;
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk(str, e);
            }
        }
    }
}
