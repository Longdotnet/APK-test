package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SkuDetails {
    public final String zza;
    public final JSONObject zzb;

    public SkuDetails(String str) {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString("productId"))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }
        if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.zza, ((SkuDetails) obj).zza);
        }
        return false;
    }

    public final String getSku() {
        return this.zzb.optString("productId");
    }

    public final String getType() {
        return this.zzb.optString("type");
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.zza));
    }
}
