package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwf extends com.google.android.gms.ads.internal.client.zzdv {
    final Map zza;
    private final Context zzb;
    private final WeakReference zzc;
    private final zzdvt zzd;
    private final zzgdy zze;
    private zzdvi zzf;

    public zzdwf(Context context, WeakReference weakReference, zzdvt zzdvtVar, zzdwh zzdwhVar, zzgdy zzgdyVar) {
        super("com.google.android.gms.ads.internal.client.IOutOfContextTester");
        this.zza = new HashMap();
        this.zzb = context;
        this.zzc = weakReference;
        this.zzd = zzdvtVar;
        this.zze = zzgdyVar;
    }

    private final Context zzj() {
        Context context = (Context) this.zzc.get();
        return context == null ? this.zzb : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzk(Object obj) {
        ResponseInfo responseInfo;
        com.google.android.gms.ads.internal.client.zzea zzeaVar;
        if (obj instanceof LoadAdError) {
            responseInfo = ((LoadAdError) obj).zza;
        } else if (obj instanceof AppOpenAd) {
            responseInfo = ((AppOpenAd) obj).getResponseInfo();
        } else if (obj instanceof InterstitialAd) {
            responseInfo = ((InterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedAd) {
            responseInfo = ((RewardedAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedInterstitialAd) {
            responseInfo = ((RewardedInterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof AdView) {
            responseInfo = ((AdView) obj).getResponseInfo();
        } else {
            if (!(obj instanceof NativeAd)) {
                return "";
            }
            responseInfo = ((NativeAd) obj).getResponseInfo();
        }
        if (responseInfo == null || (zzeaVar = responseInfo.zza) == null) {
            return "";
        }
        try {
            return zzeaVar.zzh();
        } catch (RemoteException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzl(String str) {
        try {
            zzgdn.zzr(this.zzf.zzb(str), new zzdwd(this), this.zze);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "OutOfContextTester.setAdAsOutOfContext");
            this.zzd.zzk();
        }
    }

    private final synchronized void zzm(String str) {
        try {
            zzgdn.zzr(this.zzf.zzb(str), new zzdwe(this), this.zze);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "OutOfContextTester.setAdAsShown");
            this.zzd.zzk();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdw
    public final void zze(String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        ViewGroup viewGroup = (ViewGroup) ObjectWrapper.unwrap(iObjectWrapper2);
        if (context == null || viewGroup == null) {
            return;
        }
        Map map = this.zza;
        Object obj = map.get(str);
        if (obj != null) {
            map.remove(str);
        }
        if (obj instanceof AdView) {
            zzdwh.zza(context, viewGroup, (AdView) obj);
        } else if (obj instanceof NativeAd) {
            zzdwh.zzb(context, viewGroup, (NativeAd) obj);
        }
    }

    public final void zzf(zzdvi zzdviVar) {
        this.zzf = zzdviVar;
    }

    public final synchronized void zzg(String str, Object obj) {
        this.zza.put(str, obj);
        zzl(zzk(obj));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final synchronized void zzh(zzdwg zzdwgVar) {
        byte b;
        try {
            String strZzf = zzdwgVar.zzf();
            switch (strZzf.hashCode()) {
                case -1999289321:
                    if (!strZzf.equals("NATIVE")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case -1372958932:
                    if (!strZzf.equals("INTERSTITIAL")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case -428325382:
                    if (!strZzf.equals("APP_OPEN_AD")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 543046670:
                    if (!strZzf.equals("REWARDED")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 1854800829:
                    if (!strZzf.equals("REWARDED_INTERSTITIAL")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 1951953708:
                    if (!strZzf.equals("BANNER")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                String strZze = zzdwgVar.zze();
                AppOpenAd.load(zzj(), strZze, zzdwgVar.zza(), new zzdvx(this, strZze));
                return;
            }
            if (b == 1) {
                String strZze2 = zzdwgVar.zze();
                zzbcv zzbcvVar = zzbde.zzjP;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                BaseAdView adManagerAdView = (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && zzdwgVar.zzn()) ? new AdManagerAdView(zzj()) : new AdView(zzj());
                adManagerAdView.setAdSize(zzdwgVar.zzb());
                adManagerAdView.setAdUnitId(strZze2);
                adManagerAdView.setAdListener(new zzdvy(this, strZze2, adManagerAdView));
                VideoOptions videoOptionsZzc = zzdwgVar.zzc();
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && zzdwgVar.zzn() && videoOptionsZzc != null) {
                    ((AdManagerAdView) adManagerAdView).setVideoOptions(videoOptionsZzc);
                }
                adManagerAdView.loadAd(zzdwgVar.zza());
                return;
            }
            if (b == 2) {
                String strZze3 = zzdwgVar.zze();
                InterstitialAd.load(zzj(), strZze3, zzdwgVar.zza(), new zzdvz(this, strZze3));
                return;
            }
            if (b != 3) {
                if (b == 4) {
                    String strZze4 = zzdwgVar.zze();
                    RewardedAd.load(zzj(), strZze4, zzdwgVar.zza(), new zzdwa(this, strZze4));
                    return;
                } else {
                    if (b != 5) {
                        return;
                    }
                    String strZze5 = zzdwgVar.zze();
                    RewardedInterstitialAd.load(zzj(), strZze5, zzdwgVar.zza(), new zzdwb(this, strZze5));
                    return;
                }
            }
            final String strZze6 = zzdwgVar.zze();
            AdLoader.Builder builder = new AdLoader.Builder(zzj(), strZze6);
            try {
                builder.zzb.zzk(new zzbtf(new NativeAd.OnNativeAdLoadedListener() { // from class: com.google.android.gms.internal.ads.zzdvw
                    @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
                    public final void onNativeAdLoaded(NativeAd nativeAd) {
                        this.zza.zzg(strZze6, nativeAd);
                    }
                }));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to add google native ad listener", e);
            }
            try {
                builder.zzb.zzl(new com.google.android.gms.ads.internal.client.zzg(new zzdwc(this)));
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to set AdListener.", e2);
            }
            NativeAdOptions nativeAdOptionsZzd = zzdwgVar.zzd();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjP)).booleanValue() && nativeAdOptionsZzd != null) {
                builder.withNativeAdOptions(nativeAdOptionsZzd);
            }
            builder.build().loadAd(zzdwgVar.zza());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzi(String str) {
        Map map;
        Object obj;
        try {
            Activity activityZzg = this.zzd.zzg();
            if (activityZzg != null && (obj = (map = this.zza).get(str)) != null) {
                zzbcv zzbcvVar = zzbde.zzjO;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() || (obj instanceof AppOpenAd) || (obj instanceof InterstitialAd) || (obj instanceof RewardedAd) || (obj instanceof RewardedInterstitialAd)) {
                    map.remove(str);
                }
                zzm(zzk(obj));
                if (obj instanceof AppOpenAd) {
                    ((AppOpenAd) obj).show(activityZzg);
                    return;
                }
                if (obj instanceof InterstitialAd) {
                    ((InterstitialAd) obj).show(activityZzg);
                    return;
                }
                if (obj instanceof RewardedAd) {
                    ((RewardedAd) obj).show(activityZzg, new OnUserEarnedRewardListener() { // from class: com.google.android.gms.internal.ads.zzdvu
                        @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                        public final void onUserEarnedReward(RewardItem rewardItem) {
                        }
                    });
                    return;
                }
                if (obj instanceof RewardedInterstitialAd) {
                    ((RewardedInterstitialAd) obj).show(activityZzg, new OnUserEarnedRewardListener() { // from class: com.google.android.gms.internal.ads.zzdvv
                        @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                        public final void onUserEarnedReward(RewardItem rewardItem) {
                        }
                    });
                    return;
                }
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && ((obj instanceof AdView) || (obj instanceof NativeAd))) {
                    Intent intent = new Intent();
                    Context contextZzj = zzj();
                    intent.setClassName(contextZzj, "com.google.android.gms.ads.OutOfContextTestingActivity");
                    intent.putExtra("adUnit", str);
                    com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    com.google.android.gms.ads.internal.util.zzs.zzU(contextZzj, intent);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
