package com.google.android.gms.internal.ads;

import com.facebook.login.vu.dLDI;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbkz implements zzbkf {
    private final zzdvi zza;

    public zzbkz(zzdvi zzdviVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzdviVar, "The Inspector Manager must not be null");
        this.zza = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        if (map == null || !map.containsKey("extras")) {
            return;
        }
        String str = dLDI.mbHqOczQzjCIGN;
        long j = Long.MAX_VALUE;
        if (map.containsKey(str)) {
            try {
                j = Long.parseLong((String) map.get(str));
            } catch (NumberFormatException unused) {
            }
        }
        this.zza.zzi((String) map.get("extras"), j);
    }
}
