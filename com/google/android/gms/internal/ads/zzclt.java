package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class zzclt implements zzclg {
    @Override // com.google.android.gms.internal.ads.zzclg
    public final void zza(Map map) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkQ)).booleanValue() || map.isEmpty()) {
            return;
        }
        String str = (String) map.get(YcVWhnLsj.iGqVVaN);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzE(Boolean.parseBoolean(str));
    }
}
