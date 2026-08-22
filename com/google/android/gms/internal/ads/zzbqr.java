package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.facebook.GraphRequest;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqr extends zzbps {
    private final Object zza;
    private zzbqt zzb;
    private zzbwn zzc;
    private IObjectWrapper zzd;
    private View zze;
    private MediationInterstitialAd zzf;
    private UnifiedNativeAdMapper zzg;
    private NativeAdMapper zzh;
    private MediationRewardedAd zzi;
    private MediationInterscrollerAd zzj;
    private MediationAppOpenAd zzk;
    private final String zzl = "";

    public zzbqr(Adapter adapter) {
        this.zza = adapter;
    }

    private final Bundle zzV(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        Bundle bundle;
        Bundle bundle2 = zzmVar.zzm;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private final Bundle zzW(String str, com.google.android.gms.ads.internal.client.zzm zzmVar, String str2) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.zze("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String str3 = (String) itKeys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.zza instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzmVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzmVar.zzg);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
            throw new RemoteException();
        }
    }

    private static final boolean zzX(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        if (zzmVar.zzf) {
            return true;
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        return com.google.android.gms.ads.internal.util.client.zzf.zzw();
    }

    private static final String zzY(String str, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        String str2 = zzmVar.zzu;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzA(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zze("Requesting rewarded ad from adapter.");
        try {
            zzbqp zzbqpVar = new zzbqp(this, zzbpwVar);
            zzW(str, zzmVar, null);
            zzV(zzmVar);
            zzX(zzmVar);
            Location location = zzmVar.zzk;
            zzY(str, zzmVar);
            ((Adapter) obj).loadRewardedAd(new MediationRewardedAdConfiguration(), zzbqpVar);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            zzbpn.zza(iObjectWrapper, e, "adapter.loadRewardedAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzB(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzA(this.zzd, zzmVar, str, new zzbqu((Adapter) obj, this.zzc));
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzC(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zze("Requesting rewarded interstitial ad from adapter.");
        try {
            zzbqp zzbqpVar = new zzbqp(this, zzbpwVar);
            zzW(str, zzmVar, null);
            zzV(zzmVar);
            zzX(zzmVar);
            Location location = zzmVar.zzk;
            zzY(str, zzmVar);
            ((Adapter) obj).loadRewardedInterstitialAd(new MediationRewardedAdConfiguration(), zzbqpVar);
        } catch (Exception e) {
            zzbpn.zza(iObjectWrapper, e, "adapter.loadRewardedInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzD(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzE() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzF() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzG(boolean z) {
        Object obj = this.zza;
        if (obj instanceof AbstractAdViewAdapter) {
            try {
                ((AbstractAdViewAdapter) obj).onImmersiveModeUpdated(z);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzo.zze(AbstractAdViewAdapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzo.zze("Show app open ad from adapter.");
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Can not show null mediation app open ad.");
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzI() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationInterstitialAdapter) {
            com.google.android.gms.ads.internal.util.client.zzo.zze("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) obj).showInterstitial();
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
                throw new RemoteException();
            }
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj(MediationInterstitialAdapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzo.zze("Show rewarded ad from adapter.");
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Can not show null mediation rewarded ad.");
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzL() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Can not show null mediated rewarded ad.");
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final boolean zzM() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final boolean zzN() throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            return this.zzc != null;
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqb zzO() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqc zzP() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final Bundle zze() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final Bundle zzf() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final Bundle zzg() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final com.google.android.gms.ads.internal.client.zzed zzh() {
        Object obj = this.zza;
        if (obj instanceof AbstractAdViewAdapter) {
            try {
                return ((AbstractAdViewAdapter) obj).getVideoController();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbhj zzi() {
        zzbqt zzbqtVar = this.zzb;
        if (zzbqtVar == null) {
            return null;
        }
        zzbhk zzbhkVarZzc = zzbqtVar.zzc();
        if (zzbhkVarZzc instanceof zzbhk) {
            return zzbhkVarZzc.zza();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbpz zzj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqf zzk() {
        UnifiedNativeAdMapper unifiedNativeAdMapper;
        UnifiedNativeAdMapper unifiedNativeAdMapperZza;
        Object obj = this.zza;
        if (!(obj instanceof MediationNativeAdapter)) {
            if (!(obj instanceof Adapter) || (unifiedNativeAdMapper = this.zzg) == null) {
                return null;
            }
            return new zzbqx(unifiedNativeAdMapper);
        }
        zzbqt zzbqtVar = this.zzb;
        if (zzbqtVar == null || (unifiedNativeAdMapperZza = zzbqtVar.zza()) == null) {
            return null;
        }
        return new zzbqx(unifiedNativeAdMapperZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbse zzl() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        ((Adapter) obj).getVersionInfo();
        return zzbse.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbse zzm() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        ((Adapter) obj).getSDKVersionInfo();
        return zzbse.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final IObjectWrapper zzn() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return new ObjectWrapper(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            return new ObjectWrapper(this.zze);
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj(MediationBannerAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzo() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzp(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbwn zzbwnVar, String str2) throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            this.zzd = iObjectWrapper;
            this.zzc = zzbwnVar;
            zzbwnVar.zzl(new ObjectWrapper(obj));
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0070  */
    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzq(IObjectWrapper iObjectWrapper, zzbmh zzbmhVar, List list) throws RemoteException {
        byte b;
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            throw new RemoteException();
        }
        zzbqk zzbqkVar = new zzbqk(this, zzbmhVar);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            switch (((zzbmn) it.next()).zza) {
                case "banner":
                    b = 0;
                    break;
                case "native":
                    b = 4;
                    break;
                case "rewarded":
                    b = 2;
                    break;
                case "interstitial":
                    b = 1;
                    break;
                case "app_open":
                    b = 5;
                    break;
                case "app_open_ad":
                    b = 6;
                    break;
                case "rewarded_interstitial":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            AdFormat adFormat = AdFormat.APP_OPEN_AD;
            switch (b) {
                case 0:
                    adFormat = AdFormat.BANNER;
                    break;
                case 1:
                    adFormat = AdFormat.INTERSTITIAL;
                    break;
                case 2:
                    adFormat = AdFormat.REWARDED;
                    break;
                case 3:
                    adFormat = AdFormat.REWARDED_INTERSTITIAL;
                    break;
                case 4:
                    adFormat = AdFormat.NATIVE;
                    break;
                case 5:
                    break;
                case 6:
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmm)).booleanValue()) {
                    }
                default:
                    adFormat = null;
                    break;
            }
            if (adFormat != null) {
                arrayList.add(new GraphRequest.Companion(23));
            }
        }
        ((Adapter) obj).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbqkVar, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzr(IObjectWrapper iObjectWrapper, zzbwn zzbwnVar, List list) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzs(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) throws RemoteException {
        zzB(zzmVar, str, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzt(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zze("Requesting app open ad from adapter.");
        try {
            zzbqq zzbqqVar = new zzbqq(this, zzbpwVar);
            zzW(str, zzmVar, null);
            zzV(zzmVar);
            zzX(zzmVar);
            Location location = zzmVar.zzk;
            zzY(str, zzmVar);
            ((Adapter) obj).loadAppOpenAd(new MediationAppOpenAdConfiguration(), zzbqqVar);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            zzbpn.zza(iObjectWrapper, e, "adapter.loadAppOpenAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzu(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) throws RemoteException {
        zzv(iObjectWrapper, zzrVar, zzmVar, str, null, zzbpwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzw(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zze("Requesting interscroller ad from adapter.");
        try {
            Adapter adapter = (Adapter) obj;
            zzbqj zzbqjVar = new zzbqj(this, zzbpwVar, adapter);
            zzW(str, zzmVar, str2);
            zzV(zzmVar);
            zzX(zzmVar);
            Location location = zzmVar.zzk;
            zzY(str, zzmVar);
            int i = zzrVar.zze;
            int i2 = zzrVar.zzb;
            AdSize adSize = new AdSize(i, i2);
            adSize.zzh = true;
            adSize.zzi = i2;
            zzbqjVar.onFailure(new AdError(7, adapter.getClass().getSimpleName().concat(" does not support interscroller ads."), "com.google.android.gms.ads", null));
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            zzbpn.zza(iObjectWrapper, e, "adapter.loadInterscrollerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzx(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) throws RemoteException {
        zzy(iObjectWrapper, zzmVar, str, null, zzbpwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzy(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar) throws RemoteException {
        Object obj = this.zza;
        boolean z = obj instanceof MediationInterstitialAdapter;
        if (!z && !(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj(MediationInterstitialAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zze("Requesting interstitial ad from adapter.");
        if (z) {
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj;
                List list = zzmVar.zze;
                HashSet hashSet = list != null ? new HashSet(list) : null;
                long j = zzmVar.zzb;
                zzbqi zzbqiVar = new zzbqi(j == -1 ? null : new Date(j), zzmVar.zzd, hashSet, zzmVar.zzk, zzX(zzmVar), zzmVar.zzg, zzmVar.zzr, zzmVar.zzt, zzY(str, zzmVar));
                Bundle bundle = zzmVar.zzm;
                mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbqt(zzbpwVar), zzW(str, zzmVar, str2), zzbqiVar, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
                zzbpn.zza(iObjectWrapper, th, "adapter.requestInterstitialAd");
                throw new RemoteException();
            }
        }
        Object obj2 = this.zza;
        if (obj2 instanceof Adapter) {
            try {
                zzbqm zzbqmVar = new zzbqm(this, zzbpwVar);
                zzW(str, zzmVar, str2);
                zzV(zzmVar);
                zzX(zzmVar);
                Location location = zzmVar.zzk;
                zzY(str, zzmVar);
                ((Adapter) obj2).loadInterstitialAd(new MediationInterstitialAdConfiguration(), zzbqmVar);
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th2);
                zzbpn.zza(iObjectWrapper, th2, "adapter.loadInterstitialAd");
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzz(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar, zzbge zzbgeVar, List list) throws RemoteException {
        Object obj = this.zza;
        boolean z = obj instanceof MediationNativeAdapter;
        if (!z && !(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj(MediationNativeAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zze("Requesting native ad from adapter.");
        if (z) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
                List list2 = zzmVar.zze;
                HashSet hashSet = list2 != null ? new HashSet(list2) : null;
                long j = zzmVar.zzb;
                zzbqw zzbqwVar = new zzbqw(j == -1 ? null : new Date(j), zzmVar.zzd, hashSet, zzmVar.zzk, zzX(zzmVar), zzmVar.zzg, zzbgeVar, list, zzmVar.zzr, zzmVar.zzt, zzY(str, zzmVar));
                Bundle bundle = zzmVar.zzm;
                Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.zzb = new zzbqt(zzbpwVar);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzb, zzW(str, zzmVar, str2), zzbqwVar, bundle2);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
                zzbpn.zza(iObjectWrapper, th, "adapter.requestNativeAd");
                throw new RemoteException();
            }
        }
        Object obj2 = this.zza;
        if (obj2 instanceof Adapter) {
            try {
                zzbqo zzbqoVar = new zzbqo(this, zzbpwVar);
                zzW(str, zzmVar, str2);
                zzV(zzmVar);
                zzX(zzmVar);
                Location location = zzmVar.zzk;
                zzY(str, zzmVar);
                ((Adapter) obj2).loadNativeAdMapper(new MediationNativeAdConfiguration(), zzbqoVar);
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th2);
                zzbpn.zza(iObjectWrapper, th2, "adapter.loadNativeAdMapper");
                String message = th2.getMessage();
                if (TextUtils.isEmpty(message) || !message.equals("Method is not found")) {
                    throw new RemoteException();
                }
                try {
                    Adapter adapter = (Adapter) this.zza;
                    zzbqn zzbqnVar = new zzbqn(this, zzbpwVar);
                    zzW(str, zzmVar, str2);
                    zzV(zzmVar);
                    zzX(zzmVar);
                    Location location2 = zzmVar.zzk;
                    zzY(str, zzmVar);
                    adapter.loadNativeAd(new MediationNativeAdConfiguration(), zzbqnVar);
                } catch (Throwable th3) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("", th3);
                    zzbpn.zza(iObjectWrapper, th3, "adapter.loadNativeAd");
                    throw new RemoteException();
                }
            }
        }
    }

    public zzbqr(MediationAdapter mediationAdapter) {
        this.zza = mediationAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || (obj instanceof MediationInterstitialAdapter)) {
            if (obj instanceof MediationInterstitialAdapter) {
                zzI();
                return;
            } else {
                com.google.android.gms.ads.internal.util.client.zzo.zze("Show interstitial ad from adapter.");
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj(MediationInterstitialAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + PZmDzEagKNdW.yhahRfRyEZGkK + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzv(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar) throws RemoteException {
        AdSize adSize;
        Object obj = this.zza;
        boolean z = obj instanceof MediationBannerAdapter;
        if (!z && !(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj(MediationBannerAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + jIKWv.yUEitMXNwkNlH + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zze("Requesting banner ad from adapter.");
        boolean z2 = zzrVar.zzn;
        int i = zzrVar.zzb;
        int i2 = zzrVar.zze;
        if (z2) {
            AdSize adSize2 = new AdSize(i2, i);
            adSize2.zzf = true;
            adSize2.zzg = i;
            adSize = adSize2;
        } else {
            adSize = new AdSize(i2, i, zzrVar.zza);
        }
        if (z) {
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) obj;
                List list = zzmVar.zze;
                HashSet hashSet = list != null ? new HashSet(list) : null;
                long j = zzmVar.zzb;
                zzbqi zzbqiVar = new zzbqi(j == -1 ? null : new Date(j), zzmVar.zzd, hashSet, zzmVar.zzk, zzX(zzmVar), zzmVar.zzg, zzmVar.zzr, zzmVar.zzt, zzY(str, zzmVar));
                Bundle bundle = zzmVar.zzm;
                mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbqt(zzbpwVar), zzW(str, zzmVar, str2), adSize, zzbqiVar, bundle != null ? bundle.getBundle(mediationBannerAdapter.getClass().getName()) : null);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th);
                zzbpn.zza(iObjectWrapper, th, "adapter.requestBannerAd");
                throw new RemoteException();
            }
        }
        Object obj2 = this.zza;
        if (obj2 instanceof Adapter) {
            try {
                zzbql zzbqlVar = new zzbql(this, zzbpwVar);
                zzW(str, zzmVar, str2);
                zzV(zzmVar);
                zzX(zzmVar);
                Location location = zzmVar.zzk;
                zzY(str, zzmVar);
                ((Adapter) obj2).loadBannerAd(new MediationBannerAdConfiguration(), zzbqlVar);
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", th2);
                zzbpn.zza(iObjectWrapper, th2, "adapter.loadBannerAd");
                throw new RemoteException();
            }
        }
    }
}
