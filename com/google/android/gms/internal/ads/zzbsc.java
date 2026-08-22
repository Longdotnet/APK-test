package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbsc extends zzbro {
    private final RtbAdapter zza;
    private MediationInterstitialAd zzb;
    private MediationRewardedAd zzc;
    private MediationAppOpenAd zzd;
    private String zze = "";

    public zzbsc(RtbAdapter rtbAdapter) {
        this.zza = rtbAdapter;
    }

    private final Bundle zzv(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        Bundle bundle;
        Bundle bundle2 = zzmVar.zzm;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private static final Bundle zzw(String str) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String str2 = (String) itKeys.next();
                bundle2.putString(str2, jSONObject.getString(str2));
            }
            return bundle2;
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            throw new RemoteException();
        }
    }

    private static final boolean zzx(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        if (zzmVar.zzf) {
            return true;
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        return com.google.android.gms.ads.internal.util.client.zzf.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final com.google.android.gms.ads.internal.client.zzed zze() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final zzbse zzf() {
        this.zza.getVersionInfo();
        return zzbse.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final zzbse zzg() {
        this.zza.getSDKVersionInfo();
        return zzbse.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbra zzbraVar, zzbpw zzbpwVar) throws RemoteException {
        try {
            zzbrz zzbrzVar = new zzbrz(this, zzbraVar, zzbpwVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(zzmVar);
            zzx(zzmVar);
            Location location = zzmVar.zzk;
            zzy(str2, zzmVar);
            rtbAdapter.loadRtbAppOpenAd(new MediationAppOpenAdConfiguration(), zzbrzVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render app open ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbAppOpenAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrd zzbrdVar, zzbpw zzbpwVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        try {
            zzbru zzbruVar = new zzbru(this, zzbrdVar, zzbpwVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(zzmVar);
            zzx(zzmVar);
            Location location = zzmVar.zzk;
            zzy(str2, zzmVar);
            new AdSize(zzrVar.zze, zzrVar.zzb, zzrVar.zza);
            rtbAdapter.loadRtbBannerAd(new MediationBannerAdConfiguration(), zzbruVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render banner ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbBannerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrd zzbrdVar, zzbpw zzbpwVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        try {
            zzbrv zzbrvVar = new zzbrv(this, zzbrdVar, zzbpwVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(zzmVar);
            zzx(zzmVar);
            Location location = zzmVar.zzk;
            zzy(str2, zzmVar);
            new AdSize(zzrVar.zze, zzrVar.zzb, zzrVar.zza);
            zzbrvVar.onFailure(new AdError(7, rtbAdapter.getClass().getSimpleName().concat(" does not support interscroller ads."), "com.google.android.gms.ads", null));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render interscroller ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbInterscrollerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrg zzbrgVar, zzbpw zzbpwVar) throws RemoteException {
        try {
            zzbrw zzbrwVar = new zzbrw(this, zzbrgVar, zzbpwVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(zzmVar);
            zzx(zzmVar);
            Location location = zzmVar.zzk;
            zzy(str2, zzmVar);
            rtbAdapter.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration(), zzbrwVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render interstitial ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, zzbpw zzbpwVar) throws RemoteException {
        zzn(str, str2, zzmVar, iObjectWrapper, zzbrjVar, zzbpwVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, zzbpw zzbpwVar, zzbge zzbgeVar) throws RemoteException {
        try {
            zzbrx zzbrxVar = new zzbrx(this, zzbrjVar, zzbpwVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(zzmVar);
            zzx(zzmVar);
            Location location = zzmVar.zzk;
            zzy(str2, zzmVar);
            rtbAdapter.loadRtbNativeAdMapper(new MediationNativeAdConfiguration(), zzbrxVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render native ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbNativeAdMapper");
            String message = th.getMessage();
            if (TextUtils.isEmpty(message) || !message.equals("Method is not found")) {
                throw new RemoteException();
            }
            try {
                zzbry zzbryVar = new zzbry(this, zzbrjVar, zzbpwVar);
                RtbAdapter rtbAdapter2 = this.zza;
                zzw(str2);
                zzv(zzmVar);
                zzx(zzmVar);
                Location location2 = zzmVar.zzk;
                zzy(str2, zzmVar);
                rtbAdapter2.loadRtbNativeAd(new MediationNativeAdConfiguration(), zzbryVar);
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render native ad.", th2);
                zzbpn.zza(iObjectWrapper, th2, "adapter.loadRtbNativeAd");
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrm zzbrmVar, zzbpw zzbpwVar) throws RemoteException {
        try {
            zzbsb zzbsbVar = new zzbsb(this, zzbrmVar, zzbpwVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(zzmVar);
            zzx(zzmVar);
            Location location = zzmVar.zzk;
            zzy(str2, zzmVar);
            rtbAdapter.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration(), zzbsbVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render rewarded interstitial ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbRewardedInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrm zzbrmVar, zzbpw zzbpwVar) throws RemoteException {
        try {
            zzbsb zzbsbVar = new zzbsb(this, zzbrmVar, zzbpwVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(zzmVar);
            zzx(zzmVar);
            Location location = zzmVar.zzk;
            zzy(str2, zzmVar);
            rtbAdapter.loadRtbRewardedAd(new MediationRewardedAdConfiguration(), zzbsbVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Adapter failed to render rewarded ad.", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.loadRtbRewardedAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzq(String str) {
        this.zze = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzt(IObjectWrapper iObjectWrapper) {
        return false;
    }

    private static final String zzy(String str, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        String str2 = zzmVar.zzu;
        try {
            return new JSONObject(str).getString(UUFMQdNK.LrXzXIAvyNIOS);
        } catch (JSONException unused) {
            return str2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0058  */
    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzr zzrVar, zzbrs zzbrsVar) throws RemoteException {
        byte b;
        try {
            zzbsa zzbsaVar = new zzbsa(this, zzbrsVar);
            RtbAdapter rtbAdapter = this.zza;
            switch (str.hashCode()) {
                case -1396342996:
                    if (!str.equals("banner")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case -1052618729:
                    if (!str.equals(ZRqOdXiy.jBAsBr)) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case -239580146:
                    if (!str.equals("rewarded")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 604727084:
                    if (!str.equals("interstitial")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 1167692200:
                    if (!str.equals(FirebaseAnalytics.Event.APP_OPEN)) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 1778294298:
                    if (!str.equals("app_open_ad")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 1911491517:
                    if (!str.equals("rewarded_interstitial")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    new ArrayList().add(new GraphRequest.Companion(23));
                    new AdSize(zzrVar.zze, zzrVar.zzb, zzrVar.zza);
                    rtbAdapter.collectSignals(new RtbSignalData(), zzbsaVar);
                    return;
                case 6:
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmm)).booleanValue()) {
                        new ArrayList().add(new GraphRequest.Companion(23));
                        new AdSize(zzrVar.zze, zzrVar.zzb, zzrVar.zza);
                        rtbAdapter.collectSignals(new RtbSignalData(), zzbsaVar);
                        return;
                    }
                    throw new IllegalArgumentException("Internal Error");
                default:
                    throw new IllegalArgumentException("Internal Error");
            }
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error generating signals for RTB", th);
            zzbpn.zza(iObjectWrapper, th, "adapter.collectSignals");
            throw new RemoteException();
        }
    }
}
