package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzami implements Comparable {
    public final int zza;
    public final zzamd zzb;

    public zzami(int i, zzamd zzamdVar) {
        this.zza = i;
        this.zzb = zzamdVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.zza, ((zzami) obj).zza);
    }
}
