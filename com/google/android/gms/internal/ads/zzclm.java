package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzclm implements zzclg {
    private final zzdvi zza;

    public zzclm(zzdvi zzdviVar) {
        this.zza = zzdviVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    @Override // com.google.android.gms.internal.ads.zzclg
    public final void zza(Map map) {
        byte b;
        String str = (String) map.get("gesture");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 97520651) {
            if (iHashCode == 109399814 && str.equals("shake")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (str.equals("flick")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b == 0) {
            this.zza.zzm(zzdve.SHAKE);
        } else if (b != 1) {
            this.zza.zzm(zzdve.NONE);
        } else {
            this.zza.zzm(zzdve.FLICK);
        }
    }
}
