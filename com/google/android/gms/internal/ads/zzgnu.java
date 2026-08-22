package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnu {
    private static final zzgnu zza = new zzgnu();
    private final Map zzb = new HashMap();

    public static zzgnu zzb() {
        return zza;
    }

    public final synchronized zzgfm zza(String str) {
        Map map;
        map = this.zzb;
        if (!map.containsKey("AES128_GCM")) {
            throw new GeneralSecurityException("Name AES128_GCM does not exist");
        }
        return (zzgfm) map.get("AES128_GCM");
    }

    public final synchronized void zzc(String str, zzgfm zzgfmVar) {
        try {
            Map map = this.zzb;
            if (!map.containsKey(str)) {
                map.put(str, zzgfmVar);
                return;
            }
            if (((zzgfm) map.get(str)).equals(zzgfmVar)) {
                return;
            }
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + String.valueOf(map.get(str)) + "), cannot insert " + String.valueOf(zzgfmVar));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzc((String) entry.getKey(), (zzgfm) entry.getValue());
        }
    }
}
