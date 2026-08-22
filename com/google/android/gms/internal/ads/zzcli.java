package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcli implements zzclg {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    public zzcli(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzclg
    public final void zza(Map map) {
        boolean z = Boolean.parseBoolean((String) map.get("content_url_opted_out"));
        com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) this.zza;
        zzjVar.zzR();
        synchronized (zzjVar.zza) {
            try {
                if (zzjVar.zzu == z) {
                    return;
                }
                zzjVar.zzu = z;
                SharedPreferences.Editor editor = zzjVar.zzg;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z);
                    zzjVar.zzg.apply();
                }
                zzjVar.zzS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
