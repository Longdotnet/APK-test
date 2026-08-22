package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzclw implements zzclg {
    private final Context zza;
    private final com.google.android.gms.ads.internal.util.zzg zzb = com.google.android.gms.ads.internal.zzv.zza.zzi.zzi();

    public zzclw(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzclg
    public final void zza(Map map) {
        String str;
        if (map.isEmpty() || (str = (String) map.get("gad_idless")) == null) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzb;
        boolean z = Boolean.parseBoolean(str);
        ((com.google.android.gms.ads.internal.util.zzj) zzgVar).zzD(z);
        if (z) {
            StringsKt__IndentKt.zzc(this.zza);
        }
    }
}
