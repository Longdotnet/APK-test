package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfrf implements Closeable {
    public static zzfrr zza() {
        return new zzfrr();
    }

    public static zzfrr zzb(final int i, zzfrq zzfrqVar) {
        return new zzfrr(new zzfwh() { // from class: com.google.android.gms.internal.ads.zzfrd
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return Integer.valueOf(i);
            }
        }, new zzfwh() { // from class: com.google.android.gms.internal.ads.zzfre
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return zzfrf.zze();
            }
        }, zzfrqVar);
    }

    public static zzfrr zzc(zzfwh<Integer> zzfwhVar, zzfwh<Integer> zzfwhVar2, zzfrq zzfrqVar) {
        return new zzfrr(zzfwhVar, zzfwhVar2, zzfrqVar);
    }

    public static /* synthetic */ Integer zze() {
        return -1;
    }
}
