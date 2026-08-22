package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class zzcbq {
    private final Context zza;
    private final zzccb zzb;
    private final ViewGroup zzc;
    private final zzdsj zzd;
    private zzcbp zze;

    public zzcbq(Context context, ViewGroup viewGroup, zzcfg zzcfgVar, zzdsj zzdsjVar) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcfgVar;
        this.zze = null;
        this.zzd = zzdsjVar;
    }

    public final zzcbp zza() {
        return this.zze;
    }

    public final Integer zzb() {
        zzcbp zzcbpVar = this.zze;
        if (zzcbpVar != null) {
            return zzcbpVar.zzl();
        }
        return null;
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("The underlay may only be modified from the UI thread.");
        zzcbp zzcbpVar = this.zze;
        if (zzcbpVar != null) {
            zzcbpVar.zzF(i, i2, i3, i4);
        }
    }

    public final void zzd(int i, int i2, int i3, int i4, int i5, boolean z, zzcca zzccaVar) {
        if (this.zze != null) {
            return;
        }
        zzccb zzccbVar = this.zzb;
        zzbdl.zza(zzccbVar.zzl().zza(), zzccbVar.zzk(), "vpr2");
        zzcbp zzcbpVar = new zzcbp(this.zza, zzccbVar, i5, z, zzccbVar.zzl().zza(), zzccaVar, this.zzd);
        this.zze = zzcbpVar;
        this.zzc.addView(zzcbpVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zze.zzF(i, i2, i3, i4);
        zzccbVar.zzz(false);
    }

    public final void zze() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("onDestroy must be called from the UI thread.");
        zzcbp zzcbpVar = this.zze;
        if (zzcbpVar != null) {
            zzcbpVar.zzq();
            this.zzc.removeView(this.zze);
            this.zze = null;
        }
    }

    public final void zzf() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("onPause must be called from the UI thread.");
        zzcbp zzcbpVar = this.zze;
        if (zzcbpVar != null) {
            zzcbpVar.zzu();
        }
    }

    public final void zzg(int i) {
        zzcbp zzcbpVar = this.zze;
        if (zzcbpVar != null) {
            zzcbpVar.zzC(i);
        }
    }
}
