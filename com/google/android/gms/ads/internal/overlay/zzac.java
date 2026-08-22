package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.work.Worker;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzded;

/* JADX INFO: loaded from: classes.dex */
public final class zzac extends zzbtp implements zzazw {
    public final AdOverlayInfoParcel zza;
    public final Activity zzb;
    public final boolean zzf;
    public boolean zzc = false;
    public boolean zzd = false;
    public boolean zze = false;
    public boolean zzg = false;
    public boolean zzh = false;

    public zzac(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        zzc zzcVar;
        boolean z = false;
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
        zzbcv zzbcvVar = zzbde.zzeZ;
        zzbd zzbdVar = zzbd.zza;
        boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
        zzbdc zzbdcVar = zzbdVar.zzd;
        if ((zBooleanValue || ((Boolean) zzbdcVar.zzb(zzbde.zzfa)).booleanValue() || ((Boolean) zzbdcVar.zzb(zzbde.zzfe)).booleanValue()) && (zzcVar = adOverlayInfoParcel.zza) != null && zzcVar.zzj && Build.MANUFACTURER.matches((String) zzbdcVar.zzb(zzbde.zzfc)) && Build.MODEL.matches((String) zzbdcVar.zzb(zzbde.zzfd))) {
            z = true;
        }
        this.zzf = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final boolean zzH() {
        return ((Boolean) zzbd.zza.zzd.zzb(zzbde.zzfa)).booleanValue() && this.zzf && this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zza(boolean z) {
        if (!z) {
            this.zzh = true;
        } else if (this.zzh) {
            int i = zze.$r8$clinit;
            zzo.zze("Foregrounded: finishing activity from LauncherOverlay");
            this.zzb.finish();
        }
    }

    public final synchronized void zzc$1$1() {
        try {
            if (!this.zzd) {
                zzr zzrVar = this.zza.zzc;
                if (zzrVar != null) {
                    zzrVar.zzdw(4);
                }
                this.zzd = true;
                if (this.zzf) {
                    if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzfe)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzv.zza.zzh.zze(this);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzh(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzk(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzl(Bundle bundle) {
        zzr zzrVar;
        zzbcv zzbcvVar = zzbde.zzjn;
        zzbd zzbdVar = zzbd.zza;
        boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
        Activity activity = this.zzb;
        if (zBooleanValue && !this.zze) {
            activity.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        if (adOverlayInfoParcel == null) {
            activity.finish();
            return;
        }
        if (z) {
            activity.finish();
            return;
        }
        if (bundle == null) {
            zza zzaVar = adOverlayInfoParcel.zzb;
            if (zzaVar != null) {
                zzaVar.onAdClicked();
            }
            zzded zzdedVar = adOverlayInfoParcel.zzu;
            if (zzdedVar != null) {
                zzdedVar.zzdf();
            }
            if (activity.getIntent() != null && activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (zzrVar = adOverlayInfoParcel.zzc) != null) {
                zzrVar.zzdt();
            }
        }
        if (this.zzf) {
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzfe)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zza.zzh.zzc(this);
            }
        }
        GraphRequest.Companion companion = com.google.android.gms.ads.internal.zzv.zza.zzb;
        zzc zzcVar = adOverlayInfoParcel.zza;
        zzaa zzaaVar = zzcVar.zzi;
        zzad zzadVar = adOverlayInfoParcel.zzi;
        Activity activity2 = this.zzb;
        if (GraphRequest.Companion.zzb(activity2, zzcVar, zzadVar, zzaaVar, null, "")) {
            return;
        }
        activity2.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzm() {
        if (this.zzb.isFinishing()) {
            zzc$1$1();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzo() {
        this.zzg = false;
        zzr zzrVar = this.zza.zzc;
        if (zzrVar != null) {
            zzrVar.zzdk();
        }
        if (this.zzb.isFinishing()) {
            zzc$1$1();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzp(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzr() {
        if (this.zzc) {
            zze.zza("LauncherOverlay finishing activity");
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        this.zzg = true;
        zzr zzrVar = this.zza.zzc;
        if (zzrVar != null) {
            zzrVar.zzd();
        }
        if (this.zzf) {
            zzbcv zzbcvVar = zzbde.zzeZ;
            zzbd zzbdVar = zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Worker.AnonymousClass1(this, 25), ((Integer) zzbdVar.zzd.zzb(zzbde.zzfb)).intValue());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzt() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzu() {
        if (this.zzb.isFinishing()) {
            zzc$1$1();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzv() {
        zzr zzrVar = this.zza.zzc;
        if (zzrVar != null) {
            zzrVar.zzdv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzx() {
        this.zze = true;
    }
}
