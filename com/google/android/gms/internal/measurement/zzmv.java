package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzmv extends zzmx {
    public zzmv(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzk(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzj(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.zzmy.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.zzmy.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.measurement.zzmy.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.measurement.zzmy.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzc(Object obj, long j, boolean z) {
        if (zzmy.zzb) {
            zzmy.zzi(obj, j, z);
        } else {
            zzmy.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzd(Object obj, long j, byte b) {
        if (zzmy.zzb) {
            zzmy.zzD(obj, j, b);
        } else {
            zzmy.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zze(Object obj, long j, double d) {
        zzo(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzf(Object obj, long j, float f) {
        zzn(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final boolean zzg(Object obj, long j) {
        return zzmy.zzb ? zzmy.zzt(obj, j) : zzmy.zzu(obj, j);
    }
}
