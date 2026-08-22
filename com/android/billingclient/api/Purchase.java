package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Purchase {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc;

    public Purchase(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = new JSONObject(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.zza, purchase.zza) && TextUtils.equals(this.zzb, purchase.zzb);
    }

    public final String getPurchaseToken() {
        JSONObject jSONObject = this.zzc;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.zza));
    }
}
