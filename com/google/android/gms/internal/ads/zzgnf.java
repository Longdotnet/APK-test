package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnf {
    private HashMap zza = new HashMap();

    public final zzgnh zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzgnh zzgnhVar = new zzgnh(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzgnhVar;
    }
}
