package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzbnb {
    public static void zza(zzbnc zzbncVar, String str, Map map) {
        try {
            zzbncVar.zze(str, com.google.android.gms.ads.internal.client.zzbb.zzb.zzc.zzo(map));
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzc(zzbnc zzbncVar, String str, String str2) {
        zzbncVar.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzbnc zzbncVar, String str, JSONObject jSONObject) {
        zzbncVar.zzb(str, jSONObject.toString());
    }

    public static void zzb(zzbnc zzbncVar, String str, JSONObject jSONObject) {
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("(window.AFMA_ReceiveMessage || function() {})('", str, iafHZUfOuHNwvy.EGm, jSONObject.toString(), ");");
        String string = sbM22m.toString();
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Dispatching AFMA event: ".concat(string));
        zzbncVar.zza(sbM22m.toString());
    }
}
