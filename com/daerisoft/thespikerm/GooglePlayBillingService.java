package com.daerisoft.thespikerm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbsActionBarView$VisibilityAnimListener;
import androidx.fragment.app.Fragment;
import androidx.loader.app.gv.DYYbQc;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import androidx.work.InputMergerFactory$1;
import androidx.work.impl.WorkerWrapper;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientImpl;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.zzbc;
import com.android.billingclient.api.zzcb;
import com.android.billingclient.api.zzce;
import com.android.billingclient.api.zzr;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.facebook.AccessTokenCache;
import com.facebook.ProfileCache;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.ads.zza;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.common.base.Joiner;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import com.yoyogames.runner.RunnerJNILib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GooglePlayBillingService {
    public static final String TAG = "yoyo";
    public static boolean m_isStoreConnected;
    public List<SkuDetails> m_skuDetails;
    public List<SkuDetails> m_subSkuDetails;
    public HashMap<String, Purchase> m_purchaseRequests = new HashMap<>();
    public YYPurchasesUpdatedListener m_purchaseUpdatedListener = null;
    public BillingClient m_billingClient = null;

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.GooglePlayBillingService$6 */
    public final class AnonymousClass6 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ GooglePlayBillingService this$0;
        public final /* synthetic */ String val$purchaseToken;

        public /* synthetic */ AnonymousClass6(GooglePlayBillingService googlePlayBillingService, String str, int i) {
            this.$r8$classId = i;
            this.this$0 = googlePlayBillingService;
            this.val$purchaseToken = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    String str = this.val$purchaseToken;
                    if (str == null) {
                        throw new IllegalArgumentException("Purchase token must be set");
                    }
                    SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery();
                    simpleSQLiteQuery.mQuery = str;
                    BillingClient billingClient = this.this$0.m_billingClient;
                    ProfileCache profileCache = new ProfileCache(this, 17);
                    BillingClientImpl billingClientImpl = (BillingClientImpl) billingClient;
                    if (!billingClientImpl.isReady()) {
                        BillingResult billingResult = zzce.zzm;
                        billingClientImpl.zzap(zzcb.zza(2, 3, billingResult));
                        profileCache.onAcknowledgePurchaseResponse(billingResult);
                        return;
                    }
                    if (TextUtils.isEmpty(simpleSQLiteQuery.mQuery)) {
                        zzb.zzk("BillingClient", PZmDzEagKNdW.ZRiKzWFoeg);
                        BillingResult billingResult2 = zzce.zzi;
                        billingClientImpl.zzap(zzcb.zza(26, 3, billingResult2));
                        profileCache.onAcknowledgePurchaseResponse(billingResult2);
                        return;
                    }
                    if (!billingClientImpl.zzn) {
                        BillingResult billingResult3 = zzce.zzb;
                        billingClientImpl.zzap(zzcb.zza(27, 3, billingResult3));
                        profileCache.onAcknowledgePurchaseResponse(billingResult3);
                        return;
                    } else {
                        if (billingClientImpl.zzao(new zzr(billingClientImpl, simpleSQLiteQuery, profileCache, 3), 30000L, new zza(billingClientImpl, profileCache, 15), billingClientImpl.zzaj()) == null) {
                            BillingResult billingResultZzal = billingClientImpl.zzal();
                            billingClientImpl.zzap(zzcb.zza(25, 3, billingResultZzal));
                            profileCache.onAcknowledgePurchaseResponse(billingResultZzal);
                            return;
                        }
                        return;
                    }
                default:
                    String str2 = this.val$purchaseToken;
                    if (str2 == null) {
                        throw new IllegalArgumentException("Purchase token must be set");
                    }
                    Joiner joiner = new Joiner();
                    joiner.separator = str2;
                    BillingClient billingClient2 = this.this$0.m_billingClient;
                    AccessTokenCache accessTokenCache = new AccessTokenCache(this, 14);
                    BillingClientImpl billingClientImpl2 = (BillingClientImpl) billingClient2;
                    if (!billingClientImpl2.isReady()) {
                        BillingResult billingResult4 = zzce.zzm;
                        billingClientImpl2.zzap(zzcb.zza(2, 4, billingResult4));
                        accessTokenCache.onConsumeResponse(billingResult4, joiner.separator);
                        return;
                    } else {
                        if (billingClientImpl2.zzao(new zzr(billingClientImpl2, joiner, accessTokenCache, 1), 30000L, new WorkerWrapper.AnonymousClass1(billingClientImpl2, accessTokenCache, joiner, 8, false), billingClientImpl2.zzaj()) == null) {
                            BillingResult billingResultZzal2 = billingClientImpl2.zzal();
                            billingClientImpl2.zzap(zzcb.zza(25, 4, billingResultZzal2));
                            accessTokenCache.onConsumeResponse(billingResultZzal2, joiner.separator);
                            return;
                        }
                        return;
                    }
            }
        }
    }

    public final class YYPurchasesUpdatedListener {
        public YYPurchasesUpdatedListener() {
        }

        public final void onPurchasesUpdated(BillingResult billingResult, List list) {
            GooglePlayBillingService googlePlayBillingService = GooglePlayBillingService.this;
            String[] strArr = {"id"};
            double[] dArr = {12001.0d};
            Log.d(GooglePlayBillingService.TAG, "onPurchasesUpdated called");
            int i = billingResult.zza;
            if (i != 0) {
                if (i == 1) {
                    Log.w(GooglePlayBillingService.TAG, "onPurchasesUpdated() - user cancelled the purchase flow - skipping");
                    int iJCreateDsMap = RunnerJNILib.jCreateDsMap(strArr, null, dArr);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "response_json", "{ \"success\":false, \"failure\":\"user_cancelled\" }");
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 66);
                    return;
                }
                Log.w(GooglePlayBillingService.TAG, "onPurchasesUpdated() got unknown resultCode: " + billingResult.zza);
                String str = "{ \"success\":false, \"failure\":\"unknown error\", \"responseCode\":" + Integer.toString(billingResult.zza) + " }";
                int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(strArr, null, dArr);
                RunnerJNILib.DsMapAddString(iJCreateDsMap2, "response_json", str);
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 66);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONObject.put(FirebaseAnalytics.Param.SUCCESS, true);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Purchase purchase = (Purchase) it.next();
                        if (!googlePlayBillingService.m_purchaseRequests.containsKey(purchase.getPurchaseToken())) {
                            googlePlayBillingService.m_purchaseRequests.put(purchase.getPurchaseToken(), purchase);
                        }
                        jSONArray.put(new JSONObject(purchase.zza));
                    }
                }
                jSONObject.put("purchases", jSONArray);
                String string = jSONObject.toString();
                int iJCreateDsMap3 = RunnerJNILib.jCreateDsMap(strArr, null, dArr);
                RunnerJNILib.DsMapAddString(iJCreateDsMap3, "response_json", string);
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap3, 66);
            } catch (JSONException unused) {
                Log.e(GooglePlayBillingService.TAG, DYYbQc.UIuLhA);
            }
        }
    }

    public void Destroy() {
    }

    public Map<String, Purchase> GetPurchases() {
        return this.m_purchaseRequests;
    }

    public List<SkuDetails> GetSkuDetails() {
        return this.m_skuDetails;
    }

    public List<SkuDetails> GetSubSkuDetails() {
        return this.m_subSkuDetails;
    }

    public Object InitRunnerBilling() {
        return this;
    }

    public void acknowledgePurchase(String str) {
        RunnerActivity.CurrentActivity.runOnUiThread(new AnonymousClass6(this, str, 0));
    }

    public void consumeProduct(String str) {
        RunnerActivity.CurrentActivity.runOnUiThread(new AnonymousClass6(this, str, 1));
    }

    public boolean isStoreConnected() {
        return m_isStoreConnected;
    }

    public void loadStore() {
        m_isStoreConnected = false;
        if (this.m_purchaseUpdatedListener == null && this.m_billingClient == null) {
            YYPurchasesUpdatedListener yYPurchasesUpdatedListener = new YYPurchasesUpdatedListener();
            this.m_purchaseUpdatedListener = yYPurchasesUpdatedListener;
            Context context = RunnerJNILib.ms_context;
            InputMergerFactory$1 inputMergerFactory$1 = new InputMergerFactory$1(21);
            if (context == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            this.m_billingClient = new BillingClientImpl(inputMergerFactory$1, context, yYPurchasesUpdatedListener);
        }
        BillingClient billingClient = this.m_billingClient;
        InputMergerFactory$1 inputMergerFactory$2 = new InputMergerFactory$1(23);
        BillingClientImpl billingClientImpl = (BillingClientImpl) billingClient;
        if (billingClientImpl.isReady()) {
            zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            billingClientImpl.zzaq(zzcb.zzc(6));
            InputMergerFactory$1.onBillingSetupFinished(zzce.zzl);
            return;
        }
        int i = 1;
        if (billingClientImpl.zza == 1) {
            zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            BillingResult billingResult = zzce.zzd;
            billingClientImpl.zzap(zzcb.zza(37, 6, billingResult));
            InputMergerFactory$1.onBillingSetupFinished(billingResult);
            return;
        }
        if (billingClientImpl.zza == 3) {
            zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            BillingResult billingResult2 = zzce.zzm;
            billingClientImpl.zzap(zzcb.zza(38, 6, billingResult2));
            InputMergerFactory$1.onBillingSetupFinished(billingResult2);
            return;
        }
        billingClientImpl.zza = 1;
        zzb.zzj("BillingClient", "Starting in-app billing setup.");
        billingClientImpl.zzh = new zzbc(billingClientImpl, inputMergerFactory$2);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = billingClientImpl.zze.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            i = 41;
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                    i = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", billingClientImpl.zzb);
                    if (billingClientImpl.zze.bindService(intent2, billingClientImpl.zzh, 1)) {
                        zzb.zzj("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                        i = 39;
                    }
                }
            }
        }
        billingClientImpl.zza = 0;
        zzb.zzj("BillingClient", "Billing service unavailable on device.");
        BillingResult billingResult3 = zzce.zzc;
        billingClientImpl.zzap(zzcb.zza(i, 6, billingResult3));
        InputMergerFactory$1.onBillingSetupFinished(billingResult3);
    }

    public int purchaseCatalogItem(String str) {
        return purchaseSku(str, this.m_skuDetails);
    }

    public int purchaseSubscription(String str) {
        return purchaseSku(str, this.m_subSkuDetails);
    }

    public void queryPurchasesAsync(String str) {
        BillingClient billingClient = this.m_billingClient;
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(this, str, 20);
        BillingClientImpl billingClientImpl = (BillingClientImpl) billingClient;
        if (!billingClientImpl.isReady()) {
            billingClientImpl.zzap(zzcb.zza(2, 9, zzce.zzm));
            roomOpenHelper.onQueryPurchasesResponse(zzai.zzk());
        } else if (TextUtils.isEmpty(str)) {
            zzb.zzk("BillingClient", "Please provide a valid product type.");
            billingClientImpl.zzap(zzcb.zza(50, 9, zzce.zzg));
            roomOpenHelper.onQueryPurchasesResponse(zzai.zzk());
        } else if (billingClientImpl.zzao(new zzr(billingClientImpl, str, roomOpenHelper, 2), 30000L, new zza(billingClientImpl, roomOpenHelper, 13), billingClientImpl.zzaj()) == null) {
            billingClientImpl.zzap(zzcb.zza(25, 9, billingClientImpl.zzal()));
            roomOpenHelper.onQueryPurchasesResponse(zzai.zzk());
        }
    }

    public void restorePurchasedItems() {
    }

    public int retrieveManagedProducts(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        BillingClient billingClient = this.m_billingClient;
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(18);
        roomOpenHelper.mConfiguration = "inapp";
        roomOpenHelper.mDelegate = arrayList;
        billingClient.querySkuDetailsAsync(roomOpenHelper, new AccessTokenCache(this, 13));
        return 0;
    }

    public int retrieveSubscriptions(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        BillingClient billingClient = this.m_billingClient;
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(18);
        roomOpenHelper.mConfiguration = "subs";
        roomOpenHelper.mDelegate = arrayList;
        billingClient.querySkuDetailsAsync(roomOpenHelper, new Fragment.AnonymousClass7(this, 15));
        return 0;
    }

    public void updatePurchase(SkuDetails skuDetails, String str) {
        boolean z = (TextUtils.isEmpty(str) && TextUtils.isEmpty(null)) ? false : true;
        boolean zIsEmpty = TextUtils.isEmpty(null);
        if (z && !zIsEmpty) {
            throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
        }
        if (!z && zIsEmpty) {
            throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
        }
        BillingResult.Builder builder = new BillingResult.Builder();
        builder.zzb = str;
        builder.zza = 2;
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(17);
        AbsActionBarView$VisibilityAnimListener absActionBarView$VisibilityAnimListener = new AbsActionBarView$VisibilityAnimListener();
        absActionBarView$VisibilityAnimListener.mFinalVisibility = 0;
        absActionBarView$VisibilityAnimListener.mCanceled = true;
        roomOpenHelper.mDelegate = absActionBarView$VisibilityAnimListener;
        ArrayList arrayList = new ArrayList();
        arrayList.add(skuDetails);
        roomOpenHelper.mConfiguration = arrayList;
        AbsActionBarView$VisibilityAnimListener absActionBarView$VisibilityAnimListener2 = new AbsActionBarView$VisibilityAnimListener();
        absActionBarView$VisibilityAnimListener2.this$0 = builder.zzb;
        absActionBarView$VisibilityAnimListener2.mFinalVisibility = builder.zza;
        roomOpenHelper.mDelegate = absActionBarView$VisibilityAnimListener2;
        this.m_billingClient.launchBillingFlow(RunnerActivity.CurrentActivity, roomOpenHelper.build());
    }

    private int purchaseSku(String str, List<SkuDetails> list) {
        SkuDetails next;
        if (list == null) {
            Log.e(TAG, "Sku Details: no product data was retreived.");
            return 2;
        }
        Iterator<SkuDetails> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!next.getSku().equals(str));
        if (next != null) {
            RunnerActivity.CurrentActivity.runOnUiThread(new zza((Object) this, (Object) next, 17, false));
            return 0;
        }
        Log.e(TAG, "Sku: " + str + RDFWIi.apYcRy);
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x00d6  */
    public boolean isFeatureSupported(String str) {
        byte b;
        BillingResult billingResult;
        BillingClientImpl billingClientImpl = (BillingClientImpl) this.m_billingClient;
        if (billingClientImpl.isReady()) {
            BillingResult billingResult2 = zzce.zza;
            switch (str.hashCode()) {
                case -422092961:
                    if (!str.equals("subscriptionsUpdate")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 96321:
                    if (!str.equals("aaa")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 97314:
                    if (!str.equals("bbb")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 98307:
                    if (!str.equals("ccc")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 99300:
                    if (!str.equals("ddd")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 100293:
                    if (!str.equals(YcVWhnLsj.jHE)) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 101286:
                    if (!str.equals("fff")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 102279:
                    if (!str.equals("ggg")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 103272:
                    if (!str.equals("hhh")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 104265:
                    if (!str.equals("iii")) {
                        b = -1;
                    } else {
                        b = 11;
                    }
                    break;
                case 105258:
                    if (!str.equals("jjj")) {
                        b = -1;
                    } else {
                        b = 12;
                    }
                    break;
                case 106251:
                    if (!str.equals("kkk")) {
                        b = -1;
                    } else {
                        b = 13;
                    }
                    break;
                case 207616302:
                    if (!str.equals("priceChangeConfirmation")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 1987365622:
                    if (!str.equals("subscriptions")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    billingResult = billingClientImpl.zzi ? zzce.zzl : zzce.zzo;
                    billingClientImpl.zzau(9, 2, billingResult);
                    break;
                case 1:
                    billingResult = billingClientImpl.zzj ? zzce.zzl : zzce.zzp;
                    billingClientImpl.zzau(10, 3, billingResult);
                    break;
                case 2:
                    billingResult = billingClientImpl.zzm ? zzce.zzl : zzce.zzr;
                    billingClientImpl.zzau(35, 4, billingResult);
                    break;
                case 3:
                    billingResult = billingClientImpl.zzp ? zzce.zzl : zzce.zzw;
                    billingClientImpl.zzau(30, 5, billingResult);
                    break;
                case 4:
                    billingResult = billingClientImpl.zzr ? zzce.zzl : zzce.zzs;
                    billingClientImpl.zzau(31, 6, billingResult);
                    break;
                case 5:
                    billingResult = billingClientImpl.zzq ? zzce.zzl : zzce.zzu;
                    billingClientImpl.zzau(21, 7, billingResult);
                    break;
                case 6:
                    billingResult = billingClientImpl.zzs ? zzce.zzl : zzce.zzt;
                    billingClientImpl.zzau(19, 8, billingResult);
                    break;
                case 7:
                    billingResult = billingClientImpl.zzs ? zzce.zzl : zzce.zzt;
                    billingClientImpl.zzau(61, 9, billingResult);
                    break;
                case 8:
                    billingResult = billingClientImpl.zzt ? zzce.zzl : zzce.zzv;
                    billingClientImpl.zzau(20, 10, billingResult);
                    break;
                case 9:
                    billingResult = billingClientImpl.zzu ? zzce.zzl : zzce.zzA;
                    billingClientImpl.zzau(32, 11, billingResult);
                    break;
                case 10:
                    billingResult = billingClientImpl.zzu ? zzce.zzl : zzce.zzB;
                    billingClientImpl.zzau(33, 12, billingResult);
                    break;
                case 11:
                    billingResult = billingClientImpl.zzw ? zzce.zzl : zzce.zzD;
                    billingClientImpl.zzau(60, 13, billingResult);
                    break;
                case 12:
                    billingResult = billingClientImpl.zzx ? zzce.zzl : zzce.zzE;
                    billingClientImpl.zzau(66, 14, billingResult);
                    break;
                case 13:
                    billingResult = billingClientImpl.zzy ? zzce.zzl : zzce.zzy;
                    billingClientImpl.zzau(TossType.TOSS_OPEN_BALANCED_VALUE, 18, billingResult);
                    break;
                default:
                    zzb.zzk("BillingClient", "Unsupported feature: ".concat(str));
                    billingResult = zzce.zzz;
                    billingClientImpl.zzau(34, 1, billingResult);
                    break;
            }
        } else {
            billingResult = zzce.zzm;
            if (billingResult.zza != 0) {
                billingClientImpl.zzap(zzcb.zza(2, 5, billingResult));
            } else {
                billingClientImpl.zzaq(zzcb.zzc(5));
            }
        }
        if (billingResult.zza != 0) {
            Log.w(TAG, "feature: " + str + oKjScaD.iFskxRarmVEAlK + billingResult);
        }
        return billingResult.zza == 0;
    }
}
