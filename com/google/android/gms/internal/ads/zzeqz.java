package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeqz implements zzeuc {
    private final Context zza;
    private final zzgdy zzb;

    public zzeqz(Context context, zzgdy zzgdyVar) {
        this.zza = context;
        this.zzb = zzgdyVar;
    }

    public static zzeqx zzc(zzeqz zzeqzVar) {
        Bundle bundle;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        zzbcv zzbcvVar = zzbde.zzgo;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        String string = !((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() ? "" : zzeqzVar.zza.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
        String string2 = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzgq)).booleanValue() ? zzeqzVar.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "") : "";
        com.google.android.gms.ads.internal.util.zzs zzsVar2 = zzvVar.zzd;
        Context context = zzeqzVar.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzgp)).booleanValue()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (defaultSharedPreferences.contains(str)) {
                    bundle.putString(str, defaultSharedPreferences.getString(str, null));
                }
            }
        } else {
            bundle = null;
        }
        return new zzeqx(string, string2, bundle, null);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 18;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeqz.zzc(this.zza);
            }
        });
    }
}
