package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbiw implements zzbkf {
    private final zzbix zza;

    public zzbiw(zzbix zzbixVar) {
        this.zza = zzbixVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("name");
        if (str != null) {
            this.zza.zzb(str, (String) map.get("info"));
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("App event with no name parameter.");
        }
    }
}
