package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzfwr extends zzfxi implements zzfzb {
    public zzfwr(Map map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public /* bridge */ /* synthetic */ Collection zza() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final Collection zzb(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final Collection zzc(Object obj, Collection collection) {
        return zzh(obj, (List) collection, null);
    }
}
