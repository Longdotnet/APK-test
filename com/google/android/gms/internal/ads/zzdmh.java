package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdmh {
    private final Executor zza;
    private final zzdmc zzb;
    private final zzdsd zzc;

    public zzdmh(Executor executor, zzdmc zzdmcVar, zzdsd zzdsdVar) {
        this.zza = executor;
        this.zzb = zzdmcVar;
        this.zzc = zzdsdVar;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture listenableFutureZzh;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("custom_assets");
        if (jSONArrayOptJSONArray == null) {
            return zzgdn.zzh(Collections.emptyList());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcx)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzc.zza(), zzdrr.NATIVE_ASSETS_LOADING_CUSTOM_START.zza());
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                listenableFutureZzh = zzgdn.zzh(null);
            } else {
                final String strOptString = jSONObjectOptJSONObject.optString("name");
                if (strOptString == null) {
                    listenableFutureZzh = zzgdn.zzh(null);
                } else {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    listenableFutureZzh = "string".equals(strOptString2) ? zzgdn.zzh(new zzdmg(strOptString, jSONObjectOptJSONObject.optString("string_value"))) : "image".equals(strOptString2) ? zzgdn.zzm(this.zzb.zze(jSONObjectOptJSONObject, "image_value", null), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdme
                        @Override // com.google.android.gms.internal.ads.zzfve
                        public final Object apply(Object obj) {
                            return new zzdmg(strOptString, (zzbgc) obj);
                        }
                    }, this.zza) : zzgdn.zzh(null);
                }
            }
            arrayList.add(listenableFutureZzh);
        }
        return zzgdn.zzm(zzgdn.zzd(arrayList), new zzfve() { // from class: com.google.android.gms.internal.ads.zzdmf
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzdmg zzdmgVar : (List) obj) {
                    if (zzdmgVar != null) {
                        arrayList2.add(zzdmgVar);
                    }
                }
                return arrayList2;
            }
        }, this.zza);
    }
}
