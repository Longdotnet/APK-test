package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.webkit.WebViewCompat;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.TextStreamsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgz {
    private String zza = null;
    private zzhcs zzb = null;
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    public final zzhcs zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjl)).booleanValue() && !this.zzc.getAndSet(true) && TextStreamsKt.isFeatureSupported("GET_VARIATIONS_HEADER")) {
            try {
                String variationsHeader = WebViewCompat.getVariationsHeader();
                if (variationsHeader.isEmpty()) {
                    return;
                }
                this.zza = variationsHeader;
                this.zzb = zzhcs.zzd(Base64.decode(variationsHeader, 0), zzgyr.zzb());
            } catch (zzgzw | IllegalArgumentException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(e, "ChromeVariations");
            }
        }
    }
}
