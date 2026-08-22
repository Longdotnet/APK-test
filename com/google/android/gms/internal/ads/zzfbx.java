package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfbx extends zzbwe {
    private final zzfbn zza;
    private final zzfbd zzb;
    private final zzfco zzc;
    private zzdon zzd;
    private boolean zze = false;

    public zzfbx(zzfbn zzfbnVar, zzfbd zzfbdVar, zzfco zzfcoVar) {
        this.zza = zzfbnVar;
        this.zzb = zzfbdVar;
        this.zzc = zzfcoVar;
    }

    private final synchronized boolean zzy() {
        zzdon zzdonVar = this.zzd;
        return (zzdonVar == null || zzdonVar.zze()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final Bundle zzb() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("getAdMetadata can only be called from the UI thread.");
        zzdon zzdonVar = this.zzd;
        return zzdonVar != null ? zzdonVar.zza() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized com.google.android.gms.ads.internal.client.zzea zzc() {
        zzdon zzdonVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgW)).booleanValue() && (zzdonVar = this.zzd) != null) {
            return zzdonVar.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized String zzd() {
        zzdon zzdonVar = this.zzd;
        if (zzdonVar == null || zzdonVar.zzm() == null) {
            return null;
        }
        return zzdonVar.zzm().zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zze() {
        zzf(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzf(IObjectWrapper iObjectWrapper) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzb.zzg(null);
        if (this.zzd != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzn().zza(context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(com.google.android.gms.internal.ads.zzbde.zzfN)).booleanValue() == false) goto L18;
     */
    @Override // com.google.android.gms.internal.ads.zzbwf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzg(com.google.android.gms.internal.ads.zzbwj r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            java.lang.String r0 = androidx.work.impl.constraints.controllers.pST.ehgOP.Ncscr     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.common.internal.zzah.checkMainThread$1(r0)     // Catch: java.lang.Throwable -> L21
            java.lang.String r0 = r5.zzb     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.internal.ads.zzbcv r1 = com.google.android.gms.internal.ads.zzbde.zzfL     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.ads.internal.client.zzbd r2 = com.google.android.gms.ads.internal.client.zzbd.zza     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.internal.ads.zzbdc r2 = r2.zzd     // Catch: java.lang.Throwable -> L21
            java.lang.Object r1 = r2.zzb(r1)     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L2d
            if (r0 != 0) goto L1a
            goto L2d
        L1a:
            boolean r0 = java.util.regex.Pattern.matches(r1, r0)     // Catch: java.lang.Throwable -> L21 java.lang.RuntimeException -> L23
            if (r0 == 0) goto L2d
            goto L45
        L21:
            r5 = move-exception
            goto L63
        L23:
            r0 = move-exception
            java.lang.String r1 = "NonagonUtil.isPatternMatched"
            com.google.android.gms.ads.internal.zzv r2 = com.google.android.gms.ads.internal.zzv.zza     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.internal.ads.zzbzs r2 = r2.zzi     // Catch: java.lang.Throwable -> L21
            r2.zzw(r0, r1)     // Catch: java.lang.Throwable -> L21
        L2d:
            boolean r0 = r4.zzy()     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L47
            com.google.android.gms.internal.ads.zzbcv r0 = com.google.android.gms.internal.ads.zzbde.zzfN     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.ads.internal.client.zzbd r1 = com.google.android.gms.ads.internal.client.zzbd.zza     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.internal.ads.zzbdc r1 = r1.zzd     // Catch: java.lang.Throwable -> L21
            java.lang.Object r0 = r1.zzb(r0)     // Catch: java.lang.Throwable -> L21
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L21
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L21
            if (r0 != 0) goto L47
        L45:
            monitor-exit(r4)
            return
        L47:
            com.google.android.gms.internal.ads.zzfbf r0 = new com.google.android.gms.internal.ads.zzfbf     // Catch: java.lang.Throwable -> L21
            r1 = 0
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L21
            r4.zzd = r1     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.internal.ads.zzfbn r1 = r4.zza     // Catch: java.lang.Throwable -> L21
            r2 = 1
            r1.zzj(r2)     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.ads.internal.client.zzm r2 = r5.zza     // Catch: java.lang.Throwable -> L21
            java.lang.String r5 = r5.zzb     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.internal.ads.zzfbv r3 = new com.google.android.gms.internal.ads.zzfbv     // Catch: java.lang.Throwable -> L21
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L21
            r1.zzb(r2, r5, r0, r3)     // Catch: java.lang.Throwable -> L21
            monitor-exit(r4)
            return
        L63:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L21
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfbx.zzg(com.google.android.gms.internal.ads.zzbwj):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zzh() {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("pause must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzn().zzb(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zzj() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("resume must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzn().zzc(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zzl(com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("setAdMetadataListener can only be called from the UI thread.");
        if (zzcbVar == null) {
            this.zzb.zzg(null);
        } else {
            this.zzb.zzg(new zzfbw(this, zzcbVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzm(String str) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.: setCustomData");
        this.zzc.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzn(boolean z) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("setImmersiveMode must be called on the main UI thread.");
        this.zze = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zzo(zzbwi zzbwiVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzm(zzbwiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzp(String str) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("setUserId must be called on the main UI thread.");
        this.zzc.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzq() {
        zzr(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzr(IObjectWrapper iObjectWrapper) {
        try {
            com.google.android.gms.common.internal.zzah.checkMainThread$1("showAd must be called on the main UI thread.");
            if (this.zzd != null) {
                Activity activity = null;
                if (iObjectWrapper != null) {
                    Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
                    if (objUnwrap instanceof Activity) {
                        activity = (Activity) objUnwrap;
                    }
                }
                this.zzd.zzh(this.zze, activity);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final boolean zzs() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("isLoaded must be called on the main UI thread.");
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final boolean zzt() {
        zzdon zzdonVar = this.zzd;
        return zzdonVar != null && zzdonVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zzu(zzbwd zzbwdVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzn(zzbwdVar);
    }
}
