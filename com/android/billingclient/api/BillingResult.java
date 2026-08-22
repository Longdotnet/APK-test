package com.android.billingclient.api;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.play_billing.zzb;

/* JADX INFO: loaded from: classes.dex */
public final class BillingResult {
    public int zza;
    public String zzb;

    public final class Builder {
        public int zza;
        public String zzb;

        public BillingResult build() {
            BillingResult billingResult = new BillingResult();
            billingResult.zza = this.zza;
            billingResult.zzb = this.zzb;
            return billingResult;
        }
    }

    public static Builder newBuilder() {
        Builder builder = new Builder();
        builder.zzb = "";
        return builder;
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Response Code: ", zzb.zzh(this.zza), ", Debug Message: ", this.zzb);
    }
}
