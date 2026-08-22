package com.daerisoft.thespikerm;

import android.util.Log;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GooglePlayBilling {
    public GooglePlayBillingService m_runnerBilling = null;
    public List<String> m_iapList = null;
    public List<String> m_subList = null;
    public final int EXT_ERROR_UNKNOWN = -1;
    public final int EXT_NO_ERROR = 0;
    public final int EXT_ERROR_NOT_INITIALISED = 1;
    public final int EXT_ERROR_NO_SKUS = 2;
    public final int EXT_ERROR_SELECTED_SKU_LIST_EMPTY = 3;

    private String _statusToString(int i) {
        if (i == 1) {
            return "Google Play Billing has not been initialised.";
        }
        if (i != 2) {
            return i != 3 ? "Error Unknown." : "Selected SKU List was empty";
        }
        return "IAP List is empty.";
    }

    private int getStatus() {
        if (this.m_runnerBilling == null) {
            return 1;
        }
        return (this.m_iapList == null && this.m_subList == null) ? 2 : 0;
    }

    public double GPBilling_AcknowledgePurchase(String str) {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        this.m_runnerBilling.acknowledgePurchase(str);
        return 0.0d;
    }

    public double GPBilling_AddProduct(String str) {
        if (this.m_iapList == null) {
            this.m_iapList = new ArrayList();
        }
        if (this.m_iapList.contains(str)) {
            return -1.0d;
        }
        this.m_iapList.add(str);
        return 0.0d;
    }

    public double GPBilling_AddSubscription(String str) {
        if (this.m_subList == null) {
            this.m_subList = new ArrayList();
        }
        if (this.m_subList.contains(str)) {
            return -1.0d;
        }
        this.m_subList.add(str);
        return 0.0d;
    }

    public double GPBilling_ConnectToStore() {
        GooglePlayBillingService googlePlayBillingService = this.m_runnerBilling;
        if (googlePlayBillingService == null) {
            return 1.0d;
        }
        googlePlayBillingService.loadStore();
        return 0.0d;
    }

    public double GPBilling_ConsumeProduct(String str) {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        this.m_runnerBilling.consumeProduct(str);
        return 0.0d;
    }

    public double GPBilling_GetStatus() {
        return getStatus();
    }

    public double GPBilling_Init() {
        if (this.m_runnerBilling != null) {
            return 0.0d;
        }
        Log.i(GooglePlayBillingService.TAG, "CREATED: m_runnerBilling");
        this.m_runnerBilling = new GooglePlayBillingService();
        return 0.0d;
    }

    public double GPBilling_IsStoreConnected() {
        GooglePlayBillingService googlePlayBillingService = this.m_runnerBilling;
        if (googlePlayBillingService != null) {
            return googlePlayBillingService.isStoreConnected() ? 1.0d : 0.0d;
        }
        return 0.0d;
    }

    public double GPBilling_PurchaseProduct(String str) {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        double dPurchaseCatalogItem = this.m_runnerBilling.purchaseCatalogItem(str);
        if (dPurchaseCatalogItem == 2.0d) {
            Log.i(GooglePlayBillingService.TAG, "GPBilling_PurchaseProduct :: user is required to call GPBilling_QueryProducts before trying to purchase.");
        }
        return dPurchaseCatalogItem;
    }

    public String GPBilling_Purchase_GetOriginalJson(String str) {
        Purchase purchase;
        return (getStatus() <= 0 && (purchase = this.m_runnerBilling.GetPurchases().get(str)) != null) ? purchase.zza : "";
    }

    public String GPBilling_Purchase_GetSignature(String str) {
        Purchase purchase;
        return (getStatus() <= 0 && (purchase = this.m_runnerBilling.GetPurchases().get(str)) != null) ? purchase.zzb : "";
    }

    public double GPBilling_Purchase_GetState(String str) {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        Purchase purchase = this.m_runnerBilling.GetPurchases().get(str);
        if (purchase == null) {
            return -1.0d;
        }
        char c = purchase.zzc.optInt("purchaseState", 1) != 4 ? (char) 1 : (char) 2;
        if (c == 1) {
            return 13001.0d;
        }
        return c == 2 ? 13002.0d : 13000.0d;
    }

    public double GPBilling_Purchase_VerifySignature(String str, String str2) {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        return RunnerBillingSecurity.verifyPurchase(str, str2) ? 1.0d : 0.0d;
    }

    public double GPBilling_QueryProducts() {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        List<String> list = this.m_iapList;
        if (list == null) {
            return 3.0d;
        }
        return this.m_runnerBilling.retrieveManagedProducts(list);
    }

    public void GPBilling_QueryPurchasesAsync(String str) {
        if (getStatus() > 0) {
            return;
        }
        this.m_runnerBilling.queryPurchasesAsync(str);
    }

    public double GPBilling_QuerySubscriptions() {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        List<String> list = this.m_subList;
        if (list == null) {
            return 3.0d;
        }
        return this.m_runnerBilling.retrieveSubscriptions(list);
    }

    public String GPBilling_Sku_GetDescription(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optString("description");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zzb.optString("description");
                }
            }
        }
        return "";
    }

    public String GPBilling_Sku_GetFreeTrialPeriod(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optString("freeTrialPeriod");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zzb.optString("freeTrialPeriod");
                }
            }
        }
        return "";
    }

    public String GPBilling_Sku_GetIconUrl(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optString("iconUrl");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zzb.optString("iconUrl");
                }
            }
        }
        return "";
    }

    public String GPBilling_Sku_GetIntroductoryPrice(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optString("introductoryPrice");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zzb.optString("introductoryPrice");
                }
            }
        }
        return "";
    }

    public double GPBilling_Sku_GetIntroductoryPriceAmountMicros(String str) {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optLong("introductoryPriceAmountMicros");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails == null) {
            return -1.0d;
        }
        for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
            if (skuDetails2.getSku().equals(str)) {
                return skuDetails2.zzb.optLong("introductoryPriceAmountMicros");
            }
        }
        return -1.0d;
    }

    public String GPBilling_Sku_GetIntroductoryPriceCycles(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optString("introductoryPrice");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zzb.optString("introductoryPrice");
                }
            }
        }
        return "";
    }

    public String GPBilling_Sku_GetIntroductoryPricePeriod(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optString("introductoryPricePeriod");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zzb.optString("introductoryPricePeriod");
                }
            }
        }
        return "";
    }

    public String GPBilling_Sku_GetOriginalJson(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zza;
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zza;
                }
            }
        }
        return "";
    }

    public double GPBilling_Sku_GetOriginalPriceAmountMicros(String str) {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    JSONObject jSONObject = skuDetails.zzb;
                    return jSONObject.has("original_price_micros") ? jSONObject.optLong("original_price_micros") : jSONObject.optLong("price_amount_micros");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails == null) {
            return -1.0d;
        }
        for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
            if (skuDetails2.getSku().equals(str)) {
                JSONObject jSONObject2 = skuDetails2.zzb;
                return jSONObject2.has("original_price_micros") ? jSONObject2.optLong("original_price_micros") : jSONObject2.optLong("price_amount_micros");
            }
        }
        return -1.0d;
    }

    public String GPBilling_Sku_GetPrice(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optString(FirebaseAnalytics.Param.PRICE);
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zzb.optString(FirebaseAnalytics.Param.PRICE);
                }
            }
        }
        return "";
    }

    public double GPBilling_Sku_GetPriceAmountMicros(String str) {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optLong("price_amount_micros");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails == null) {
            return -1.0d;
        }
        for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
            if (skuDetails2.getSku().equals(str)) {
                return skuDetails2.zzb.optLong("price_amount_micros");
            }
        }
        return -1.0d;
    }

    public String GPBilling_Sku_GetPriceCurrencyCode(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optString("price_currency_code");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zzb.optString("price_currency_code");
                }
            }
        }
        return "";
    }

    public String GPBilling_Sku_GetSku(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.getSku();
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.getSku();
                }
            }
        }
        return "";
    }

    public String GPBilling_Sku_GetSubscriptionPeriod(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optString("subscriptionPeriod");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zzb.optString("subscriptionPeriod");
                }
            }
        }
        return "";
    }

    public String GPBilling_Sku_GetTitle(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.zzb.optString("title");
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.zzb.optString("title");
                }
            }
        }
        return "";
    }

    public String GPBilling_Sku_GetType(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    return skuDetails.getType();
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    return skuDetails2.getType();
                }
            }
        }
        return "";
    }

    public double GPBilling_PurchaseSubscription(String str) {
        int status = getStatus();
        if (status > 0) {
            return status;
        }
        double dPurchaseSubscription = this.m_runnerBilling.purchaseSubscription(str);
        if (dPurchaseSubscription == 2.0d) {
            Log.i(GooglePlayBillingService.TAG, ZRqOdXiy.aaw);
        }
        return dPurchaseSubscription;
    }

    public String GPBilling_Sku_GetOriginalPrice(String str) {
        if (getStatus() > 0) {
            return "";
        }
        List<SkuDetails> listGetSkuDetails = this.m_runnerBilling.GetSkuDetails();
        String str2 = gZrKCJ.cDAzTnxU;
        if (listGetSkuDetails != null) {
            for (SkuDetails skuDetails : listGetSkuDetails) {
                if (skuDetails.getSku().equals(str)) {
                    JSONObject jSONObject = skuDetails.zzb;
                    if (jSONObject.has("original_price")) {
                        return jSONObject.optString("original_price");
                    }
                    return jSONObject.optString(str2);
                }
            }
        }
        List<SkuDetails> listGetSubSkuDetails = this.m_runnerBilling.GetSubSkuDetails();
        if (listGetSubSkuDetails != null) {
            for (SkuDetails skuDetails2 : listGetSubSkuDetails) {
                if (skuDetails2.getSku().equals(str)) {
                    JSONObject jSONObject2 = skuDetails2.zzb;
                    if (jSONObject2.has("original_price")) {
                        return jSONObject2.optString("original_price");
                    }
                    return jSONObject2.optString(str2);
                }
            }
        }
        return "";
    }
}
