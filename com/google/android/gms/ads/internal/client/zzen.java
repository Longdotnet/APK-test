package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzazr;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbpm;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class zzen {
    public final zzem zza;
    public final zzbpm zzb;
    public final zzq zzc;
    public final VideoController zze;
    public zza zzf;
    public AdListener zzg;
    public AdSize[] zzh;
    public AppEventListener zzi;
    public zzbx zzj;
    public VideoOptions zzk;
    public String zzl;
    public final BaseAdView zzm;
    public boolean zzo;
    public OnPaidEventListener zzp;
    public final AtomicLong zzq;

    public zzen(BaseAdView baseAdView) {
        zzq zzqVar = zzq.zza;
        this.zzb = new zzbpm();
        this.zze = new VideoController();
        this.zza = new zzem(this);
        this.zzq = new AtomicLong();
        this.zzm = baseAdView;
        this.zzc = zzqVar;
        this.zzj = null;
        new AtomicBoolean(false);
    }

    public static zzr zzF(Context context, AdSize[] adSizeArr) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.INVALID)) {
                return new zzr("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false);
            }
        }
        zzr zzrVar = new zzr(context, adSizeArr);
        zzrVar.zzj = false;
        return zzrVar;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00d6 A[Catch: RemoteException -> 0x00d4, TRY_LEAVE, TryCatch #1 {RemoteException -> 0x00d4, blocks: (B:28:0x00a1, B:30:0x00a7, B:32:0x00b5, B:34:0x00c7, B:37:0x00d6), top: B:55:0x00a1, outer: #0 }] */
    public final void zzn(zzek zzekVar) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzbx zzbxVar = this.zzj;
            BaseAdView baseAdView = this.zzm;
            if (zzbxVar == null) {
                if (this.zzh == null || this.zzl == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = baseAdView.getContext();
                zzr zzrVarZzF = zzF(context, this.zzh);
                zzbx zzbxVar2 = "search_v2".equals(zzrVarZzF.zza) ? (zzbx) new zzan(zzbb.zzb.zzd, context, zzrVarZzF, this.zzl).zzd(context, false) : (zzbx) new zzal(zzbb.zzb.zzd, context, zzrVarZzF, this.zzl, this.zzb).zzd(context, false);
                this.zzj = zzbxVar2;
                zzbxVar2.zzE(new zzg(this.zza));
                zza zzaVar = this.zzf;
                if (zzaVar != null) {
                    this.zzj.zzD(new zzb(zzaVar));
                }
                AppEventListener appEventListener = this.zzi;
                if (appEventListener != null) {
                    this.zzj.zzH(new zzazr(appEventListener));
                }
                VideoOptions videoOptions = this.zzk;
                if (videoOptions != null) {
                    this.zzj.zzW(new zzgc(videoOptions));
                }
                this.zzj.zzQ(new zzfu(this.zzp));
                this.zzj.zzO(this.zzo);
                zzbx zzbxVar3 = this.zzj;
                if (zzbxVar3 != null) {
                    try {
                        IObjectWrapper iObjectWrapperZzo = zzbxVar3.zzo();
                        if (iObjectWrapperZzo != null) {
                            if (((Boolean) zzbfc.zzf.zze()).booleanValue()) {
                                if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                                    zzf.zza.post(new com.google.android.gms.ads.zza(this, iObjectWrapperZzo, 19));
                                } else {
                                    baseAdView.addView((View) ObjectWrapper.unwrap(iObjectWrapperZzo));
                                }
                            } else {
                                baseAdView.addView((View) ObjectWrapper.unwrap(iObjectWrapperZzo));
                            }
                        }
                    } catch (RemoteException e) {
                        zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
            zzekVar.zzn = jCurrentTimeMillis;
            zzbx zzbxVar4 = this.zzj;
            if (zzbxVar4 == null) {
                throw null;
            }
            AtomicLong atomicLong = this.zzq;
            if (atomicLong.get() != 0) {
                zzbxVar4.zzR(atomicLong.get());
            }
            zzq zzqVar = this.zzc;
            Context context2 = baseAdView.getContext();
            zzqVar.getClass();
            zzbxVar4.zzad(zzq.zza(context2, zzekVar));
        } catch (RemoteException e2) {
            zzo.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zzr(zza zzaVar) {
        try {
            this.zzf = zzaVar;
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzD(zzaVar != null ? new zzb(zzaVar) : null);
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzu(AdSize... adSizeArr) {
        BaseAdView baseAdView = this.zzm;
        this.zzh = adSizeArr;
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzG(zzF(baseAdView.getContext(), this.zzh));
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
        baseAdView.requestLayout();
    }

    public final void zzw(AppEventListener appEventListener) {
        try {
            this.zzi = appEventListener;
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzH(appEventListener != null ? new zzazr(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
