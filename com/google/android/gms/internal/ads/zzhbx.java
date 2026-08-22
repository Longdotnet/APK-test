package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
abstract class zzhbx {
    private static volatile int zza = 100;

    public abstract Object zza(Object obj);

    public abstract Object zzb();

    public abstract Object zzc(Object obj);

    public abstract void zzd(Object obj, int i, int i2);

    public abstract void zze(Object obj, int i, long j);

    public abstract void zzf(Object obj, int i, Object obj2);

    public abstract void zzg(Object obj, int i, zzgxz zzgxzVar);

    public abstract void zzh(Object obj, int i, long j);

    public abstract void zzi(Object obj);

    public abstract void zzj(Object obj, Object obj2);

    public final boolean zzk(Object obj, zzhbf zzhbfVar, int i) throws zzgzw {
        int iZzd = zzhbfVar.zzd();
        int i2 = iZzd >>> 3;
        int i3 = iZzd & 7;
        if (i3 == 0) {
            zzh(obj, i2, zzhbfVar.zzl());
            return true;
        }
        if (i3 == 1) {
            zze(obj, i2, zzhbfVar.zzk());
            return true;
        }
        if (i3 == 2) {
            zzg(obj, i2, zzhbfVar.zzp());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw new zzgzw("Protocol message end-group tag did not match expected tag.");
            }
            if (i3 != 5) {
                throw new zzgzv("Protocol message tag had invalid wire type.");
            }
            zzd(obj, i2, zzhbfVar.zzf());
            return true;
        }
        Object objZzb = zzb();
        int i4 = i2 << 3;
        int i5 = i + 1;
        if (i5 >= zza) {
            throw new zzgzw("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzhbfVar.zzc() != Integer.MAX_VALUE && zzk(objZzb, zzhbfVar, i5)) {
        }
        if ((i4 | 4) != zzhbfVar.zzd()) {
            throw new zzgzw("Protocol message end-group tag did not match expected tag.");
        }
        zzf(obj, i2, zzc(objZzb));
        return true;
    }
}
