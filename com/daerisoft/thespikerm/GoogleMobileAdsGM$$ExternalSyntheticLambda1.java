package com.daerisoft.thespikerm;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.work.WorkContinuation;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.ProfileCache;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.LoginClient;
import com.facebook.login.WebLoginMethodHandler;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler$$ExternalSyntheticLambda1;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GoogleMobileAdsGM$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ GoogleMobileAdsGM$$ExternalSyntheticLambda1(GoogleMobileAdsGM googleMobileAdsGM, String str, String str2) {
        this.$r8$classId = 2;
        this.f$0 = googleMobileAdsGM;
        this.f$2 = str;
        this.f$1 = str2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                ((GoogleMobileAdsGM) this.f$0).lambda$showRewardedInterstitialAd$15((RewardedInterstitialAd) this.f$1, (String) this.f$2);
                return;
            case 1:
                ProfileCache profileCache = (ProfileCache) this.f$0;
                final ExceptionsKt exceptionsKt = (ExceptionsKt) this.f$1;
                final ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f$2;
                profileCache.getClass();
                try {
                    FontRequestEmojiCompatConfig fontRequestEmojiCompatConfigCreate = WorkContinuation.create((Context) profileCache.sharedPreferences);
                    if (fontRequestEmojiCompatConfigCreate == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) fontRequestEmojiCompatConfigCreate.mMetadataLoader;
                    synchronized (fontRequestMetadataLoader.mLock) {
                        fontRequestMetadataLoader.mExecutor = threadPoolExecutor;
                        break;
                    }
                    fontRequestEmojiCompatConfigCreate.mMetadataLoader.load(new ExceptionsKt() { // from class: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1
                        @Override // kotlin.ExceptionsKt
                        public final void onFailed(Throwable th) {
                            ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                            try {
                                exceptionsKt.onFailed(th);
                            } finally {
                                threadPoolExecutor2.shutdown();
                            }
                        }

                        @Override // kotlin.ExceptionsKt
                        public final void onLoaded(Dispatcher dispatcher) {
                            ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                            try {
                                exceptionsKt.onLoaded(dispatcher);
                            } finally {
                                threadPoolExecutor2.shutdown();
                            }
                        }
                    });
                    return;
                } catch (Throwable th) {
                    exceptionsKt.onFailed(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 2:
                ((GoogleMobileAdsGM) this.f$0).lambda$loadAppOpenAd$16((String) this.f$2, (String) this.f$1);
                return;
            case 3:
                ((GoogleMobileAdsGM) this.f$0).lambda$showRewardedAd$12((RewardedAd) this.f$1, (String) this.f$2);
                return;
            case 4:
                ((GoogleMobileAdsGM) this.f$0).lambda$showInterstitialAd$9((InterstitialAd) this.f$1, (String) this.f$2);
                return;
            case 5:
                CustomTabLoginMethodHandler this$0 = (CustomTabLoginMethodHandler) this.f$0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                LoginClient.Request request = (LoginClient.Request) this.f$1;
                Intrinsics.checkNotNullParameter(request, "$request");
                Bundle bundle = (Bundle) this.f$2;
                try {
                    this$0.processCodeExchange(request, bundle);
                    this$0.onComplete(request, bundle, null);
                    return;
                } catch (FacebookException e) {
                    this$0.onComplete(request, null, e);
                    return;
                }
            case 6:
                WebLoginMethodHandler this$1 = (WebLoginMethodHandler) this.f$0;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                LoginClient.Request request2 = (LoginClient.Request) this.f$1;
                Intrinsics.checkNotNullParameter(request2, "$request");
                Bundle bundle2 = (Bundle) this.f$2;
                try {
                    this$1.processCodeExchange(request2, bundle2);
                    this$1.handleResultOk(request2, bundle2);
                    return;
                } catch (FacebookServiceException e2) {
                    FacebookRequestError facebookRequestError = e2.requestError;
                    this$1.handleResultError(request2, facebookRequestError.errorType, facebookRequestError.getErrorMessage(), String.valueOf(facebookRequestError.errorCode));
                    return;
                } catch (FacebookException e3) {
                    this$1.handleResultError(request2, null, e3.getMessage(), null);
                    return;
                }
            default:
                AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$1;
                String str = autoValue_TransportContext.backendName;
                AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.f$2;
                DefaultScheduler defaultScheduler = (DefaultScheduler) this.f$0;
                defaultScheduler.getClass();
                Logger logger = DefaultScheduler.LOGGER;
                try {
                    TransportBackend transportBackend = defaultScheduler.backendRegistry.get(str);
                    if (transportBackend == null) {
                        String str2 = "Transport backend '" + str + "' is not registered";
                        logger.warning(str2);
                        new IllegalArgumentException(str2);
                    } else {
                        ((SQLiteEventStore) defaultScheduler.guard).runCriticalSection(new DefaultScheduler$$ExternalSyntheticLambda1(defaultScheduler, autoValue_TransportContext, ((CctTransportBackend) transportBackend).decorate(autoValue_EventInternal), 0));
                    }
                    return;
                } catch (Exception e4) {
                    logger.warning("Error scheduling event " + e4.getMessage());
                    return;
                }
        }
    }

    public /* synthetic */ GoogleMobileAdsGM$$ExternalSyntheticLambda1(DefaultScheduler defaultScheduler, AutoValue_TransportContext autoValue_TransportContext, DifferentialMotionFlingController$$ExternalSyntheticLambda0 differentialMotionFlingController$$ExternalSyntheticLambda0, AutoValue_EventInternal autoValue_EventInternal) {
        this.$r8$classId = 7;
        this.f$0 = defaultScheduler;
        this.f$1 = autoValue_TransportContext;
        this.f$2 = autoValue_EventInternal;
    }

    public /* synthetic */ GoogleMobileAdsGM$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
