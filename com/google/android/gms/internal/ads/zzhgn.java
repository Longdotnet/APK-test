package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class zzhgn implements zzhgr {
    private final Map zza;

    public zzhgn(Map map) {
        this.zza = Collections.unmodifiableMap(map);
    }

    public final Map zza() {
        return this.zza;
    }
}
