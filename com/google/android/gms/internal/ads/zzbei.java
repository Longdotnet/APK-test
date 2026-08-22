package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import java.util.Objects;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
final class zzbei extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbej zzb;

    public zzbei(zzbej zzbejVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzbejVar);
        this.zzb = zzbejVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbej zzbejVar = this.zzb;
            zzbejVar.zzg.postMessage(zzbejVar.zzc(this.zza, str).toString());
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error creating PACT Error Response JSON: ", e);
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        String str = queryInfo.zza.symbol;
        try {
            zzbej zzbejVar = this.zzb;
            zzbejVar.zzg.postMessage(zzbejVar.zzd(this.zza, str).toString());
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error creating PACT Signal Response JSON: ", e);
        }
    }
}
