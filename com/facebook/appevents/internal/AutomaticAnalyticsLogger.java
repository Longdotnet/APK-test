package com.facebook.appevents.internal;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookSdk;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.firebase.auth.zzaa;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AutomaticAnalyticsLogger {
    public static final Fragment.AnonymousClass7 internalAppEventsLogger = new Fragment.AnonymousClass7(FacebookSdk.getApplicationContext(), 18);

    /* JADX WARN: Code duplicated, block: B:41:0x016c  */
    public static final void logPurchase(String str, String skuDetails, boolean z) {
        zzaa zzaaVar;
        String str2;
        Intrinsics.checkNotNullParameter(skuDetails, "skuDetails");
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery != null && UserSettingsManager.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.iAPAutomaticLoggingEnabled) {
            HashMap map = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = new JSONObject(skuDetails);
                Bundle bundle = new Bundle(1);
                bundle.putCharSequence("fb_iap_product_id", jSONObject.getString("productId"));
                bundle.putCharSequence("fb_iap_purchase_time", jSONObject.getString("purchaseTime"));
                bundle.putCharSequence(QTaELkFI.noLnkxXMhjeeva, jSONObject.getString("purchaseToken"));
                bundle.putCharSequence("fb_iap_package_name", jSONObject.optString("packageName"));
                bundle.putCharSequence("fb_iap_product_title", jSONObject2.optString("title"));
                bundle.putCharSequence("fb_iap_product_description", jSONObject2.optString(gZrKCJ.cSbWbFzeL));
                String strOptString = jSONObject2.optString("type");
                bundle.putCharSequence("fb_iap_product_type", strOptString);
                if (Intrinsics.areEqual(strOptString, "subs")) {
                    bundle.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                    bundle.putCharSequence("fb_iap_subs_period", jSONObject2.optString("subscriptionPeriod"));
                    bundle.putCharSequence("fb_free_trial_period", jSONObject2.optString("freeTrialPeriod"));
                    String introductoryPriceCycles = jSONObject2.optString("introductoryPriceCycles");
                    Intrinsics.checkNotNullExpressionValue(introductoryPriceCycles, "introductoryPriceCycles");
                    if (introductoryPriceCycles.length() != 0) {
                        bundle.putCharSequence("fb_intro_price_amount_micros", jSONObject2.optString("introductoryPriceAmountMicros"));
                        bundle.putCharSequence("fb_intro_price_cycles", introductoryPriceCycles);
                    }
                }
                for (Map.Entry entry : map.entrySet()) {
                    bundle.putCharSequence((String) entry.getKey(), (String) entry.getValue());
                }
                BigDecimal bigDecimal = new BigDecimal(jSONObject2.getLong("price_amount_micros") / 1000000.0d);
                Currency currency = Currency.getInstance(jSONObject2.getString("price_currency_code"));
                Intrinsics.checkNotNullExpressionValue(currency, "getInstance(skuDetailsJSON.getString(\"price_currency_code\"))");
                zzaaVar = new zzaa(11);
                zzaaVar.zza = bigDecimal;
                zzaaVar.zzb = currency;
                zzaaVar.zzc = bundle;
            } catch (JSONException e) {
                Log.e("com.facebook.appevents.internal.AutomaticAnalyticsLogger", "Error parsing in-app subscription data.", e);
                zzaaVar = null;
            }
            if (zzaaVar == null) {
                return;
            }
            Bundle bundle2 = (Bundle) zzaaVar.zzc;
            Currency currency2 = (Currency) zzaaVar.zzb;
            BigDecimal bigDecimal2 = (BigDecimal) zzaaVar.zza;
            Fragment.AnonymousClass7 anonymousClass7 = internalAppEventsLogger;
            if (z) {
                AtomicBoolean atomicBoolean = FetchedAppGateKeepersManager.isLoading;
                if (FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_if_auto_log_subs", FacebookSdk.getApplicationId(), false)) {
                    InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
                    if (CrashShieldHandler.isObjectCrashing(inAppPurchaseEventManager)) {
                        str2 = "Subscribe";
                    } else {
                        try {
                            String strOptString2 = new JSONObject(skuDetails).optString("freeTrialPeriod");
                            if (strOptString2 == null || strOptString2.length() <= 0) {
                                str2 = "Subscribe";
                            } else {
                                str2 = "StartTrial";
                            }
                        } catch (JSONException unused) {
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(inAppPurchaseEventManager, th);
                        }
                    }
                    String str3 = str2;
                    anonymousClass7.getClass();
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                        AppEventsLoggerImpl appEventsLoggerImpl = (AppEventsLoggerImpl) anonymousClass7.this$0;
                        appEventsLoggerImpl.getClass();
                        if (CrashShieldHandler.isObjectCrashing(appEventsLoggerImpl) || bigDecimal2 == null || currency2 == null) {
                            return;
                        }
                        if (bundle2 == null) {
                            try {
                                bundle2 = new Bundle();
                            } catch (Throwable th2) {
                                CrashShieldHandler.handleThrowable(appEventsLoggerImpl, th2);
                                return;
                            }
                        }
                        Bundle bundle3 = bundle2;
                        bundle3.putString("fb_currency", currency2.getCurrencyCode());
                        appEventsLoggerImpl.logEvent(str3, Double.valueOf(bigDecimal2.doubleValue()), bundle3, true, ActivityLifecycleTracker.getCurrentSessionGuid());
                        return;
                    }
                    return;
                }
            }
            anonymousClass7.getClass();
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                AppEventsLoggerImpl appEventsLoggerImpl2 = (AppEventsLoggerImpl) anonymousClass7.this$0;
                appEventsLoggerImpl2.getClass();
                if (CrashShieldHandler.isObjectCrashing(appEventsLoggerImpl2)) {
                    return;
                }
                try {
                    appEventsLoggerImpl2.logPurchase(bigDecimal2, currency2, bundle2);
                } catch (Throwable th3) {
                    CrashShieldHandler.handleThrowable(appEventsLoggerImpl2, th3);
                }
            }
        }
    }
}
