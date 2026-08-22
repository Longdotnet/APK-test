package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgom {
    private static final zzgxe zza = zzgxe.zzb(new byte[0]);
    private final Map zzb;

    public final Iterable zza(byte[] bArr) {
        Map map = this.zzb;
        List list = (List) map.get(zza);
        List list2 = bArr.length >= 5 ? (List) map.get(zzgxe.zzc(bArr, 0, 5)) : null;
        if (list == null && list2 == null) {
            return new ArrayList();
        }
        if (list == null) {
            return list2;
        }
        return list2 == null ? list : new zzgoi(this, list2, list);
    }
}
