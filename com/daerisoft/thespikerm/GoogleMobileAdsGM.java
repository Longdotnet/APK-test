package com.daerisoft.thespikerm;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.android.billingclient.api.zzcj;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.facebook.appevents.codeless.CodelessManager$$ExternalSyntheticLambda0;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.login.vu.dLDI;
import com.google.ads.mediation.zzd;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdapterResponseInfo;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzdb;
import com.google.android.gms.ads.internal.client.zzey;
import com.google.android.gms.ads.internal.client.zzfx;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.internal.ads.zzfrw;
import com.google.android.gms.internal.consent_sdk.zza;
import com.google.android.gms.internal.consent_sdk.zzj;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.common.base.Splitter;
import com.google.gson.yWTz.kBfGXgdfpo;
import com.yoyogames.runner.RunnerJNILib;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleMobileAdsGM extends RunnerSocial {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ADMOB_BANNER_ALIGNMENT_CENTER = 1;
    public static final int ADMOB_BANNER_ALIGNMENT_LEFT = 0;
    public static final int ADMOB_BANNER_ALIGNMENT_RIGHT = 2;
    public static final int ADMOB_ERROR_AD_LIMIT_REACHED = -3;
    public static final int ADMOB_ERROR_ILLEGAL_CALL = -6;
    public static final int ADMOB_ERROR_INVALID_AD_ID = -2;
    public static final int ADMOB_ERROR_NOT_INITIALIZED = -1;
    public static final int ADMOB_ERROR_NO_ACTIVE_BANNER_AD = -5;
    public static final int ADMOB_ERROR_NO_ADS_LOADED = -4;
    public static final int ADMOB_ERROR_NULL_VIEW_HANDLER = -7;
    public static final int ADMOB_OK = 0;
    public static final int EVENT_OTHER_SOCIAL = 70;
    public static final String LOG_TAG = "AdMob";
    public static final long MAX_DOUBLE_SAFE = 9007199254740992L;
    public WeakReference<Activity> activityRef;
    public ConsentForm consentFormInstance;
    public ConsentInformation consentInformation;
    public final ViewGroup rootView;
    public boolean isInitialized = false;
    public boolean isTestDevice = false;
    public boolean isRdpEnabled = false;
    public boolean isShowingAd = false;
    public boolean targetCOPPA = false;
    public boolean targetUnderAge = false;
    public String maxAdContentRating = "G";
    public String bannerAdUnitId = "";
    public AdView bannerAdView = null;
    public AdSize bannerSize = null;
    public int currentBannerAlignment = 14;
    public RelativeLayout bannerLayout = null;
    public String interstitialAdUnitId = "";
    public int interstitialAdQueueCapacity = 1;
    public final ConcurrentLinkedQueue<InterstitialAd> interstitialAdQueue = new ConcurrentLinkedQueue<>();
    public String serverSideVerificationUserId = null;
    public String serverSideVerificationCustomData = null;
    public String rewardedUnitId = "";
    public int rewardedAdQueueCapacity = 1;
    public final ConcurrentLinkedQueue<RewardedAd> rewardedAdQueue = new ConcurrentLinkedQueue<>();
    public String rewardedInterstitialAdUnitId = "";
    public int rewardedAdInterstitialQueueCapacity = 1;
    public final ConcurrentLinkedQueue<RewardedInterstitialAd> rewardedInterstitialAdQueue = new ConcurrentLinkedQueue<>();
    public String appOpenAdUnitId = "";
    public int appOpenAdOrientation = 0;
    public long appOpenAdLoadTime = 0;
    public int appOpenAdExpirationTime = 4;
    public AppOpenAd appOpenAd = null;
    public boolean triggerOnPaidEvent = false;
    public boolean triggerAppOpenAd = false;

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.GoogleMobileAdsGM$1 */
    public final class AnonymousClass1 extends AdListener {
        public AnonymousClass1() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            GoogleMobileAdsGM.this.sendAsyncEvent("AdMob_Banner_OnLoaded", null);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(LoadAdError loadAdError) {
            HashMap map = new HashMap();
            map.put(kBfGXgdfpo.kcZMJ, loadAdError.zzb);
            map.put("errorCode", Double.valueOf(((AdError) loadAdError).zza));
            GoogleMobileAdsGM.this.sendAsyncEvent("AdMob_Banner_OnLoadFailed", map);
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.GoogleMobileAdsGM$2 */
    public final class AnonymousClass2 extends InterstitialAdLoadCallback {
        public final /* synthetic */ GoogleMobileAdsGM this$0;
        public final /* synthetic */ ConcurrentLinkedQueue val$adQueue;
        public final /* synthetic */ String val$adUnitId;
        public final /* synthetic */ String val$callingMethod;
        public final /* synthetic */ int val$maxInstances;

        public AnonymousClass2(int i, GoogleMobileAdsGM googleMobileAdsGM, String str, String str2, ConcurrentLinkedQueue concurrentLinkedQueue) {
            this.this$0 = googleMobileAdsGM;
            this.val$adQueue = concurrentLinkedQueue;
            this.val$maxInstances = i;
            this.val$callingMethod = str;
            this.val$adUnitId = str2;
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public final void onAdFailedToLoad(LoadAdError loadAdError) {
            HashMap map = new HashMap();
            map.put("unit_id", this.val$adUnitId);
            map.put("errorMessage", loadAdError.zzb);
            map.put("errorCode", Double.valueOf(((AdError) loadAdError).zza));
            this.this$0.sendAsyncEvent("AdMob_Interstitial_OnLoadFailed", map);
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public final void onAdLoaded(Object obj) {
            InterstitialAd interstitialAd = (InterstitialAd) obj;
            ConcurrentLinkedQueue concurrentLinkedQueue = this.val$adQueue;
            if (concurrentLinkedQueue.size() >= this.val$maxInstances) {
                Log.i(dLDI.hhJrk, this.val$callingMethod + " :: Maximum number of loaded ads reached.");
                return;
            }
            concurrentLinkedQueue.offer(interstitialAd);
            GoogleMobileAdsGM googleMobileAdsGM = this.this$0;
            if (googleMobileAdsGM.triggerOnPaidEvent) {
                interstitialAd.setOnPaidEventListener(new CodelessManager$$ExternalSyntheticLambda0(this, interstitialAd, 3));
            }
            HashMap map = new HashMap();
            map.put("unit_id", this.val$adUnitId);
            googleMobileAdsGM.sendAsyncEvent("AdMob_Interstitial_OnLoaded", map);
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.GoogleMobileAdsGM$4 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass4 extends RewardedAdLoadCallback {
        public final /* synthetic */ GoogleMobileAdsGM this$0;
        public final /* synthetic */ ConcurrentLinkedQueue val$adQueue;
        public final /* synthetic */ String val$adUnitId;
        public final /* synthetic */ String val$callingMethod;
        public final /* synthetic */ int val$maxInstances;
        public final /* synthetic */ String val$ssvCustomData;
        public final /* synthetic */ String val$ssvUserId;

        public AnonymousClass4(int i, GoogleMobileAdsGM googleMobileAdsGM, String str, String str2, String str3, String str4, ConcurrentLinkedQueue concurrentLinkedQueue) {
            this.this$0 = googleMobileAdsGM;
            this.val$adQueue = concurrentLinkedQueue;
            this.val$maxInstances = i;
            this.val$callingMethod = str;
            this.val$ssvUserId = str2;
            this.val$ssvCustomData = str3;
            this.val$adUnitId = str4;
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public final void onAdFailedToLoad(LoadAdError loadAdError) {
            HashMap map = new HashMap();
            map.put("unit_id", this.val$adUnitId);
            map.put("errorMessage", loadAdError.zzb);
            map.put("errorCode", Double.valueOf(((AdError) loadAdError).zza));
            this.this$0.sendAsyncEvent("AdMob_RewardedVideo_OnLoadFailed", map);
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public final void onAdLoaded(Object obj) {
            RewardedAd rewardedAd = (RewardedAd) obj;
            ConcurrentLinkedQueue concurrentLinkedQueue = this.val$adQueue;
            if (concurrentLinkedQueue.size() >= this.val$maxInstances) {
                Log.i(GoogleMobileAdsGM.LOG_TAG, this.val$callingMethod + " :: Maximum number of loaded ads reached.");
                return;
            }
            String str = this.val$ssvUserId;
            String str2 = this.val$ssvCustomData;
            GoogleMobileAdsGM googleMobileAdsGM = this.this$0;
            googleMobileAdsGM.configureServerSideVerification(rewardedAd, str, str2);
            concurrentLinkedQueue.offer(rewardedAd);
            if (googleMobileAdsGM.triggerOnPaidEvent) {
                rewardedAd.setOnPaidEventListener(new CodelessManager$$ExternalSyntheticLambda0(this, rewardedAd, 4));
            }
            HashMap map = new HashMap();
            map.put("unit_id", this.val$adUnitId);
            googleMobileAdsGM.sendAsyncEvent("AdMob_RewardedVideo_OnLoaded", map);
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.GoogleMobileAdsGM$6 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass6 extends RewardedInterstitialAdLoadCallback {
        public final /* synthetic */ GoogleMobileAdsGM this$0;
        public final /* synthetic */ ConcurrentLinkedQueue val$adQueue;
        public final /* synthetic */ String val$adUnitId;
        public final /* synthetic */ String val$callingMethod;
        public final /* synthetic */ int val$maxInstances;
        public final /* synthetic */ String val$ssvCustomData;
        public final /* synthetic */ String val$ssvUserId;

        public AnonymousClass6(int i, GoogleMobileAdsGM googleMobileAdsGM, String str, String str2, String str3, String str4, ConcurrentLinkedQueue concurrentLinkedQueue) {
            this.this$0 = googleMobileAdsGM;
            this.val$adQueue = concurrentLinkedQueue;
            this.val$maxInstances = i;
            this.val$callingMethod = str;
            this.val$ssvUserId = str2;
            this.val$ssvCustomData = str3;
            this.val$adUnitId = str4;
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public final void onAdFailedToLoad(LoadAdError loadAdError) {
            HashMap map = new HashMap();
            map.put("unit_id", this.val$adUnitId);
            map.put("errorMessage", loadAdError.zzb);
            map.put("errorCode", Double.valueOf(((AdError) loadAdError).zza));
            this.this$0.sendAsyncEvent("AdMob_RewardedInterstitial_OnLoadFailed", map);
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public final void onAdLoaded(Object obj) {
            RewardedInterstitialAd rewardedInterstitialAd = (RewardedInterstitialAd) obj;
            ConcurrentLinkedQueue concurrentLinkedQueue = this.val$adQueue;
            if (concurrentLinkedQueue.size() >= this.val$maxInstances) {
                Log.i(GoogleMobileAdsGM.LOG_TAG, this.val$callingMethod + " :: Maximum number of loaded ads reached.");
                return;
            }
            String str = this.val$ssvUserId;
            String str2 = this.val$ssvCustomData;
            GoogleMobileAdsGM googleMobileAdsGM = this.this$0;
            googleMobileAdsGM.configureServerSideVerification(rewardedInterstitialAd, str, str2);
            concurrentLinkedQueue.offer(rewardedInterstitialAd);
            if (googleMobileAdsGM.triggerOnPaidEvent) {
                rewardedInterstitialAd.setOnPaidEventListener(new CodelessManager$$ExternalSyntheticLambda0(this, rewardedInterstitialAd, 5));
            }
            HashMap map = new HashMap();
            map.put("unit_id", this.val$adUnitId);
            googleMobileAdsGM.sendAsyncEvent("AdMob_RewardedInterstitial_OnLoaded", map);
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.GoogleMobileAdsGM$8 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass8 extends AppOpenAd.AppOpenAdLoadCallback {
        public final /* synthetic */ String val$adUnitId;

        public AnonymousClass8(String str) {
            this.val$adUnitId = str;
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public final void onAdFailedToLoad(LoadAdError loadAdError) {
            GoogleMobileAdsGM googleMobileAdsGM = GoogleMobileAdsGM.this;
            googleMobileAdsGM.appOpenAd = null;
            HashMap map = new HashMap();
            map.put("unit_id", this.val$adUnitId);
            map.put("errorMessage", loadAdError.zzb);
            map.put("errorCode", Double.valueOf(((AdError) loadAdError).zza));
            googleMobileAdsGM.sendAsyncEvent("AdMob_AppOpenAd_OnLoadFailed", map);
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public final void onAdLoaded(Object obj) {
            long time = new Date().getTime();
            GoogleMobileAdsGM googleMobileAdsGM = GoogleMobileAdsGM.this;
            googleMobileAdsGM.appOpenAdLoadTime = time;
            googleMobileAdsGM.appOpenAd = (AppOpenAd) obj;
            if (googleMobileAdsGM.triggerOnPaidEvent) {
                googleMobileAdsGM.appOpenAd.setOnPaidEventListener(new InputConnectionCompat$$ExternalSyntheticLambda0(this, 1));
            }
            HashMap map = new HashMap();
            map.put("unit_id", this.val$adUnitId);
            googleMobileAdsGM.sendAsyncEvent("AdMob_AppOpenAd_OnLoaded", map);
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.GoogleMobileAdsGM$9 */
    public final class AnonymousClass9 extends FullScreenContentCallback {
        public AnonymousClass9() {
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public final void onAdDismissedFullScreenContent() {
            GoogleMobileAdsGM googleMobileAdsGM = GoogleMobileAdsGM.this;
            googleMobileAdsGM.cleanAd(googleMobileAdsGM.appOpenAd, new GoogleMobileAdsGM$9$$ExternalSyntheticLambda0(this, 1));
            googleMobileAdsGM.appOpenAd = null;
            googleMobileAdsGM.sendAsyncEvent("AdMob_AppOpenAd_OnDismissed", null);
            if (googleMobileAdsGM.triggerAppOpenAd) {
                googleMobileAdsGM.AdMob_AppOpenAd_Load();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public final void onAdShowedFullScreenContent() {
            GoogleMobileAdsGM.this.sendAsyncEvent("AdMob_AppOpenAd_OnFullyShown", null);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public final void onAdFailedToShowFullScreenContent(AdError adError) {
            GoogleMobileAdsGM googleMobileAdsGM = GoogleMobileAdsGM.this;
            googleMobileAdsGM.isShowingAd = false;
            googleMobileAdsGM.cleanAd(googleMobileAdsGM.appOpenAd, new GoogleMobileAdsGM$9$$ExternalSyntheticLambda0(this, 0));
            googleMobileAdsGM.appOpenAd = null;
            HashMap map = new HashMap();
            map.put("errorMessage", adError.zzb);
            map.put(MnHfHMYQDPUO.nYmQ, Double.valueOf(adError.zza));
            googleMobileAdsGM.sendAsyncEvent("AdMob_AppOpenAd_OnShowFailed", map);
            if (googleMobileAdsGM.triggerAppOpenAd) {
                googleMobileAdsGM.AdMob_AppOpenAd_Load();
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface AdCleaner {
        void clean(Object obj);
    }

    public static /* synthetic */ void $r8$lambda$JhyGSPHcVJ79stSKHuTWl3EUdk8(int i, GoogleMobileAdsGM googleMobileAdsGM, String str, String str2, String str3, String str4, ConcurrentLinkedQueue concurrentLinkedQueue) {
        googleMobileAdsGM.lambda$loadRewardedAd$10(str, str2, concurrentLinkedQueue, i, str3, str4);
    }

    public static /* synthetic */ void $r8$lambda$pNKpGF2UysJFf_kqCgl2SJ0k4f4(int i, GoogleMobileAdsGM googleMobileAdsGM, String str, String str2, String str3, String str4, ConcurrentLinkedQueue concurrentLinkedQueue) {
        googleMobileAdsGM.lambda$loadRewardedInterstitialAd$13(str, str2, concurrentLinkedQueue, i, str3, str4);
    }

    public GoogleMobileAdsGM() {
        RunnerActivity runnerActivity = RunnerActivity.CurrentActivity;
        if (runnerActivity != null) {
            this.activityRef = new WeakReference<>(runnerActivity);
            this.rootView = (ViewGroup) runnerActivity.findViewById(android.R.id.content);
        } else {
            Log.w(LOG_TAG, "Activity reference is null in constructor.");
            this.activityRef = new WeakReference<>(null);
            this.rootView = null;
        }
    }

    public double AdMob_AppOpenAd_Load() {
        if (!validateInitialized("AdMob_AppOpenAd_Load")) {
            return -1.0d;
        }
        if (!validateAdId(this.appOpenAdUnitId, "AdMob_AppOpenAd_Load")) {
            return -2.0d;
        }
        if (!validateViewHandler("AdMob_AppOpenAd_Load")) {
            return -7.0d;
        }
        if (appOpenAdIsValid("AdMob_AppOpenAd_Load")) {
            return 0.0d;
        }
        loadAppOpenAd(this.appOpenAdUnitId, "AdMob_AppOpenAd_Load");
        return 0.0d;
    }

    private double AdMob_AppOpenAd_Show() {
        if (!validateInitialized("AdMob_AppOpenAd_Show")) {
            return -1.0d;
        }
        if (!validateViewHandler("AdMob_AppOpenAd_Show")) {
            return -7.0d;
        }
        if (!appOpenAdIsValid("AdMob_AppOpenAd_Show")) {
            return -4.0d;
        }
        showAppOpenAd("AdMob_AppOpenAd_Show");
        return 0.0d;
    }

    private AdRequest buildAdRequest() {
        AdRequest.Builder builder = new AdRequest.Builder();
        ((AppCompatTextHelper) builder.mBuilder).mFontTypeface = "gmext-admob-" + RunnerJNILib.extGetVersion(LOG_TAG);
        if (this.isRdpEnabled) {
            Bundle bundle = new Bundle();
            bundle.putInt("rdp", 1);
            builder.addNetworkExtrasBundle(bundle);
        }
        return new AdRequest(builder);
    }

    private RequestConfiguration buildRequestConfiguration(String str) {
        RequestConfiguration requestConfiguration = zzey.zzf().zzn;
        requestConfiguration.getClass();
        RequestConfiguration.Builder builder = new RequestConfiguration.Builder();
        builder.setTagForChildDirectedTreatment(requestConfiguration.zzb);
        builder.setTagForUnderAgeOfConsent(requestConfiguration.zzc);
        builder.setMaxAdContentRating(requestConfiguration.zzd);
        ArrayList arrayList = requestConfiguration.zze;
        ArrayList arrayList2 = builder.zzd;
        arrayList2.clear();
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        if (this.isTestDevice) {
            List listSingletonList = Collections.singletonList(getDeviceID(str));
            arrayList2.clear();
            if (listSingletonList != null) {
                arrayList2.addAll(listSingletonList);
            }
        }
        if (this.targetCOPPA) {
            builder.setTagForChildDirectedTreatment(1);
        }
        if (this.targetUnderAge) {
            builder.setTagForUnderAgeOfConsent(1);
        }
        builder.setMaxAdContentRating(this.maxAdContentRating);
        return new RequestConfiguration(builder.zza, builder.zzb, builder.zzc, arrayList2, builder.zze);
    }

    private boolean canShowAds(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        String string = sharedPreferences.getString("IABTCF_PurposeConsents", "");
        String string2 = sharedPreferences.getString("IABTCF_VendorConsents", "");
        String string3 = sharedPreferences.getString("IABTCF_VendorLegitimateInterests", "");
        String string4 = sharedPreferences.getString("IABTCF_PurposeLegitimateInterests", "");
        boolean zHasAttribute = hasAttribute(string2, 755);
        boolean zHasAttribute2 = hasAttribute(string3, 755);
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(2);
        arrayList2.add(7);
        arrayList2.add(9);
        arrayList2.add(10);
        return hasConsentFor(arrayList, string, zHasAttribute) && hasConsentOrLegitimateInterestFor(arrayList2, string, string4, zHasAttribute, zHasAttribute2);
    }

    public <T> void cleanAd(T t, AdCleaner adCleaner) {
        if (t != null) {
            RunnerActivity.ViewHandler.post(new GraphRequest$Companion$$ExternalSyntheticLambda1(adCleaner, t, 5));
        }
    }

    public void cleanUpAd(AdView adView) {
        adView.setAdListener(null);
        adView.setOnPaidEventListener(null);
    }

    private String computeMD5(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public void configureServerSideVerification(Object obj, String str, String str2) {
        if (obj == null) {
            Log.e(LOG_TAG, "Ad instance is null. Cannot configure server-side verification.");
            return;
        }
        if ((str == null || str.isEmpty()) && (str2 == null || str2.isEmpty())) {
            return;
        }
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = new FetchedAppSettings.DialogFeatureConfig();
        dialogFeatureConfig.dialogName = "";
        dialogFeatureConfig.featureName = "";
        if (str != null && !str.isEmpty()) {
            dialogFeatureConfig.dialogName = str;
        }
        if (str2 != null && !str2.isEmpty()) {
            dialogFeatureConfig.featureName = str2;
        }
        ServerSideVerificationOptions serverSideVerificationOptions = new ServerSideVerificationOptions(dialogFeatureConfig);
        if (obj instanceof RewardedAd) {
            ((RewardedAd) obj).setServerSideVerificationOptions(serverSideVerificationOptions);
        } else if (obj instanceof RewardedInterstitialAd) {
            ((RewardedInterstitialAd) obj).setServerSideVerificationOptions(serverSideVerificationOptions);
        } else {
            Log.e(LOG_TAG, "Unsupported ad type for server-side verification.");
        }
    }

    private void createBannerAdView(final double d, final boolean z, int i, final String str) {
        RunnerActivity.ViewHandler.post(new Runnable() { // from class: com.daerisoft.thespikerm.GoogleMobileAdsGM$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createBannerAdView$7(str, d, z);
            }
        });
    }

    private void deleteBannerAdView() {
        cleanAd(this.bannerAdView, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 3));
        this.bannerLayout.removeView(this.bannerAdView);
        this.bannerAdView.destroy();
        this.bannerAdView = null;
        this.rootView.removeView(this.bannerLayout);
        this.bannerLayout = null;
        this.bannerSize = null;
    }

    private <T> void freeLoadedInstances(final Queue<T> queue, final double d, final AdCleaner adCleaner) {
        RunnerActivity.ViewHandler.post(new Runnable() { // from class: com.daerisoft.thespikerm.GoogleMobileAdsGM$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                GoogleMobileAdsGM.lambda$freeLoadedInstances$27(queue, d, adCleaner);
            }
        });
    }

    private Activity getActivity(String str) {
        Activity activity = this.activityRef.get();
        if (activity == null) {
            Log.w(LOG_TAG, str + " :: Activity reference is null.");
        }
        return activity;
    }

    private AdSize getAdSize(double d, String str) {
        int iRound;
        AdSize adSize;
        DisplayMetrics displayMetrics;
        Activity activity = getActivity(str);
        if (activity == null) {
            return null;
        }
        switch ((int) d) {
            case 0:
                return AdSize.BANNER;
            case 1:
                return AdSize.LARGE_BANNER;
            case 2:
                return AdSize.MEDIUM_RECTANGLE;
            case 3:
                return AdSize.FULL_BANNER;
            case 4:
                return AdSize.LEADERBOARD;
            case 5:
                return AdSize.SMART_BANNER;
            case 6:
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                int i = (int) (displayMetrics2.widthPixels / displayMetrics2.density);
                AdSize adSize2 = AdSize.BANNER;
                zzfrw zzfrwVar = zzf.zza;
                Context applicationContext = activity.getApplicationContext();
                Activity applicationContext2 = activity;
                if (applicationContext != null) {
                    applicationContext2 = activity.getApplicationContext();
                }
                Resources resources = applicationContext2.getResources();
                int iRound2 = (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null || resources.getConfiguration() == null) ? -1 : Math.round(displayMetrics.heightPixels / displayMetrics.density);
                if (iRound2 == -1) {
                    adSize = AdSize.INVALID;
                } else {
                    int iMin = Math.min(90, Math.round(iRound2 * 0.15f));
                    if (i > 655) {
                        iRound = Math.round((i / 728.0f) * 90.0f);
                    } else if (i > 632) {
                        iRound = 81;
                    } else if (i > 526) {
                        iRound = Math.round((i / 468.0f) * 60.0f);
                    } else {
                        iRound = i > 432 ? 68 : Math.round((i / 320.0f) * 50.0f);
                    }
                    adSize = new AdSize(i, Math.max(Math.min(iRound, iMin), 50));
                }
                adSize.zze = true;
                return adSize;
            default:
                Log.w(LOG_TAG, str + " :: Invalid banner size.");
                return null;
        }
    }

    private String getDeviceID(String str) {
        Activity activity = getActivity(str);
        if (activity == null) {
            return "";
        }
        String strComputeMD5 = computeMD5(Settings.Secure.getString(activity.getContentResolver(), "android_id"));
        if (strComputeMD5 != null) {
            return strComputeMD5.toUpperCase();
        }
        Log.w(LOG_TAG, "Failed to generate MD5 hash of ANDROID_ID.");
        return "";
    }

    private boolean hasAttribute(String str, int i) {
        return str != null && str.length() >= i && str.charAt(i - 1) == '1';
    }

    private boolean hasConsentOrLegitimateInterestFor(List<Integer> list, String str, String str2, boolean z, boolean z2) {
        Iterator<Integer> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                return true;
            }
            Integer next = it.next();
            boolean z3 = hasAttribute(str2, next.intValue()) && z2;
            boolean z4 = hasAttribute(str, next.intValue()) && z;
            if (!z3 && !z4) {
                Log.e(LOG_TAG, "hasConsentOrLegitimateInterestFor: denied for #" + next);
                return false;
            }
        }
    }

    public /* synthetic */ void lambda$AdMob_Banner_Hide$4() {
        if (validateActiveBannerAd("AdMob_Banner_Hide")) {
            this.bannerAdView.setVisibility(8);
        }
    }

    public /* synthetic */ void lambda$AdMob_Banner_Move$2(double d) {
        if (validateActiveBannerAd("AdMob_Banner_Move")) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(this.currentBannerAlignment);
            layoutParams.addRule(d > 0.5d ? 12 : 10);
            this.bannerAdView.setLayoutParams(layoutParams);
        }
    }

    public /* synthetic */ void lambda$AdMob_Banner_Remove$5() {
        if (validateActiveBannerAd("AdMob_Banner_Remove")) {
            deleteBannerAdView();
        }
    }

    public /* synthetic */ void lambda$AdMob_Consent_Load$21(ConsentForm consentForm) {
        this.consentFormInstance = consentForm;
        sendAsyncEvent("AdMob_Consent_OnLoaded", null);
    }

    public void lambda$AdMob_Consent_Load$22(FormError formError) {
        HashMap map = new HashMap();
        map.put("errorMessage", formError.zzb);
        map.put("errorCode", Double.valueOf(formError.zza));
        sendAsyncEvent("AdMob_Consent_OnLoadFailed", map);
    }

    public void lambda$AdMob_Consent_Load$23(Activity activity) {
        zza.zza(activity).zzc().zzb(new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 1), new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 2));
    }

    public /* synthetic */ void lambda$AdMob_Consent_RequestInfoUpdate$18() {
        sendAsyncEvent("AdMob_Consent_OnRequestInfoUpdated", null);
    }

    public void lambda$AdMob_Consent_RequestInfoUpdate$19(FormError formError) {
        HashMap map = new HashMap();
        map.put("errorMessage", formError.zzb);
        map.put("errorCode", Double.valueOf(formError.zza));
        sendAsyncEvent("AdMob_Consent_OnRequestInfoUpdateFailed", map);
    }

    public void lambda$AdMob_Consent_RequestInfoUpdate$20(double d) {
        Activity activity = getActivity("AdMob_Consent_RequestInfoUpdate");
        if (activity == null) {
            return;
        }
        zzcj zzcjVar = new zzcj(3);
        zzcjVar.zza = this.targetUnderAge;
        if (d != 3.0d) {
            Splitter splitter = new Splitter(activity);
            splitter.limit = (int) d;
            ((ArrayList) splitter.trimmer).add(getDeviceID("AdMob_Consent_RequestInfoUpdate"));
            zzcjVar.zzb = splitter.build();
        }
        ConsentRequestParameters consentRequestParameters = new ConsentRequestParameters(zzcjVar);
        zzj zzjVarZzb = zza.zza(activity).zzb();
        this.consentInformation = zzjVarZzb;
        zzjVarZzb.requestConsentInfoUpdate(activity, consentRequestParameters, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 0), new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 5));
    }

    public void lambda$AdMob_Consent_Show$24(FormError formError) {
        if (formError == null) {
            sendAsyncEvent("AdMob_Consent_OnShown", null);
        } else {
            HashMap map = new HashMap();
            map.put("errorMessage", formError.zzb);
            map.put("errorCode", Double.valueOf(formError.zza));
            sendAsyncEvent("AdMob_Consent_OnShowFailed", map);
        }
        this.consentFormInstance = null;
    }

    public /* synthetic */ void lambda$AdMob_Consent_Show$25() {
        Activity activity = getActivity("AdMob_Consent_Show");
        if (activity == null) {
            return;
        }
        ConsentForm consentForm = this.consentFormInstance;
        if (consentForm != null) {
            consentForm.show(activity, new GoogleMobileAdsGM$$ExternalSyntheticLambda19(this));
        } else {
            Log.i(LOG_TAG, "AdMob_Consent_Show :: There is no loaded consent form.");
        }
    }

    public /* synthetic */ void lambda$AdMob_Initialize$0(InitializationStatus initializationStatus) {
        Map adapterStatusMap = initializationStatus.getAdapterStatusMap();
        for (String str : adapterStatusMap.keySet()) {
            AdapterStatus adapterStatus = (AdapterStatus) adapterStatusMap.get(str);
            Log.d(LOG_TAG, String.format("Adapter name: %s, Description: %s, Latency: %d", str, adapterStatus.getDescription(), Integer.valueOf(adapterStatus.getLatency())));
        }
        sendAsyncEvent("AdMob_OnInitialized", null);
        initializeAdUnits();
        this.isInitialized = true;
    }

    public void lambda$AdMob_Initialize$1() {
        RequestConfiguration requestConfigurationBuildRequestConfiguration = buildRequestConfiguration("AdMob_Initialize");
        zzey zzeyVarZzf = zzey.zzf();
        zzeyVarZzf.getClass();
        zzah.checkArgument(requestConfigurationBuildRequestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (zzeyVarZzf.zzk) {
            try {
                RequestConfiguration requestConfiguration = zzeyVarZzf.zzn;
                zzeyVarZzf.zzn = requestConfigurationBuildRequestConfiguration;
                zzdb zzdbVar = zzeyVarZzf.zzl;
                if (zzdbVar != null) {
                    if (requestConfiguration.zzb != requestConfigurationBuildRequestConfiguration.zzb || requestConfiguration.zzc != requestConfigurationBuildRequestConfiguration.zzc) {
                        try {
                            zzdbVar.zzu(new zzfx(requestConfigurationBuildRequestConfiguration));
                        } catch (RemoteException e) {
                            zzo.zzh("Unable to set request configuration parcel.", e);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            Activity activity = getActivity("AdMob_Initialize");
            if (activity == null) {
                return;
            }
            MobileAds.initialize(activity, new GoogleMobileAdsGM$$ExternalSyntheticLambda17(this));
        } catch (Exception e2) {
            Log.i(LOG_TAG, "GoogleMobileAds Init Error: " + e2.toString());
            Log.i(LOG_TAG, e2.toString());
        }
    }

    public void lambda$createBannerAdView$6(AdValue adValue) {
        ResponseInfo responseInfo = this.bannerAdView.getResponseInfo();
        Objects.requireNonNull(responseInfo);
        AdapterResponseInfo adapterResponseInfo = responseInfo.zzc;
        if (adapterResponseInfo == null) {
            return;
        }
        onPaidEventHandler(adValue, this.bannerAdView.getAdUnitId(), "Banner", adapterResponseInfo, this.bannerAdView.getResponseInfo().getMediationAdapterClassName());
    }

    public /* synthetic */ void lambda$createBannerAdView$7(String str, double d, boolean z) {
        if (this.bannerAdView != null) {
            deleteBannerAdView();
        }
        Activity activity = getActivity(str);
        if (activity == null) {
            return;
        }
        AdSize adSize = getAdSize(d, str);
        this.bannerSize = adSize;
        if (adSize == null) {
            return;
        }
        this.bannerLayout = new RelativeLayout(activity);
        AdView adView = new AdView(activity);
        this.bannerAdView = adView;
        if (this.triggerOnPaidEvent) {
            adView.setOnPaidEventListener(new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 4));
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(this.currentBannerAlignment);
        layoutParams.addRule(z ? 12 : 10);
        this.bannerLayout.addView(this.bannerAdView, layoutParams);
        this.rootView.addView(this.bannerLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.bannerAdView.setAdListener(new AdListener() { // from class: com.daerisoft.thespikerm.GoogleMobileAdsGM.1
            public AnonymousClass1() {
            }

            @Override // com.google.android.gms.ads.AdListener
            public final void onAdLoaded() {
                GoogleMobileAdsGM.this.sendAsyncEvent("AdMob_Banner_OnLoaded", null);
            }

            @Override // com.google.android.gms.ads.AdListener
            public final void onAdFailedToLoad(LoadAdError loadAdError) {
                HashMap map = new HashMap();
                map.put(kBfGXgdfpo.kcZMJ, loadAdError.zzb);
                map.put("errorCode", Double.valueOf(((AdError) loadAdError).zza));
                GoogleMobileAdsGM.this.sendAsyncEvent("AdMob_Banner_OnLoadFailed", map);
            }
        });
        this.bannerAdView.setAdSize(this.bannerSize);
        this.bannerAdView.setAdUnitId(this.bannerAdUnitId);
        this.bannerAdView.requestLayout();
        this.bannerAdView.setVisibility(0);
        this.bannerAdView.loadAd(buildAdRequest());
    }

    public static /* synthetic */ void lambda$freeLoadedInstances$27(Queue queue, double d, AdCleaner adCleaner) {
        synchronized (queue) {
            if (d < 0.0d) {
                try {
                    d = queue.size();
                } catch (Throwable th) {
                    throw th;
                }
            }
            while (d > 0.0d && !queue.isEmpty()) {
                Object objPoll = queue.poll();
                if (objPoll != null) {
                    adCleaner.clean(objPoll);
                }
                d -= 1.0d;
            }
        }
    }

    public /* synthetic */ void lambda$loadAppOpenAd$16(String str, String str2) {
        Activity activity = getActivity(str);
        if (activity == null) {
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        this.appOpenAdOrientation = activity.getResources().getConfiguration().orientation;
        AppOpenAd.load(applicationContext, this.appOpenAdUnitId, buildAdRequest(), new AnonymousClass8(str2));
    }

    public /* synthetic */ void lambda$loadInterstitialAd$8(String str, String str2, ConcurrentLinkedQueue concurrentLinkedQueue, int i) {
        Activity activity = getActivity(str);
        if (activity == null) {
            return;
        }
        InterstitialAd.load(activity.getApplicationContext(), str2, buildAdRequest(), new AnonymousClass2(i, this, str, str2, concurrentLinkedQueue));
    }

    private /* synthetic */ void lambda$loadRewardedAd$10(String str, String str2, ConcurrentLinkedQueue concurrentLinkedQueue, int i, String str3, String str4) {
        Activity activity = getActivity(str);
        if (activity == null) {
            return;
        }
        RewardedAd.load(activity.getApplicationContext(), str2, buildAdRequest(), new AnonymousClass4(i, this, str, str3, str4, str2, concurrentLinkedQueue));
    }

    private /* synthetic */ void lambda$loadRewardedInterstitialAd$13(String str, String str2, ConcurrentLinkedQueue concurrentLinkedQueue, int i, String str3, String str4) {
        Activity activity = getActivity(str);
        if (activity == null) {
            return;
        }
        RewardedInterstitialAd.load(activity.getApplicationContext(), str2, buildAdRequest(), new AnonymousClass6(i, this, str, str3, str4, str2, concurrentLinkedQueue));
    }

    public static /* synthetic */ void lambda$sendAsyncEvent$28(String str, Map map) {
        double dDoubleValue;
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
        RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", str);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, str2, (String) value);
                } else if ((value instanceof Double) || (value instanceof Integer) || (value instanceof Float) || (value instanceof Boolean)) {
                    if (value instanceof Boolean) {
                        dDoubleValue = ((Boolean) value).booleanValue() ? 1.0d : 0.0d;
                    } else if (value instanceof Integer) {
                        dDoubleValue = ((Integer) value).doubleValue();
                    } else {
                        dDoubleValue = value instanceof Float ? ((Float) value).doubleValue() : ((Double) value).doubleValue();
                    }
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, str2, dDoubleValue);
                } else if (value instanceof Long) {
                    Long l = (Long) value;
                    long jLongValue = l.longValue();
                    if (Math.abs(jLongValue) <= MAX_DOUBLE_SAFE) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, str2, jLongValue);
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, str2, String.format("@i64@%016x$i64$", l));
                    }
                } else if (value instanceof Map) {
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, str2, new JSONObject((Map) value).toString());
                } else if (value instanceof List) {
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, str2, new JSONArray((Collection) value).toString());
                } else {
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, str2, value.toString());
                }
            }
        }
        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
    }

    public /* synthetic */ void lambda$showAppOpenAd$17(String str) {
        Activity activity;
        if (this.appOpenAd == null || (activity = getActivity(str)) == null) {
            return;
        }
        this.appOpenAd.setFullScreenContentCallback(new AnonymousClass9());
        this.isShowingAd = true;
        this.appOpenAd.show(activity);
    }

    public /* synthetic */ void lambda$showInterstitialAd$9(InterstitialAd interstitialAd, String str) {
        Activity activity;
        if (interstitialAd == null || (activity = getActivity(str)) == null) {
            return;
        }
        interstitialAd.setFullScreenContentCallback(new zzd(this, interstitialAd, 1));
        interstitialAd.show(activity);
        this.isShowingAd = true;
    }

    public /* synthetic */ void lambda$showRewardedAd$11(RewardedAd rewardedAd, RewardItem rewardItem) {
        int amount = rewardItem.getAmount();
        String type = rewardItem.getType();
        HashMap map = new HashMap();
        map.put("unit_id", rewardedAd.getAdUnitId());
        map.put("reward_amount", Double.valueOf(amount));
        map.put("reward_type", type);
        sendAsyncEvent("AdMob_RewardedVideo_OnReward", map);
    }

    public /* synthetic */ void lambda$showRewardedAd$12(RewardedAd rewardedAd, String str) {
        Activity activity;
        if (rewardedAd == null || (activity = getActivity(str)) == null) {
            return;
        }
        rewardedAd.setFullScreenContentCallback(new zzd(this, rewardedAd, 2));
        rewardedAd.show(activity, new CodelessManager$$ExternalSyntheticLambda0(this, rewardedAd, 2));
        this.isShowingAd = true;
    }

    public /* synthetic */ void lambda$showRewardedInterstitialAd$14(RewardedInterstitialAd rewardedInterstitialAd, RewardItem rewardItem) {
        int amount = rewardItem.getAmount();
        String type = rewardItem.getType();
        HashMap map = new HashMap();
        map.put("unit_id", rewardedInterstitialAd.getAdUnitId());
        map.put("reward_amount", Double.valueOf(amount));
        map.put("reward_type", type);
        sendAsyncEvent("AdMob_RewardedInterstitial_OnReward", map);
    }

    public /* synthetic */ void lambda$showRewardedInterstitialAd$15(RewardedInterstitialAd rewardedInterstitialAd, String str) {
        Activity activity;
        if (rewardedInterstitialAd == null || (activity = getActivity(str)) == null) {
            return;
        }
        rewardedInterstitialAd.setFullScreenContentCallback(new zzd(this, rewardedInterstitialAd, 3));
        rewardedInterstitialAd.show(activity, new CodelessManager$$ExternalSyntheticLambda0(this, rewardedInterstitialAd, 1));
        this.isShowingAd = true;
    }

    private void loadAppOpenAd(String str, String str2) {
        RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda1(this, str2, str));
    }

    private void loadInterstitialAd(String str, ConcurrentLinkedQueue<InterstitialAd> concurrentLinkedQueue, int i, String str2) {
        RunnerActivity.ViewHandler.post(new SuncyanNet$$ExternalSyntheticLambda10(i, this, str2, str, concurrentLinkedQueue));
    }

    private void loadRewardedAd(String str, ConcurrentLinkedQueue<RewardedAd> concurrentLinkedQueue, int i, String str2) {
        RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda23(this, str2, str, concurrentLinkedQueue, i, this.serverSideVerificationUserId, this.serverSideVerificationCustomData, 1));
    }

    private void loadRewardedInterstitialAd(String str, ConcurrentLinkedQueue<RewardedInterstitialAd> concurrentLinkedQueue, int i, String str2) {
        RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda23(this, str2, str, concurrentLinkedQueue, i, this.serverSideVerificationUserId, this.serverSideVerificationCustomData, 0));
    }

    public void sendAsyncEvent(String str, Map<String, Object> map) {
        RunnerActivity.CurrentActivity.runOnUiThread(new GraphRequest$Companion$$ExternalSyntheticLambda1(str, map, 8));
    }

    private void showAppOpenAd(String str) {
        RunnerActivity.ViewHandler.post(new GraphRequest$Companion$$ExternalSyntheticLambda1(this, str, 7));
    }

    private void showInterstitialAd(ConcurrentLinkedQueue<InterstitialAd> concurrentLinkedQueue, String str) {
        RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda1(this, concurrentLinkedQueue.poll(), str, 4));
    }

    private void showRewardedAd(ConcurrentLinkedQueue<RewardedAd> concurrentLinkedQueue, String str) {
        if (validateAdLoaded(concurrentLinkedQueue, str)) {
            RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda1(this, concurrentLinkedQueue.poll(), str, 3));
        }
    }

    private void showRewardedInterstitialAd(ConcurrentLinkedQueue<RewardedInterstitialAd> concurrentLinkedQueue, String str) {
        if (validateAdLoaded(concurrentLinkedQueue, str)) {
            RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda1(this, concurrentLinkedQueue.poll(), str, 0));
        }
    }

    private <T> void trimLoadedAdsQueue(Queue<T> queue, int i, AdCleaner adCleaner) {
        int size = queue.size();
        if (size <= i) {
            return;
        }
        freeLoadedInstances(queue, size - i, adCleaner);
    }

    private boolean validateActiveBannerAd(String str) {
        if (this.bannerAdView != null) {
            return true;
        }
        Log.w(LOG_TAG, str + " :: There is no active banner ad.");
        return false;
    }

    private boolean validateAdId(String str, String str2) {
        if (!str.isEmpty()) {
            return true;
        }
        Log.w(LOG_TAG, str2 + " :: Ad unit ID is empty.");
        return false;
    }

    private <T> boolean validateAdLoaded(Queue<T> queue, String str) {
        if (!queue.isEmpty()) {
            return true;
        }
        Log.w(LOG_TAG, str + " :: There is no loaded ad in queue.");
        return false;
    }

    private boolean validateInitialized(String str) {
        if (!this.isInitialized) {
            Log.w(LOG_TAG, str + " :: Extension was not initialized.");
        }
        return this.isInitialized;
    }

    private <T> boolean validateLoadedAdsLimit(Queue<T> queue, int i, String str) {
        if (queue.size() < i) {
            return true;
        }
        Log.w(LOG_TAG, str + " :: Maximum number of loaded ads reached.");
        return false;
    }

    private boolean validateNotInitialized(String str) {
        if (this.isInitialized) {
            Log.w(LOG_TAG, str + " :: Method cannot be called after initialization.");
        }
        return !this.isInitialized;
    }

    private boolean validateViewHandler(String str) {
        if (RunnerActivity.ViewHandler != null) {
            return true;
        }
        Log.w(LOG_TAG, str + " :: ViewHandler is null, cannot post to main thread.");
        return false;
    }

    public void AdMob_AppOpenAd_Disable() {
        this.triggerAppOpenAd = false;
    }

    public double AdMob_AppOpenAd_Enable(double d) {
        if (!validateInitialized("AdMob_AppOpenAd_Enable")) {
            return -1.0d;
        }
        if (!validateAdId(this.appOpenAdUnitId, "AdMob_AppOpenAd_Enable")) {
            return -2.0d;
        }
        this.triggerAppOpenAd = true;
        if (appOpenAdIsValid("AdMob_AppOpenAd_Enable")) {
            return 0.0d;
        }
        AdMob_AppOpenAd_Load();
        return 0.0d;
    }

    public double AdMob_AppOpenAd_IsEnabled() {
        return this.triggerAppOpenAd ? 1.0d : 0.0d;
    }

    public double AdMob_AppOpenAd_IsLoaded() {
        return appOpenAdIsValid("AdMob_AppOpenAd_IsLoaded") ? 1.0d : 0.0d;
    }

    public void AdMob_AppOpenAd_Set_AdUnit(String str) {
        this.appOpenAdUnitId = str;
    }

    public double AdMob_Banner_Create(double d, double d2) {
        if (!validateInitialized("AdMob_Banner_Create")) {
            return -1.0d;
        }
        if (!validateAdId(this.bannerAdUnitId, "AdMob_Banner_Create")) {
            return -2.0d;
        }
        if (!validateViewHandler("AdMob_Banner_Create")) {
            return -7.0d;
        }
        boolean z = d2 > 0.5d;
        this.currentBannerAlignment = 14;
        createBannerAdView(d, z, 14, "AdMob_Banner_Create");
        return 0.0d;
    }

    public double AdMob_Banner_Create_Ext(double d, double d2, double d3) {
        if (!validateInitialized("AdMob_Banner_Create_Ext")) {
            return -1.0d;
        }
        if (!validateAdId(this.bannerAdUnitId, "AdMob_Banner_Create_Ext")) {
            return -2.0d;
        }
        if (!validateViewHandler("AdMob_Banner_Create_Ext")) {
            return -7.0d;
        }
        boolean z = d2 > 0.5d;
        int i = (int) d3;
        if (i == 0) {
            this.currentBannerAlignment = 9;
        } else if (i == 1) {
            this.currentBannerAlignment = 14;
        } else if (i != 2) {
            Log.w(LOG_TAG, "AdMob_Banner_Create_Ext :: Invalid horizontal alignment parameter. Defaulting to CENTER.");
            this.currentBannerAlignment = 14;
        } else {
            this.currentBannerAlignment = 11;
        }
        createBannerAdView(d, z, this.currentBannerAlignment, "AdMob_Banner_Create_Ext");
        return 0.0d;
    }

    public double AdMob_Banner_GetHeight() {
        if (this.bannerAdView == null) {
            return 0.0d;
        }
        int heightInPixels = this.bannerSize.getHeightInPixels(RunnerJNILib.ms_context);
        if (this.bannerSize == AdSize.SMART_BANNER) {
            DisplayMetrics displayMetrics = RunnerJNILib.ms_context.getResources().getDisplayMetrics();
            int iRound = Math.round(displayMetrics.heightPixels / displayMetrics.density);
            int iRound2 = Math.round(displayMetrics.density);
            if (iRound < 400) {
                heightInPixels = iRound2 * 32;
            } else {
                heightInPixels = iRound <= 720 ? iRound2 * 50 : iRound2 * 90;
            }
        }
        return heightInPixels;
    }

    public double AdMob_Banner_GetWidth() {
        if (this.bannerAdView == null) {
            return 0.0d;
        }
        AdSize adSize = this.bannerSize;
        Context context = RunnerJNILib.ms_context;
        int i = adSize.zzb;
        int iZzC = -1;
        if (i != -3) {
            if (i != -1) {
                zzf zzfVar = zzbb.zzb.zzc;
                iZzC = zzf.zzC(context, i);
            } else {
                iZzC = context.getResources().getDisplayMetrics().widthPixels;
            }
        }
        return iZzC;
    }

    public double AdMob_Banner_Hide() {
        if (!validateActiveBannerAd("AdMob_Banner_Hide")) {
            return -5.0d;
        }
        if (!validateViewHandler("AdMob_Banner_Hide")) {
            return -7.0d;
        }
        RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda0(this, 3));
        return 0.0d;
    }

    public double AdMob_Banner_Move(double d) {
        if (!validateInitialized("AdMob_Banner_Move")) {
            return -1.0d;
        }
        if (!validateActiveBannerAd("AdMob_Banner_Move")) {
            return -5.0d;
        }
        if (!validateViewHandler("AdMob_Banner_Move")) {
            return -7.0d;
        }
        RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda10(this, d, 0));
        return 0.0d;
    }

    public double AdMob_Banner_Remove() {
        if (!validateActiveBannerAd("AdMob_Banner_Remove")) {
            return -5.0d;
        }
        if (!validateViewHandler("AdMob_Banner_Remove")) {
            return -7.0d;
        }
        RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda0(this, 2));
        return 0.0d;
    }

    public void AdMob_Banner_Set_AdUnit(String str) {
        this.bannerAdUnitId = str;
    }

    public double AdMob_Banner_Show() {
        if (!validateInitialized("AdMob_Banner_Show")) {
            return -1.0d;
        }
        if (!validateActiveBannerAd("AdMob_Banner_Show")) {
            return -5.0d;
        }
        if (!validateViewHandler("AdMob_Banner_Show")) {
            return -7.0d;
        }
        RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda0(this, 1));
        return 0.0d;
    }

    public double AdMob_Consent_GetStatus() {
        ConsentInformation consentInformation = this.consentInformation;
        if (consentInformation == null) {
            return 0.0d;
        }
        return consentInformation.getConsentStatus();
    }

    public double AdMob_Consent_GetType() {
        ConsentInformation consentInformation = this.consentInformation;
        if (consentInformation == null || consentInformation.getConsentStatus() != 3) {
            return 0.0d;
        }
        Context context = RunnerJNILib.ms_context;
        if (canShowAds(context)) {
            return canShowPersonalizedAds(context) ? 2.0d : 1.0d;
        }
        return 3.0d;
    }

    public double AdMob_Consent_IsFormAvailable() {
        ConsentInformation consentInformation = this.consentInformation;
        return (consentInformation != null && consentInformation.isConsentFormAvailable()) ? 1.0d : 0.0d;
    }

    public void AdMob_Consent_Load() {
        Activity activity = getActivity("AdMob_Consent_Load");
        if (activity != null && validateViewHandler("AdMob_Consent_Load")) {
            RunnerActivity.ViewHandler.post(new GraphRequest$Companion$$ExternalSyntheticLambda1(this, activity, 6));
        }
    }

    public void AdMob_Consent_RequestInfoUpdate(double d) {
        if (validateViewHandler("AdMob_Consent_RequestInfoUpdate")) {
            RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda10(this, d, 1));
        }
    }

    public void AdMob_Consent_Reset() {
        ConsentInformation consentInformation = this.consentInformation;
        if (consentInformation != null) {
            consentInformation.reset();
        }
    }

    public void AdMob_Consent_Set_RDP(double d) {
        this.isRdpEnabled = d > 0.5d;
    }

    public void AdMob_Consent_Show() {
        if (validateViewHandler("AdMob_Consent_Show")) {
            RunnerActivity.ViewHandler.post(new GoogleMobileAdsGM$$ExternalSyntheticLambda0(this, 4));
        }
    }

    public void AdMob_Events_OnPaidEvent(double d) {
        this.triggerOnPaidEvent = d >= 0.5d;
    }

    public double AdMob_Initialize() {
        if (!validateNotInitialized("AdMob_Initialize")) {
            return -6.0d;
        }
        if (!validateViewHandler("AdMob_Initialize")) {
            return -7.0d;
        }
        new Thread(new GoogleMobileAdsGM$$ExternalSyntheticLambda0(this, 0)).start();
        return 0.0d;
    }

    public double AdMob_Interstitial_Instances_Count() {
        return this.interstitialAdQueue.size();
    }

    public double AdMob_Interstitial_IsLoaded() {
        return AdMob_Interstitial_Instances_Count() > 0.0d ? 1.0d : 0.0d;
    }

    public double AdMob_Interstitial_Load() {
        if (!validateInitialized("AdMob_Interstitial_Load")) {
            return -1.0d;
        }
        if (!validateAdId(this.interstitialAdUnitId, "AdMob_Interstitial_Load")) {
            return -2.0d;
        }
        if (!validateLoadedAdsLimit(this.interstitialAdQueue, this.interstitialAdQueueCapacity, "AdMob_Interstitial_Load")) {
            return -3.0d;
        }
        if (!validateViewHandler("AdMob_Interstitial_Load")) {
            return -7.0d;
        }
        loadInterstitialAd(this.interstitialAdUnitId, this.interstitialAdQueue, this.interstitialAdQueueCapacity, "AdMob_Interstitial_Load");
        return 0.0d;
    }

    public void AdMob_Interstitial_Set_AdUnit(String str) {
        this.interstitialAdUnitId = str;
    }

    public double AdMob_Interstitial_Show() {
        if (!validateInitialized("AdMob_Interstitial_Show")) {
            return -1.0d;
        }
        if (!validateAdLoaded(this.interstitialAdQueue, "AdMob_Interstitial_Show")) {
            return -4.0d;
        }
        if (!validateViewHandler("AdMob_Interstitial_Show")) {
            return -7.0d;
        }
        showInterstitialAd(this.interstitialAdQueue, "AdMob_Interstitial_Show");
        return 0.0d;
    }

    public void AdMob_RewardedInterstitial_Free_Loaded_Instances(double d) {
        freeLoadedInstances(this.rewardedInterstitialAdQueue, d, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 8));
    }

    public double AdMob_RewardedInterstitial_Instances_Count() {
        return this.rewardedInterstitialAdQueue.size();
    }

    public double AdMob_RewardedInterstitial_IsLoaded() {
        return AdMob_RewardedInterstitial_Instances_Count() > 0.0d ? 1.0d : 0.0d;
    }

    public double AdMob_RewardedInterstitial_Load() {
        if (!validateInitialized("AdMob_RewardedInterstitial_Load")) {
            return -1.0d;
        }
        if (!validateAdId(this.rewardedInterstitialAdUnitId, "AdMob_RewardedInterstitial_Load")) {
            return -2.0d;
        }
        if (!validateLoadedAdsLimit(this.rewardedInterstitialAdQueue, this.rewardedAdInterstitialQueueCapacity, "AdMob_RewardedInterstitial_Load")) {
            return -3.0d;
        }
        if (!validateViewHandler("AdMob_RewardedInterstitial_Load")) {
            return -7.0d;
        }
        loadRewardedInterstitialAd(this.rewardedInterstitialAdUnitId, this.rewardedInterstitialAdQueue, this.rewardedAdInterstitialQueueCapacity, "AdMob_RewardedInterstitial_Load");
        return 0.0d;
    }

    public void AdMob_RewardedInterstitial_Max_Instances(double d) {
        int i = (int) d;
        this.rewardedAdInterstitialQueueCapacity = i;
        trimLoadedAdsQueue(this.rewardedInterstitialAdQueue, i, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 8));
    }

    public void AdMob_RewardedInterstitial_Set_AdUnit(String str) {
        this.rewardedInterstitialAdUnitId = str;
    }

    public double AdMob_RewardedInterstitial_Show() {
        if (!validateInitialized("AdMob_RewardedInterstitial_Show")) {
            return -1.0d;
        }
        if (!validateAdLoaded(this.rewardedInterstitialAdQueue, "AdMob_RewardedInterstitial_Show")) {
            return -4.0d;
        }
        if (!validateViewHandler("AdMob_RewardedInterstitial_Show")) {
            return -7.0d;
        }
        showRewardedInterstitialAd(this.rewardedInterstitialAdQueue, "AdMob_RewardedInterstitial_Show");
        return 0.0d;
    }

    public void AdMob_RewardedVideo_Free_Loaded_Instances(double d) {
        freeLoadedInstances(this.rewardedAdQueue, d, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 7));
    }

    public double AdMob_RewardedVideo_Instances_Count() {
        return this.rewardedAdQueue.size();
    }

    public double AdMob_RewardedVideo_IsLoaded() {
        return AdMob_RewardedVideo_Instances_Count() > 0.0d ? 1.0d : 0.0d;
    }

    public double AdMob_RewardedVideo_Load() {
        if (!validateInitialized("AdMob_RewardedVideo_Load")) {
            return -1.0d;
        }
        if (!validateAdId(this.rewardedUnitId, "AdMob_RewardedVideo_Load")) {
            return -2.0d;
        }
        if (!validateLoadedAdsLimit(this.rewardedAdQueue, this.rewardedAdQueueCapacity, "AdMob_RewardedVideo_Load")) {
            return -3.0d;
        }
        if (!validateViewHandler("AdMob_RewardedVideo_Load")) {
            return -7.0d;
        }
        loadRewardedAd(this.rewardedUnitId, this.rewardedAdQueue, this.rewardedAdQueueCapacity, "AdMob_RewardedVideo_Load");
        return 0.0d;
    }

    public void AdMob_RewardedVideo_Max_Instances(double d) {
        int i = (int) d;
        this.rewardedAdQueueCapacity = i;
        trimLoadedAdsQueue(this.rewardedAdQueue, i, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 7));
    }

    public void AdMob_RewardedVideo_Set_AdUnit(String str) {
        this.rewardedUnitId = str;
    }

    public double AdMob_RewardedVideo_Show() {
        if (!validateInitialized("AdMob_RewardedVideo_Show")) {
            return -1.0d;
        }
        if (!validateAdLoaded(this.rewardedAdQueue, "AdMob_RewardedVideo_Show")) {
            return -4.0d;
        }
        if (!validateViewHandler("AdMob_RewardedVideo_Show")) {
            return -7.0d;
        }
        showRewardedAd(this.rewardedAdQueue, "AdMob_RewardedVideo_Show");
        return 0.0d;
    }

    public void AdMob_ServerSideVerification_Clear() {
        if (validateInitialized("AdMob_ServerSideVerification_Clear")) {
            this.serverSideVerificationUserId = null;
            this.serverSideVerificationCustomData = null;
        }
    }

    public void AdMob_ServerSideVerification_Set(String str, String str2) {
        if (validateInitialized("AdMob_ServerSideVerification_Set")) {
            this.serverSideVerificationUserId = str;
            this.serverSideVerificationCustomData = str2;
        }
    }

    public double AdMob_SetTestDeviceId() {
        if (!validateNotInitialized("AdMob_SetTestDeviceId")) {
            return -6.0d;
        }
        this.isTestDevice = true;
        return 0.0d;
    }

    public void AdMob_Settings_SetMuted(double d) {
        boolean z = d >= 0.5d;
        zzey zzeyVarZzf = zzey.zzf();
        synchronized (zzeyVarZzf.zzk) {
            zzah.checkState(zzeyVarZzf.zzl != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                zzeyVarZzf.zzl.zzp(z);
            } catch (RemoteException e) {
                zzo.zzh("Unable to set app mute state.", e);
            }
        }
    }

    public void AdMob_Settings_SetVolume(double d) {
        float f = (float) d;
        zzey zzeyVarZzf = zzey.zzf();
        zzeyVarZzf.getClass();
        boolean z = true;
        zzah.checkArgument(f >= 0.0f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (zzeyVarZzf.zzk) {
            if (zzeyVarZzf.zzl == null) {
                z = false;
            }
            zzah.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                zzeyVarZzf.zzl.zzq(f);
            } catch (RemoteException e) {
                zzo.zzh("Unable to set app volume.", e);
            }
        }
    }

    public double AdMob_Targeting_COPPA(double d) {
        if (!validateNotInitialized("AdMob_Targeting_COPPA")) {
            return -6.0d;
        }
        this.targetCOPPA = d > 0.5d;
        return 0.0d;
    }

    public double AdMob_Targeting_UnderAge(double d) {
        if (!validateNotInitialized("AdMob_Targeting_UnderAge")) {
            return -6.0d;
        }
        this.targetUnderAge = d >= 0.5d;
        return 0.0d;
    }

    public void Admob_Interstitial_Free_Loaded_Instances(double d) {
        freeLoadedInstances(this.interstitialAdQueue, d, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 6));
    }

    public void Admob_Interstitial_Max_Instances(double d) {
        int i = (int) d;
        this.interstitialAdQueueCapacity = i;
        trimLoadedAdsQueue(this.interstitialAdQueue, i, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 6));
    }

    @Override // com.daerisoft.thespikerm.RunnerSocial
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.activityRef = new WeakReference<>(RunnerActivity.CurrentActivity);
    }

    @Override // com.daerisoft.thespikerm.RunnerSocial
    public void onDestroy() {
        super.onDestroy();
        if (this.bannerAdView != null) {
            deleteBannerAdView();
        }
        freeLoadedInstances(this.interstitialAdQueue, -1.0d, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 6));
        this.interstitialAdQueue.clear();
        freeLoadedInstances(this.rewardedAdQueue, -1.0d, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 7));
        this.rewardedAdQueue.clear();
        freeLoadedInstances(this.rewardedInterstitialAdQueue, -1.0d, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 8));
        this.rewardedInterstitialAdQueue.clear();
        AppOpenAd appOpenAd = this.appOpenAd;
        if (appOpenAd != null) {
            cleanAd(appOpenAd, new GoogleMobileAdsGM$$ExternalSyntheticLambda3(this, 9));
            this.appOpenAd = null;
        }
        this.consentFormInstance = null;
        this.consentInformation = null;
        WeakReference<Activity> weakReference = this.activityRef;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    @Override // com.daerisoft.thespikerm.RunnerSocial
    public void onResume() {
        super.onResume();
        if (!this.triggerAppOpenAd || this.isShowingAd) {
            this.isShowingAd = false;
        } else if (appOpenAdIsValid("onResume")) {
            AdMob_AppOpenAd_Show();
        } else {
            AdMob_AppOpenAd_Load();
        }
    }

    private boolean appOpenAdIsValid(String str) {
        AppOpenAd appOpenAd = this.appOpenAd;
        if (appOpenAd == null) {
            Log.w(LOG_TAG, str + " :: There is no app open ad loaded.");
            return false;
        }
        if (appOpenAd.getResponseInfo() == null) {
            Log.w(LOG_TAG, str + FKidOcdAYt.TdkfCrgyrs);
            return false;
        }
        if (new Date().getTime() - this.appOpenAdLoadTime >= ((long) this.appOpenAdExpirationTime) * 3600000) {
            Log.w(LOG_TAG, str + " :: The loaded app open ad expired.");
            return false;
        }
        Activity activity = getActivity(str);
        if ((activity != null ? activity.getResources().getConfiguration().orientation : 0) == this.appOpenAdOrientation) {
            return true;
        }
        Log.w(LOG_TAG, str + " :: The loaded app open ad has incorrect orientation.");
        return false;
    }

    private boolean canShowPersonalizedAds(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        String string = sharedPreferences.getString("IABTCF_PurposeConsents", "");
        String string2 = sharedPreferences.getString(yzwzcWHcnH.VaDRvSuzbQckqY, "");
        String string3 = sharedPreferences.getString("IABTCF_VendorLegitimateInterests", "");
        String string4 = sharedPreferences.getString("IABTCF_PurposeLegitimateInterests", "");
        boolean zHasAttribute = hasAttribute(string2, 755);
        boolean zHasAttribute2 = hasAttribute(string3, 755);
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(2);
        arrayList2.add(7);
        arrayList2.add(9);
        arrayList2.add(10);
        return hasConsentFor(arrayList, string, zHasAttribute) && hasConsentOrLegitimateInterestFor(arrayList2, string, string4, zHasAttribute, zHasAttribute2);
    }

    private void initializeAdUnits() {
        this.bannerAdUnitId = RunnerJNILib.extOptGetString(LOG_TAG, "Android_BANNER");
        this.interstitialAdUnitId = RunnerJNILib.extOptGetString(LOG_TAG, RDFWIi.mSjKHmoia);
        this.rewardedUnitId = RunnerJNILib.extOptGetString(LOG_TAG, "Android_REWARDED");
        this.rewardedInterstitialAdUnitId = RunnerJNILib.extOptGetString(LOG_TAG, "Android_REWARDED_INTERSTITIAL");
        this.appOpenAdUnitId = RunnerJNILib.extOptGetString(LOG_TAG, "Android_OPENAPPAD");
    }

    public /* synthetic */ void lambda$AdMob_Banner_Show$3() {
        if (validateActiveBannerAd(UUFMQdNK.mGtMtJBHMXfMUjv)) {
            this.bannerAdView.setVisibility(0);
        }
    }

    public void onPaidEventHandler(AdValue adValue, String str, String str2, AdapterResponseInfo adapterResponseInfo, String str3) {
        HashMap map = new HashMap();
        map.put("mediation_adapter_class_name", str3);
        map.put("unit_id", str);
        map.put("ad_type", str2);
        map.put("micros", Long.valueOf(adValue.zzc));
        map.put(FKidOcdAYt.PfDsEZUwH, adValue.zzb);
        map.put("precision", Double.valueOf(adValue.zza));
        if (adapterResponseInfo != null) {
            zzv zzvVar = adapterResponseInfo.zza;
            map.put("ad_source_name", zzvVar.zze);
            map.put("ad_source_id", zzvVar.zzf);
            map.put("ad_source_instance_name", zzvVar.zzg);
            map.put("ad_source_instance_id", zzvVar.zzh);
        } else {
            Log.w(LOG_TAG, "LoadedAdapterResponseInfo is null.");
        }
        sendAsyncEvent("AdMob_OnPaidEvent", map);
    }

    public double AdMob_Targeting_MaxAdContentRating(double d) {
        if (!validateNotInitialized("AdMob_Targeting_MaxAdContentRating")) {
            return -6.0d;
        }
        int i = (int) d;
        if (i == 0) {
            this.maxAdContentRating = "G";
            return 0.0d;
        }
        if (i == 1) {
            this.maxAdContentRating = "PG";
            return 0.0d;
        }
        if (i == 2) {
            this.maxAdContentRating = sgtsHsWT.bHeciU;
            return 0.0d;
        }
        if (i != 3) {
            return 0.0d;
        }
        this.maxAdContentRating = dLDI.HADNNjGdDGST;
        return 0.0d;
    }

    public void cleanUpAd(InterstitialAd interstitialAd) {
        interstitialAd.setFullScreenContentCallback(null);
        interstitialAd.setOnPaidEventListener(null);
    }

    private boolean hasConsentFor(List<Integer> list, String str, boolean z) {
        for (Integer num : list) {
            if (!hasAttribute(str, num.intValue())) {
                Log.e(FETmZwrVHuasmL.yayFUtDxbs, "hasConsentFor: denied for purpose #" + num);
                return false;
            }
        }
        return z;
    }

    public void cleanUpAd(RewardedAd rewardedAd) {
        rewardedAd.setFullScreenContentCallback(null);
        rewardedAd.setOnPaidEventListener(null);
    }

    public void cleanUpAd(RewardedInterstitialAd rewardedInterstitialAd) {
        rewardedInterstitialAd.setFullScreenContentCallback(null);
        rewardedInterstitialAd.setOnPaidEventListener(null);
    }

    public void cleanUpAd(AppOpenAd appOpenAd) {
        appOpenAd.setFullScreenContentCallback(null);
        appOpenAd.setOnPaidEventListener(null);
    }
}
