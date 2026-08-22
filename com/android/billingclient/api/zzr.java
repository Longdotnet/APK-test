package com.android.billingclient.api;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SimpleSQLiteQuery;
import com.facebook.AccessTokenCache;
import com.facebook.ProfileCache;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.nonagon.signalgeneration.zzau;
import com.google.android.gms.ads.nonagon.signalgeneration.zzp;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.ads.zzavv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzfda;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzs;
import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import okhttp3.Headers;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzr implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ Object zzc;

    public /* synthetic */ zzr(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        int iZza;
        Headers.Builder builder;
        zzda zzdaVar;
        zzfda zzfdaVar;
        int i = 23;
        int i2 = 3;
        int i3 = 9;
        String strZzg = "";
        switch (this.$r8$classId) {
            case 0:
                BillingClientImpl billingClientImpl = (BillingClientImpl) this.zza;
                return billingClientImpl.zzg.zzf(3, billingClientImpl.zze.getPackageName(), (String) this.zzb, (String) this.zzc, null);
            case 1:
                BillingClientImpl billingClientImpl2 = (BillingClientImpl) this.zza;
                Joiner joiner = (Joiner) this.zzb;
                AccessTokenCache accessTokenCache = (AccessTokenCache) this.zzc;
                billingClientImpl2.getClass();
                String str = joiner.separator;
                try {
                    zzb.zzj("BillingClient", "Consuming purchase with token: " + str);
                    if (billingClientImpl2.zzn) {
                        zzs zzsVar = billingClientImpl2.zzg;
                        String packageName = billingClientImpl2.zze.getPackageName();
                        boolean z = billingClientImpl2.zzn;
                        String str2 = billingClientImpl2.zzb;
                        Bundle bundle = new Bundle();
                        if (z) {
                            bundle.putString("playBillingLibraryVersion", str2);
                        }
                        Bundle bundleZze = zzsVar.zze(9, packageName, str, bundle);
                        iZza = bundleZze.getInt("RESPONSE_CODE");
                        strZzg = zzb.zzg(bundleZze, "BillingClient");
                    } else {
                        iZza = billingClientImpl2.zzg.zza(3, billingClientImpl2.zze.getPackageName(), str);
                    }
                    BillingResult billingResultZza = zzce.zza(iZza, strZzg);
                    if (iZza == 0) {
                        zzb.zzj("BillingClient", "Successfully consumed purchase.");
                        accessTokenCache.onConsumeResponse(billingResultZza, str);
                    } else {
                        zzb.zzk("BillingClient", "Error consuming purchase with token. Response code: " + iZza);
                        billingClientImpl2.zzap(zzcb.zza(23, 4, billingResultZza));
                        accessTokenCache.onConsumeResponse(billingResultZza, str);
                    }
                } catch (Exception e) {
                    zzb.zzl("BillingClient", "Error consuming purchase!", e);
                    BillingResult billingResult = zzce.zzm;
                    billingClientImpl2.zzap(zzcb.zza(29, 4, billingResult));
                    accessTokenCache.onConsumeResponse(billingResult, str);
                }
                return null;
            case 2:
                BillingClientImpl billingClientImpl3 = (BillingClientImpl) this.zza;
                String str3 = (String) this.zzb;
                zzb.zzj("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str3)));
                ArrayList arrayList = new ArrayList();
                boolean z2 = billingClientImpl3.zzn;
                boolean z3 = billingClientImpl3.zzv;
                billingClientImpl3.zzz.getClass();
                billingClientImpl3.zzz.getClass();
                int i4 = 0;
                Bundle bundleZzc = zzb.zzc(z2, z3, true, false, billingClientImpl3.zzb);
                String string = null;
                while (true) {
                    try {
                        Bundle bundleZzj = billingClientImpl3.zzn ? billingClientImpl3.zzg.zzj(true != billingClientImpl3.zzv ? i3 : 19, billingClientImpl3.zze.getPackageName(), str3, string, bundleZzc) : billingClientImpl3.zzg.zzi(i2, billingClientImpl3.zze.getPackageName(), str3, string);
                        BillingResult billingResult2 = zzce.zzj;
                        if (bundleZzj == null) {
                            zzb.zzk("BillingClient", "getPurchase() got null owned items list");
                            zzdaVar = new zzda(billingResult2, 54);
                        } else {
                            int iZzb = zzb.zzb(bundleZzj, "BillingClient");
                            String strZzg2 = zzb.zzg(bundleZzj, "BillingClient");
                            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                            builderNewBuilder.zza = iZzb;
                            builderNewBuilder.zzb = strZzg2;
                            BillingResult billingResultBuild = builderNewBuilder.build();
                            if (iZzb != 0) {
                                zzb.zzk("BillingClient", "getPurchase() failed. Response code: " + iZzb);
                                zzdaVar = new zzda(billingResultBuild, i);
                            } else if (bundleZzj.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundleZzj.containsKey("INAPP_PURCHASE_DATA_LIST") && bundleZzj.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                                ArrayList<String> stringArrayList3 = bundleZzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                                if (stringArrayList == null) {
                                    zzb.zzk("BillingClient", "Bundle returned from getPurchase() contains null SKUs list.");
                                    zzdaVar = new zzda(billingResult2, 56);
                                } else if (stringArrayList2 == null) {
                                    zzb.zzk("BillingClient", "Bundle returned from getPurchase() contains null purchases list.");
                                    zzdaVar = new zzda(billingResult2, 57);
                                } else if (stringArrayList3 == null) {
                                    zzb.zzk("BillingClient", "Bundle returned from getPurchase() contains null signatures list.");
                                    zzdaVar = new zzda(billingResult2, 58);
                                } else {
                                    zzdaVar = new zzda(zzce.zzl, 1);
                                }
                            } else {
                                zzb.zzk("BillingClient", "Bundle returned from getPurchase() doesn't contain required fields.");
                                zzdaVar = new zzda(billingResult2, 55);
                            }
                        }
                        BillingResult billingResult3 = (BillingResult) zzdaVar.zza;
                        if (billingResult3 != zzce.zzl) {
                            billingClientImpl3.zzap(zzcb.zza(zzdaVar.zzb, i3, billingResult3));
                            builder = new Headers.Builder(billingResult3, null);
                        } else {
                            ArrayList<String> stringArrayList4 = bundleZzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                            ArrayList<String> stringArrayList5 = bundleZzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                            ArrayList<String> stringArrayList6 = bundleZzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                            int i5 = i4;
                            int i6 = i5;
                            while (i6 < stringArrayList5.size()) {
                                String str4 = stringArrayList5.get(i6);
                                String str5 = stringArrayList6.get(i6);
                                zzb.zzj("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList4.get(i6))));
                                try {
                                    Purchase purchase = new Purchase(str4, str5);
                                    if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                                        zzb.zzk("BillingClient", "BUG: empty/null token!");
                                        i5 = 1;
                                    }
                                    arrayList.add(purchase);
                                    i6++;
                                    i3 = 9;
                                } catch (JSONException e2) {
                                    zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e2);
                                    BillingResult billingResult4 = zzce.zzj;
                                    billingClientImpl3.zzap(zzcb.zza(51, 9, billingResult4));
                                    builder = new Headers.Builder(billingResult4, null);
                                }
                            }
                            int i7 = i3;
                            if (i5 != 0) {
                                billingClientImpl3.zzap(zzcb.zza(26, i7, zzce.zzj));
                            }
                            string = bundleZzj.getString("INAPP_CONTINUATION_TOKEN");
                            zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                            if (TextUtils.isEmpty(string)) {
                                builder = new Headers.Builder(zzce.zzl, arrayList);
                            } else {
                                i4 = i4;
                                i = 23;
                                i2 = 3;
                                i3 = 9;
                            }
                        }
                    } catch (Exception e3) {
                        BillingResult billingResult5 = zzce.zzm;
                        billingClientImpl3.zzap(zzcb.zza(52, 9, billingResult5));
                        zzb.zzl("BillingClient", "Got exception trying to get purchasesm try to reconnect", e3);
                        builder = new Headers.Builder(billingResult5, null);
                    }
                }
                ArrayList arrayList2 = builder.namesAndValues;
                if (arrayList2 != null) {
                    ((RoomOpenHelper) this.zzc).onQueryPurchasesResponse(arrayList2);
                    return null;
                }
                ((RoomOpenHelper) this.zzc).onQueryPurchasesResponse(zzai.zzk());
                return null;
            case 3:
                BillingClientImpl billingClientImpl4 = (BillingClientImpl) this.zza;
                SimpleSQLiteQuery simpleSQLiteQuery = (SimpleSQLiteQuery) this.zzb;
                ProfileCache profileCache = (ProfileCache) this.zzc;
                billingClientImpl4.getClass();
                try {
                    zzs zzsVar2 = billingClientImpl4.zzg;
                    String packageName2 = billingClientImpl4.zze.getPackageName();
                    String str6 = simpleSQLiteQuery.mQuery;
                    String str7 = billingClientImpl4.zzb;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("playBillingLibraryVersion", str7);
                    Bundle bundleZzd = zzsVar2.zzd(9, packageName2, str6, bundle2);
                    profileCache.onAcknowledgePurchaseResponse(zzce.zza(zzb.zzb(bundleZzd, "BillingClient"), zzb.zzg(bundleZzd, "BillingClient")));
                } catch (Exception e4) {
                    zzb.zzl("BillingClient", "Error acknowledge purchase!", e4);
                    BillingResult billingResult6 = zzce.zzm;
                    billingClientImpl4.zzap(zzcb.zza(28, 3, billingResult6));
                    profileCache.onAcknowledgePurchaseResponse(billingResult6);
                }
                return null;
            case 4:
                Uri uriZza = (Uri) this.zzb;
                try {
                    boolean zBooleanValue = ((Boolean) zzbd.zza.zzd.zzb(zzbde.zzmu)).booleanValue();
                    zzau zzauVar = (zzau) this.zza;
                    IObjectWrapper iObjectWrapper = (IObjectWrapper) this.zzc;
                    uriZza = (!zBooleanValue || (zzfdaVar = zzauVar.zzi) == null) ? zzauVar.zzh.zza(uriZza, zzauVar.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null) : zzfdaVar.zza(uriZza, zzauVar.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
                    break;
                } catch (zzavv e5) {
                    int i8 = zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzk("", e5);
                }
                if (uriZza.getQueryParameter("ms") != null) {
                    return uriZza;
                }
                throw new Exception("Failed to append spam signals to click url.");
            case 5:
                zzau zzauVar2 = (zzau) this.zza;
                zzavu zzavuVar = zzauVar2.zzh;
                strZzg = zzavuVar.zzc() != null ? zzavuVar.zzc().zzh(zzauVar2.zzg, (View) ObjectWrapper.unwrap((IObjectWrapper) this.zzc), null) : "";
                if (TextUtils.isEmpty(strZzg)) {
                    throw new Exception("Failed to get view signals.");
                }
                ArrayList arrayList3 = new ArrayList();
                for (Uri uri : (List) this.zzb) {
                    if (zzau.zzX(uri, zzauVar2.zzD, zzauVar2.zzE)) {
                        arrayList3.add(zzau.zzaa("ms", uri, strZzg));
                    } else {
                        String strValueOf = String.valueOf(uri);
                        int i9 = zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Not a Google URL: ".concat(strValueOf));
                        arrayList3.add(uri);
                    }
                }
                if (arrayList3.isEmpty()) {
                    throw new Exception("Empty impression URLs result.");
                }
                return arrayList3;
            default:
                QueryInfo.generate(((com.google.android.gms.ads.nonagon.signalgeneration.zzo) this.zza).zzc, (AdRequest) this.zzb, (zzp) this.zzc);
                return Boolean.TRUE;
        }
    }
}
