package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfyi {
    public static int zza(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    public static int zzb(Object obj) {
        return zza(obj == null ? 0 : obj.hashCode());
    }
}
