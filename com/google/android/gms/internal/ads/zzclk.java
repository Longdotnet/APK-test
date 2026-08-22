package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzclk implements zzclg {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    public zzclk(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzclg
    public final void zza(Map map) {
        boolean z = Boolean.parseBoolean((String) map.get("content_vertical_opted_out"));
        com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) this.zza;
        zzjVar.zzR();
        synchronized (zzjVar.zza) {
            try {
                if (zzjVar.zzv == z) {
                    return;
                }
                zzjVar.zzv = z;
                SharedPreferences.Editor editor = zzjVar.zzg;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z);
                    zzjVar.zzg.apply();
                }
                zzjVar.zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
