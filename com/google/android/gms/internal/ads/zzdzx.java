package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdzx implements zzgdj {
    final /* synthetic */ zzbvq zza;
    final /* synthetic */ zzbvi zzb;

    public zzdzx(zzeab zzeabVar, zzbvq zzbvqVar, zzbvi zzbviVar) {
        this.zza = zzbvqVar;
        this.zzb = zzbviVar;
        Objects.requireNonNull(zzeabVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        try {
            zzbvi zzbviVar = this.zzb;
            com.google.android.gms.ads.internal.client.zze zzeVarZza = zzfdx.zza(th);
            zzbviVar.zze(new com.google.android.gms.ads.internal.util.zzbb(zzfwg.zzd(th.getMessage()) ? zzeVarZza.zzb : th.getMessage(), zzeVarZza.zza));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Service can't call client", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        Bundle bundle;
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        try {
            zzbcv zzbcvVar = zzbde.zzcq;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                this.zzb.zzf(parcelFileDescriptor);
                return;
            }
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzcr)).booleanValue() && (bundle = this.zza.zzm) != null) {
                String strZza = zzdrr.BINDER_CALL_START.zza();
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                bundle.putLong(strZza, System.currentTimeMillis());
            }
            this.zzb.zzg(parcelFileDescriptor, this.zza);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Service can't call client", e);
        }
    }
}
