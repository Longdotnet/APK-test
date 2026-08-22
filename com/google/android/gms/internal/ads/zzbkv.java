package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import okhttp3.internal.concurrent.onZL.mnwSv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbkv implements zzbkf {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    public final ListenableFuture zzb(zzbnm zzbnmVar, String str, JSONObject jSONObject) {
        zzcak zzcakVar = new zzcak();
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        String string = UUID.randomUUID().toString();
        zzc(string, new zzbkt(this, zzcakVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", string);
            jSONObject2.put("args", jSONObject);
            zzbnmVar.zzp(str, jSONObject2);
        } catch (Exception e) {
            zzcakVar.zzd(e);
        }
        return zzcakVar;
    }

    public final void zzc(String str, zzbku zzbkuVar) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbkuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        String str = mnwSv.cIgwQ;
        String str2 = (String) map.get("id");
        String str3 = (String) map.get("fail");
        String str4 = (String) map.get("fail_reason");
        String str5 = (String) map.get("fail_stack");
        String str6 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        String strConcat = TextUtils.isEmpty(str5) ? "" : "\n".concat(String.valueOf(str5));
        synchronized (this.zza) {
            try {
                zzbku zzbkuVar = (zzbku) this.zzb.remove(str2);
                if (zzbkuVar == null) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj(str + str2);
                    return;
                }
                if (!TextUtils.isEmpty(str3)) {
                    zzbkuVar.zza(str4 + strConcat);
                    return;
                }
                if (str6 == null) {
                    zzbkuVar.zzb(null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                        com.google.android.gms.ads.internal.util.zze.zza("Result GMSG: " + jSONObject.toString(2));
                    }
                    zzbkuVar.zzb(jSONObject);
                } catch (JSONException e) {
                    zzbkuVar.zza(e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
