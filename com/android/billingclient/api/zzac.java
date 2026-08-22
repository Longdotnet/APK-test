package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzs;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzkt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzac implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Serializable zzc;
    public final /* synthetic */ Object zzd;

    public /* synthetic */ zzac(BillingClientImpl billingClientImpl, String str, ArrayList arrayList, SkuDetailsResponseListener skuDetailsResponseListener) {
        this.$r8$classId = 0;
        this.zza = billingClientImpl;
        this.zzb = str;
        this.zzc = arrayList;
        this.zzd = skuDetailsResponseListener;
    }

    public /* synthetic */ zzac(zzgj zzgjVar, String str, String str2, String str3, int i) {
        this.$r8$classId = i;
        this.zzd = zzgjVar;
        this.zzb = str;
        this.zza = str2;
        this.zzc = str3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String strZzg;
        int iZzb;
        int i;
        Bundle bundleZzk;
        switch (this.$r8$classId) {
            case 0:
                BillingClientImpl billingClientImpl = (BillingClientImpl) this.zza;
                String str = this.zzb;
                ArrayList arrayList = (ArrayList) this.zzc;
                SkuDetailsResponseListener skuDetailsResponseListener = (SkuDetailsResponseListener) this.zzd;
                billingClientImpl.getClass();
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 < size) {
                        int i3 = i2 + 20;
                        ArrayList<String> arrayList3 = new ArrayList<>(arrayList.subList(i2, i3 > size ? size : i3));
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
                        bundle.putString("playBillingLibraryVersion", billingClientImpl.zzb);
                        try {
                            if (billingClientImpl.zzo) {
                                zzs zzsVar = billingClientImpl.zzg;
                                String packageName = billingClientImpl.zze.getPackageName();
                                int i4 = billingClientImpl.zzk;
                                billingClientImpl.zzz.getClass();
                                if (billingClientImpl.zzv) {
                                    billingClientImpl.zzz.getClass();
                                }
                                String str2 = billingClientImpl.zzb;
                                Bundle bundle2 = new Bundle();
                                if (i4 >= 9) {
                                    bundle2.putString("playBillingLibraryVersion", str2);
                                }
                                if (i4 >= 9) {
                                    bundle2.putBoolean("enablePendingPurchases", true);
                                }
                                i = 8;
                                try {
                                    bundleZzk = zzsVar.zzl(10, packageName, str, bundle, bundle2);
                                } catch (Exception e) {
                                    e = e;
                                    zzb.zzl("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", e);
                                    billingClientImpl.zzap(zzcb.zza(43, i, zzce.zzm));
                                    strZzg = "Service connection is disconnected.";
                                    iZzb = -1;
                                }
                            } else {
                                i = 8;
                                bundleZzk = billingClientImpl.zzg.zzk(3, billingClientImpl.zze.getPackageName(), str, bundle);
                            }
                            strZzg = "Item is unavailable for purchase.";
                            if (bundleZzk == null) {
                                zzb.zzk("BillingClient", "querySkuDetailsAsync got null sku details list");
                                billingClientImpl.zzap(zzcb.zza(44, i, zzce.zzC));
                            } else if (bundleZzk.containsKey("DETAILS_LIST")) {
                                ArrayList<String> stringArrayList = bundleZzk.getStringArrayList("DETAILS_LIST");
                                if (stringArrayList == null) {
                                    zzb.zzk("BillingClient", xPQrbOSWiEdU.gzoxQ);
                                    billingClientImpl.zzap(zzcb.zza(46, i, zzce.zzC));
                                } else {
                                    for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
                                        try {
                                            SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i5));
                                            zzb.zzj("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                                            arrayList2.add(skuDetails);
                                        } catch (JSONException e2) {
                                            zzb.zzl("BillingClient", "Got a JSON exception trying to decode SkuDetails.", e2);
                                            strZzg = "Error trying to decode SkuDetails.";
                                            billingClientImpl.zzap(zzcb.zza(47, i, zzce.zza(6, "Error trying to decode SkuDetails.")));
                                            iZzb = 6;
                                        }
                                    }
                                    i2 = i3;
                                }
                                arrayList2 = null;
                            } else {
                                iZzb = zzb.zzb(bundleZzk, "BillingClient");
                                strZzg = zzb.zzg(bundleZzk, "BillingClient");
                                if (iZzb != 0) {
                                    zzb.zzk("BillingClient", "getSkuDetails() failed. Response code: " + iZzb);
                                    billingClientImpl.zzap(zzcb.zza(23, i, zzce.zza(iZzb, strZzg)));
                                } else {
                                    zzb.zzk("BillingClient", ZRqOdXiy.JUW);
                                    billingClientImpl.zzap(zzcb.zza(45, i, zzce.zza(6, strZzg)));
                                    iZzb = 6;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            i = 8;
                        }
                        break;
                    } else {
                        strZzg = "";
                        iZzb = 0;
                    }
                    skuDetailsResponseListener.onSkuDetailsResponse(zzce.zza(iZzb, strZzg), arrayList2);
                    return null;
                }
                iZzb = 4;
                arrayList2 = null;
                skuDetailsResponseListener.onSkuDetailsResponse(zzce.zza(iZzb, strZzg), arrayList2);
                return null;
            case 1:
                zzgj zzgjVar = (zzgj) this.zzd;
                zzgjVar.zza.zzA$1();
                zzam zzamVar = zzgjVar.zza.zze;
                zzkt.zzal(zzamVar);
                return zzamVar.zzv(this.zzb, (String) this.zza, (String) this.zzc);
            case 2:
                zzgj zzgjVar2 = (zzgj) this.zzd;
                zzgjVar2.zza.zzA$1();
                zzam zzamVar2 = zzgjVar2.zza.zze;
                zzkt.zzal(zzamVar2);
                return zzamVar2.zzv(this.zzb, (String) this.zza, (String) this.zzc);
            case 3:
                zzgj zzgjVar3 = (zzgj) this.zzd;
                zzgjVar3.zza.zzA$1();
                zzam zzamVar3 = zzgjVar3.zza.zze;
                zzkt.zzal(zzamVar3);
                return zzamVar3.zzs(this.zzb, (String) this.zza, (String) this.zzc);
            default:
                zzgj zzgjVar4 = (zzgj) this.zzd;
                zzgjVar4.zza.zzA$1();
                zzam zzamVar4 = zzgjVar4.zza.zze;
                zzkt.zzal(zzamVar4);
                return zzamVar4.zzs(this.zzb, (String) this.zza, (String) this.zzc);
        }
    }
}
