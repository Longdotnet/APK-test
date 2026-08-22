package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzfz;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzgd;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgk;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class zzcb {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        int i = zzcc.$r8$clinit;
    }

    public static zzga zza(int i, int i2, BillingResult billingResult) {
        try {
            zzfz zzfzVarZzy = zzga.zzy();
            zzgg zzggVarZzy = zzgk.zzy();
            zzggVarZzy.zzn(billingResult.zza);
            zzggVarZzy.zzm(billingResult.zzb);
            zzggVarZzy.zzo(i);
            zzfzVarZzy.zzl(zzggVarZzy);
            zzfzVarZzy.zzn(i2);
            return (zzga) zzfzVarZzy.zzf();
        } catch (Exception e) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }

    public static zzge zzc(int i) {
        try {
            zzgd zzgdVarZzy = zzge.zzy();
            zzgdVarZzy.zzm(i);
            return (zzge) zzgdVarZzy.zzf();
        } catch (Exception e) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }
}
