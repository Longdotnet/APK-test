package com.google.android.gms.ads.nativead;

import android.os.RemoteException;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.facebook.AccessTokenCache;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbhj;

/* JADX INFO: loaded from: classes.dex */
public final class MediaView extends FrameLayout {
    public MediaContent zza;
    public boolean zzb;
    public ImageView.ScaleType zzc;
    public boolean zzd;
    public AccessTokenCache zze;
    public Fragment.AnonymousClass7 zzf;

    public MediaContent getMediaContent() {
        return this.zza;
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        zzbgt zzbgtVar;
        this.zzd = true;
        this.zzc = scaleType;
        Fragment.AnonymousClass7 anonymousClass7 = this.zzf;
        if (anonymousClass7 == null || (zzbgtVar = ((NativeAdView) anonymousClass7.this$0).zzb) == null || scaleType == null) {
            return;
        }
        try {
            zzbgtVar.zzdA(new ObjectWrapper(scaleType));
        } catch (RemoteException e) {
            zzo.zzh("Unable to call setMediaViewImageScaleType on delegate", e);
        }
    }

    public void setMediaContent(MediaContent mediaContent) {
        boolean zZzl;
        boolean zZzr;
        this.zzb = true;
        this.zza = mediaContent;
        AccessTokenCache accessTokenCache = this.zze;
        if (accessTokenCache != null) {
            NativeAdView.zzc((NativeAdView) accessTokenCache.sharedPreferences, mediaContent);
        }
        if (mediaContent == null) {
            return;
        }
        try {
            zzbhj zzbhjVar = ((zzff) mediaContent).zzc;
            if (zzbhjVar != null) {
                boolean zZzk = false;
                try {
                    zZzl = ((zzff) mediaContent).zza.zzl();
                } catch (RemoteException e) {
                    zzo.zzh("", e);
                    zZzl = false;
                }
                if (!zZzl) {
                    try {
                        zZzk = ((zzff) mediaContent).zza.zzk();
                    } catch (RemoteException e2) {
                        zzo.zzh("", e2);
                    }
                    if (zZzk) {
                        zZzr = zzbhjVar.zzr(new ObjectWrapper(this));
                    }
                    removeAllViews();
                }
                zZzr = zzbhjVar.zzs(new ObjectWrapper(this));
                if (zZzr) {
                    return;
                }
                removeAllViews();
            }
        } catch (RemoteException e3) {
            removeAllViews();
            zzo.zzh("", e3);
        }
    }

    public final synchronized void zzb(Fragment.AnonymousClass7 anonymousClass7) {
        this.zzf = anonymousClass7;
        if (this.zzd) {
            ImageView.ScaleType scaleType = this.zzc;
            zzbgt zzbgtVar = ((NativeAdView) anonymousClass7.this$0).zzb;
            if (zzbgtVar != null && scaleType != null) {
                try {
                    zzbgtVar.zzdA(new ObjectWrapper(scaleType));
                } catch (RemoteException e) {
                    zzo.zzh("Unable to call setMediaViewImageScaleType on delegate", e);
                }
            }
        }
    }
}
