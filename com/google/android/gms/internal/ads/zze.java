package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zze {
    public static final zze zza = new zze(0, 0, 1, 1, 0, null);
    private zzc zzb;

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public /* synthetic */ zze(int i, int i2, int i3, int i4, int i5, zzd zzdVar) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zze.class != obj.getClass()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 486696559;
    }

    public final zzc zza() {
        if (this.zzb == null) {
            this.zzb = new zzc(this, null);
        }
        return this.zzb;
    }
}
