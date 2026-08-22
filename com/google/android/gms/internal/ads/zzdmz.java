package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class zzdmz extends zzbmr implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbgb {
    private View zza;
    private com.google.android.gms.ads.internal.client.zzed zzb;
    private zzdio zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdmz(zzdio zzdioVar, zzdit zzditVar) {
        this.zza = zzditVar.zzf();
        this.zzb = zzditVar.zzj();
        this.zzc = zzdioVar;
        if (zzditVar.zzs() != null) {
            zzditVar.zzs().zzap(this);
        }
    }

    private final void zzg() {
        View view;
        zzdio zzdioVar = this.zzc;
        if (zzdioVar == null || (view = this.zza) == null) {
            return;
        }
        zzdioVar.zzC(view, Collections.emptyMap(), Collections.emptyMap(), zzdio.zzZ(this.zza));
    }

    private final void zzh() {
        View view = this.zza;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.zza);
        }
    }

    private static final void zzi(zzbmv zzbmvVar, int i) {
        try {
            zzbmvVar.zze(i);
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzg();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final com.google.android.gms.ads.internal.client.zzed zzb() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzg("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final zzbgm zzc() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdio zzdioVar = this.zzc;
        if (zzdioVar == null || zzdioVar.zzc() == null) {
            return null;
        }
        return zzdioVar.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final void zzd() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzh();
        zzdio zzdioVar = this.zzc;
        if (zzdioVar != null) {
            zzdioVar.zzb();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final void zze(IObjectWrapper iObjectWrapper) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzf(iObjectWrapper, new zzdmy(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final void zzf(IObjectWrapper iObjectWrapper, zzbmv zzbmvVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Instream ad can not be shown after destroy().");
            zzi(zzbmvVar, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            String str = view == null ? "can not get video view." : "can not get video controller.";
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Instream internal error: ".concat(str));
            zzi(zzbmvVar, 0);
            return;
        }
        if (this.zze) {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Instream ad should not be used again.");
            zzi(zzbmvVar, 1);
            return;
        }
        this.zze = true;
        zzh();
        ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
        zzcas zzcasVar = com.google.android.gms.ads.internal.zzv.zza.zzE;
        zzcas.zza(this.zza, this);
        zzcas.zzb(this.zza, this);
        zzg();
        try {
            zzbmvVar.zzf();
        } catch (RemoteException e) {
            int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
