package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcly implements zzclg {
    private final zzfbz zza;

    public zzcly(zzfbz zzfbzVar) {
        this.zza = zzfbzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzclg
    public final void zza(Map map) {
        String str = (String) map.get("render_in_browser");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.zza.zzb(Boolean.parseBoolean(str));
        } catch (Exception e) {
            throw new IllegalStateException("Invalid render_in_browser state", e);
        }
    }
}
