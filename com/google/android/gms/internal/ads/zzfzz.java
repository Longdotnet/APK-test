package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
final class zzfzz extends zzgab implements Serializable {
    static final zzfzz zza = new zzfzz();

    private zzfzz() {
    }

    @Override // com.google.android.gms.internal.ads.zzgab, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }

    @Override // com.google.android.gms.internal.ads.zzgab
    public final zzgab zza() {
        return zzgaj.zza;
    }
}
