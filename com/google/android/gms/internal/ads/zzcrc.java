package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcrc implements zzcrd {
    private final Map zza;

    public zzcrc(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcrd
    public final zzedm zza(int i, String str) {
        return (zzedm) this.zza.get(str);
    }
}
