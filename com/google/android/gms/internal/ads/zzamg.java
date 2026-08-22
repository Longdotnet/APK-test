package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class zzamg {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzamf
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((zzamg) obj).zzb.zzb, ((zzamg) obj2).zzb.zzb);
        }
    };
    private final zzamh zzb;
    private final int zzc;

    public /* synthetic */ zzamg(zzamh zzamhVar, int i, zzamk zzamkVar) {
        this.zzb = zzamhVar;
        this.zzc = i;
    }
}
