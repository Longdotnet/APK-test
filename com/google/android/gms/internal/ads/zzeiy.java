package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzeiy extends zzcoz {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeiy(zzeja zzejaVar, View view, zzcfg zzcfgVar, zzcqy zzcqyVar, zzfcb zzfcbVar) {
        super(view, null, zzcqyVar, zzfcbVar);
        Objects.requireNonNull(zzejaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcoz
    public final zzcxk zzd(Set set) {
        return new zzcxk(Collections.emptySet());
    }
}
