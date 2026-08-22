package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzbey;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class CsiUrlBuilder {
    public final String zza = (String) zzbey.zza.zze();

    public final String generateUrl(Map map) {
        Uri.Builder builderBuildUpon = Uri.parse(this.zza).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }
}
