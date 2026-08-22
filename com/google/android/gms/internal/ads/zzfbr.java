package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzfbr extends zzbwu {
    private final zzfbn zza;
    private final zzfbd zzb;
    private final String zzc;
    private final zzfco zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private final zzavu zzg;
    private final zzdsj zzh;
    private zzdon zzi;
    private boolean zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzaS)).booleanValue();

    public zzfbr(String str, zzfbn zzfbnVar, Context context, zzfbd zzfbdVar, zzfco zzfcoVar, VersionInfoParcel versionInfoParcel, zzavu zzavuVar, zzdsj zzdsjVar) {
        this.zzc = str;
        this.zza = zzfbnVar;
        this.zzb = zzfbdVar;
        this.zzd = zzfcoVar;
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzg = zzavuVar;
        this.zzh = zzdsjVar;
    }

    private final synchronized void zzx(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbxc zzbxcVar, int i) {
        try {
            if (!zzmVar.zzb()) {
                boolean z = false;
                if (((Boolean) zzbfc.zzk.zze()).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                        z = true;
                    }
                }
                if (this.zzf.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlF)).intValue() || !z) {
                    com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
                }
            }
            zzfbd zzfbdVar = this.zzb;
            zzfbdVar.zzk(zzbxcVar);
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            if (com.google.android.gms.ads.internal.util.zzs.zzI(this.zze) && zzmVar.zzs == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to load the ad because app ID is missing.");
                zzfbdVar.zzdD(zzfdx.zzd(4, null, null));
                return;
            }
            if (this.zzi != null) {
                return;
            }
            zzfbf zzfbfVar = new zzfbf(null);
            zzfbn zzfbnVar = this.zza;
            zzfbnVar.zzj(i);
            zzfbnVar.zzb(zzmVar, this.zzc, zzfbfVar, new zzfbq(this));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final synchronized long zzb() {
        zzdon zzdonVar = this.zzi;
        if (zzdonVar == null || zzdonVar.zzl() == null) {
            return 0L;
        }
        return zzdonVar.zzl().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final Bundle zzc() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzdon zzdonVar = this.zzi;
        return zzdonVar != null ? zzdonVar.zza() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final com.google.android.gms.ads.internal.client.zzea zzd() {
        zzdon zzdonVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgW)).booleanValue() && (zzdonVar = this.zzi) != null) {
            return zzdonVar.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final zzbws zze() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzdon zzdonVar = this.zzi;
        if (zzdonVar != null) {
            return zzdonVar.zzc();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final String zzf() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final synchronized String zzg() {
        zzdon zzdonVar = this.zzi;
        if (zzdonVar == null || zzdonVar.zzm() == null) {
            return null;
        }
        return zzdonVar.zzm().zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbxc zzbxcVar) {
        zzx(zzmVar, zzbxcVar, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final synchronized void zzi(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbxc zzbxcVar) {
        zzx(zzmVar, zzbxcVar, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final synchronized void zzj(boolean z) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("setImmersiveMode must be called on the main UI thread.");
        this.zzj = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzk(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        if (zzdqVar == null) {
            this.zzb.zzg(null);
        } else {
            this.zzb.zzg(new zzfbp(this, zzdqVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzl(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdtVar.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzi(zzdtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final synchronized void zzm(long j) {
        zzdon zzdonVar = this.zzi;
        if (zzdonVar == null || zzdonVar.zzl() == null) {
            return;
        }
        zzdonVar.zzl().zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzn(zzbwy zzbwyVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        this.zzb.zzj(zzbwyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final synchronized void zzo(zzbxj zzbxjVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzfco zzfcoVar = this.zzd;
        zzfcoVar.zza = zzbxjVar.zza;
        zzfcoVar.zzb = zzbxjVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final synchronized void zzp(IObjectWrapper iObjectWrapper) {
        zzq(iObjectWrapper, this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final synchronized void zzq(IObjectWrapper iObjectWrapper, boolean z) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        if (this.zzi == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Rewarded can not be shown before loaded");
            this.zzb.zzs(zzfdx.zzd(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdd)).booleanValue()) {
                this.zzg.zzc().zzn(new Throwable().getStackTrace());
            }
            this.zzi.zzh(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final boolean zzr() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzdon zzdonVar = this.zzi;
        return (zzdonVar == null || zzdonVar.zzf()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzs(zzbxd zzbxdVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        this.zzb.zzo(zzbxdVar);
    }
}
