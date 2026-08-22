package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgab implements Comparator {
    public static zzgab zzb(Comparator comparator) {
        return new zzfyb(comparator);
    }

    public static zzgab zzc() {
        return zzfzz.zza;
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzgab zza() {
        return new zzgak(this);
    }

    public final zzgab zzd(zzfve zzfveVar) {
        return new zzfxm(zzfveVar, this);
    }
}
