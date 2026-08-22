package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcd {
    public static final zzcd zza = new zzcd(0, 0, 1.0f);
    public final int zzb;
    public final int zzc;
    public final float zzd;

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(3, 36);
    }

    public zzcd(int i, int i2, float f) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcd) {
            zzcd zzcdVar = (zzcd) obj;
            if (this.zzb == zzcdVar.zzb && this.zzc == zzcdVar.zzc && this.zzd == zzcdVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb + 217;
        float f = this.zzd;
        return Float.floatToRawIntBits(f) + (((i * 31) + this.zzc) * 31);
    }
}
