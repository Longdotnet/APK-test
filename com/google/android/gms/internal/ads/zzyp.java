package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
abstract class zzyp {
    public final int zza;
    public final zzbm zzb;
    public final int zzc;
    public final zzz zzd;

    public zzyp(int i, zzbm zzbmVar, int i2) {
        this.zza = i;
        this.zzb = zzbmVar;
        this.zzc = i2;
        this.zzd = zzbmVar.zzb(i2);
    }

    public abstract int zzb();

    public abstract boolean zzc(zzyp zzypVar);
}
