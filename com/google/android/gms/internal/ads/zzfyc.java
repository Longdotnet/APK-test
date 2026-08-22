package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class zzfyc extends zzfyf {
    public zzfyc() {
        super(null);
    }

    public static final zzfyf zzf(int i) {
        if (i < 0) {
            return zzfyf.zzb;
        }
        return i > 0 ? zzfyf.zzc : zzfyf.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    public final zzfyf zzb(int i, int i2) {
        return zzf(Integer.compare(i, i2));
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    public final zzfyf zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    public final zzfyf zzd(boolean z, boolean z2) {
        return zzf(Boolean.compare(z, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    public final zzfyf zze(boolean z, boolean z2) {
        return zzf(Boolean.compare(z2, z));
    }
}
