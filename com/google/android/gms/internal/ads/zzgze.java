package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgze implements zzgyv {
    final int zza;
    final zzhck zzb;
    final boolean zzc;
    final boolean zzd;

    public zzgze(zzgzm zzgzmVar, int i, zzhck zzhckVar, boolean z, boolean z2) {
        this.zza = i;
        this.zzb = zzhckVar;
        this.zzc = z;
        this.zzd = z2;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zzgze) obj).zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgyv
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgyv
    public final zzhck zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgyv
    public final zzhcl zzc() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgyv
    public final boolean zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgyv
    public final boolean zze() {
        return this.zzc;
    }
}
