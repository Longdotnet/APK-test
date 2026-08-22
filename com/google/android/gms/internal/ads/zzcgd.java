package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcgd implements zzbkf {
    final /* synthetic */ zzcgf zza;

    public zzcgd(zzcgf zzcgfVar) {
        Objects.requireNonNull(zzcgfVar);
        this.zza = zzcgfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i = Integer.parseInt(str);
                zzcgf zzcgfVar = this.zza;
                synchronized (zzcgfVar) {
                    try {
                        if (zzcgfVar.zzI != i) {
                            zzcgfVar.zzI = i;
                            zzcgfVar.requestLayout();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Exception occurred while getting webview content height", e);
            }
        }
    }
}
