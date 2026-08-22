package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.auth.IJ.gZrKCJ;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzdzv implements zzgdj {
    final /* synthetic */ zzbva zza;
    final /* synthetic */ zzbvj zzb;

    public zzdzv(zzeab zzeabVar, zzbvj zzbvjVar, zzbva zzbvaVar) {
        this.zzb = zzbvjVar;
        this.zza = zzbvaVar;
        Objects.requireNonNull(zzeabVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zzb.zzf((String) obj, this.zza);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Service can't call client", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        try {
            zzbvj zzbvjVar = this.zzb;
            com.google.android.gms.ads.internal.client.zze zzeVarZza = zzfdx.zza(th);
            zzbvjVar.zze(new com.google.android.gms.ads.internal.util.zzbb(zzfwg.zzd(th.getMessage()) ? zzeVarZza.zzb : th.getMessage(), zzeVarZza.zza));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb(gZrKCJ.bPqSN, e);
        }
    }
}
