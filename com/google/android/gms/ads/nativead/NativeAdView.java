package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.TooltipPopup;
import androidx.fragment.app.Fragment;
import com.facebook.AccessTokenCache;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbgt;

/* JADX INFO: loaded from: classes.dex */
public final class NativeAdView extends FrameLayout {
    public final FrameLayout zza;
    public final zzbgt zzb;

    public NativeAdView(Context context) {
        zzbgt zzbgtVar;
        super(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        this.zza = frameLayout;
        if (isInEditMode()) {
            zzbgtVar = null;
        } else {
            TooltipPopup tooltipPopup = zzbb.zzb.zzd;
            Context context2 = frameLayout.getContext();
            tooltipPopup.getClass();
            zzbgtVar = (zzbgt) new zzaw(tooltipPopup, this, frameLayout, context2).zzd(context2, false);
        }
        this.zzb = zzbgtVar;
    }

    public static void zzc(NativeAdView nativeAdView, MediaContent mediaContent) {
        zzbgt zzbgtVar = nativeAdView.zzb;
        if (zzbgtVar == null) {
            return;
        }
        try {
            if (mediaContent instanceof zzff) {
                zzbgtVar.zzdz(((zzff) mediaContent).zza);
            } else if (mediaContent == null) {
                zzbgtVar.zzdz(null);
            } else {
                zzo.zze("Use MediaContent provided by NativeAd.getMediaContent");
            }
        } catch (RemoteException e) {
            zzo.zzh("Unable to call setMediaContent on delegate", e);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zza);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zza;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzbgt zzbgtVar = this.zzb;
        if (zzbgtVar != null) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlW)).booleanValue()) {
                try {
                    zzbgtVar.zzd(new ObjectWrapper(motionEvent));
                } catch (RemoteException e) {
                    zzo.zzh("Unable to call handleTouchEvent on delegate", e);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public AdChoicesView getAdChoicesView() {
        zza("3011");
        return null;
    }

    public final View getAdvertiserView() {
        return zza("3005");
    }

    public final View getBodyView() {
        return zza("3004");
    }

    public final View getCallToActionView() {
        return zza("3002");
    }

    public final View getHeadlineView() {
        return zza("3001");
    }

    public final View getIconView() {
        return zza("3003");
    }

    public final View getImageView() {
        return zza("3008");
    }

    public final MediaView getMediaView() {
        View viewZza = zza("3010");
        if (viewZza instanceof MediaView) {
            return (MediaView) viewZza;
        }
        if (viewZza == null) {
            return null;
        }
        zzo.zze("View is not an instance of MediaView");
        return null;
    }

    public final View getPriceView() {
        return zza("3007");
    }

    public final View getStarRatingView() {
        return zza("3009");
    }

    public final View getStoreView() {
        return zza("3006");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzbgt zzbgtVar = this.zzb;
        if (zzbgtVar == null) {
            return;
        }
        try {
            zzbgtVar.zze(new ObjectWrapper(view), i);
        } catch (RemoteException e) {
            zzo.zzh("Unable to call onVisibilityChanged on delegate", e);
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        addView(this.zza);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.zza == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zzf(adChoicesView, "3011");
    }

    public final void setAdvertiserView(View view) {
        zzf(view, "3005");
    }

    public final void setBodyView(View view) {
        zzf(view, "3004");
    }

    public final void setCallToActionView(View view) {
        zzf(view, "3002");
    }

    public final void setClickConfirmingView(View view) {
        zzbgt zzbgtVar = this.zzb;
        if (zzbgtVar == null) {
            return;
        }
        try {
            zzbgtVar.zzdy(new ObjectWrapper(view));
        } catch (RemoteException e) {
            zzo.zzh("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        zzf(view, "3001");
    }

    public final void setIconView(View view) {
        zzf(view, "3003");
    }

    public final void setImageView(View view) {
        zzf(view, "3008");
    }

    public final void setMediaView(MediaView mediaView) {
        zzf(mediaView, "3010");
        if (mediaView == null) {
            return;
        }
        AccessTokenCache accessTokenCache = new AccessTokenCache(this, 20);
        synchronized (mediaView) {
            mediaView.zze = accessTokenCache;
            if (mediaView.zzb) {
                zzc(this, mediaView.zza);
            }
        }
        mediaView.zzb(new Fragment.AnonymousClass7(this, 21));
    }

    public void setNativeAd(NativeAd nativeAd) {
        zzbgt zzbgtVar = this.zzb;
        if (zzbgtVar == null) {
            return;
        }
        try {
            zzbgtVar.zzdB((IObjectWrapper) nativeAd.zza());
        } catch (RemoteException e) {
            zzo.zzh("Unable to call setNativeAd on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        zzf(view, "3007");
    }

    public final void setStarRatingView(View view) {
        zzf(view, "3009");
    }

    public final void setStoreView(View view) {
        zzf(view, "3006");
    }

    public final View zza(String str) {
        zzbgt zzbgtVar = this.zzb;
        if (zzbgtVar != null) {
            try {
                IObjectWrapper iObjectWrapperZzb = zzbgtVar.zzb(str);
                if (iObjectWrapperZzb != null) {
                    return (View) ObjectWrapper.unwrap(iObjectWrapperZzb);
                }
            } catch (RemoteException e) {
                zzo.zzh("Unable to call getAssetView on delegate", e);
            }
        }
        return null;
    }

    public final void zzf(View view, String str) {
        zzbgt zzbgtVar = this.zzb;
        if (zzbgtVar == null) {
            return;
        }
        try {
            zzbgtVar.zzdx(str, new ObjectWrapper(view));
        } catch (RemoteException e) {
            zzo.zzh("Unable to call setAssetView on delegate", e);
        }
    }
}
