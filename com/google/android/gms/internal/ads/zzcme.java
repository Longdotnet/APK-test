package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcme implements zzclg {
    private final zzdvi zza;

    public zzcme(zzdvi zzdviVar) {
        this.zza = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzclg
    public final void zza(Map map) {
        String str = (String) map.get("test_mode_enabled");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zza.zzo(str.equals("true"));
    }
}
