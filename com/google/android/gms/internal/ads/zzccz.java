package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzccz implements zzbkf {
    private final zzdma zza;

    public zzccz(zzdma zzdmaVar) {
        this.zza = zzdmaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        String str = (String) map.get(oKjScaD.usowCVnrB);
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Action missing from video GMSG.");
            return;
        }
        if (str.equals("src")) {
            String str2 = (String) map.get("src");
            if (str2 == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("src missing from video GMSG.");
            } else {
                zzdma zzdmaVar = this.zza;
                Bundle bundle = new Bundle();
                bundle.putString("mediaUrl", str2);
                zzdmaVar.zza.zzc(bundle);
            }
        }
    }
}
