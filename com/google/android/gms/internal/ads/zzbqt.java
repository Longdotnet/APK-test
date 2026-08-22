package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqt implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzbpw zza;
    private UnifiedNativeAdMapper zzb;
    private zzbhk zzc;

    public zzbqt(zzbpw zzbpwVar) {
        this.zza = zzbpwVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.zza.zzg(i);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzb;
        if (this.zzc == null) {
            if (unifiedNativeAdMapper == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", null);
                return;
            } else if (!unifiedNativeAdMapper.zzp) {
                com.google.android.gms.ads.internal.util.client.zzo.zze("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdImpression.");
        try {
            this.zza.zzm();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdLoaded.");
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onVideoEnd.");
        try {
            this.zza.zzw();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final UnifiedNativeAdMapper zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void zzb(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAppEvent.");
        try {
            this.zza.zzq(str, str2);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final zzbhk zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zze(MediationNativeAdapter mediationNativeAdapter, zzbhk zzbhkVar, String str) {
        try {
            this.zza.zzr(zzbhkVar.zza(), str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zzd(MediationNativeAdapter mediationNativeAdapter, zzbhk zzbhkVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1(nYVxXTZQ.SbEVNEp);
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdLoaded with template id ".concat(String.valueOf(zzbhkVar.zzb())));
        this.zzc = zzbhkVar;
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, AdError adError) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(adError.zza, "Adapter called onAdFailedToLoad with error. ErrorCode: ", ". ErrorMessage: ");
        sbM.append(adError.zzb);
        sbM.append(". ErrorDomain: ");
        sbM.append(adError.zzc);
        com.google.android.gms.ads.internal.util.client.zzo.zze(sbM.toString());
        try {
            this.zza.zzh(adError.zza());
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdLoaded.");
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzb;
        if (this.zzc == null) {
            if (unifiedNativeAdMapper == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", null);
                return;
            } else if (!unifiedNativeAdMapper.zzq) {
                com.google.android.gms.ads.internal.util.client.zzo.zze("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdLoaded.");
        this.zzb = unifiedNativeAdMapper;
        if (!(mediationNativeAdapter instanceof AdMobAdapter)) {
            Object obj = new Object();
            new zzbqg();
            synchronized (obj) {
            }
        }
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.zza.zzg(i);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, AdError adError) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(adError.zza, bUqMCsuPSX.AAfwPpQIAKX, ". ErrorMessage: ");
        sbM.append(adError.zzb);
        sbM.append(". ErrorDomain: ");
        sbM.append(adError.zzc);
        com.google.android.gms.ads.internal.util.client.zzo.zze(sbM.toString());
        try {
            this.zza.zzh(adError.zza());
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.zze("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.zza.zzg(i);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, AdError adError) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("#008 Must be called on the main UI thread.");
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(adError.zza, "Adapter called onAdFailedToLoad with error. ErrorCode: ", ". ErrorMessage: ");
        sbM.append(adError.zzb);
        sbM.append(". ErrorDomain: ");
        sbM.append(adError.zzc);
        com.google.android.gms.ads.internal.util.client.zzo.zze(sbM.toString());
        try {
            this.zza.zzh(adError.zza());
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
