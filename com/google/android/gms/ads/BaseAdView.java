package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzem;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.client.zzfu;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAdView extends ViewGroup {
    public final zzen zza;

    public BaseAdView(Context context) {
        super(context);
        this.zza = new zzen(this);
    }

    public final void destroy() {
        zzbde.zza(getContext());
        if (((Boolean) zzbfc.zze.zze()).booleanValue()) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlB)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new zzd(this, 1));
                return;
            }
        }
        zzen zzenVar = this.zza;
        zzenVar.getClass();
        try {
            zzbx zzbxVar = zzenVar.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzy();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public AdListener getAdListener() {
        return this.zza.zzg;
    }

    public AdSize getAdSize() {
        zzr zzrVarZzh;
        zzen zzenVar = this.zza;
        zzenVar.getClass();
        try {
            zzbx zzbxVar = zzenVar.zzj;
            if (zzbxVar != null && (zzrVarZzh = zzbxVar.zzh()) != null) {
                return new AdSize(zzrVarZzh.zze, zzrVarZzh.zzb, zzrVarZzh.zza);
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = zzenVar.zzh;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public String getAdUnitId() {
        zzbx zzbxVar;
        zzen zzenVar = this.zza;
        if (zzenVar.zzl == null && (zzbxVar = zzenVar.zzj) != null) {
            try {
                zzenVar.zzl = zzbxVar.zzs();
            } catch (RemoteException e) {
                zzo.zzl("#007 Could not call remote method.", e);
            }
        }
        return zzenVar.zzl;
    }

    public OnPaidEventListener getOnPaidEventListener() {
        return this.zza.zzp;
    }

    public long getPlacementId() {
        zzen zzenVar = this.zza;
        AtomicLong atomicLong = zzenVar.zzq;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        try {
            zzbx zzbxVar = zzenVar.zzj;
            if (zzbxVar == null) {
                return 0L;
            }
            atomicLong.set(zzbxVar.zzc());
            return atomicLong.get();
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            return 0L;
        }
    }

    public ResponseInfo getResponseInfo() {
        zzea zzeaVarZzl;
        zzen zzenVar = this.zza;
        zzenVar.getClass();
        try {
            zzbx zzbxVar = zzenVar.zzj;
            zzeaVarZzl = zzbxVar != null ? zzbxVar.zzl() : null;
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
        if (zzeaVarZzl != null) {
            return new ResponseInfo(zzeaVarZzl);
        }
        return null;
    }

    public final void loadAd(AdRequest adRequest) {
        zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        zzbde.zza(getContext());
        if (((Boolean) zzbfc.zzf.zze()).booleanValue()) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new zza(this, adRequest, 26));
                return;
            }
        }
        this.zza.zzn(adRequest.zza);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        AdSize adSize;
        int heightInPixels;
        int iZzC;
        int measuredWidth = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzo.zzh("Unable to retrieve ad size.", e);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int i3 = adSize.zzb;
                if (i3 == -3) {
                    iZzC = -1;
                } else if (i3 != -1) {
                    zzf zzfVar = zzbb.zzb.zzc;
                    iZzC = zzf.zzC(context, i3);
                } else {
                    iZzC = context.getResources().getDisplayMetrics().widthPixels;
                }
                heightInPixels = adSize.getHeightInPixels(context);
                measuredWidth = iZzC;
            } else {
                heightInPixels = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            measuredWidth = childAt.getMeasuredWidth();
            heightInPixels = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(heightInPixels, getSuggestedMinimumHeight()), i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        zzen zzenVar = this.zza;
        zzenVar.zzg = adListener;
        zzem zzemVar = zzenVar.zza;
        synchronized (zzemVar.zza$1) {
            zzemVar.zzb = adListener;
        }
        if (adListener == 0) {
            zzenVar.zzr(null);
            return;
        }
        if (adListener instanceof com.google.android.gms.ads.internal.client.zza) {
            zzenVar.zzr((com.google.android.gms.ads.internal.client.zza) adListener);
        }
        if (adListener instanceof AppEventListener) {
            zzenVar.zzw((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        AdSize[] adSizeArr = {adSize};
        zzen zzenVar = this.zza;
        if (zzenVar.zzh != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zzenVar.zzu(adSizeArr);
    }

    public void setAdUnitId(String str) {
        zzen zzenVar = this.zza;
        if (zzenVar.zzl != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        zzenVar.zzl = str;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        zzen zzenVar = this.zza;
        zzenVar.getClass();
        try {
            zzenVar.zzp = onPaidEventListener;
            zzbx zzbxVar = zzenVar.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzQ(new zzfu(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public void setPlacementId(long j) {
        zzen zzenVar = this.zza;
        zzenVar.zzq.set(j);
        try {
            zzbx zzbxVar = zzenVar.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzR(j);
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
