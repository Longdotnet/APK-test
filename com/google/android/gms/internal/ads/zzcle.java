package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcle {
    private final Map zza;
    private final Map zzb;

    public zzcle(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfcn zzfcnVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        for (zzfcl zzfclVar : zzfcnVar.zzb.zzc) {
            Map map = this.zza;
            String str = zzfclVar.zza;
            if (!map.containsKey(str) || (jSONObject2 = zzfclVar.zzb) == null) {
                Map map2 = this.zzb;
                if (map2.containsKey(str) && (jSONObject = zzfclVar.zzb) != null) {
                    zzclg zzclgVar = (zzclg) map2.get(str);
                    HashMap map3 = new HashMap();
                    Iterator itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String str2 = (String) itKeys.next();
                        String strOptString = jSONObject.optString(str2);
                        if (strOptString != null) {
                            map3.put(str2, strOptString);
                        }
                    }
                    zzclgVar.zza(map3);
                }
            } else {
                ((zzclh) map.get(str)).zza(jSONObject2);
            }
        }
    }
}
