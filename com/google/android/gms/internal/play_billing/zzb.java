package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.InAppMessageResult;
import com.android.billingclient.api.Purchase;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzb {
    public static final int zza = Runtime.getRuntime().availableProcessors();

    public static int zzb(Bundle bundle, String str) {
        if (bundle == null) {
            zzk(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzj(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        zzk(str, "Unexpected type for bundle response code: ".concat(obj.getClass().getName()));
        return 6;
    }

    public static Bundle zzc(boolean z, boolean z2, boolean z3, boolean z4, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (z && z3) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z2 && z4) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        return bundle;
    }

    public static Bundle zzd(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        return bundle;
    }

    public static BillingResult zze(Intent intent, String str) {
        if (intent != null) {
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.zza = zzb(intent.getExtras(), str);
            builderNewBuilder.zzb = zzg(intent.getExtras(), str);
            return builderNewBuilder.build();
        }
        zzk("BillingHelper", "Got null intent!");
        BillingResult.Builder builderNewBuilder2 = BillingResult.newBuilder();
        builderNewBuilder2.zza = 6;
        builderNewBuilder2.zzb = "An internal error occurred.";
        return builderNewBuilder2.build();
    }

    public static InAppMessageResult zzf(Bundle bundle, String str) {
        if (bundle == null) {
            return new InAppMessageResult();
        }
        zzm(bundle, "BillingClient");
        bundle.getString("IN_APP_MESSAGE_PURCHASE_TOKEN");
        return new InAppMessageResult();
    }

    public static String zzh(int i) {
        return zza.zza(i).toString();
    }

    public static List zzi(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            Purchase purchaseZzn = zzn(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (purchaseZzn == null) {
                zzj("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(purchaseZzn);
        } else {
            zzj("BillingHelper", "Found purchase list of " + stringArrayList.size() + " items");
            for (int i = 0; i < stringArrayList.size() && i < stringArrayList2.size(); i++) {
                Purchase purchaseZzn2 = zzn(stringArrayList.get(i), stringArrayList2.get(i));
                if (purchaseZzn2 != null) {
                    arrayList.add(purchaseZzn2);
                }
            }
        }
        return arrayList;
    }

    public static void zzj(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            if (str2.isEmpty()) {
                Log.v(str, str2);
                return;
            }
            int i = 40000;
            while (!str2.isEmpty() && i > 0) {
                int iMin = Math.min(str2.length(), Math.min(4000, i));
                Log.v(str, str2.substring(0, iMin));
                str2 = str2.substring(iMin);
                i -= iMin;
            }
        }
    }

    public static void zzk(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void zzl(String str, String str2, Throwable th) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    private static int zzm(Bundle bundle, String str) {
        if (bundle != null) {
            return bundle.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
        }
        zzk(str, JuorMn.NYdfwEw);
        return 0;
    }

    private static Purchase zzn(String str, String str2) {
        if (str == null || str2 == null) {
            zzj("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e) {
            zzk("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e.toString()));
            return null;
        }
    }

    public static int zza(Intent intent, String str) {
        String str2 = PZmDzEagKNdW.MDc;
        if (intent != null) {
            return zzm(intent.getExtras(), str2);
        }
        zzk(str2, "Got null intent!");
        return 0;
    }

    public static String zzg(Bundle bundle, String str) {
        String str2 = JrbhsraGtto.xnHrQvCA;
        if (bundle == null) {
            zzk(str, "Unexpected null bundle received!");
            return str2;
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zzj(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return str2;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        zzk(str, "Unexpected type for debug message: ".concat(obj.getClass().getName()));
        return str2;
    }
}
