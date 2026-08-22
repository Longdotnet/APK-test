package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzehw implements zzedo {
    private final Map zza = new HashMap();
    private final zzdpz zzb;

    public zzehw(zzdpz zzdpzVar) {
        this.zzb = zzdpzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedo
    public final zzedp zza(String str, JSONObject jSONObject) {
        zzedp zzedpVar;
        synchronized (this) {
            try {
                Map map = this.zza;
                zzedpVar = (zzedp) map.get(str);
                if (zzedpVar == null) {
                    zzedpVar = new zzedp(this.zzb.zzc(str, jSONObject), new zzefe(), str);
                    map.put(str, zzedpVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzedpVar;
    }
}
