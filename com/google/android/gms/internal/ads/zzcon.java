package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzcon extends zzbav {
    private final zzcom zza;
    private final com.google.android.gms.ads.internal.client.zzbx zzb;
    private final zzexy zzc;
    private boolean zzd = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzaV)).booleanValue();
    private final zzdsj zze;

    public zzcon(zzcom zzcomVar, com.google.android.gms.ads.internal.client.zzbx zzbxVar, zzexy zzexyVar, zzdsj zzdsjVar) {
        this.zza = zzcomVar;
        this.zzb = zzbxVar;
        this.zzc = zzexyVar;
        this.zze = zzdsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final long zze() {
        zzcom zzcomVar = this.zza;
        if (zzcomVar == null || zzcomVar.zzl() == null) {
            return 0L;
        }
        return zzcomVar.zzl().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final com.google.android.gms.ads.internal.client.zzbx zzf() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final com.google.android.gms.ads.internal.client.zzea zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgW)).booleanValue()) {
            return this.zza.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final String zzh() {
        try {
            return this.zzb.zzs();
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzi(boolean z) {
        this.zzd = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzj(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!zzdtVar.zzf()) {
                    this.zze.zze();
                }
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Error in making CSI ping for reporting paid event callback", e);
            }
            this.zzc.zzn(zzdtVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzk(long j) {
        zzcom zzcomVar = this.zza;
        if (zzcomVar == null || zzcomVar.zzl() == null) {
            return;
        }
        zzcomVar.zzl().zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzl(IObjectWrapper iObjectWrapper, zzbbd zzbbdVar) {
        try {
            this.zzc.zzp(zzbbdVar);
            this.zza.zzd((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzbbdVar, this.zzd);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
