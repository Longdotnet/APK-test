package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
final class zzaft implements zzafj {
    public final String zza;

    private zzaft(String str) {
        this.zza = str;
    }

    public static zzaft zzb(zzen zzenVar) {
        return new zzaft(zzenVar.zzB(zzenVar.zza(), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final int zza() {
        return 1852994675;
    }
}
