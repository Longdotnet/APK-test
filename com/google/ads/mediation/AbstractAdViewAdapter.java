package com.google.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextHelper;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzed;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbit;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdLoader adLoader;
    protected AdView mAdView;
    protected InterstitialAd mInterstitialAd;

    public AdRequest buildAdRequest(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Set keywords = mediationAdRequest.getKeywords();
        AppCompatTextHelper appCompatTextHelper = (AppCompatTextHelper) builder.mBuilder;
        if (keywords != null) {
            Iterator it = keywords.iterator();
            while (it.hasNext()) {
                ((HashSet) appCompatTextHelper.mView).add((String) it.next());
            }
        }
        if (mediationAdRequest.isTesting()) {
            zzf zzfVar = zzbb.zzb.zzc;
            ((HashSet) appCompatTextHelper.mDrawableRightTint).add(zzf.zzD(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            appCompatTextHelper.mStyle = mediationAdRequest.taggedForChildDirectedTreatment() != 1 ? 0 : 1;
        }
        appCompatTextHelper.mAsyncFontPending = mediationAdRequest.isDesignedForFamilies();
        builder.addNetworkExtrasBundle(buildExtrasBundle(bundle, bundle2));
        return new AdRequest(builder);
    }

    public abstract Bundle buildExtrasBundle(Bundle bundle, Bundle bundle2);

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.mAdView;
    }

    public InterstitialAd getInterstitialAd() {
        return this.mInterstitialAd;
    }

    public zzed getVideoController() {
        zzed zzedVar;
        AdView adView = this.mAdView;
        if (adView == null) {
            return null;
        }
        VideoController videoController = adView.zza.zze;
        synchronized (videoController.zza) {
            zzedVar = videoController.zzb;
        }
        return zzedVar;
    }

    public AdLoader.Builder newAdLoader(Context context, String str) {
        return new AdLoader.Builder(context, str);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, com.google.android.gms.ads.mediation.MediationAdapter, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onDestroy() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.destroy();
            this.mAdView = null;
        }
        if (this.mInterstitialAd != null) {
            this.mInterstitialAd = null;
        }
        if (this.adLoader != null) {
            this.adLoader = null;
        }
    }

    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(z);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, com.google.android.gms.ads.mediation.MediationAdapter, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onPause() {
        AdView adView = this.mAdView;
        if (adView != null) {
            zzbde.zza(adView.getContext());
            if (((Boolean) zzbfc.zzg.zze()).booleanValue()) {
                if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlC)).booleanValue()) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new com.google.android.gms.ads.zzd(adView, 2));
                    return;
                }
            }
            zzen zzenVar = adView.zza;
            zzenVar.getClass();
            try {
                zzbx zzbxVar = zzenVar.zzj;
                if (zzbxVar != null) {
                    zzbxVar.zzA();
                }
            } catch (RemoteException e) {
                zzo.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, com.google.android.gms.ads.mediation.MediationAdapter, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onResume() {
        AdView adView = this.mAdView;
        if (adView != null) {
            zzbde.zza(adView.getContext());
            if (((Boolean) zzbfc.zzh.zze()).booleanValue()) {
                if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlA)).booleanValue()) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new com.google.android.gms.ads.zzd(adView, 0));
                    return;
                }
            }
            zzen zzenVar = adView.zza;
            zzenVar.getClass();
            try {
                zzbx zzbxVar = zzenVar.zzj;
                if (zzbxVar != null) {
                    zzbxVar.zzC();
                }
            } catch (RemoteException e) {
                zzo.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        AdView adView = new AdView(context);
        this.mAdView = adView;
        adView.setAdSize(new AdSize(adSize.zzb, adSize.zzc));
        this.mAdView.setAdUnitId(getAdUnitId(bundle));
        this.mAdView.setAdListener(new zzb(this, mediationBannerListener));
        this.mAdView.loadAd(buildAdRequest(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        InterstitialAd.load(context, getAdUnitId(bundle), buildAdRequest(context, mediationAdRequest, bundle2, bundle), new zzc(this, mediationInterstitialListener));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zze zzeVar = new zze(this, mediationNativeListener);
        AdLoader.Builder builderNewAdLoader = newAdLoader(context, bundle.getString(AD_UNIT_ID_PARAMETER));
        builderNewAdLoader.getClass();
        zzbt zzbtVar = builderNewAdLoader.zzb;
        try {
            zzbtVar.zzl(new zzg(zzeVar));
        } catch (RemoteException e) {
            zzo.zzk("Failed to set AdListener.", e);
        }
        try {
            zzbtVar.zzo(new zzbge(nativeMediationAdRequest.getNativeAdOptions()));
        } catch (RemoteException e2) {
            zzo.zzk("Failed to specify native ad options", e2);
        }
        builderNewAdLoader.withNativeAdOptions(nativeMediationAdRequest.getNativeAdRequestOptions());
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            try {
                zzbtVar.zzk(new zzbit(zzeVar));
            } catch (RemoteException e3) {
                zzo.zzk("Failed to add google native ad listener", e3);
            }
        }
        if (nativeMediationAdRequest.zzb()) {
            for (String str : nativeMediationAdRequest.zza().keySet()) {
                zzbiq zzbiqVar = new zzbiq(zzeVar, true != ((Boolean) nativeMediationAdRequest.zza().get(str)).booleanValue() ? null : zzeVar);
                try {
                    zzbtVar.zzh(str, zzbiqVar.zzd(), zzbiqVar.zzc());
                } catch (RemoteException e4) {
                    zzo.zzk("Failed to add custom template ad listener", e4);
                }
            }
        }
        AdLoader adLoaderBuild = builderNewAdLoader.build();
        this.adLoader = adLoaderBuild;
        adLoaderBuild.loadAd(buildAdRequest(context, nativeMediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.show(null);
        }
    }
}
