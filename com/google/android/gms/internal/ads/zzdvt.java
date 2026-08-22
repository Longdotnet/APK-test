package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdvt implements com.google.android.gms.ads.internal.overlay.zzr, zzcgw {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private zzdvi zzc;
    private zzcfg zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private com.google.android.gms.ads.internal.client.zzdn zzh;
    private boolean zzi;

    public zzdvt(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = versionInfoParcel;
    }

    private final synchronized boolean zzl(com.google.android.gms.ads.internal.client.zzdn zzdnVar) {
        zzbcv zzbcvVar = zzbde.zzjp;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Ad inspector had an internal error.");
            try {
                zzdnVar.zze(zzfdx.zzd(16, null, null));
            } catch (RemoteException unused) {
            }
            return false;
        }
        if (this.zzc == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Ad inspector had an internal error.");
            try {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(new NullPointerException("InspectorManager null"), "InspectorUi.shouldOpenUi");
                zzdnVar.zze(zzfdx.zzd(16, null, null));
            } catch (RemoteException unused2) {
            }
            return false;
        }
        if (!this.zze && !this.zzf) {
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            if (System.currentTimeMillis() >= this.zzg + ((long) ((Integer) zzbdVar.zzd.zzb(zzbde.zzjs)).intValue())) {
                return true;
            }
        }
        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Ad inspector cannot be opened because it is already open.");
        try {
            zzdnVar.zze(zzfdx.zzd(19, null, null));
        } catch (RemoteException unused3) {
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgw
    public final synchronized void zza(boolean z, int i, String str, String str2) {
        if (z) {
            com.google.android.gms.ads.internal.util.zze.zza("Ad inspector loaded.");
            this.zze = true;
            zzk();
            return;
        }
        int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Ad inspector failed to load.");
        try {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(new Exception("Failed to load UI. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2), "InspectorUi.onAdWebViewFinishedLoading 0");
            com.google.android.gms.ads.internal.client.zzdn zzdnVar = this.zzh;
            if (zzdnVar != null) {
                zzdnVar.zze(zzfdx.zzd(17, null, null));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "InspectorUi.onAdWebViewFinishedLoading 1");
        }
        this.zzi = true;
        this.zzd.destroy();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzd() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdk() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdt() {
        this.zzf = true;
        zzk();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdw(int i) {
        this.zzd.destroy();
        if (!this.zzi) {
            com.google.android.gms.ads.internal.util.zze.zza("Inspector closed.");
            com.google.android.gms.ads.internal.client.zzdn zzdnVar = this.zzh;
            if (zzdnVar != null) {
                try {
                    zzdnVar.zze(null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0L;
        this.zzi = false;
        this.zzh = null;
    }

    public final Activity zzg() {
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar == null || zzcfgVar.zzaE()) {
            return null;
        }
        return this.zzd.zzi();
    }

    public final void zzi(zzdvi zzdviVar) {
        this.zzc = zzdviVar;
    }

    public final synchronized void zzk() {
        if (this.zze && this.zzf) {
            zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdvs
                @Override // java.lang.Runnable
                public final void run() {
                    zzdvt zzdvtVar = this.zza;
                    zzdvtVar.zzd.zzb("window.inspectorInfo", zzdvtVar.zzc.zze().toString());
                }
            });
        }
    }

    public final synchronized void zzj(com.google.android.gms.ads.internal.client.zzdn zzdnVar, zzbkz zzbkzVar, zzbks zzbksVar, zzbkg zzbkgVar) {
        if (zzl(zzdnVar)) {
            try {
                com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
                zzcft zzcftVar = zzvVar.zze;
                zzcfg zzcfgVarZza = zzcft.zza(this.zza, zzchd.zza(), "", false, false, null, null, this.zzb, null, null, null, zzbcc.zza(), null, null, null, null, null);
                this.zzd = zzcfgVarZza;
                zzcgy zzcgyVarZzN = zzcfgVarZza.zzN();
                if (zzcgyVarZzN == null) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to obtain a web view for the ad inspector");
                    try {
                        zzvVar.zzi.zzw(new NullPointerException("Failed to obtain a web view for the ad inspector"), "InspectorUi.openInspector 2");
                        zzdnVar.zze(zzfdx.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                        return;
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, ehgOP.BzAOPaDjH);
                        return;
                    }
                }
                this.zzh = zzdnVar;
                Context context = this.zza;
                zzcgyVarZzN.zzX(null, null, null, null, null, false, null, null, null, null, null, null, null, zzbkzVar, null, new zzbky(context), zzbksVar, zzbkgVar, null);
                zzcgyVarZzN.zzC(this);
                this.zzd.loadUrl((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjq));
                GraphRequest.Companion.zza(context, new AdOverlayInfoParcel(this, this.zzd, this.zzb), true, null);
                zzvVar.zzl.getClass();
                this.zzg = System.currentTimeMillis();
            } catch (zzcfs e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to obtain a web view for the ad inspector", e2);
                try {
                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e2, "InspectorUi.openInspector 0");
                    zzdnVar.zze(zzfdx.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                } catch (RemoteException e3) {
                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e3, "InspectorUi.openInspector 1");
                }
            }
        }
    }
}
